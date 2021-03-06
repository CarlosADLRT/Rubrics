package com.example.carlos.rubric;

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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Asignatura> data;
    //Constructor


    public Adapter(List<Asignatura> data) {
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
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        // set the view's size, margins, paddings and layout parameters
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
