package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField txtNomePet;

    public Integer corPet;  //Cor dos Pets - 0 = Vermelho, 1 = Azul, 2 = Amarelo e 3 = Verde
    @FXML
    private void pressButton(ActionEvent event){
        System.out.println("Clicou");
        int valor = 100;
//        int valor += 10;

        String nomePet = txtNomePet.getText();
        if(nomePet != null){
            virtualPet pet = new virtualPet(nomePet, corPet);
            System.out.println(pet.getCor().toString());
            System.out.println(pet.toString());

            sample.Main.colecaoPets.AdicionarPet(pet);

            for(virtualPet p : sample.Main.colecaoPets.getPets()){
                System.out.println(p);
            }

        }
        else{
            System.out.println("Não cadastrou, campo vazio");
        }

    }

    @FXML
    private void pressButtonIncrement(ActionEvent event){
    //Descobrir como modificar um valor específico de um objeto criado
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //Quando o botão for apertado mudará para tela 1 ou 2
    @FXML
    public void bttJanelaListaPClick(ActionEvent event) {
        Main.mudaTela(2);
    }

    @FXML
    public void bttJanelaCadastroClick(ActionEvent event) {
        Main.mudaTela(1);
    }

    public void bttClickCorPetAzul(ActionEvent event) {
        corPet = 1;
    }

    public void bttClickCorPetVermelho(ActionEvent event) {
        corPet = 0;
    }

    public void bttClickCorPetAmarelo(ActionEvent event) {
        corPet = 2;
    }

    public void bttClickCorPetVerde(ActionEvent event) {
        corPet = 3;
    }
}
