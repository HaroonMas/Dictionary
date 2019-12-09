package com.haroonmasjidi.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.haroonmasjidi.dictionary.model.DictionaryClass;

public class DisplayFrench extends AppCompatActivity {
    private TextView word;
    private TextView translated;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_french);

        word = findViewById(R.id.word);
        translated = findViewById(R.id.translated);
        //back = findViewById(R.id.backBTN2);

        DictionaryClass dictionaryClass;
        Bundle bundle;
        bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            Gson gson = new Gson();
            dictionaryClass=gson.fromJson(bundle.getString("translateOBJ"),DictionaryClass.class);

            word.setText(dictionaryClass.getObject());
            translated.setText(dictionaryClass.getFrench());

        }
/*        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Back to Home Page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);

            }
        });*/

    }
}
