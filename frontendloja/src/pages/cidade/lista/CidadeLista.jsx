import React, { useEffect, useState } from "react";
import './CidadeLista.css';
import { useNavigate } from "react-router-dom";
import { CidadeService } from "../../../services/CidadeService";
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from "primereact/button";
import { ConfirmDialog } from 'primereact/confirmdialog';
import { Paginator } from "primereact/paginator";

const CidadeLista = () => {
	const navigate = useNavigate();
	const [cidades, setCidades] = useState([]);
	const cidadeService = new CidadeService();
	const [idExcluir, setIdExcluir] = useState(null);
	const [dialogExcluir, setDialogExcluir] = useState(false);
	const [first, setFirst] = useState(0);
	const [rows, setRows] = useState(10);

	useEffect(() => {
		buscarCidades();
	}, [rows, first]);

	const onPageChange = (event) => {
		setFirst(event.first);
		setRows(event.rows);
	}

	const buscarCidades = () => {
		const page = first / rows;
		cidadeService.listar(page, rows).then(data => {
			setCidades(data.data);
		})
	}

	const formulario = () => {
		navigate("/cidade-formulario");
	}

	const alterar = (rowData) => {
		navigate("/cidade-formulario", { state: { cidadeAlterar: rowData } })
	}

	const excluir = () => {
		cidadeService.excluir(idExcluir).then(data=>{
			buscarCidades();
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
			<h2>Lista de Cidades</h2>
			<button onClick={formulario}>Nova Cidade</button>
			<br /><br />
			<DataTable value={cidades.content} tableStyle={{ minWidth: '50rem' }}>
				<Column field="id" header="Id"></Column>
				<Column field="nome" header="Nome"></Column>
				<Column header="Opções" body={optionColumn}></Column>
			</DataTable>
			<Paginator first={first} rows={rows} totalRecords={cidades.totalElements} rowsPerPageOptions={[5, 10, 20, 30]} onPageChange={onPageChange} />
			<ConfirmDialog visible={dialogExcluir} onHide={() => setDialogExcluir(false)} message="Deseja excluir?"
				header="Confirmação" icon="pi pi-exclamation-triangle" accept={excluir} reject={() => setIdExcluir(null)} acceptLabel="Sim" rejectLabel="Não"/>


		</div>
	);
}

export default CidadeLista;