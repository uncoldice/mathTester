package com.example.mathtester;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int add1, add2, add3, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView subjectView = (TextView) findViewById(R.id.subject);
        generateAddNumber(subjectView);
    }

    public void generateAddNumber (View view) {
        TextView add1View = (TextView) findViewById(R.id.add1);
        Button nextBtn = (Button) findViewById(R.id.next);

        nextBtn.setEnabled(false);

        add1 = (int)(Math.random()*((100-0)+1))+0;
        add2 = (int)(Math.random()*((100-0)+1))+0;
        add3 = 0;

        String formula = Integer.toString(add1) + " + " + Integer.toString(add2) + "=";

        if ((add2%3) == 0) {
            add3 = (int)(Math.random()*((100-0)+1))+0;
            formula = Integer.toString(add1) + " + " + Integer.toString(add2) + " + " + Integer.toString(add3) + "=";
        }

        add1View.setText(formula);
    }
    
    /** Called when the user clicks the Send button */
    public void checkResult(View view) {
        // Do something in response to button

        EditText resultView = (EditText) findViewById(R.id.result);
        TextView correctView = (TextView) findViewById(R.id.correct);
        Button submitBtn = (Button) findViewById(R.id.submit);
        Button nextBtn = (Button) findViewById(R.id.next);
        ProgressBar progBar = (ProgressBar) findViewById(R.id.progressBar);

        if (resultView.getText().length() == 0){
            return;
        }

        String resultStr = resultView.getText().toString();
        result = Integer.parseInt(resultStr);

        TextView subjectView = (TextView) findViewById(R.id.subject);

        if (result == add1 + add2 + add3) {
            correctView.setText("正确");
            submitBtn.setEnabled(false);
            nextBtn.setEnabled(true);
            progBar.incrementProgressBy(10);
        } else {
            correctView.setText("错误！");
            nextBtn.setEnabled(false);
            submitBtn.setEnabled(true);
        }
    }

    public void nextOne(View view) {
        // Do something in response to button

        EditText resultView = (EditText) findViewById(R.id.result);
        TextView correctView = (TextView) findViewById(R.id.correct);
        Button btn = (Button) findViewById(R.id.submit);

        btn.setEnabled(true);

        resultView.setText("");
        correctView.setText("");

        generateAddNumber(resultView);
    }
}

