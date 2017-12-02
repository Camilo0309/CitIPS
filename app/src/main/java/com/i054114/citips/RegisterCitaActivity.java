package com.i054114.citips;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.i054114.citips.Adapter.CitasAdapter;
import com.i054114.citips.Helper.SqliteHelper;
import com.i054114.citips.Models.Cita;
import com.i054114.citips.Utilities.Constans;

import java.util.ArrayList;
import java.util.List;

public class RegisterCitaActivity extends AppCompatActivity {
    EditText editTextname, editTextcedula, editTexttelefono, editTextdoctor, editTextfecha, editTexthora;
    SqliteHelper sqliteHelper;
    List<Cita> citaList = new ArrayList<>();
    CitasAdapter citasAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cita);

        editTextname = (EditText) findViewById(R.id.register_name);
        editTextcedula = (EditText) findViewById(R.id.register_cedula);
        editTexttelefono = (EditText) findViewById(R.id.register_telefono);
        editTextdoctor = (EditText) findViewById(R.id.register_doctor);
        editTextfecha = (EditText) findViewById(R.id.register_fecha);
        editTexthora = (EditText) findViewById(R.id.register_hora);

        sqliteHelper = new SqliteHelper(this, "db_citips", null, 1);
        recyclerView = (RecyclerView) findViewById(R.id.id_rv_citas);

    }

    public void onClickCreateCita(View view) {
        String stringName = editTextname.getText().toString();
        String stringcedula = editTextcedula.getText().toString();
        String stringphone = editTexttelefono.getText().toString();
        String stringdoctor = editTextdoctor.getText().toString();
        String stringfecha = editTextfecha.getText().toString();
        String stringhora = editTexthora.getText().toString();


        if (stringName.isEmpty()) {
            Toast.makeText(this, "El campo de nombre esta vacio", Toast.LENGTH_SHORT).show();
        } else if (stringcedula.isEmpty()) {
            Toast.makeText(this, "El campo de cedula esta vacio", Toast.LENGTH_SHORT).show();
        } else if (stringphone.isEmpty()) {
            Toast.makeText(this, "El campo de telefono esta vacio", Toast.LENGTH_SHORT).show();
        } else if (stringdoctor.isEmpty()) {
            Toast.makeText(this, "Ingrese nombre del Dr(a)", Toast.LENGTH_SHORT).show();
        } else if (stringfecha.isEmpty()) {
            Toast.makeText(this, "Ingrese fecha de la cita", Toast.LENGTH_SHORT).show();
        } else if (stringhora.isEmpty()){
            Toast.makeText(this, "Ingrese hora de la cita", Toast.LENGTH_SHORT).show();
        }else{
            createCita();
        }
    }

    private void createCita() {
        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constans.TABLE_FIELD_CITAS_NAMEUSER, editTextname.getText().toString());
        values.put(Constans.TABLE_FIELD_CITAS_CEDULA, editTextcedula.getText().toString());
        values.put(Constans.TABLE_FIELD_CITAS_TELEFONO, editTexttelefono.getText().toString());
        values.put(Constans.TABLE_FIELD_CITAS_NAMEDOCTOR, editTextdoctor.getText().toString());
        values.put(Constans.TABLE_FIELD_CITAS_FECHA, editTextfecha.getText().toString());
        values.put(Constans.TABLE_FIELD_CITAS_HORA, editTexthora.getText().toString());

        db.insert(Constans.TABLE_NAME_CITAS,Constans.TABLE_FIELD_CITAS_ID, values);

        editTextname.setText("");
        editTextcedula.setText("");
        editTexttelefono.setText("");
        editTextdoctor.setText("");
        editTextfecha.setText("");
        editTexthora.setText("");

        Intent intent = new Intent(this, AgendaActivity.class);
        startActivity(intent);


    }

    private void processData() {
        citasAdapter = new CitasAdapter(citaList, getApplicationContext());
        recyclerView.setAdapter(citasAdapter);
    }

}
