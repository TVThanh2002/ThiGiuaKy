package com.example.quanlysinhvien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.quanlysinhvien.data.SinhVien;
import com.example.quanlysinhvien.data.SinhVienDao;
import com.example.quanlysinhvien.data.SinhVienDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcvSV;
    private SinhVienDatabase svData;
    private AdapterSV adapterSV;
    private SinhVienDao svDao;
    private List<SinhVien> listSinhVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvSV = findViewById(R.id.recycler_notes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvSV.setLayoutManager(linearLayoutManager);
        svData = SinhVienDatabase.getDatabase(this);
        svDao = svData.sinhVienDao();
//        svDao.insert(new SinhVien("Trần Văn Thanh","tvthanh.20ce@vku.udn.vn","20CE","Quảng Trị"));
//        svDao.insert(new SinhVien("Trần Văn Thanh2","tvthanh2.20ce@vku.udn.vn","20CE","Quảng Trị"));
        listSinhVien = svDao.listSV();
        adapterSV = new AdapterSV(listSinhVien);
        rcvSV.setAdapter(adapterSV);


        Button btnNew = findViewById(R.id.button_new_note);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewSVActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}