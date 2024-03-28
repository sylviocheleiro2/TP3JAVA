package org.example;

import org.example.models.JsonUnitario;
import org.example.services.RespostasService;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICLIENT {
    private final Retrofit retrofit;
    private static APICLIENT instance = null;
    private APICLIENT(){
        String baseUrl = "https://jsonplaceholder.typicode.com/";
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private static APICLIENT getInstance(){
        if(instance == null){
           instance = new APICLIENT();
        }
        return instance;
    }
    public static RespostasService getRespostasService(){
        return getInstance().retrofit.create(RespostasService.class);
    }
    public static Call<JsonUnitario> createPost(JsonUnitario novoPost) {
        return (Call<JsonUnitario>) getInstance().retrofit.create(RespostasService.class);
    }
}
