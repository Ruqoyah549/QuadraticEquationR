package com.example.android.quadraticequation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondInputActivity extends AppCompatActivity {
    TextView x1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_input);

        Bundle b = getIntent().getExtras();
        x1 = (TextView) findViewById(R.id.xx1_textView);
        x1.setText(b.getString("x1"));

        //OnClickListener for Next Button
        Button btn2 = (Button) findViewById(R.id.next2Button);
        btn2.setOnClickListener(new View.OnClickListener() {
            EditText x2_editText = (EditText) findViewById(R.id.xx2_editText);

            public void onClick(View v) {
                Intent intent = new Intent(SecondInputActivity.this, ThirdInputActivity.class);
                //Create a bundle object
                Bundle bb = new Bundle();

                //test if the input is a number or not
                String input = x1.getText().toString();
                String input2 = x2_editText.getText().toString();
                TestForNumber test = new TestForNumber(input);
                TestForNumber test2 = new TestForNumber(input2);
                if (test.testInput() && test2.testInput()) {

                    //Inserts a String value into the mapping of this Bundle
                    bb.putString("xx1", x1.getText().toString());
                    bb.putString("x2", x2_editText.getText().toString());

                    //Add the bundle to the intent.
                    intent.putExtras(bb);

                    //start the DisplayActivity
                    startActivity(intent);
                } else { // if input is not a number
                    Toast.makeText(SecondInputActivity.this, "Invalid input, Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
