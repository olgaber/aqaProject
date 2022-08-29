package com.provectus.tests.session23;

import com.provectus.api.ApiTest;
import com.provectus.api.entities.Order;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrdersApiTests {

    @Test
    public Order createNewOrder() throws IOException {

        ApiTest apiTest = new ApiTest();
        //String newOrderId = apiTest.createOrder();

        Order order = new Order();
        order.setId(null);
        order.setComplete(true);
        order.setPetId(789);
        order.setQty(4);
        order.setStatus("available");

        Order newOrder = apiTest.serializeOrder(order);

        Assert.assertNotNull(newOrder.getId().toString());
        return newOrder;
    }

    @Test
    public void getOrder() throws IOException {
        String id = createNewOrder().getId().toString();
        ApiTest apiTest = new ApiTest();
        String retrievedId = apiTest.getOrder(id).getId();

        Assert.assertEquals(retrievedId, id);
    }

    @Test
    public void deleteOrder() throws IOException {
        String id = createNewOrder().getId().toString();
        ApiTest apiTest = new ApiTest();
        apiTest.deleteOrder(id);
        //How to make sure the order was deleted?
    }

    @Test
    public void getOrdersList() throws IOException {
        ApiTest apiTest = new ApiTest();
        apiTest.getOrdersList();
    }
}
