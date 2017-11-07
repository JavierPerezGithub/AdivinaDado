package com.example.javier.adivinadado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RecogeNombre extends AppCompatActivity {
    EditText nombre;
    Button btnContinuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoge_nombre);
        nombre = (EditText)findViewById(R.id.etIntroduce2);
        btnContinuar = (Button)findViewById(R.id.btnMetoNombre);

    }
    public void onClick2(View view){
        String nombre = this.nombre.getText().toString();
        Intent intent = new Intent(RecogeNombre.this,ProcesoCargaDados.class);
        intent.putExtra("Nombre",nombre);
        startActivity(intent);
        finish();
    }
}