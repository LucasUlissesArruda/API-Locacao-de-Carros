# 🚗 API de Locação de Carros

> API REST completa para a gestão de uma empresa de locação de veículos, desenvolvida como projeto académico. A aplicação permite o controlo total sobre clientes, frota de carros, reservas, pagamentos e manutenções.

<p align="center">
  <img src="https://img.shields.io/badge/Java-21%2B-blue.svg" alt="Java 21+">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.2-brightgreen.svg" alt="Spring Boot 3.2.2">
  <img src="https://img.shields.io/badge/Maven-4.0.0-red.svg" alt="Maven">
  <img src="https://img.shields.io/badge/Licença-MIT-blue.svg" alt="Licença MIT">
</p>

---

## 📋 Sobre o Projeto

Este projeto consiste numa API RESTful construída com **Spring Boot**, que serve como backend para um sistema de locação de carros. Foram implementadas todas as operações de CRUD (Criar, Ler, Atualizar, Apagar) para as principais entidades do negócio, além de regras de negócio específicas para garantir a consistência e a integridade dos dados, como a verificação de disponibilidade de veículos e o controlo de datas para reservas.

---

## ✨ Funcionalidades Principais

* **Gestão de Clientes:** CRUD completo para os clientes da locadora.
* **Gestão da Frota:** CRUD completo para os carros, incluindo a capacidade de filtrar por disponibilidade.
* **Sistema de Reservas:** Permite criar, consultar, atualizar e cancelar reservas, com validação de datas e disponibilidade do veículo.
* **Controlo de Manutenções:** Registo e acompanhamento de manutenções, atualizando automaticamente a disponibilidade do carro.
* **Registo de Pagamentos:** Sistema para registar pagamentos associados a uma reserva, com cálculo automático do valor.
* **Documentação da API:** Geração automática da documentação com **SpringDoc (Swagger)** para facilitar os testes e a integração.

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias e padrões:

* **Linguagem:** [Java 21](https://www.oracle.com/java/)
* **Framework:** [Spring Boot 3.2.2](https://spring.io/projects/spring-boot)
* **Base de Dados:** [PostgreSQL](https://www.postgresql.org/)
* **Acesso a Dados:** [Spring Data JPA (Hibernate)](https://spring.io/projects/spring-data-jpa)
* **Gestor de Dependências:** [Maven](https://maven.apache.org/)
* **Mapeamento de Objetos:** [MapStruct](https://mapstruct.org/)
* **Redução de Código:** [Lombok](https://projectlombok.org/)
* **Documentação da API:** [SpringDoc (Swagger UI)](https://springdoc.org/)

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e executar a aplicação localmente.

### Pré-requisitos

* **Java Development Kit (JDK)** - Versão 21 ou superior.
* **Maven** - Versão 3.8 ou superior (pode usar o Maven Wrapper incluído).
* **PostgreSQL** - Uma instância ativa e a funcionar.
* Uma IDE de sua preferência (ex: IntelliJ IDEA, VS Code, Eclipse).

### Configuração

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/LucasUlissesArruda/API-Locacao-de-Carros.git](https://github.com/LucasUlissesArruda/API-Locacao-de-Carros.git)
    cd API-Locacao-de-Carros
    ```

2.  **Configure a Base de Dados:**
    * Crie uma base de dados no seu PostgreSQL (ex: `locadora_db`).
    * Abra o ficheiro `src/main/resources/application.properties`.
    * Altere as seguintes propriedades com as suas credenciais:
        ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/locadora_db
        spring.datasource.username=seu_usuario_postgres
        spring.datasource.password=sua_senha_postgres
        ```

3.  **Compile o projeto:**
    * Use o Maven Wrapper para compilar o projeto e descarregar as dependências.
    ```bash
    # No Windows
    .\mvnw.cmd clean install

    # No Linux ou macOS
    ./mvnw clean install
    ```

4.  **Execute a Aplicação:**
    ```bash
    java -jar target/demo-0.0.1-SNAPSHOT.jar
    ```

A API estará a ser executada em `http://localhost:8080`.

---

## 📖 Utilização e Documentação da API

Após iniciar a aplicação, a documentação completa da API, gerada pelo Swagger UI, estará disponível para consulta e testes.

🔗 **Aceda a:** [**http://localhost:8080/swagger-ui.html**](http://localhost:8080/swagger-ui.html)

Nesta página, poderá ver todos os endpoints disponíveis, os seus parâmetros, e executar pedidos diretamente pelo navegador.

### Exemplo: Criar um novo Cliente

* **Endpoint:** `POST /api/clientes`
* **Corpo do Pedido (JSON):**
    ```json
    {
      "nome": "João da Silva",
      "email": "joao.silva@exemplo.com",
      "telefone": "912345678",
      "endereco": "Rua das Flores, 123",
      "documento": "12345678901"
    }
    ```

* **Resposta de Sucesso (201 Created):**
    ```json
    {
      "success": true,
      "data": {
        "id": 1,
        "nome": "João da Silva",
        "email": "joao.silva@exemplo.com",
        "telefone": "912345678",
        "endereco": "Rua das Flores, 123",
        "documento": "12345678901"
      },
      "error": null
    }
    ```

---

## 🏗️ Estrutura do Projeto

O projeto segue uma arquitetura em camadas para garantir a separação de responsabilidades:

* `controller`: Camada responsável por expor os endpoints da API REST e lidar com os pedidos HTTP.
* `service`: Contém a lógica de negócio da aplicação.
* `repository`: Interfaces do Spring Data JPA para o acesso e manipulação dos dados na base de dados.
* `entities`: Classes que representam as tabelas da base de dados (modelos de domínio).
* `dto`: (Data Transfer Objects) Objetos para transferir dados entre as camadas, especialmente entre o controller e o cliente da API.
* `mapper`: Interfaces do MapStruct para a conversão automática entre Entidades e DTOs.
* `exception`: Gestor global de exceções para padronizar as respostas de erro da API.

---

## 👨‍💻 Autores

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/LucasUlissesArruda">
        <img src="https://avatars.githubusercontent.com/u/101250275?v=4" width="115px;" alt="Lucas Ulisses Arruda"/>
        <br />
        <sub><b>Lucas Ulisses Arruda</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/y0shzz">
        <img src="https://avatars.githubusercontent.com/u/101569062?v=4" width="115px;" alt="y0shzz"/>
        <br />
        <sub><b>y0shzz</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/cezarioth">
        <img src="https://avatars.githubusercontent.com/u/112615362?v=4" width="115px;" alt="cezarioth"/>
        <br />
        <sub><b>cezarioth</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Joao-miguell">
        <img src="https://avatars.githubusercontent.com/u/113111812?v=4" width="115px;" alt="Joao-miguell"/>
        <br />
        <sub><b>Joao-miguell</b></sub>
      </a>
    </td>
  </tr>
</table>


---

## 📜 Licença

Este projeto está sob a licença MIT.

