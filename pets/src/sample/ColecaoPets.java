package sample;

import java.util.ArrayList;

public class ColecaoPets {
    public ArrayList<virtualPet> todosPets;

    //Construtor de ColecaoPets
    public ColecaoPets(){
        todosPets = new ArrayList<virtualPet>();
    }

    //método para adicionar novos pets
    public void AdicionarPet(virtualPet p){
        if(p != null){
            todosPets.add(p);
        }
    }

     public ArrayList<virtualPet> getPets(){
        return todosPets;
     }
}
