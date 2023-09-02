package com.example.coba_sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    EditText komentarText;
    Button btnsimpan;
    public static final String TAG = "SIKLUS HIDUP ACT";
    private String getDefaultSharedPreferences(String key) {
        return this.getSharedPreferences("siklus hidup", Context.MODE_PRIVATE).getString(key, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        komentarText = findViewById(R.id.komentarText);
        btnsimpan = findViewById(R.id.btnsimpan);
        text1 = findViewById(R.id.text1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT);
        System.out.println(TAG+" On Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT);
        System.out.println(TAG+" On Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT);
        System.out.println(TAG+" On Resume");
        String dataTersimpan = this.getSharedPreferences("siklus hidup", Context.MODE_PRIVATE).getString("komentar", null);
        komentarText.setText(dataTersimpan);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT);
        System.out.println(TAG+" On Destroy");
        SharedPreferences.Editor data = this.getSharedPreferences("siklus hidup", Context.MODE_PRIVATE).edit();
        data.putString("komentar", komentarText.getText().toString());
        data.commit();
    }
}