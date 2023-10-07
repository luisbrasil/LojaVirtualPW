import React, { useEffect, useState } from "react";
import './CategoriaLista.css';
import { useNavigate } from "react-router-dom";
import { CategoriaService } from "../../../services/CategoriaService";
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from "primereact/button";
import { ConfirmDialog } from 'primereact/confirmdialog';
import { Paginator } from "primereact/paginator";

const CategoriaLista = () => {
	const navigate = useNavigate();
	const [categorias, setCategorias] = useState([]);
	const categoriaService = new CategoriaService();
	const [idExcluir, setIdExcluir] = useState(null);
	const [dialogExcluir, setDialogExcluir] = useState(false);
	const [first, setFirst] = useState(0);
	const [rows, setRows] = useState(10);

	useEffect(() => {
		buscarCategorias();
	}, [rows, first]);

	const onPageChange = (event) => {
		setFirst(event.first);
		setRows(event.rows);
	}

	const buscarCategorias = () => {
		const page = first / rows;
		categoriaService.listar(page, rows).then(data => {
			setCategorias(data.data);
		})
	}

	const formulario = () => {
		navigate("/categoria-formulario");
	}

	const alterar = (rowData) => {
		navigate("/categoria-formulario", { state: { categoriaAlterar: rowData } })
	}

	const excluir = () => {
		categoriaService.excluir(idExcluir).then(data => {
			buscarCategorias();
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
			<h2>Lista de Categorias</h2>
			<button onClick={formulario}>Novo Categoria</button>
			<br /><br />
			<DataTable value={categorias.content} tableStyle={{ minWidth: '50rem' }}>
				<Column field="id" header="Id"></Column>
				<Column field="nome" header="Nome"></Column>
				<Column header="Opções" body={optionColumn}></Column>
			</DataTable>
			<Paginator first={first} rows={rows} totalRecords={categorias.totalElements} rowsPerPageOptions={[5, 10, 20, 30]} onPageChange={onPageChange} />
			<ConfirmDialog visible={dialogExcluir} onHide={() => setDialogExcluir(false)} message="Deseja excluir?"
				header="Confirmação" icon="pi pi-exclamation-triangle" accept={excluir} reject={() => setIdExcluir(null)} acceptLabel="Sim" rejectLabel="Não" />


		</div>
	);
}

export default CategoriaLista;