package alidoran.ir.sharedprefrence;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtuser;
    EditText edtpass;
    Button btnok;
    SharedPreferences sharedPreferences;
    LinearLayout LinierForm;
    TextView txtuser;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        edtuser = findViewById ( R.id.edtid );
        edtpass = findViewById ( R.id.edtpass );
        btnok = findViewById ( R.id.btnok );
        LinierForm = findViewById ( R.id.LinierForm );
        txtuser = findViewById ( R.id.textuser );

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences ( MainActivity.this );
        String username=sharedPreferences.getString ( "username",null );
        if (username!=null){
            LinierForm.setVisibility ( View.GONE );
            txtuser.setVisibility ( View.VISIBLE );
            txtuser.setText ( username );
        }

            btnok.setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick ( View v ) {
                    String username = edtuser.getText ( ).toString ( );
                    String pass = edtpass.getText ( ).toString ( );

                    SharedPreferences.Editor editor = sharedPreferences.edit ( );
                    editor.putString ( "username" , username );
                    editor.putString ( "pass" , pass );
                    editor.commit ( );
                    Toast.makeText ( MainActivity.this , "ok" , Toast.LENGTH_LONG ).show ( );
                }
            } );

    }
}
