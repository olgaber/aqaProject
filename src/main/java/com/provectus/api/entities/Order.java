package com.provectus.api.entities;

public class Order {

    private String id;
    private int petId;
    private int qty;
    private String status;
    private boolean complete;

    public int getPetId() {
        return petId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", petId=" + petId +
                ", qty=" + qty +
                ", status='" + status + '\'' +
                ", complete=" + complete +
                '}';
    }
}
