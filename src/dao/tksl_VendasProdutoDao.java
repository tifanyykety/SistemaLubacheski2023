/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.TkslVendas;
import bean.TkslVendasproduto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ""
 */
public class tksl_VendasProdutoDao extends Dao_Abstract {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslVendasproduto.class);
        criteria.add(Restrictions.eq("idvendasproduto", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslVendasproduto.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listaQuantidade(String quantidade){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslVendasproduto.class);
        criteria.add(Restrictions.like("tkslQuantidade", "%"+quantidade+"%"));
        List listaQuantidade = criteria.list();
        session.getTransaction().commit();
        return listaQuantidade;
    }
    
    public List listaTotal(String total){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslVendasproduto.class);
        criteria.add(Restrictions.like("tkslTotal", "%"+total+"%"));
        List listaTotal = criteria.list(); //salva os resultados obtidos dentro de uma lista
        session.getTransaction().commit();
        return listaTotal;
    }
    
    public List listaQuantTotal(String quantidade, String total){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslVendasproduto.class);
        criteria.add(Restrictions.like("tkslQuantidade", "%"+quantidade+"%"));
        criteria.add(Restrictions.like("tkslTotal", "%"+total+"%"));
        List listaQuantTotal = criteria.list();
        session.getTransaction().commit();
        return listaQuantTotal;
    }

    public List listVenda(int idvenda) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslVendasproduto.class);
        criteria.add(Restrictions.eq("tksl_fk_venda", idvenda));
        List listaVenda = criteria.list();
        session.getTransaction().commit();
        return listaVenda;
    }
    
       public List listaProdutos(TkslVendas tkslVendas){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslVendasproduto.class);
        criteria.add(Restrictions.eq("tkslVendas", tkslVendas));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
}
