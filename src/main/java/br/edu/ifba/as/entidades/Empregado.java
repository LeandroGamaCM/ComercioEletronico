package br.edu.ifba.as.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "empregado")
public class Empregado implements Serializable{

    private static final long serialVersionUID = 4234573984299225141L;
    
    @Id
    @GeneratedValue
    @Column(name = "cod_empregado")
    private Integer empregado;

    private String nome;
    
    @OneToOne
    @JoinColumn(name = "cod_chefe")
    private Empregado Chefe;

    public Integer getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Integer empregado) {
        this.empregado = empregado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empregado getChefe() {
        return Chefe;
    }

    public void setChefe(Empregado Chefe) {
        this.Chefe = Chefe;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.empregado);
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.Chefe);
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
        final Empregado other = (Empregado) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.empregado, other.empregado)) {
            return false;
        }
        if (!Objects.equals(this.Chefe, other.Chefe)) {
            return false;
        }
        return true;
    }
    
    
}
