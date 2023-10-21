import React from 'react';
import styles from './Home.module.css';
import ProdutoNotificacaoWebSocket from '../../components/produto-notificao/ProdutoNotificacaoWebSocket';

const Home = () => {
  return (
    <div className={styles.home}>
      <h1>Bem-vindo à Página Inicial da sua Loja Virtual</h1>
      <p>Conteúdo....</p>
    <div className={styles.card}>
    </div>
    <ProdutoNotificacaoWebSocket/>
    </div>
  );
};

export default Home;
