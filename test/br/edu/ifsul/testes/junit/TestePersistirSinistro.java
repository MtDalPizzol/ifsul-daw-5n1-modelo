/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.modelo.Sinistro;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistirSinistro {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirSinistro() {
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
            
            Sinistro sinistro = new Sinistro();
            Seguro seguro = em.find(Seguro.class, 1);

            sinistro.setDescricao("Acidente na BR116");
            sinistro.setEstado("RS");
            sinistro.setCidade("Passo Fundo");
            sinistro.setData(new GregorianCalendar(2017, Calendar.JANUARY, 13));
            sinistro.setSeguro(seguro);
            
            seguro.getSinistros().add(sinistro);
            
            em.getTransaction().begin();
            em.persist(sinistro);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }

        Assert.assertEquals(false, exception);
    }

}
