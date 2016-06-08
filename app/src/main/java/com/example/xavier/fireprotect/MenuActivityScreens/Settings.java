package com.example.xavier.fireprotect.MenuActivityScreens;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

import com.example.xavier.fireprotect.R;

/**
 * Created by xavier i dídac
 */

public class Settings extends AppCompatActivity {

    private Spinner timeRefreshMap;
    private Spinner timeSendData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        SharedPreferences prefe = getSharedPreferences("data", Context.MODE_PRIVATE);

        timeRefreshMap = (Spinner)findViewById(R.id.timeRefreshMap);
        timeRefreshMap.setSelection(prefe.getInt("spinnerSelectionMap", 0));

        timeSendData = (Spinner)findViewById(R.id.timeSendData);
        timeSendData.setSelection(prefe.getInt("spinnerSelectionSend", 0));

    }

    public void onClickSave(View view) {
        Snackbar.make(view, getString(R.string.saved), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        SharedPreferences preferences = getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        int selectedPositionMap = timeRefreshMap.getSelectedItemPosition();
        editor.putInt("spinnerSelectionMap", selectedPositionMap);

        int selectedPositionSend = timeSendData.getSelectedItemPosition();
        editor.putInt("spinnerSelectionSend", selectedPositionSend);
        editor.commit();

    }

}


