# Projeto Lavajato Acadêmico

Este é um projeto acadêmico desenvolvido para a disciplina de **Backend** utilizando **Spring Boot**. O sistema é uma API REST para o gerenciamento de um **Lava Jato**, com operações de CRUD (Create, Read, Update, Delete).

## Tecnologias Utilizadas

- **Spring Boot**: Framework Java para construção de aplicações backend.
- **MySQL Database**: Banco de dados em memória utilizado para armazenamento dos dados.
- **JPA (Java Persistence API)**: Utilizado para a interação com o banco de dados.
- **Spring Web**: Para criar os endpoints da API RESTful.
- **Spring Data JPA**: Facilita a implementação de repositórios para interagir com o banco de dados.

## Funcionalidades

### 1. **Cadastro de Clientes**
- O sistema permite o cadastro, visualização, atualização e exclusão de clientes.
- Cada cliente possui informações como nome, CPF e telefone.

### 2. **Cadastro de Funcionários**
- Possibilidade de registrar dados de funcionários, como nome, cargo e salário.

### 3. **Cadastro de Veículos**
- O sistema permite o cadastro de veículos de clientes, incluindo dados como modelo, cor e placa.

### 4. **Controle Financeiro**
- Registro de movimentações financeiras, incluindo entradas e saídas, permitindo o controle de receitas e despesas.


### Requisitos:
- **Java 11 ou superior**
- **Maven**


## Endpoints da API

- **POST /clientes**: Cadastro de um novo cliente.
- **GET /clientes**: Retorna todos os clientes cadastrados.
- **GET /clientes/{id}**: Retorna um cliente específico pelo ID.
- **PUT /clientes/{id}**: Atualiza os dados de um cliente.
- **DELETE /clientes/{id}**: Exclui um cliente.

(Continue com os endpoints para as outras entidades, como Funcionário, Veículo)



