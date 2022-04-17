package com.example.schoolbase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import  androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private ArrayList Id,FIO,DataRos,Class,Intelect,Isscustvo,Sport;


    public MyAdapter(Context context,ArrayList id,  ArrayList fio, ArrayList dataRos, ArrayList aClass, ArrayList intelect, ArrayList isscustvo, ArrayList sport) {
        this.context = context;
        Id = id;
        FIO = fio;
        DataRos = dataRos;
        Class = aClass;
        Intelect = intelect;
        Isscustvo = isscustvo;
        Sport = sport;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate((R.layout.userentry), parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.id.setText(String.valueOf(Id.get(position)));
        holder.fio.setText(String.valueOf(FIO.get(position)));
        holder.dataros.setText(String.valueOf(DataRos.get(position)));
        holder.aClass.setText(String.valueOf(Class.get(position)));
        holder.intelect.setText(String.valueOf(Intelect.get(position)));
        holder.isscustvo.setText(String.valueOf(Isscustvo.get(position)));
        holder.sport.setText(String.valueOf(Sport.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UpdateActivity.class);
                intent.putExtra("id",String.valueOf(Id.get(position)));
                intent.putExtra("fio",String.valueOf(FIO.get(position)));
                intent.putExtra("dataros",String.valueOf(DataRos.get(position)));
                intent.putExtra("class",String.valueOf(Class.get(position)));
                intent.putExtra("intelect",String.valueOf(Intelect.get(position)));
                intent.putExtra("iscustvo",String.valueOf(Isscustvo.get(position)));
                intent.putExtra("sport",String.valueOf(Sport.get(position)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return FIO.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,fio,dataros,aClass,intelect,isscustvo,sport;
        CardView mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id= itemView.findViewById(R.id.id_lable);
            fio = itemView.findViewById(R.id.fio_lable);
            dataros = itemView.findViewById(R.id.dataros_lable);
            aClass = itemView.findViewById(R.id.class_lable);
            intelect = itemView.findViewById(R.id.intelect_lable);
            isscustvo = itemView.findViewById(R.id.isccusstvo_lable);
            sport = itemView.findViewById(R.id.sport_lable);
            mainLayout = itemView.findViewById(R.id.MainLayout);
        }
    }
}
