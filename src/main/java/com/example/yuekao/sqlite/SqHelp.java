package com.example.yuekao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @Author：贾天阳
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 11:57
 * @Description：描述信息
 */
public class SqHelp extends SQLiteOpenHelper{
    public SqHelp(Context context) {
        super(context, "bw.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE person(id INTEGER PRIMARY KEY AUTOINCREMENT,title,TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
