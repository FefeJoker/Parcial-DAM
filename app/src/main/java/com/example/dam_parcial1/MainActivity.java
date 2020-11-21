package com.example.dam_parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView texto;
    private RadioButton booleano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.texto);
        booleano = findViewById(R.id.booleano);
    }
    public void guardarListener(View v){
        EntityParcial e = new EntityParcial(texto.getText().toString(),
                booleano.isChecked());

        Intent intent = new Intent(this, EntityParcialDatabase.class);
        intent.putExtra("entity", e);
        startService(intent);
    }
    public void recuperarListener(View v){

    }
}