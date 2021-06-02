package br.com.basicscomponents.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransitionImpl;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.basicscomponents.R;
import br.com.basicscomponents.activity.fragment.ChatFragment;
import br.com.basicscomponents.activity.fragment.ContactsFragment;

public class Fragment extends AppCompatActivity {

    private Button btnContacts, btnChat;
    private ChatFragment chatFragment;
    private ContactsFragment contactsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btnChat = findViewById(R.id.btn_chat);
        btnContacts = findViewById(R.id.btn_contacts);

        chatFragment = new ChatFragment();

        //configurar o objeto para o fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_layout, chatFragment);
        transaction.commit();

        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactsFragment = new ContactsFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_layout, contactsFragment);
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatFragment = new ChatFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_layout, chatFragment);
            }
        });
    }
}