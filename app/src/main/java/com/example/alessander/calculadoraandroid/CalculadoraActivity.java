package com.example.alessander.calculadoraandroid;

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

    public void onClickOperacoes(View v) {

    }
}
