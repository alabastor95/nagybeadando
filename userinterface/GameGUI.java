package beadando.userinterface;


import beadando.Main;
import beadando.gamelogic.GameLogic;
import beadando.messagehandler.MessageHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class GameGUI extends Application implements UserInterface  {
    protected Stage stage;


    @Override
    public void updateUI(String message) {
        //TODO
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        initUI();
}



    protected void initUI()
    {
        Button btn = new Button();
        btn.setText("New game");
        btn.setOnAction((ActionEvent action) -> {
            networkChooser();
        });
        btn.setLayoutX(GameLogic.GAME_SIZE_X/2);
        btn.setLayoutY(GameLogic.GAME_SIZE_Y/2);

        Group parent = new Group();
        parent.getChildren().add(btn);

        Scene scene = new Scene(parent, GameLogic.GAME_SIZE_X, GameLogic.GAME_SIZE_Y);
        scene.setFill(Color.BLACK);

        stage.setTitle("Create new game");
        stage.setScene(scene);
        stage.show();
    }

    protected void networkChooser()
    {
        Button localBtn = new Button();
        localBtn.setText("Local host");
        localBtn.setLayoutX(GameLogic.GAME_SIZE_X/4);
        localBtn.setLayoutY(GameLogic.GAME_SIZE_Y/2);
        localBtn.setOnAction((ActionEvent action) -> {
            local();
        });

        Button networkBtn = new Button();
        networkBtn.setText("Network host");
        networkBtn.setLayoutX(3*GameLogic.GAME_SIZE_X/4);
        networkBtn.setLayoutY(GameLogic.GAME_SIZE_Y/2);
        networkBtn.setOnAction((ActionEvent action) ->{
            network();
        });

        Group parent = new Group();
        parent.getChildren().addAll(localBtn, networkBtn);

        Scene scene = new Scene(parent, GameLogic.GAME_SIZE_X, GameLogic.GAME_SIZE_Y);
        scene.setFill(Color.BLACK);

        stage.setTitle("Choose your network!");
        stage.setScene(scene);
        stage.show();
    }

    protected void local()
    {
        //TODO
        Text t = new Text("Choose how many players you want to play with!");
        t.setFill(Color.WHITE);
        t.setLayoutX(GameLogic.GAME_SIZE_X/4);
        t.setLayoutY(GameLogic.GAME_SIZE_Y/4);

        Button btn1 = new Button();
        btn1.setText("2");
        btn1.setLayoutX(GameLogic.GAME_SIZE_X/6);
        btn1.setLayoutY(GameLogic.GAME_SIZE_Y/2);

        Button btn2 = new Button();
        btn2.setText("3");
        btn2.setLayoutX(2*GameLogic.GAME_SIZE_X/6);
        btn2.setLayoutY(GameLogic.GAME_SIZE_Y/2);

        Button btn3 = new Button();
        btn3.setText("4");
        btn3.setLayoutX(3*GameLogic.GAME_SIZE_X/6);
        btn3.setLayoutY(GameLogic.GAME_SIZE_Y/2);

        Button btn4 = new Button();
        btn4.setText("5");
        btn4.setLayoutX(4*GameLogic.GAME_SIZE_X/6);
        btn4.setLayoutY(GameLogic.GAME_SIZE_Y/2);

        Button btn5 = new Button();
        btn5.setText("6");
        btn5.setLayoutX(5*GameLogic.GAME_SIZE_X/6);
        btn5.setLayoutY(GameLogic.GAME_SIZE_Y/2);

        Group parent = new Group();
        parent.getChildren().addAll(t, btn1, btn2, btn3, btn4, btn5);

        Scene scene = new Scene(parent, GameLogic.GAME_SIZE_X, GameLogic.GAME_SIZE_Y);
        scene.setFill(Color.BLACK);

        stage.setTitle("Hot-seat");
        stage.setScene(scene);
        stage.show();
    }

    protected void network()
    {
        //TODO
//        Text t = new Text("This area is under implementation at the moment.");
//        t.setFill(Color.WHITE);
//        t.setLayoutX(GameLogic.GAME_SIZE_X/4);
//        t.setLayoutY(GameLogic.GAME_SIZE_Y/2);

        Button btn1 = new Button();
        btn1.setText("Host a game");
        btn1.setLayoutX(GameLogic.GAME_SIZE_X/4);
        btn1.setLayoutY(GameLogic.GAME_SIZE_Y/2);
        btn1.setOnAction((ActionEvent action)->{

        });

        Button btn2 = new Button();
        btn2.setText("Join game");
        btn2.setLayoutX(3*GameLogic.GAME_SIZE_X/4);
        btn2.setLayoutY(GameLogic.GAME_SIZE_Y/2);

        Group parent = new Group();
        parent.getChildren().addAll(btn1, btn2);

        Scene scene = new Scene(parent, GameLogic.GAME_SIZE_X, GameLogic.GAME_SIZE_Y);
        scene.setFill(Color.BLACK);

        stage.setTitle("Network host");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
