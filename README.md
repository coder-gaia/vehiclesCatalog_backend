# Projeto Catálogo de Veículos

Bem-vindo ao projeto Catálogo de Veículos! Este repositório contém microsserviços para gerenciar veículos e usuários, juntamente com um servidor de configuração.

## Visão Geral dos Microsserviços

### Serviço de Veículos

O Serviço de Veículos gerencia dados e funcionalidades relacionadas a veículos.

### Serviço de Usuários

O Serviço de Usuários lida com dados de usuários e autenticação. (Atualmente não está funcional)

### Servidor de Configuração

O Servidor de Configuração centraliza o gerenciamento de configurações para os microsserviços.

## Configuração

### Configurações no `config/`

#### Arquivo `user-service.yml`
server:
  port: 8081
  wait-time-in-ms-when-sync-empty: 3000

spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/user_DB
      auto-index-creation: true

application-version: 1.0

#### Arquivo `vehicle-service.yml`
server:
  port: 8082
  wait-time-in-ms-when-sync-empty: 3000

spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: vehicle_DB
      auto-index-creation: true

application-version: 1.1


## Instruções de Configuração
Para configurar este projeto localmente, siga os passos abaixo:

## Clonar o Repositório:
git clone <repository_url>
cd VehicleCatalog

## Compilar e Executar Cada Microsserviço:

Serviço de Veículos:
cd VehicleService
mvn spring-boot:run

Serviço de Usuários:
cd UserService
mvn spring-boot:run

Serviço de Configuração:
cd ConfigServer
mvn spring-boot:run

## Acessar os Microsserviços:

Serviço de Veículos: http://localhost:8082/swagger-ui.html
Serviço de Usuários: http://localhost:8081/swagger-ui.html (Atualmente não está funcional)
Servidor de Configuração: http://localhost:8888

## Utilização das URLs no Postman
## Aqui estão as instruções para utilizar as URLs dos microsserviços UserController e VehicleController no Postman.

## UserController

## Listar Todos os Usuários
Método: GET
URL: http://localhost:8081/api/users/list
Descrição: Retorna todos os usuários cadastrados.

## Login de Usuário
Método: POST
URL: http://localhost:8081/api/users/login
Descrição: Autentica o usuário e retorna um token JWT.
Body: JSON com os dados de login do usuário
{
  "username": "usuario",
  "password": "senha"
}

## Criar Novo Usuário
Método: POST
URL: http://localhost:8081/api/users/create
Body: JSON com os dados do novo usuário
Descrição: Cria um novo usuário.
{
  "username": "novousuario",
  "password": "novasenha",
  "email": "novousuario@example.com"
}


## Deletar Usuário por Nome de Usuário
Método: DELETE
URL: http://localhost:8081/api/users/delete/{username}
Descrição: Deleta um usuário pelo nome de usuário especificado na URL.

## Logout de Usuário
Método: POST
URL: http://localhost:8081/api/users/logout
Descrição: Desloga o usuário atualmente autenticado.


## VehicleController

## Listar Todos os Veículos
Método: GET
URL: http://localhost:8082/api/vehicles
Descrição: Retorna todos os veículos cadastrados.

## Obter Veículo por ID
Método: GET
URL: http://localhost:8082/api/vehicles/{id}
Descrição: Retorna o veículo com o ID especificado na URL.

## Criar Novo Veículo
Método: POST
URL: http://localhost:8082/api/vehicles
Descrição: Cria um novo veículo.
Body: JSON com os dados do novo veículo
{
  "brand": "Marca",
  "model": "Modelo",
  "year": 2023
}

## Atualizar Veículo por ID
Método: PUT
URL: http://localhost:8082/api/vehicles/{id}
Descrição: Atualiza os dados do veículo com o ID especificado na URL.
Body: JSON com os novos dados do veículo:
{
  "brand": "Nova Marca",
  "model": "Novo Modelo",
  "year": 2024
}

## Deletar Veículo por ID
Método: DELETE
URL: http://localhost:8082/api/vehicles/{id}
Descrição: Deleta o veículo com o ID especificado na URL.


## Para utilizar essas URLs no Postman ##:

Substitua {username} e {id} pelos valores reais ao fazer as requisições.
Certifique-se de que os microsserviços UserService e VehicleService estão em execução nas portas 8081 e 8082, respectivamente.
Configure o Postman de acordo com os métodos e URLs mencionados acima para testar os endpoints.


## Contribuições
Contribuições são bem-vindas! Siga estes passos para contribuir:

Fork o repositório.
Crie um novo branch (git checkout -b feature/nova-feature).
Faça suas alterações.
Comite suas mudanças (git commit -am 'Adicionar nova feature').
Faça o push para o branch (git push origin feature/nova-feature).
Crie um novo Pull Request.

##### Licença
Este projeto está licenciado sob a Licença MIT.
