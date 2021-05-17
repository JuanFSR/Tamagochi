package sample;

public class virtualPet {
    private double tempoVida;
    private String nome;
    private double saude;
    private double fome;
    private double felicidade;
    private double sono;
    private double higiene;
    private int cor;



    //Construtor
    //Tirei os parametos do construtor, vamos ver se funciona
    public virtualPet(String nome, int cor){
        this.tempoVida = 0;
        this.nome = nome != null ? nome :"";
        this.saude = 100;
        this.fome = 100;
        this.felicidade = 100;
        this.sono = 100;
        this.higiene = 100;
        this.cor = cor;
    }
    //Getters
    public double getTempoVida(){
        return tempoVida;
    }

    public String getNome(){
        return nome;
    }

    public double getSaude(){
        return saude;
    }

    public double getFome(){
        return fome;
    }

    public double getFelicidade(){return felicidade;}

    public double getSono(){return sono;}

    public double getHigiene(){return higiene;}

    public Integer getCor(){return cor;}




    //Setters
    public void setTempoVida(Integer novotempoVida){
        if(novotempoVida != null){
            this.tempoVida = novotempoVida;
        }
    }

    public void setNome(String novoNome){
        System.out.println("Aqui Mesmo");
        if(novoNome != " "){
            this.nome = novoNome;
        }
    }

    public void setSaude(double Saude){
        if(Saude != 0 && Saude < 100){
            this.saude = Saude;
        }
    }

    public void setFome(double novoFome){
        if(novoFome < 100 && novoFome>0){
            this.fome = novoFome;
        }
    }

    public void setFelicidade(double novoFelicidade){
        if(novoFelicidade < 100){
            this.felicidade = novoFelicidade;
        }
    }

    public void setSono(double novoSono){
        if(novoSono < 100){
            this.sono = novoSono;
        }
    }

    public void setHigiene(double novoHigiene){
        if(novoHigiene < 100){
            this.higiene = novoHigiene;
        }
    }

    public void setCor(int cor) {
        if(cor == 0 || cor == 1 || cor == 2 || cor == 3){
            this.cor = cor;
        }
        else{
            this.cor = 0;
        }

    }

    //Transforma todos os dados em string
    @Override
    public String toString(){
        StringBuilder pstring = new StringBuilder();
        pstring.append("Pet{Nome=").append(nome);
        pstring.append(", tempo de Vida=").append(tempoVida);
        pstring.append(", saude=").append(saude);
        pstring.append(", fome=").append(fome);
        pstring.append(", felicidade=").append(felicidade);
        pstring.append(", sono=").append(sono);
        pstring.append(", higiene=").append(higiene);
        pstring.append(", cor=").append(cor);
        pstring.append("}");
        return pstring.toString();
    }


}
