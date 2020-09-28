package com.elcio.listadetarefas.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.elcio.listadetarefas.R;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "lista_tarefas";

    /**
     * <bold>description</bold> - this constants represent the app verison,
     * in case of app's upgrade I must to change this constant to the version
     * <p>
     * <bold>Exemple:</bold> <br/>
     * App version 2 <br/>
     * private static final int VERSION = 2;
     * </p>
     */
    private static final int VERSION = 1;
    public static final String ID_COLUMN_NAME_TO_PERSON_TABLE = "id";
    public static final String PERSON_TABLE_NAME = "person";
    public static final String NAME_COLUMN_NAME_TO_PERSON_TABLE = "name";
    public static final String AGE_COLUMN_NAME_TO_PERSON_TABLE = "age";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DATA_BASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS " + PERSON_TABLE_NAME + " ( "
                + ID_COLUMN_NAME_TO_PERSON_TABLE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COLUMN_NAME_TO_PERSON_TABLE + " VARCHAR(256), "
                + AGE_COLUMN_NAME_TO_PERSON_TABLE + " INT(3) " +
                ");";

        try {
            db.execSQL(sqlCreateTable);

            Log.i("BANCO_OK", "banco criado");
        } catch (SQLException e) {
            Log.i("ERRO_NO_BANCO", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
