package com.example.demoprojecttast1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.demoprojecttast1.EntityModel;

@Database(entities = EntityModel.class,exportSchema = false,version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String dB_Name = "AppDatabase";
    private static AppDatabase instance;

    public static synchronized AppDatabase getDB(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, dB_Name)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract AppDao appDao();
}
