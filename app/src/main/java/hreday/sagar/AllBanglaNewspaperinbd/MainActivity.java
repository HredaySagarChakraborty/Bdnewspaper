package hreday.sagar.AllBanglaNewspaperinbd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;

import hreday.sagar.AllBanglaNewspaperinbd.Bangla.BbcBangla;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Bdnews24;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Bdprotidin;
import hreday.sagar.AllBanglaNewspaperinbd.English.China;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Dhakatimes;
import hreday.sagar.AllBanglaNewspaperinbd.English.Gurdian;
import hreday.sagar.AllBanglaNewspaperinbd.English.India;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Ittefaq;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Jaijaidin;
import hreday.sagar.AllBanglaNewspaperinbd.English.Japan;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Jonokontho;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Jugantor;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Kalerkontho;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Manobjomin;
import hreday.sagar.AllBanglaNewspaperinbd.English.Newwork;
import hreday.sagar.AllBanglaNewspaperinbd.English.Pakistan;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.ProthomAlo;
import hreday.sagar.AllBanglaNewspaperinbd.Bangla.Somokal;
import hreday.sagar.AllBanglaNewspaperinbd.English.Sydney;
import hreday.sagar.AllBanglaNewspaperinbd.English.Turkey;
import hreday.sagar.AllBanglaNewspaperinbd.English.Washinton;
import hreday.sagar.AllBanglaNewspaperinbd.English.World;
import hreday.sagar.AllBanglaNewspaperinbd.Fragments.Bangla;
import hreday.sagar.AllBanglaNewspaperinbd.Fragments.English;
import hreday.sagar.AllBanglaNewspaperinbd.Fragments.Job;
import hreday.sagar.AllBanglaNewspaperinbd.Fragments.LiveTv;
import hreday.sagar.AllBanglaNewspaperinbd.Fragments.Sports;
import hreday.sagar.AllBanglaNewspaperinbd.Job.Bdjobs;
import hreday.sagar.AllBanglaNewspaperinbd.Job.ChakriJob;
import hreday.sagar.AllBanglaNewspaperinbd.Job.GovtJobs;
import hreday.sagar.AllBanglaNewspaperinbd.Job.JobJobJob;
import hreday.sagar.AllBanglaNewspaperinbd.Job.Jobs;
import hreday.sagar.AllBanglaNewspaperinbd.Job.PartTimeJobs;
import hreday.sagar.AllBanglaNewspaperinbd.Job.PrivateJobs;
import hreday.sagar.AllBanglaNewspaperinbd.Job.Weekly;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.AtnNews;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.Bioscope;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.Channel24;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.Gtv;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.Jagobd;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.Jamuna;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.Live2;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.Ntv;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.Rtv;
import hreday.sagar.AllBanglaNewspaperinbd.LiveTelevision.SomoiTv;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.Bddailysports;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.Bdnews24Sports;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.Crickbuzz;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.DhakaTimesSports;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.IttefaqSports;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.JugantorSports;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.Kalerkonthosports;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.Prothomalosports;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.SkySports;
import hreday.sagar.AllBanglaNewspaperinbd.Sports.SomokalSports;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //  private  ProgressBar progressBar;

    private ProgressBar progressBar;
    private int progress;

    private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);



                tabLayout = findViewById(R.id.tab);
                viewPager = findViewById(R.id.viewPagerId);
                viewPager.setAdapter(new MypagerAdapter(getSupportFragmentManager()));
                tabLayout.setupWithViewPager(viewPager);

                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    class MypagerAdapter extends FragmentPagerAdapter {

        String[] name = {"বাংলা","লাইভ টিভি","ইংরেজি","খেলাধুলা","চাকরী"};


        public MypagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            if (position == 0) {

                return new Bangla();

            }

            if (position == 1) {

                return new LiveTv();

            }
            if (position == 2) {

                return new English();

            }
            if (position == 3) {

                return new Sports();

            }

            if (position == 4) {

                return new Job();

            }




            return null;
        }

        @Override
        public int getCount() {
            return name.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return name[position];
        }
    }

    public void prothomAlo(View v) {


        Intent intent = new Intent(MainActivity.this, ProthomAlo.class);
        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();


        startActivity(intent);


    }


    public void Bbcbangla(View v) {
        Intent intent = new Intent(MainActivity.this, BbcBangla.class);
        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void Bdnews(View v) {
        Intent intent = new Intent(MainActivity.this, Bdnews24.class);
        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void DhakaTimes(View v) {
        Intent intent = new Intent(MainActivity.this, Dhakatimes.class);
        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);
        //   Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_SHORT).show();

    }

    public void Ittefaq(View v) {
        Intent intent = new Intent(MainActivity.this, Ittefaq.class);
        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void Jaijaidin(View v) {
        Intent intent = new Intent(MainActivity.this, Jaijaidin.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void jonokontho(View v) {
        Intent intent = new Intent(MainActivity.this, Jonokontho.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void Jugantor(View v) {
        Intent intent = new Intent(MainActivity.this, Jugantor.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void Kalerkontho(View v) {
        Intent intent = new Intent(MainActivity.this, Kalerkontho.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void Manobjomin(View v) {
        Intent intent = new Intent(MainActivity.this, Manobjomin.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void Bdprotidin(View v) {
        Intent intent = new Intent(MainActivity.this, Bdprotidin.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void Somokal(View v) {
        Intent intent = new Intent(MainActivity.this, Somokal.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void gurdian(View v) {
        Intent intent = new Intent(MainActivity.this, Gurdian.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void worls_street(View v) {
        Intent intent = new Intent(MainActivity.this, World.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void washington(View v) {
        Intent intent = new Intent(MainActivity.this, Washinton.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void newwork(View v) {
        Intent intent = new Intent(MainActivity.this, Newwork.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void china(View v) {
        Intent intent = new Intent(MainActivity.this, China.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void times_of_india(View v) {
        Intent intent = new Intent(MainActivity.this, India.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void sydney(View v) {
        Intent intent = new Intent(MainActivity.this, Sydney.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void japan(View v) {
        Intent intent = new Intent(MainActivity.this, Japan.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void dawn(View v) {
        Intent intent = new Intent(MainActivity.this, Pakistan.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void zaman(View v) {
        Intent intent = new Intent(MainActivity.this, Turkey.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }


    public void prothomAloSports(View v) {
        Intent intent = new Intent(MainActivity.this, Prothomalosports.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void dhakatimesSports(View v) {
        Intent intent = new Intent(MainActivity.this, DhakaTimesSports.class);
        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void IttefaqSports(View v) {
        Intent intent = new Intent(MainActivity.this, IttefaqSports.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void JugantorSports(View v) {
        Intent intent = new Intent(MainActivity.this, JugantorSports.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void SomokalSports(View v) {
        Intent intent = new Intent(MainActivity.this, SomokalSports.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void BdprotidinSports(View v) {
        Intent intent = new Intent(MainActivity.this, Bddailysports.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void BdnewsSports(View v) {
        Intent intent = new Intent(MainActivity.this, Bdnews24Sports.class);

        //  Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }


    public void KalerkonthoSports(View v) {
        Intent intent = new Intent(MainActivity.this, Kalerkonthosports.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }


    public void privatejob(View v) {
        Intent intent = new Intent(MainActivity.this, PrivateJobs.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void job(View v) {
        Intent intent = new Intent(MainActivity.this, Jobs.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

    public void govt(View v) {
        Intent intent = new Intent(MainActivity.this, GovtJobs.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }

    public void part(View v) {
        Intent intent = new Intent(MainActivity.this, PartTimeJobs.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }


    public void Crickbuzz(View v) {
        Intent intent = new Intent(MainActivity.this, Crickbuzz.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }


    public void skySports(View v) {
        Intent intent = new Intent(MainActivity.this, SkySports.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }

    public void Bdjob(View v) {
        Intent intent = new Intent(MainActivity.this, Bdjobs.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }

    public void Weekly(View v) {
        Intent intent = new Intent(MainActivity.this, Weekly.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }

    public void Chaki(View v) {
        Intent intent = new Intent(MainActivity.this, ChakriJob.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }

    public void Jobbbs(View v) {
        Intent intent = new Intent(MainActivity.this, JobJobJob.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }



    public void LiveTv (View v) {
        Intent intent = new Intent(MainActivity.this, Jagobd.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }




    public void Gtv (View v) {
        Intent intent = new Intent(MainActivity.this, Gtv.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }


    public void Bioscope  (View v) {
        Intent intent = new Intent(MainActivity.this, Bioscope.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }

    public void AtnNews  (View v) {
        Intent intent = new Intent(MainActivity.this, AtnNews.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }


    public void Channel24  (View v) {
        Intent intent = new Intent(MainActivity.this, Channel24.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }


    public void Somoi  (View v) {
        Intent intent = new Intent(MainActivity.this, SomoiTv.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }


    public void Rtv  (View v) {
        Intent intent = new Intent(MainActivity.this, Rtv.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }


    public void Ntv  (View v) {
        Intent intent = new Intent(MainActivity.this, Ntv.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }

    public void Jamuna  (View v) {
        Intent intent = new Intent(MainActivity.this, Jamuna.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }

    public void Live2  (View v) {
        Intent intent = new Intent(MainActivity.this, Live2.class);

        Toast.makeText(this, "Please wait a few seconds it's loading", Toast.LENGTH_LONG).show();

        startActivity(intent);

    }







}
