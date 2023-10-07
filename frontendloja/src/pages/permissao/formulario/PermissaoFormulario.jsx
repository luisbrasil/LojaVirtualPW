import React, { useEffect, useState } from "react";
import { useNavigate, useLocation, useParams } from 'react-router-dom';
import './PermissaoFormulario.css';
import { PermissaoService } from "../../../services/PermissaoService";

const PermissaoFormulario = (props) => {
	const navigate = useNavigate();
	const permissaoNovo = { nome: '' };
	const location = useLocation();
	const { permissaoAlterar } = location.state || {};

	const [permissao, setPermissao] = useState(permissaoNovo);
	const permissaoService = new PermissaoService();

	useEffect(() => {
		if (permissaoAlterar) {
			setPermissao(permissaoAlterar);
		} else {
			setPermissao(permissaoNovo);
		}
	}, []);

	const listaPermissaos = () => {
		navigate("/permissoes")
	}

	const alterarValor = (event) => {
		setPermissao({ ...permissao, [event.target.name]: event.target.value });

	}
	const salvar = () => {
		if (permissao.id) {
			permissaoService.alterar(permissao).then(data => {
				console.log(data);
				setPermissao(permissaoNovo);
			});
		} else {
			permissaoService.inserir(permissao).then(data => {
				console.log(data);
				setPermissao(permissaoNovo);
			});
		}
		listaPermissaos();
	}

	return (
		<div className="container">
			<h2>Inserir ou Alterar uma Permissão</h2>
			<input placeholder="Nome" type="text" name="nome" value={permissao.nome} onChange={alterarValor} /><br /><br />
			<button onClick={salvar}>Salvar</button>
			<button onClick={listaPermissaos}>Lista de Permissões</button>
		</div>
	);
}

export default PermissaoFormulario;