package com.example.aoyi.forceofflinetest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    private EditText input_accout;
    private EditText input_password;
    private CheckBox rememberPassCheckBox;
    private Button loginButton;
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        input_accout= (EditText) findViewById(R.id.input_accout_edittext);
        input_password= (EditText) findViewById(R.id.input_password_edittext);
        loginButton= (Button) findViewById(R.id.login_btn);
        rememberPassCheckBox= (CheckBox) findViewById(R.id.remember_pass_checkbox);
        boolean isRemember=prefs.getBoolean("remember_password",false);
        if (isRemember){
            String account=prefs.getString("account","");
            String password=prefs.getString("password","");
            input_accout.setText(account);
            input_password.setText(password);
            rememberPassCheckBox.setChecked(true);
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accout=input_accout.getText().toString();
                String password=input_password.getText().toString();
                editor=prefs.edit();
                if (accout.equals("qifeng")&&password.equals("1314")){
                    if (rememberPassCheckBox.isChecked()){
                        editor.putString("account",accout);
                        editor.putString("password",password);
                        editor.putBoolean("remember_password",true);
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent =new Intent(LoginActivity.this,SecondActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
