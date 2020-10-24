package org.aforo255.withdrawal.service;

import org.aforo255.withdrawal.entity.Transaction;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionService implements  ITransaction {

    @Override
    public Transaction save(Transaction transaction) {

        transaction.persist();

        return transaction;
    }

}
