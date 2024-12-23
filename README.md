  Desafio Polvo

Este é um projeto de gerenciamento de usuários e postagens utilizando Spring Boot com JPA (Java Persistence API). O sistema permite a criação, atualização, listagem e remoção de usuários e postagens.

  Tecnologias Utilizadas

Spring Boot: Framework para construção da aplicação.
JPA (Jakarta Persistence API): Para mapeamento objeto-relacional.
Spring Data JPA: Para facilitar a manipulação dos dados no banco de dados.
Lombok: Para reduzir o código boilerplate.
H2 Database: Banco de dados em memória para testes (pode ser substituído por outro banco de dados de sua escolha).


  Estrutura do Projeto

Pacote home.desafiopolvo.Usuario

Usuario: Entidade que representa um usuário do sistema, com campos para email, nome e cpf. A classe utiliza anotações do JPA para persistir dados no banco.

RepositoryUsuarios: Interface do repositório que estende JpaRepository, facilitando a comunicação com o banco de dados.

DadosUsuarios: Record que contém as informações necessárias para criar ou atualizar um usuário, como email, cpf e nome.

ServiceUsuarios: Classe de serviço responsável pelas operações CRUD relacionadas aos usuários, como adicionar, atualizar, deletar e listar usuários. Ela interage com o repositório e trata exceções específicas.

ValidarExepction: Classe personalizada para lançar exceções quando ocorrerem falhas específicas, como um usuário não encontrado.

Pacote home.desafiopolvo.Post

Post: Entidade que representa uma postagem feita por um usuário. A classe possui campos como titulo, conteudo, horapublica e autor.

DadosPost: Record que contém os dados de uma postagem, como titulo, conteudo, autor e dataPublicacao.

ServicePost: Classe de serviço responsável pelas operações CRUD relacionadas às postagens. Além disso, ela valida a existência do autor da postagem e realiza as modificações no banco de dados.

RepositoryPost: Interface do repositório para a entidade Post, que estende JpaRepository.

   Como Rodar o Projeto

Pré-requisitos
JDK 17 ou superior
Maven
IDE (IntelliJ, Eclipse, etc.)


Endpoints

Usuários
GET /usuarios: Lista todos os usuários.
POST /usuarios: Cria um novo usuário.
PUT /usuarios/{id}: Atualiza um usuário existente.
DELETE /usuarios/{id}: Deleta um usuário.
Postagens
GET /posts: Lista todas as postagens.
POST /posts: Cria uma nova postagem.
PUT /posts/{id}: Atualiza uma postagem existente.
DELETE /posts/{id}: Deleta uma postagem.

Exceções
O sistema lança exceções personalizadas quando ocorrem erros, como ValidarExepction, para garantir que as falhas sejam informadas adequadamente ao usuário.

Link do repositorio do desafio:
https://github.com/devssa/no-pain-no-brain/tree/master/Polvo/Est%C3%A1gio%20Backend
