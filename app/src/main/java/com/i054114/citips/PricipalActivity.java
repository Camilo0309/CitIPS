package com.i054114.citips;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PricipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricipal);
    }

    public void Agenda(View view){
        Intent intent = new Intent(this, AgendaActivity.class);
        startActivity(intent);
    }
}
