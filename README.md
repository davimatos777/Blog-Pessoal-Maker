# Blog Pessoal

O **Blog Pessoal** é uma API RESTful desenvolvida com **Spring Boot 3.4**, estruturada com base na arquitetura **MVC** e nas melhores práticas de desenvolvimento backend. O projeto contempla autenticação com **JWT**, persistência de dados com **Spring Data JPA**, documentação com **Swagger**, e análise de qualidade de código com **SonarQube**.

Este repositório tem o objetivo de demonstrar habilidades técnicas com **Java**, **Spring Boot**, **segurança**, **testes automatizados**, e **documentação de APIs**.

---

## ✅ Funcionalidades

- 🔐 Cadastro e autenticação de usuários (com token JWT)
- 🧑‍💻 CRUD completo de Usuários
- 📝 CRUD de Postagens e Temas
- 🔗 Relacionamento entre Postagem e Tema / Usuário
- 🔐 Segurança com Spring Security e autenticação stateless
- 📚 Documentação interativa via Swagger UI
- 🧪 Testes com JUnit
- 📊 Análise de qualidade de código com SonarQube
- 🛢️ Banco de dados H2 em memória

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia       | Finalidade                          |
|------------------|--------------------------------------|
| Java 17          | Linguagem principal                  |
| Spring Boot      | Framework para desenvolvimento web   |
| Spring Data JPA  | Persistência de dados                |
| Spring Security  | Autenticação e autorização           |
| JWT (jjwt)       | Geração e validação de tokens        |
| H2 Database      | Banco de dados em memória            |
| Swagger (OpenAPI)| Documentação da API                  |
| SonarQube        | Análise de qualidade de código       |
| Maven            | Gerenciamento de dependências        |

---

## 📦 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/blogpessoal/blog/
│   │   ├── config/         -> Configurações (segurança, Swagger)
│   │   ├── controller/     -> Controladores REST
│   │   ├── dto/            -> Objetos de Transferência de Dados
│   │   ├── model/          -> Entidades JPA
│   │   ├── repository/     -> Interfaces de acesso a dados
│   │   ├── security/       -> Filtros e utilitários de segurança (JWT)
│   │   └── service/        -> Lógica de negócio
│   └── resources/
│       └── application.properties
```

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/blog-pessoal.git
cd blog-pessoal
```

2. Compile e execute com Maven:
```bash
./mvnw spring-boot:run
```

> O backend será iniciado em: `http://localhost:8080`

---

## 🔐 Autenticação com JWT

### 1. Cadastro de usuário:
```http
POST /api/usuarios
```

### 2. Login:
```http
POST /auth/login
```
**Body:**
```json
{
  "email": "usuario@email.com",
  "senha": "123456"
}
```

### 3. Token de acesso:

Será retornado um `token JWT`. Para acessar endpoints protegidos, envie o token no cabeçalho:

```
Authorization: Bearer seu_token_aqui
```

---

## 📚 Documentação da API (Swagger)

> Após iniciar a aplicação, acesse:

🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

A documentação contém todos os endpoints disponíveis para:

- Usuários
- Temas
- Postagens
- Autenticação

---

## 🛢️ Banco de Dados H2

O projeto utiliza um banco de dados em memória para facilitar testes e execução local.

### Console H2:
```
URL: jdbc:h2:mem:blogdb
Usuário: sa
Senha: (deixe em branco)
```

Acesse via navegador:

🔗 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 🧪 Testes Automatizados

Execute os testes com:

```bash
./mvnw test
```

---

## 📊 Análise com SonarQube

Se desejar realizar análise de qualidade:

1. Inicie o SonarQube localmente: `http://localhost:9000`
2. Gere um token de autenticação
3. Execute:

```bash
./mvnw clean verify sonar:sonar \
  -Dsonar.projectKey=blog-pessoal \
  -Dsonar.projectName='Blog Pessoal' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=SEU_TOKEN_AQUI
```
