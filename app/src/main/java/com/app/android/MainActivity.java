package com.app.android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public EditText urlInput;
    private Button openUrl, closeApp, butCats, butDogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openUrl = findViewById(R.id.open_url);
        closeApp = findViewById(R.id.close);
        butCats = findViewById(R.id.cats);
        butDogs = findViewById(R.id.dogs);
        urlInput = findViewById(R.id.urlText);

        openUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlPage = urlInput.getText().toString();
                openUrlPage(view, urlPage);
            }
        });

        closeApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCloseApp(view);
            }
        });

        butCats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CatsFragment fragment = new CatsFragment();
                setNewFragment(fragment);
            }
        });

        butDogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DogsFragment fragment = new DogsFragment();
                setNewFragment(fragment);
            }
        });
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.frame, fragment);
        t.addToBackStack(null);
        t.commit();
    }

    private void dialogCloseApp(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Закрити додаток?")
                .setMessage("Ви дійсно хочете закрити додаток?")
                .setCancelable(false)
                .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openUrlPage(View view, String url) {
        Intent intent = new Intent(this, UrlPage.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

}