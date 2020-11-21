package com.example.dam_parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView texto;
    private RadioButton booleano;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.texto);
        booleano = findViewById(R.id.booleano);
        lista = findViewById(R.id.lista);
    }
    public void guardarListener(View v){
        EntityParcial e = new EntityParcial(texto.getText().toString(),
                booleano.isChecked());

        Intent intent = new Intent(this, EntityParcialDatabase.class);
        intent.putExtra("entity", e);
        startService(intent);
    }
    public void recuperarListener(View v) {
        DBService dbService = new DBService("db");
        EntityParcial[] datos = dbService.getAllEntities();
        ArrayAdapter adapter = new ArrayAdapter<EntityParcial>(this, android.R.layout.simple_list_item_1, datos);
        lista.setAdapter(adapter);
    }
}