package com.example.quanlysinhvien.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {SinhVien.class},version = 1)
public abstract class SinhVienDatabase extends RoomDatabase {
  private static SinhVienDatabase INSTANCE;
  public abstract SinhVienDao sinhVienDao();
  public static SinhVienDatabase getDatabase(Context context){
   if(INSTANCE==null){
       INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), SinhVienDatabase.class).allowMainThreadQueries().build();
     //INSTANCE = Room.DatabaseBuilder(this, SinhVienDatabase.class,"QuanLy.db").allowMainThreadQueries().build();
   }
   return INSTANCE;
  }
}
