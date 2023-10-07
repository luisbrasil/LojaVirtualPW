import React, { useEffect, useState } from "react";
import { useNavigate, useLocation, useParams } from 'react-router-dom';
import './MarcaFormulario.css';
import { MarcaService } from "../../../services/MarcaService";

const MarcaFormulario = (props) => {
	const navigate = useNavigate();
	const marcaNova = { nome: ''};
	const location = useLocation();
	const { marcaAlterar } = location.state || {};

	const [marca, setMarca] = useState(marcaNova);
	const marcaService = new MarcaService();

	useEffect(() => {
		if (marcaAlterar) {
			setMarca(marcaAlterar);
		} else {
			setMarca(marcaNova);
		}
	}, []);

	const listaMarcas = () => {
		navigate("/marcas")
	}

	const alterarValor = (event) => {
		setMarca({ ...marca, [event.target.name]: event.target.value });
	}

	const salvar = () => {
		if (marca.id) {
			marcaService.alterar(marca).then(data => {
				console.log(data);
				setMarca(marcaNova);
			});
		} else {
			marcaService.inserir(marca).then(data => {
				console.log(data);
				setMarca(marcaNova);
			});
		}
		listaMarcas();
	}

	return (
		<div className="container">
			<h2>Inserir ou Alterar uma Marca</h2>
			<input placeholder="Nome" type="text" name="nome" value={marca.nome} onChange={alterarValor} /><br /><br />
			<button onClick={salvar}>Salvar</button>
			<button onClick={listaMarcas}>Lista Marcas</button>
		</div>
	);
}

export default MarcaFormulario;