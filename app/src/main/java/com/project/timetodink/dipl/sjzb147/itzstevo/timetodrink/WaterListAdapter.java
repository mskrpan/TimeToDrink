package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Ana on 26.3.2015..
 */
public class WaterListAdapter extends ArrayAdapter<String> {
    private ClickCallback mBack;
    private int resId;
    private int[] ids;
    private float[] amounts;
    private String[] dates;

    private Context cxt;

    private LayoutInflater inflater;

    public interface ClickCallback{
        public void onListClick();
    }

    public WaterListAdapter(Context context, int resourceId, int[] id, float[] amount, String[] date, ClickCallback cBack){
        super (context, resourceId, date);

        cxt = context;
        resId = resourceId;
        ids = id;
        amounts = amount;
        dates = date;
        this.mBack = cBack;

        inflater = (LayoutInflater) cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //save view id for later use
        convertView = inflater.inflate(resId, null);

        TextView tview1 = (TextView) convertView.findViewById(R.id.tvAmount);
        tview1.setText("Amount: "+ String.format("%.2f", amounts[position]) + " ml");

        TextView tview2 = (TextView) convertView.findViewById(R.id.tvDate);
        tview2.setText("Date: " + dates[position]);

        return convertView;
    }
}
