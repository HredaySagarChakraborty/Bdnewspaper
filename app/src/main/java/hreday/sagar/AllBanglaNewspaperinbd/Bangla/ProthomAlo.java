package hreday.sagar.AllBanglaNewspaperinbd.Bangla;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import hreday.sagar.AllBanglaNewspaperinbd.R;

public class ProthomAlo extends AppCompatActivity {
    private WebView mWeb;
    private ProgressBar progressBar;
    private AdView adView;
    private InterstitialAd mInterstitialAd;
   // private AlertDialog.Builder alert;

    ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prothom_alo);

        getSupportActionBar().hide();


        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4248114886151875/2595314880");

        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        this.setTitle("Prothom Alo");


        mWeb = findViewById(R.id.webviewId);
        mWeb.loadUrl("https://www.prothomalo.com");
        progressBar = findViewById(R.id.progressId);


        WebSettings webSettings = mWeb.getSettings();

        mWeb.setWebViewClient(new WebViewClient());
        webSettings.setJavaScriptEnabled(true);



    }

    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }
            });
        } else {
            super.onBackPressed();
        }
    }


//pDialog.dismiss();

}
