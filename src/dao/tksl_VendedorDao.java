/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.TkslVendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ""
 */
public class tksl_VendedorDao extends Dao_Abstract {

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
        Criteria criteria = session.createCriteria(TkslVendedor.class);
        criteria.add(Restrictions.eq("idvendedor", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslVendedor.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public List listaId(String idVendedor){
    Criteria criteria = session.createCriteria(TkslVendedor.class);
    criteria.add(Restrictions.like("tksl_idVendedor", "+idVendedor"));
    List listaId = criteria.list();
    session.getTransaction().commit();
    return listaId;
    }
    
    public List listaNome(String nome){
    Criteria criteria = session.createCriteria(TkslVendedor.class);
    criteria.add(Restrictions.like("tksl_nome", "%"+nome+"%"));
    List listaNome = criteria.list(); //salva os resultados obtidos dentro de uma lista
    session.getTransaction().commit();
    return listaNome;
    }
    
    public List listaIdNome(String idVendedor, String nome){
    Criteria criteria = session.createCriteria(TkslVendedor.class);
    criteria.add(Restrictions.like("tksl_idVendedor", "+idVendedor"));
    criteria.add(Restrictions.like("tksl_nome", "%"+nome+"%"));
    List listaIdNome = criteria.list();
    session.getTransaction().commit();
    return listaIdNome;
    }
}
