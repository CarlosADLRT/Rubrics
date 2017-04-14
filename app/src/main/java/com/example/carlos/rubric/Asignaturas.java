package com.example.carlos.rubric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Asignaturas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Asignaturas extends Fragment {

    private ViewGroup layout;
    private ScrollView scrollView;
    ArrayList<RelativeLayout> relativeLayout=new ArrayList();
    EditText text,text2;
    CheckBox chek;
    int id,tam=0,n,ii=1;
    String var="",num="";
    private OnFragmentInteractionListener mListener;

    public Asignaturas() {
        // Required empty public constructor

    }
    @SuppressLint("InlinedApi")
    private void addChild(int i) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        id = R.layout.cat;
        RelativeLayout rl= (RelativeLayout) inflater.inflate(id, null, false);
        relativeLayout.add(rl);
        text= (EditText) rl.findViewById(R.id.editText);
        text.setText("Asignatura "+(i));
        layout.addView(rl);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_asignaturas, container, false);
        layout = (ViewGroup) v.findViewById(R.id.content);
        scrollView = (ScrollView) v.findViewById(R.id.scrollView);
        initUI(v);
        return v;
    }

    private void initUI(View v) {
        Button b1 = (Button) v.findViewById(R.id.add);
        text2= (EditText) v.findViewById(R.id.tam);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                num = text2.getText().toString();
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
                // TODO Auto-generated method stub

            }

        });
        Button b2 = (Button) v.findViewById(R.id.delet);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //layout.removeViewAt(1);
                remove();
                // TODO Auto-generated method stub

            }

        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}