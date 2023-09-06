package com.tvc.datvetaumobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import Fragment.*;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout;
    private FrameLayout frameLayoutUser;
    private TabLayout tabLayoutUser;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        setFragment(new FragmentTraCuu());
        tabLayoutUser.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        setFragment(new FragmentTraCuu());
                        break;
                    case 1:
                        setFragment(new FragmentVeCuaToi());
                        break;
                    case 2:
                        setFragment(new FragmentTaiKhoan());
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                firebaseAuth.signOut();
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

    }
    private void init(){
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        frameLayoutUser = findViewById(R.id.frameLayoutUser);
        tabLayoutUser = findViewById(R.id.tabLayoutUser);
    }
    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayoutUser, fragment);
        transaction.commit();
    }
}