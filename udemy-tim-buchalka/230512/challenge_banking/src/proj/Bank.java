package proj;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches;
    private String bankName;
    private Integer bankId;

    public Bank(String bankName, Integer bankId) {
        this.branches = new ArrayList<Branch>();
        this.bankName = bankName;
        this.bankId = bankId;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public String getBankName() {
        return bankName;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void addNewBranch(Integer branchId, String branchName) throws BranchAlreadyExists {
        Branch branch = new Branch(branchName, branchId);
        if (isBranchNameOrIdAlreadyBeenUsed(branchName, branchId)){
            throw new BranchAlreadyExists("The branch trying to be created already exists. Either name or id are already being used.");
        }
        branches.add(branch);
        String message = String.format("New branch added successfully. Name: %s; Id: %d; ", branch.getBranchName(), branch.getBranchId());
        System.out.println(message);
    }

    // TODO: if we don't annotate the function with `throws BranchNotFoundException` does the program works?
    // The IDE will show an error if we don't annotate with throws
    public void addNewCustomer(Integer branchId, Integer customerId, String customerName, Double initialTransactionAmount) throws BranchNotFoundException, CustomerAlreadyExists {
        Branch branch = filterBranchById(branchId);
        branch.addNewCustomer(customerId,customerName, initialTransactionAmount);
    }

    private Branch filterBranchById(Integer branchId) throws BranchNotFoundException {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getBranchId() == branchId) {
                return branch;
            }
        }
        throw new BranchNotFoundException("The branch with branchId=" + branchId + " could not be found.");
    }

    private Branch filterBranchByName(String branchName) throws BranchNotFoundException {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getBranchName () == branchName) {
                return branch;
            }
        }
        throw new BranchNotFoundException("The branch with branchName=" + branchName + " could not be found.");
    }

    private Boolean isBranchNameOrIdAlreadyBeenUsed(String branchName, Integer branchId){
        try{
            filterBranchById(branchId);
            // this is autoboxing
            return true;
        } catch(BranchNotFoundException e){
            try{
                filterBranchByName(branchName);
                // this is autoboxing
                return true;
            } catch(BranchNotFoundException e2){
                // this is autoboxing
                // because false is of type boolean, but the compiler knows to transform it into Boolean class
                return false;
            }
        }
    }

}
