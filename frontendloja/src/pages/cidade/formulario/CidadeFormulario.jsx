import React, { useEffect, useState } from "react";
import { useNavigate, useLocation, useParams } from 'react-router-dom';
import './CidadeFormulario.css';
import { CidadeService } from "../../../services/CidadeService";

const CidadeFormulario = (props) => {
	const navigate = useNavigate();
	const cidadeNova = { nome: '', sigla: ''};
	const location = useLocation();
	const { cidadeAlterar } = location.state || {};

	const [cidade, setCidade] = useState(cidadeNova);
	const cidadeService = new CidadeService();

	useEffect(() => {
		if(cidadeAlterar){
			setCidade(cidadeAlterar);
		}else{
			setCidade(cidadeNova);
		}		
	}, []);

	const listaCidades = () =>{
		navigate("/cidades")
	}

	const alterarValor = (event) => {
		setCidade({ ...cidade, [event.target.name]: event.target.value });
	}

	const salvar = () => {
		if (cidade.id) {
			cidadeService.alterar(cidade).then(data => {
				console.log(data);
				setCidade(cidadeNova);
			});
		} else {
			cidadeService.inserir(cidade).then(data => {
				console.log(data);
				setCidade(cidadeNova);
			});
		}
		listaCidades();
	}

	return (
		<div className="container">
			<h2>Inserir ou Alterar um Cidade</h2>
			<input placeholder="Nome" type="text" name="nome" value={cidade.nome} onChange={alterarValor} /><br /><br />
			<button onClick={salvar}>Salvar</button>
			<button onClick={listaCidades}>Lista Cidades</button>
		</div>
	);
}

export default CidadeFormulario;