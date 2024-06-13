# Embarque

Embarque é um sistema de gerenciamento de compra de viagens de onibus!
Atualmente estamos focando na parte do back-end do projeto mas pretendemos futuramente seguir com o projeto full-cycle.

## 🚀 Começando

Para ter um clone do projeto localmente recomendamos utilizar o seguinte comando no diretorio que desejar:

```
git clone https://github.com/itatiN/Embarque
```


### 📋 Pré-requisitos

* [OpenJDK 17](https://openjdk.org/projects/jdk/17/) - A linguagem usada
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [Docker](https://www.docker.com/products/docker-desktop/) - Plataforma de conteinerização

### 🔧 Instalação

O primeiro passo é ter a certeza de que o seu JDK esta configurado como variavel de ambiente, clique [aqui](https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26) caso precisar de ajuda.

Na sequencia temos de instalar o docker e possivelmente o [wsl](https://learn.microsoft.com/pt-br/windows/wsl/install) no windows

Pode acontecer de voce precisar habilitar a virtualização na sua placa, para isso recomendo pesquisar o modelo da BIOS no google.

Apos essa etapa de configuração, devemos primeiro rodar o banco de dados via docker:

```
cd DataBase
docker build -t mysql-db .
docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=teste -e MYSQL_DATABASE=embarque -p 3306:3306 -d mysql:latest
```

Depois disso devemos ir ate o diretorio do projeto spring boot e rodar o comando para criar o .jar(executavel do java):

```
cd \Embarque\BackEnd\Embarque
mvnw clean package
```

Se tudo der certo, na sua pasta target agora voce vai ter uma Snapshot do seu projeto!
Recomendo depois fechar a instancia do seu banco de dados do docker, voltar ao diretorio raiz e executar o comando:

```
docker compose up
```

Esse comando vai fazer com que tanto o seu banco de dados quanto o seu backend funcionem de forma conjunta e com melhor latencia de rede.

Se quiser parar de rodar o sistema basta digitar:

```
docker compose down
```

ERRO COMUM DE ACONTECER: as vezes o comando depends_on do docker-compose acaba nao sendo lido o que leva a aplicacao java carregar antes que o banco de dados,
caso isso acontecer, aconselho parar o .jar pelo docker visual e depois roda-lo novamente quando o banco de dados estiver 100% pronto.

## 🛠️ Construído com

* [OpenJDK 17](https://openjdk.org/projects/jdk/17/) - A linguagem usada
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [Docker](https://www.docker.com/products/docker-desktop/) - Plataforma de conteinerização
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework utilizado
* [Spring initializr](https://start.spring.io/) - Inicializador de projeto contendo codigo boiler plate e configurações inicais
* [Maven Repository](https://mvnrepository.com/) - Onde achei as dependencias usadas no codigo

## 📌 Versão

Beta 0.0.1

## ✒️ Autores

* **Itatiano Niquini** - [itatiN](https://github.com/itatiN)
* **Gabriel Simões** - [kyosho-dev](https://github.com/kyosho-dev)
* **Pedro Lucas** - [pedro-ors](https://github.com/pedro-ors)
* **Jadir** - [Jadir01](https://github.com/Jadir01)
* **Vitor Henrique** - [Vitor124](https://github.com/Vitur124)

## 🎁 Grato por

* Itatiano - Foi muito divertido quando encontramos presencialmente e pudemos nos divertir enquanto fazia o trabalho, fora o mojito que tava otimo 😎
* Vitor - Grato por ter encontrado com o grupo e termos nos divertido enquanto bebíamos durante o trabalho 😎
* Pedro - Obrigado pelos amendoins e pelo mojito! 😄
* Jadir - Gratidão pelos amigos,por Deus colocar pessoas que acrescentam na nossa vida! Obrigado pelos momentos de conhecimento, parceria , guloseimas e até mesmo aquele personagem doidão do YouTube.😄😄🤣
* Gabriel - Grato por ter encontrado um grupo que seja tão batata como eu no Worms! 🤣

---