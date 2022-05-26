package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();
        String RanNum = receivingEnd.getStringExtra("RanNum");

        User myUser = new User();
        myUser.setName("MAD " + RanNum);
        myUser.setDescription("A very long message to fill in the gaps which I have decided not to copy and paste from the original activity as it is not only incredibly long, it is also trapped within the confines of an image preventing the copy and paste.");
        myUser.setFollowed(false);

        TextView Name = findViewById(R.id.myName);
        Name.setText(myUser.getName());
        TextView Description = findViewById(R.id.myDescription);
        Description.setText(myUser.getDescription());

        Button myFollowButton = findViewById(R.id.myFollowButton);

        myFollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myUser.isFollowed() != true) {
                    myFollowButton.setText("Unfollow");
                    myUser.setFollowed(true);
                    Toast.makeText(MainActivity.this,"Followed",Toast.LENGTH_SHORT).show();
                }
                else {
                    myFollowButton.setText("Follow");
                    myUser.setFollowed(false);
                    Toast.makeText(MainActivity.this,"Unfollowed",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}