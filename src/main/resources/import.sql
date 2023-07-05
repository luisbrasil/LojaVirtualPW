INSERT INTO `estado` (`nome`, `sigla`) VALUES ('PARANÁ', 'PR');
INSERT INTO `cidade` (`nome`, `id_estado`) VALUES ('PARANAVAÍ', 1);
INSERT INTO `pessoa` (`nome`, `cpf`,`email`,`senha`,`endereco`,`cep`, `id_cidade`) VALUES ('Felipe da Hora','748.578.010-78', 'lipedahora2000@hotmail.com','123456','Rua Morumbi No Centro do Morumbi','87703500',1);
INSERT INTO `permissao` (`nome`) VALUES ('Administrador');
INSERT INTO `permissao_pessoa` (`id_permissao`, `id_pessoa`) VALUES (1,1);