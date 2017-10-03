/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Seguro;
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
public class TestePersistirSeguro {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirSeguro() {
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
            
            Seguro seguro = new Seguro();
            Corretor corretor = em.find(Corretor.class, 2);
            Carro carro = em.find(Carro.class, 2);

            Cobertura terceiros = new Cobertura();
            terceiros.setDescricao("Cobertura contra terceiros");
            terceiros.setValor(500.00);
            
            Cobertura roubo = new Cobertura();
            roubo.setDescricao("Cobertura contra roubo");
            roubo.setValor(1000.00);
            
            seguro.setCorretor(corretor);
            seguro.setCarro(carro);
            seguro.setValorFipe(17000.00);
            seguro.adicionarCobertura(terceiros);
            seguro.adicionarCobertura(roubo);
            seguro.setData(Calendar.getInstance());
            seguro.setInicioVigencia(new GregorianCalendar(2017, Calendar.OCTOBER, 10));
            seguro.setFimVigencia(new GregorianCalendar(2018, Calendar.OCTOBER, 10));
            
            em.getTransaction().begin();
            em.persist(seguro);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }

        Assert.assertEquals(false, exception);
    }

}
