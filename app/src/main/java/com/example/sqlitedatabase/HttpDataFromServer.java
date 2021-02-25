package com.example.sqlitedatabase;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpDataFromServer extends Activity {

    private TextView txtview;
    private Button btn;
    private String JSONData="";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.http_datafom_server);

      txtview = findViewById(R.id.txtView);
      btn = findViewById(R.id.btn);



        btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

             new AsyncTask() {
                  @Override
                  protected Object doInBackground(Object[] objects) {

                      OkHttpClient client = new OkHttpClient();

                      Request request = new Request.Builder()
                              .url("https://jsonplaceholder.typicode.com/posts")
                              .build();
                      Response response = null;

                      try {
                          response = client.newCall(request).execute();
                          return response.body().string();

                      }catch (IOException e){
                          e.printStackTrace();
                      }
                      return null;
                  }

                  @Override
                  protected void onPostExecute(Object o) {
                      super.onPostExecute(o);

                      JSONData = o.toString();

                      DisplayTitle();

//                      txtview.setText(o.toString());

                  }
              }.execute();

          }
      });

    }

    private void DisplayTitle() {

        try {
            JSONArray array = new JSONArray(JSONData);

            for (int i = 0; i < array.length(); i++) {

                try {
                    JSONObject object = array.getJSONObject(i);

                    try {
                        System.out.println("title: "+object.getString("title"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
