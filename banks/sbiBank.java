package Task06Bank2404.banks;
import Task06Bank2404.acquireInformation.acquireInformation;
import java.util.List;
import java.util.ArrayList;

public class sbiBank extends acquireInformation {

    private String bankName = "State Bank Of India";
    private String bankShortCode = "sbi";
    private List<acquireInformation> SBI_allAccounts = new ArrayList<acquireInformation>();

    public void initializeAccount(){
        this.initializeSuper(bankName, bankShortCode);
    }

    public boolean findAccount(String acc){
        for(acquireInformation i: SBI_allAccounts){
            if(i.provideAccountNumber().equals(acc)){
                return true;
            }
        }
        System.out.println("Account number is invalid");
        return false;
    }

    public boolean addNewDetails(){
        this.setBankDetails();
        boolean flag=this.setUserDetails();
        if(!flag){
            System.out.println("Under-age people are not allowed.");
        }
        return flag;
    }

    public void saveNewAccount(){
        SBI_allAccounts.add(this);
        System.out.println("A new SBI Account Number >> "+this.provideAccountNumber() +" #Make sure to use it properly.");
    }

    public void CreditAmount(String acc){
        // .get() only takes int as parameter hence iteration
        for(acquireInformation i: SBI_allAccounts){
            if(i.provideAccountNumber().equals(acc)){
                i.depositeAmount();
                break;
            }
        }
    }

    public void DebitAmount(String acc){
        for(acquireInformation i: SBI_allAccounts){
            if(i.provideAccountNumber().equals(acc)){
                i.withdrawAmount();
                break;
            }
        }
    }

    public void printAccountInformation(String acc){
        for(acquireInformation i: SBI_allAccounts){
            if(i.provideAccountNumber().equals(acc)){
                i.showDetails();
                break;
            }
        }
    }

}
