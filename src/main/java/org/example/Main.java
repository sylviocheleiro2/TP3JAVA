package org.example;

import org.example.models.JsonGeral;
import org.example.models.JsonUnitario;
import org.example.services.RespostasService;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        listarGeral();

        listarUnidade();

        colocarUnidade();

    }
    public static void listarGeral(){
        try {
            Call<List<JsonGeral>> call = APICLIENT.getRespostasService().list();
            Response<List<JsonGeral>> response = call.execute();
            List<JsonGeral> jsonPlaceHolders = response.body();
            if (jsonPlaceHolders != null) {
                /*
                TIRE PARA LISTAR TODOAS
                for (JsonGeral jsonPlaceHolder : jsonPlaceHolders) {
                    System.out.println("ID: " + jsonPlaceHolder.id);
                    System.out.println("UserID: " + jsonPlaceHolder.userid);
                    System.out.println("Title: " + jsonPlaceHolder.title);
                    System.out.println("Completed: " + jsonPlaceHolder.completed);
                    System.out.println("-----------------------");
                } */
                System.out.println(jsonPlaceHolders.size());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void listarUnidade(){
        try {
            Call<JsonUnitario> call = APICLIENT.getRespostasService().show(44);
            Response<JsonUnitario> response = call.execute();
            JsonUnitario jsonUnitarios = response.body();
            if (jsonUnitarios != null) {
                /* for (JsonGeral jsonPlaceHolder : jsonPlaceHolders) {
                    System.out.println("ID: " + jsonPlaceHolder.id);
                    System.out.println("UserID: " + jsonPlaceHolder.userid);
                    System.out.println("Title: " + jsonPlaceHolder.title);
                    System.out.println("Completed: " + jsonPlaceHolder.completed);
                    System.out.println("-----------------------");
                } */
                System.out.println(jsonUnitarios.title);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  static void colocarUnidade(){
        RespostasService respostasService = APICLIENT.getRespostasService();

        JsonUnitario novoPost = new JsonUnitario();
        novoPost.setId(44);
        novoPost.setTitle("AAAAAAAAAA");
        novoPost.setBody("bar");
        novoPost.setUserId(1);

        Call<JsonUnitario> call = respostasService.createPost(novoPost);
        call.enqueue(new Callback<JsonUnitario>() {
            @Override
            public void onResponse(Call<JsonUnitario> call, Response<JsonUnitario> response) {
                if (response.isSuccessful()) {
                    JsonUnitario jsonUnitario = response.body();
                    System.out.println("ID: " + jsonUnitario.getId());
                    System.out.println("Title: " + jsonUnitario.getTitle());
                    System.out.println("Body: " + jsonUnitario.getBody());
                    System.out.println("UserId: " + jsonUnitario.getUserId());
                } else {
                    System.out.println("Erro de requisição");
                }
            }

            @Override
            public void onFailure(Call<JsonUnitario> call, Throwable t) {
                // Trate falhas de requisição
            }
        });
    }
}
