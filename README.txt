PROJETO DE AUTENTICA��O DE DOCUMENTOS

login: rodrigo
senha: 123

TECNOLOGIAS
O projeto foi desenvolvido em Spring Boot com banco de dados MySQL.
N�o foi utilizado a integra��o com o Docker.
Spring Security com a Autentica��o via JPA.
Utilizei o Template do Materialize.

PROJETO
O projeto foi organizado nos pacotes:
controllers
data
models
repository (interface)
security

Os arquivos html foram aplicados nos diret�rios:
templates
templates/dossie
templates/usu

BASE DADOS INICIAL - MySQL
Na primeira execu��o da aplica��o, o mesmo ir� criar as tabelas iniciais.
As tabelas que dever�o ser alimentadas com os scripts abaixo:

Usuario
INSERT INTO autenticodb.usuariosm (login, nome, senha) VALUES ('rodrigo', 'Rodrigo Barros', '$2a$10$REHlkpAzIA5qa1Hnw./zLOvu1HoQqZpYgdZRzD5U.oeuaUYuxn8V2');


ROLE
INSERT INTO autenticodb.role (nome_role) VALUES ('ROLE_ADMIN');
INSERT INTO autenticodb.role (nome_role) VALUES ('ROLE_USER');

Usuarios Roles
INSERT INTO autenticodb.usuarios_roles (usuario_id, role_id) VALUES ('rodrigo', 'ROLE_ADM');

Os cadastros de Usu�rios, Dossie e Comprovantes est�o prontos.



Autor: Rodrigo Barros dos Santos
rodrigo.barros1981@hotmail.com
(81) 98884-4524










