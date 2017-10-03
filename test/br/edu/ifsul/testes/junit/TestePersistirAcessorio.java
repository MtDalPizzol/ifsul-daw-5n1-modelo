/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Acessorio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dalpizzol
 */
public class TestePersistirAcessorio {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAcessorio() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("IFSUL-DAW-5N1-PU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;

        try {
            
            Acessorio acessorio = new Acessorio();

            acessorio.setDescricao("Ar condicionado");
            
            em.getTransaction().begin();
            em.persist(acessorio);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }

        Assert.assertEquals(false, exception);
    }

}
