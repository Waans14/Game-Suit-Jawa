package com.millenialzdev.mysuitjawa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvScore;
    private ImageView ivKom, ivPlayer;
    private Button btnJempol, btnTelunjuk, btnKelingking;
    private int scorePlayer = 0, scoreKomputer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvScore = findViewById(R.id.tvScore);
        ivKom = findViewById(R.id.ivKom);
        ivPlayer = findViewById(R.id.ivPlayer);
        btnJempol = findViewById(R.id.btnJempol);
        btnTelunjuk = findViewById(R.id.btnTelunjuk);
        btnKelingking = findViewById(R.id.btnKelingking);

        btnJempol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPlayer.setImageResource(R.drawable.jempol_atas);
                String message = gamestart("jempol");
                Toast.makeText(MainActivity.this, "Player Memilih Jempol, "+message, Toast.LENGTH_SHORT).show();
                tvScore.setText("Score Player : " + Integer.toString(scorePlayer) + " Komputer : " + Integer.toString(scoreKomputer));
            }
        });

        btnTelunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPlayer.setImageResource(R.drawable.telunjuk_atas);
                String message = gamestart("telunjuk");
                Toast.makeText(MainActivity.this, "Player Memilih Telunjuk, "+message, Toast.LENGTH_SHORT).show();
                tvScore.setText("Score Player : " + Integer.toString(scorePlayer) + " Komputer : " + Integer.toString(scoreKomputer));
            }
        });

        btnKelingking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivPlayer.setImageResource(R.drawable.kelingking_atas);
                String message = gamestart("kelingking");
                Toast.makeText(MainActivity.this, "Player Memilih Kelingking, "+message, Toast.LENGTH_SHORT).show();
                tvScore.setText("Score Player : " + Integer.toString(scorePlayer) + " Komputer : " + Integer.toString(scoreKomputer));
            }
        });
    }

    private String gamestart(String player) {

        String komputer = "";
        Random angka_random = new Random();

        int angka_komputer = angka_random.nextInt(3) + 1;

        //nentuin pilihan komputernya
        if (angka_komputer  == 1){
            komputer = "jempol";
        }else if (angka_komputer == 2 ){
            komputer = "telunjuk";
        }else if (angka_komputer == 3 ){
            komputer = "kelingking";
        }

        if (komputer == "jempol"){
            ivKom.setImageResource(R.drawable.jempol_bawah);
        }else if(komputer == "telunjuk"){
            ivKom.setImageResource(R.drawable.telunjuk_bawah);
        }else if(komputer == "kelingking"){
            ivKom.setImageResource(R.drawable.kelingking_bawah);
        }


        //aturan main
        if (komputer == player){
            return "SERI";
        }else if (player == "jempol" && komputer == "telunjuk"){
            scorePlayer++;
            return "Player Menang";
        }else if (player == "jempol" && komputer == "kelingking"){
            scoreKomputer++;
            return "Player Kalah";
        }else if (player == "telunjuk" && komputer == "jempol"){
            scoreKomputer++;
            return "Player Kalah";
        }else if (player == "telunjuk" && komputer == "kelingking"){
            scorePlayer++;
            return "Player Menang";
        }else if (player == "kelingking" && komputer == "jempol"){
            scorePlayer++;
            return "Player Menang";
        }else{
            scoreKomputer++;
            return "Player Kalah";
        }

    }
}