package com.sistemadecompras.breno.sistemadecompras;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SistemadeComprasActivity extends Activity {

    CheckBox chkarroz, chkleite, chkcarne, chkfeijao;
    Button bttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistemadecompras);

        chkarroz = (CheckBox) findViewById(R.id.chkarroz);
        chkleite = (CheckBox) findViewById(R.id.chkleite);
        chkcarne = (CheckBox) findViewById(R.id.chkcarne);
        chkfeijao = (CheckBox) findViewById(R.id.chkfeijao);

        Button bttotal = (Button) findViewById(R.id.bttotal);

        bttotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double total = 0;
                if (chkarroz.isChecked())
                    total += 2.00;
                if (chkleite.isChecked())
                    total += 5.00;
                if (chkcarne.isChecked())
                    total += 8.00;
                if (chkfeijao.isChecked())
                    total += 10.00;
                AlertDialog.Builder dialogo;
                dialogo = new
                        AlertDialog.Builder(SistemadeComprasActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Valor total da compra : R$ " +
                        String.valueOf(total));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }

}
