package mx.com.dloza.descendent.dolores;

/**
 * Created by Hp on 05/03/2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{

    //The variables used by the database user.db begin to be declared.
    public static final String TAG = DBHelper.class.getSimpleName();
    public static final String DB_NAME = "usuario.db";
    public static final int DB_VERSION = 1;

    // declare variables that refer to the table called users
    // Declaring the attributes that will be part of the table
    public static final String USER_TABLE = "usuarios";
    public static final String COLUMN_ID = " id ";
    public static final String COLUMN_EMAIL = " email ";
    public static final String COLUMN_PASS = " password ";

    // The table is created within the database
    public static final String CREATE_TABLE_USUARIOS = "CREATE TABLE "+ USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASS + " TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USUARIOS);
    }

    // Here it helps to delete the database if it already exists
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);
    }

    // Here a new user is added to the database
    public void addUser(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASS, password);

        long id = db.insert(USER_TABLE, null, values);
        db.close();


// This part of the code helps send success message when a user is inserted into the database
        Log.d(TAG, "Usuario insertado"+ id);
    }

    // This part of the code helps us to make a query to verify which user has registered in the database
    public boolean getUser(String email, String pass){
        String selectQuery = "select * from " + USER_TABLE + " where" +
                COLUMN_EMAIL + " = " + "'"+email+"'" + "and " + COLUMN_PASS + " = " +
                "'"+pass+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            return true;
        }

        cursor.close();
        db.close();

        return false;
    }
}
