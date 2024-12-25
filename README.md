# carro-backend
Exemplo de backend spring boot de um projeto restfull de gerenciamento de carros simples

## Projeto de controle de carros com Spring Boot Java usando docker para o servidor de banco de dados MYSQL e phpmyadmin para visualização das tabelas.

##Abaixo segue o link do arquivo do docker-compose.yml para você subir após ter instalado e configurado o docker em seu computador. O Arquivo pode ser colocado em qualquer lugar do seu computador e para você rodar deve executar o seguinte comando:

Arquivo docker-compose para usar no comando abaixo:

[https://github.com/bruno130187/minhasfinancas-backend/blob/master/src/docker-compose.yaml]

### `docker-compose -f c:\pasta-do-arquivo\docker-compose.yaml up`

##Assim que você executar o docker irá baixar a imagem do MySQL e irá subir um servior dele no seu docker na porta 3306

## E para o pgAdmin4 você irá acessar, após subir no docker conforme informado acima, colocando a seguinte url no seu navegador:

[http://localhost:8091/]

Para se conectar usando pgAdmin pela URL acima utilize o acesso que está no arquivo docker-compose.yaml acima (root como usuário e senha informados no serviço mysql do arquivo docker-compose.yml).

## Após abrir o projeto com o a sua IDEA de preferência (Eclipse, Intellij, Spring Tools, Netbeans) basta rodar a aplicação API que ficará disponível na porta http://localhost:8080 conforme o arquivo application.properties do projeto.

Link do Projeto Frontend:
[https://github.com/bruno130187/minhasfinancas-frontend]

Segue meu LinkedIn: [https://www.linkedin.com/in/bruno-araujo-oficial/]
