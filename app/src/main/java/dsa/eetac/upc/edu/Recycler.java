package dsa.eetac.upc.edu;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {
    private List<User> data;

    //Asign the text TextView to the text1 in the layout
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView followerNameView;
        public ImageView photoFollower;
        public TextView text;

        public ViewHolder(View v) {
            super(v);
            followerNameView = v.findViewById(R.id.followerNameView);
            photoFollower = v.findViewById(R.id.photoFollower);

            text = (TextView) v.findViewById(android.R.id.text1);
        }
    }

    //Constructor
    public Recycler(List<User> data) {
        this.data = data;
    }

    @Override
    public Recycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Recycler.ViewHolder holder, int position) {
        User userData = ((User) data.get(position));
        holder.itemView.setTag(userData.id);
        holder.text.setText(userData.toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




}


