package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class usuario extends AppCompatActivity {
    private EditText nombre,rut,edadin;
    private TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_usuario);
        nombre=(EditText) findViewById(R.id.nombres_in);
        rut=(EditText) findViewById(R.id.rut_in);
        edadin=(EditText) findViewById(R.id.edad_text);
        data=(TextView) findViewById(R.id.data_in);

    }
    public void guardar_datos(View view){
        String elnombre=nombre.getText().toString();
        String elrut=rut.getText().toString();
        String laedad=edadin.getText().toString();
        SharedPreferences prefs = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putString("nombre", elnombre);  // Debes proporcionar una clave para el valor
        editor.putString("rut", elrut);        // Debes proporcionar una clave para el valor
        editor.putString("edad", laedad);
        editor.commit();
        Toast.makeText(this,"guardado",Toast.LENGTH_SHORT).show();

    }
    public void buscar_datos(View view){
        SharedPreferences prefs = getSharedPreferences("agenda", Context.MODE_PRIVATE);

        // Recuperar los valores utilizando las claves
        String elnombre = prefs.getString("nombre", "");
        String elrut = prefs.getString("rut", "");
        String laedad = prefs.getString("edad", "");

        if (!elnombre.isEmpty() && !elrut.isEmpty() && !laedad.isEmpty()) {
            // Los datos están disponibles en SharedPreferences, ahora puedes mostrarlos
            // Puedes usar estos valores como desees, por ejemplo, mostrarlos en Toast o en vistas de texto.
            String mensaje = "Nombre: " + elnombre + "\nRUT: " + elrut + "\nEdad: " + laedad;
            data.setText(mensaje);
        } else {
            Toast.makeText(this, "No se encontraron datos guardados", Toast.LENGTH_SHORT).show();
        }
    }

}