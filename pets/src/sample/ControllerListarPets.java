package sample;

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
import javafx.scene.control.TextField;
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

    private String nomePetSelecionado;

    @FXML
    private TextField txtNovaCorPet;

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
    ObservableList<virtualPet> campos;

    private void populaTabelaPets(ArrayList<virtualPet> arr){
        colNomePet.setCellValueFactory(new PropertyValueFactory<>("nome"));

        campos = FXCollections.observableArrayList(arr);
//        System.out.println(arr);

        tbPets.setItems(campos);
    }


    public void bttAcessarPet(MouseEvent mouseEvent) throws IOException {
        //Buscar o índice da linha
        int indice = tbPets.getSelectionModel().getSelectedIndex();
        nomePet = (virtualPet) tbPets.getItems().get(indice);

        if(mouseEvent.getClickCount() == 2){
            System.out.println("Cliquei duas vezes");
            //Isso aqui é para acessar o Pet, colocar em outro botão talvez

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
        }else{
            nomePetSelecionado = nomePet.getNome();
            if(nomePet.getCor() == 0){
                txtNovaCorPet.setText("Vermelho");
            }
            else if(nomePet.getCor() == 1){
                txtNovaCorPet.setText("Azul");
            }
            else if(nomePet.getCor() == 2){
                txtNovaCorPet.setText("Amarelo");
            }
            else{
                txtNovaCorPet.setText("Verde");
            }
//            txtNovaCorPet.setText(Integer.toString(nomePet.getCor()));

        }

    }

    public virtualPet retornaPet(){
        return nomePet;
    }

    public void bttClickDeletar(ActionEvent event) {
        String novoNome = nomePetSelecionado;
        for(int i=0; i< Main.colecaoPets.getPets().size(); i++){
            if(novoNome.equals(Main.colecaoPets.getPets().get(i).getNome())){
                Main.colecaoPets.getPets().remove(i);
                break;
            }
        }
    }

    //só atualiza quando eu cadastro outro pet, porque?
    public void bttClickEditar(ActionEvent event) {
        int novaCor;
        String novaCorNome = txtNovaCorPet.getText();
        System.out.println(novaCorNome);

        if(novaCorNome == "Vermelho"){
            novaCor = 0;
        }
        else if(novaCorNome == "Azul"){
            novaCor = 1;
        }
        else if(novaCorNome == "Amarelo"){
            novaCor = 2;
        }
        else{
            novaCor = 3;
        }

        //Alteramos a cor do Pet
        for(int i=0; i< Main.colecaoPets.getPets().size(); i++){
            if(nomePetSelecionado.equals(Main.colecaoPets.getPets().get(i).getNome())){
                Main.colecaoPets.getPets().get(i).setCor(novaCor);
                System.out.println(Main.colecaoPets.getPets().get(i).getCor());

            }
        }
    }
}


