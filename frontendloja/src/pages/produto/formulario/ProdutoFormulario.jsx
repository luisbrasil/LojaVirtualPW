import React, { useEffect, useState } from "react";
import { useNavigate, useLocation, useParams } from 'react-router-dom';
import './ProdutoFormulario.css';
import { ProdutoService } from "../../../services/ProdutoService";

const ProdutoFormulario = (props) => {
	const navigate = useNavigate();
	const produtoNovo = { descricao: '', valor: 0, valorPromocional: 0 };
	const location = useLocation();
	const { produtoAlterar } = location.state || {};

	const [produto, setProduto] = useState(produtoNovo);
	const produtoService = new ProdutoService();

	useEffect(() => {
		if(produtoAlterar){
			setProduto(produtoAlterar);
		}else{
			setProduto(produtoNovo);
		}		
	}, []);

	const listaProdutos = () =>{
		navigate("/produtos")
	}

	const alterarValor = (event) => {
		setProduto({ ...produto, [event.target.name]: event.target.value });
	}

	const salvar = () => {
		if (produto.id) {
			produtoService.alterar(produto).then(data => {
				console.log(data);
				setProduto(produtoNovo);
			});
		} else {
			produtoService.inserir(produto).then(data => {
				console.log(data);
				setProduto(produtoNovo);
			});
		}
		listaProdutos();
	}

	return (
		<div className="container">
			<h2>Inserir ou Alterar um Produto</h2>
			<input placeholder="Descrição Curta" type="text" name="descricaoCurta" value={produto.descricaoCurta} onChange={alterarValor} /><br /><br />
			<input placeholder="Descrição Detalhada" type="text" name="descricaoDetalhada" value={produto.descricaoDetalhada} onChange={alterarValor} /><br /><br />
			<input placeholder="Valor de Custo" type="number" name="valorCusto" value={produto.valorCusto} onChange={alterarValor} /><br /><br />
			<input placeholder="Valor de Venda" type="number" name="valorVenda" value={produto.valorVenda} onChange={alterarValor} /><br /><br />
			<button onClick={salvar}>Salvar</button>
			<button onClick={listaProdutos}>Lista Produtos</button>
		</div>
	);
}

export default ProdutoFormulario;