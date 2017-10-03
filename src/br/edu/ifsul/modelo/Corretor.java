/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author dalpizzol
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "corretor")
public class Corretor extends Pessoa implements Serializable {

    @NotNull(message = "O nome de usuário não pode ser nulo")
    @NotBlank(message = "O nome de usuário não pode ser branco")
    @Length(max = 20, message = "O nome de usuário deve ter no máximo {max} caracteres")
    @Column(name = "nome_usuario", length = 20, nullable = false)
    private String nomeUsuario;
    
    @NotNull(message = "O percentual de comissão não pode ser nulo")
    @Min(value = 0, message = "O percentual de comissão não pode ser negativo")
    @Column(name = "percentual_comissao", nullable = false, columnDefinition = "decimal(12,2)")
    private Double percentualComissao;
    
    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha não pode ser branca")
    @Length(max = 8, message = "A senha deve ter no máximo {max} caracteres")
    @Column(name = "senha", length = 8, nullable = false)
    private String senha;

    public Corretor() {
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(Double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
