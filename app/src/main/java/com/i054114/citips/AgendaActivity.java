package com.i054114.citips;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.i054114.citips.Adapter.CitasAdapter;
import com.i054114.citips.Helper.SqliteHelper;
import com.i054114.citips.Models.Cita;

import java.util.ArrayList;
import java.util.List;

public class AgendaActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SqliteHelper sqliteHelper;
    List<Cita>  citaList = new ArrayList<>();
    CitasAdapter citasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        sqliteHelper = new SqliteHelper(this, "db_citips", null, 1);
        recyclerView = (RecyclerView) findViewById(R.id.id_rv_citas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        listCitas();

    }


    private void listCitas() {
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select id, namepaciente, cedula, telefono, nameDoctor, fecha, hora from citas order by id desc", null);
        while (cursor.moveToNext()){
            Cita cita = new Cita();
            cita.setIdC(cursor.getInt(0));
            cita.setNamepaciente(cursor.getString(1));
            cita.setCedula(cursor.getString(2));
            cita.setTelefono(cursor.getString(3));
            cita.setNameDoctor(cursor.getString(4));
            cita.setFecha(cursor.getString(5));
            cita.setHora(cursor.getString(6));
            citaList.add(cita);
        }
        cursor.close();
        if (citaList.size() != 0){
            processData();
        }else{
            Toast.makeText(this, "Agenda vacia", Toast.LENGTH_SHORT).show();
        }
    }

    private void processData() {
        citasAdapter = new CitasAdapter(citaList, getApplicationContext());
        recyclerView.setAdapter(citasAdapter);
    }

    public void registerCita(View view){
        Intent intent = new Intent(this, RegisterCitaActivity.class);
        startActivity(intent);


    }
}
