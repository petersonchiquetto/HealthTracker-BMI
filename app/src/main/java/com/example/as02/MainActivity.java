package com.example.as02;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText alturaEditText;
    EditText pesoEditText;
    EditText imcEditText;
    EditText faixaEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Atribuindo valores da view para as variaveis
        alturaEditText = findViewById(R.id.alturaEditText);
        pesoEditText = findViewById(R.id.pesoEditText);
        imcEditText = findViewById(R.id.imcEditText);
        faixaEditText = findViewById(R.id.faixaEditText);

    }

    protected float getNumFromEditText(int id)
    {
        //Convertendo valores recebidos
        String aux;
        if(id == 1)
        {
            aux = alturaEditText.getText().toString();
        }
        else
        {
            aux = pesoEditText.getText().toString();
        }
        return Float.parseFloat(aux);
    }

    public void calcularButtonOnClick(View v)
    {
        //Função Calcular
        float altura = getNumFromEditText(1);
        altura = altura / 100;
        float peso = getNumFromEditText(2);
        float imc = peso / (altura * altura);
        imcEditText.setText(String.valueOf(imc));
        if(imc <= 18.5 )
        {
            faixaEditText.setText(String.valueOf("Abaixo do Peso"));
        }
        else if(imc <= 24.9)
        {
            faixaEditText.setText(String.valueOf("Peso Normal"));
        }
        else if(imc <= 29.9)
        {
            faixaEditText.setText(String.valueOf("Sobrepeso"));
        }
        else if(imc <= 34.9)
        {
            faixaEditText.setText(String.valueOf("Obesidade Grau I"));
        }
        else if(imc <= 39.9)
        {
            faixaEditText.setText(String.valueOf("Obesidade Grau II"));
        }
        else
        {
            faixaEditText.setText(String.valueOf("Obesidade Grau III"));
        }
    }
}