package Task06Bank2404.banks;
import Task06Bank2404.acquireInformation.acquireInformation;
import java.util.List;
import java.util.ArrayList;

public class hdfcBank extends acquireInformation {

    protected String bankName = "Housing Development Finance Corporation Bank";
    protected String bankShortCode = "hdfc";
    protected List<acquireInformation> HDFC_allAccounts = new ArrayList<acquireInformation>();

    public void initializeAccount(){
        this.initializeSuper(bankName, bankShortCode);
    }

    public boolean findAccount(String acc){
        for(acquireInformation i: HDFC_allAccounts){
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
        HDFC_allAccounts.add(this);
        System.out.println("The new HDFC Account Number : "+this.provideAccountNumber());
    }

    public void CreditAmount(String acc){
        // .get() only takes int as parameter hence iteration
        for(acquireInformation i: HDFC_allAccounts){
            if(i.provideAccountNumber().equals(acc)){
                i.depositeAmount();
                break;
            }
        }
    }

    public void DebitAmount(String acc){
        for(acquireInformation i: HDFC_allAccounts){
            if(i.provideAccountNumber().equals(acc)){
                i.withdrawAmount();
                break;
            }
        }
    }

    public void printAccountInformation(String acc){
        for(acquireInformation i: HDFC_allAccounts){
            if(i.provideAccountNumber().equals(acc)){
                i.showDetails();
                break;
            }
        }
    }

}