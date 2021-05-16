package sample;

import com.sun.tools.javac.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerListarPets implements Initializable {
    @FXML
    private TableView tbPets;

    @FXML
    private TableColumn<virtualPet, String> colNomePet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void bttJanelaListaPClick(ActionEvent event) {
        sample.Main.mudaTela(2);
    }

    @FXML
    public void bttJanelaCadastroClick(ActionEvent event) {
        sample.Main.mudaTela(1);
    }

    public void bttListarPets(ActionEvent event) {
        //Preenche a tabela com todos os cadastros de pet
        populaTabelaPets(sample.Main.colecaoPets.getPets());
    }

    //Mudei aqui para static
    static virtualPet nomePet;

    private void populaTabelaPets(ArrayList<virtualPet> arr){
        colNomePet.setCellValueFactory(new PropertyValueFactory<>("nome"));

        ObservableList<virtualPet> campos = FXCollections.observableArrayList(arr);

        tbPets.setItems(campos);
    }


    public void bttAcessarPet(MouseEvent mouseEvent) throws IOException {
        //Buscar o índice da linha
        int indice = tbPets.getSelectionModel().getSelectedIndex();
        nomePet = (virtualPet) tbPets.getItems().get(indice);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tela_pet.fxml"));
//        System.out.println(nomePet);
        Parent root = null;
        Node node = (Node) mouseEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        root = loader.load();
        Scene scene = new Scene(root, 800, 600);

        //Agora eu posso acessar o controller e acessar um método
        ControllerTelaPet controller = loader.getController();
        controller.initDados(nomePet);

        stage.setScene(scene);
        stage.show();


    }

    public virtualPet retornaPet(){
        return nomePet;
    }

}


