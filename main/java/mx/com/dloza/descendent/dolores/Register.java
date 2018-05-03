package mx.com.dloza.descendent.dolores;

/**
 * Created by Hp on 05/03/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mx.com.dloza.descendent.R;


// Class where a user's registration is made
public class Register extends AppCompatActivity  implements View.OnClickListener{
    private Button btnRegister;
    private TextView txvLogin;
    private EditText edtEmail;
    private EditText edtPass;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // They call the buttons of the layout using their id
        db = new DBHelper(this);
        btnRegister = (Button) findViewById(R.id.btn_register);
        txvLogin = (TextView)findViewById(R.id.edt_email);
        edtEmail = (EditText)findViewById(R.id.edt_email);
        edtPass = (EditText)findViewById(R.id.edt_password);

        btnRegister.setOnClickListener(this);
        txvLogin.setOnClickListener(this);
    }

    // Actions that help the buttons to work when clicking
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                register();
                break;
            case R.id.btn_login:
                startActivity(new Intent(Register.this, LoginActivity.class));
                finish();
                break;
            default:
        }
    }

    // Code that helps register a user and then log in
    private void register(){
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();
        if (email.isEmpty() && pass.isEmpty()){

    // Code that helps display the error when a field in the user record is not filled
            displayToast("Username/password fiel empty");
        }else{
            db.addUser(email,pass);

    // Code that helps us send a success message when a user registers correctly
            displayToast("Usuario Registrado");
            finish();
        }

    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }
}
