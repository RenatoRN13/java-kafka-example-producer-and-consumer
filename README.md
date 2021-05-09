# java-kafka-example-producer-and-consumer

Implementação de produtor e consumidor de mensagem com kafka, utilizando um objeto "Message" como valor de mensagem enviada e consumida.

Para rodar a aplicação, é preciso:

i) instalar o java e kafka;

ii) configurar as variáveis de ambiente do java e kafka;

iii) rodar os comandos para subir o kafka:
  - zookeeper-server-start.bat <path-zookeeper.properties>
  - kafka-server-start.bat <path-server.properties>
  
Além de produzir mensagens pela classe Producer, é possível gerar mensagens pelo terminal com seguinte código:
  - kafka-console-producer.bat --broker-list <server\-url:port> --topic <topic\-name>
