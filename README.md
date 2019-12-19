# Projet full stack sur une API filmographique 

## Description :

 Le projet contient une liste de films avec un titre, le nom du réalisateur, l'année de sortie et un identifiant auto-incrémentée. Dans cette API on peut afficher la liste de films et affiché le film choisi, on peut rechercher un film grâce à son identifiant et on peut aussi ajouter un film avec toutes ses caractéristiques dans la liste.

## le diagramme du projet :

![alt text](https://zupimages.net/up/19/51/ebw4.jpg)

## Les differents EndPoints :

### /movie/about :

![alt text](https://zupimages.net/up/19/51/txqb.jpg)

Le endpoint renvoie un simple String, qui est une description du projet Movie.

### /movie/all : 

![alt text](https://zupimages.net/up/19/51/d2xs.jpg)

Ce EndPoint renvoie ma liste de films en format Json.

### /movie/id? :

![alt text](https://zupimages.net/up/19/51/64l3.jpg)

Ce EndPoint attend une valeur, un identifiant, qui renvoie un film dans toutes la Liste en format Json. 

### /movie/add? :

![alt text](https://zupimages.net/up/19/51/5eou.jpg)

Ce EndPoint attend les 3 valeur qui va lui permettre de créer un film, un titre, un réalisateur et l'année de sortie.
Ensuite il renvoie le film en format Json.

## Screen du Menu Principal :

![alt text](https://zupimages.net/up/19/51/xb0l.jpg)
![alt text](https://zupimages.net/up/19/51/d40k.jpg)

## Architecture des fichiers :

![alt text](https://zupimages.net/up/19/51/yey3.jpg)



