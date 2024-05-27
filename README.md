# Santander Dev Week 2023

Java RESTful API criada para a Santander Dev Week.

## Principais Tecnologias
 - **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
 - **Railway**: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## [Link do Figma](https://www.figma.com/file/0ZsjwjsYlYd3timxqMWlbj/SANTANDER---Projeto-Web%2FMobile?type=design&node-id=1421%3A432&mode=design&t=6dPQuerScEQH0zAn-1)

O Figma foi utilizado para a abstração do domínio desta API, sendo útil na análise e projeto da solução.

## Gerando Diagrama de classe com ChatGpt
Prompt usado:

Gere um diagrama de classes (usando a sintaxe Mermaid) tendo em vista o seguinte JSON que representa um usuário d eum banco. Mantenha uma estrutura simples e fiel ao modelo que vou passar. Além disso, mantenha o nome das classes em inglês.

Estrutura Json:

```json
{
  "id": 1,
  "name": "Name User",
  "account": {
    "id": 1,
    "number": "01.097954-4",
    "agency": "2030",
    "balance": 624.12,
    "limit": 1000
  },
  "card": {
    "id": 1,
    "number": "xxxx xxxx xxxx 1111",
    "limit": 2000
  },
  "features": [
    {
      "id": 1,
      "icon": "URL",
      "description": "Descrição da feature"
    }
  ],
  "news": [
    {
      "id": 1,
      "icon": "URL",
      "description": "Descrição da feature"
    }
  ]
}
```

## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    -String number
    -String agency
    -Number balance
    -Number limit
  }

  class Feature {
    -String icon
    -String description
  }

  class Card {
    -String number
    -Number limit
  }

  class News {
    -String icon
    -String description
  }

  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News
```

## IMPORTANTE

Este projeto foi construído com um viés totalmente educacional através da plataforma de cursos da DIO.

