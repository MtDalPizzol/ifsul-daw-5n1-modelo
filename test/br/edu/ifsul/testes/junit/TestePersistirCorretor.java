/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Corretor;
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
public class TestePersistirCorretor {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirCorretor() {
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
            
            Corretor corretor = new Corretor();

            corretor.setNome("John Doe");
            corretor.setCpf("199.728.687-45");
            corretor.setRg("340191569");
            corretor.setEmail("johndoe@test.com");
            corretor.setTelefone("(54) 99999-9999");
            corretor.setNomeUsuario("johndoe");
            corretor.setSenha("123");
            corretor.setPercentualComissao(10.0);
            
            em.getTransaction().begin();
            em.persist(corretor);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }

        Assert.assertEquals(false, exception);
    }

}
