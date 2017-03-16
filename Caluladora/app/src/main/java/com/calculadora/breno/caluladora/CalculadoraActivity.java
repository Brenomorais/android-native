package com.calculadora.breno.caluladora;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculadoraActivity extends AppCompatActivity {

   EditText ednumero1, ednumero2;
   Button btsomar, btsubtrair, btmultiplicar, btdividir,btlimpar;

    public boolean verifica(){

        boolean aux = false;

        if (ednumero1.getText().toString().equals("") || ednumero2.getText().toString().equals("")){

            AlertDialog.Builder dialogo = new AlertDialog.Builder(CalculadoraActivity.this);
            dialogo.setTitle("Aviso");
            dialogo.setMessage("Campo(s) em branco ");
            dialogo.setNeutralButton("OK", null);
            dialogo.show();
            return aux = true;
        }else{
            return aux;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        ednumero1 = (EditText) findViewById(R.id.ednumero1);
        ednumero2 = (EditText) findViewById(R.id.ednumero2);
        btsomar = (Button) findViewById(R.id.btsomar);
        btsubtrair = (Button) findViewById(R.id.btsubtrair);
        btmultiplicar = (Button) findViewById(R.id.btmultiplicar);
        btdividir = (Button) findViewById(R.id.btdividir);
        btlimpar = (Button) findViewById(R.id.btlimpar);

        btsomar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (verifica() == false) {

                    double num1 = Double.parseDouble(
                            ednumero1.getText().toString());
                    double num2 = Double.parseDouble(
                            ednumero2.getText().toString());
                    double resultado = num1 + num2;
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(CalculadoraActivity.this);
                    dialogo.setTitle("Resultado da Soma");
                    dialogo.setMessage("A soma é : " + resultado);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
            }
        });

        btsubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if (verifica() == false) {

                    double num1 = Double.parseDouble(
                            ednumero1.getText().toString());
                    double num2 = Double.parseDouble(
                            ednumero2.getText().toString());
                    double resultado = num1 - num2;
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(CalculadoraActivity.this);
                    dialogo.setTitle("Resultado da Subtração");
                    dialogo.setMessage("A subtração é : " + resultado);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
            }
        });

        btmultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (verifica() == false) {

                    double num1 = Double.parseDouble(
                            ednumero1.getText().toString());
                    double num2 = Double.parseDouble(
                            ednumero2.getText().toString());
                    double resultado = num1 * num2;
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(CalculadoraActivity.this);
                    dialogo.setTitle("Resultado da Multiplicação");
                    dialogo.setMessage("A Multiplicação é : " + resultado);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
            }
        });

        btdividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if (verifica() == false) {

                    double num1 = Double.parseDouble(
                            ednumero1.getText().toString());
                    double num2 = Double.parseDouble(
                            ednumero2.getText().toString());
                    double resultado = num1 / num2;
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(CalculadoraActivity.this);
                    dialogo.setTitle("Resultado IMC");
                    dialogo.setMessage("A Divisao é : " + resultado);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                }
            }
        });

        btlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ednumero1.setText("");
                ednumero2.setText("");

            }
        });

    }
}
