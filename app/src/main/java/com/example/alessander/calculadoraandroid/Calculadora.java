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

    private void realizarOperacaoSimples() {
        if (!operador.equals("")) {
            if (operador.equals("+")) {
                numero = numeroAnterior + numero;
            } else if (operador.equals("-")) {
                numero = numeroAnterior - numero;
            } else if (operador.equals("x")) {
                numero = numeroAnterior * numero;
            } else if (operador.equals("÷")) {
                if (numero != 0) {
                    numero = numeroAnterior / numero;
                }
            }
        }
    }

    public void realizaOperacao(String op) {
        if (op.equals("%")) {
            numero = (numeroAnterior * numero) / 100;
        } else if (op.equals("+/-")) {
            numero = -numero;
        } else if (op.equals("C")) {
            numero = 0;
            operador = "";
        } else {
            realizarOperacaoSimples();
            operador = op;
            numeroAnterior = numero;
        }
    }

}
