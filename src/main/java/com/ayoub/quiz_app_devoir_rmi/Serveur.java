/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */

package com.ayoub.quiz_app_devoir_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Serveur extends UnicastRemoteObject implements IServeur {

    private static final int TAILLE_QUESTION = 10;

    private Question[] questions;
    private int questionCourrante;
    private int score;

    public Serveur() throws RemoteException {
        super();
        initialiserLesQuestions();
        questionCourrante = 0;
        score = 0;
    }

    /**
     * Pour initialiser les questions
     */
    private void initialiserLesQuestions() {
        questions = new Question[TAILLE_QUESTION];

        // Question 1
        String question1 = "React est principalement utilisé pour construire ___.";
        String[] choix1 = new String[]{"Base de données", "Connectivité", "Interface utilisateur", "Design Platform"};
        int choixCorrect1 = 2;
        questions[0] = new Question(question1, choix1, choixCorrect1);

        // Question 2
        String question2 = "Les méthodes de cycle de vie sont principalement utilisées pour ___.";
        String[] choix2 = new String[]{"Garder une trace de l'historique des événements", "Améliorer les composants", "Libérer des ressources", "Aucune de ces réponses"};
        int choixCorrect2 = 3;
        questions[1] = new Question(question2, choix2, choixCorrect2);

        // Question 3
        String question3 = "___ peut être fait alors que plusieurs éléments doivent être retournés à partir d'un composant.";
        String[] choix3 = new String[]{"Abstraction", "Packing", "Insulation", "Wrapping"};
        int choixCorrect3 = 3;
        questions[2] = new Question(question3, choix3, choixCorrect3);

        // Question 4
        String question4 = "Quelle est la bonne façon d'accéder à une fonction fetch() à partir d'un élément h1 dans JSX?";
        String[] choix4 = new String[]{"<h1>{fetch()}</h1>", "<h1>${fetch()}</h1>", "<h1>{fetch}</h1>", "<h1>${fetch}</h1>"};
        int choixCorrect4 = 2;
        questions[3] = new Question(question4, choix4, choixCorrect4);

        // Question 5
        String question5 = "Laquelle des méthodes suivantes dans un composant React doit être remplacée pour empêcher la mise à jour du composant?";
        String[] choix5 = new String[]{"willComponentUpdate", "shouldComponentUpdate", "componentDidUpdate", "componentDidMount"};
        int choixCorrect5 = 1;
        questions[4] = new Question(question5, choix5, choixCorrect5);

        // Question 6
        String question6 = "Qu'est-ce qui est utilisé pour transmettre des données à un composant depuis l'extérieur?";
        String[] choix6 = new String[]{"setState", "render with arguments", "PropTypes", "props"};
        int choixCorrect6 = 3;
        questions[5] = new Question(question6, choix6, choixCorrect6);

        // Question 7
        String question7 = "Laquelle des méthodes suivantes dans un composant React est appelée après le premier rendu du composant?";
        String[] choix7 = new String[]{"componentDidUpdate", "componentDidMount", "componentMounted", "componentUpdated"};
        int choixCorrect7 = 1;
        questions[6] = new Question(question7, choix7, choixCorrect7);

        // Question 8
        String question8 = "Parmi les propositions suivantes, laquelle est la syntaxe correcte pour un gestionnaire d'événements de clic de bouton foo ?";
        String[] choix8 = new String[]{"<button onclick={this.foo()}>", "<button onclick={this.foo}>", "<button onClick={this.foo()}>", "<button onClick={this.foo}>"};
        int choixCorrect8 = 3;
        questions[7] = new Question(question8, choix8, choixCorrect8);

        // Question 9
        String question9 = "Que se passera-t-il si vous appelez setState() dans la méthode render()?";
        String[] choix9 = new String[]{"Une sortie répétitive apparaît à l'écran", "Duplicate key error", "Stack overflow error", "Il ne se passe rien"};
        int choixCorrect9 = 2;
        questions[8] = new Question(question9, choix9, choixCorrect9);

        // Question 10
        String question10 = "Comment écrivez-vous un style en ligne qui spécifie la font-size:12px et color:red; dans JSX ?";
        String[] choix10 = new String[]{"style={{font-size:12,color:'red'}}", "style={{fontSize:'12px',color:'red'}}", "style={fontSize:'12px',color:'red'}", "style={{font-size:12px,color:'red'}}"};
        int choixCorrect10 = 1;
        questions[9] = new Question(question10, choix10, choixCorrect10);

    }

    /**
     * L'implementation de la qustionSuivante() ou il y a la condition
     * Est ce qu'on a terminer les qustions ou non
     * @return La question suivante de type Question ou null
     * @throws RemoteException
     */
    @Override
    public Question questionSuivante() throws RemoteException {
        if (questionCourrante < questions.length) {
            return questions[questionCourrante++];
        } else {
            //la fin de quiz
            return null;
        }
    }

    /**
     * On valide la réponse, si juste on incremente le score
     * @param question c'est l'id de la question
     * @param reponse c'est l'id de la reponse
     * @return true si juste, false sinon
     * @throws RemoteException
     */
    @Override
    public boolean validerLaReponse(int question, int reponse) throws RemoteException {
        if (questions[question].getChoixCorrecte() == reponse) {
            score++;
            return true;
        }
        return false;
    }

    /**
     * Renvoyer le score finale
     * @return le score
     * @throws RemoteException
     */
    @Override
    public int getScore() throws RemoteException {
        return score;
    }

    /**
     * Pour savoir le nombre de questions
     * @return nombre de questions
     * @throws RemoteException
     */
    @Override
    public int getNombreDeQuestion() throws RemoteException {
        return 0;
    }
}
