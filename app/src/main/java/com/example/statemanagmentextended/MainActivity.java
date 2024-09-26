package com.example.statemanagmentextended;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNTER = "counter";
    private static final String KEY_USERTEXT = "userText";
    private static final String KEY_CHECKBOX = "checkBox";
    private static final String KEY_CHANGEMODE = "changeMode";

    private TextView showNumber;
    private Button increaseNumber;
    private EditText userText;
    private CheckBox checkBox;
    private Switch changeMode = findViewById(R.id.changeMode);
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        showNumber = findViewById(R.id.showNumber);
        increaseNumber = findViewById(R.id.increaseNumber);
        userText = findViewById(R.id.userText);
        checkBox = findViewById(R.id.checkBox);

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(KEY_COUNTER);
            userText.setText(savedInstanceState.getString(KEY_USERTEXT));
            checkBox.setChecked(savedInstanceState.getBoolean(KEY_CHECKBOX));

        }
        updateCounter();
        updateMode();

        increaseNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                updateCounter();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, counter);
    }
    private void updateCounter(){
        showNumber.setText("Ilość kliknięć: "+counter);
    }
    private void updateMode(){
        View view = this.getWindow().getDecorView();
        if(!changeMode.isChecked()){
            view.setBackgroundColor(1);
        }else{
            view.setBackgroundColor(2);
        }
    }
}