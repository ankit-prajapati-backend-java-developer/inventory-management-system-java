package com.inventory;

import java.util.PriorityQueue;

public class Order implements Comparable<Order> {
    private String orderId;
    private boolean isExpress;
    private PriorityQueue<Order> orderPriorityQueue;

    public Order() {
        // express (true) comes before non-express (false) — min-heap polls smallest first
        this.orderPriorityQueue = new PriorityQueue<>();
    }

    public Order(String orderId, boolean isExpress) {
        this.orderId = orderId;
        this.isExpress = isExpress;
    }

    @Override
    public int compareTo(Order other) {
        return Boolean.compare(other.isExpress, this.isExpress); // express first
    }

    public int getOrderPriorityQueueSize() {
        return orderPriorityQueue.size();
    }

    public PriorityQueue<Order> getOrderPriorityQueue() {
        return orderPriorityQueue;
    }

    public String getOrderId() {
        return orderId;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setExpress(boolean isExpress) {
        this.isExpress = isExpress;
    }

    public void addOrder(Order order) {
        orderPriorityQueue.add(order);
    }

    public void removeOrder(Order order) {
        orderPriorityQueue.remove(order);
    }

    /** Process and remove the highest-priority order (express first). */
    public void processOrder() {
        if (orderPriorityQueue == null || orderPriorityQueue.isEmpty()) {
            System.out.println("No orders to process.");
            return;
        }
        Order order = orderPriorityQueue.poll();
        System.out.println("Processing order: " + order.getOrderId()
                + (order.isExpress() ? " [EXPRESS]" : ""));
    }
}
