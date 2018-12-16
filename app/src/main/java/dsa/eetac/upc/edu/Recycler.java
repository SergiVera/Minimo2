package dsa.eetac.upc.edu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {
    private List<User> data;
    private Context context;

    public void addFollowers(List<User> followersList) {
        data.addAll(followersList);
        notifyDataSetChanged();
    }

    //Asign the text TextView to the text1 in the layout
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView followerNameView;
        private ImageView photoFollower;

        public ViewHolder(View v) {
            super(v);
            followerNameView = v.findViewById(R.id.followerNameView);
            photoFollower = v.findViewById(R.id.photoFollower);
        }
    }

    //Constructor
    public Recycler(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    @Override
    public Recycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follower, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Recycler.ViewHolder holder, int position) {
        User userData = data.get(position);
        holder.followerNameView.setText(userData.login);

        Picasso.with(context).load(userData.avatar_url).into(holder.photoFollower);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




}


