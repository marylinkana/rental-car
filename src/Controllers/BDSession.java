/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.persistence.*;

public class BDSession { 
    
    // créate an entity manager link with a persistence unit to link the data base
    public static EntityManager getEM() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CarRentalPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
    
    public static void main(String[] args){
        EntityManager em = BDSession.getEM();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println(tx.isActive());
        tx.commit();
        System.out.println(tx.isActive());
        tx.begin();
        System.out.println(tx.isActive());
    }

}