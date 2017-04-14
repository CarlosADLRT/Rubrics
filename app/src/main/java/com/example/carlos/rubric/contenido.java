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

import java.util.ArrayList;

public class contenido extends AppCompatActivity {

    private ViewGroup layout;
    private ScrollView scrollView;
    ArrayList<RelativeLayout> relativeLayout=new ArrayList();
    ArrayList<Intent> intents=new ArrayList();
    EditText text,text2,text3,text4,tm;
    CheckBox chek;
    int id,tam=0,n,ii=1;
    String var="",num="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r_contenido);
        layout = (ViewGroup) findViewById(R.id.content);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        num=getIntent().getStringExtra("elementos");
        var=getIntent().getStringExtra("niveles");
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
        /*for (int i = 0; i < tam; i++){
            Intent in = new Intent(this, contenido.class);
            text3=(EditText) relativeLayout.get(i).findViewById(R.id.nelem);
            text4=(EditText) relativeLayout.get(i).findViewById(R.id.lvl);
            in.putExtra("elementos", var);
            intents.add(in);
            startActivityForResult(in, i);
        }*/

        finish();
    }
}
