INSERT INTO `estado` (`id`, `nome`, `sigla`) VALUES (1, 'PARANÁ', 'PR');
INSERT INTO  `cidade` (`id`, `nome`, `estado_id`) VALUES (1,'PARANAVAÍ', 1);
INSERT INTO `pessoa` (`id`, `nome`, `cpf`,`email`,`senha`,`endereco`,`cep`, `cidade_id`) VALUES (1,"Felipe da Hora","748.578.010-78", "lipedahora2000@hotmail.com","123456","Rua Morumbi No Centro do Morumbi","87703500",1);
INSERT INTO `permissao` (`id`, `nome`) VALUES (1, "Administrador");
INSERT INTO `permissao_pessoa` (`id`,`id_permissao`, `id_pessoa`) VALUES (1,1,1);