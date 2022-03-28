package com.example.quanlysinhvien.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface SinhVienDao {
    @Insert
    void insert(SinhVien sinhVien);
    @Update
    void update(SinhVien sinhVien);
    @Delete
    void delete(SinhVien sinhVien);
    @Query("SELECT * FROM sinhVien")
    List<SinhVien> listSV();
//    @Query("SELECT * FROM sinhvien ORDER BY id ASC")
//    List<SinhVien> getAllSV();
}
