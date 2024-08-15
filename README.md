# Spring Boot CRUD Application

## Descrição

Este é um projeto de demonstração usando Spring Boot para criar uma aplicação CRUD (Create, Read, Update, Delete) de usuários com autenticação OAuth2. A aplicação permite realizar operações de criação, leitura, atualização e exclusão de usuários e inclui autenticação via OAuth2 usando GitHub.

## Tecnologias Utilizadas

- **Spring Boot 3.3.2**: Framework para desenvolvimento de aplicações Java.
- **Spring Security 6.1**: Framework de segurança para autenticação e autorização.
- **Spring Data JPA**: Interface para integração com bancos de dados.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional.
- **GitHub OAuth2**: Provedor de autenticação para login.
- **Swagger/OpenAPI**: Documentação da API.

## Configuração do Ambiente

### Requisitos

- **Java 17** ou superior
- **Maven** para gerenciamento de dependências
- **MySQL** para o banco de dados

### Configuração do Banco de Dados

1. Certifique-se de ter o MySQL instalado e em execução.
2. Crie um banco de dados para a aplicação, por exemplo, `spring_crud_db`.

### Configuração do Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   
2. Atualize as configurações do banco de dados no arquivo src/main/resources/application.properties:

    ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/spring_crud_db
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update

3. Configure o OAuth2 no GitHub:
- Acesse GitHub Developer Settings e crie uma nova aplicação.
- Defina o callback URL para sua aplicação, por exemplo, http://localhost:8080/login/oauth2/code/github.
- Copie o Client ID e o Client Secret.

4. Adicione as credenciais do GitHub ao arquivo application.properties:
   
   ```bash
    spring.security.oauth2.client.registration.github.client-id=SEU_CLIENT_ID
    spring.security.oauth2.client.registration.github.client-secret=SEU_CLIENT_SECRET

###  Executar a Aplicação
Compile e execute o projeto:

    ```bash
    ./mvnw spring-boot:run

Acesse a aplicação em http://localhost:8080.

### Endpoints da API

POST /api/users: Cria um novo usuário.
GET /api/users/{id}: Obtém um usuário pelo ID.
PUT /api/users/{id}: Atualiza um usuário existente.
DELETE /api/users/{id}: Deleta um usuário pelo ID.
GET /api/users: Obtém todos os usuários.

### Autenticação

Login: O login é realizado através do GitHub OAuth2. Após o login, o usuário será redirecionado para /dashboard.
Logout: O logout pode ser feito acessando /logout, o que encerrará a sessão na aplicação.

### Documentação da API
A documentação da API está disponível através do Swagger/OpenAPI em http://localhost:8080/swagger-ui.html.
