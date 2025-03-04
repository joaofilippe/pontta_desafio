# Pontta Desafio

Este projeto é composto por duas partes: `ponta-backend` e `pontta-front`. A parte backend é uma aplicação Spring Boot, enquanto a parte frontend é uma aplicação Angular.

## Pré-requisitos

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Node.js](https://nodejs.org/en/download/)
- [Angular CLI](https://angular.io/cli)

## Configuração do Backend

### Passos para rodar o backend

1. Navegue até o diretório `ponta-backend`:
    ```sh
    cd ponta-backend
    ```

2. Instale as dependências e compile o projeto:
    ```sh
    ./mvnw clean install
    ```

3. Execute a aplicação:
    ```sh
    ./mvnw spring-boot:run
    ```

Você também pode utilizar a sua IDE preferida para rodar o projeto.

A aplicação backend estará disponível em http://localhost:8080

## Configuração do Frontend

### Passos para rodar o frontend

1. Navegue até o diretório [pontta-front]:
    ```sh
    cd pontta-front
    ```

2. Instale as dependências:
    ```sh
    npm install
    ```

3. Execute a aplicação:
    ```sh
    npm start
    ```


Você também pode utilizar a sua IDE preferida, ou o comando `ng serve`

A aplicação frontend estará disponível em http://localhost:4200.
