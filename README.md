<h2>Desafio Polvo</h2>

Este é um projeto de gerenciamento de usuários e postagens utilizando Spring Boot com JPA (Java Persistence API). O sistema permite a criação, atualização, listagem e remoção de usuários e postagens.

<h4>Tecnologias Utilizadas</h4>

Spring Boot: Framework para construção da aplicação.
JPA (Jakarta Persistence API): Para mapeamento objeto-relacional.
Spring Data JPA: Para facilitar a manipulação dos dados no banco de dados.
Lombok: Para reduzir o código boilerplate.
H2 Database: Banco de dados em memória para testes (pode ser substituído por outro banco de dados de sua escolha).


<h4>Estrutura do Projeto</h4>

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

  

<h4> Pré-requisitos</h4>
JDK 17 ou superior
Maven
IDE (IntelliJ, Eclipse, etc.)


<h4>Endpoints</h4>

<h2>Usuários</h2>

<strong>GET /usuarios/buscar: Lista todos os usuários.
![ListUsuarios](https://github.com/user-attachments/assets/a6f36386-2aac-4ad7-b17c-af8b70c44c29)
<br>
<br>
<strong>POST /usuarios/adicionar: Cria um novo usuário.
![AddUsuarios](https://github.com/user-attachments/assets/985567b3-13eb-4fe4-a563-140f392f8884)
<br>
<br>
<strong>PUT /usuarios/atualizar/{id}: Atualiza um usuário existente.
![AttUsusarios](https://github.com/user-attachments/assets/9cc7d493-62ea-48ec-a229-1915e204fafd)
<br>
<br>
<strong>DELETE /usuarios/deletar/{id}: Deleta um usuário.
![DellUsuarios](https://github.com/user-attachments/assets/a9629820-1a1e-4270-a010-0e8322aab868)
<br>
<br>
<h2> Postagens </h2>

<strong> GET /posts/buscar: Lista todas as postagens.
![ListPost](https://github.com/user-attachments/assets/7da623dd-3df9-4694-9bc7-4f20ac29d408)
<br>
<br>
<strong> POST /posts/adicionar: Cria uma nova postagem.
![AddPost](https://github.com/user-attachments/assets/1c56f36a-6bd2-415f-8219-679cadb44db0)
<br>
<br>
<strong> PUT /posts/atualizar/{id}: Atualiza uma postagem existente.
![AttPost](https://github.com/user-attachments/assets/9b63fe12-7510-47e0-a02f-1edb372222e2)
<br>
<br>
<strong>DELETE /posts/deletar/{id}: Deleta uma postagem.

![DellPost](https://github.com/user-attachments/assets/18142ffe-2f59-4a76-9fd8-b30394b45d79)
<br>
<br>
<h4>Exceções</h4>
O sistema lança exceções personalizadas quando ocorrem erros, como ValidarExepction, para garantir que as falhas sejam informadas adequadamente ao usuário.


<h4>Link do repositorio do desafio:</h4>
https://github.com/devssa/no-pain-no-brain/tree/master/Polvo/Est%C3%A1gio%20Backend
