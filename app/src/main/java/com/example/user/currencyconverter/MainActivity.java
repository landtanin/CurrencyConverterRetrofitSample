package com.example.user.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.currencyconverter.manager.Contextor;
import com.example.user.currencyconverter.manager.HttpManager;
import com.example.user.currencyconverter.models.CollectionModel;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Double USDs, THBs, EURs, AUDs, JPYs, CNYs, BGNs, BRLs, CADs,CHFs, DKKs;
    private EditText THBBtn, GBPBtn, USDBtn, EURBtn, AUDBtn, JPYBtn, CNYBtn;
    Button b2 ;

    /**
     * Create connection from Retrofit classes (HttpManager)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        THBBtn = (EditText) findViewById(R.id.THB);
        GBPBtn = (EditText) findViewById(R.id.GBP);
        USDBtn = (EditText) findViewById(R.id.USD);
        EURBtn = (EditText) findViewById(R.id.EUR);
        AUDBtn = (EditText) findViewById(R.id.AUD);
        JPYBtn = (EditText) findViewById(R.id.JPY);
        CNYBtn = (EditText) findViewById(R.id.CNY);
        b2 = (Button) findViewById(R.id.rates);
        Contextor.getInstance().init(getApplicationContext());

        // Create connection from Retrofit classes (HttpManager)
        connectToDatabase();

    }


    /**
     * start connection (form the URL, add the query parameter which is a currency "GBP")
     * start Asynchronous connection to server
     * get the response string into object of CollectionModel class
    */
    private void connectToDatabase() {

        // start connection (form the URL, add the query parameter which is a currency "GBP")
        Call<CollectionModel> call = HttpManager.getInstance().getService().exchangeRates("GBP");

        // start Asynchronous connection to server
        call.enqueue(new Callback<CollectionModel>() {
            @Override
            public void onResponse(Call<CollectionModel> call, Response<CollectionModel> response) {

                if (response.isSuccessful()) {

                    // get the response string into object of CollectionModel class
                    CollectionModel testModel = response.body();
                    USDs = testModel.getRates().getUSD();
                    THBs = testModel.getRates().getTHB();
                    EURs = testModel.getRates().getEUR();
                    AUDs = testModel.getRates().getAUD();
                    CNYs = testModel.getRates().getCNY();
                    JPYs = testModel.getRates().getJPY();
                    BGNs = testModel.getRates().getBGN();
                    BRLs = testModel.getRates().getBRL();
                    CADs = testModel.getRates().getCAD();
                    CHFs = testModel.getRates().getCHF();
                    DKKs = testModel.getRates().getDKK();
                    //Toast.makeText(MainActivity.this, USDs.toString() + THBs.toString() + EURs.toString(), Toast.LENGTH_SHORT).show();

                    // show response in case of having "errors"
                } else {
                    try {
                        Toast.makeText(MainActivity.this, "error " + response.errorBody().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //show response in case "failed"
            @Override
            public void onFailure(Call<CollectionModel> call, Throwable t) {

                Toast.makeText(MainActivity.this, "failed " + t.toString(), Toast.LENGTH_SHORT).show();

            }

        });
    }

    /**
     * "ConvertGBP" button
     * Create "EditText" for each currency
     */
    void  convertGBP()
    {
        // Create "EditText" for each currency
        EditText THB = (EditText) findViewById(R.id.THB);
        THB.setInputType(InputType.TYPE_CLASS_NUMBER);

        EditText GBP = (EditText) findViewById(R.id.GBP);
        GBP.setInputType(InputType.TYPE_CLASS_NUMBER);

        EditText USD = (EditText) findViewById(R.id.USD);
        USD.setInputType(InputType.TYPE_CLASS_NUMBER);

        EditText EUR = (EditText) findViewById(R.id.EUR);
        EUR.setInputType(InputType.TYPE_CLASS_NUMBER);

        EditText AUD = (EditText) findViewById(R.id.AUD);
        AUD.setInputType(InputType.TYPE_CLASS_NUMBER);

        EditText CNY = (EditText) findViewById(R.id.CNY);
        CNY.setInputType(InputType.TYPE_CLASS_NUMBER);

        EditText JPY = (EditText) findViewById(R.id.JPY);
        JPY.setInputType(InputType.TYPE_CLASS_NUMBER);

        // User's input*rates and show result
        double a = Double.parseDouble(GBP.getText().toString());
        double result = a*THBs;
        THB.setText(String.valueOf("THB = " + result));

        double b = Double.parseDouble(GBP.getText().toString());
        double result2 = b*USDs;
        USD.setText(String.valueOf("USD = " + result2));

        double c = Double.parseDouble(GBP.getText().toString());
        double result3 = c*EURs;
        EUR.setText(String.valueOf("EUR = " + result3));

        double d = Double.parseDouble(GBP.getText().toString());
        double result4 = d*AUDs;
        AUD.setText(String.valueOf("AUD = " + result4));

        double e = Double.parseDouble(GBP.getText().toString());
        double result5 = e*CNYs;
        CNY.setText(String.valueOf("CNY = " + result5));

        double f = Double.parseDouble(GBP.getText().toString());
        double result6 = f*JPYs;
        JPY.setText(String.valueOf("JPY = " + result6));
    }


    /**
     * When click on "convertGBP" button
     */
    public void click1(View view)
    {
        connectToDatabase();
        convertGBP();
        Button b1 = (Button) findViewById(R.id.convert1);
        b1.setEnabled(false);
    }

    /**
     * "Reset" button to clear all Texts
     * @param view
     */
    public  void reset(View view)
    {
        Button b1 = (Button) findViewById(R.id.convert1);
        b1.setEnabled(true);

        THBBtn.setText("");
        GBPBtn.setText("");
        USDBtn.setText("");
        EURBtn.setText("");
        AUDBtn.setText("");
        CNYBtn.setText("");
        JPYBtn.setText("");

    }

    /**
     * Response when click on "Rates" button by using "putExtra" to send the all created rates value
     * "Intent" to "Main2Activity"
     * @param view
     */
    public void rates(View view)
    {
        // "Intent" to "Main2Activity"
        Intent Main2Activity = new Intent(this,Main2Activity.class);

        Main2Activity.putExtra("usdnaja",USDs);
        Main2Activity.putExtra("thbnaja",THBs);
        Main2Activity.putExtra("audnaja",AUDs);
        Main2Activity.putExtra("eurnaja",EURs);
        Main2Activity.putExtra("cnynaja",CNYs);
        Main2Activity.putExtra("jpynaja",JPYs);
        Main2Activity.putExtra("bgnnaja",BGNs);
        Main2Activity.putExtra("brlnaja",BRLs);
        Main2Activity.putExtra("cadnaja",CADs);
        Main2Activity.putExtra("chfnaja",CHFs);
        Main2Activity.putExtra("dkknaja",DKKs);

        b2.setEnabled(true);
        startActivity(Main2Activity);
    }
}
