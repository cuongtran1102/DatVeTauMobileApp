package com.tvc.datvetaumobileapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import Service.DatePicker;
import Object.*;

public class EditProfileUserActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser mUser;
    private ImageButton btnBack;
    private Button btnUpdate;
    private EditText etName, etBirtOfDate;
    private Context context = this;
    private DatePicker datePicker;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_user);
        init();

        loadProfileUser();

        etBirtOfDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.showDatePickerDialog();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String ngaySinh = etBirtOfDate.getText().toString();
                if(name.isEmpty() || ngaySinh.isEmpty()){
                    Toast.makeText(context, "Hãy nhập đủ thông tin cần cập nhật", Toast.LENGTH_SHORT).show();
                }
                else {
                    updateProfile();
                    loadProfileUser();
                }
            }
        });
    }
    private void init(){
        database = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        mUser = firebaseAuth.getCurrentUser();

        btnBack = findViewById(R.id.btnBack_ProfileDetail);
        btnUpdate = findViewById(R.id.btnUpdate_ProfileDetail);
        etName = findViewById(R.id.etName_ProfileDetails);
        etBirtOfDate = findViewById(R.id.etNgaySinh_ProfileDetails);
        calendar = Calendar.getInstance();
        datePicker = new DatePicker(context, calendar, etBirtOfDate);
    }
    private void loadProfileUser(){
        DatabaseReference databaseReference = database.getReference("Users").
                child(mUser.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                etName.setText(user.getName());
                etBirtOfDate.setText(user.getDateOfBirth());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void updateProfile(){
        DatabaseReference databaseReference = database.getReference("Users").
                child(mUser.getUid());
        Map<String, Object> map =new HashMap<>();
        map.put("name", etName.getText().toString());
        map.put("dateOfBirth", etBirtOfDate.getText().toString());
        databaseReference.updateChildren(map, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if(error == null){
                    Toast.makeText(context, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}