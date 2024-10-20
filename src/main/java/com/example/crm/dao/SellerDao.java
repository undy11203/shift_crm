package com.example.crm.dao;

import com.example.crm.models.Seller;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class SellerDao {
    @PersistenceContext
    private EntityManager em;

    public Seller getMostProductivitySellerByPeriod(LocalDateTime startPeriod,
                                                    LocalDateTime endPeriod) {
        String jpql =
                """
                        select t.seller from Transaction t
                            where t.transactionDate > :startPeriod and t.transactionDate < :endPeriod
                            group by t.seller
                            order by sum(t.amount) desc
                """;


        TypedQuery<Seller> query = em.createQuery(jpql, Seller.class)
                .setParameter("startPeriod", startPeriod)
                .setParameter("endPeriod", endPeriod);

        query.setMaxResults(1);
        List<Seller> sellers = query.getResultList();
        return sellers.isEmpty() ? null : sellers.get(0);
    }

    public List<Seller> getSellersWithLessSumByPeriod(LocalDateTime startPeriod,
                                                      LocalDateTime endPeriod, int maxTotalAmount) {
        String jpql =
                """
                        select s from Seller s where s.id in (                       
                            select t.seller.id from Transaction t
                            where t.transactionDate > :startPeriod and t.transactionDate < :endPeriod
                            group by t.seller.id\s
                            having (sum(t.amount) < :maxAmount)
            
                        )
                """;


        TypedQuery<Seller> query = em.createQuery(jpql, Seller.class)
                .setParameter("startPeriod", startPeriod)
                .setParameter("endPeriod", endPeriod)
                .setParameter("maxAmount" , maxTotalAmount);

        query.setMaxResults(1);
        List<Seller> sellers = query.getResultList();
        return sellers;
    }
}
