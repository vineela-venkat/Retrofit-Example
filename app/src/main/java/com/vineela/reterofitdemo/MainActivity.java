package com.vineela.reterofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Call<List<ModelClass>> call;
    List<ModelClass> list=new ArrayList<>();
    Spinner spinner;
    TextView textView;
    ArrayList<String> hero_names=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        textView=(TextView)findViewById(R.id.textview);
        getdata();

    }

    private void getdata() {

        Retrofit retrofit=new Retrofit.Builder().baseUrl(ApiInterface.BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface=retrofit.create(ApiInterface.class);
        call=apiInterface.getdata();
        call.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                list=response.body();
                if (list!=null&&list.size()>0) {
                    for (ModelClass modelClass : list) {
                        hero_names.add(modelClass.getName());
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, hero_names);
                    spinner.setAdapter(arrayAdapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            textView.setText(list.get(i).getBio());
                            textView.append(list.get(i).getCreatedby());
                            textView.append(list.get(i).getFirstappearance());
                            textView.append(list.get(i).getRealname());

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "empty list", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "something went wrong"+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
