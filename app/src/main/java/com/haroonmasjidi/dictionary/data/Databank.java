package com.haroonmasjidi.dictionary.data;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.haroonmasjidi.dictionary.controller.AppController;
import com.haroonmasjidi.dictionary.model.DictionaryClass;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Databank {

    private String url="https://my-json-server.typicode.com/cgerard321/dictionary/dictionary";
    AppController appController= new AppController();
    ArrayList<DictionaryClass> dictionaryArrayList= new ArrayList<>();

    public List<DictionaryClass> getObject(final Interface callback)
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject jsonObject;
                        for (int i = 0; i < response.length(); i++) {

                            try {
                                jsonObject = response.getJSONObject(i);
                                DictionaryClass dictionary = new DictionaryClass();

                                dictionary.setObject(jsonObject.getString("word"));
                                dictionary.setPos(jsonObject.getString("pos"));
                                dictionary.setDefinition(jsonObject.getString("definition"));
                                dictionary.setFrench(jsonObject.getString("french"));
                                dictionaryArrayList.add(dictionary);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (callback != null) {
                            callback.processFinished(dictionaryArrayList);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        return dictionaryArrayList;
    }
}
