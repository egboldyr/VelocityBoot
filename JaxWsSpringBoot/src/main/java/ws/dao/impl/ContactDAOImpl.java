package ws.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ws.dao.ContactDAO;
import ws.entity.Contact;

import java.util.List;

@Repository
@Transactional
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Contact contact) {
        return (Long) factory.getCurrentSession().save(contact);
    }

    @Override
    public Contact read(Long id) {
        return factory.getCurrentSession().get(Contact.class, id);
    }

    @Override
    public boolean update(Contact contact) {
        try {
            factory.getCurrentSession().update(contact);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Contact contact) {
        try {
            factory.getCurrentSession().delete(contact);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            factory.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<Contact> findAll() {
        return factory
                .getCurrentSession()
                .createCriteria(Contact.class)
                .list();
    }
}
