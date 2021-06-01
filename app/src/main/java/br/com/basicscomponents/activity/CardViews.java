package br.com.basicscomponents.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.basicscomponents.R;
import br.com.basicscomponents.activity.adapter.AdapterCardView;
import br.com.basicscomponents.activity.model.Post;

public class CardViews extends AppCompatActivity {

    private RecyclerView recPost;
    private List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_views);

        recPost = findViewById(R.id.recyclerPost);

        //definir layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recPost.setLayoutManager(layoutManager);

        //define adapter
        this.adjustPosts();
        AdapterCardView adapter = new AdapterCardView(posts);
        recPost.setAdapter(adapter);
    }

    public void adjustPosts(){
        Post p = new Post("Gi", "Onti", R.drawable.ic_baseline_favorite);
        this.posts.add(p);

         p = new Post("Bah", "anti onte", R.drawable.ic_baseline_electric_scooter_24);
        this.posts.add(p);

         p = new Post("Tia", "Oge", R.drawable.ic_baseline_comment_24);
        this.posts.add(p);

         p = new Post("Tio", "Sla", R.drawable.ic_launcher_background);
        this.posts.add(p);

         p = new Post("Eu", "Onti", R.drawable.ic_baseline_favorite);
        this.posts.add(p);
    }
}