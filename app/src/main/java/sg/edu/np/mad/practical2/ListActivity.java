package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView myImage = findViewById(R.id.imageClick);

        myImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent){
                QueryActivity();
                return false;
            }
        });
    }

    private void QueryActivity(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Random ran = new Random();
                int value = ran.nextInt();
                Bundle extras = new Bundle();
                extras.putString("RanNum", String.valueOf(value));

                Intent myNewCreate = new Intent(ListActivity.this, MainActivity.class);
                myNewCreate.putExtras(extras);
                startActivity(myNewCreate);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
        /*Extra comment because I had issues pulling and pushing and need to recommit
        Also the file is called Practical 2 since I copy pasted the files but I do not
        know how to change the name.*/
    }
}