package com.project.OOPs;

public class Player {
    private String name;
    private char symbol;
   public Player(String name,char symbol){
        setName(name);
        setSymbol(symbol);
    }

    public void setSymbol(char symbol) {
        if (symbol!='\0') //not null char
           this.symbol=symbol;
    }

    private void setName(String name) {
        if (!name.isEmpty())
            this.name=name;
    }
   public String getName(){
        return this.name;

    }
    public  char getSymbol() {
        return this.symbol;
    }


}
