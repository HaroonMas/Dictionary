package com.haroonmasjidi.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.haroonmasjidi.dictionary.data.Databank;
import com.haroonmasjidi.dictionary.data.Interface;
import com.haroonmasjidi.dictionary.data.RecyclerViewAdapter;
import com.haroonmasjidi.dictionary.model.DictionaryClass;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<DictionaryClass> dictionaryList;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dictionaryList = new Databank().getObject(new Interface() {
            @Override
            public void processFinished(ArrayList<DictionaryClass> dictionaryArrayList) {
                for(int i=0;i<dictionaryArrayList.size();i++){
                    Log.d("json", "processFinished: " + dictionaryArrayList.get(i).getObject());
                }

                recyclerView=findViewById(R.id.recyclerV);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                recyclerViewAdapter= new RecyclerViewAdapter(MainActivity.this, dictionaryArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);

            }
        });
    }
}
