package com.ikheiry.dialogapp.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.ikheiry.dialogapp.R;

public class MyDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] colors = getActivity().getResources().getStringArray(R.array.colors);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pic a color");

        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(),"Selected color : " + colors[i], Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }
}
