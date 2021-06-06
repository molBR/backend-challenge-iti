# BACKEND CHALLENGE - ITI

O propósito deste repositório é a realização de um desafio de backend para o ITI 

https://github.com/itidigital/backend-challenge

Nele está contido uma API que recebe através de uma chamada REST a informação da senha e é retornado para o 
cliente se ela é válida de acordo com algumas definições citadas.

## Instalação

### Pré condições

- Java 11 Corretto (https://aws.amazon.com/pt/corretto/)
- Maven

### Execução
Para executar a aplicação localmente é necessário:

- Clonar o repositório: ``` git clone {endereço} ``` 
- Executar a instalação das dependências ```mvn install ``` (Todos os testes devem passar) 
- Executar a aplicação Spring Boot ``` mvn spring-boot:root ```

## Projeto
### Requisição
Endpoint: ```POST: localhost:8080/validate/password``` 

Body: 
```json
{ "password": "AbTp!f1oak" } 
```

Curl: 
```curl
 --location --request POST 'localhost:8080/validate/password' \
         --header 'Content-Type: application/json' \
         --data-raw '{
             "password": "AbTp!f1oak"
         }' 
```

### Resposta

Status code: ```200 OK```

Body: 
```json
{ "isPasswordValid": true } 
```

Status code 400 

Body: 
```json
{
    "list_of_errors": [
        "Should not have repeated char"
    ],
    "error_message": "Not a valid password"
}
```
### Composição

Este projeto pode ser separado em duas partes: 
o código responsável por criar uma aplicação 
REST, possibilitando receber requisições HTTP
e responder para o cliente de acordo com o conteúdo 
(grande parte do código) e a regra de negócio que resolve
o problema apresentado de validar uma senha (contido somente no arquivo: 
``` ValidatePasswordUseCase ```).

#### Validação da senha

A função que valida a senha trabalha com flags que indicam quais condições estão sendo cumpridas e quais estão 
violadas, as flags servem para retornar para o cliente quais condições não foram obedecidas. Para validar as regras,
é iterado sobre a string recebida e cada caractere é passado por uma validação das regras, de forma que garanta que todas
as regras estão de acordo. A solução foi escolhida dessa forma para garantir que a complexidade seja igual ao tamanho
da string, ou seja ```O(n)``` onde n é igual ao tamanho da string.

Foi pressuposto que o tamanho máximo da senha é de 256 caracteres, porém, analisando que os caracteres não se repetem, e podem ter
letras maiúsculas, minúsculas, caracteres especiais e dígitos. O maior tamanho que uma senha genuína possa ter é de: 74.
26 letras maísculas, 26 letras minúsculas, 10 dígitos e 12 caracteres especiais.

<b>Importante</b> notar que da forma que este arquivo está muito sensível à entropia, ou seja, caso seja adcionado novas o processo será custoso e cada nova regra tornará a manutenção do código mais moroso. Uma outra alternativa seria fazer o processo de <i>strategy</i> (https://refactoring.guru/pt-br/design-patterns/strategy). Tal concepção só foi feita após finalização do projeto e não houve tempo hábil para a implementação do mesmo. Todavia, é importante notar o débito técnico.


#### Aplicação REST

A aplicação REST segue a arquitetura Hexagonal, com uma camada de adapter no exterior, camada de ```service``` que conecta o ```controller```
com os ```use cases ``` (regras de negócio do desafio).

Como a solução é única e auto contida, não existe a necessidade de criar interface para as implementações, porém, caso fosse uma aplicação
a ser mantida e incrementada, a criação de interface para a comunicação entre as dependências é altamente recomendado.

Como a proposta é bastante simples, todas as entidades criadas são entidades que são utilizadas no domínio do controller. Não havendo
a necessidade de criar entidades de negócio, uma vez que é trafegado apenas uma string com a senha. As entidades são:

- <b>PasswordRequest</b> - Entidade do objeto JSON da requisição
- <b>PasswordResponse</b> - Entidade do objeto JSON de resposta para o cliente
- <b>ErrorResponse</b> - Entidade do objeto JSON de erro retornado para o cliente caso a senha não respeite as regras.

Por fim, foi escolhido fazer uma requisição `POST` e não `GET` por motivos de segurança, uma vez que por mais que possa assegurar uma requsição segura HTTPS, não é o ideal deixá-la na rota. Para garantir a senha dentro do body da requisição, foi mantida a escolha de utilizar um `POST`. 

### Testes unitários

O projeto possui testes unitários que rodam garantem a cobertura dos testes. Grande parte dos arquivos e da essência das regras de negócio estão contempladas
por testes unitários que garantem a integridade do código desenvolvido.

Para executar os testes: ```mvn test```

Ainda para garantir a qualidade dos testes desenvolvidos, está integrado o PI TEST
plugin responsável pelos testes mutantes.

Para rodar os testes de mutação: 

```mvn org.pitest:pitest-maven:mutationCoverage ```

O relatório estará em: ```target/pit-reports```

O último relatório criado está da seguinte forma: 

![Report](/images/pireport.png)

As linhas não contempladas são devido à mutantes que sobreviveram aos testes porém não comprometem a integridade do código.
Logo, foi escolhido, por hora, ignorá-los.

### To do

- Logs

- Melhorar tests de mutação

## Referências

- Tom Hombergs - <b>Get your hands Dirty on Clean Architecture </b>
- Robert Martin - <b> Clean Architect </b>
