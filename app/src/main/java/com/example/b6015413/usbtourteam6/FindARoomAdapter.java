package com.example.b6015413.usbtourteam6;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class FindARoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    String[] items;

    public FindARoomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View findARoomRow = inflater.inflate(R.layout.find_a_room_row, viewGroup, false);

        Item findARoomRowItem = new Item(findARoomRow);

        return findARoomRowItem;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((Item)viewHolder).roomTextFARR.setText(items[i]);
        ((Item)viewHolder).getDirectionsFARR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GetDirections.class);
                context.startActivity(intent);
            }
        });
        //another button press for show on map - to be implemented later
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class Item extends RecyclerView.ViewHolder {
        //defining objects in the custom row xml files
        TextView roomTextFARR;
        Button getDirectionsFARR, showOnMapFARR;

        //adding font for recycler view to use
        AssetManager am = context.getApplicationContext().getAssets();
        Typeface robotoLight = Typeface.createFromAsset(am,String.format(Locale.UK,"fonts/%s","Roboto-Light.ttf"));

        public Item(View itemView) {
            super(itemView);
            //findViewById for all objects defined above
            //Find A Room
            roomTextFARR = itemView.findViewById(R.id.roomText);
            getDirectionsFARR = itemView.findViewById(R.id.getDirectionsBtn);
            showOnMapFARR = itemView.findViewById(R.id.showOnMapBtn);

            //setting font for objects
            //Find A Room
            roomTextFARR.setTypeface(robotoLight);
            getDirectionsFARR.setTypeface(robotoLight);
            showOnMapFARR.setTypeface(robotoLight);


        }
    }

}
