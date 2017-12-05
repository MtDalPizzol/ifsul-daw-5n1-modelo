/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util.relatorios;

import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Acessorio;
import br.edu.ifsul.modelo.Pessoa;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author dalpizzol
 */
public class FabricaObj {

    public static List<Seguro> carregaSeguro() {
        List<Seguro> lista = new ArrayList<>();
        
        Pessoa proprietario = new Pessoa();
        Corretor corretor = new Corretor();
        Carro carro = new Carro();
        Seguro seguro = new Seguro();
        Cobertura c1 = new Cobertura();
        Cobertura c2 = new Cobertura();
        
        proprietario.setId(1);
        proprietario.setNome("Matheus Dal'Pizzol");
        proprietario.setCpf("33846078050");
        proprietario.setRg("4062913381");
        proprietario.setEmail("matheusdalpizzol@gmail.com");
        proprietario.setTelefone("5499005400");
        
        corretor.setId(1);
        corretor.setNome("João da Silva");
        corretor.setCpf("06967153170");
        corretor.setEmail("joaodasilva@gmail.com");
        corretor.setRg("123456987");
        corretor.setTelefone("5499005400");
        corretor.setPercentualComissao(10.0);
        corretor.setNomeUsuario("joaodasilva");
        corretor.setSenha("123");
        
        carro.setId(1);
        carro.setPlaca("KCQ-5999");
        carro.setRenavam("10556962017");
        carro.setFabricante("Ford");
        carro.setModelo("Focus");
        carro.setAnoFabricacao(2015);
        carro.setAnoModelo(2016);
        carro.setProprietario(proprietario);
        
        seguro.setId(1);
        seguro.setCorretor(corretor);
        seguro.setCarro(carro);
        seguro.setData(Calendar.getInstance());
        seguro.setInicioVigencia(Calendar.getInstance());
        seguro.setFimVigencia(Calendar.getInstance());
        seguro.setValorFipe(20000.30);
        // seguro.setValorTotal(1000.00);
        
        c1.setId(1);
        c1.setDescricao("Cobertura 1");
        c1.setValor(400.00);
        c1.setSeguro(seguro);
        
        c2.setId(1);
        c2.setDescricao("Cobertura 2");
        c2.setValor(600.00);
        c2.setSeguro(seguro);
        
        seguro.adicionarCobertura(c1);
        seguro.adicionarCobertura(c2);
        
            lista.add(seguro);
        
        return lista;
    }
    
}
