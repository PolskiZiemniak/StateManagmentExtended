package com.example.statemanagmentextended;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

    private StateViewModel stateViewModel;

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

        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);

        updateCounter();
        updateUserText();
        updateCheckbox();
        updateSwitch();
        increaseNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stateViewModel.incrementCount();
                updateCounter();
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stateViewModel.setChecked(checkBox.isChecked());
                updateCheckbox();
            }
        });
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stateViewModel.setSwitched(aSwitch.isChecked());
                updateSwitch();
            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stateViewModel.setText(userText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        userText.addTextChangedListener(textWatcher);
    }
    private void updateCounter(){
        showNumber.setText("Ilość kliknięć: "+ stateViewModel.getCounter());
    }
    private void updateUserText(){
        userText.setText(stateViewModel.getText());
    }
    private void updateCheckbox(){
        if(stateViewModel.getIsChecked()){
            hiddenText.setVisibility(View.VISIBLE);
            checkBox.setChecked(true);
        }else {
            hiddenText.setVisibility(View.INVISIBLE);
            checkBox.setChecked(false);
        }
    }
    private void updateSwitch(){
        if (stateViewModel.getIsSwitched()) {
            background.setBackgroundColor(Color.BLACK);
            aSwitch.setChecked(true);
        }else {
            background.setBackgroundColor(Color.WHITE);
            aSwitch.setChecked(false);
        }
    }

}