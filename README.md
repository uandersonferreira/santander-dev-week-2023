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

### Explicação do application-dev.yml

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:sdw2023
    username: sdw2023
    password:
  jpa:
    show-sql: true
    open-in-view: false
    hibernate:
      ddl-auto: create # validate | update | create | create-drop
    properties:
      hibernate:
        format_sql: true
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        trace: false
        web-allow-others: false
```
OBS.: Validar a sintaxe do yml caso tenha erro :)

### Explicação Detalhada:

- `spring.datasource`: Configurações relacionadas ao banco de dados.
    - `url`: A URL JDBC para o banco de dados H2 em memória.
    - `username`: Nome de usuário para acessar o banco de dados.
    - `password`: Senha para acessar o banco de dados (deixado em branco, ou seja, sem senha).

- `spring.jpa`: Configurações específicas para o JPA e o Hibernate.
    - `show-sql`: Quando `true`, as consultas SQL geradas serão exibidas no console.
    - `open-in-view`: Quando `false`, desabilita a prática de manter a sessão Hibernate aberta durante a renderização da view, o que pode prevenir problemas de gerenciamento de sessão em aplicações web.
    - `hibernate.ddl-auto`: Controla a estratégia de gerenciamento de schema do banco de dados:
        - `validate`: Apenas valida o schema existente.
        - `update`: Atualiza o schema, aplicando mudanças incrementais.
        - `create`: Cria o schema do zero a cada inicialização.
        - `create-drop`: Cria o schema ao iniciar e o remove ao finalizar.
    - `properties.hibernate.format_sql`: Quando `true`, formata as instruções SQL geradas para melhor legibilidade.

- `spring.h2.console`: Configurações para o console web do H2.
    - `enabled`: Quando `true`, habilita o console web do H2.
    - `path`: Define o caminho para acessar o console web do H2.
    - `settings.trace`: Quando `false`, desabilita o rastreamento detalhado (útil para depuração).
    - `settings.web-allow-others`: Quando `false`, restringe o acesso ao console web do H2 apenas para conexões locais.

### Definindo o profile de trabalho no intelliI IDEA
> Edit configuration(Run/Debug configuration) > Profile: 
> SPRING_PROFILES_ACTIVE=dev 
> | ou só dev (ultimate)