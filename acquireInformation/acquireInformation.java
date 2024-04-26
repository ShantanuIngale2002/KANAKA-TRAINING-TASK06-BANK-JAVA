package Task06Bank2404.acquireInformation;
import Task06Bank2404.information.bankInformation;
import Task06Bank2404.rbiProtocol.rbiProtocol;

import java.util.Scanner;


public class acquireInformation extends bankInformation implements rbiProtocol{

    private String bankShortCode;
    private String bankName;
    public void initializeSuper(String s1, String s2){
        this.bankName = s1;
        this.bankShortCode = s2;
    }

    private Scanner sc = new Scanner(System.in);
    private int inpi;
    private float inpf;
    private String inps;

    public void setBankDetails(){
        String bank=bankShortCode.toLowerCase();
        this.setBankAccountNumber();
        System.out.print("Select Acc_type (1. Savings / 2. Current) --> Choose : ");
        inpi=sc.nextInt();
        while(inpi!=1 && inpi!=2){
            System.out.print("Invalid type, Enter again : ");
            inpi=sc.nextInt();
        }
        this.setBankAccountType(inpi);
        
        System.out.print("Select Branch (1. Nashik / 2. Pune) --------> Choose : ");
        inpi=sc.nextInt();
        switch (bank){
            case "sbi":
                switch (inpi) {
                    case 1:
                        this.setBankIfsc(bankCodes.get(bank), sbiBranchCodes.get("nashik"));
                        break;
                    case 2:
                        this.setBankIfsc(bankCodes.get(bank), sbiBranchCodes.get("pune"));
                        break;
                    default:
                        this.setBankIfsc(bankCodes.get(bank), sbiBranchCodes.get("mumbai"));
                        break;
                }
                break;
            
            case "hdfc":
                switch (inpi) {
                    case 1:
                        this.setBankIfsc(bankCodes.get(bank), hdfcBranchCodes.get("nashik"));
                        break;
                    case 2:
                        this.setBankIfsc(bankCodes.get(bank), hdfcBranchCodes.get("pune"));
                        break;
                    default:
                        this.setBankIfsc(bankCodes.get(bank), hdfcBranchCodes.get("mumbai"));
                        break;
                }
                break;
            
            default:
                break;
        }
    }

    public boolean setUserDetails(){
        sc.nextLine();
        System.out.print("Enter Customer Name  : ");
        inps=sc.nextLine();
        this.setUserAccountName(inps);

        System.out.print("Enter Contact Number : ");
        inps=sc.nextLine();
        while(!this.setUserContact(contactCode,inps)){
            System.out.print("Invalid Contact, Enter again : ");
            inps=sc.nextLine();
        }

        System.out.print("Enter Adhaar Number  : ");
        inps=sc.nextLine();
        while(!this.setUserAdhaar(inps)){
            System.out.print("Invalid Adhaar, Enter again : ");
            inps=sc.nextLine();
        }

        System.out.print("Enter Address        : ");
        inps=sc.nextLine();
        this.setUserAddress(inps);

        System.out.print("Enter Date of Birth  : ");
        inps=sc.nextLine();
        while(!this.setUserDOB(inps)){
            System.out.print("User seems underage, If its the case Enter yes ELSE try again : ");
            inps=sc.nextLine();
            if(inps.toLowerCase().equals("yes")){return false;}
        }

        return true;
    }
    
    public boolean withdrawAmount(){
        System.out.print("Enter the amount to withdraw : ");
        inpf=sc.nextFloat();
        if(this.getBalance()-inpi < 0){
            System.out.println("Account have in-sufficient balance.");
            return false;
        }
        this.updateBalanceOnWithdrawal(inpf);
        System.out.println("Amount has been successfully Debited.");
        return true;
    }
    
    public boolean depositeAmount(){
        System.out.print("Enter the amount to deposit : ");
        inpf=sc.nextFloat();
        this.updateBalanceOnDeposite(inpf);
        System.out.println("Amount has been successfully Credited.");
        return true;
    }
    
    public void showDetails(){
        System.out.println("Bank Name       : "+ this.bankName);
        System.out.println("Account Holder  : "+ this.getAccountHolderName());
        System.out.println("Account Number  : "+ this.getAccontNumber());
        System.out.println("IFSC code       : "+ this.getIfsc());
        System.out.println("Adhaar Number   : "+ this.getAdhaar());
        System.out.println("Date Of Birth   : "+ this.getDOB());
        System.out.println("Contact         : "+ this.getContact());
        System.out.println("Account Balance : Rs. "+ this.getBalance());
    }

    public String provideAccountNumber(){
        return this.getAccontNumber(); 
    }


}
