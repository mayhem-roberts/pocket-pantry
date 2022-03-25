package com.example.pocketpantry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper implements Contract.DatabaseModel {
    public static final String TABLE_NAME = "PANTRY_TABLE";
    public static final String COLUMN_PANTRY_ITEM_NAME = "PANTRY_ITEM_NAME";
    public static final String COLUMN_PANTRY_ITEM_QUANTITY = "PANTRY_ITEM_QUANTITY";
    public static final String COLUMN_PANTRY_ITEM_WEIGHT = "PANTRY_ITEM_WEIGHT";
    public static final String COLUMN_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "pantry.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PANTRY_ITEM_NAME + " TEXT, " + COLUMN_PANTRY_ITEM_QUANTITY + " INT, " + COLUMN_PANTRY_ITEM_WEIGHT + " FLOAT)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addOne(String name, int quantity, float weight){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PANTRY_ITEM_NAME, name);
        cv.put(COLUMN_PANTRY_ITEM_QUANTITY, quantity);
        cv.put(COLUMN_PANTRY_ITEM_WEIGHT, weight);

        long insert = db.insert(TABLE_NAME, null, cv);

        if (insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public List<PantryItem> getAll() {
        List<PantryItem> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do {
                int _id = cursor.getInt(0);
                String pantryItemName = cursor.getString(1);
                int pantryItemQuantity = cursor.getInt(2);
                float pantryItemWeight = cursor.getFloat(3);

                PantryItem pantryItem = new PantryItem(_id, pantryItemName, pantryItemQuantity, pantryItemWeight);
                returnList.add(pantryItem);
            } while(cursor.moveToNext());
        }
        else{}

        cursor.close();
        db.close();
        return returnList;
    }

    @Override
    public void updateItem(PantryItem pantryItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PANTRY_ITEM_NAME, pantryItem.getName());
        cv.put(COLUMN_PANTRY_ITEM_QUANTITY, pantryItem.getQuantity());
        cv.put(COLUMN_PANTRY_ITEM_WEIGHT, pantryItem.getWeight());

        long update = db.update(TABLE_NAME, cv, "COLUMN_ID=?", new String[] {String.valueOf(pantryItem.get_id())});
    }

    @Override
    public void deleteItem(int _id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "COLUMN_ID=?", new String[] {String.valueOf(_id)});
    }


}
