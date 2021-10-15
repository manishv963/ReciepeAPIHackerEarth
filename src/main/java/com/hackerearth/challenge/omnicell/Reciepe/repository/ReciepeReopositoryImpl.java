package com.hackerearth.challenge.omnicell.Reciepe.repository;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hackerearth.challenge.omnicell.Reciepe.entities.Reciepe;
import com.hackerearth.challenge.omnicell.Reciepe.util.HibernateUtil;

@Repository("reciepeReopository")
public class ReciepeReopositoryImpl implements ReciepeReopositoryInterface{
	
	@Override
	public String saveReciepe(Reciepe reciepe) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction =  session.beginTransaction();
            // save the student objects
            session.save(reciepe);
            
            // commit transaction
            transaction.commit();
            System.out.println("added");
          
        } catch (Exception e) {
            if (transaction != null) {
                	transaction.rollback();
				
            }
            e.printStackTrace();

            return "error";
        }
		return "success";
		
	}

	@Override
	public Reciepe getReciepe(int reciepeId) {
		// TODO Auto-generated method stub
		Reciepe reciepe = new Reciepe();
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction =  session.beginTransaction();
            // save the student objects
            reciepe = session.get(Reciepe.class, reciepeId);
            
            // commit transaction
            transaction.commit();
            System.out.println("added");
        } catch (Exception e) {
            if (transaction != null) {
                	transaction.rollback();
				
            }
            e.printStackTrace();
        }
		return reciepe;
		}

	@Override
	public List<Reciepe> allReciepe() {
		// TODO Auto-generated method stub
		List<Reciepe>  allReciepe = new ArrayList<Reciepe>();
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
			allReciepe = 	session.createQuery("SELECT a FROM Reciepe a", Reciepe.class).getResultList();     
        } catch (Exception e) {
          
            e.printStackTrace();

           
        }
		 return allReciepe;
	}
	
	

}
