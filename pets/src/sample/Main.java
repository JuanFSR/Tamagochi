package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    //Agora vamos criar uma cena
    private static Scene sceneSample, sceneListarPets;
    private static Stage primaryStage;

    public static ColecaoPets colecaoPets;

    @Override
    public void start(Stage stage) throws Exception{
        //Guarda a primeira janela (sample - será usada para cadastrar Pets)
        FXMLLoader sample = new FXMLLoader(getClass().getResource("sample.fxml"));
        FXMLLoader listar_pets = new FXMLLoader(getClass().getResource("listar_pets.fxml"));

        primaryStage = stage;

        //Definir um título para o palco
        primaryStage.setTitle("Navegação entre janelas");

        //Agora definimos uma janela inicial
        Parent parentSample = sample.load();
        Parent parentListarPets = listar_pets.load();

        //Será uma nova cena
        sceneSample = new Scene(parentSample, 600, 400);
        sceneListarPets = new Scene(parentListarPets, 600, 400);

        //Inicia o Stage como a janela sample
        primaryStage.setScene(sceneSample);
        primaryStage.show();
    }

    //método para que vejamos uma tela ou outra
    public static void mudaTela(int opcao){
        switch (opcao){
            case 1:
                primaryStage.setScene(sceneSample);
                break;
            case 2:
                primaryStage.setScene(sceneListarPets);
                break;
        }
    }

    public static void main(String[] args){
        colecaoPets = new ColecaoPets();
        launch(args);
    }
}
