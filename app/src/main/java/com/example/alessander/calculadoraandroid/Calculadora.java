package com.example.alessander.calculadoraandroid;

public class Calculadora {

    private double numero;
    private double numeroAnterior;
    private String operador;

    public Calculadora() {

        numero = 0;
        numeroAnterior = 0;
        operador = "";
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }
    
}