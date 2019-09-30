package com.unsa.login;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.unsa.login.BaseDatosCel.DatosOpenCel;



public class NuevoModelo extends AppCompatActivity {

    private EditText edtMarca;
    private EditText edtModelo;
    private EditText edtPrecio;
    private EditText edtTamano;
    private EditText edtCamaraF;
    private EditText edtCamaraT;

    private SQLiteDatabase conexion;
    private DatosOpenCel datosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_nuevo_modelo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtMarca = (EditText) findViewById(R.id.edtMarca);
        edtModelo = (EditText) findViewById(R.id.edtModelo);
        edtPrecio = (EditText) findViewById(R.id.edtPrecio);
        edtTamano = (EditText) findViewById(R.id.edtTamano);
        edtCamaraF = (EditText) findViewById(R.id.edtCamaraF);
        edtCamaraT = (EditText) findViewById(R.id.edtCamaraT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_nuevo_modelo, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_ok:
                if (bCamposCorrectos()) {
                    try {
                        datosOpenHelper = new DatosOpenCel(this);
                        conexion = datosOpenHelper.getWritableDatabase();
                        StringBuilder sql = new StringBuilder();
                        sql.append("INSERT INTO CELULARES (MARCA, MODELO, PRECIO, TAMANO, CAMARAF, CAMARAT) VALUES('");
                        sql.append(edtMarca.getText().toString().trim() + "', '");
                        sql.append(edtModelo.getText().toString().trim() + "', '");
                        sql.append(edtPrecio.getText().toString().trim() + "', '");
                        sql.append(edtTamano.getText().toString().trim() + "', '");
                        sql.append(edtCamaraF.getText().toString().trim() + "', '");
                        sql.append(edtCamaraT.getText().toString().trim() + "')");

                        conexion.execSQL(sql.toString());
                        conexion.close();
                        finish();
                    } catch (Exception ex) {
                        AlertDialog.Builder dig = new AlertDialog.Builder(this);
                        dig.setTitle("Aviso");
                        dig.setMessage(ex.getMessage());
                        dig.setNeutralButton("OK", null);
                        dig.show();
                    }
                } else {
                    AlertDialog.Builder dig = new AlertDialog.Builder(this);
                    dig.setTitle("Aviso");
                    dig.setMessage("Existen campos vacios");
                    dig.setNeutralButton("OK", null);
                    dig.show();
                }
                break;

            case R.id.action_cancelar:
                //Toast.makeText(this,"Boton Cancelar seleccionado",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean bCamposCorrectos() {
        boolean res = true;
        if (edtMarca.getText().toString().trim().isEmpty()) {
            edtMarca.requestFocus();
            res = false;
        }
        if (edtModelo.getText().toString().trim().isEmpty()) {
            edtMarca.requestFocus();
            res = false;
        }
        if (edtPrecio.getText().toString().trim().isEmpty()) {
            edtMarca.requestFocus();
            res = false;
        }
        if (edtTamano.getText().toString().trim().isEmpty()) {
            edtMarca.requestFocus();
            res = false;
        }
        if (edtCamaraF.getText().toString().trim().isEmpty()) {
            edtMarca.requestFocus();
            res = false;
        }
        if (edtCamaraT.getText().toString().trim().isEmpty()) {
            edtMarca.requestFocus();
            res = false;
        }
        return res;
    }

}

