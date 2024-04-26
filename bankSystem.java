package Task06Bank2404;
import Task06Bank2404.banks.hdfcBank;
import Task06Bank2404.banks.sbiBank;

import java.util.Scanner;
/**
 * bank System
 */
public class bankSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sbiBank sbiBankObj= new sbiBank();
        hdfcBank hdfcBankObj = new hdfcBank();
        int bankSelect;
        String welcomemsg="\n";

        System.out.print("----------------------- Select Bank >> 1. SBI || 2. HDFC -----> Choose : ");
        bankSelect = sc.nextInt();
        while(bankSelect!=1 && bankSelect!=2){
            System.out.print("--- Invalid Bank, Select Bank Again >> 1. SBI || 2. HDFC -----> Choose : ");
            bankSelect = sc.nextInt();
        }
        
        if(bankSelect==1){
            sbiBankObj.initializeAccount();
            System.out.println("\n-----------------------------------------------------------------------------------");
            System.out.println("----------------------- Hello, Welcome to <SBI> BANK SYSTEM -----------------------");
            System.out.println("-----------------------------------------------------------------------------------");
            welcomemsg+="---------------------------- SBI : Choose Operation -------------------------------\n-----------------------------------------------------------------------------------";
        }else if(bankSelect==2){
            hdfcBankObj.initializeAccount();
            System.out.println("\n-----------------------------------------------------------------------------------");
            System.out.println("---------------------- Hello, Welcome to <HDFC> BANK SYSTEM -----------------------");
            System.out.println("-----------------------------------------------------------------------------------");
            welcomemsg+="----------------------------- HDFC : Choose Operation -----------------------------\n-----------------------------------------------------------------------------------";
        }
        
        int choice=0;
        int inpi;
        String inps;
        float inpf;

        while(choice!=5){
            System.out.println(welcomemsg);
            System.out.println("------------- 1. New Registeration     2. Display Account Information");
            System.out.println("------------- 3. Deposit Amount        4. Withdraw Amount6.");
            System.out.print("------------- 5. Close Interface       ----------- Choose ----------> ");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    if(bankSelect==1){
                        if(sbiBankObj.addNewDetails()){
                            sbiBankObj.saveNewAccount();
                        } else { continue; }
                    }else if(bankSelect==2){
                        if(hdfcBankObj.addNewDetails()){
                            hdfcBankObj.saveNewAccount();
                        } else { continue; }
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Account number : ");
                    inps=sc.nextLine();
                    if(bankSelect==1){
                        if(sbiBankObj.findAccount(inps)){
                            sbiBankObj.printAccountInformation(inps);
                        } else { continue; }
                    }else if(bankSelect==2){
                        if(hdfcBankObj.findAccount(inps)){
                            hdfcBankObj.printAccountInformation(inps);
                        } else { continue; }
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Account number : ");
                    inps=sc.nextLine();
                    if(bankSelect==1){
                        if(sbiBankObj.findAccount(inps)){
                            sbiBankObj.CreditAmount(inps);
                        } else { continue; }
                    }else if(bankSelect==2){
                        if(hdfcBankObj.findAccount(inps)){
                            hdfcBankObj.CreditAmount(inps);
                        } else { continue; }
                    }
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter Account number : ");
                    inps=sc.nextLine();
                    if(bankSelect==1){
                        if(sbiBankObj.findAccount(inps)){
                            sbiBankObj.DebitAmount(inps);
                        } else { continue; }
                    }else if(bankSelect==2){
                        if(hdfcBankObj.findAccount(inps)){
                            hdfcBankObj.DebitAmount(inps);
                        } else { continue; }
                    }
                    break;

                case 5:
                    continue;
            
                default:
                    break;
            }
        }
        

    }
}
