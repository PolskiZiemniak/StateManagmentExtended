package com.example.statemanagmentextended;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNTER = "counter";
    private static final String KEY_USERTEXT = "userText";
    private static final String KEY_CHECKBOX = "checkBox";
    private static final String KEY_SWITCH = "changeMode";

    private TextView showNumber;
    private Button increaseNumber;
    private EditText userText;
    private CheckBox checkBox;
    private TextView hiddenText;
    private Switch aSwitch;
    private ConstraintLayout background;

    private int counter = 0;
    private String text = "";
    private Boolean isChecked = false;
    private Boolean isSwitched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        showNumber = findViewById(R.id.showNumber);
        increaseNumber = findViewById(R.id.increaseNumber);
        userText = findViewById(R.id.userText);
        checkBox = findViewById(R.id.checkBox);
        hiddenText = findViewById(R.id.hiddenText);
        aSwitch = findViewById(R.id.changeMode);
        background = findViewById(R.id.main);

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(KEY_COUNTER);
            text = savedInstanceState.getString(KEY_USERTEXT);
            isChecked = savedInstanceState.getBoolean(KEY_CHECKBOX);
            isSwitched = savedInstanceState.getBoolean(KEY_SWITCH);
        }
        updateCounter();
        updateUserText();
        updateCheckbox();
        updateSwitch();

        increaseNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                updateCounter();
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isChecked = checkBox.isChecked();
                updateCheckbox();
            }
        });
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSwitched = aSwitch.isChecked();
                updateSwitch();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, counter);
        outState.putString(KEY_USERTEXT, text);
        outState.putBoolean(KEY_CHECKBOX, isChecked);
        outState.putBoolean(KEY_SWITCH, isSwitched);
    }
    private void updateCounter(){
        showNumber.setText("Ilość kliknięć: "+counter);
    }
    private void updateUserText(){
        userText.setText(text);
    }
    private void updateCheckbox(){
        if(isChecked){
            hiddenText.setVisibility(View.VISIBLE);
            checkBox.setChecked(true);
        }else {
            hiddenText.setVisibility(View.INVISIBLE);
            checkBox.setChecked(false);
        }
    }
    private void updateSwitch(){
        if (isSwitched) {
            background.setBackgroundColor(Color.BLACK);
            aSwitch.setChecked(true);
        }else {
            background.setBackgroundColor(Color.WHITE);
            aSwitch.setChecked(false);
        }
    }
}