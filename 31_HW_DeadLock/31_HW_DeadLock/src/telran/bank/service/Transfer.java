package telran.bank.service;

import telran.bank.model.Account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transfer implements Runnable {
    private Account accFrom;
    private Account accTo;
    private int sum;

    public Transfer(Account accFrom, Account accTo, int sum) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.sum = sum;
    }

    @Override
    public void run() {
        Account firstLock = accFrom.getAccNumber() > accTo.getAccNumber() ? accTo : accFrom;
        Account secondLock = accFrom.getAccNumber() > accTo.getAccNumber() ? accFrom : accTo;
        firstLock.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            secondLock.lock();
            try {
                if (accFrom.getBalance() >= sum) {
                    accFrom.debit(sum);
                    accTo.credit(sum);
                }
            } finally {
                secondLock.unlock();
            }
        } finally {
            firstLock.unlock();
        }
    }
}
