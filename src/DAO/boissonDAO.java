package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernate;
import model.Administrateur;
import model.Boisson;

public class boissonDAO implements IboisDAO {

	@Override
	public void saveBoisson(Boisson Boisson) {
		Transaction transaction =null;
		// TODO Auto-generated method stubTransaction transaction = null;
        try (Session session = hibernate.getSessionFactory().openSession()) {
            // start the transaction
            transaction  = session.beginTransaction();

            // save student object
            session.save(Boisson);

            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
		
	}

	@Override
	public void updateBoisson(Boisson Boisson) {
		// TODO Auto-generated method stub
		 Transaction transaction = null;
	        try (Session session = hibernate.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.saveOrUpdate(Boisson);

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
	public Boisson getBoissonById(int id) {
		// TODO Auto-generated method stub
		  Transaction transaction = null;
	       Boisson boisson= null;
	        try {
				Session session = hibernate.getSessionFactory().openSession();
				    // start the transaction
				    transaction = session.beginTransaction();

				    // get student object
				   boisson= session.byId(Boisson.class).getReference(id);
				     // or student = session.get(Student.class, id);
				    //or student = session.load(Student.class, id);
				   //or commit the transaction
				    transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
				
			}
	        
	        
	        return boisson;
	    }



	@Override
	public List<Boisson> getAllBoisson() {
		 Transaction transaction = null;
	        List < Boisson > boissons= null;
	        try (Session session = hibernate.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();

	            // get students
	           boissons = session.createQuery("from admin").list();
	            //student = session.load(Student.class, id);
	            // commit the transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	        return boissons;
	    }

	    /* (non-Javadoc)
	     * @see net.javaguides.hibernate.dao.IStudentDao#deleteStudent(long)
	     */

		

	@Override
	public void deleteBoisson(int id) {
		 Transaction transaction = null;
	       Boisson boisson = null;
	        try (Session session = hibernate.getSessionFactory().openSession()) {
	            // start the transaction
	            transaction = session.beginTransaction();
boisson = session.get(Boisson.class, id);
	            // get student object
	            session.delete(boisson);
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
