# bombacombustivel - Backend API

Esta documentação fornece uma visão da API backend `bombacombustivel`, focando em seus recursos, endpoints e configurações.

## Sumário
1. [Visão Geral](#1-visão-geral)
2. [Tecnologias Principais](#2-tecnologias-principais)
3. [Entidades Principais](#3-entidades-principais)
    - [3.1. `TypeOfFuel`](#31-typeoffuel)
    - [3.2. `FuelPump`](#32-fuelpump)
    - [3.3. `FuelSupply`](#33-fuelsupply)
4. [Endpoints da API](#4-endpoints-da-api)
    - [4.1. Endpoints de Tipos de Combustível (`/fuel-type`)](#41-endpoints-de-tipos-de-combustível-fuel-type)
    - [4.2. Endpoints de Bombas de Combustível (`/fuel-pump`)](#42-endpoints-de-bombas-de-combustível-fuel-pump)
    - [4.3. Endpoints de Abastecimento (`/fuel-supply`)](#43-endpoints-de-abastecimento-fuel-supply)
5. [Configurações Essenciais (`application.properties`)](#5-configurações-essenciais-applicationproperties)
6. [Executando Localmente](#6-executando-localmente)

---

### 1. Visão Geral

A aplicação `bombacombustivel` é um serviço backend desenvolvido em Spring Boot, com o objetivo de gerenciar tipos de combustível, bombas de combustível e registros de abastecimentos. A API oferece endpoints para operações CRUD para essas entidades.

### 2. Tecnologias Principais

*   **Framework**: Spring Boot 3.x
*   **Linguagem**: Java 21
*   **Persistência**: Spring Data JPA
*   **Banco de Dados**: H2 Database (em memória para desenvolvimento, configurável para arquivo)
*   **Auxiliares**: Lombok
*   **Build Tool**: Maven

### 3. Entidades Principais

As principais entidades que compõem o sistema são:

#### 3.1. `TypeOfFuel`

Representa um tipo de combustível disponível na bomba.

*   **id**: `Integer` (Gerado automaticamente)
*   **name**: `String` (Nome do combustível, único, obrigatório)
*   **literPrice**: `BigDecimal` (Preço por litro, obrigatório)

#### 3.2. `FuelPump`

Representa uma bomba de combustível, associada a um tipo específico de combustível.

*   **id**: `Integer` (Gerado automaticamente)
*   **fuel**: `TypeOfFuel` (Associação Many-to-One com o tipo de combustível, obrigatório)

#### 3.3. `FuelSupply`

Representa um registro de abastecimento realizado por uma bomba.

*   **id**: `Integer` (Gerado automaticamente)
*   **timeStamp**: `LocalDateTime` (Timestamp do abastecimento, obrigatório)
*   **pump**: `Integer` (ID da bomba que realizou o abastecimento, obrigatório)
*   **typeOfFuel**: `String` (Nome do tipo de combustível abastecido, obrigatório)
*   **totalLiters**: `BigDecimal` (Quantidade total de litros abastecidos, obrigatório)
*   **literPrice**: `BigDecimal` (Preço por litro no momento do abastecimento, obrigatório)
*   **totalPayment**: `BigDecimal` (Valor total do pagamento calculado, obrigatório)

### 4. Endpoints da API

A API é organizada por recursos relacionados a tipos de combustível, bombas e abastecimentos.

#### 4.1. Endpoints de Tipos de Combustível (`/fuel-type`)

Base: `/fuel-type`

*   **`POST /fuel-type`**
    *   **Descrição**: Cria um novo tipo de combustível.
    *   **Método**: `POST`
    *   **Corpo da Requisição**: `TypeOfFuel` (JSON)
        ```json
        {
            "name": "Gasolina Comum",
            "literPrice": 5.89
        }
        ```
    *   **Resposta**: `200 OK` com o `TypeOfFuel` criado.

*   **`GET /fuel-type`**
    *   **Descrição**: Lista todos os tipos de combustível registrados.
    *   **Método**: `GET`
    *   **Resposta**: `200 OK` com uma lista de `TypeOfFuel`.

*   **`GET /fuel-type/{id}`**
    *   **Descrição**: Busca um tipo de combustível pelo ID.
    *   **Método**: `GET`
    *   **Parâmetros de Path**: `id` (Integer)
    *   **Resposta**: `200 OK` com o `TypeOfFuel` encontrado.

*   **`PUT /fuel-type`**
    *   **Descrição**: Atualiza um tipo de combustível existente.
    *   **Método**: `PUT`
    *   **Parâmetros de Query**: `id` (Integer)
    *   **Corpo da Requisição**: `TypeOfFuel` (JSON)
        ```json
        {
            "name": "Gasolina Aditivada",
            "literPrice": 6.15
        }
        ```
    *   **Resposta**: `200 OK` com o `TypeOfFuel` atualizado.

*   **`DELETE /fuel-type/{id}`**
    *   **Descrição**: Exclui um tipo de combustível pelo ID.
    *   **Método**: `DELETE`
    *   **Parâmetros de Path**: `id` (Integer)
    *   **Resposta**: `200 OK` com `true` se a exclusão for bem-sucedida.

#### 4.2. Endpoints de Bombas de Combustível (`/fuel-pump`)

Base: `/fuel-pump`

*   **`POST /fuel-pump`**
    *   **Descrição**: Cria uma nova bomba de combustível associando-a a um tipo de combustível existente.
    *   **Método**: `POST`
    *   **Corpo da Requisição**: `FuelPump` (JSON)
        ```json
        {
            "fuel": {
                "id": 1
            }
        }
        ```
    *   **Resposta**: `200 OK` com a `FuelPump` criada.

*   **`GET /fuel-pump`**
    *   **Descrição**: Lista todas as bombas de combustível.
    *   **Método**: `GET`
    *   **Resposta**: `200 OK` com uma lista de `FuelPump`.

*   **`GET /fuel-pump/{id}`**
    *   **Descrição**: Busca uma bomba de combustível pelo ID.
    *   **Método**: `GET`
    *   **Parâmetros de Path**: `id` (Integer)
    *   **Resposta**: `200 OK` com a `FuelPump` encontrada.

*   **`PUT /fuel-pump`**
    *   **Descrição**: Atualiza o tipo de combustível associado a uma bomba.
    *   **Método**: `PUT`
    *   **Parâmetros de Query**: `idPump` (Integer), `idTypeOfFuel` (Integer)
        ```http
        PUT /fuel-pump?idPump=1&idTypeOfFuel=2
        ```
    *   **Resposta**: `200 OK` com a `FuelPump` atualizada.

*   **`DELETE /fuel-pump/{id}`**
    *   **Descrição**: Exclui uma bomba de combustível pelo ID.
    *   **Método**: `DELETE`
    *   **Parâmetros de Path**: `id` (Integer)
    *   **Resposta**: `200 OK` com `true` se a exclusão for bem-sucedida.

#### 4.3. Endpoints de Abastecimento (`/fuel-supply`)

Base: `/fuel-supply`

*   **`POST /fuel-supply`**
    *   **Descrição**: Registra um novo abastecimento.
    *   **Método**: `POST`
    *   **Parâmetros de Query**: `idPump` (Integer), `totalLiters` (BigDecimal)
        ```http
        POST /fuel-supply?idPump=1&totalLiters=30.5
        ```
    *   **Resposta**: `200 OK` com o `FuelSupply` registrado.

*   **`GET /fuel-supply`**
    *   **Descrição**: Lista todos os registros de abastecimento.
    *   **Método**: `GET`
    *   **Resposta**: `200 OK` com uma lista de `FuelSupply`.

*   **`GET /fuel-supply/{id}`**
    *   **Descrição**: Busca um registro de abastecimento pelo ID.
    *   **Método**: `GET`
    *   **Parâmetros de Path**: `id` (Integer)
    *   **Resposta**: `200 OK` com o `FuelSupply` encontrado.

### 5. Configurações Essenciais `application.properties`

*   Nome da Aplicação:
    *   `spring.application.name`:`bombacombustivel`
*   Console H2 Database:
    *   `spring.h2.console.enabled=true`
    *   `spring.h2.console.path=/h2-console`
*   Configurações de Banco de Dados H2:
    *   `spring.datasource.driver-class-name=org.h2.Driver`
    *   `spring.datasource.url=jdbc:h2:file:/data/db/testdb` (Banco de dados persistido em arquivo)
    *   `spring.datasource.username=sa`
    *   `spring.datasource.password=` (sem senha)
*   JPA (atualização do banco de dados):
    *   `spring.jpa.hibernate.ddl-auto`:`update`

### 6. Executando Localmente

A aplicação utiliza Maven para construção e pode ser executada diretamente como uma aplicação Spring Boot.

*   Pré-requisitos:
    *   Java 21 instalado
    *   Maven instalado
*   Passos para Execução:
    *   Navegue até a raiz do projeto
    *   Execute a aplicação usando o comando Maven: mvn spring-boot:run
    *   A aplicação estará disponível em http://localhost:8080 (porta padrão do Spring Boot).
    *   O console do H2 Database estará acessível em `http://localhost:8080/h2-console`.
