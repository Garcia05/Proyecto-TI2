package com.unsa.login.BaseDatosCel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

public class DatosOpenCel extends SQLiteOpenHelper {

    public DatosOpenCel(Context context){
        super(context, "DATOS",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        StringBuilder sql=new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS CELULARES(");
        sql.append("MARCA VARCHAR(250),");
        sql.append("MODELO VARCHAR(250),");
        sql.append("PRECIO VARCHAR(200),");
        sql.append("TAMANO VARCHAR(200),");
        sql.append("CAMARAF VARCHAR(200),");
        sql.append("CAMARAT VARCHAR (200))");

        sqLiteDatabase.execSQL(sql.toString());
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i,int il){

    }
}