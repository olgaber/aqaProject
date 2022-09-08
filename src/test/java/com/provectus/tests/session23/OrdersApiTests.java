package com.provectus.tests.session23;

import com.provectus.api.ApiTest;
import com.provectus.api.entities.Order;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrdersApiTests {

    @Test
    public void createNewOrder() throws IOException {
        Order newOrder = createNewOrderMethod();
        Assert.assertNotNull(newOrder.getId());
    }

    @Test
    public void getOrder() throws IOException {
        String id = createNewOrderMethod().getId();
        ApiTest apiTest = new ApiTest();
        String retrievedId = apiTest.getOrder(id).getId();

        Assert.assertEquals(retrievedId, id);
    }

    @Test
    public void deleteOrder() throws IOException {
        String id = createNewOrderMethod().getId();
        ApiTest apiTest = new ApiTest();
        apiTest.deleteOrder(id);
        //How to make sure the order was deleted?
    }

    @Test
    public void getOrdersList() throws IOException {
        ApiTest apiTest = new ApiTest();
        apiTest.getOrdersList();
    }

    // help method
    public Order createNewOrderMethod() throws IOException {

        ApiTest apiTest = new ApiTest();

        Order order = new Order();
        order.setId(null);
        order.setComplete(true);
        order.setPetId(789);
        order.setQty(4);
        order.setStatus("available");

        order = apiTest.serializeOrder(order);

        return order;
    }
}
