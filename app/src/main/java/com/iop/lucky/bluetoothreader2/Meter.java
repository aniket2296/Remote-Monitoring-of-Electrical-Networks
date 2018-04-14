package com.iop.lucky.bluetoothreader2;

public class Meter {
    private String title;
    private float value;
    private String unit;
    private float max;
    private float min;

    public Meter() {
        min = 0;
    }

    public Meter(String title, String unit, float max) {
        this.title = title;
        this.unit = unit;
        this.min = 0;
        this.max = max;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMin() {
        return this.min;
    }

    public float getMax() {
        return this.max;
    }

    public float getValue() {
        return this.value;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUnit() {
        return this.unit;
    }
}
