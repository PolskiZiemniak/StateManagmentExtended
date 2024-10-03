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
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private CountViewModel countViewModel;

    private TextView showNumber;
    private Button increaseNumber;
    private EditText userText;
    private CheckBox checkBox;
    private TextView hiddenText;
    private Switch aSwitch;
    private ConstraintLayout background;


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

        countViewModel = new ViewModelProvider(this).get(CountViewModel.class);

        updateCounter();
        updateUserText();
        updateCheckbox();
        updateSwitch();
        increaseNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countViewModel.incrementCount();
                updateCounter();
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countViewModel.setChecked(checkBox.isChecked());
                updateCheckbox();
            }
        });
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countViewModel.setSwitched(aSwitch.isChecked());
                updateSwitch();
            }
        });

    }
    private void updateCounter(){
        showNumber.setText("Ilość kliknięć: "+countViewModel.getCounter());
    }
    private void updateUserText(){
        userText.setText(countViewModel.getText());
    }
    private void updateCheckbox(){
        if(countViewModel.getIsChecked()){
            hiddenText.setVisibility(View.VISIBLE);
            checkBox.setChecked(true);
        }else {
            hiddenText.setVisibility(View.INVISIBLE);
            checkBox.setChecked(false);
        }
    }
    private void updateSwitch(){
        if (countViewModel.getIsSwitched()) {
            background.setBackgroundColor(Color.BLACK);
            aSwitch.setChecked(true);
        }else {
            background.setBackgroundColor(Color.WHITE);
            aSwitch.setChecked(false);
        }
    }

}