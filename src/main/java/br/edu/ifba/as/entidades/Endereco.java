package br.edu.ifba.as.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{

    private static final long serialVersionUID = 320969826710586619L;
    
    @Id
    @GeneratedValue(generator = "fk_endereco_cod_cliente")
    @org.hibernate.annotations.GenericGenerator(name = "fk_endereco_cod_cliente", 
            strategy = "foreign", parameters = @Parameter(name = "property", value = "cliente"))
    @Column(name = "cod_cliente")
    private Integer endereco;
    
    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;
    private String rua;
    private String cidade;

    public Integer getEndereco() {
        return endereco;
    }

    public void setEndereco(Integer endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.endereco);
        hash = 17 * hash + Objects.hashCode(this.cliente);
        hash = 17 * hash + Objects.hashCode(this.rua);
        hash = 17 * hash + Objects.hashCode(this.cidade);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    
}
