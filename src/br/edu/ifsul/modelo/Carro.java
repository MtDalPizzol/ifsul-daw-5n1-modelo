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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author dalpizzol
 */
@Entity
@Table(name = "carro")
public class Carro implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O placa não pode ser nula")
    @NotBlank(message = "O placa não pode ser branca")
    @Length(max = 8, message = "O placa deve ter no máximo {max} caracteres")
    @Column(name = "placa", length = 8, nullable = false)
    private String placa;
    
    @NotNull(message = "O renavan não pode ser nulo")
    @NotBlank(message = "O renavan não pode ser branco")
    @Length(max = 11, message = "O renavan deve ter no máximo {max} caracteres")
    @Column(name = "renavan", length = 11, nullable = false)
    private String renavam;
    
    @NotNull(message = "O modelo não pode ser nulo")
    @NotBlank(message = "O modelo não pode ser branco")
    @Length(max = 20, message = "O modelo deve ter no máximo {max} caracteres")
    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;
    
    @NotNull(message = "O fabricante não pode ser nulo")
    @NotBlank(message = "O fabricante não pode ser branco")
    @Length(max = 20, message = "O fabricante deve ter no máximo {max} caracteres")
    @Column(name = "fabricante", length = 20, nullable = false)
    private String fabricante;
    
    @NotNull(message = "O ano de fabricação não pode ser nulo")
    @Min(value = 1900, message = "O ano de fabricação não pode ser menor que {value}")
    @Column(name = "ano_fabricacao", length = 4, nullable = false)
    private Integer anoFabricacao;
    
    @NotNull(message = "O ano do modelo não pode ser nulo")
    @Min(value = 1900, message = "O ano do modelo não pode ser menor que {value}")
    @Column(name = "ano_modelo", length = 4, nullable = false)
    private Integer anoModelo;
    
    @NotNull(message = "O proprietário não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_pessoa_id")
    private Pessoa proprietario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "carro_acessorio",
                joinColumns =
                @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false),
                inverseJoinColumns = 
                @JoinColumn(name = "acessorio", referencedColumnName = "id", nullable = false))
    private List<Acessorio> acessorios = new ArrayList<>();
    
    
    public Carro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
