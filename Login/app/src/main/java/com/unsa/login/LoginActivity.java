package com.unsa.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button boton = (Button) findViewById(R.id.inicio_sesion);
        boton.setOnClickListener(new View.OnClickListener(){
       @Override
        public void onClick(View view){
            String usuario= ((EditText)findViewById(R.id.ing_usuario)).getText().toString();
            String contrasena =((EditText)findViewById(R.id.ing_contra)).getText().toString();
            if(usuario.equals("GARCIA")&& contrasena.equals("12345"))

            {

                Intent nuevoform=new Intent(LoginActivity.this,ActMain.class);
                startActivity(nuevoform);
            }

            else if(usuario.equals("QUIÑONES")&& contrasena.equals("12345"))

            {

                Intent nuevoform=new Intent(LoginActivity.this,ActMain.class);
                startActivity(nuevoform);
            }

            else
            {
                Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
            }

            }
        });
    }
}

