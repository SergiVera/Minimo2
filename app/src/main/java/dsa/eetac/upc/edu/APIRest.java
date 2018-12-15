package dsa.eetac.upc.edu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIRest {
    //We specify the url
    String BASE_URL = "https://api.github.com/users/";

    //We add the GET method to obtain the profile of the given user
    @GET("{username}")
    Call<User> getProfile(@Path("username") String username);

    //We add the GET method to obtain the followers of the user
    @GET("{username}/followers")
    Call<List<User>> getFollowers(@Path("username") String username);

    static APIRest createAPIRest() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(APIRest.class);
    }
}
