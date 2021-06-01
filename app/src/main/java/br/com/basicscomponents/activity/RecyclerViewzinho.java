package br.com.basicscomponents.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.basicscomponents.R;
import br.com.basicscomponents.activity.adapter.Adapter;
import br.com.basicscomponents.activity.model.Movie;

public class RecyclerViewzinho extends AppCompatActivity {

    private RecyclerView recView;
    private List<Movie> listMovie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_viewzinho);

        recView = findViewById(R.id.rec_filmes);

        //Listagem de filmes
        this.createFilm();

        //configurar adapter
        Adapter adapter = new Adapter(listMovie);

        //configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recView.setLayoutManager(layoutManager);
        recView.setHasFixedSize(true);
        recView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recView.setAdapter(adapter);

        //evento de click
        recView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Movie mov = listMovie.get(position);
                        Toast.makeText(getApplicationContext(), "vc precionou: " + mov.getTitleMovie(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Movie mov = listMovie.get(position);
                        Toast.makeText(getApplicationContext(), "vc segurou: " + mov.getGenereMovie(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                })
        );
    }

    public void createFilm() {
        Movie movie = new Movie("Homiranha", "Comedia", "2022");
        this.listMovie.add(movie);

        movie = new Movie("Marveu Mundo", "Acao", "2000");
        this.listMovie.add(movie);

        movie = new Movie("Os desincriveis", "trama", "1002");
        this.listMovie.add(movie);

        movie = new Movie("Todo mundo com fome", "Desepspero", "2094");
        this.listMovie.add(movie);

        movie = new Movie("Tá chovendo Acaí", "Gordos", "1033");
        this.listMovie.add(movie);

        movie = new Movie("Xangricá", "Ironico", "1005");
        this.listMovie.add(movie);

        movie = new Movie("4", "numérico", "300");
        this.listMovie.add(movie);

        movie = new Movie("Remédio", "Genérico", "9494");
        this.listMovie.add(movie);

        movie = new Movie("4xt243t43t", "sla", "1003");
        this.listMovie.add(movie);
    }


}