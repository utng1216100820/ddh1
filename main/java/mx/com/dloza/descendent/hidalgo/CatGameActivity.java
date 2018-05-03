package mx.com.dloza.descendent.hidalgo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.com.dloza.descendent.R;

public class CatGameActivity extends AppCompatActivity implements View.OnClickListener {

    int turn,cont,conta=0;
    String letter;
    EditText edtWinner;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnGetOut,btnReset;

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_cat_game);
        mp = MediaPlayer.create( this, R.raw.winner);

        edtWinner=(EditText)findViewById(R.id.edt_winner);

        btn1=(Button)(findViewById(R.id.btn_1));
        btn2=(Button)(findViewById(R.id.btn_2));
        btn3=(Button)(findViewById(R.id.btn_3));
        btn4=(Button)(findViewById(R.id.btn_4));
        btn5=(Button)(findViewById(R.id.btn_5));
        btn6=(Button)(findViewById(R.id.btn_6));
        btn7=(Button)(findViewById(R.id.btn_7));
        btn8=(Button)(findViewById(R.id.btn_8));
        btn9=(Button)(findViewById(R.id.btn_9));
        btnReset =(Button)(findViewById(R.id.btn_reset));

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        cont++;
        turn=cont%2;

        if(turn == 1){
            printXO('x', v);
        }
        else{
            printXO('o', v);
        }
    }

    public void printXO(char letter, View v){

        if(v.getId() == R.id.btn_reset){
            edtWinner.setEnabled(true);
            edtWinner.setText("");

            btn1.setEnabled(true);
            btn1.setText("");

            btn2.setEnabled(true);
            btn2.setText("");

            btn3.setEnabled(true);
            btn3.setText("");

            btn4.setEnabled(true);
            btn4.setText("");

            btn5.setEnabled(true);
            btn5.setText("");

            btn6.setEnabled(true);
            btn6.setText("");

            btn7.setEnabled(true);
            btn7.setText("");

            btn8.setEnabled(true);
            btn8.setText("");

            btn9.setEnabled(true);
            btn9.setText("");
        }
        if(v.getId() == R.id.btn_1){
            btn1.setText(letter+"");
            btn1.setEnabled(false);
        }
        else if(v.getId() == R.id.btn_2){
            btn2.setText(letter+"");
            btn2.setEnabled(false);
        }
        else if(v.getId() == R.id.btn_3){
            btn3.setText(letter+"");
            btn3.setEnabled(false);
        }
        else if(v.getId() == R.id.btn_4){
            btn4.setText(letter+"");
            btn4.setEnabled(false);
        }
        else if(v.getId() == R.id.btn_5){
            btn5.setText(letter+"");
            btn5.setEnabled(false);
        }
        else if(v.getId() == R.id.btn_6){
            btn6.setText(letter+"");
            btn6.setEnabled(false);
        }
        else if(v.getId() == R.id.btn_7){
            btn7.setText(letter+"");
            btn7.setEnabled(false);
        }
        else if(v.getId() == R.id.btn_8){
            btn8.setText(letter+"");
            btn8.setEnabled(false);
        }
        else if(v.getId() == R.id.btn_9){
            btn9.setText(letter+"");
            btn9.setEnabled(false);
        }
        Winner(letter);
    }

    public void Winnwe(char letter){

        if(btn1.getText().toString().equals(letter+"") && (btn2.getText().toString().equals(letter+"")) && (btn3.getText().toString().equals(letter+""))){
            edtWinner.setText("El ganador es "+letter);
            edtWinner.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            mp.start();

        }else if(btn4.getText().toString().equals(letter+"") && (btn5.getText().toString().equals(letter+"")) && (btn6.getText().toString().equals(letter+""))){
            edtWinner.setText("El ganador es "+letter);
            edtWinner.setEnabled(false);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            mp.start();
        }else if(btn7.getText().toString().equals(letter+"") && (btn8.getText().toString().equals(letter+"")) && (btn9.getText().toString().equals(letter+""))){
            edtWinner.setText("El ganador es "+letter);
            edtWinner.setEnabled(false);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            mp.start();
        }else if(btn1.getText().toString().equals(letter+"") && (btn4.getText().toString().equals(letter+"")) && (btn7.getText().toString().equals(letter+""))){
            edtWinner.setText("El ganador es "+letter);
            edtWinner.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            mp.start();
        }else if(btn2.getText().toString().equals(letter+"") && (btn5.getText().toString().equals(letter+"")) && (btn8.getText().toString().equals(letter+""))){
            edtWinner.setText("El ganador es "+letter);
            edtWinner.setEnabled(false);
            btn1.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn9.setEnabled(false);
            mp.start();

        }else if(btn3.getText().toString().equals(letter+"") && (btn6.getText().toString().equals(letter+"")) && (btn9.getText().toString().equals(letter+""))){
            edtWinner.setText("El ganador es "+letter);
            edtWinner.setEnabled(false);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            mp.start();

        }else if(btn1.getText().toString().equals(letter+"") && (btn5.getText().toString().equals(letter+"")) && (btn9.getText().toString().equals(letter+""))){
            edtWinner.setText("El ganador es "+letter);
            edtWinner.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            mp.start();

        }else if(btn3.getText().toString().equals(letter+"") && (btn5.getText().toString().equals(letter+"")) && (btn7.getText().toString().equals(letter+""))){
            edtWinner.setText(getString(R.string.edtWiner)+letter);
            edtWinner.setEnabled(false);
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn4.setEnabled(false);
            btn6.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            mp.start();
        }else if(conta<9){
            conta++;
        }else {
            edtWinner.setText(R.string.draw);
        }
    }
}

