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

    public void addNewBranch(String branchName, Integer branchId) {
        Branch branch = new Branch(branchName, branchId);
        this.branches.add(branch);
        String message = String.format("New branch added successfully. Name: %s; Id: %d; ", branch.getBranchName(), branch.getBranchId());
        System.out.println(message);
    }

    // TODO: if we don't annotate the function with `throws BranchNotFoundException` does the program works?
    public void addNewBranch(Integer branchId, String name, Double initialTransactionAmount) throws BranchNotFoundException {
        Branch branch = filterBranchById(branchId);
        branch.addNewCustomer(name, initialTransactionAmount);
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

}
