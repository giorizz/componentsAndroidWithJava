package br.com.basicscomponents.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import br.com.basicscomponents.R;

public class AlertDialogsAndBars extends AppCompatActivity {

    private ProgressBar progressHori;
    private ProgressBar progressCicle;
    private int progress = 0;

    private SeekBar seekScale;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialogs_and_bars);

        progressHori = findViewById(R.id.pbHorizontal);
        progressCicle = findViewById(R.id.pbVertical);

        seekScale = findViewById(R.id.seekBarScale);
        txtRes = findViewById(R.id.txt_res);

        seekScale.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtRes.setText("Progresso: " + progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void recProgress(View view){
        txtRes.setText("Escolhido: " + seekScale.getProgress());
    }


    public void carregarProgressBar(View view){
        //progress horizontal
        this.progress = this.progress + 1;
        progressHori.setProgress(this.progress);
        
        //progress circular
        this.progressCicle.setVisibility(View.VISIBLE);

        if (progress == 11){
            this.progressCicle.setVisibility(View.GONE);
            progressHori.setProgress(this.progress = 0);
        }
    }

    public void abrirDialog(View view) {
        //instancia Alert Dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());

        //configurar cancelamento(sair do alert)
        dialog.setCancelable(false);

        //configure icone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);
        //configurar titulo e msg
        dialog.setTitle("Título de Dialog");
        dialog.setMessage("Mensagem da Dialog");
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Executar ação ao clicar no Sim", Toast.LENGTH_SHORT).show();
            }
        });
        //criar e exibir AlertDialog
        dialog.create();
        dialog.show();
    }
}