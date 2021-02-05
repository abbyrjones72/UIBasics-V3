package com.example.uibasics_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // checkbox group
    private CheckBox checkBoxSolaris;
    private CheckBox checkBoxJoker;
    private CheckBox checkBoxPassengers;

    // radio group
    private RadioGroup rgMaritalStatus;

    // progress bars
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxSolaris = findViewById(R.id.solaris);
        checkBoxJoker = findViewById(R.id.Joker);
        checkBoxPassengers = findViewById(R.id.passengers);

        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);

        progressBar = findViewById(R.id.pbProgress);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(1000);
                }
            }
        });

        thread.start();

        int checkedButton = rgMaritalStatus.getCheckedRadioButtonId();

        switch(checkedButton) {
            case R.id.rbMarried:
                Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbSingle:
                Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbInRelationship:
                Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId) {
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.rbInRelationship:
                        Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();

                        break;
                    default:
                        break;
                }
            }
        });



        /* ------------------------------ CHECK BOXES ---------------------------------------------------------- */
        if(checkBoxSolaris.isChecked()) {
            Toast.makeText(MainActivity.this, "You have watched Solaris.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "You have not watched Solaris yet.", Toast.LENGTH_SHORT).show();
        }

        if(checkBoxJoker.isChecked()) {
            Toast.makeText(MainActivity.this, "You have watched Joker.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "You have not watched Joker yet.", Toast.LENGTH_SHORT).show();
        }

        if(checkBoxPassengers.isChecked()) {
            Toast.makeText(MainActivity.this, "You have watched Passengers.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "You have not watched Passengers yet.", Toast.LENGTH_SHORT).show();
        }
        /* ------------------------------ CHECK BOXES END ------------------------------------------------------- */


        checkBoxSolaris.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this, "You have watched Solaris.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You have not watched Solaris yet.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxJoker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this, "You have watched Joker.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You have not watched Joker yet.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxPassengers.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this, "You have watched Passengers.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You have not watched Passengers yet.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}