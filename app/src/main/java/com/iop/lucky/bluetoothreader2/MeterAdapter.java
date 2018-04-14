package com.iop.lucky.bluetoothreader2;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.anastr.speedviewlib.SpeedView;

import java.util.List;

public class MeterAdapter extends RecyclerView.Adapter<MeterAdapter.MyViewHolder> {

    private List<Meter> metersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public SpeedView speedView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.meter_title);
            speedView = (SpeedView) view.findViewById(R.id.speedView);
        }
    }


    public MeterAdapter(List<Meter> metersList) {
        this.metersList = metersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meter_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Meter meter = metersList.get(position);
        if(holder.speedView.getMaxSpeed() != meter.getMax()) {
            holder.speedView.setMaxSpeed(meter.getMax());
            holder.speedView.setMinSpeed(meter.getMin());
            holder.speedView.setUnit(metersList.get(position).getUnit());
        }

        holder.title.setText(meter.getTitle());
        holder.speedView.speedTo(meter.getValue(), 500);
    }

    @Override
    public int getItemCount() {
        return metersList.size();
    }
}