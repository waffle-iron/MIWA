Pour lancer le projet il vous faut
Maven
Java 1.8

Comment lancer le projet


Si vous avez installé maven sur votre ordinateur
```mvn clean install tomcat7:run```

Sinon ouvrez le projet avec votre IDE et ajoutez cette commande maven.


Une fois le projet lancé, pour vérifier que tout marche bien:

Allez sur [Ce lien](http://127.0.0.1:8080/miwa/api/time)

Normalement vous allez recevoir ```{"speed":1}```
