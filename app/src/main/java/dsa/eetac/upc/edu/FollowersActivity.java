package dsa.eetac.upc.edu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FollowersActivity extends MainActivity{

    private APIRest myapirest;
    private Retrofit retrofit;
    private User user;

    public String message;
    ImageView ivImageFromUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        ivImageFromUrl = (ImageView)findViewById(R.id.iv_image_from_url);

        myapirest = APIRest.createAPIRest();

        getData();

        Picasso.with(getApplicationContext()).load(user.avatar_url).into(ivImageFromUrl);

    }

    private void getData() {
        Call<User> userCall = myapirest.getProfile(message);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    user = response.body();

                    Log.i("Login: " + user.login, response.message());
                    Log.i("id: " + user.id, response.message());
                    Log.i("public_repos: " + user.public_repos, response.message());
                    Log.i("followers: " + user.followers, response.message());
                    Log.i("following: " + user.following, response.message());
                    Log.i("avatar_url: " + user.avatar_url, response.message());

                }
                else{
                    Log.e("No api connection", String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("No api connection", t.getMessage());
            }
        });
    }
}
