import java.io.*;
class BankAccount{
      int AccountNumber;
      float balance;
      String ownerName;
      BankAccount(int accnum,String name){
          AccountNumber=accnum;
          balance=0;
          ownerName=name;
      }
      public float getBalance(){
             return balance;
      }
      public void add(float amount){
             balance+=amount;
      }
      public void subtract(float amount){
             balance-=amount;
      }
}

class AccountManager{
      BankAccount b[]=new BankAccount[500];
      public void create(int accnum,String name,int i){
             b[i]=new BankAccount(accnum,name);
      }
      public void delete(int i){
             b[i]=null;
      }
      public void deposit(int i,float amount){
             b[i].add(amount);
      }
      public void withdraw(int i,float amount){
             b[i].subtract(amount);
      }
      public void printDetails(int i){
             System.out.println(b[i].AccountNumber+"\t\t"+b[i].balance+"\t\t"+b[i].ownerName);
      }
}

class Bank{
      public static void main(String args[])throws IOException{
             BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             AccountManager acc=new AccountManager();
             int i,accnum;
             float amount;
             String name;
             char ch;
             for (i=0;i<5;i++){
                 System.out.println("Enter account number and name of the account holder of "+(i+1)+" th account");
                 accnum=Integer.parseInt(br.readLine());
                 name=br.readLine();
                 acc.create(accnum,name,i);
             }
             for (i=0;i<5;i++){
                 System.out.println("For account with "+acc.b[i].AccountNumber+" as account number,");
                 System.out.println("Do you want to deposit?[Y/N]");
                 ch=br.readLine().charAt(0);
                 if (ch=='Y'){
                    System.out.println("Enter amount to be deposited");
                    amount=Float.parseFloat(br.readLine());
                    acc.deposit(i,amount);
                 }
             }
             System.out.println("AccountNumber\tBalance\t\tName");
             for (i=0;i<5;i++)
                 acc.printDetails(i);
      }
}
