package sample;

public class virtualPet {
    private int valor;
    private String nome;
    private double saude;
    private double fome;
    private double felicidade;
    private double sono;
    private double higiene;


    //Construtor
    //Tirei os parametos do construtor, vamos ver se funciona
    public virtualPet(int valor, String nome){
        this.valor = 0;
        this.nome = nome != null ? nome :"";
        this.saude = 100;
        this.fome = 0;
        this.felicidade = 100;
        this.sono = 0;
        this.higiene = 100;
    }
    //Getters
    public int getValor(){
        return valor;
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




    //Setters
    public void setValor(){
        if(valor < 100){
            this.valor += 10;
        }
    }

    public void setNome(){
        if(nome != null){
            this.nome = nome;
        }
    }

    public void setSaude(){
        if(saude != 0){
            this.saude = saude;
        }
    }

    public void setFome(){
        if(fome < 100){
            this.fome = fome;
        }
    }

    public void setFelicidade(){
        if(felicidade < 100){
            this.felicidade = felicidade;
        }
    }

    public void setSono(){
        if(sono < 100){
            this.sono = sono;
        }
    }

    public void setHigiene(){
        if(higiene < 100){
            this.higiene = higiene;
        }
    }



    //Transforma todos os dados em string
    @Override
    public String toString(){
        StringBuilder pstring = new StringBuilder();
        pstring.append("Pet{Nome=").append(nome);
        pstring.append(", saude=").append(saude);
        pstring.append(", fome=").append(fome);
        pstring.append(", felicidade=").append(felicidade);
        pstring.append(", sono=").append(sono);
        pstring.append(", higiene=").append(higiene);
        pstring.append("}");
        return pstring.toString();
    }
}
