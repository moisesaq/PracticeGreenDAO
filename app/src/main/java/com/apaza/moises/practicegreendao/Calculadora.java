package com.apaza.moises.practicegreendao;

public class Calculadora {

    private double numeroA;
    private double numeroB;
    public double resultado;

    public Calculadora(){

    }

    public Calculadora(double numeroA, double numeroB){
        this.numeroA = numeroA;
        this.numeroB = numeroB;
    }

    public void sumar(){

    }

    private void restar(){

    }

    public void setNumeroA(double a){
        this.numeroA = a;
    }

    public double getNumeroA(){
        return numeroA;
    }

    public void setNumeroB(double b){
        this.numeroB = b;
    }

    public double getNumeroB(){
        return numeroB;
    }
}
