package vn.edu.vtn.demo_mvp_splash.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.vtn.demo_mvp_splash.MainActivity;
import vn.edu.vtn.demo_mvp_splash.R;
import vn.edu.vtn.demo_mvp_splash.db.prefs.SaveInfoLogin;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {
    TextView txtUsername, txtPassword;
    Button btnLogin;
    LoginMVP.Presenter presenter;
    SaveInfoLogin saveInfoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControls();
        addEvents();
    }

    private void addControls() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        presenter = new LoginPresenter(this, LoginActivity.this);
        saveInfoLogin = new SaveInfoLogin(this);
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                presenter.checkLogin(username, password);
            }
        });
    }

    @Override
    public void showResult(boolean result, String username) {
        if (result) {
            saveInfoLogin.setLoggedin(true, username);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "Username or Password is incorrect !!! ", Toast.LENGTH_SHORT).show();
        }
    }
}
