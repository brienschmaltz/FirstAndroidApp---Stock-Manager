package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
//import java.InputStreamReader;
//******************ShareManager is the model*************************


public class ShareManager {

    private float u_shares; //Number of shares user inputs
    public float getShares() {
        return u_shares;
    }
    public void setShares(float u_shares) {
        this.u_shares = u_shares;
    }
    private float stock_Price; // StockPrice given from user
    public float getStockPrice() {
        return stock_Price;
    }
    public void setStockPrice(float stock_Price) {
        this.stock_Price = stock_Price;
    }
    private float fStockPrice; // Final Stock Price
    public float getfStockPrice() {
        return fStockPrice;
    }
    public void setfStockPrice(float fStockPrice) {
        this.fStockPrice = fStockPrice;
    }

    public float calculatefStockPrice(float stock_Price, float u_shares) {
        return (stock_Price * u_shares);
    }
    /*public void startScrapper() throws IOException {
         https://markets.businessinsider.com/stocks/gme-stock
        URL url = new URL("https://markets.businessinsider.com/stocks/gme-stock");
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        String line = buff.readLine();

        while(line != null) {
            System.out.println(line);
            line = buff.readLine();
        }

    } */

}
