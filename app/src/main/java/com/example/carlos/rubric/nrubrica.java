package com.example.carlos.rubric;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.PersistableBundle;
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

import java.util.ArrayList;

public class nrubrica extends AppCompatActivity {

    private ViewGroup layout;
    private ScrollView scrollView;
    ArrayList<RelativeLayout> relativeLayout=new ArrayList();
    ArrayList<Intent> intents=new ArrayList();
    EditText text,text2,text3,text4,tm;
    CheckBox chek;
    int id,tam=0,n,ii=1;
    String asg="",num="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nrubrica);
        layout = (ViewGroup) findViewById(R.id.content);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        asg=getIntent().getStringExtra("asignatura");

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("tamaño",tam);
    }

    @SuppressLint("InlinedApi")
    private void addChild(int i) {
        LayoutInflater inflater = LayoutInflater.from(this);
        id = R.layout.cat;
        RelativeLayout rl= (RelativeLayout) inflater.inflate(id, null, false);
        text= (EditText) rl.findViewById(R.id.editText);
        text.setText("Categoria "+(i));
        text2= (EditText) rl.findViewById(R.id.peso);
        text2.setHint("X%");
        text3= (EditText) rl.findViewById(R.id.nelem);
        text3.setHint("Elem");
        text4= (EditText) rl.findViewById(R.id.lvl);
        text4.setHint("Nivel");
        relativeLayout.add(rl);
        layout.addView(rl);
    }
    public void remove(){
        int i=0;
        while(i<relativeLayout.size()) {
            chek=(CheckBox) relativeLayout.get(i).findViewById(R.id.delet);
            if (chek.isChecked()) {
                layout.removeViewAt(i);
                relativeLayout.remove(i);
                tam--;
                i=0;
            }else{
                i++;
            }
        }
    }
    public void add(View view) {
        //Creamos el evento de agregar EditText segun la necesidad
        //Con el ciclo podemos crear n editText segun el usuario (con eso creamos los elementos
        //que pide el profesor Augusto
        tm= (EditText) findViewById(R.id.tam);
        num = tm.getText().toString();
        if(num.equals("")){
            n=0;
        }else{
            n=Integer.parseInt(num);
            tam=tam+n;
        }
        for(int i=0;i<n;i++) {
            addChild(ii);
            ii++;
        }
    }

    public void delet(View view) {
        remove();
    }

    public void next(View view) {
        Rubric rubrica = new Rubric();
        rubrica.setAsignatura(asg);
        rubrica.setRubric(asg);
        rubrica.save();
        //rubrica.setNcat(tam);
        //rubrica.save();
        for (int i = 0; i < tam; i++){
            Intent in = new Intent(this, contenido.class);
            text = (EditText) relativeLayout.get(i).findViewById(R.id.editText);
            text2 = (EditText) relativeLayout.get(i).findViewById(R.id.peso);
            text3 = (EditText) relativeLayout.get(i).findViewById(R.id.nelem);
            text4 = (EditText) relativeLayout.get(i).findViewById(R.id.lvl);
            in.putExtra("elementos", text3.getText().toString());
            in.putExtra("niveles", text4.getText().toString());
            in.putExtra("categoria",text.getText().toString());
            in.putExtra("pesoc",text2.getText().toString());
            in.putExtra("asignatura",asg);
            intents.add(in);
            startActivityForResult(in, i);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
