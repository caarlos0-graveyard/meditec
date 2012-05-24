[Meditec](http://caarlos0.github.com/meditec) [![Build Status](https://secure.travis-ci.org/caarlos0/meditec.png?branch=master)](http://travis-ci.org/caarlos0/meditec)
=================

# Aplicação de Exemplo para o Minicurso do III Meditec
## Produtividade no Desenvolvimento Web com GWT



    Welcome to the light side of the source, young padawan.

    One step closer to learn something interesting you are...

                               ____
                            _.' :  `._
                        .-.'`.  ;   .'`.-.
               __      / : ___\ ;  /___ ; \      __
             ,'_ ""--.:__;".-.";: :".-.":__;.--"" _`,
             :' `.t""--.. '<@.`;_  ',@:` ..--""j.' `;
                  `:-.._J '-.-'L__ `-- ' L_..-;'
                    "-.__ ;  .-"  "-.  : __.-"
                        L ' /.------.\ ' J
                         "-.   "--"   .-"
                        __.l"-:_JL_;-";.__
                     .-j/'.;  ;""""  / .'\"-.
                   .' /:`. "-.:     .-" .';  `.
                .-"  / ;  "-. "-..-" .-"  :    "-.
             .+"-.  : :      "-.__.-"      ;-._   \
             ; \  `.; ;                    : : "+. ;
             :  ;   ; ;                    : ;  : \:
             ;  :   ; :                    ;:   ;  :
            : \  ;  :  ;                  : ;  /  ::
            ;  ; :   ; :                  ;   :   ;:
            :  :  ;  :  ;                : :  ;  : ;
            ;\    :   ; :                ; ;     ; ;
            : `."-;   :  ;              :  ;    /  ;
             ;    -:   ; :              ;  : .-"   :
             :\     \  :  ;            : \.-"      :
              ;`.    \  ; :            ;.'_..--  / ;
              :  "-.  "-:  ;          :/."      .'  :
               \         \ :          ;/  __        :
                \       .-`.\        /t-""  ":-+.   :
                 `.  .-"    `l    __/ /`. :  ; ; \  ;
                   \   .-" .-"-.-"  .' .'j \  /   ;/
                    \ / .-"   /.     .'.' ;_:'    ;
                     :-""-.`./-.'     /    `.___.'
                           \ `t  ._  /
                            "-.t-._:'



Documentação: http://caarlos0.github.com/meditec/

Apresentação: http://www.slideshare.net/caarlos0/produtividade-no-desenvolvimento-web-com-gwt

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