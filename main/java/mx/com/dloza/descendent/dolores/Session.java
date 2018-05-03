package mx.com.dloza.descendent.dolores;

/**
 * Created by Hp on 05/03/2018.
 */

import android.content.Context;
import android.content.SharedPreferences;


// Class that helps keep session open
public class Session {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context ctx;


    public Session(Context ctx){
        this.ctx = ctx;

// Here reference is made to which activity will send after loggin
        preferences = ctx.getSharedPreferences("loginMenuDescendientes", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setLoggedin(boolean loggedin){
        editor.putBoolean("loggedInmode",loggedin);
        editor.commit();
    }

    public boolean loggedin(){
        return preferences.getBoolean("loggedInmode", false);
    }

}

