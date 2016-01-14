package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Stevo on 28.3.2015..
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    List<InformationRecycleList> podatci = Collections.emptyList();

    //kako bi inflejtali to u taj row moramo stvorim konstruktor za inflater koji će to ubaciti
    public RecycleAdapter(Context context, List<InformationRecycleList> podatci) {
        inflater = LayoutInflater.from(context);
        this.podatci = podatci;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    //s onBindVireHolderom puninomo rowove s podatcima
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InformationRecycleList current = podatci.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }

    @Override
    public int getItemCount() {
        //prikazuje što je unutra ako je return 0 kao da nema ničega
        return podatci.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView icon;
        private Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.tvCustomText);
            icon = (ImageView) itemView.findViewById(R.id.ivCustomRow);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final Intent intent;
            switch (getPosition()){
                case 0:
                    intent =  new Intent(context, Calculator.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    intent =  new Intent(context, Alarm.class);
                    context.startActivity(intent);
                    break;
                case 2:
                    intent =  new Intent(context, Chart.class);
                    context.startActivity(intent);
                    break;
                case 3:
                    intent =  new Intent(context, ListFromDB.class);
                    context.startActivity(intent);
                    break;
            }
        }
    }


}
