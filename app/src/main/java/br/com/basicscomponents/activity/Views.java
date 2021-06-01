package br.com.basicscomponents.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import br.com.basicscomponents.R;
import br.com.basicscomponents.activity.RecyclerViewzinho;

public class Views extends AppCompatActivity {

    Button nxtCardView;
    Button recycler1;
    private ListView listLocales;
    private String[] itens = {"Diadema", "Sao leopoldo", "Sao paulo", "Caxias",
            "Londres", "Paris", "França", "Alemanha", "Bósnia",
            "Diadema", "Sao leopoldo", "Sao paulo", "Caxias",
            "Londres", "Paris", "França", "Alemanha", "Bósnia",
            "Diadema", "Sao leopoldo", "Sao paulo", "Caxias",
            "Londres", "Paris", "França", "Alemanha", "Bósnia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        listLocales = findViewById(R.id.list_locales);

        //adaptador para a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                //vai ser o layout a ser exibido
                android.R.layout.simple_list_item_1,
                //vai receber os nossos itens da lista
                android.R.id.text1,
                //ultimo parametro é a lista
                itens
        );

        //adicionar o adapter na lista
        listLocales.setAdapter(adaptador);

        //adiciona o click na lista
        listLocales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectValue = listLocales.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), selectValue, Toast.LENGTH_SHORT).show();
            }
        });


        recycler1 = findViewById(R.id.btn_rec_1);
        recycler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt = new Intent(getApplicationContext(), RecyclerViewzinho.class);
                startActivity(nxt);
            }
        });

        nxtCardView = findViewById(R.id.btn_cv);
        nxtCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt = new Intent(getApplicationContext(), CardViews.class);
                startActivity(nxt);
            }
        });
    }
}