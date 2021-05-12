package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField txtNomePet;

    @FXML
    private void pressButton(ActionEvent event){
        System.out.println("Clicou");
        int valor = 100;
//        int valor += 10;

        String nomePet = txtNomePet.getText();
        if(nomePet != null){
            virtualPet pet = new virtualPet(valor, nomePet);
            System.out.println(pet.toString());

            Main.colecaoPets.AdicionarPet(pet);

            for(virtualPet p : Main.colecaoPets.getPets()){
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
}
