/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author dalpizzol
 */
@Entity
@Table(name = "acessorio")
public class Acessorio implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_acessorio", sequenceName = "seq_acessorio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_acessorio", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "A descricao não pode ser nula")
    @NotBlank(message = "A descricao não pode ser branca")
    @Length(max = 100, message = "A descricao deve ter no máximo {max} caracteres")
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(name = "carro_acessorio",
            joinColumns
            = @JoinColumn(name = "acessorio", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false))
    private List<Carro> carros = new ArrayList<>();

    public Acessorio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Acessorio other = (Acessorio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
