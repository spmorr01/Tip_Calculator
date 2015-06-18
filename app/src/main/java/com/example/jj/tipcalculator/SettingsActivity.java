package com.example.jj.tipcalculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by jj on 6/11/15.
 */
public class SettingsActivity extends Activity {

    NumberFormat decimalFormat;
    TextView defaultTextView;
    TextView defaultTipView;
    TextView dollarSign;
    EditText defaultTipEdit;
    TextView defaultSplitView;
    EditText defaultSplitEdit;
    double defaultTipInDouble;
    int defaultSplitIn, defaultTipIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity_layout);
        decimalFormat = new DecimalFormat("#0.00");
        defaultTextView = (TextView) findViewById(R.id.defaultTextView);
        defaultTipView = (TextView) findViewById(R.id.defaultTipTextView);
        dollarSign = (TextView) findViewById(R.id.defaultDollarSign);
        defaultTipEdit = (EditText) findViewById(R.id.defaultTipEditText);
        defaultSplitView = (TextView) findViewById(R.id.defaultSplitTextView);
        defaultSplitEdit = (EditText) findViewById(R.id.defaultSplitEditText);
        loadPreferences();
        defaultTipIn = Integer.parseInt(defaultTipEdit.getText().toString());
        defaultTipInDouble = ((double) defaultTipIn / 100);
        defaultSplitIn = Integer.parseInt(defaultSplitEdit.getText().toString());
    }

    private void loadPreferences(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int tipValue = sp.getInt("TIPAMOUNT", 20);
        int splitValue = sp.getInt("SPLITAMOUNT", 1);
        defaultTipEdit.setText(tipValue);
        defaultSplitEdit.setText(splitValue);
    }

    private void saveTipPreferences(String key, Integer value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    private void saveSplitPreferences(String key, Integer value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public void onSaveSettingsButtonClick(View v){
        saveTipPreferences("TIPAMOUNT", Integer.parseInt(defaultTipEdit.getText().toString()));
        saveTipPreferences("SPLITAMOUNT", Integer.parseInt(defaultSplitEdit.getText().toString()));

    finish();
    }
}
