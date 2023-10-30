/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.TkslCliente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ""
 */
public class tksl_ClienteDao extends Dao_Abstract {

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
        Criteria criteria = session.createCriteria(TkslCliente.class);
        criteria.add(Restrictions.eq("idcliente", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

@Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslCliente.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listaNome(String nome){
    Criteria criteria = session.createCriteria(TkslCliente.class);
    criteria.add(Restrictions.like("tksl_nome", "%"+nome+"%"));
    List listaNome = criteria.list();
    session.getTransaction().commit();
    return listaNome;
    }
    
    public List listaCpf(String cpf){
    Criteria criteria = session.createCriteria(TkslCliente.class);
    criteria.add(Restrictions.like("tksl_cpf", "%"+cpf+"%"));
    List listaCpf = criteria.list(); //salva os resultados obtidos dentro de uma lista
    session.getTransaction().commit();
    return listaCpf;
    }
    
    public List listaRg(String rg){
    Criteria criteria = session.createCriteria(TkslCliente.class);
    criteria.add(Restrictions.like("tksl_rg", "%"+rg+"%"));
    List listaRg = criteria.list(); //salva os resultados obtidos dentro de uma lista
    session.getTransaction().commit();
    return listaRg;
    }
    
    public List listaTudoJunto(String nome, String cpf, String rg){
    Criteria criteria = session.createCriteria(TkslCliente.class);
    criteria.add(Restrictions.like("tksl_nome", "%"+nome+"%"));
    criteria.add(Restrictions.like("tksl_cpf", "%"+cpf+"%"));
    criteria.add(Restrictions.like("tksl_rg", "%"+rg+"%"));
    List listaTudoJunto = criteria.list();
    session.getTransaction().commit();
    return listaTudoJunto;
    }
}

