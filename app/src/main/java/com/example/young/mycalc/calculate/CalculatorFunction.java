package com.example.young.mycalc.calculate;


import android.app.Activity;
import android.widget.TextView;

import com.example.young.mycalc.R;

/**
 * Created by Young on 8/12/2016.
 */
public class CalculatorFunction {
    //Create instance of activity
    public Activity activity;
    //Create constructor for passed down instance of activity
       public CalculatorFunction (Activity _activity){
        this.activity = _activity;
    }
    //Double variable to hold the result or last number input
    private double result = 0;
    //String variable to hold the current number
    private String inputNumber = "";
    //String variable to hold the operator
    private String operator = "";
    //String variable to hold the the history of past calculations
    private String history = "";

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
    public void clearAll(){
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
        TextView historyTextView = (TextView) this.activity.findViewById(R.id.input_history_text_view);
        historyTextView.setText(history);
        //clear the inputNumber for new inputNumber
        inputNumber = "";
    }

    //Display nothing on the current_number window
    private void displayResult(){
        TextView resultTextView = (TextView) this.activity.findViewById(R.id.current_number_text_view);
        resultTextView.setText("");
    }

    //Display passed in string on the current_number window
    private void displayResult (String input){
        TextView resultTextView = (TextView) this.activity.findViewById(R.id.current_number_text_view);
        resultTextView.setText(input);
    }

    //Display passed in double on the current_number window
    private void displayResult (double input){
        TextView resultTextView = (TextView) this.activity.findViewById(R.id.current_number_text_view);
        resultTextView.setText(String.valueOf(input));
    }
}
