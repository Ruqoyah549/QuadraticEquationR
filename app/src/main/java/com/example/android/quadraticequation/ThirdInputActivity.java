package com.example.android.quadraticequation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdInputActivity extends AppCompatActivity {
    TextView x1;
    TextView x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_input);

       //create Bundle to get data sent from previous activity
        Bundle b = getIntent().getExtras();
        x1 = (TextView) findViewById(R.id.xxx1_textView);
        x2 = (TextView) findViewById(R.id.xxx2_textView);
        x1.setText(b.getCharSequence("xx1"));
        x2.setText(b.getCharSequence("x2"));


        //OnClickListener for Next Button
        Button btn2 = (Button) findViewById(R.id.next3Button);
        btn2.setOnClickListener(new View.OnClickListener() {
            EditText x3_editText = (EditText) findViewById(R.id.xxx3_editText);

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalculateActivity.class);
                //Create a bundle object
                Bundle bbb = new Bundle();

                //test if the input is a number or not
                String input = x1.getText().toString();
                String input2 = x2.getText().toString();
                String input3 = x3_editText.getText().toString();
                TestForNumber test = new TestForNumber(input);
                TestForNumber test2 = new TestForNumber(input2);
                TestForNumber test3 = new TestForNumber(input3);
                if (test.testInput() && test2.testInput() && test3.testInput()) {

                    //Inserts a String value into the mapping of this Bundle
                    bbb.putString("xxx1", x1.getText().toString());
                    bbb.putString("xxx2", x2.getText().toString());
                    bbb.putString("xxx3", x3_editText.getText().toString());

                    //Add the bundle to the intent.
                    intent.putExtras(bbb);

                    //start the DisplayActivity
                    startActivity(intent);
                } else { // if input is not a number
                    Toast.makeText(ThirdInputActivity.this, "Invalid input, Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
