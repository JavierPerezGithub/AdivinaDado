package com.example.javier.adivinadado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RealizaJuego extends AppCompatActivity {
    int contador;
    TextView tvPistas;
    TextView tvIntentos;
    TextView tvNombre;
    EditText etIntroducir;
    Button btnAccion;
    Random r;
    String clavepista;
    String msgPista;
    int aleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realiza_juego);
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        contador = 5;
        aleatorio = randomNumber();
        tvIntentos = (TextView)findViewById(R.id.txvIntentos);
        tvIntentos.setText(getResources().getString(R.string.sEmpiezasIntentos)
                + " "+contador +" "+ getResources().getString(R.string.sIntentos));
        msgPista = getResources().getString(R.string.sPresentacion);
        tvPistas = (TextView)findViewById(R.id.txvPresentacion);
        tvPistas.setText(msgPista);
        etIntroducir =(EditText)findViewById(R.id.etIntroduce);
        btnAccion = (Button)findViewById(R.id.btnAccion);

        String nombrIntent = getIntent().getStringExtra("Nombre");
        tvNombre.setText(nombrIntent);

    }public void onClick(View v){
        int numero=3;
        try {
                numero = Integer.parseInt(etIntroducir.getText().toString());
            }catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.sSinNumero), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            toast.show();

             }
            if((etIntroducir.getText().toString().isEmpty())){

                //TODO METER ESTO EN UN METODO
                Toast toast = Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.sSinNumero), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }else {
            if (compruebaNumero(numero)==0) {//igual
                btnAccion.setEnabled(false);
                etIntroducir.setEnabled(false);
                msgPista = getResources().getString(R.string.sGanado);
                tvPistas.setText(msgPista);

            }
            if(compruebaNumero(numero)==2){//mayor
                contador--;
                tvIntentos.setText(getResources().getString(R.string.sIntento)
                        + " "+contador +" "+ getResources().getString(R.string.sIntentos));
                msgPista = getResources().getString(R.string.sMenos);
                tvPistas.setText(msgPista);

            }
            if(compruebaNumero(numero)==1){//menor
                contador--;
                tvIntentos.setText(getResources().getString(R.string.sIntento)
                        + " "+contador +" "+  getResources().getString(R.string.sIntentos));
                msgPista = getResources().getString(R.string.sMas);
                tvPistas.setText(msgPista);
            }
            if (contador == 0) {
                msgPista = getResources().getString(R.string.sPerdido);
                tvPistas.setText(msgPista);
                etIntroducir.setEnabled(false);
                btnAccion.setEnabled(false);
                tvIntentos.setText(getResources().getString(R.string.sMuestraNumero)+aleatorio);
            }
        }
    }
    private int randomNumber(){
        int n = 0;
        r = new Random();
        n= r.nextInt(6);
        return n;
    }

    private int compruebaNumero(int n){
        int devuelta=0;

        if(n<aleatorio){
            devuelta= 1;
        }else if(n>aleatorio){
            devuelta=2;
        }else{
            devuelta=0;
        }
        return devuelta;
    }
    public void onSaveInstanceState(Bundle datos){
        super.onSaveInstanceState(datos);
        datos.putInt(getResources().getString(R.string.clave),contador);
        datos.putString(getResources().getString(R.string.claveTexto),
                msgPista);
        datos.putInt(getResources().getString(R.string.claveRandom),aleatorio);
        //TODO hacer lo mismo con el numero aleatorio y con el texto de las pistas.
    }

    public void onRestoreInstanceState(Bundle datos){
        super.onRestoreInstanceState(datos);
        contador = datos.getInt(getResources().getString(R.string.clave));
        msgPista = datos.getString(getResources().getString(R.string.claveTexto));
        tvIntentos.setText(msgPista);
        aleatorio = datos.getInt(getResources().getString(R.string.claveRandom));
    }

}
