package com.example.android.quadraticequation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {
    TextView x1, x2, x3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        //create bundle to get data pass from previous activity
        Bundle bb = getIntent().getExtras();
        x1 = (TextView) findViewById(R.id.xxxx1_textView);
        x2 = (TextView) findViewById(R.id.xxxx2_textView);
        x3 = (TextView) findViewById(R.id.xxxx3_textView);

        //set Textview to the data retrieved from previous activity
        x1.setText(bb.getCharSequence("xxx1"));
        x2.setText(bb.getCharSequence("xxx2"));
        x3.setText(bb.getCharSequence("xxx3"));


        //OnclickListener for calculate button
        Button cal_button = (Button) findViewById(R.id.cal_button);
        cal_button.setOnClickListener(new View.OnClickListener() {

            TextView cal = (TextView) findViewById(R.id.result_textView);
            TextView d_textView = (TextView) findViewById(R.id.d_textView);

            public void onClick(View v) {

                //convert all the three values retrieve to integer
                int a = Integer.parseInt(x1.getText().toString());
                int b = Integer.parseInt(x2.getText().toString());
                int c = Integer.parseInt(x3.getText().toString());

                //create object instance of CalQuadraticEquation class
                CalQuadraticEquation quadraticEquation = new CalQuadraticEquation(a, b, c);
                double r = quadraticEquation.calculateQuadratic();
                if (quadraticEquation.discriminant() > 0) { //two real roots
                    d_textView.setText("Discriminant > 0\n We have 2 Real Roots");
                    cal.setText("root 1 = " + quadraticEquation.root1() + " root 2 = " + quadraticEquation.root2());
                } else if (quadraticEquation.discriminant() == 0) {//equal root
                    d_textView.setText("Discriminant = 0\n We have Equal Root");
                    cal.setText("Equal roots = " + r);
                } else {//complex root
                    d_textView.setText("Discriminant < 0\n Complex Roots");
                    cal.setText("No real roots");
                }

            }
        });

        //OnClickListener for refresh button
        ImageButton refresh_button = (ImageButton) findViewById(R.id.refresh_button);
        refresh_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CalculateActivity.this, HomeActivity.class);
                startActivity(intent);
            }//end Onclick method
        });

    }//end Oncreate
}//end class
