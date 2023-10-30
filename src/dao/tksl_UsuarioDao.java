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
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslUsuarios.class);
        criteria.add(Restrictions.eq("idusuario", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista; 
        
    }

    @Override
    public List listAll() {  
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TkslUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listaNome(String nome){
    Criteria criteria = session.createCriteria(TkslUsuarios.class);
    criteria.add(Restrictions.like("tksl_nome", "%"+nome+"%"));
    List listaNome = criteria.list();
    session.getTransaction().commit();
    return listaNome;
    }
    
    public List listaCpf(String cpf){
    Criteria criteria = session.createCriteria(TkslUsuarios.class);
    criteria.add(Restrictions.like("tksl_cpf", "%"+cpf+"%"));
    List listaCpf = criteria.list(); //salva os resultados obtidos dentro de uma lista
    session.getTransaction().commit();
    return listaCpf;
    }
    
    public List listaNomeCpf(String nome, String cpf){
    Criteria criteria = session.createCriteria(TkslUsuarios.class);
    criteria.add(Restrictions.like("tksl_nome", "%"+nome+"%"));
    criteria.add(Restrictions.like("tksl_cpf", "%"+cpf+"%"));
    List listaNome = criteria.list();
    session.getTransaction().commit();
    return listaNome;
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
