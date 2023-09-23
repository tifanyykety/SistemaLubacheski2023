/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.TkslUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ""
 */
public class tksl_UsuarioDao extends Dao_Abstract {

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

        return null;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public List login(String usuario, String senha) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslUsuarios.class);
        criteria.add(Restrictions.eq("tkslApelido", usuario));
        criteria.add(Restrictions.eq("tkslSenha", senha));
        List lista = criteria.list();
        session.getTransaction().commit();
        if (!lista.isEmpty()) {
            return (List) lista.get(0);
        } else {
            return null;
        }
    }
}
