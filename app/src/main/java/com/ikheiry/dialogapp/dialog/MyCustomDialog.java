package com.ikheiry.dialogapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ikheiry.dialogapp.R;

public class MyCustomDialog extends DialogFragment {

    private EditText txtUsername, txtPassword;
    private OnLoginListener loginListener;

    public interface OnLoginListener {
        public void onLogin(String message);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog_layout, null);
        builder.setView(view);

        txtUsername = view.findViewById(R.id.user_name);
        txtPassword = view.findViewById(R.id.user_password);

        builder.setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    if (username.equals(getActivity().getResources().getString(R.string.username)) &&
                            password.equals(getActivity().getResources().getString(R.string.password))) {
                        loginListener.onLogin("Welcome " + getActivity().getResources().getString(R.string.user_real_name));
                    } else {
                        loginListener.onLogin("Sorry, login failed!");
                    }
                } else
                    loginListener.onLogin("Username or Password cannot be empty!");
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Operation cancled!", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            loginListener = (OnLoginListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnLoginListener methods");
        }
    }
}
