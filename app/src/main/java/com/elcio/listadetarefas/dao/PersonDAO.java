package com.elcio.listadetarefas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.elcio.listadetarefas.database.DataBaseHelper;
import com.elcio.listadetarefas.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements InterfaceDAO {
    private SQLiteDatabase writeDatabase;
    private SQLiteDatabase readDatabase;


    public PersonDAO(Context context) {
        DataBaseHelper helper = new DataBaseHelper(context);
        writeDatabase = helper.getWritableDatabase();
        readDatabase = helper.getReadableDatabase();
    }

    /**
     * Take a person and save on data base with two values, name and age
     *
     * @param person - a Person {@link Person} instance
     * @return false if was not possible to save on database; true if was saved
     */
    @Override
    public boolean insert(Person person) {

        try {
            ContentValues values = new ContentValues();
            values.put(DataBaseHelper.NAME_COLUMN_NAME_TO_PERSON_TABLE, person.getFirstName());
            values.put(DataBaseHelper.AGE_COLUMN_NAME_TO_PERSON_TABLE, person.getAge());
            writeDatabase.insert(DataBaseHelper.PERSON_TABLE_NAME, null, values);

            Log.i("SALVO", "DADOS SALVOS");
        } catch (Exception e) {
            Log.i("NAO SALVO", e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean upDate(Person person) {
        String tableName = DataBaseHelper.PERSON_TABLE_NAME;

        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.AGE_COLUMN_NAME_TO_PERSON_TABLE, person.getAge().toString());
        contentValues.put(DataBaseHelper.NAME_COLUMN_NAME_TO_PERSON_TABLE, person.getFirstName().toString());

        String whereClause = "id=?";
        String[] args = {person.getId().toString()};

        try {
            writeDatabase.update(tableName, contentValues, whereClause, args);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("DADOS", e.getMessage());
            return false;
        }
    }

    private void upDateById(Integer id, String firstName, Integer age) {
        Log.i("UPDATE", + id + firstName + age);
    }

    @Override
    public boolean delete(Person person) {
        return false;
    }

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<Person>();

        String sql = "SELECT * FROM " + DataBaseHelper.PERSON_TABLE_NAME;

        Cursor cursor = readDatabase.rawQuery(sql, null);

        cursor.moveToFirst();
        while (cursor.moveToNext()) {

            String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.NAME_COLUMN_NAME_TO_PERSON_TABLE));

            Integer age = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.AGE_COLUMN_NAME_TO_PERSON_TABLE));


            Integer id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.ID_COLUMN_NAME_TO_PERSON_TABLE));

            personList.add(new Person(name, age, id));
        }
        return personList;
    }
}
