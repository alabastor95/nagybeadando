package beadando;

import beadando.gamelogic.GameLogic;
import beadando.messagehandler.MessageHandler;
import beadando.userinterface.GameGUI;
import beadando.userinterface.GameTextUI;
import beadando.userinterface.UserInterface;
import javafx.application.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * This class initiates all of the classes depending on the players choice.
 */
public class Main {




    public static void main(String[] args) {


        //Getting and starting the ui we need
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String streamIn = new String();
        System.out.println("This is the JATacka game from Jónás Veress.\r\n" +
                "Please give us what UI want to use!");
        do {
            System.out.println("Possible options: TextUI, GUI");
            try {
                streamIn = consoleReader.readLine().toLowerCase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!streamIn.equals("textui") && !streamIn.equals("gui"));
        UserInterface ui;
        if(streamIn.equals("textui"))
        {
            ui =  new GameTextUI();
        }
        if(streamIn.equals("gui"))
        {

            ui = new GameGUI();
            Application.launch(GameGUI.class, args);
        }

    }

}
