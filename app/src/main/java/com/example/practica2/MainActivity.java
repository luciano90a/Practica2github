package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nombre,des;
    private TextView descripcion;
    private ListView contenedor_consolas;
    private List<String> consolas = new ArrayList<>();
    private List<String> Des = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    int pos=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=(EditText) findViewById(R.id.nombre_in);
        des=(EditText) findViewById(R.id.des_in);
        contenedor_consolas=(ListView) findViewById(R.id.consolas);
        adapter = new ArrayAdapter<String>(this, R.layout.l_view, consolas);
        descripcion=(TextView)findViewById(R.id.la_des);
        contenedor_consolas.setAdapter(adapter);
        contenedor_consolas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Corregir el texto para mostrar el precio correctamente

                String laconsola=Des.get(position);
                descripcion.setText(laconsola);

            }

        });

    }
    public void agregar_consola(View view) {
        String nombre_agregado = nombre.getText().toString();
        String des_agregada = des.getText().toString();
        if (!nombre_agregado.isEmpty() && !des_agregada.isEmpty()) {
            consolas.add(nombre_agregado);
            Des.add(des_agregada);
            adapter.notifyDataSetChanged();
            nombre.setText("");  // Limpia el campo de entrada de nombre
            des.setText("");
            Toast.makeText(this,"exito",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
        }
        pos++;

    }
    public void siguiente(View view){
        Intent sig = new Intent(this, usuario.class);
        startActivity(sig);
    }
}



