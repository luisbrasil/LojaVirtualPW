import React, { useEffect, useState } from "react";
import { useNavigate, useLocation, useParams } from 'react-router-dom';
import './PessoaFormulario.css';
import { PessoaService } from "../../../services/PessoaService";

const PessoaFormulario = (props) => {
	const navigate = useNavigate();
	const pessoaNova = { descricao: '', valor: 0, valorPromocional: 0 };
	const location = useLocation();
	const { pessoaAlterar } = location.state || {};

	const [pessoa, setPessoa] = useState(pessoaNova);
	const pessoaService = new PessoaService();

	useEffect(() => {
		if(pessoaAlterar){
			setPessoa(pessoaAlterar);
		}else{
			setPessoa(pessoaNova);
		}		
	}, []);

	const listaPessoas = () =>{
		navigate("/pessoas")
	}

	const alterarValor = (event) => {
		setPessoa({ ...pessoa, [event.target.name]: event.target.value });
	}

	const salvar = () => {
		if (pessoa.id) {
			pessoaService.alterar(pessoa).then(data => {
				console.log(data);
				setPessoa(pessoaNova);
			});
		} else {
			pessoaService.inserir(pessoa).then(data => {
				console.log(data);
				setPessoa(pessoaNova);
			});
		}
		listaPessoas();
	}

	return (
		<div className="container">
			<h2>Inserir ou Alterar uma Pessoa</h2>
			<input placeholder="Nome" type="text" name="nome" value={pessoa.descricaoCurta} onChange={alterarValor} /><br /><br />
			<input placeholder="CPF" type="text" name="cpf" value={pessoa.descricaoDetalhada} onChange={alterarValor} /><br /><br />
			<input placeholder="Email" type="number" name="email" value={pessoa.valorCusto} onChange={alterarValor} /><br /><br />
			<input placeholder="Senha" type="password" name="senha" value={pessoa.valorVenda} onChange={alterarValor} /><br /><br />
			<input placeholder="Endereço" type="text" name="endereco" value={pessoa.valorVenda} onChange={alterarValor} /><br /><br />
			<input placeholder="CEP" type="number" name="cep" value={pessoa.valorVenda} onChange={alterarValor} /><br /><br />
			<button onClick={salvar}>Salvar</button>
			<button onClick={listaPessoas}>Lista Pessoas</button>
		</div>
	);
}

export default PessoaFormulario;