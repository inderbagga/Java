package multithreading.synchronization.itc;

public class InterThreadCom{

    public static void main(String[] args){

        System.out.println("Customer opens an account with 10,000");
        Customer customer=new Customer(10000);

        new Thread(){
            @Override
            public void run() {
                System.out.println("Customer goes to withdraw 11,000");
                customer.withdraw(11000);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("Customer goes to deposit 2,000");
                customer.deposit(2000);
            }
        }.start();
    }
}

class Customer {

    Customer(int balance){
        this.balance=balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int balance;

    synchronized void withdraw(int amount) {

        if(this.balance<amount){

            System.out.println("Insufficient balance to withdraw "+amount);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(this.balance<amount){
                System.out.println("Transaction has been declined!");
            }else{
                this.balance-=amount;
                System.out.println(amount+" has been successfully debited. Your balance is "+balance);
            }
        }
    }

    synchronized void deposit(int amount){

        this.balance+=amount;
        System.out.println(amount+" has been deposited.");
        notify();
    }
}
