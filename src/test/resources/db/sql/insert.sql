INSERT INTO PRODUTO (DESCRICAO) VALUES ('REVISTA CAPRICHO');
INSERT INTO PRODUTO (DESCRICAO) VALUES ('REVISTA VEJA');
INSERT INTO PRODUTO (DESCRICAO) VALUES ('REVISTA EXAME');
INSERT INTO PRODUTO (DESCRICAO) VALUES ('REVISTA PLACAR');
INSERT INTO PRODUTO (DESCRICAO) VALUES ('REVISTA SUPERINTERESSANTE');

INSERT INTO PESSOA (NOMPESSOA) VALUES ('CLIENTE 1');
INSERT INTO PESSOA (NOMPESSOA) VALUES ('CLIENTE 2');
INSERT INTO PESSOA (NOMPESSOA) VALUES ('CLIENTE 3');
INSERT INTO PESSOA (NOMPESSOA) VALUES ('CLIENTE 4');
INSERT INTO PESSOA (NOMPESSOA) VALUES ('CLIENTE 5');
INSERT INTO PESSOA (NOMPESSOA) VALUES ('CLIENTE 5');
INSERT INTO PESSOA (NOMPESSOA) VALUES ('CLIENTE 7');

INSERT INTO ASSINATURA (CODPESSOA, CODPRODUTO) VALUES (1, 1);
INSERT INTO ASSINATURA (CODPESSOA, CODPRODUTO) VALUES (2, 1);
INSERT INTO ASSINATURA (CODPESSOA, CODPRODUTO) VALUES (2, 2);
INSERT INTO ASSINATURA (CODPESSOA, CODPRODUTO) VALUES (3, 1);
INSERT INTO ASSINATURA (CODPESSOA, CODPRODUTO) VALUES (3, 5);

INSERT INTO ASSINATURAENDERECO (CODASSINATURA, TIPOENDERECO, NUMCEP) VALUES (1, 'ENTREGA', 11111111);
INSERT INTO ASSINATURAENDERECO (CODASSINATURA, TIPOENDERECO, NUMCEP) VALUES (1, 'COBRANCA', 11111111);
INSERT INTO ASSINATURAENDERECO (CODASSINATURA, TIPOENDERECO, NUMCEP) VALUES (2, 'ENTREGA', 22222222);
INSERT INTO ASSINATURAENDERECO (CODASSINATURA, TIPOENDERECO, NUMCEP) VALUES (2, 'COBRANCA', 22222222);
INSERT INTO ASSINATURAENDERECO (CODASSINATURA, TIPOENDERECO, NUMCEP) VALUES (3, 'ENTREGA', 33333333);
INSERT INTO ASSINATURAENDERECO (CODASSINATURA, TIPOENDERECO, NUMCEP) VALUES (3, 'COBRANCA', 33333333);

