package proj;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions;
    private Integer customerId;
    private String customerName;

    public Customer(String name) {
        this.transactions = new ArrayList<>(); // create an empty ArrayList
        this.customerName = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public void registerNewTransaction(Double transaction) {
        this.transactions.add(transaction);
    }

}
