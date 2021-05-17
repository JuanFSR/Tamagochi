package sample;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ControllerTelaPet implements Initializable {

    @FXML private Label labelNomePet;

    @FXML private ProgressBar progresBarFelicidade;

    @FXML private ProgressBar progresBarFome;

    @FXML private ProgressBar progresBarSono;

    @FXML private ProgressBar progresBarHigiene;

    @FXML private ProgressBar progresBarSaude;

    @FXML private Button bttBanho;

    @FXML private Button bttDormir;

    @FXML private Button bttBrincar;

    @FXML private Button bttCuidar;

    @FXML private Button bttAlimentar;


    private static virtualPet petSelecionado;
    private double Felicidade;
    private double Fome;
    private double Saude;
    private double Sono;
    private double Higiene;
    private double TempoVida;
    private int Cor;
    private Integer flag = 0;

    private Integer Doente = 0;     //Se diferente de 0, está doente
    private Integer Dormindo = 0;
    private Integer Morto = 0;
    private Integer Normal = 1;
    private Integer Cansado = 0;
    private Integer Sujo = 0;
    private Integer Triste = 0;

    private Integer rateFelicidade = 1;
    private Integer rateSaude = 1;
    private Integer rateFome = 2;
    private Integer rateSono = 3;
    private Integer rateHigiene = 3;

    private Boolean loop = true;

    double arrayAleatorio [] = new double[5];
    Random gerador = new Random();

    //método recebe um pet para inicializar a view
    public void initDados(virtualPet pet){
        petSelecionado = pet;

        Felicidade = petSelecionado.getFelicidade();
        Fome = petSelecionado.getFome();
        Saude = petSelecionado.getSaude();
        Sono = petSelecionado.getSono();
        Higiene = petSelecionado.getHigiene();
        TempoVida = petSelecionado.getTempoVida();
        Cor = petSelecionado.getCor();

        labelNomePet.setText(petSelecionado.getNome());
        progresBarFelicidade.setProgress(Felicidade);
        progresBarFome.setProgress(Fome);
        progresBarSaude.setProgress(Saude);
        progresBarSono.setProgress(Sono);
        progresBarHigiene.setProgress(Higiene);
        System.out.println(Cor);
        System.out.println(TempoVida);


    }

    //Necessário verificar a cor do Pet para alterar a imagem
    //Vermelho = 0
    //Azul = 1
    //Amarelo = 2
    //Verde = 3

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            testee();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    double valor = 1;
    public void testee() throws InterruptedException {
        Service<Void> servico = new Service() {
            protected Task createTask() {
                return new Task() {
                    protected Void call() throws Exception {

                        Thread.sleep(300);
                        while(loop){
                            atualizaAtributos();
                            System.out.println("Dormindo valor");
                            System.out.println(Dormindo);
                            Thread.sleep(500);
                        }
                        return null;
                    }
                };
            }
        };
        servico.restart();
    }



    public void bttClickBrincar(ActionEvent event) {
        if(Dormindo != 1){

            if(Felicidade < 95 && Fome-8 == 0){
                Felicidade = Felicidade + 5;
                Fome = 0;
            }
            else if(Felicidade <95 && Fome-8 != 0){
                Felicidade = Felicidade + 5;
                Fome = Fome - 8;
            }
            else if(Felicidade > 95 && Fome-8 != 0){
                Felicidade = 100;
                Fome = Fome - 8;
            }
            else{
                Felicidade = 100;
                Fome = 0;
            }
//        progresBarFelicidade.setProgress(Felicidade);
        }

    }


    public void bttClickAlimentar(ActionEvent event) {
        if(Dormindo != 1) {
            if (Fome > 0 && Fome < 90) {
                Fome = Fome + 5;
            } else if (Fome > 90) {
                Fome = Fome + 5;
                Saude = Saude - 3;
            } else if (Fome == 0) {
                Fome = 0;
            }
        }
    }

    public void bttClickCuidar(ActionEvent event) {
        if(Dormindo != 1) {
            if (Saude > 0 && Saude < 95) {
                Saude = Saude + 5;
            } else if (Saude > 90) {
                if (Saude + 5 >= 100) {
                    Saude = 100;
                }
                Doente = 1;
            }
        }
    }

    public void bttClickDormir(ActionEvent event) {
        if(Dormindo == 0) {
            System.out.println("Estou dormindoooo");
            Dormindo = 1;
            rateFome = -1;
            rateSaude = -1;
            rateHigiene = 2;
            rateSono = -2;
            rateFelicidade = 1;
        }
        else{
            Dormindo = 0;
            System.out.println("Acordeiiii, to pronto");
            rateSono = 3;
            rateSaude = 1;
            rateFome = 2;
            rateFelicidade = 1;
            rateHigiene = 3;
        }
//        Timeline DezSegundosTimeLine = null;
//
//        if(flag == 0){
//            flag = 1;
//
//            DezSegundosTimeLine = new Timeline(new KeyFrame(Duration.seconds(2), event1 -> {
////                Sono = Sono + 1;
//                labelSono.setText(updateTicker());
//
//            }));
//
//            //Executa indefinidamente
//            DezSegundosTimeLine.setCycleCount(Timeline.INDEFINITE);
//            DezSegundosTimeLine.play();
//        }
//        else{
//            flag = 0;
//            DezSegundosTimeLine.stop();
//        }
//
//
//        System.out.println(flag);
//

    }

//    private String updateTicker() {
//        Sono = Sono + 1;
//        return Double.toString(Sono);
//    }

    private void atualizaAtributos() throws IOException {
        for(int i=0; i<5; i++){
            //Varia de 0.15 até 0.24
            arrayAleatorio[i] = ((gerador.nextFloat() + 1)* 0.3) ;
//            System.out.println((gerador.nextFloat()+ 1) * 0.3);

        }

        //Incrementa o tempo de vida conforme as threads são executadas , que nesse caso, são executadas a cada 300ms
        TempoVida += 0.005;

    if(Morto != 1) {
        Sono -= arrayAleatorio[0] * rateSono;
//        System.out.println(Sono);
        Felicidade -= arrayAleatorio[1] * rateFelicidade;
//        System.out.println(Felicidade);
        Saude -= arrayAleatorio[2] * rateSaude;
//        System.out.println(Saude);
        Higiene -= arrayAleatorio[3] * rateHigiene;
//        System.out.println(Higiene);
        Fome -= arrayAleatorio[4] * rateHigiene;
//        System.out.println(Fome);

        //        System.out.println(Sono);

        if (Sono > 100) {
            Sono = 100;
        } else if (Sono <= 0) {
            Sono = 0;
        }

        if (Felicidade < 0) {
            Felicidade = 0;
        } else if (Felicidade > 100) {
            Felicidade = 100;
        }

        if (Saude > 100) {
            Saude = 100;
        } else if (Saude < 0) {
            Saude = 0;
        }

        if (Higiene < 0) {
            Higiene = 0;
        } else if (Higiene > 100) {
            Higiene = 100;
        }

        if (Fome > 100) {
            Fome = 100;
        } else if (Fome < 0) {
            Fome = 0;
        }


        //Verificar se é menor do 100 e maior do que 0
        System.out.println(Sono);
        System.out.println(Felicidade);
        System.out.println(Saude);
        System.out.println(Higiene);
        System.out.println(Fome);

        progresBarSono.setProgress(Sono / 100);
        progresBarFelicidade.setProgress(Felicidade / 100);
        progresBarSaude.setProgress(Saude / 100);
        progresBarHigiene.setProgress(Higiene / 100);
        progresBarFome.setProgress(Fome / 100);

        if (Dormindo != 1) {
            if (Saude < 40) {
                Doente = 1;
                rateSaude = 2;
            } else {
                rateSaude = 1;
            }

            if (Higiene < 50) {
                Sujo = 1;
                rateHigiene = 4;
            } else {
                rateHigiene = 3;
            }

            if (Felicidade < 40) {
                Triste = 1;
                rateFelicidade = 2;
            } else {
                rateFelicidade = 1;
            }

            if (Saude == 0) {
                Morto = 1;
                //Tem que parar e abrir uma janela falando que ele morreu
            }

            if (Sono < 30) {
                Cansado = 1;
                rateSono = 4;
            } else {
                rateSono = 3;
            }
            if (Felicidade == 0 || Saude == 0 || Fome == 0) {
                Morto = 1;
            }
        }
    }
    else{
        loop = false;
        System.out.println("Morri");
        System.out.println(Doente);
        System.out.println(Dormindo);
        System.out.println(Morto);
        System.out.println(Normal);
        System.out.println(Cansado);
        System.out.println(Sujo);
        System.out.println(Triste);

        //Abrir uma nova página que mostra que o Pet morreu - não consegui ainda

//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("pet_morreu.fxml"));
////        System.out.println(nomePet);
//        Parent root = null;
////        Node node = (Node) mouseEvent.getSource();
//        Stage stage = (Stage) node.getScene().getWindow();
//
//        root = loader.load();
//        Scene scene = new Scene(root, 800, 600);
//
//
//        stage.setScene(scene);
//        stage.show();
    }

        //}
//        if(Dormindo == 0){
//            System.out.println("Acordeiiii, to pronto");
//            rateSono = 3;
//            rateSaude = 1;
//            rateFome = 2;
//            rateFelicidade = 1;
//            rateHigiene = 3;
//        }

    }

    public void tst() throws InterruptedException {
        testee();                            System.out.println("Chamou/n");

    }

    public void bttClickBanho(ActionEvent event) {
        if(Dormindo != 1 ) {
            if (Higiene + 5 > 100 && Saude + 3 < 100) {
                Higiene = 100;
                Saude = Saude + 3;
            } else if (Higiene + 5 > 100 && Saude + 3 > 100) {
                Higiene = 100;
                Saude = 100;
            } else if (Higiene + 5 < 100 && Saude + 3 < 100) {
                Higiene = Higiene + 5;
                Saude = Saude + 3;
            } else {
                Higiene = Higiene + 5;
                Saude = 100;
            }
        }

    }
}
