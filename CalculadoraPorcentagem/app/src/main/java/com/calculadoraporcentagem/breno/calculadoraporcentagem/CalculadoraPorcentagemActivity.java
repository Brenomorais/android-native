package com.calculadoraporcentagem.breno.calculadoraporcentagem;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class CalculadoraPorcentagemActivity extends Activity {


    Button btsomar, btsubtrair, btlimpar;
    EditText ednumero,edporcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadoraporcentagem);

        ednumero = (EditText)findViewById(R.id.ednumero);
        edporcentagem = (EditText)findViewById(R.id.edporcentagem);
        btsomar = (Button)findViewById(R.id.btsomar);
        btsubtrair = (Button)findViewById(R.id.btsubtrair);
        btlimpar = (Button)findViewById(R.id.btlimpar);

        btsomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double valor = Double.parseDouble(ednumero.getText().toString());
                double porcentagem = Double.parseDouble(edporcentagem.getText().toString());
                double novo_valor = 0;

                novo_valor = valor + (valor * (porcentagem / 100));

                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(CalculadoraPorcentagemActivity.this);
                dialogo.setTitle("Resultado");
                dialogo.setMessage("Novo valor: " +
                        String.valueOf(novo_valor));
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
            }
        });

        btsubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double valor = Double.parseDouble(ednumero.getText().toString());
                double porcentagem = Double.parseDouble(edporcentagem.getText().toString());
                double novo_valor = 0;

                novo_valor = valor - (valor * (porcentagem / 100));

                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(CalculadoraPorcentagemActivity.this);
                dialogo.setTitle("Resultado");
                dialogo.setMessage("Novo valor: " +
                        String.valueOf(novo_valor));
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
            }
        });

        btlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ednumero.setText("");
                edporcentagem.setText("");

            }
        });

    }
}
