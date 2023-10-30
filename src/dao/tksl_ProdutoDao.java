/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.TkslProduto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ""
 */
public class tksl_ProdutoDao extends Dao_Abstract {

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
        Criteria criteria = session.createCriteria(TkslProduto.class);
        criteria.add(Restrictions.eq("idproduto", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslProduto.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listaNome(String nome){
    Criteria criteria = session.createCriteria(TkslProduto.class);
    criteria.add(Restrictions.like("tksl_nome", "%"+nome+"%"));
    List listaNome = criteria.list();
    session.getTransaction().commit();
    return listaNome;
    }
    
    public List listaTime(String time){
    Criteria criteria = session.createCriteria(TkslProduto.class);
    criteria.add(Restrictions.like("tksl_time", "%"+time+"%"));
    List listaTime = criteria.list(); //salva os resultados obtidos dentro de uma lista
    session.getTransaction().commit();
    return listaTime;
    }
    
    public List listaNomeTime(String nome, String time){
    Criteria criteria = session.createCriteria(TkslProduto.class);
    criteria.add(Restrictions.like("tksl_nome", "%"+nome+"%"));
    criteria.add(Restrictions.like("tksl_time", "%"+time+"%"));
    List listaNomeTime = criteria.list();
    session.getTransaction().commit();
    return listaNomeTime;
    }

}
