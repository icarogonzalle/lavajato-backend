Lava Jato API - Projeto Acadêmico
Este projeto é uma API RESTful desenvolvida como parte de uma disciplina acadêmica de Backend. A aplicação é voltada para a gestão de um Lava Jato e permite o gerenciamento de clientes, funcionários, veículos e informações financeiras.

=====================================================================================================================================================================

Funcionalidades
Cliente: Cadastro, consulta, atualização e exclusão de clientes.
Funcionário: Cadastro, consulta, atualização e exclusão de funcionários.
Veículo: Cadastro, consulta e exclusão de veículos.

Tecnologias Utilizadas:
Spring Boot: Framework para desenvolvimento de APIs REST.
MySQL: Banco de dados.
JPA (Java Persistence API): Para mapeamento e manipulação das entidades no banco de dados.
Endpoints

=====================================================================================================================================================================

A API expõe os seguintes endpoints:

Cliente:
GET /clientes - Retorna todos os clientes cadastrados.
POST /clientes - Cria um novo cliente.
GET /clientes/{id} - Retorna os detalhes de um cliente pelo ID.
PUT /clientes/{id} - Atualiza as informações de um cliente.
DELETE /clientes/{id} - Exclui um cliente pelo ID.

Funcionario:
GET /funcionarios - Retorna todos os funcionários cadastrados.
POST /funcionarios - Cria um novo funcionário.
GET /funcionarios/{id} - Retorna os detalhes de um funcionário pelo ID.
PUT /funcionarios/{id} - Atualiza as informações de um funcionário.
DELETE /funcionarios/{id} - Exclui um funcionário pelo ID.

Veículo:
GET /veiculos - Retorna todos os veículos cadastrados.
POST /veiculos - Cria um novo veículo.
GET /veiculos/{id} - Retorna os detalhes de um veículo pelo ID.
DELETE /veiculos/{id} - Exclui um veículo pelo ID.
