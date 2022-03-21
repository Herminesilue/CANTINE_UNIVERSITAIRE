package DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernate;
import model.Administrateur;

public class adminDAO implements IadminDAO{

	@Override
	public void saveAdministrateur(Administrateur Administrateur) {
		// TODO Auto-generated
        Transaction transaction = null;
        try (Session session = hibernate.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(Administrateur);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}
	@Override
	public void updateAdministrateur(Administrateur Administrateur) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        try (Session session = hibernate.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.saveOrUpdate(Administrateur);

	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	    }

	    /* (non-Javadoc)
	     * @see net.javaguides.hibernate.dao.IStudentDao#getStudentById(long)
	     */

		
	

	@Override
	public Administrateur getAdministrateurById(int id) {
		// TODO Auto-generated method stub

        Transaction transaction = null;
        Administrateur administrateur = null;
        try {
			Session session = hibernate.getSessionFactory().openSession();
			    // start the transaction
			    transaction = session.beginTransaction();

			    // get student object
			    administrateur= session.byId(Administrateur.class).getReference(id);
			     // or student = session.get(Student.class, id);
			    //or student = session.load(Student.class, id);
			   //or commit the transaction
			    transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
			
		}
        
        
        return administrateur;
    }


	@Override
	public List<Administrateur> getAllAdministrateur() {

        Transaction transaction = null;
        List < Administrateur > administrateurs= null;
        try (Session session = hibernate.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            administrateurs = session.createQuery("from admin").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return administrateurs;
    }

    /* (non-Javadoc)
     * @see net.javaguides.hibernate.dao.IStudentDao#deleteStudent(long)
     */

	

	@Override
	public void deleteAdministrateur(int id) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	       Administrateur administrateur = null;
	        try (Session session = hibernate.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            administrateur= session.get(Administrateur.class, id);
	            // get student object
	            session.delete(administrateur);
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	    }
		
	}


