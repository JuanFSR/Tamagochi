package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerListarPets implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void bttJanelaListaPClick(ActionEvent event) {
        Main.mudaTela(2);
    }

    @FXML
    public void bttJanelaCadastroClick(ActionEvent event) {
        Main.mudaTela(1);
    }
}


