package com.festember16.app;

/**
 * Created by bharath17 on 14/9/16.
 * Holder for recycleview adpater
 */
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView name;


    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        name = (TextView)itemView.findViewById(R.id.name);

    }

    @Override
    public void onClick(View view) {
        Intent i;
        Toast.makeText(view.getContext(),name.getText().toString(),Toast.LENGTH_SHORT).show();
        DBHandler db = new DBHandler(view.getContext());
        Utilities.events = new ArrayList<Events>();
        Utilities.events = db.getEventsByCluster(Utilities.clusters[getPosition()]);
        i = new Intent(view.getContext(),Events_list.class);
        view.getContext().startActivity(i);


    }
}