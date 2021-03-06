package com.ikheiry.dialogapp.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.ikheiry.dialogapp.R;

import java.util.ArrayList;
import java.util.List;

public class MySecondDialog extends DialogFragment{

    private List<String> mSelectedItems;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mSelectedItems = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick your toppings");

        builder.setMultiChoiceItems(R.array.toppings, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                String[] items = getActivity().getResources().getStringArray(R.array.toppings);

                if(b){
                    mSelectedItems.add(items[i]);
                }else {
                    mSelectedItems.remove(items[i]);
                }
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String final_selection = "";
                for (String item : mSelectedItems){
                    final_selection += "\n" + item;
                }
                Toast.makeText(getActivity(), "Selection : " + final_selection, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(),"Operation cancled!", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }

}
