package dsa.eetac.upc.edu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FollowersActivity extends MainActivity{

    ImageView ivImageFromUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        ivImageFromUrl = (ImageView)findViewById(R.id.iv_image_from_url);

        Picasso.with(getApplicationContext()).load("https://avatars2.githubusercontent.com/u/43316590?v=4").into(ivImageFromUrl);
    }
}
