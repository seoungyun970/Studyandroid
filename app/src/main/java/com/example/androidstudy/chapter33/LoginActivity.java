package com.example.androidstudy.chapter33;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LoginActivity extends Activity {
    TextView id, pwd;
    Button btn;
    String loginId, loginPwd;
    ArrayList<String> strings = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = findViewById(R.id.inputId);
        pwd = findViewById(R.id.inputPwd);
        btn = findViewById(R.id.loginBtn);

        loginId = SharedPreferencesManager.getString(this, "inputId");
        loginPwd = SharedPreferencesManager.getString(this, "inputPwd");



        strings.add("a");
        strings.add("b");
        strings.add("c");



        if (loginId != null && loginPwd != null) {
            if (loginId.equals("sypark") && loginPwd.equals("1102")) {
                Toast.makeText(this, loginId + "님 자동로그인 입니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SubActivity.class);
                startActivity(intent);
                finish();
            }
        } else if (loginId == null && loginPwd == null) {
            btn.setOnClickListener(v -> {
                if (id.getText().toString().equals("sypark") && pwd.getText().toString().equals("1102")) {
                    SharedPreferencesManager.setString(this, "inputId",id.getText().toString());
                    SharedPreferencesManager.setString(this, "inputPwd",pwd.getText().toString());

                    Toast.makeText(this, id.getText().toString() + " 님 환영합니다. ", Toast.LENGTH_SHORT).show();


                    SharedPreferencesManager.setStringArray(this,"inputArray",strings);
                    Intent intent = new Intent(this, SubActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this,"아이디와 비밀번호가 틀렸습니다.",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
