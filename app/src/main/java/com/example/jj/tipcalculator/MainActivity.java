package com.example.jj.tipcalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends ActionBarActivity {

    TextView checkView;
    EditText checkAmount;
    TextView percentView;
    EditText percentAmount;
    TextView splitView;
    EditText splitAmount;
    TextView totalLineView;
    TextView totalTipLineView;
    double checkAmountIn, percentAmountInDouble, totalTipOut;
    int splitAmountIn, percentAmountIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void onButtonClick(View v) {
        NumberFormat decimalFormat = new DecimalFormat("#0.00");
        checkView = (TextView) findViewById(R.id.checkTextView);
        checkAmount = (EditText) findViewById(R.id.checkEditText);
        percentView = (TextView) findViewById(R.id.percentageTextView);
        percentAmount = (EditText) findViewById(R.id.percentageEditText);
        splitView = (TextView) findViewById(R.id.splitTextView);
        splitAmount = (EditText) findViewById(R.id.splitEditText);
        totalLineView = (TextView) findViewById(R.id.totalTextView);
        totalTipLineView = (TextView) findViewById(R.id.tipTotalTextView);
        checkAmountIn = Double.parseDouble(checkAmount.getText().toString());
        percentAmountIn = Integer.parseInt(percentAmount.getText().toString());
        percentAmountInDouble = ((double) percentAmountIn / 100);
        splitAmountIn = Integer.parseInt(splitAmount.getText().toString());
        totalTipOut = (checkAmountIn * percentAmountInDouble) / (double) splitAmountIn;
        String formatTotalTipOut = decimalFormat.format(totalTipOut);
        totalTipLineView.setText("$" + formatTotalTipOut);
    }

    public void onResetButtonClick(View v) {
        checkAmount.setText(null);
        percentAmount.setText(null);
        splitAmount.setText(null);
        totalTipLineView.setText(null);
    }

    /*public void onSettingsButtonClick(View v){
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }*/




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){

        //noinspection SimplifiableIfStatement
            case R.id.action_settings:
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
