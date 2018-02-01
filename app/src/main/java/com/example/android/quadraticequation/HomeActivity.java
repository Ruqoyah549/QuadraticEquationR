package com.example.android.quadraticequation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // OnClickListener for Know Quadratic TextView
        //to hide and show the layout when button is clicked
        Button know_button = (Button) findViewById(R.id.know_button);
        know_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LinearLayout know_layout = (LinearLayout) findViewById(R.id.know_layout);

                if (know_layout.getVisibility() == View.GONE) {
                    know_layout.setVisibility(View.VISIBLE);
                } else {
                    know_layout.setVisibility(View.GONE);
                }
            }
        });

        //OnclickListener to start activity
        Button start_button = (Button) findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FirstInputActivity.class);
                startActivity(intent);

            }
        });
    }
}
