package com.example.dialogwindow;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class MyDialog extends DialogFragment {

    private MainActivity context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (MainActivity) context;
    }

    public Dialog onCreateDialog(Bundle saveInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String text = getArguments().getString("text");

        return builder.setTitle("Удаление")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Вы уверены что хотите удалить: " + text + "?")
                .setPositiveButton("Да", (dialog, which) -> context.remove(text))
                .setNegativeButton("Нет", null)
                .create();
    }
}
