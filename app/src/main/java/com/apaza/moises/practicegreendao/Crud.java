package com.apaza.moises.practicegreendao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.apaza.moises.practicegreendao.database.DaoMaster;
import com.apaza.moises.practicegreendao.database.DaoSession;
import com.apaza.moises.practicegreendao.database.PlaceDao;
import com.apaza.moises.practicegreendao.database.RatingDao;
import com.apaza.moises.practicegreendao.database.UserDao;

public class Crud {

    private static String nameDB = "dataBaseMoises";
    private static SQLiteDatabase db;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    private static Crud crud;

    private PlaceDao placeDao;
    private UserDao userDao;
    private RatingDao ratingDao;

    private Crud(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, nameDB, null);
        try{
            db = helper.getWritableDatabase();
            daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Crud getInstance(Context context){
        if(crud == null)
            crud = new Crud(context);
        return crud;
    }

    public DaoSession getDaoSession(){
        if(daoSession == null)
            daoSession = daoMaster.newSession();
        return daoSession;
    }

}
