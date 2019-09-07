# Projet de système d'information d'une bibliotheque
La solution technique proposée comprend:
* Une API Rest qui implémente la logique métier, l'accès et la lecture des données et le routage URI.
* Un client à destination des lecteurs.
* Un client "Admin" à destination des emloyés de la bibliotheque.
* Un batch pour la planification des mails de relance en cas de retard.



## Tehnologies utilisées:
* JDK 8
* Spring Boot 2
* Spring Boot data jpa
* Spring Cloud security
* Spring Cloud openFeign 2
* Spring Boot Batch
* Spring Boot mail
* Maven
* mySQL 5.6.41 (login: root, pwd=root)
* IntelliJ 2018.2
* Bootstrap 3.3.7
* JSTL 1.2
* JSP  2.3
* Apache Tomcat (embeded & 9.0.19)



## Lancer les modules à l'aide du plugin Maven

Il est possible de compiler et d'executer rapidement l'application avec la commande suivante maven

```
mvn spring-boot:run
```

## Compiler en JAR/WAR

La compilation des livrables se fait avec la commande suivante à l'aide de maven selon la balise <packaging>war</packaging> du pom.xml
```
mvn clean package
```

## Lancer les modules compilés JAR/WAR
Le lancement des modules batch et Api Rest se fait par la commande suivante
```
java -jar batch.jar
```
Pour déployer les applications WAR client-library.war et client-lecteurs sur Tomcat, il est nécessaire de copier le fichier WAR dans le dossier webapps de Tomcat et de personnaliser les champs docBase et port des balises suivantes de server.xml (dans le dossier conf de Tomcat)
Dans docBase, indiquez client-teurs client-lecteurs.WAR
```
 <Host name="localhost"  appBase="webapps" unpackWARs="true" autoDeploy="true">
    <Context docBase="client-library" path="" reloadable="true" />
 </Host>

```

L'application sera déployée sur le port 8082
```
<Connector connectionTimeout="20000" port="8082" protocol="HTTP/1.1" redirectPort="8443"/>
```
Démarrez Tomcat et activez les logs:
```
./startup.sh
tail -f logs/catalina.out

```


## URLs

L'Api rest webservices est déployée sur le port 9092
Pour consulter la liste des livres au format JSON
```
http://localhost:9092/livres
```

Le client lecteurs est accessible à:

```
http://localhost:8082/login
```
Utilisez pour la démo
login: "lecteurTest" ou "userTest"
mdp: 12345 

Le client admin est accessible à:
```
http://localhost:8080/livres
```

## Auteur

Joseph Herradi
