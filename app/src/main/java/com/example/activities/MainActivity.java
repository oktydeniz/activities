package com.example.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView);
        //ilk activity calistigi  gibi calisiyor. Fakat henuz kullanici UI kismi gormuyor.Uygulamadan acikildi fakat destroy edilmediyse
        // oncreate tekrar cagirilmaz onStart ve onResume cagirilir. Bunun nedeni bastan birsey olusturmuyoruz.

        // - savedInstanceState (paket)
        // App' in icinde bulundugu durumu kaydeden ve sonra geri getiren Bundle' dir.
        //

        Log.i(TAG, "onCreate: ");

        findViewById(R.id.button2).setOnClickListener(view -> startActivity(new Intent(this, MainActivity2.class)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
        //onCreate den sonra veya activity arkaplana alininip tekrar cagirilinca calisan fonksiyondur.

        
    }


    public void changeText(View v){
        textView.setText(editText.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
        //kullanici bu fonksiyon cagrildigi zaman anca UI ile etkilesime gecebilir, veya gorur.

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
        //Telefon uyku moduna girince veya arka plana alininca calisacak fonksiyon.
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
        //uygulama komple kapatilirsa cagirilir.

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
        //onPauseden sonra calisacak fonksiyon uygulama arkaplandayken yine calistirilir.
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //onStop fonksiyonundan once calisan ve kaydedilecek degerler bu fonksiyon icinde kaydedilir.
        outState.putString("name",editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Kaydedilen deger var ise buradan alinir.
        textView.setText(savedInstanceState.getString("name"));

    }

}