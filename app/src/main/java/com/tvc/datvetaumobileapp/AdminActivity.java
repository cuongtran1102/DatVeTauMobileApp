package com.tvc.datvetaumobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import Fragment.*;

public class AdminActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private static final int FRAGMENT_QLCHUYENTAU = 0, FRAGMENT_QLTUYENDUONG = 1, FRAGMENT_QLTAIKHOAN = 2,
            FRAGMENT_THONGKE = 3, FRAGMENT_EDITPROFILE = 4;
    private int currentFragment;
    private Context context = this;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        init();

        replaceFragment(new FragmentQuanLyChuyenTau());
        navigationView.getMenu().findItem(R.id.nav_quan_ly_chuyen_tau).setChecked(true);
    }
    private void init(){
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_quan_ly_chuyen_tau) {
            if (currentFragment != FRAGMENT_QLCHUYENTAU) {
                replaceFragment(new FragmentQuanLyChuyenTau());
                currentFragment = FRAGMENT_QLCHUYENTAU;
            }
        }
        else if(id == R.id.nav_quan_ly_tuyen_duong){
                if(currentFragment != FRAGMENT_QLTUYENDUONG){
                    replaceFragment(new FragmentQuanLyTuyenDuong());
                    currentFragment = FRAGMENT_QLTUYENDUONG;
                }
            }
        else if(id == R.id.nav_quan_ly_tai_khoan){
            if(currentFragment != FRAGMENT_QLTAIKHOAN){
                replaceFragment(new FragmentQuanLyTaiKhoan());
                currentFragment = FRAGMENT_QLTAIKHOAN;
            }
        }
        else if(id == R.id.nav_thong_ke){
            if(currentFragment != FRAGMENT_THONGKE){
                replaceFragment(new FragmentThongKeBaoCao());
                currentFragment = FRAGMENT_THONGKE;
            }
        }
        else if(id == R.id.nav_edit_profile){
            if(currentFragment != FRAGMENT_EDITPROFILE){
                replaceFragment(new FragmentEditProfile());
                currentFragment = FRAGMENT_EDITPROFILE;
            }
        }
        else{

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentFrame, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}