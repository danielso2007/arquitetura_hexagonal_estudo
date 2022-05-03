# Arquitetura Hexagonal

Projeto para estudo da arquitetura hexagonal.

# Quarkus

## Iniciando projeto em Quarkus

Todo o processo será feito em linux. **Endereço**: [localhost:8080/q/swagger-ui](http://localhost:8080/q/swagger-ui)

### Instalar via interface de linha de comando

```shell
curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/

curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio
```

Recomendo fazer a instalação do CLI com SDKMAN:

```shell
sdk install quarkus
```

### Criar o aplicativo de introdução

```shell
quarkus create
```

### Execute o aplicativo de introdução

```shell
quarkus dev
```

## Usando o Start Coding

Configure a aplicação via site [code.quarkus.io](https://code.quarkus.io/)

# Spring-boot

## Iniciando projeto em spring-boot

Todo o processo será feito em linux. **Endereço**: [localhost:8080/swagger-ui](http://localhost:8080/swagger-ui/index.html)

## Usando o Start 

Configure a aplicação via site [start.spring.io](https://start.spring.io/)


### Fly-way

O projeto spring boot está configurado para usar o flyway, execute o comando abaixo no terminal:

```shell
./mvnw flyway:migrate
```

### Execute o aplicativo de introdução

```shell
./mvnw spring-boot:run
```

## Actuator

[localhost:8080/actuator](http://localhost:8080/actuator)

## Metrics

[localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)



