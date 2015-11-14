package com.seb.hhd2k15.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seb.hhd2k15.Database.ItemDatabase.TagDB;

import org.w3c.dom.Comment;

/**
 * Created by Elie on 14/11/2015.
 */
public class sqlite extends SQLiteOpenHelper {


    String DATABASE_CREATE_1 = "CREATE TABLE IF NOT EXISTS `user` (" +
            "  `ID_USER` int(11) NOT NULL," +
            "  `DEVICE_ID` varchar(10) NOT NULL," +
            "  `TOKEN` varchar(30) NOT NULL" +
            ") ;";
    String DATABASE_CREATE_2 = "CREATE TABLE IF NOT EXISTS `user_tag` (" +
            "  `ID` int(11) NOT NULL ," +
            "  `LABEL` text NOT NULL," +
            "  `ACTIVE` tinyint(1) NOT NULL" +
            " ) ;";
    String DATABASE_CREATE_3 = "INSERT INTO `user_tag` (`ID`, `LABEL`, `ACTIVE`) VALUES" +
            "(1, 'Point de vue', 0)," +
            "(2, 'Romantique', 0)," +
            "(3, 'Culturels', 0)," +
            "(4, 'Événémentiels', 0);";

    private static String DATABASE_NAME = "hhd.db";

    public sqlite(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    public String getdbName() {
        return this.DATABASE_NAME;
    }

    public void openDB() throws SQLException {
        this.getWritableDatabase();
    }

    public void closeDB() throws SQLException {
        this.close();
    }

    public void updateUserTag(SQLiteDatabase database, TagDB t) {
        database.execSQL("UPDATE user_tag SET ACTIVE=1 WHERE id=" + t.id + "");

    }

    private TagDB cursorToTagTB(Cursor cursor) {
        return new TagDB(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
    }


    public void ListTagDB(SQLiteDatabase database) {
        List<TagDB> listtagdatabase = new ArrayList<TagDB>();

        Cursor cursor = database.query("user_tags", null, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            TagDB tag = cursorToTagTB(cursor);
            listtagdatabase.add(tag);
            Log.d(null, tag.toString());
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_1);
        db.execSQL(DATABASE_CREATE_2);
        db.execSQL(DATABASE_CREATE_3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
