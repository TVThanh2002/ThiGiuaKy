package com.example.quanlysinhvien;

import android.arch.persistence.room.Database;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.quanlysinhvien.data.SinhVien;
import com.example.quanlysinhvien.data.SinhVienDao;
import com.example.quanlysinhvien.data.SinhVienDatabase;

import java.util.List;

public class AdapterSV extends RecyclerView.Adapter<AdapterSV.SVViewHolder>  {
    private List<SinhVien> listSV;
    private SinhVienDatabase dataSV;
    private SinhVienDao svDao;
    public AdapterSV(List<SinhVien> listSV) {
        this.listSV = listSV;
    }

    @NonNull
    @Override
    public SVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sinhvien_item,parent,false);
        return new SVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SVViewHolder holder, int position) {
        SinhVien sinhVien = listSV.get(position);
        if(sinhVien ==null){
            return;
        }
        holder.name.setText(sinhVien.getFullName());
        holder.email.setText(sinhVien.getEmail());
        holder.Contact.setText(sinhVien.getContact());
        holder.Address.setText(sinhVien.getAddress());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dataSV = SinhVienDatabase.getDatabase(view.getContext());
               svDao = dataSV.sinhVienDao();
               dataSV.sinhVienDao().delete(sinhVien);
               listSV = dataSV.sinhVienDao().listSV();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listSV!=null){
            return listSV.size();
        }
        return 0;
    }

    public class SVViewHolder extends RecyclerView.ViewHolder{
        private TextView Contact,name,Address,email;
        private Button btnDelete;
        public SVViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            Contact = itemView.findViewById(R.id.Contact);
            Address = itemView.findViewById(R.id.Address);
            btnDelete = itemView.findViewById(R.id.button_delete);
        }
    }
}
