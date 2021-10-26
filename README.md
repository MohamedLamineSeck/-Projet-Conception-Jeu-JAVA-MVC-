# -Projet-Conception-Jeu-JAVA-MVC-

Réalisisation d'un jeu possédant une interface graphique. 
Pour la réalisation de ce projet on va utiliser le model  MVC en java tout en utilisant les autres patterns que nous avons vus durant les cours.
Ce jeu devrait comporter un panel dans lequel seront placées aléatoirement des formes rouges (cercles et rectangles). 
Le joueur devra par la suite déposer 4 formes bleues qui ne devront pas être en contact les unes avec les autres. 
L'objectif est de maximiser la surface occupée par les formes dans le panel et un score sera donné en fonction de la surface recouverte sur le panel.
L’interface graphique devra comporter une barre contenant les options disponibles pour le joueur. Tel que la création d’une forme (cercle / rectangle), 
le déplacement, la suppression ou encore la possibilité de redimensionner les formes présentes sur le panel. Cette interface disposera également d’un tableau permettant d’afficher le nom et la surface utilisée par chacune des formes.
Par la suite nous devions créer une intelligence artificielle qui serait capable de participer au jeu, nous permettant de pouvoir comparer les résultats obtenus en
fonction du joueur qui lance le jeu (Humain ou Machine).

1. Introduction
2. Architecture
  a. Architecture générale  
  b. Architecture model MVC
3. Patterns
  a. Pattern MVC
  b. Pattern Command
  c. Pattern Abstract Factory
  d. Pattern State
  e. Pattern Observer
4. Aperçu du jeu et fonctionnement

Les Patterns

A. Le Pattern MVC
Le pattern MVC (Modèle Vue Contrôleur) sert à dissocier les trois composantes de notre application. Ainsi la conception du modèle n'est pas entachée par celles de la vue et du contrôleur. On peut disposer de plusieurs vues sur un même modèle, chaque élément du modèle possède sa propre vue.

B. Le Pattern Command (+ Memento)
Le Pattern Command et Memento nous a permis de prendre en charge les actions d'annulation et de rétablissement (undo - redo).
Ce modèle simple nous permet de sauvegarder les états d'un objet. Nous mettons simplement l'objet dans une nouvelle classe et à chaque fois que son état 
change, nous le mettons à jour.

C. Le Pattern Abstract Factory
On s'appuie sur des types d’objets abstraits définis par des interfaces sans se préoccuper de leur type réel et laisser à « factory » le soin de nous fournir les instances dont on a besoin. On ignore le type réel des objets que l’on manipule. Le but est de dissocier totalement l’utilisation des objets de leur création, de
sorte à pouvoir ensuite créer et utiliser de nouvelles implémentations de nos types d’objets, sans avoir à changer une seule ligne de notre code les utilisant.

D. Le Pattern State 
Une fois une classe créée, ses objets ont des méthodes qui certes sont paramétrables, mais dont le comportement est immuable. Nous souhaiterions avoir des objets dont le comportement puisse dépendre de son état, c'est pourquoi on utilise le pattern State qui va nous aider à pouvoir automatiser les changements d'états.

E. Le Pattern Observer
Pour rendre un objet observable ou écoutable par d’autres objets nous avons besoin d’utiliser du pattern observé coupler avec des listeners. En utilisant ce Pattern on veut que n’importe quel autre objet puisse potentiellement être un Observer, pas uniquement des objets spécifiques. Lorsque nous modifions l’état de l’objet observable, cela prévient tous ceux qui l’observent.
