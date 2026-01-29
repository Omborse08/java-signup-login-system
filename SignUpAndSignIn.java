import java.util.Scanner;

class Account {
    private String[][] passworld = new String[10][2];

    public boolean setPasswordStorage(int tol, String email, String pass, String cPass) {
        if (pass.equals(cPass)) {
            this.passworld[tol][0] = email;
            this.passworld[tol][1] = pass;
            return true;
        }
        return false;
    }

    public boolean emailExist(String isEmail,int user) {
        for (int i=0;i<user;i++) {
            if(this.passworld[i][0].equals(isEmail)) {
                return true;
            }
        }
        return false;
    }

    public void checkPasswordIsRight(String aEmail,String aPass,int user) {
        boolean b1 = false;
        for (int i=0;i<user;i++) {
                if (this.passworld[i][0].equals(aEmail) && this.passworld[i][1].equals(aPass)) {
                    System.out.print("\n> Account Sign In Successfully!");
                    b1 = true;
                    break;
                }
        }
        if(b1==false) {
            System.out.print("\n> Invalid Details!");
        }
    }

    public void getShowDetails(int user) {
        for (int i=0;i<user;i++) {
            System.out.printf("\nEmail Address: %s",this.passworld[i][0]);
            System.out.printf("\nYour Password: %s",this.passworld[i][1]);
            System.out.println();
        }
    }
}

public class SignUpAndSignIn {
    public static void main(String[] args) {
        int user = 0;
        boolean isTrue = true;
        Account acc = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.print("\n    Menu\n1.Create New Account\n2.Sign In\n3.ShowSavedUsers\n4.Exit");
        while (isTrue) {
            System.out.print("\nChoose Option: ");
            int choose = sc.nextInt();
            String skip = sc.nextLine();
            switch (choose) {
                case 1: {
                    if (user==10) {
                        System.out.print("\nStorage Full! ");
                        break;
                    }
                    else {
                        System.out.print("===== Create New Account =====");
                        System.out.print("\nEmail Address: ");
                        String email = sc.nextLine();
                        if (acc.emailExist(email,user)) {
                            System.out.print("\nEmail Already Exist");
                            break;
                        }
                        System.out.print("\nEnter Password Here: ");
                        String pass = sc.nextLine();
                        System.out.print("\nEnter Password Again: ");
                        String cPass = sc.nextLine();
                        if(acc.setPasswordStorage(user, email, pass, cPass)) {
                            System.out.print("\nAccount Created Sucessfully!");
                            user = user + 1;
                            break;
                        }
                        System.out.print("\nWrong Password!");
                        break;
                    }
                }
                case 2: {
                    System.out.print("\n===== Account Sign In Method =====\n");
                    System.out.print("\nEnter Email: ");
                    String aEmail = sc.nextLine();
                    System.out.print("\nEnter Password: ");
                    String aPass = sc.nextLine();
                    acc.checkPasswordIsRight(aEmail, aPass, user);
                    break;
                }
                case 3: {
                    System.out.print("\n===== All Password Details =====");
                    acc.getShowDetails(user);
                    break;
                }
                case 4:
                    System.out.print("\nGood By See You Soon!");
                    isTrue = false;
                    break;
            }
        }
        sc.close();
    }
}
