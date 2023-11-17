import React, { createContext, useState } from 'react';
import './App.css';
import Menu from './components/menu/Menu';
import Home from './pages/home/Home';
import Rodape from './components/rodape/Rodape';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ProdutoLista from './pages/produto/lista/ProdutoLista';
import ProdutoFormulario from './pages/produto/formulario/ProdutoFormulario';
import PermissaoLista from './pages/permissao/lista/PermissaoLista';
import PermissaoFormulario from './pages/permissao/formulario/PermissaoFormulario';
import EstadoLista from './pages/estado/lista/EstadoLista';
import EstadoFormulario from './pages/estado/formulario/EstadoFormulario';
import MarcaFormulario from './pages/marca/formulario/MarcaFormulario';
import MarcaLista from './pages/marca/lista/MarcaLista';
import CategoriaLista from './pages/categoria/lista/CategoriaLista';
import CategoriaFormulario from './pages/categoria/formulario/CategoriaFormulario';
import CidadeLista from './pages/cidade/lista/CidadeLista';
import CidadeFormulario from './pages/cidade/formulario/CidadeFormulario';

export const TemaContexto = createContext();

function App() {
	const [dark, setDark] = useState(true);

	return (
		<div className="App">

			<TemaContexto.Provider value={{dark, setDark}}>
				<BrowserRouter>
					<Menu />
					<Routes>
						<Route exact path='/' Component={() => <Home />} />
						<Route path='/produtos' Component={ProdutoLista}/>
						<Route path='/produto-formulario' Component={ProdutoFormulario}/>
						<Route path='/estados' Component={EstadoLista}/>
						<Route path='/estado-formulario' Component={EstadoFormulario} />
						<Route path='/marcas' Component={MarcaLista}/>
						<Route path='/marca-formulario' Component={MarcaFormulario}/>
						<Route path='/permissoes' Component={PermissaoLista} />
						<Route path='/permissao-formulario' Component={PermissaoFormulario} />
						<Route path='/categorias' Component={CategoriaLista} />
						<Route path='/categoria-formulario' Component={CategoriaFormulario} />
						<Route path='/cidades' Component={CidadeLista} />
						<Route path='/cidade-formulario' Component={CidadeFormulario} />
					</Routes>
					<Rodape />
				</BrowserRouter>
			</TemaContexto.Provider>
		</div>
	);
}

export default App;
