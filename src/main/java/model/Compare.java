package model;

public class Compare {
    double firstValue;
    double secondValue;

    public Compare(double firstValue, double secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public Compare(String firstValue, String secondValue) {
        this.firstValue = Double.parseDouble(firstValue);
        this.secondValue = Double.parseDouble(secondValue);
    }


    public boolean getResult() {
        double max = Math.max(secondValue, firstValue);
        return Math.abs(secondValue - firstValue)/max * 100 < 30;
    }
}