package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    private ShareManager m_Share = new ShareManager();
    private EditText numberShares, priceShares, finalPrice;
    private Button mButton, cButton, gButton;
    private String pShare,nShare;
    private float pS,nS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Controller loads the view. ***Main Activity is the Controller. *** activity_main.xml is the vew.*** ShareManager is model**

        //Connects buttons,EditText a variable you can modify.
        numberShares = findViewById(R.id.uiNumberofShares);
        priceShares = findViewById(R.id.uiSharePrice);
        mButton = findViewById(R.id.button);
        cButton = findViewById(R.id.button2);
        gButton = findViewById(R.id.button3);
        finalPrice = findViewById(R.id.uiFinalSharePrice);
        //Adds Text Listeners
        numberShares.addTextChangedListener(this);
        priceShares.addTextChangedListener(this);
        finalPrice.addTextChangedListener(this);


        // Attaching OnClick listener to the Get gme price
        /* initiates scraper.
        gButton.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View v) {
                try {
                    m_Share.startScrapper();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        */

        // Attaching OnClick listener to the Clear button
        // Clears values.
        cButton.setOnClickListener(new View.OnClickListener()  {
            public void onClick(View v) {
                String tmp = "";
                numberShares.setText(tmp);
                priceShares.setText(tmp);
                finalPrice.setText(tmp);
            }
        });

        // Attaching OnClick listener to the Calculate button
        // When Clicked, Method Onclick will be called and execute the math. SharePrice * #ofShares
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gather user input.
                pShare = priceShares.getText().toString();
                nShare = numberShares.getText().toString();

                //Convert string to float from user input. The send the data to the model.
                pS = Float.parseFloat(pShare);
                m_Share.setShares(pS);

                //Convert string to float from user input. The send the data to the model.
                nS = Float.parseFloat(nShare);
                m_Share.setStockPrice(nS);

                //Calculates final price and updates the finalPrice text box to reflect the final price.
                String fS = Float.toString(m_Share.calculatefStockPrice(nS,pS));
                finalPrice.setText(fS);

                //System.out.printf("%.2f", fPrice); //For my debugging purposes, keeps track of finalPrice.
            }
        });
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
//Method needed to get string from text field.
    @Override
    public void afterTextChanged(Editable s) {

    }
}