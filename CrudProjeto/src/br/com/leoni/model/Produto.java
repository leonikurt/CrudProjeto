package br.com.leoni.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author leoni
 */

@Entity
@Table(name = "Produto")
public class Produto {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int codigo;
    
    @Column
    private String nome;
    
    @Column
    private float preco;

    public static final String PROP_CODIGO = "codigo";

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        int oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange(PROP_CODIGO, oldCodigo, codigo);
    }
    
    
    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }
    
       

    public static final String PROP_PRECO = "preco";

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        float oldPreco = this.preco;
        this.preco = preco;
        propertyChangeSupport.firePropertyChange(PROP_PRECO, oldPreco, preco);
    }

    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
