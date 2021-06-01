package br.com.basicscomponents.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import br.com.basicscomponents.R;

public class MainActivity extends AppCompatActivity {

    EditText nameSpace;
    EditText mailSpace;
    TextView textRes;

    Button nxtPage;
    Button nxtViews;

    private CheckBox checkGreen, checkYellow, checkBlue;

    private RadioButton sexoMasc, sexoFem;

    private RadioGroup optSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //inputs
        nameSpace = findViewById(R.id.et_name);
        mailSpace = findViewById(R.id.et_mail);
        textRes = findViewById(R.id.result_text);

        //checkbox
        checkGreen = findViewById(R.id.color_green);
        checkYellow = findViewById(R.id.color_yellow);
        checkBlue = findViewById(R.id.color_blue);

        //radio button
        sexoFem = findViewById(R.id.radioF);
        sexoMasc = findViewById(R.id.radioM);
        optSex = findViewById(R.id.rd_group);

        radioButton();

        //next page button
        nxtPage = findViewById(R.id.btn_next);
        nxtPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toggleSwitch = new Intent(getApplicationContext(), ToggleAndSwitch.class);
                startActivity(toggleSwitch);
            }
        });

        //news views
        nxtViews = findViewById(R.id.btn_new_views);
        nxtViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt = new Intent(getApplicationContext(), Views.class);
                startActivity(nxt);
            }
        });
    }

    public void radioButton() {
        optSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioM) {
                    textRes.setText("Masculino");
                } else if (checkedId == R.id.radioF) {
                    textRes.setText("Feminino");
                }
            }
        });
//        if (sexoMasc.isChecked()){
//            textRes.setText("Masculino");
//        }else if(sexoFem.isChecked()){
//            textRes.setText("Feminino");
//
//        }
    }


    public void send(View view) {
        String name = nameSpace.getText().toString();
        String mail = mailSpace.getText().toString();
        textRes.setText(name + ' ' + mail);

//        radioButton();

//        checkbox();
    }

    public void clear(View view) {
        mailSpace.setText("");
        nameSpace.setText("");
    }

    private void checkbox() {

        String text = "";
        if (checkGreen.isChecked()) {
//            String colorSelected = checkGreen.getText().toString();
//            text = colorSelected;
            text = "Verde selecionado - ";
        }

        if (checkYellow.isChecked()) {
            text = text + "Amarelo selecionado - ";
        }

        if (checkBlue.isChecked()) {
            text = text + "Azul selecionado - ";
        }

        textRes.setText(text);
    }
}