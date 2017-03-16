package br.com.brenomorais.calculadoradeimc;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.*;
import android.view.View;

public class MainActivity extends Activity {

    private EditText edPeso;
    private EditText edAltura;
    private Button   btCalcular;
    private Button   btLimpar;
    private RadioGroup rgSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPeso = (EditText)findViewById(R.id.edPeso);
        edAltura = (EditText)findViewById(R.id.edAltura);
        btCalcular = (Button)findViewById(R.id.btCalcular);
        btLimpar = (Button)findViewById(R.id.btLimpar);
        rgSexo = (RadioGroup)findViewById(R.id.rgSexo);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edPeso.getText().toString().equals("") || edAltura.getText().toString().equals("")) {

                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("Atenção");
                    dlg.setMessage("Campo(s) em branco(s), verifique!");
                    dlg.setNeutralButton("Ok", null);
                    dlg.show();

                } else {

                    float peso = Float.parseFloat(edPeso.getText().toString());
                    float altura = Float.parseFloat(edAltura.getText().toString());
                    float result = calculoIMC(peso, altura);
                    int op = rgSexo.getCheckedRadioButtonId();

                    String abaixoPeso = "Baixo do Peso";
                    String pesoNormal = "Peso Normal";
                    String acimaPesoM = "Marginalmente acima do Peso";
                    String acimaPeso = "Acima do peso Ideal";
                    String obeso = "Obseo";

                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("Resulado IMC");

                    if (op == R.id.rbFem) {

                        if (result <= 19.1) {

                            dlg.setMessage("IMC é: " + result + " Seu IMC está:" + abaixoPeso);
                            dlg.setNeutralButton("Ok", null);
                            dlg.show();

                        } else if ((result > 19.1) && (result <= 25.8)) {

                            dlg.setMessage("IMC é: " + result + " Seu IMC está:" + pesoNormal);
                            dlg.setNeutralButton("Ok", null);
                            dlg.show();

                        } else if ((result > 25.8) && (result <= 27.3)) {

                            dlg.setMessage("IMC é: " + result + " Seu IMC está:" + acimaPesoM);
                            dlg.setNeutralButton("Ok", null);
                            dlg.show();

                        } else if ((result > 27.3) && (result <= 32.3)) {

                            dlg.setMessage("IMC é: " + result + " Seu IMC está:" + acimaPeso);
                            dlg.setNeutralButton("Ok", null);
                            dlg.show();

                        }
                        if (result > 32.3) {

                            dlg.setMessage("IMC é: " + result + " Seu IMC está:" + obeso);
                            dlg.setNeutralButton("Ok", null);
                            dlg.show();

                        }

                    } else {
                        if (op == R.id.rbMasc) {

                            if (result <= 20.7) {

                                dlg.setMessage("IMC é: " + result + " Seu IMC está:" + abaixoPeso);
                                dlg.setNeutralButton("Ok", null);
                                dlg.show();

                            } else if ((result > 20.7) && (result <= 26.4)) {

                                dlg.setMessage("IMC é: " + result + " Seu IMC está:" + pesoNormal);
                                dlg.setNeutralButton("Ok", null);
                                dlg.show();

                            } else if ((result > 26.4) && (result <= 27.8)) {

                                dlg.setMessage("IMC é: " + result + " Seu IMC está:" + acimaPesoM);
                                dlg.setNeutralButton("Ok", null);
                                dlg.show();

                            } else if ((result > 27.8) && (result <= 31.1)) {

                                dlg.setMessage("IMC é: " + result + " Seu IMC está:" + acimaPeso);
                                dlg.setNeutralButton("Ok", null);
                                dlg.show();

                            }
                            if (result > 31.1) {

                                dlg.setMessage("IMC é: " + result + " Seu IMC está:" + obeso);
                                dlg.setNeutralButton("Ok", null);
                                dlg.show();

                            }
                        }
                    }

                }
            }

        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edPeso.setText("");
                edAltura.setText("");

            }
        });
    }

    public float calculoIMC(float a, float b){

        float kg   = a;
        float al   = b;
        float  imc = kg / (al  * al);
        return imc;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
