package com.example.alessander.calculadoraandroid;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraActivity extends AppCompatActivity {

    private Calculadora calc;

    private boolean usuarioDigitando;
    private boolean separadorDecimalDigitado;

    private TextView txtVisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        calc = new Calculadora();
        usuarioDigitando = false;
        separadorDecimalDigitado = false;
        txtVisor = (TextView) findViewById(R.id.txtVisor);
        txtVisor.setText("0");

        if (savedInstanceState != null) {
            txtVisor.setText(savedInstanceState.getString("text_txtVisor"));
        }
    }

    public void onClickNumeros(View v) {
        Button botaoTocado = (Button)v;
        String digito = botaoTocado.getText().toString();
        String textoVisor = txtVisor.getText().toString();

        if (!usuarioDigitando || textoVisor.equals("0")) {
            txtVisor.setText(digito);
            if (!digito.equals("0")) {
                usuarioDigitando = true;
            }
        } else {
            txtVisor.setText(textoVisor + digito);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putString("text_txtVisor", txtVisor.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void onClickOperacoes(View v) {
        Button botaoTocado = (Button)v;
        String operacao = botaoTocado.getText().toString();

        if (operacao.equals(",") && !separadorDecimalDigitado) {
            separadorDecimalDigitado = true;
            if (!usuarioDigitando) {
                txtVisor.setText("0" + ",");
            } else {
                txtVisor.setText(txtVisor.getText().toString() + ",");
            }
            usuarioDigitando = true;
        } else if (!operacao.equals(",")) {
            String modificaVirgula = txtVisor.getText().toString().replace(',','.');

            calc.setNumero(Double.parseDouble(modificaVirgula));
            calc.realizaOperacao(operacao);

            String textoResultado = String.valueOf(calc.getNumero());

            if (textoResultado.endsWith(".0")) {
                textoResultado = textoResultado.substring(0, textoResultado.length() - 2);
            }

            txtVisor.setText(textoResultado.replace('.',','));
            usuarioDigitando = false;
            separadorDecimalDigitado = false;
        }
    }

    public void onClickMemoria(View v) {
        Button botaoTocado = (Button)v;
        String opMemoria = botaoTocado.getText().toString();

        String modificaVirgula = txtVisor.getText().toString().replace(',','.');

        calc.setNumero(Double.parseDouble(modificaVirgula));
        calc.realizaMemoria(opMemoria);

        usuarioDigitando = false;

        String textoResultado = String.valueOf(calc.getNumero());

        if (textoResultado.endsWith(".0")) {
            textoResultado = textoResultado.substring(0, textoResultado.length() - 2);
        }

        txtVisor.setText(textoResultado.replace('.',','));
        usuarioDigitando = false;
        separadorDecimalDigitado = false;
    }
}
