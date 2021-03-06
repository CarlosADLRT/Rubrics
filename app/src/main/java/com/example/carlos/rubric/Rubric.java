package com.example.carlos.rubric;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by carlos on 3/04/17.
 */

public class Rubric extends RecyclerView.Adapter<Rubric.ViewHolder> {
    private static List<Asignatura> data;
    static Context context;
    //Constructor

    public Rubric(List<Asignatura> data) {
        this.data=data;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public Button mButton;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.row_textview);
            mButton = (Button) v.findViewById(R.id.row_button);
            mButton.setOnClickListener(new View.OnClickListener() {

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View arg0) {
                    context=itemView.getContext();
                    Intent detail = new Intent(context.getApplicationContext(),nrubrica.class);
                    context.startActivity(detail);
                    // TODO Auto-generated method stub
                }

            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        context = v.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(this.data.get(position).getNombre());
    }



    @Override
    public int getItemCount() {
        return data.size();
    }
}
