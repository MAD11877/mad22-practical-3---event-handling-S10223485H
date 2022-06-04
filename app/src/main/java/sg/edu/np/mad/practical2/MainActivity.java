package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();
        User myUser = new User();
        myUser.setName(receivingEnd.getStringExtra("name"));
        myUser.setDescription(receivingEnd.getStringExtra("description"));
        myUser.setFollowed(Boolean.valueOf(receivingEnd.getStringExtra("follow")));

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
                }
                else {
                    myFollowButton.setText("Follow");
                    myUser.setFollowed(false);
                }

            }
        });
    }
}