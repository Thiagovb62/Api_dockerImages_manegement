# Docker Management API

Este projeto é uma API Spring Boot para gerenciar containers e imagens Docker. Ele permite listar, filtrar, criar, iniciar, parar e deletar containers e imagens Docker.

## Requisitos

- Java 11 ou superior
- Maven
- Docker

## Configuração

1. Clone o repositório:
   ```sh
   git clone <URL_DO_REPOSITORIO>
   cd <NOME_DO_REPOSITORIO>
2. Execute o comando Maven para compilar o projeto:
   ```sh
   mvn clean install
3. Execute o comando Maven para rodar o projeto:
   ```sh
    mvn spring-boot:run
4.  Configure o caminho do socket Docker no arquivo application.properties:
    ```
    docker.socket.path=unix:///var/run/docker.sock
    
## Endpoints

### Containers
 
- **GET /containers/filter?all={true|false}**: Lista todos os containers Docker com true que estao parados e false que estao rodando.
- **POST /containers/{containerId}/start**: Inicia um container.
- **POST /containers/{containerId}/stop**: Para um container.
- **DELETE /containers/{containerId}**: Deleta um container.
- **POST /containers/create?image={imageName}**: Cria um container.

### Imagens

- **GET /image/list**: Lista todas as imagens Docker.
- **GET /images/filter/?imageName={imageName}**: filtrar uma imagem Docker.