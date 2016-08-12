package com.example.young.mycalc;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.example.young.mycalc.calculate.CalculatorFunction;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {


    //Instintiate CalculatorFunction class object with instance of current activity
    CalculatorFunction performMath = new CalculatorFunction(this);

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.young.mycalc/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.young.mycalc/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    //Onclick calls for math operation
    //append "0" into the current number
    public void zero(View view) {
        performMath.appendNumber("0");
    }
    ////append "1" into the current number
    public void one(View view) {
        performMath.appendNumber("1");
    }
    //append "2" into the current number
    public void two(View view) {
        performMath.appendNumber("2");
    }
    //append "3" into the current number
    public void three(View view) {
        performMath.appendNumber("3");
    }
    //append "4" into the current number
    public void four(View view) {
        performMath.appendNumber("4");
    }
    //append "5" into the current number
    public void five(View view) {
        performMath.appendNumber("5");
    }
    //append "6" into the current number
    public void six(View view) {
        performMath.appendNumber("6");
    }
    //append "7" into the current number
    public void seven(View view) {
        performMath.appendNumber("7");
    }
    //append "8" into the current number
    public void eight(View view) {
        performMath.appendNumber("8");
    }
    //append "9" into the current number
    public void nine(View view) {
        performMath.appendNumber("9");
    }
    //append "." into the current number
    public void dot(View view) {
        performMath.appendNumber(".");
    }
    //delete last digit out of the current number
    public void delete(View view){
        performMath.appendNumber("del");
    }
    //perform plus operation between result and coming inputNumer
    public void plus(View view){
        performMath.useOperator("+");
    }
    //perform minus operation between result and coming inputNumer
    public void minus(View view){
        performMath.useOperator("-");
    }
    //perform multiplication opreation between result and coming input number
    public void multiply(View view){
        performMath.useOperator("*");
    }
    //perform division operation between result and coming input number
    public void divide(View view){
        performMath.useOperator("/");
    }
    //perform whatever operation is set between result and input number
    public void equal(View view){
        performMath.useOperator("=");
    }
    //perform negation on current input number
    public void negate(View view){
        performMath.useOperator("-+");
    }
    //clear the whole operation and history
    public void clear(View view){
        performMath.clearAll();
    }
    //save the current value into variable
    public void save(View view){

    }
    //retrive the current value into variable
    public void retrieve(View view){

    }
    //end of onclick calls for math operation
}
