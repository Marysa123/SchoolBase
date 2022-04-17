package com.example.schoolbase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(FIO.get(position)));
        holder.fio.setText(String.valueOf(FIO.get(position)));
        holder.dataros.setText(String.valueOf(DataRos.get(position)));
        holder.aClass.setText(String.valueOf(Class.get(position)));
        holder.intelect.setText(String.valueOf(Intelect.get(position)));
        holder.isscustvo.setText(String.valueOf(Isscustvo.get(position)));
        holder.sport.setText(String.valueOf(Sport.get(position)));
    }

    @Override
    public int getItemCount() {
        return FIO.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,fio,dataros,aClass,intelect,isscustvo,sport;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id= itemView.findViewById(R.id.id_lable);
            fio = itemView.findViewById(R.id.fio_lable);
            dataros = itemView.findViewById(R.id.dataros_lable);
            aClass = itemView.findViewById(R.id.class_lable);
            intelect = itemView.findViewById(R.id.intelect_lable);
            isscustvo = itemView.findViewById(R.id.isccusstvo_lable);
            sport = itemView.findViewById(R.id.sport_lable);
        }
    }
}
