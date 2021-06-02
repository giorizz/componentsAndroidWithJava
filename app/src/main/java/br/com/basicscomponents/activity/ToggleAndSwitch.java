package br.com.basicscomponents.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

import br.com.basicscomponents.R;
import br.com.basicscomponents.activity.AlertDialogsAndBars;

public class ToggleAndSwitch extends AppCompatActivity {

    private ToggleButton togglePassword;
    private Switch switchPassword;
    private TextView textResult;
    private CheckBox checkPassword;
    private Button btnToast, nxtPage, btnFragment, btnSnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_and_switch);

        togglePassword = findViewById(R.id.toggle_pass);
        switchPassword = findViewById(R.id.sw_pass);
        textResult = findViewById(R.id.result);
        checkPassword = findViewById(R.id.check_pass);

        btnToast = findViewById(R.id.btn_toast);
        btnSnack = findViewById(R.id.btn_snackbar);

        btnSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Botão pressionado", Snackbar.LENGTH_LONG).setAction("alterar texto", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnSnack.setText("alterou a snack");
                    }
                }).setActionTextColor(getResources().getColor(R.color.design_default_color_error)).show();
            }
        });

        addListener();

        nxtPage = findViewById(R.id.btn_next);
        nxtPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toggleSwitch = new Intent(getApplicationContext(), AlertDialogsAndBars.class);
                startActivity(toggleSwitch);
            }
        });

        btnFragment = findViewById(R.id.btn_fragments);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fragment.class);
                startActivity(intent);
            }
        });
    }

    public void toastBtn(View view) {
        Toast.makeText(this, "TOAST MAROTO", Toast.LENGTH_SHORT).show();
    }

    public void toastBtnImage(View view) {
        Toast toast = new Toast(this);
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.ic_baseline_electric_scooter_24);
        toast.setView(image);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();

    }

    public void sendPass(View view) {
        if (switchPassword.isChecked()) {
            textResult.setText("Switch Ligado");
        } else {
            textResult.setText("Switch Desligado");
        }
//        if (togglePassword.isChecked()){
//            textResult.setText("Toggle Ligado");
//        }else{
//            textResult.setText("Toggle Desligado");
//        }
    }

    public void addListener() {
        checkPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textResult.setText("Ligado");
                } else {
                    textResult.setText("Desligado");
                }
            }
        });
    }
}