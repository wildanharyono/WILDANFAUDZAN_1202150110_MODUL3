package com.example.haryono.wildanfaudzan_1202150110_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

        EditText username, password; //Membuat object dari class EdiText
        String usernya, passwordnya; //Membuat object string

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log_in);

            password = (EditText) findViewById(R.id.password); //Memanggil ID EditText
        }

        /*Membuat Method onclick pada button*/
        public void login(View view) {
            username = (EditText) findViewById(R.id.username); //Memanggil ID EditText
            password = (EditText) findViewById(R.id.password); //Memanggil ID EditText
            usernya = username.getText().toString(); //Mengambil value (nilai) pada username
            passwordnya = password.getText().toString(); //Mengambil value (nilai) pada password

        /*Membuat Kondisi Ketika Button Di Tekan*/
            if ((usernya.contains("EAD")) && ((passwordnya.contains("MOBILE"))))
            //Jika text1(username) Dan text2(password) sama dengan kondisi maka tampilkan toast dan pindah activity
            {
                Toast.makeText(this, "Anda Berhasil Login", Toast.LENGTH_SHORT).show(); //Menampilkan toast
                Intent intent = new Intent(LogInActivity.this, MainActivity.class); //Berpindah activity
                startActivity(intent); //Menjalankan Activity
            } else if ((usernya.matches("") || passwordnya.matches("")))
            //Atau jika input text 1 dan text 2 kosong maka tampilkan toast
            {
                Toast.makeText(this, "Isikan Username dan Password", Toast.LENGTH_SHORT).show(); //menampilkan toast

            } else
            //jika kedua kondisi diatas tidak memenuhi maka tampilkan toast
            {
                Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_SHORT).show(); //menampilkan toast
            }

        }
    }
