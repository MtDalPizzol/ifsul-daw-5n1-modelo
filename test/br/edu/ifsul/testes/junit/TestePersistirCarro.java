/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Acessorio;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirCarro {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirCarro() {
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
            
            Carro carro = new Carro();
            Pessoa proprietario = em.find(Pessoa.class, 2);
            Acessorio arCondicionado = em.find(Acessorio.class, 1);

            carro.setFabricante("Ford");
            carro.setModelo("Focus");
            carro.setPlaca("KDN-4464");
            carro.setRenavam("06466917928");
            carro.setAnoFabricacao(2006);
            carro.setAnoModelo(2005);
            
            carro.setPessoa(proprietario);
            carro.getAcessorios().add(arCondicionado);
            
            em.getTransaction().begin();
            em.persist(carro);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }

        Assert.assertEquals(false, exception);
    }

}
