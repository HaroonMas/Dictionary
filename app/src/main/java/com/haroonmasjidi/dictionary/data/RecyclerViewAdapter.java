package com.haroonmasjidi.dictionary.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.haroonmasjidi.dictionary.DisplayDefinition;
import com.haroonmasjidi.dictionary.DisplayFrench;
import com.haroonmasjidi.dictionary.R;
import com.haroonmasjidi.dictionary.model.DictionaryClass;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<DictionaryClass> dictionaryList;
    private DictionaryClass dictionaryClass;

    public RecyclerViewAdapter(Context context, ArrayList<DictionaryClass> dictionaryList){
        this.context=context;
        this.dictionaryList=dictionaryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dictionary,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        dictionaryClass=dictionaryList.get(position);

        holder.object.setText(dictionaryClass.getObject());
        holder.pos.setText(dictionaryClass.getPos());

    }

    @Override
    public int getItemCount() {
        return dictionaryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView object;
        private TextView pos;

        private Button define;
        private Button translate;


        public ViewHolder(@NonNull View view) {
            super(view);
            object = view.findViewById(R.id.object);
            pos = view.findViewById(R.id.pos);

            define = view.findViewById(R.id.defineBTN);
            translate = view.findViewById(R.id.frenchBTN);

            define.setOnClickListener(this);
            translate.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.defineBTN:
                int position = getAdapterPosition();
                DictionaryClass dictionaryClass = dictionaryList.get(position);

                Gson gson = new Gson();
                String definitionString = gson.toJson(dictionaryClass);

                Intent intent = new Intent(view.getContext(), DisplayDefinition.class);
                intent.putExtra("defineOBJ", definitionString);

                view.getContext().startActivity(intent);
                break;
                case R.id.frenchBTN:
                    int position2 = getAdapterPosition();
                    DictionaryClass dictionaryClass2 = dictionaryList.get(position2);

                    Gson gson2 = new Gson();
                    String translateString = gson2.toJson(dictionaryClass2);

                    Intent intent2 = new Intent(view.getContext(), DisplayFrench.class);
                    intent2.putExtra("translateOBJ", translateString);

                    view.getContext().startActivity(intent2);
                    break;

            }


        }
    }
}
