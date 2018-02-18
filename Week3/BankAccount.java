/* Week 3, exercise 5:
- a) Add a constructor that takes two arguments, specifying name and account number
- b) Appropriate accessor and mutator methods
- c) Add methods to deposit to, check balance and withdraw from account */

public class BankAccount {
    private String holderName;
    private double balance;
    private String number;

    /// Constructor for BankAccount
    public BankAccount(String holderName, String number){
        this.holderName = holderName;
        this.number = number;
        this.balance = 0.0;
    }

    public BankAccount(String holderName, String number, String balance){
        this.holderName = holderName;
        this.number = number;
        this.balance = Double.parseDouble(balance);
    }

    /// Accessor for name of the accoun holder
    public String getName(){
        return holderName;
    }

    /// Mutator for name of the account holder
    public void setName(String newName){
        holderName = newName;
    }

    /// Accessor for bank abbount number
    public String getNumber(){
        return number;
    }

    /// Mutator for bank account number
    public void setNumber(String newNumber){
        number = newNumber;
    }

    /// Method to deposit to the bank account
    public void deposit(double addMoney){
        balance += addMoney;
    }

    /// Method to chack balance of bank account
    public double checkBalance(){
        return balance;
    }

    /// Method to withdraw from bank account
    public void withdraw(double withdrawal){
        if(balance - withdrawal >= 0){
            balance -= withdrawal;
        }
        else System.out.printf("You have insufficient funds (£%.2f) for a withdrawal of £%.2f \n",balance,withdrawal);
    }

    public String toString(){
        String s = holderName + "\t(" + number + ":\t£" + balance + ") ";
        return s;
    }
}
