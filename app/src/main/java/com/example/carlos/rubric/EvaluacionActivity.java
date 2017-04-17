package com.example.carlos.rubric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

public class EvaluacionActivity extends AppCompatActivity implements AdapterEstudiante.RecyclerClickListner {
    private RecyclerView recyclerView;
    private AdapterEstudiante adapterEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion);

        recyclerView = (RecyclerView) findViewById(R.id.activity_evaluacion_recycler);
        List<Estudiante> list = new Select().from(Estudiante.class).queryList();
        adapterEstudiante = new AdapterEstudiante(list);
        recyclerView.setAdapter(adapterEstudiante);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void itemClick(View view, int position) {
        Intent intent = new Intent(view.getContext(), AddNotaActivity.class);
        TextView textView = (TextView) view.findViewById(R.id.row_textview);

        intent.putExtra("Nombre", textView.getText().toString());
        startActivityForResult(intent, 0);
    }
}
