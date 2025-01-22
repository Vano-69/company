package telran.bank.model;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock mutex = new ReentrantLock();
    private int accNumber;
    private int balance;

    public Account(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void debit(int sum) {
        balance = balance - sum;
    }

    public void credit(int sum) {
        balance = balance + sum;
    }

    public void lock() {
        mutex.lock();
    }

    public void unlock() {
        mutex.unlock();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Account account = (Account) object;
        return accNumber == account.accNumber && balance == account.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accNumber);
    }
}
