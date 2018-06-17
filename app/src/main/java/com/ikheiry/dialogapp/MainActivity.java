package com.ikheiry.dialogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ikheiry.dialogapp.dialog.FireMissileFragment;
import com.ikheiry.dialogapp.dialog.MyDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialog(View view) {
        new MyDialog().show(getSupportFragmentManager(), "simpledialog");

    }
}
