package dsa.eetac.upc.edu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class User {
    @SerializedName("login")
    @Expose
    String login;
    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("public_repos")
    @Expose
    int public_repos;
    @SerializedName("followers")
    @Expose
    int followers;
    @SerializedName("following")
    @Expose
    int following;
    @SerializedName("avatar_url")
    @Expose
    String avatar_url;

    public User(String login, int id, int public_repos, int followers, int following, String avatar_url) {
        this.login = login;
        this.id = id;
        this.public_repos = public_repos;
        this.followers = followers;
        this.following = following;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String toString() {
        return(login);
    }
}
