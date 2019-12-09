package com.haroonmasjidi.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.haroonmasjidi.dictionary.model.DictionaryClass;

public class DisplayDefinition extends AppCompatActivity {
    private TextView object;
    private TextView pos;
    private TextView definition;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_definition);

        object= findViewById(R.id.object1);
        pos = findViewById(R.id.pos1);
        definition= findViewById(R.id.definiton1);
       // back = findViewById(R.id.backBTN);

        DictionaryClass dictionaryClass;
        Bundle bundle;
        bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            Gson gson = new Gson();
            dictionaryClass=gson.fromJson(bundle.getString("defineOBJ"),DictionaryClass.class);

            object.setText(dictionaryClass.getObject());
            pos.setText(dictionaryClass.getPos());
            definition.setText(dictionaryClass.getDefinition());


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
