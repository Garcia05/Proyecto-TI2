package com.unsa.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unsa.login.BaseDatosCel.DatosOpenCel;


import java.util.ArrayList;

public class ActMain extends AppCompatActivity {
    private ListView lstDatos;
    private ArrayAdapter<String> adaptador;
    private ArrayList<String> clientes;

    private SQLiteDatabase conexion;
    private DatosOpenCel datosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ActMain.this, NuevoModelo.class);
                startActivityForResult(it, 0);
            }
        });
        actualizar();
    }
    private void actualizar(){
        lstDatos=(ListView) findViewById(R.id.lstDatos);
        clientes=new ArrayList<String>();
        try {
            datosOpenHelper = new DatosOpenCel(this);
            conexion = datosOpenHelper.getWritableDatabase();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM CELULARES");
            String sModelo;
            String sPrecio;

            Cursor resultado = conexion.rawQuery(sql.toString(), null);

            if (resultado.getCount() > 0) {
                resultado.moveToFirst();
                do {
                    sModelo = resultado.getString(resultado.getColumnIndex("MODELO"));
                    sPrecio = resultado.getString(resultado.getColumnIndex("PRECIO"));
                    clientes.add("Modelo: "+sModelo + " -> Precio:  S/" + sPrecio);

                }
                while (resultado.moveToNext());
            }
            adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clientes);
            lstDatos.setAdapter(adaptador);
        }
        catch (Exception ex){
            AlertDialog.Builder dlg=new AlertDialog.Builder(this);
            dlg.setTitle("Aviso");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data){
        actualizar();
    }
}