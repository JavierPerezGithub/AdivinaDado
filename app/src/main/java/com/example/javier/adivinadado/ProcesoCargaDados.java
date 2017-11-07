package com.example.javier.adivinadado;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProcesoCargaDados extends AppCompatActivity {
String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceso_carga_dados);
        nombre = getIntent().getStringExtra("Nombre");
        Thread tiempo = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(ProcesoCargaDados.this,RealizaJuego.class);
                    intent.putExtra("Nombre",nombre);
                    startActivity(intent);
                   finish();
                }
            }
        };
        tiempo.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
