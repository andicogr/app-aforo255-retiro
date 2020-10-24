package org.aforo255.withdrawal.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.aforo255.withdrawal.entity.Transaction;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionRepository implements PanacheRepositoryBase<Transaction, Integer> {

}
