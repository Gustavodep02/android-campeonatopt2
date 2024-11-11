package br.edu.fateczl.time.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*
 *@author:<Gustavo de Paula>
 */
public class GenericDao extends SQLiteOpenHelper {

    private static final String DATABASE = "CAMPEONATO.DB";
    private static final int DATABASE_VER = 1;
    private static final String CREATE_TABLE_TIME = "CREATE TABLE time (codigo INT NOT NULL PRIMARY KEY, nome VARCHAR(50) NOT NULL, cidade VARCHAR(80) NOT NULL);";
    private static final String CREATE_TABLE_JOGADOR = "CREATE TABLE jogador (id INT NOT NULL PRIMARY KEY, nome VARCHAR(100), data_nasc VARCHAR(10), altura DECIMAL(4,2), peso DECIMAL (4,1), TimeCodigo INT NOT NULL, FOREIGN KEY (TimeCodigo) REFERENCES codigo(time));";



    public GenericDao(Context context){
        super(context, DATABASE, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_TABLE_TIME);
        sqLiteDatabase.execSQL(CREATE_TABLE_JOGADOR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antigaVersao, int novaVersao){
        if(novaVersao > antigaVersao){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS jogador");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS time");
            onCreate(sqLiteDatabase);
        }

    }

}
