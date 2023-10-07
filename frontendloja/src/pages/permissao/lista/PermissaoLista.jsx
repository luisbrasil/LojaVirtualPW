import React, { useEffect, useState } from "react";
import './PermissaoLista.css';
import { useNavigate } from "react-router-dom";
import { PermissaoService } from "../../../services/PermissaoService";
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from "primereact/button";
import { ConfirmDialog } from 'primereact/confirmdialog';
import { Paginator } from "primereact/paginator";

const PermissaoLista = () => {
	const navigate = useNavigate();
	const [permissaos, setPermissaos] = useState([]);
	const permissaoService = new PermissaoService();
	const [idExcluir, setIdExcluir] = useState(null);
	const [dialogExcluir, setDialogExcluir] = useState(false);
	const [first, setFirst] = useState(0);
	const [rows, setRows] = useState(10);

	useEffect(() => {
		buscarPermissaos();
	}, [rows, first]);

	const onPageChange = (event) => {
		setFirst(event.first);
		setRows(event.rows);
	}

	const buscarPermissaos = () => {
		const page = first / rows;
		permissaoService.listar(page, rows).then(data => {
			setPermissaos(data.data);
		})
	}

	const formulario = () => {
		navigate("/permissao-formulario");
	}

	const alterar = (rowData) => {
		navigate("/permissao-formulario", { state: { permissaoAlterar: rowData } })
	}

	const excluir = () => {
		permissaoService.excluir(idExcluir).then(data => {
			buscarPermissaos();
		});
	}

	const optionColumn = (rowData) => {
		return (
			<>
				<Button label="Alterar" severity="warning" onClick={() => alterar(rowData)} />

				<Button label="Excluir" severity="dander" onClick={() => { setIdExcluir(rowData.id); setDialogExcluir(true) }} />
			</>
		)
	}

	return (
		<div className="container">
			<h2>Lista de Permissões</h2>
			<button onClick={formulario}>Nova Permissão</button>
			<br /><br />
			<DataTable value={permissaos.content} tableStyle={{ minWidth: '50rem' }}>
				<Column field="id" header="Id"></Column>
				<Column field="nome" header="Nome"></Column>
				<Column header="Opções" body={optionColumn}></Column>
			</DataTable>
			<Paginator first={first} rows={rows} totalRecords={permissaos.totalElements} rowsPerPageOptions={[5, 10, 20, 30]} onPageChange={onPageChange} />
			<ConfirmDialog visible={dialogExcluir} onHide={() => setDialogExcluir(false)} message="Deseja excluir?"
				header="Confirmação" icon="pi pi-exclamation-triangle" accept={excluir} reject={() => setIdExcluir(null)} acceptLabel="Sim" rejectLabel="Não" />


		</div>
	);
}

export default PermissaoLista;