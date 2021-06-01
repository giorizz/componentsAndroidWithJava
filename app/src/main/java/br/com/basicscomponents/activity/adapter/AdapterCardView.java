package br.com.basicscomponents.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.basicscomponents.R;
import br.com.basicscomponents.activity.model.Post;

public class AdapterCardView extends RecyclerView.Adapter<AdapterCardView.MyViewHolder>{

    private List<Post> postsList;

    public AdapterCardView(List<Post> p){
        this.postsList = p;
    }

    @NonNull
    @Override
    public AdapterCardView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cardview, parent, false);
        return new AdapterCardView.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Post postage = postsList.get(position);
        holder.name.setText(postage.getName());
        holder.date.setText(postage.getPostage());
        holder.image.setImageResource(postage.getImage());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView date;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }
    }
}
