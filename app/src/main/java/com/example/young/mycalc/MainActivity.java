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


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {
    //Double variable to hold the result or last number input
    private double result = 0;
    //String variable to hold the current number
    private String inputNumber = "";
    //String variable to hold the operator
    private String operator = "";
    //String variable to hold the the history of past calculations
    private String history = "";

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
    //append "0" into the current number
    public void zero(View view) {
        appendNumber("0");
    }
    ////append "1" into the current number
    public void one(View view) {
        appendNumber("1");
    }
    //append "2" into the current number
    public void two(View view) {
        appendNumber("2");
    }
    //append "3" into the current number
    public void three(View view) {
        appendNumber("3");
    }
    //append "4" into the current number
    public void four(View view) {
        appendNumber("4");
    }
    //append "5" into the current number
    public void five(View view) {
        appendNumber("5");
    }
    //append "6" into the current number
    public void six(View view) {
        appendNumber("6");
    }
    //append "7" into the current number
    public void seven(View view) {
        appendNumber("7");
    }
    //append "8" into the current number
    public void eight(View view) {
        appendNumber("8");
    }
    //append "9" into the current number
    public void nine(View view) {
        appendNumber("9");
    }
    //append "." into the current number
    public void dot(View view) {
        appendNumber(".");
    }
    //delete last digit out of the current number
    public void delete(View view){
        appendNumber("del");
    }
    //perform plus operation between result and coming inputNumer
    public void plus(View view){
        useOperator("+");
    }
    //perform minus operation between result and coming inputNumer
    public void minus(View view){
        useOperator("-");
    }
    //perform multiplication opreation between result and coming input number
    public void multiply(View view){
        useOperator("*");
    }
    //perform division operation between result and coming input number
    public void divide(View view){
        useOperator("/");
    }
    //perform whatever operation is set between result and input number
    public void equal(View view){
        useOperator("=");
    }
    //perform negation on current input number
    public void negate(View view){
        useOperator("-+");
    }
    //clear the whole operation and history
    public void clear(View view){
        clearAll();
    }

    //Method to modify current working number such as append a digit or decimal to current number
    //and delete last digit from current number
    public void appendNumber(String number){
        //if no previous digit is present in the current number, then append 0 before . for
        //decimal presentation
        if(number == "." && inputNumber == ""){
            inputNumber = "0.";
        }
        //If current number is not empty, take out last digit from the number
        else if (number == "del"){
            if (!inputNumber.isEmpty()){
                //Get length of inputNumber and remove last digit from input Number
                int size = inputNumber.length();
                inputNumber = inputNumber.substring(0, size-1);
            }
        }
        //if last operation was equal sign, then appending new number requires
        //starting of new calculation, therefore, clear all operation and start fresh
        else if (operator == "="){
            clearAll();
            inputNumber = number;
        }
        //Append new digit into the back of inputNumber
        else{
            inputNumber = inputNumber + number;
        }
        //display the updated inputNumber on the calculator window
        displayResult (inputNumber);
    }

    //Method to perform or insult operation between result and current inputNumber
    public void useOperator(String opt){
        //Negate current number
        if (opt == "-+" && !inputNumber.isEmpty()){
            double negateNumber = Double.valueOf(inputNumber) * -1.0;
            inputNumber = String.valueOf(negateNumber);
        }
        //if current inputed operator(opt) is not negation and operator already exist for
        //calculation, perform the existing opeartion according to if input number is not empty
        else if (opt != "-+" && !operator.isEmpty()){
           if (!inputNumber.isEmpty()) {
               switch (operator) {
                   case "+":
                       result = result + Double.valueOf(inputNumber);
                       break;
                   case "-":
                       result = result - Double.valueOf(inputNumber);
                       break;
                   case "*":
                       result = result * Double.valueOf(inputNumber);
                       break;
                   case "/":
                       result = result / Double.valueOf(inputNumber);
                       break;
                   case "=":
                       inputNumber = String.valueOf(result);
                       break;
                   default:
                       break;
               }
           }
           //if inputNumber is empty, user is changing the desired operation to be performed,
           //therefore, erase last displaying operator from history
            else if (inputNumber.isEmpty()){
               //inputNumber = String.valueOf(result);
               int size = history.length();
               history = history.substring(0, size-2);
           }
        }
        //if operator is empty, but inputNumber is not, it means that it is first
        //number from for the calculation, therefore, move it to result for upcoming operation
        else if(operator.isEmpty() && !inputNumber.isEmpty()){
            result = Double.valueOf(inputNumber);
         }
        //Only if current operator input is not negation,
        //set the operator to current operator(opt) and display history and result accordingly
        if (opt != "-+" && !inputNumber.isEmpty()) {
            operator = opt;
            displayHistory(opt);
            displayResult(result);
        }
        //else if input number is not empty just display negated inputNumber on the window
        else if (!inputNumber.isEmpty()){
            displayResult(inputNumber);
        }
    }

    //Clear all the variables and window to start new fresh calculation
    private void clearAll(){
        result = 0;
        operator = "";
        history = "";
        inputNumber = "";
        displayHistory((history));
        displayResult();
    }

    //Display history of all the operation in current calculation in the input_history window
    private void displayHistory (String input){
        //if inputNumber is empty, different operator is chosen before enterning new inputNumber
        //for calculation, so only display previous history and new input which is new operator
        if (inputNumber.isEmpty()){
            history = history + " " + input;
        }
        //else, inputNumber with new input which is operator should be appended into the history
        else {
            history = history + " " + inputNumber + " " + input;
        }
        //Display updated history into input_history window
        TextView historyTextView = (TextView) findViewById(R.id.input_history_text_view);
        historyTextView.setText(history);
        //clear the inputNumber for new inputNumber
        inputNumber = "";
    }

    //Display nothing on the current_number window
    private void displayResult(){
        TextView resultTextView = (TextView) findViewById(R.id.current_number_text_view);
        resultTextView.setText("");
    }

    //Display passed in string on the current_number window
    private void displayResult (String input){
        TextView resultTextView = (TextView) findViewById(R.id.current_number_text_view);
        resultTextView.setText(input);
    }

    //Display passed in double on the current_number window
    private void displayResult (double input){
        TextView resultTextView = (TextView) findViewById(R.id.current_number_text_view);
        resultTextView.setText(String.valueOf(input));
    }
}
