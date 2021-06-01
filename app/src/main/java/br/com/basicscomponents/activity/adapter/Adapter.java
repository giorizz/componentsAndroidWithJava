package br.com.basicscomponents.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.basicscomponents.R;
import br.com.basicscomponents.activity.model.Movie;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Movie> listMovies;
    public Adapter(List<Movie> list){
        this.listMovies = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = listMovies.get(position);
        holder.title.setText(movie.getTitleMovie());
        holder.genere.setText(movie.getGenereMovie());
        holder.year.setText(movie.getYearMovie());
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView year;
        TextView genere;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            year = itemView.findViewById(R.id.txt_year);
            genere = itemView.findViewById(R.id.txt_genere);
        }
    }
}
