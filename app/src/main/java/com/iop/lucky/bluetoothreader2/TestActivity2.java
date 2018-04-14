package com.iop.lucky.bluetoothreader2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;
import java.util.List;

public class TestActivity2 extends AppCompatActivity {

    private List<Meter> meterList = new ArrayList<>();
    private DiscreteScrollView discreteScrollView;
    private MeterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        discreteScrollView = (DiscreteScrollView) findViewById(R.id.picker);

        mAdapter = new MeterAdapter(meterList);

        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        discreteScrollView.setHasFixedSize(true);
//        discreteScrollView.setItemAnimator(new DefaultItemAnimator());
        discreteScrollView.setAdapter(mAdapter);
        discreteScrollView.setItemTransitionTimeMillis(10);

        prepareMeterData();
    }

    private void prepareMeterData() {
        Meter meter = new Meter("Ammeter", " Amperes", 5);
        meterList.add(meter);

        meter = new Meter("Voltmeter", " Volts", 300);
        meterList.add(meter);

        meter = new Meter("Wattmeter", " Watts", 300);
        meterList.add(meter);

        mAdapter.notifyDataSetChanged();
    }

}
