import React, { useEffect, useState } from "react";
import { useNavigate, useLocation, useParams } from 'react-router-dom';
import './CategoriaFormulario.css';
import { CategoriaService } from "../../../services/CategoriaService";

const CategoriaFormulario = (props) => {
	const navigate = useNavigate();
	const categoriaNova = { nome: '' };
	const location = useLocation();
	const { categoriaAlterar } = location.state || {};
	const [categoria, setCategoria] = useState(categoriaNova);
	const categoriaService = new CategoriaService();

	useEffect(() => {
		if (categoriaAlterar) {
			setCategoria(categoriaAlterar);
		} else {
			setCategoria(categoriaNova);
		}
	}, []);

	const listaCategorias = () => {
		navigate("/categorias")
	}

	const alterarValor = (event) => {
		setCategoria({ ...categoria, [event.target.name]: event.target.value });
	}

	const salvar = () => {
		if (categoria.id) {
			categoriaService.alterar(categoria).then(data => {
				console.log(data);
				setCategoria(categoriaNova);
			});
		} else {
			categoriaService.inserir(categoria).then(data => {
				console.log(data);
				setCategoria(categoriaNova);
			});
		}
		listaCategorias();
	}

	return (
		<div className="container">
			<h2>Inserir ou Alterar uma Categoria</h2>
			<input placeholder="Nome" type="text" name="nome" value={categoria.nome} onChange={alterarValor} /><br /><br />
			<button onClick={salvar}>Salvar</button>
			<button onClick={listaCategorias}>Lista de Categorias</button>
		</div>
	);
}

export default CategoriaFormulario;