/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */

package com.ayoub.quiz_app_devoir_rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Utilisateur extends UnicastRemoteObject{

    private IServeur serveur;
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] choixButtons;
    private JButton envoyerButton;
    private int questionCourrante;

    /**
     * L'objet utilisateur, connecté au serveur et commencer le quiz
     * @throws RemoteException
     */
    public Utilisateur() throws RemoteException {
        super();
        questionCourrante = 0;
        try {
            String url = "rmi://127.0.0.1/irisi-quiz";
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            serveur = (IServeur) Naming.lookup(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
        initialiseGUI();
        laQuestionSuivante();
    }

    /**
     * Pour initilaliser l'interface utilisateur avec Java Swing
     */
    private void initialiseGUI() {
        frame = new JFrame("Quiz sur ReactJs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel questionPanel = new JPanel(new FlowLayout());
        questionLabel = new JLabel();
        questionPanel.add(questionLabel);

        JPanel choixPanel = new JPanel(new GridLayout(4, 1));
        choixButtons = new JRadioButton[4];
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < choixButtons.length; i++) {
            choixButtons[i] = new JRadioButton();
            choixButtons[i].addActionListener(new ChoixButtonActionListener());
            choixPanel.add(choixButtons[i]);
            buttonGroup.add(choixButtons[i]);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout());
        envoyerButton = new JButton("Envoyer");
        envoyerButton.addActionListener(new EnvoyerButtonActionListener());
        buttonPanel.add(envoyerButton);

        mainPanel.add(questionPanel, BorderLayout.NORTH);
        mainPanel.add(choixPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    /**
     * Preparer la question suivante s'elle existe
     * Sinon, on affiche le score
     */
    private void laQuestionSuivante() {
        try {
            Question question = serveur.questionSuivante();
            if (question != null) {
                questionLabel.setText(question.getQuestion());
                String[] choix = question.getChoix();
                for (int i = 0; i < choix.length; i++) {
                    choixButtons[i].setText(choix[i]);
                    choixButtons[i].setSelected(false);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Score : " + serveur.getScore() + "/" +serveur.getNombreDeQuestion());
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ChoixButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    /**
     * L'action Listener du button Envoyer
     */
    private class EnvoyerButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                //Par défaut n'est pas sélectionné
                int choixSelectionne = -1;
                for (int i = 0; i < choixButtons.length; i++) {
                    if (choixButtons[i].isSelected()) {
                        choixSelectionne = i;
                        break;
                    }
                }
                if (choixSelectionne != -1) {
                    if (serveur.validerLaReponse(questionCourrante, choixSelectionne)) {
                        JOptionPane.showMessageDialog(frame, "C'est juste");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Faux");
                    }
                    questionCourrante++;
                    laQuestionSuivante();
                } else {
                    JOptionPane.showMessageDialog(frame, "Sélectionner d'abord un choix");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
