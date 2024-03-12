package com.xworkz.train.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.train.entity.TrainEntity;
 
@Component
public class TrainDAOImpl implements TrainDAO {

	@Autowired
	private SessionFactory sessionFactory ;
	
	public TrainDAOImpl() {
		System.out.println("TrainDAO created");
	}
	
	public TrainDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory ;
		System.out.println("sessionFactory is created");
	}
	
	
	@Override
	public boolean saveTrainEntity(TrainEntity trainEntity) {
		Session session = null ;	
		try {
		 session = sessionFactory.openSession();
		 Transaction transaction = session.beginTransaction();
		 session.save(trainEntity);
		 transaction.commit();
		 System.out.println("trainEntity is saved");
		}
		  catch (HibernateException e) {
			 e.getMessage();
	    }
		 finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			else {
				System.out.println("session is not closed");
			}
		}
		return false ;		
	}
	

	@Override
	public TrainEntity findTrainEntityByTrainName(String trainName) {
		System.out.println(" invoked findTrainEntityByTrainName");
		Session session = null ;
		TrainEntity trainEntity = null ;
		try {
			session = sessionFactory.openSession();
			Query query = session.createNamedQuery("TrainEntity.findTrainEntityByTrainName");
			query.setParameter("TrAiNnAmE" ,trainName );
			Object obj = query.uniqueResult();		
		    trainEntity = (TrainEntity)obj ;
			if(trainEntity != null) {
				return trainEntity ;
			}
			else {
				System.out.println("trainEntity not found");
			}		
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			else {
				System.out.println("session is not closed");
			}
		}	
		return trainEntity;
	}

	
	@Override
	public List<TrainEntity> getListOfTrainEntity() {
        System.out.println("invoked getListOfTrainEntity");
		Session session = null ;
		List<TrainEntity> list = null ;
		try {
			session = sessionFactory.openSession();
			Query query = session.createNamedQuery("TrainEntity.getListOfTrainEntity");
			 list = query.list();
			if(list.size()> 0){
				return list ;
			}
			else {
				System.out.println("table doesnt contain anything its empty");
			}		
		}
		catch(HibernateException e) {
			e.getMessage();
		}
		finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			else {
				System.out.println("session is not closed");
			}
		}		
		return list;
	}

	
	@Override
	public boolean deleteByName(String trainName) {
		System.out.println("invoked deleteByName()");
        Session session = null ;
        boolean isDataDeleted=false;
        try {
        	session = sessionFactory.openSession();
        	Transaction transaction = session.beginTransaction();
        	Query query = session.createNamedQuery("TrainEntity.deleteByName");
        	query.setParameter("DeleteName", trainName);
        	int update = query.executeUpdate();
        	if(update>0) {
        		isDataDeleted=true;
        		System.out.println(update+" data deleted successfully");
        	}else {
        		System.out.println(update+" data is not available in database");
        	}
        		
        	transaction.commit();
        }
        catch(HibernateException e){
        	e.getMessage();
        }
        finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			else {
				System.out.println("session is not closed");
			}
		}		
		
		return isDataDeleted;
	}

	@Override
	public boolean updateTrainEntityByTrainName(TrainEntity trainEntity) {
        Session session = null ;
        Transaction transaction = null ;
        boolean isTrainEntityUpdated = false ;
        try {
        	session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
        	Query query = session.createNamedQuery("TrainEntity.updateTrainEntityByTrainName");
        	query.setParameter("TRAINNAME", trainEntity.getTrainName());
        	query.setParameter("TRAINSPEED", trainEntity.getTrainSpeed());
        	query.setParameter("TRAINCOLOR", trainEntity.getTrainColor());
        	query.setParameter("NOOFCOMPARTMENTS", trainEntity.getNoOfCompartments());
        	query.setParameter("NOOFWHEELS", trainEntity.getNoOfWheels());
        	query.setParameter("TRAINTYPE", trainEntity.getTrainType());
        	query.setParameter("t", trainEntity.getTrainName());
        	query.executeUpdate();
        	transaction.commit();
        	isTrainEntityUpdated = true ;
        	return isTrainEntityUpdated ;
        }
        catch(HibernateException e) {
        	e.getMessage();
        	transaction.rollback();
        }
        finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			}
			else {
				System.out.println("session is not closed");
			}
		}		
       	return isTrainEntityUpdated;
	}	
}
