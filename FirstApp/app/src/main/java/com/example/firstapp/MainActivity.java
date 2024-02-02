package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText emailTxt,passwordTxt,confirmPasswordTxt;
    TextView errorTxt,successTxt;
    Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        emailTxt=findViewById(R.id.emailTxt);
        passwordTxt=findViewById(R.id.passwordTxt);
        confirmPasswordTxt=findViewById(R.id.confirmPasswordTxt);
        signUpButton=findViewById(R.id.signUpButton);
        errorTxt=findViewById(R.id.errorTxt);
        successTxt=findViewById(R.id.successTxt);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailTxt.getText().toString();
                String pass = passwordTxt.getText().toString();
                String confirmPass = confirmPasswordTxt.getText().toString();

                if(validEmail(email) & validPassword(pass) & validConfirmPassword(pass,confirmPass)){
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    resetError();
                }
                else{
                    setError("Please provide valid Details");
                }

            }
        });

    }

    private boolean validEmail(String email){
        return checkRegex("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", email);
    }

    private boolean validPassword(String pass){
        return checkRegex("^[a-zA-Z]\\w{3,14}$", pass);
    }

    private boolean validConfirmPassword(String actualpass,String confirmPass){
        return actualpass.equals(confirmPass);
    }

    private void setError(String errormsg){
        errorTxt.setVisibility(View.VISIBLE);
        errorTxt.setText(errormsg);
    }
    private void resetError(){
        errorTxt.setVisibility(View.INVISIBLE);
        errorTxt.setText("");
    }

    private boolean checkRegex(String pattern,String input){
        //Creates Pattern Object.
        Pattern r = Pattern.compile(pattern);
        //Now create matcher object.
        return r.matcher(input).matches();
    }

}