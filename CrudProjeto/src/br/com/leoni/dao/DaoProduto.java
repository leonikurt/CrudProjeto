package br.com.leoni.dao;

import br.com.leoni.model.Produto;
import br.com.leoni.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leoni
 */
public class DaoProduto {
    
    private EntityManager em;
    
    public DaoProduto(){
        em = Manager.getInstance().getEm();
    }
    
    public void salvar(Produto p){
        em.getTransaction().begin();
        if (p.getCodigo()>0) {
            p = em.merge(p);
        }
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public List<Produto> listar(){
        Query qry = em.createQuery("Select p from br.com.leoni.model.Produto p");
        List produtos = qry.getResultList();
        return (List<Produto>) produtos;
    }
    
    public List<Produto> consultar(String nome){
        Query qry = em.createQuery("Select p from br.com.leoni.model.Produto p where p.nome = '" + nome + "'");
        List p = qry.getResultList();
        return (List<Produto>) p;
    }
    
    public void remover(Produto p){
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();   
    }
}
