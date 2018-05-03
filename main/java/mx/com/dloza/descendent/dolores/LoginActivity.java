package mx.com.dloza.descendent.dolores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.com.dloza.descendent.MenuActivity;
import mx.com.dloza.descendent.R;

/**
 * Created by Jairo on 02/04/2018.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    // Begin to declare the buttons that will link to the view
    private Button btnLogin;
    private Button btnRegistry;
    private EditText edtName;
    private EditText edtPass;
    private DBHelper db;
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

// Part of the code where the main class is linked to the layout
        setContentView(R.layout.activity_login);


// They are called the loyout variable
        db = new DBHelper(this);
        session = new Session(this);
        btnLogin = (Button)findViewById(R.id.btn_login);
        btnRegistry = (Button)findViewById(R.id.btn_register);
        edtName = (EditText) findViewById(R.id.edt_name);
        edtPass = (EditText) findViewById(R.id.edt_password);
        btnLogin.setOnClickListener(this);
        btnRegistry.setOnClickListener(this);


        // Part of the code where the session starts
        if (session.loggedin()){
            startActivity(new Intent(LoginActivity.this,MenuActivity.class));
            finish();
        }

    }

    // Actions that the buttons perform when they are pressed
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;

            case R.id.btn_register:
                startActivity(new Intent(LoginActivity.this, Register.class));
                break;
            default:
        }
    }


    // Code that helps to log in
    private void login(){
        String email = edtName.getText().toString();
        String pass = edtPass.getText().toString();

        if (db.getUser(email, pass)){
            session.setLoggedin(true);

// Here it helps to send from one activity to another
            startActivity(new Intent(LoginActivity.this, MenuActivity.class));
            finish();
        }else{

// Here an error message is sent in case of missing data in the login fields
            Toast.makeText(getApplicationContext(), "Escriba nombre/contraseña", Toast.LENGTH_SHORT).show();
        }
    }
}

