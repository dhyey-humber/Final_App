package com.ceng319.greenhousesystemproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.github.mikephil.charting.charts.BarChart;
        import com.github.mikephil.charting.data.BarData;
        import com.github.mikephil.charting.data.BarDataSet;
        import com.github.mikephil.charting.data.BarEntry;
        import com.github.mikephil.charting.utils.ColorTemplate;

        import java.util.ArrayList;

public class MainReadingsPageActivity extends AppCompatActivity {

    BarChart chart1 ;
    BarChart chart2 ;
    ArrayList<BarEntry> BARENTRY1 ;
    ArrayList<String> BarEntryLabels1 ;
    BarDataSet Bardataset1 ;
    BarData BARDATA1 ;
    ArrayList<BarEntry> BARENTRY2 ;
    ArrayList<String> BarEntryLabels2 ;
    BarDataSet Bardataset2 ;
    BarData BARDATA2 ;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_readings_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  btn1 = (Button) findViewById(R.id.tmpbtn);
        chart1 = (BarChart) findViewById(R.id.chart1);
        chart2 = (BarChart) findViewById(R.id.chart2);

        BARENTRY1 = new ArrayList<>();

        BarEntryLabels1 = new ArrayList<String>();

        BARENTRY2 = new ArrayList<>();

        BarEntryLabels2 = new ArrayList<String>();

        AddValuesToBARENTRY1();

        AddValuesToBarEntryLabels1();

        AddValuesToBARENTRY2();

        AddValuesToBarEntryLabels2();

        Bardataset1 = new BarDataSet(BARENTRY1, "Temperature Data");

        BARDATA1 = new BarData(BarEntryLabels1, Bardataset1);

        Bardataset1.setColors(ColorTemplate.COLORFUL_COLORS);

        Bardataset2 = new BarDataSet(BARENTRY2, "Soil Moisture Data");

        BARDATA2 = new BarData(BarEntryLabels2, Bardataset2);

        Bardataset2.setColors(ColorTemplate.COLORFUL_COLORS);

        chart1.setData(BARDATA1);
        chart2.setData(BARDATA2);

        chart1.animateY(3000);
        chart2.animateY(3000);

     /*   btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_register);
                Intent tmp_data = new Intent(HomeActivity.this, Temperature_data.class);
                startActivity(tmp_data);
            }
        });*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainreadingspage, menu);
        //globalmenu = menu;
        // setMenuItem(R.id.action_write, false);  // enable the write function.
        //setMenuItem(R.id.action_read, false);  // enable the write function.
        return true;
    }
    /*
    private void setMenuItem(int id, boolean enable){
        globalmenu.findItem(id).setEnabled(enable);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_TemperatureData)
        {
            // TODO: Start the read option.
            Intent temperatureData = new Intent(getApplicationContext(), TemperatureDataActivity.class);
            startActivity(temperatureData);
            return true;
        }
        else if (id == R.id.action_SoilMoistureData){
            // TODO: Start the write option.
            Intent soilMoistureData = new Intent(getApplicationContext(), SoilMoistureDataActivity.class);
            startActivity(soilMoistureData);
            return true;
        }
          return super.onOptionsItemSelected(item);
    }

    public void AddValuesToBARENTRY1(){

        BARENTRY1.add(new BarEntry(2f, 0));
        BARENTRY1.add(new BarEntry(4f, 1));
        BARENTRY1.add(new BarEntry(6f, 2));
        BARENTRY1.add(new BarEntry(8f, 3));
        BARENTRY1.add(new BarEntry(7f, 4));
        BARENTRY1.add(new BarEntry(3f, 5));

    }

    public void AddValuesToBarEntryLabels1(){

        BarEntryLabels1.add("January");
        BarEntryLabels1.add("February");
        BarEntryLabels1.add("March");
        BarEntryLabels1.add("April");
        BarEntryLabels1.add("May");
        BarEntryLabels1.add("June");

    }

    public void AddValuesToBARENTRY2(){

        BARENTRY2.add(new BarEntry(2f, 0));
        BARENTRY2.add(new BarEntry(5f, 1));
        BARENTRY2.add(new BarEntry(5f, 2));
        BARENTRY2.add(new BarEntry(5f, 3));
        BARENTRY2.add(new BarEntry(5f, 4));
        BARENTRY2.add(new BarEntry(1f, 5));

    }

    public void AddValuesToBarEntryLabels2(){

        BarEntryLabels2.add("Monday");
        BarEntryLabels2.add("Tuesday");
        BarEntryLabels2.add("Wednesday");
        BarEntryLabels2.add("Thursday");
        BarEntryLabels2.add("Friday");
        BarEntryLabels2.add("Saturday");

    }
}