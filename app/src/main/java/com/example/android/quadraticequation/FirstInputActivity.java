package com.example.android.quadraticequation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_input);

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            EditText editTextView = (EditText) findViewById(R.id.x1_editText);

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstInputActivity.this, SecondInputActivity.class);
                //Create a bundle object
                Bundle b = new Bundle();

                //test if the input is a number or not
                String input = editTextView.getText().toString();

                //create an object instance of TestForNumber class
                TestForNumber test = new TestForNumber(input);

                //create an object instance of TestForZero class
                TestForZero testForZero = new TestForZero(input);

                if (test.testInput() && !testForZero.testZero()) {//test for number and zero

                    b.putString("x1", editTextView.getText().toString());
                    //Add the bundle to the intent.
                    intent.putExtras(b);

                    //start the DisplayActivity
                    startActivity(intent);
                } else { // if input is not a number
                    Toast.makeText(FirstInputActivity.this, "Invalid input, Please enter a number", Toast.LENGTH_SHORT).show();
                }

            }//end Onclick method

        });
    }//end Oncreate
}//end class
