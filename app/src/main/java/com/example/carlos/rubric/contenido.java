package com.example.carlos.rubric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

public class contenido extends AppCompatActivity {

    private ViewGroup layout;
    private ScrollView scrollView;
    ArrayList<RelativeLayout> relativeLayout=new ArrayList();
    ArrayList<Intent> intents=new ArrayList();
    EditText text,text2,text3,text4,tm;
    CheckBox chek;
    int id,tam=0,n,ii=1;
    String var="",num="",asig,cat,peso,elem,niv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_contenido);
        layout = (ViewGroup) findViewById(R.id.content);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        num=getIntent().getStringExtra("elementos");
        var=getIntent().getStringExtra("niveles");
        elem=num;
        niv=var;
        cat=getIntent().getStringExtra("categoria");
        peso=getIntent().getStringExtra("pesoc");
        asig=getIntent().getStringExtra("asignatura");
        List<Rubric> ru = (List<Rubric>) new Select(Rubric_Table.Asignatura).from(Rubric.class).where(Rubric_Table.Rubric.is(asig)).queryList();
        //Toast.makeText(this,"Nota: "+nota, Toast.LENGTH_LONG).show();
        tam=Integer.parseInt(num);
        for(int i=0;i<tam;i++) {
            addChild(ii);
            ii++;
        }
    }
    public void remove(){
        int i=0;
        while(i<relativeLayout.size()) {
            chek=(CheckBox) relativeLayout.get(i).findViewById(R.id.delet);
            if (chek.isChecked()) {
                layout.removeViewAt(i);
                relativeLayout.remove(i);
                i=0;
            }else{
                i++;
            }
        }
    }

    private void addChild(int i) {
        LayoutInflater inflater = LayoutInflater.from(this);
        id = R.layout.elem;
        RelativeLayout rl= (RelativeLayout) inflater.inflate(id, null, false);
        text= (EditText) rl.findViewById(R.id.editText);
        text.setText("Elemento "+(i));
        text2= (EditText) rl.findViewById(R.id.peso);
        text2.setText("X%");
        relativeLayout.add(rl);
        layout.addView(rl);
    }

    public void delet(View view) {
        remove();
    }

    public void next(View view) {
        for (int i = 0; i < tam; i++){
            Intent in1 = new Intent(this, conenido2.class);
            text4=(EditText) relativeLayout.get(i).findViewById(R.id.lvl);
            in1.putExtra("asignatura",asig);
            in1.putExtra("pesoc",peso);
            in1.putExtra("categoria",cat);
            in1.putExtra("elementos",elem);
            in1.putExtra("niveles", var);
            in1.putExtra("name", text.getText().toString());
            intents.add(in1);
            startActivityForResult(in1, i);
        }
        finish();
    }
}
