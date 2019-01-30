package vn.edu.vtn.demo_mvp_splash.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import vn.edu.vtn.demo_mvp_splash.db.model.Info;

public class HelperModel {
    SQLiteDatabase database = null;
    String DATABASE_NAME = "Info.db";
    Context context;

    public HelperModel(Context context) {
        this.context = context;
        database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
    }


    public Info getDataFromUsername(String username) {

        String query = "SELECT * FROM INFO WHERE USERNAME=? ";
        Cursor cursor = database.rawQuery(query, new String[]{username});
        String name = null, old = null, hometown = null, work = null;
        while (cursor.moveToNext()) {
            name = cursor.getString(3);
            old = cursor.getString(4);
            hometown = cursor.getString(5);
            work = cursor.getString(6);
        }
        cursor.close();
        return new Info(name, old, hometown, work);
    }


    public boolean checkLogin(String username, String password) {
        Log.d("AAAA", username + " " + password);
        String query = "SELECT * FROM INFO WHERE USERNAME=? AND PASSWORD=? ";
        Cursor cursor = database.rawQuery(query, new String[]{username, password});
        if (cursor.moveToNext()) {
            return true;
        }
        cursor.close();
        return false;
    }

}
