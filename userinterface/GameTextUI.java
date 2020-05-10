package beadando.userinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.regex.Pattern;

public class GameTextUI implements UserInterface {
    protected BufferedReader consoleReader;

    public GameTextUI()
    {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        startUI();
    }

    public void startUI()
    {
        System.out.println("You have chosen the TextUI. Have a good game!");
        netWorkChooser();
    }

    protected void netWorkChooser()
    {
        String streamIn = new String();
        System.out.println("Please choose your host.");
        do {
            System.out.println("Your possible choices are: network, local");
            try {
                streamIn = consoleReader.readLine().toLowerCase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!streamIn.equals("network") && !streamIn.equals("local"));
        if(streamIn.equals("network"))
            network();
        if(streamIn.equals("local"))
            local();
    }

    protected void local() {
        String streamIn = new String();
        System.out.println("You have chosen  local multiplayer.\r\nPlease select the number of players.");
        do {
            System.out.println("You have to select minimum 2 and maximum 6 players.");
            try {
                do {
                    System.out.println("You can only select numbers.");
                    streamIn = consoleReader.readLine().toLowerCase();
                } while (!Pattern.matches("^[0-9]+$", streamIn));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (Integer.valueOf(streamIn)<2 || Integer.valueOf(streamIn)>6);

        System.out.println("You have selected " + streamIn + " players.");
    }

    protected void network()
    {
        String streamIn = new String();
        System.out.println("Please select if you want to host or join a game.");
        do {
            System.out.println("Your possible choices are: host, join");
            try {
                streamIn = consoleReader.readLine().toLowerCase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!streamIn.equals("host") && !streamIn.equals("join"));
        System.out.println("You have decided to "+ streamIn + " a game");
    }



    @Override
    public void updateUI(String message) {


    }



}
