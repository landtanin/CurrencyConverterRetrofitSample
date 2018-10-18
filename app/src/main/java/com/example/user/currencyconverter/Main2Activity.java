package com.example.user.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView USD, AUD, THB, EUR, CNY, JPY, BGN, BRL, CAD, CHF, DKK;

    /** input and output all created rates value
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        USD = (TextView) findViewById(R.id.rateUSD);
        Double A = getIntent().getDoubleExtra("usdnaja", 0.0);
        String AA = String.valueOf(A);
        USD.setText("USD Rate "+" = "+AA);

        AUD = (TextView) findViewById(R.id.rateAUD);
        Double B = getIntent().getDoubleExtra("audnaja", 0.0);
        String BB = String.valueOf(B);
        AUD.setText("AUD Rate "+" = "+BB);

        THB = (TextView) findViewById(R.id.rateTHB);
        Double C = getIntent().getDoubleExtra("thbnaja", 0.0);
        String CC = String.valueOf(C);
        THB.setText("THB Rate "+" = "+CC);

        EUR = (TextView) findViewById(R.id.rateEUR);
        Double D = getIntent().getDoubleExtra("eurnaja", 0.0);
        String DD = String.valueOf(D);
        EUR.setText("EUR Rate "+" = "+DD);

        CNY = (TextView) findViewById(R.id.rateCNY);
        Double E = getIntent().getDoubleExtra("cnynaja", 0.0);
        String EE = String.valueOf(E);
        CNY.setText("CNY Rate "+" = "+EE);

        JPY = (TextView) findViewById(R.id.rateJPY);
        Double F = getIntent().getDoubleExtra("jpynaja", 0.0);
        String FF = String.valueOf(F);
        JPY.setText("JPY Rate "+" = "+FF);

        BGN = (TextView) findViewById(R.id.rateBGN);
        Double G = getIntent().getDoubleExtra("bgnnaja", 0.0);
        String GG = String.valueOf(G);
        BGN.setText("BGN Rate "+" = "+GG);

        BRL = (TextView) findViewById(R.id.rateBRL);
        Double H = getIntent().getDoubleExtra("brlnaja", 0.0);
        String HH = String.valueOf(H);
        BRL.setText("BRL Rate "+" = "+HH);

        CAD = (TextView) findViewById(R.id.rateCAD);
        Double I = getIntent().getDoubleExtra("cadnaja", 0.0);
        String II = String.valueOf(I);
        CAD.setText("CAD Rate "+" = "+II);

        CHF = (TextView) findViewById(R.id.rateCHF);
        Double J = getIntent().getDoubleExtra("chfnaja", 0.0);
        String JJ = String.valueOf(J);
        CHF.setText("CHF Rate "+" = "+JJ);

        DKK = (TextView) findViewById(R.id.rateDKK);
        Double K = getIntent().getDoubleExtra("dkknaja", 0.0);
        String KK = String.valueOf(K);
        DKK.setText("DKK Rate "+" = "+KK);


    }
}
