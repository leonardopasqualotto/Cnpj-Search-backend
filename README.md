<h1 align="center" style="font-weight: bold;">Cnpj Search - Backend 💻</h1>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)


<p align="center">

<a href="#overview">Overview</a> • 
 <a href="#arquitecture">Arquitecture</a> • 
 <a href="#tech">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> 

</p>

<h2 id="overview">🔎 Overview </h2>

RESTful API developed in **Java**  using **Spring Boot** framework and **PostgreSQL** . Serves as backend of  "CNPJ'S - search" application designed for searching companies registered in the Brazilian Federal Revenue.

API uses Spring Security with JWT for authentication and authorization control. 


The database is generated from a ETL process available in [this repository](https://github.com/leonardopasqualotto/Receita_Federal_do_Brasil_-_Dados_Publicos_CNPJ/blob/master/README.md).



<h2 id="arquitecture">📐 Arquitecture</h2>

The project follows the MVC (Model-View-Controller) architectural pattern, separating responsibilities into distinct layers to facilitate maintenance, scalability and code organization.

- Model (Entity): It's a "Database Mirror", responsible for representing entities and business logic. Models reflect database tables and are used to map data.

- Controller: This layer manages the HTTP requests arriving from the frontend and delegates the tasks to the appropriate services. It is also responsible for returning responses to the customer.

- Service: Contains the business logic of the application. Services act as intermediaries between the controller and the repository.

- Repository: Persistence layer that communicates directly with the database, using Spring Data JPA to manipulate entity data.

- DTO (Data Transfer Object): Used to Transfers data between system layers.

- Security: Reesponsible for configuring the security behavior of the application. Defines authentication and authorization rules, in addition to managing how requests are filtered and processed.

<h2 id="tech">💻 Technologies</h2>

- ♨️ Java 
- 🍃 Spring (Web, Security, Data JPA) 
- 🐘 PostgreSQL 
- 🪽 Flyway 

<h2 id="started">🚀 Getting started</h2>

Here you describe how to run your project locally

<h3>Prerequisites</h3>

1) Clone and run the ETL process from repository [Dados_Publicos_CNPJ](https://github.com/leonardopasqualotto/Receita_Federal_do_Brasil_-_Dados_Publicos_CNPJ/blob/master/README.md)


<h3>Starting</h3>

1) ```git clone https://github.com/leonardopasqualotto/Cnpj-Search-backend.git```

2) Edit your configuration file `.env` with your PostgreSQL Credentials. Example:

```yaml
spring.datasource.url = jdbc:postgresql://localhost:5432/Dados_RFB
spring.datasource.username=postgres
spring.datasource.password=your_password
```

