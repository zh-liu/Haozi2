package com.jsecode.androidmvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jsecode.androidmvp.activity.SplashActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity{

    Button email_sign_in_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_sign_in_button = findViewById(R.id.email_sign_in_button);

        email_sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });
    }
}

