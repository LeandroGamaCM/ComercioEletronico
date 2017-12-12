package br.edu.ifba.as.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 1489621629742815109L;
    
    @Id
    @GeneratedValue
    @Column(name = "cod_pedido")
    private Integer pedido;
    @Column(name = "data_pedido", updatable = false)
    private Date dataPedido;
    @Column(name = "hora_pedido", updatable = false)
    private Time horaPedido;
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "cod_empregado")
    private Empregado empregado;
    
    @ManyToMany
    @JoinTable(name = "item", joinColumns = {@JoinColumn(name = "cod_pedido",
            referencedColumnName = "cod_pedido")}, inverseJoinColumns = {@JoinColumn(name = 
            "cod_produto")})
    private Set<Produto> produto = new HashSet<Produto>();

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Time getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Time horaPedido) {
        this.horaPedido = horaPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public Set<Produto> getProduto() {
        return produto;
    }

    public void setProduto(Set<Produto> produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.pedido);
        hash = 71 * hash + Objects.hashCode(this.dataPedido);
        hash = 71 * hash + Objects.hashCode(this.horaPedido);
        hash = 71 * hash + Objects.hashCode(this.descricao);
        hash = 71 * hash + Objects.hashCode(this.cliente);
        hash = 71 * hash + Objects.hashCode(this.empregado);
        hash = 71 * hash + Objects.hashCode(this.produto);
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
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        if (!Objects.equals(this.dataPedido, other.dataPedido)) {
            return false;
        }
        if (!Objects.equals(this.horaPedido, other.horaPedido)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.empregado, other.empregado)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
    
    
    
}
