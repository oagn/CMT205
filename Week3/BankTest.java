/* Week 3, exercise 5:
- Test the BankAccount class */
public class BankTest{

    public static void main(String[] args){
        // Create a new account
        System.out.println("\nSTEP 1:\n Create a new bank account.");
        BankAccount a = new BankAccount(args[0], args[1]);
        System.out.println(a);

        // Get and set names
        System.out.println("\nSTEP 2:\n Get account holder name.");
        String name = a.getName();
        System.out.println("The name is " + name);
        System.out.println(a);

        System.out.println("\nSTEP 3:\n Set account holder name.");
        a.setName("Mary Berry");
        System.out.println(a);

        // Get and set account number
        System.out.println("\nSTEP 4:\n Get account number.");
        String number = a.getNumber();
        System.out.println("The account number is " + number);
        System.out.println(a);

        System.out.println("\nSTEP 5:\n Set account number.");
        a.setNumber("0012044");
        System.out.println(a);

        // Withdraw money with no funds
        System.out.println("\nSTEP 6:\n Attempt to withdraw money with insufficient funds.");
        a.withdraw(22.0);
        System.out.println(a);

        // Deposit to account
        System.out.println("\nSTEP 7:\n Deposit to bank account.");
        a.deposit(50.0);
        System.out.println(a);

        // Check balance
        System.out.println("\nSTEP 8:\n Check account balance.");
        double balance = a.checkBalance();
        System.out.println("The balance is " + balance);
        System.out.println(a);

        // Withdraw with sufficient funds
        System.out.println("\nSTEP 9:\n Withdraw from account.");
        a.withdraw(22.0);
        System.out.println(a);
    }
}
