package br.eti.inovare.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {
        String precoAlcool =  editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        if (validarCampos(precoAlcool, precoGasolina)) {
            textResultado.setText("É melhor abastecer com :" + calcularMelhorOpcaoCombustivel(Double.parseDouble(precoAlcool), Double.parseDouble(precoGasolina)));
        } else {
            textResultado.setText("Preencha os campso primeiro.");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        if( pAlcool == null || pAlcool.equals("") ||
                pGasolina == null || pGasolina.equals("")){
            return false;
        } else {
            return true;
        }
    }

    public String calcularMelhorOpcaoCombustivel(Double alcool, Double gasolina) {
        if((alcool/gasolina) >= 0.7) {
            return "Gasolina";
        } else {
            return "Alcool";
        }
    }
}