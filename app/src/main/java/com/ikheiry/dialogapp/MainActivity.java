package com.ikheiry.dialogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ikheiry.dialogapp.dialog.MyCustomDialog;
import com.ikheiry.dialogapp.dialog.MyThirdDialog;

public class MainActivity extends AppCompatActivity implements MyCustomDialog.OnLoginListener {

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.dialog_response);
    }

    public void openDialog(View view) {
        MyCustomDialog customDialog = new MyCustomDialog();
        customDialog.show(getSupportFragmentManager(), "custom_dialog");

    }

    @Override
    public void onLogin(String message) {
        display.setText(message);
    }
}
