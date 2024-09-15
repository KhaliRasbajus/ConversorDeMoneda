package com.alura.conversorDeMoneda.Moduls;

public class Currency {

    private double currency;

    public Currency(CurrencyApi currencyApi) {
        this.currency = currencyApi.conversion_result();
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }


}
