package Task06Bank2404.information;
import java.time.LocalDate;
import java.util.Random;

public class bankInformation extends userInformation{
    protected String accountNumber;
    protected String accountType;
    protected float balance=1000;
    protected String ifsc;
    protected int joinDate;
    protected int joinMonth;
    protected int joinYear;

    protected void setBankAccountNumber(){
        Random random = new Random();
        String b=""+random.nextInt(9)+1;
        for(int i=0;i<9;i++){
            b=b+random.nextInt(10);
        }
        this.accountNumber = b;
        LocalDate currDate = LocalDate.now();
        this.joinDate = currDate.getDayOfMonth();
        this.joinMonth=currDate.getMonthValue();
        this.joinYear=currDate.getYear();
    }

    protected void setBankAccountType(int i){
        if(i==1){this.accountType="Savings";}
        else{this.accountType="Current";}
    }
    protected void setBankIfsc(String s, String c){this.ifsc=s+c;}
    
    protected void updateBalanceOnWithdrawal(float b){
        this.balance=this.balance-b;
    }
    protected void updateBalanceOnDeposite(float b){
        this.balance=this.balance+b;
    }

    protected String getAccontNumber(){return this.accountNumber;}
    protected String getAccontType(){return this.accountType;}
    protected float getBalance(){return this.balance;}
    protected String getIfsc(){return this.ifsc;}
    protected String getDateOfJoining(){return this.joinDate+"/"+this.joinMonth+"/"+this.joinYear;}
}
