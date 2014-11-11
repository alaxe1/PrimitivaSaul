package com.example.primitivasaul;

import java.util.ArrayList;
import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	TextView cuadroNumeros1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        cuadroNumeros1=(TextView)findViewById(R.id.CuadroNumeros); 
        SharedPreferences prefe=getSharedPreferences("Numeros",Context.MODE_PRIVATE);
        cuadroNumeros1.setText(prefe.getString("numAl","")); 
    
    
    
    }
    
    public void generarLoteria(View v){
    	Random rd= new Random();
    	ArrayList<Integer> resultados = new ArrayList<Integer>();
    	int numero;
    	for (int i = 0; i < 6; i++) {
    		numero=(rd.nextInt(49)+1);
    		while (resultados.contains(numero)) {
    			numero=(rd.nextInt(49)+1);		
			}    		
    		resultados.add(numero);   	
		} 	
    	String resulFinal=""+resultados;    	
    	cuadroNumeros1.setText(resulFinal);
    	
    	SharedPreferences preferencias=getSharedPreferences("Numeros",Context.MODE_PRIVATE);
        Editor editor=preferencias.edit();
        editor.putString("numAl", cuadroNumeros1.getText().toString());
        editor.commit();
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
