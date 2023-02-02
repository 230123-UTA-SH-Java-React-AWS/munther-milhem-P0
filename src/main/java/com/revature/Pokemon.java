package com.revature;

public class Pokemon {
    private int level;

    public Pokemon(){
        level = 1;
    }

    public void setLevel(int level) throws Exception{
        if(level > 0){
            this.level = level;
        }
        else
        {
            throw new Exception("you set the wrong level value");
        }
        
    }

}
