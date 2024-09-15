package com.alura.conversorDeMoneda.Moduls;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi  {
    private String uri;



    private HttpClient client = HttpClient.newHttpClient();
    private Gson gson;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String json;
    CurrencyApi currencyApi;
    Currency currency;


    public ConsultaApi(String url) throws IOException, InterruptedException {
        this.uri = url;
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        this.request = HttpRequest
                .newBuilder()
                .uri(URI.create(uri))
                .build();
        this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
        this.json = response.body();
        this.currencyApi = gson.fromJson(json, CurrencyApi.class);
        this.currency = new Currency(this.currencyApi);
    }



    public double getData() {
        return currency.getCurrency();
    }
}
