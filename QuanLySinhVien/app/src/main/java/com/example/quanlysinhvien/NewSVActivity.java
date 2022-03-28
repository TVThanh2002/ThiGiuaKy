package com.example.quanlysinhvien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlysinhvien.data.SinhVien;
import com.example.quanlysinhvien.data.SinhVienDao;
import com.example.quanlysinhvien.data.SinhVienDatabase;

public class NewSVActivity extends AppCompatActivity {

    private EditText txtname,txtemail,txtContact,txtAddress;
    private Button btnSave;
    private SinhVienDatabase svData;
    private SinhVienDao svDao;
    private AdapterSV adapterSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_svactivity);
        txtname = findViewById(R.id.txtname);
        txtemail = findViewById(R.id.txtemail);
        txtContact = findViewById(R.id.txtContact);
        txtAddress = findViewById(R.id.txtaddress);
        btnSave = findViewById(R.id.button_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtname.getText().toString();
                String email = txtemail.getText().toString();
                String Contact = txtContact.getText().toString();
                String Address = txtAddress.getText().toString();
                svData = SinhVienDatabase.getDatabase(getApplication());
                svDao = svData.sinhVienDao();
                svDao.insert(new SinhVien(name,email,Contact,Address));
                finish();
                Intent intent = new Intent(NewSVActivity.this, MainActivity.class);
                NewSVActivity.this.startActivity(intent);
            }
        });
    }
}