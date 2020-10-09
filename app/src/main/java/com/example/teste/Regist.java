package com.example.teste;

public class Regist {
    private String regusername;
    private String regpassword;
    private String regemaile;

    public Regist(String regusername, String regpassword, String regemaile){
        this.regusername = regusername;
        this.regpassword = regpassword;
        this.regemaile = regemaile;
    }

    public String getRegusername() {
        return regusername;
    }

    public void setRegusername(String regusername) {
        this.regusername = regusername;
    }

    public String getRegpassword() {
        return regpassword;
    }

    public void setRegpassword(String regpassword) {
        this.regpassword = regpassword;
    }

    public String getRegemaile() { return regemaile;}

    public void setRegemaile(String regemaile) {
        this.regemaile = regemaile;
    }

    }
