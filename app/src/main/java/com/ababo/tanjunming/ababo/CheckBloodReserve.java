package com.ababo.tanjunming.ababo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class CheckBloodReserve extends AppCompatActivity {

    private VerticalProgressBar aPlusLevel;
    private VerticalProgressBar bPlusLevel;
    private VerticalProgressBar oPlusLevel;
    private VerticalProgressBar abPlusLevel;
    private VerticalProgressBar aNegLevel;
    private VerticalProgressBar bNegLevel;
    private VerticalProgressBar oNegLevel;
    private VerticalProgressBar abNegLevel;
    private TextView lastUpdateView;

    private String lastBloodStockUpdate;
    private GetBloodStock mGetBloodStock;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(CheckBloodReserve.this, MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(CheckBloodReserve.this, Donate.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(CheckBloodReserve.this, Explore.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_blood_reserve);

        mGetBloodStock = new GetBloodStock();
        mGetBloodStock.execute((Void) null);

        aPlusLevel = (VerticalProgressBar) findViewById(R.id.aplus);
        aPlusLevel.setProgress(95);
        bPlusLevel = (VerticalProgressBar) findViewById(R.id.bplus);
        bPlusLevel.setProgress(97);
        oPlusLevel = (VerticalProgressBar) findViewById(R.id.oplus);
        oPlusLevel.setProgress(100);
        abPlusLevel = (VerticalProgressBar) findViewById(R.id.abplus);
        abPlusLevel.setProgress(100);
        aNegLevel = (VerticalProgressBar) findViewById(R.id.aneg);
        aNegLevel.setProgress(49);
        bNegLevel = (VerticalProgressBar) findViewById(R.id.bneg);
        bNegLevel.setProgress(67);
        oNegLevel = (VerticalProgressBar) findViewById(R.id.oneg);
        oNegLevel.setProgress(16);
        abNegLevel = (VerticalProgressBar) findViewById(R.id.abneg);
        abNegLevel.setProgress(50);

        lastUpdateView = (TextView) findViewById(R.id.lastupdate);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_notifications);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public class GetBloodStock extends AsyncTask<Void, Void, Boolean>{

        @Override
        protected Boolean doInBackground(Void... params) {

            try{
                Log.d(getClass().getName(), "started");
                String html = "https://redcross.sg";

                /*
                Document doc = DocumentBuilderFactory.newInstance()
                        .newDocumentBuilder().parse(new InputSource(new StringReader(html)));

                XPathExpression xpath = XPathFactory.newInstance()
                        .newXPath().compile("//td[text()=\"Description\"]/following-sibling::td[2]");

                htmlresult = (String) xpath.evaluate(doc, XPathConstants.STRING);*/


                org.jsoup.nodes.Document doc = Jsoup.connect(html).get();
                lastBloodStockUpdate = doc.select("#bloodbank-110 .last_update").first().text();
                lastUpdateView.setText(lastBloodStockUpdate);


                String apos = doc.select("#bloodbank-110").first().text();
                Log.d(getClass().getName(), apos);

            }
            catch (Exception e){
                Log.d(getClass().getName(), "crawling failed");
                Log.d(getClass().getName(), e.getMessage());
                return false;
            }

            return true;
        }
    }

}
