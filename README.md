# Sistema de Empréstimo de Ferramentas - Back-end 🛠️

> Repositório para a parte do **back-end** do projeto da A3 de Sistemas Distribuídos.
> O front-end está em [SistemaEmprestimo-Front](https://github.com/turt0/SistemaEmprestimo-Front).

## A3 da UC de Sistemas Distribuídos, 2026

> O sistema está escrito em **Java 11** e usa um banco de dados **MySQL 8.3.0**.
> A comunicação entre front e back é feita via **SOAP**.

## Grupo

- Caio Candido Cunha, RA 1072413246 (turt0)

## Sobre o projeto

O sistema é um gerenciador de empréstimo de ferramentas distribuído, dividido em dois projetos implantados no mesmo Apache Tomcat 9:

- **Back-end (este repositório)**: expõe três serviços SOAP — `AmigoServico`, `FerramentaServico` e `EmprestimoServico` — que encapsulam o acesso ao banco MySQL via DAOs.
- **Front-end** ([SistemaEmprestimo-Front](https://github.com/turt0/SistemaEmprestimo-Front)): aaplicação web JSP/Servlet que serve as telas no navegador e consome os serviços SOAP.

Por ser distribuído, este front depende do back estar disponível para funcionar.

## Tecnologias

- Java 11
- Apache Tomcat 9.0.117
- MySQL 8.3.0

## Estrutura

```
src/main/java/
├── dao/
├── modelo/
└── servico/
src/main/webapp/WEB-INF/
├── web.xml
└── sun-jaxws.xml
```

## Levantamento de requisitos

### Requisitos funcionais

- **RF01**: O sistema deve permitir o cadastro de ferramentas com informações como nome, marca e custo de aquisição.
- **RF02**: O sistema deve permitir o cadastro de amigos com informações como nome e telefone.
- **RF03**: O usuário deve poder registrar empréstimos de uma ferramenta a um amigo, incluindo data de empréstimo e data de devolução prevista.
- **RF04**: O sistema deve permitir registrar a devolução dos empréstimos.
- **RF05**: O sistema deve gerar um relatório que exiba todas as ferramentas cadastradas e o custo total gasto.
- **RF06**: O sistema deve gerar um relatório com todos os empréstimos realizados, quem fez a maior quantidade de empréstimos, e quem ainda não devolveu.
- **RF07**: O sistema deve fornecer um relatório com os empréstimos ativos no momento.
- **RF08**: O sistema deve, a cada novo empréstimo a um amigo, informar se o amigo ainda não devolveu algo.

### Requisitos não-funcionais

- **RNF01**: O sistema deve rodar em ambiente local com Apache Tomcat 9.
- **RNF02**: O sistema deve ser escrito em Java 11.
- **RNF03**: A interface é web, acessível por navegador em `http://localhost:8080/SistemaEmprestimo-Front/`.
- **RNF04**: O sistema deve ser **distribuído**
- **RNF05**: Front-end e back-end devem se comunicar via SOAP (JAX-WS RPC).

### Regras de negócio

- **RN01**: Pode haver apenas um amigo para cada empréstimo.
- **RN02**: Múltiplas ferramentas podem ser emprestadas para um amigo (um empréstimo por ferramenta).
- **RN03**: A manipulação de Amigos, Ferramentas, e Empréstimos é responsabilidade do back-end.

## Configurações do banco de dados

- **Host**: `localhost:3306`
- **Database**: `db_ferramentas`
- **User**: `root`
- **Senha**: `1234`

Os parâmetros de conexão estão centralizados em `dao/BaseDAO.java`.

## Endpoints SOAP

Após o deploy, os WSDLs ficam disponíveis em:

- `http://localhost:8080/webservice_emprestimo_jaxws_soap_tomcat/AmigoServico?wsdl`
- `http://localhost:8080/webservice_emprestimo_jaxws_soap_tomcat/FerramentaServico?wsdl`
- `http://localhost:8080/webservice_emprestimo_jaxws_soap_tomcat/EmprestimoServico?wsdl`

## Como executar

1. Criar o banco e as tabelas no MySQL (script DDL no projeto).
2. Subir o Apache Tomcat 9 na porta 8080.
3. Buildar o projeto e fazer deploy no Tomcat.
4. Subir também o front-end seguindo as instruções do repositório [SistemaEmprestimo-Front](https://github.com/turt0/SistemaEmprestimo-Front).
