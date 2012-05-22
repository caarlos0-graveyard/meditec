# Aplicação de Exemplo para o Minicurso do III Meditec
## Produtividade no Desenvolvimento Web com GWT

Documentação: http://caarlos0.github.com/meditec/

### Download + Executar

```
$ git clone git@github.com:caarlos0/meditec.git
$ cd meditec
$ mvn clean gwt:run
```

Ou pode gerar um war e colocar em um tomcat/jetty/glassfish/etc:

```
$ mvn clean package
```

### Para gerar o site/javadocs localmente:

```
$ mvn clean site -Dgithub.site.dryRun=true -Ddependency.locations.enabled=false
```

### Atenção!
É necessário um banco de dados chamado "meditec" em um postgreSQL. As configurações podem ser alteradas
em `src/main/resources/META-INF/persistence.xml`.

=)