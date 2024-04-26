package Task06Bank2404.information;
import java.time.LocalDate;

public class userInformation{
    protected String accountHolderName;
    protected String contact;
    protected String adhaar;
    protected String address;
    protected int birthDate;
    protected int birthMonth;
    protected int birthYear;

    protected void setUserAccountName(String s){this.accountHolderName=s;}

    protected boolean setUserContact(String c, String s){
        if(s.matches("^[1-9]\\d{9}$")){
            this.contact = c+s;
        }else{
            return false;
        }
        return true;
    }

    protected boolean setUserAdhaar(String s){
        String[] arr=s.split(" ");
        if(arr.length!=1 && arr.length!=3){return false;}
        if(arr.length == 3){
            for(String i:arr){
                if(i.length()!=4 || !i.matches("^\\d{4}$")){
                    return false;
                }
            }        }else{
            if(!arr[0].matches("^\\d{12}$")){return false;}
        }
        this.adhaar=String.join("",arr);
        return true;
    }

    protected void setUserAddress(String s){this.address=s;}

    protected boolean setUserDOB(String s){
        String[] arr=s.split("/");
        LocalDate curr = LocalDate.now();
        int year=Integer.parseInt(arr[2]);
        if(curr.getYear()-year < 18){return false;}
        this.birthDate=Integer.parseInt(arr[0]);
        this.birthMonth=Integer.parseInt(arr[1]);
        this.birthYear=Integer.parseInt(arr[2]);
        return true;
    }

    protected String getAccountHolderName(){return this.accountHolderName;}
    protected String getContact(){return this.contact;}
    protected String getAdhaar(){return this.adhaar;}
    protected String getAddress(){return this.address;}
    protected String getDOB(){return this.birthDate+"/"+this.birthMonth+"/"+this.birthYear;}
}
