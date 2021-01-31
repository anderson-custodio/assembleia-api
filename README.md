# Serviço assembleia-api

Esta API é responsável por:

- Criar/Listar pautas de votação
- Receber requisição de início de votação e enviar para a sessao-api
- Receber os votos de uma pauta
- Publicar o resultado da votação em uma fila do RabbitMQ

## Iniciando ou apontando para um serviço do RabbitMQ  

Este serviço usa o RabbitMQ para publicar o resultado da votação.  
Você pode apontar para um serviço do RabbitMQ ajustando a configuração `spring.rabbitmq.addresses` em application.properties.  
Caso queira executar o rabbitmq via docker: `docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management`

## Executando a aplicação

Para iniciar a aplicação siga os seguintes passos:  

~~~~bash
./mvnw compile
./mvnw spring-boot:run
~~~~

## Sobre o banco de dados

Para facilitar o desenvolvimento foi utilizado o banco de dados H2.  
Se mantida a configuração default, o banco será armazenado em `~/data/assembleiadb`.  
O banco pode ser acessado pelo link `http://localhost:8080/h2-console` com usuário e senha `sa`.  

## Documentação da API Rest

A documentação da API foi gerada usando swagger, após iniciar a aplicação a mesma está disponível em `http://localhost:8080/swagger-ui.html`.

## Executar testes unitários

Os testes podem ser executados por meio do comando:

~~~~bash
./mvnw test
~~~~
