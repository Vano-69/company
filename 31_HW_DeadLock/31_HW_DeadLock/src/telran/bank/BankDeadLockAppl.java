package telran.bank;

import telran.bank.model.Account;
import telran.bank.service.Transfer;

public class BankDeadLockAppl {
    public static void main(String[] args) throws InterruptedException {
        Account father = new Account(1000);
        Account son = new Account(2000);
        father.credit(1000);
        son.credit(1000);
        Transfer transfer1 = new Transfer(father, son, 900);
        Transfer transfer2 = new Transfer(son, father, 900);
        Thread thread1 = new Thread(transfer1);
        Thread thread2 = new Thread(transfer2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Balance of acc: " + father.getAccNumber() + " = " + father.getBalance());
        System.out.println("Balance of acc: " + son.getAccNumber() + " = " + son.getBalance());
    }
}
