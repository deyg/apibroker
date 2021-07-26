# Comunicação assíncrona entre Microsserviços com RabbitMQ

A pasta application contem README com mais informações sobre APIBroker.

* Para clonar este projeto: 
* git clone -b BrokerAnalyserInRabbitMQConsumer https://github.com/deyg/apibroker.git

* docker/rabbitMQ: pasta que contem arquivo docker com imagem do RabbitMQ. executar arquivo com docker-compose up -d. Acesso ao painel do RabbitMQ em localhost://15678

* application: aplicação responsável por realizar um mashup de um broker. Produz dados para uma fila no RabbitMQ. executa na porta 8080

* app-analyser: aplicação responsável por calcular a categoria de um broker. Consome os dados de uma fila RabbitMQ. Configurado para executar na porta 8081.

* postman: possui chamadas as APIs para fins de teste.


![Alt text](/images/arquitetura.png)
