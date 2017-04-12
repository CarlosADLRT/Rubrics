package com.example.carlos.rubric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Asignaturas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Asignaturas extends Fragment {

    private ViewGroup layout;
    private ScrollView scrollView;
    RelativeLayout[] relativeLayout=new RelativeLayout[100];
    TextView textView;
    EditText text;
    int id,i=0;
    String var="";
    private OnFragmentInteractionListener mListener;

    public Asignaturas() {
        // Required empty public constructor

    }
    @SuppressLint("InlinedApi")
    private void addChild() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        id = R.layout.edit;
        relativeLayout[i] = (RelativeLayout) inflater.inflate(id, null, false);
        text= (EditText) relativeLayout[i].findViewById(R.id.editText);
        var = text.getText().toString();
        layout.addView(relativeLayout[i]);
        i++;
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
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                addChild();
                // TODO Auto-generated method stub

            }

        });
        Button b2 = (Button) v.findViewById(R.id.delet);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                layout.removeAllViews();
                i=0;
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
