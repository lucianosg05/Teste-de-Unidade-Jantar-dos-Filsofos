# Teste de Unidade Jantar dos Filosofos
Implementação de um teste de unidade em Java utilizando JUnit 5 para verificar a configuração inicial do problema do Jantar dos Filósofos. O objetivo é garantir que os objetos (filósofos e garfos) sejam criados corretamente após a inicialização do ambiente. O teste foi projetado para falhar propositalmente, conforme solicitado na atividade.

Como rodar

1. Compile:
  javac -cp "lib/junit-platform-console-standalone-1.10.0.jar" main/*.java test/*.java
   
2. Execute:
  java -jar lib/junit-platform-console-standalone-1.10.0.jar -cp "main;test" --scan-classpath
