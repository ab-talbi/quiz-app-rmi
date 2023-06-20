# Une application de quiz sur ReactJs avec java RMI et Java SWING

## Le projet se décompose en deux Parties
- [Partie Serveur](#serveur)
- [Partie Client](#client)

## Partie Serveur <a name = "serveur"></a>
La classe serveur contient les implementations des methodes de l'interface remote IServeur. Les methodes sont :

<ul>
  <li>Question questionSuivante()</li>
  <li>boolean validerLaReponse(int question, int reponse)</li>
  <li>int getScore()</li>
  <li>int getNombreDeQuestion()</li>
</ul>

et d'autres methodes comme :

<ul>
  <li>void initialiserLesQuestions() pour l'initialisation des questions</li>
</ul>

![1](https://github.com/ab-talbi/quiz-app-rmi/assets/101748749/f1d2aaac-71f3-4a36-b29d-a2a28cd69f61)
<br>
un exemple de question

<br>
 
## Partie Client <a name = "client"></a>
L'utilisateur repondre au question et passe d'une question à une autre en utilisant un button "Envoyer". Une fois on arrive à la derniere question, le résultat s'affiche automatiquement.

![2](https://github.com/ab-talbi/quiz-app-rmi/assets/101748749/750d449b-e587-485f-b670-82a161fc1d20)
![3](https://github.com/ab-talbi/quiz-app-rmi/assets/101748749/fefa9279-9620-4413-8d22-51ad3ffe0409)
![4](https://github.com/ab-talbi/quiz-app-rmi/assets/101748749/0b04a374-45c2-4523-9d3a-683bde6392b2)


 <br>

## Téchnologies utilisés
<ul>
  <li>Java RMI</li>
  <li>Java Swing</li>
</ul>

## Comment utiliser le projet
<ul>
  <li>Cloner le projet ou le télecharger sous form zip</li>
  <li>Lancer le serveur de ServeurMain</li>
  <li>Lancer UtilisateurMain1 ou UtilisateurMain2</li>
  <li>Commencer à répondre au questions</li>
</ul>

## Réalisé par : TALBI AYOUB