3) Run `CnpjSearchApplication.java` ;
4) Wait until all 4 migrations are finished (it may take a while);
5) Clone and execute (frontend) or  test using API Client like ![Postman](https://img.shields.io/badge/-Postman-FF6C37?style=flat&logo=postman&logoColor=white) or ![Insomnia](https://img.shields.io/badge/Insomnia-4000BF?logo=insomnia&logoColor=white&style=for-the-badge)


<h2 id="routes">📍 API Endpoints</h2>

Here is the list of routes of the API, and what are their expected request bodies.
​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /cnpj/{cnpj}</kbd>     | retrieves cnpj info see [response details](#get-auth-detail)
| <kbd>POST /auth/login</kbd>     | authenticate user see [request details](#post_login-auth-detail)
<kbd>POST /auth/register</kbd>     | create and save new user see [request details](#post_register-auth-detail)


<h3 id="get-auth-detail">GET /cnpj/{cnpj}</h3>

**REQUEST**

<h4>Header</h4>
<h5>Authorization: Bearer</h5>

```json
 {
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdX"
  }
```



<h4>Body</h4>

```json 
"cnpj": 12345678000910
```

**RESPONSE**



```json
   {
    "e": {
        "cnpj": "12345678000910",
        "nome_fantasia": "Pasqualotto - Imóveis",
        "data_situacao_cadastral": "20110214",
        "nome_cidade_exterior": null,
        "data_inicio_atividade": "20110214",
        "tipo_logradouro": "AVENIDA",
        "logradouro": "BRIG FARIA LIMA",
        "numero": "3732",
        "complemento": "ANDAR 3AO7 8ALASUL 9 E 10",
        "bairro": "ITAIM BIBI",
        "cep": "04538132",
        "uf": "SP",
        "ddd_1": "11",
        "telefone_1": "30736800",
        "ddd_2": null,
        "telefone_2": null,
        "ddd_fax": "11",
        "fax": "30789333",
        "correio_eletronico": "TAXCOMPLIANCEBR@FB.COM",
        "situacao_especial": null,
        "data_situacao_especial": null,
        "cnae_fiscal_secundaria": "7319004,7020400",
        "identificador_matriz_filial": {
            "codigo": 1,
            "descricao": "Matriz"
        },
        "situacao_cadastral": {
            "codigo": 2,
            "descricao": "Ativa"
        },
        "municipio": {
            "codigo": 7107,
            "descricao": "SAO PAULO"
        },
        "cnae_fiscal_principal": {
            "codigo": "7312200",
            "descricao": "Agenciamento de espaços para publicidade, exceto em veículos de comunicação"
        },
        "pais": null,
        "motivo_situacao_cadastral": {
            "codigo": 0,
            "descricao": "SEM MOTIVO"
        },
        "empresa": {
            "cnpj_basico": "13347016",
            "natureza_juridica": {
                "codigo": "2062",
                "descricao": "Sociedade Empresária Limitada"
            },
            "porte_empresa": {
                "codigo": 5,
                "descricao": "Demais"
            },
            "qualificacao_responsavel": {
                "codigo": "5",
                "descricao": "Administrador"
            },
            "socios": [
                {
                    "cnpj_basico": "13347016",
                    "nome_socio_razao_social": "LEONARDO PASQUALOTTO",
                    "cpf_cnpj_socio": "***573998**",
                    "data_entrada_sociedade": "20181114",
                    "pais": null,
                    "representante_legal": "***000000**",
                    "nome_do_representante": null,
                    "qualificacao_representante_legal": {
                        "codigo": "0",
                        "descricao": "Não informada"
                    },
                    "identificador_socio": {
                        "codigo": 2,
                        "descricao": "Pessoa Física"
                    },
                    "qualificacao_socio": {
                        "codigo": "5",
                        "descricao": "Administrador"
                    },
                    "faixa_etaria": {
                        "codigo": 5,
                        "descricao": "41 a 50 anos"
                    }
                },
                {
                    "cnpj_basico": "13347016",
                    "nome_socio_razao_social": "FULANO DA SILVA",
                    "cpf_cnpj_socio": "***634408**",
                    "data_entrada_sociedade": "20181114",
                    "pais": null,
                    "representante_legal": "***000000**",
                    "nome_do_representante": null,
                    "qualificacao_representante_legal": {
                        "codigo": "0",
                        "descricao": "Não informada"
                    },
                    "identificador_socio": {
                        "codigo": 2,
                        "descricao": "Pessoa Física"
                    },
                    "qualificacao_socio": {
                        "codigo": "5",
                        "descricao": "Administrador"
                    },
                    "faixa_etaria": {
                        "codigo": 4,
                        "descricao": "31 a 40 anos"
                    }
                }
            ],
            "razao_social": "FACEBOOK SERVICOS ONLINE DO BRASIL LTDA.",
            "ente_federativo_responsavel": null,
            "capital_social": 3631639.0
        },
        "simples": null
    },
    "cnaes": [
        {
            "codigo": "7020400",
            "descricao": "Atividades de consultoria em gestão empresarial, exceto consultoria técnica específica"
        },
        {
            "codigo": "7319004",
            "descricao": "Consultoria em publicidade"
        }
    ]
}
```

<h3 id="post_login-auth-detail">POST /auth/login</h3>

**REQUEST**




```json
{
  "login": "leoPasqualotto",
  "password": "123456"
}
```

**RESPONSE**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6Imxlb0FkbWluIiwiZXhwIjoxNzI2MTU0MjkzfQ.5y32CbI5s19_LSA4IhUySFkU9sWi9WlSHeOYu_R54tg"
}
```

<h3 id="post_register-auth-detail">POST /auth/register</h3>

**REQUEST**
```json
{
  "login": "leoPasqualotto",
  "password": "123456",
  "role": "USER"
}
```

**RESPONSE**
```json
{
  "status": 200
}
```

<h2 id="routes">📃 Roles</h2>

The following roles are available:

```
USER -> Standard user role for logged-in users.
ADMIN -> Admin role for managing partners (registering new partners).
``` 
