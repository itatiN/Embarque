## Boas praticas em relacao a branches
1. Nao podemos dar push direto para main nem para develop
2. Todo trabalho devera ser feito criando uma branch a partir da branch develop
3. Branches devem ser autoexplicativas
4. Excluir a nova branch apos fazer merge na branch develop

## Boas praticas em relacao a commits
1. Commits autoexplicativos
2. Pequenos commits a cada funcao feita
3. Se possivel colocar um prefixo seguido por : para explicar qual sua mudanca.
ex:   update: Mudando classe Y

## Comandos que podem ser necessarios:
1. cd \Embarque\BackEnd\Embarque - Usado para navegar ate a pasta onde esta o mvnw.cmd
2. mvnw clean package - Usado para testar o programa e criar o .jar
3. docker compose up  - Usado para subir os dockers, use na raiz do projeto
4. docker compose down - Usado para parar os containers, use na raiz do projeto

## Possiveis problemas: 
1. Esquecer de colocar as variaveis de ambiente JAVA_HOME
2. Nao rodar o cmd como adm para criar o .jar