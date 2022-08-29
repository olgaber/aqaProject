package com.provectus.api;

import com.codeborne.selenide.conditions.Or;
import com.google.gson.Gson;
import com.provectus.api.entities.Order;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

/**
 * Автоматизировать работу с ендпоинтами "store" https://petstore.swagger.io/#/
 * Для автоматизации использовать OkHttp, тело запроса (body) можно формировать через JSON или сериализацию,
 * код разделить на отдельные слои - слой API и слой тестов
 * */


public class ApiTest {

    public Order serializeOrder(Order order) throws IOException {

        Gson gson = new Gson();
        String json = gson.toJson(order);

        System.out.println(json);

        RequestBody body = RequestBody.create(json.getBytes());
        Request request = new Request.Builder()
                .post(body)
                .url("https://petstore.swagger.io/v2/store/order")
                .addHeader("Content-Type", "application/json")
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        Order newOrder = gson.fromJson(response.body().string(), Order.class);
        System.out.println(newOrder);
        return newOrder;
    }

    public Order getOrder(String id) throws IOException {

        Gson gson = new Gson();

        Request request = new Request.Builder()
                .get()
                .url("https://petstore.swagger.io/v2/store/order/" + id)
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        Order newOrder = gson.fromJson(response.body().string(), Order.class);
        System.out.println(newOrder);
        return newOrder;

        //Assert.assertEquals(response.code(), 200);
    }

    public void deleteOrder(String id) throws IOException {

        Gson gson = new Gson();

        String url = "https://petstore.swagger.io/v2/store/order/" + id;

        Request request = new Request.Builder()
                .delete()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        System.out.println(response.body().string());

        //Assert.assertEquals(response.code(), 200);
    }

    public void getOrdersList() throws IOException {

        Request request = new Request.Builder()
                .get()
                .url("https://petstore.swagger.io/v2/store/inventory")
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        //Assert.assertEquals(response.code(), 200);

        assert response.body() != null;
        System.out.println(response.body().string());
    }

        /*public String createOrder() throws IOException {

        JSONObject json = new JSONObject();
        json.put("petId", 2);
        json.put("quantity", 3);
        json.put("status", "placed");
        json.put("complete", true);

        RequestBody body = RequestBody.create(json.toString().getBytes());
        Request request = new Request.Builder()
                .post(body)
                .url("https://petstore.swagger.io/v2/store/order")
                .addHeader("Content-Type", "application/json")
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        //System.out.println(response.code());
        //Assert.assertEquals(response.code(), 200);
        //assert response.body() != null;

        String responseBody = response.body().string();
        JSONObject responseJson = new JSONObject(responseBody);

        return responseJson.get("id").toString();
    }
*/
}

