# poc-microservico

 - Porta dos microserviços:
  - configure-service : 8060
  - discovery-service: 8070
  - gateway-service: 8080

 Obs.: Os demais micro serviços rodam em portas randomicas.

 - URL do swagger está concentrada no gateway, desta forma para entrar na interface de documentação acesse: http://localhost:8080/swagger-ui.html.
 - A comunicação entre os serviços se dá pelo cliente "feign" da stack spring cloud, pode ser substituido pelo webflux que é reativo.
 - O Serviço de configuração ppode ser substituido por outras tecnologias como: consul, file vault, etc...

