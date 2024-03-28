package org.example.services;

import org.example.models.JsonGeral;
import org.example.models.JsonUnitario;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RespostasService {
    @GET("/posts")
        //TODOS
    Call<List<JsonGeral>> list();

    @GET("/posts/{id}")
    Call<JsonUnitario> show(@Path("id") int id);

    @POST("/posts")
     Call<JsonUnitario> createPost(@Body JsonUnitario post);
}
