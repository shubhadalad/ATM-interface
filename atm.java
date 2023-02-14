import java.util.*;
import java.lang.String;

class User{
    String user_id = "sh123";
    int user_pin = 1234;
    String transfer_user_id = "pr456", n_transfer_user_id;
    double total = 0;
    double amount;
    double history[] = new double[10];
    Scanner sc = new Scanner(System.in);
    int i = 0, result;

    public int verify(String id, int pin){
        if(user_id.equals(id) && user_pin == pin)
            result = 1;
        else
            result = 0;
        return result;
    }

    public double getAmount(){
        System.out.print("Enter amount: ");
        amount = sc.nextDouble();
        return amount;
    }

    public void history(){
        System.out.println();
        System.out.println("Transaction history");
        for(int k = 0 ; k < i; k++){
            System.out.println(history[k]);
        }
    }

    public void withdraw(){
        amount = getAmount();
        if(total < amount){
            System.out.println("Transaction cannot be done......Unsufficient balance!!!!");
        }
        else{
            total -= amount;
            history[i] = total;
            i++;
            System.out.println();
            System.out.println("Transaction successfull.....");
        }
        
    }

    public void deposit(){
        amount = getAmount();
        total += amount;
        history[i] = total;
        i++;
        System.out.println();
        System.out.println("Transaction successfull.....");
    }    

    public void transfer(){
        System.out.print("Enter accont number to transfer money: ");
        n_transfer_user_id = sc.next();
        if(transfer_user_id.equals(n_transfer_user_id)){
            System.out.print("Enter amount to deposit: ");
            amount = sc.nextDouble();
            total -= amount;
            history[i] = total;
            i++;
            System.out.println();
            System.out.println("Transfer successfull.....");
        }
        else{
            System.out.println();
            System.out.println("User doesn't exist!!!!!");
            System.out.println("Try again...");
        }        
    }
    
} 

class atm{
    public static void main(String args[]){
        int ch = 0;
        User u1 = new User();
        Scanner sc = new Scanner(System.in);
        System.out.print("User Id : ");
        String n_user_id = sc.next();
        System.out.print("User pin : ");
        int n_user_pin = sc.nextInt();

        int result = u1.verify(n_user_id, n_user_pin);

        if(result == 1){
            while(ch != 5){
                System.out.println();
                System.out.println("Select option\n1.Transaction history\n2.Withdraw\n3.Deposit\n4Transfer\n5.Exit");
                System.out.print("Enter your choice: ");
                ch = sc.nextInt();
                if(ch == 1){
                    u1.history();
                }
                if(ch == 2){
                    u1.withdraw();
                }
                if(ch == 3){
                    u1.deposit();
                }
                if(ch == 4){
                    u1.transfer();
                }
            }
        }
        else{
            System.out.println("Wrong user id or pin!!!!!!\nTry again");
        }
    }
}

// class atm{
    
//     public static void main(String[] args) {
//         String user_id = "sh123";
//         int user_pin = 1234;
//         String transfer_user_id = "pr456", n_transfer_user_id;
//         double total = 0;
//         double amount;
//         double history[] = new double[10]; 
//         int ch = 0, i = 0;

//         Scanner sc = new Scanner(System.in);

//         System.o.print("User Id : ");
//         String n_user_id = sc.next();
//         System.out.print("User pin : ");
//         int n_user_pin = sc.nextInt();

//         if(user_id.equals(n_user_id) && user_pin == n_user_pin){
//             while(ch != 5){
//                 System.out.println();
//                 System.out.println("Select option\n1.Transaction history\n2.Withdraw\n3.Deposit\n4Transfer\n5.Exit");
//                 System.out.print("Enter your choice: ");
//                 ch = sc.nextInt();
//                 if(ch == 1){
//                     System.out.println();
//                     System.out.println("Transaction history");
//                     for(int k = 0 ; k < i; k++){
//                         System.out.println(history[k]);
//                     }
//                 }
//                 if(ch == 2){
//                     System.out.println();
//                     System.out.print("Enter amount to withdraw: ");
//                     amount = sc.nextDouble();
//                     total -= amount;
//                     history[i] = total;
//                     i++;
//                     System.out.println();
//                     System.out.println("Transaction successfull.....");
//                 }
//                 if(ch == 3){
//                     System.out.println();
//                     System.out.print("Enter amount to deposit: ");
//                     amount = sc.nextDouble();
//                     total += amount;
//                     history[i] = total;
//                     i++;
//                     System.out.println();
//                     System.out.println("Transaction successfull.....");
//                 }
//                 if(ch == 4){
//                     System.out.print("Enter accont number to transfer money: ");
//                     n_transfer_user_id = sc.next();
//                     if(transfer_user_id.equals(n_transfer_user_id)){
//                         System.out.print("Enter amount to deposit: ");
//                         amount = sc.nextDouble();
//                         total -= amount;
//                         history[i] = total;
//                         System.out.println();
//                         System.out.println("Transfer successfull.....");
//                     }
//                     else{
//                         System.out.println();
//                         System.out.println("User doesn't exist!!!!!");
//                         System.out.println("Try again...");
//                     }
//                 }
//             }
//         }
//         else{
//             System.out.println("Wrong user id or pin!!!!!!\nTry again");
//         }
        
//     }
// }