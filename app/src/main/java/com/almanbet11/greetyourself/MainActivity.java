package com.almanbet11.greetyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String toastText = "the name is incorrect!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void greet(View view) {
        EditText name_text_edit = (EditText) findViewById(R.id.name_edit_text_view);
        String name = name_text_edit.getText().toString();

        if (isStringOnlyAlphabet(name) == true){
            display(name);
        }
        else{
            showToast();
        }
    }

    private void display(String name) {
        TextView nameTextView = (TextView) findViewById(R.id.name_text_view);
        nameTextView.setText(String.format("Hello, %s !", name));
    }

    private void showToast(){
        Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
    }

    private  boolean isStringOnlyAlphabet(String str){
        if (str == null || str.equals("")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((!(ch >= 'A' && ch <= 'Z'))
                    && (!(ch >= 'a' && ch <= 'z'))) {
                return false;
            }
        }
        return true;
    }



}
