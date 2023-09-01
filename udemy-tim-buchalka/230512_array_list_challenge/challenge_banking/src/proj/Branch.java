package proj;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers;
    private Integer branchId;
    private String branchName;

    public Branch(String branchName, Integer branchId) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>(); // create branch with no customers
    }

    public Integer getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addNewCustomer(Integer customerId, String customerName, Double initialTransactionAmount) throws CustomerAlreadyExists {

        if (isCustomerNameOrIdAlreadyBeenUsed(customerId, customerName)){
            throw new CustomerAlreadyExists("The customer trying to be created already exists. Either name or id are already being used.");
        }

        Customer customer = new Customer(customerId, customerName);
        customer.registerNewTransaction(initialTransactionAmount);
        customers.add(customer);
    }

    public void addNewTransaction(Integer customerId, Double transactionAmount) {
        try {
            Customer customer = filterCustomerById(customerId);
            customer.registerNewTransaction(transactionAmount);
            String message = String.format("New transaction added successfully. Customer Name: %s; Customer Id: %d; Transaction Amount: %d.", customer.getCustomerName(), customer.getCustomerId(), transactionAmount);
            System.out.println(message);
        } catch (CustomerNotFoundException e) {
            System.out.println("ERROR: " + e);
            return;
        }
    }

    private Customer filterCustomerById(Integer customerId) throws CustomerNotFoundException {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        throw new CustomerNotFoundException("The customer with customerId=" + customerId + " could not be found.");
    }

    private Customer filterCustomerByName(String branchName) throws CustomerNotFoundException {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer branch = this.customers.get(i);
            if (branch.getCustomerName () == branchName) {
                return branch;
            }
        }
        throw new CustomerNotFoundException("The customer with branchName=" + branchName + " could not be found.");
    }

    private Boolean isCustomerNameOrIdAlreadyBeenUsed(Integer customerId,String customerName){
        try{
            filterCustomerById(customerId);
            return true;
        } catch(CustomerNotFoundException e){
            try{
                filterCustomerByName(customerName);
                return true;
            } catch(CustomerNotFoundException e2){
                return false;
            }
        }
    }
}
