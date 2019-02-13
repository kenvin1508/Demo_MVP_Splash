package vn.edu.vtn.demo_mvp_splash;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.edu.vtn.demo_mvp_splash.db.prefs.SharedPrefsHelper;
import vn.edu.vtn.demo_mvp_splash.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Button btnLogOut;
    SharedPrefsHelper sharedPrefsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefsHelper = new SharedPrefsHelper(MainActivity.this);
                sharedPrefsHelper.setLoggedin(false, "");
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void addControls() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        btnLogOut = findViewById(R.id.btnOut);
        FragmentManager manager = getSupportFragmentManager();
        MainFragmentPagerAdapter mainFragmentPagerAdapter = new MainFragmentPagerAdapter(this, manager);

        viewPager.setAdapter(mainFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
