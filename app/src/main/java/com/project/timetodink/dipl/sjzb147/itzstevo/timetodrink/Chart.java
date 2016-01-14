package com.project.timetodink.dipl.sjzb147.itzstevo.timetodrink;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.Arrays;

/**
 * Created by Stevo on 4.3.2015..
 */
public class Chart extends ActionBarActivity {

    public static final String PREFS = "examplePrefs";
    private View mChart;

    float maxAmount = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //prikazuje sterlicu za povratak
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        openChart();

    }

    private void openChart(){

        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        //SharedPreferences example = getSharedPreferences(PREFS, 0);
        //Float userFloatReset = example.getFloat("userMessageReset", 0);


        WaterDBHelper dbHelper = new WaterDBHelper(getBaseContext());
        Cursor cursor = dbHelper.getWaterRows();
        int count = cursor.getCount();
        if (count > 7)
            count = 7;

        //fildovi u koje ću spremiti pojedine podatke

        float[] amount = new float[7];
        String[] date = new String[7];
        Arrays.fill(amount, 0);
        Arrays.fill(date, "");
        int i = 0;
        while(cursor.moveToNext() && i < 7){
            amount[i] = cursor.getFloat(1);
             if (maxAmount<amount[i])
                 maxAmount=amount[i];
            date[i] = cursor.getString(2);
            i++;
        }



        CategorySeries series = new CategorySeries("Liquid");
        for (i = 0; i<7; i++ ) {
            series.add(amount[i]);
            multiRenderer.addXTextLabel(i+1,"\n\n\n\n\n" + date[i]);
        }

        //series.add(dayOne);
        /*series.add(1560);
        series.add(2000);
        series.add(950);
        */
        // for(int i=0; i < y.length; i++){
        //     series.add("Voda"+(i+1),y[i]);
        // }

        XYMultipleSeriesDataset dataSet = new XYMultipleSeriesDataset();  // collection of series under one object.,there could any
        dataSet.addSeries(series.toXYSeries());

        // Creating XYSeriesRenderer to customize incomeSeries
        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();
        incomeRenderer.setColor(getResources().getColor(R.color.primaryColor)); //color of the graph set to cyan
        // incomeRenderer.setFillPoints(true);
        //  incomeRenderer.setLineWidth(2);
        incomeRenderer.setDisplayChartValues(true);
        incomeRenderer.setChartValuesTextAlign(Paint.Align.RIGHT);
        incomeRenderer.setChartValuesTextSize(14);



        //incomeRenderer.setDisplayChartValuesDistance(10); //setting chart value distance


        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        // XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();

        // Adding incomeRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(incomeRenderer);

        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Entered liquid so far:");
        //multiRenderer.setXTitle("Year 2015");
        multiRenderer.setYTitle("Amount in ml");

        //multiRenderer.setBarSpacing(.2);
        multiRenderer.setBarWidth(45);

        multiRenderer.setXAxisMax(7);
        multiRenderer.setXAxisMin(0);
        multiRenderer.setYAxisMin(0);

        if (maxAmount < 1000)
            multiRenderer.setYAxisMax(1000);
        if (maxAmount > 1000)
            multiRenderer.setYAxisMax(2000);
        if (maxAmount > 2000)
            multiRenderer.setYAxisMax(3000);
        if (maxAmount > 3000)
            multiRenderer.setYAxisMax(4000);
        if (maxAmount > 4000)
            multiRenderer.setYAxisMax(5000);
        if (maxAmount > 5000)
            multiRenderer.setYAxisMax(6000);

        //Setting background color of the graph to transparent
        multiRenderer.setBackgroundColor(Color.TRANSPARENT);
        multiRenderer.setAxesColor(getResources().getColor(R.color.button_material_dark));
        multiRenderer.setLabelsColor(Color.BLACK);
        multiRenderer.setYLabelsColor(0, Color.BLACK);
        multiRenderer.setXLabelsColor(Color.BLACK);
        //Setting margin color of the graph to transparent
        multiRenderer.setMarginsColor(getResources().getColor(R.color.transparent_background));
        multiRenderer.setApplyBackgroundColor(true);
        multiRenderer.setChartTitleTextSize(20);
        multiRenderer.setAxisTitleTextSize(14);
        multiRenderer.setLabelsTextSize(20);
        multiRenderer.setLegendTextSize(20);
        //multiRenderer.setChartValuesTextSize(14);
        multiRenderer.setXLabelsAngle(315);
        multiRenderer.setMargins(new int[] {30, 40, 65, 0});



        multiRenderer.setPanEnabled(false, false);

        multiRenderer.setXLabelsPadding(20);
        multiRenderer.setXLabelsAlign(Paint.Align.CENTER);
        multiRenderer.setYAxisAlign(Paint.Align.LEFT, 0);
        multiRenderer.setYLabelsAlign(Paint.Align.LEFT, 0);


        multiRenderer.setXLabels(0);






        //this part is used to display graph on the xml
        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.chart);
        //remove any views before u paint the chart
        chartContainer.removeAllViews();
        //drawing bar chart
        mChart = ChartFactory.getBarChartView(Chart.this, dataSet, multiRenderer, BarChart.Type.DEFAULT);
        //adding the view to the linearlayout
        chartContainer.addView(mChart);

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_def, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        //ovim definiramo da ako je pritisnut home strelica vrati nas u naš parent activity s naredbom
        //NavUtils.navigateUP
        if (id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if ( keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            onBackPressed();
        }

        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {

        return;
    }

}