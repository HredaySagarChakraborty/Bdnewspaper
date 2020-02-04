package hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import hreday.sagar.AllBanglaNewspaperinbd.R;

public class SomoiTv extends AppCompatActivity {


    private WebView webView;

    private AdView adView;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somoi_tv);

        this.setTitle("Somoi Tv");
        getSupportActionBar().hide();


        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4248114886151875/2595314880");

        mInterstitialAd.loadAd(new AdRequest.Builder().build());





        webView=findViewById(R.id.webviewId);
        webView.loadUrl("https://www.youtube.com/watch?v=C6WYnrftqJ8&fbclid=IwAR2LpnuomQGCxZ5iPkBa1vydolMF2p_H3OZ2uGXfNWvyBuNf6ac3SvnpR-c");



        WebSettings webSettings = webView.getSettings();
        webView.setWebViewClient(new WebViewClient());
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
}
