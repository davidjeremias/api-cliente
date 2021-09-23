# api-cliente
Serviço gerenciador de clientes

# Instruções para executar localmente a Api
1- Subir container de banco de dados postgres 10.0
  - Navegar até a pasta onde contém o docker-compose.yaml "api-cliente/bin/postgres/"
  - Executar o comando "docker-compose up -d"
  
2- Criar o banco de dados "cliente"

# Segurança da Api
1- A Api utiliza o tipo de seguraça basic do Spring Security sendo necessário o envio do Header Authorization com as credenciais encoded username: "builder" password: "builder"
em todas as requisições.

# Acessar a documentação da Api localmente(OpenAPI)
1- http://localhost:8080/api/swagger-ui.html

2- Acessar usandos as credenciais username: "builder" password: "builder"

# CI/CD
1- a aplicação contém um arquivo Jenkinsfile onde é feito o build e empacotamento dos arquivos e criação de imagem docker para o deploy nos ambientes
Obs.: Alterar o repositório para criação da imagem.

# Ambiente Cloud
1- Acessar a documentação da Api cloud(OpenAPI)
http://34.121.178.65/api/swagger-ui.html

2- Url base Cloud
http://34.121.178.65/api/
