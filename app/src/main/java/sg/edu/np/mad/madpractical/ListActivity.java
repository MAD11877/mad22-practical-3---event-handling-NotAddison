package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "ListActivity";
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        // -- Get Elements
        img = (ImageView) findViewById(R.id.imageLogo);

        // On click
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Clicked on the image");

                // Defining Content in Alert Dialogue
                AlertDialog.Builder builder = new AlertDialog.Builder( ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADNess");
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Log.v(TAG, "Clicked on View");
                        // --- Generating Random Number ---
                        Random random = new Random();
                        int randomNumber = random.nextInt();
                        while (randomNumber < 0){               // Prevent Negative Numbers
                            randomNumber = random.nextInt();
                        }
                        Log.v(TAG, "randomNumber: " + randomNumber);

                        Intent intent = new Intent(ListActivity.this, MainActivity.class);
                        intent.putExtra("Number", String.valueOf(randomNumber));  // Must pass a string value (Not Int)
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Log.v(TAG, "Clicked on Close");
                    }
                });

                AlertDialog alert = builder.create();   // Create the Alert Dialogue
                alert.show();                           // Show the Alert Dialogue
            }
        });
    }
}