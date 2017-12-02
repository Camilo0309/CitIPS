package com.i054114.citips.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.i054114.citips.Models.Cita;
import com.i054114.citips.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CAMILO on 2/12/2017.
 */

public class CitasAdapter extends RecyclerView.Adapter<CitasAdapter.ViewHolder> {

List<Cita> citaList = new ArrayList<>();
Context context;

    public CitasAdapter (List<Cita> citaList, Context context){
        this.citaList = citaList;
        this.context = context;
    }

    @Override
    public CitasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cita, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CitasAdapter.ViewHolder holder, int position) {
        holder.editTextname.setText(citaList.get(position).getNamepaciente());
        holder.editTextcedula.setText(citaList.get(position).getCedula());
        holder.editTexttelefono.setText(citaList.get(position).getTelefono());
        holder.editTextdoctor.setText(citaList.get(position).getNameDoctor());
        holder.editTextfecha.setText(citaList.get(position).getFecha());
        holder.editTexthora.setText(citaList.get(position).getHora());

    }

    @Override
    public int getItemCount() {
        return citaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView editTextname, editTextcedula, editTexttelefono, editTextdoctor, editTextfecha, editTexthora;

        public ViewHolder(View item) {
            super(item);

            editTextname = (TextView) item.findViewById(R.id.id_tv_item_name);
            editTextcedula = (TextView) item.findViewById(R.id.id_tv_item_cedula);
            editTexttelefono = (TextView) item.findViewById(R.id.id_tv_item_telefono);
            editTextdoctor = (TextView) item.findViewById(R.id.id_tv_item_doctor);
            editTextfecha = (TextView) item.findViewById(R.id.id_tv_item_fecha);
            editTexthora = (TextView) item.findViewById(R.id.id_tv_item_hora);
        }
    }
}
