package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.GerarTabelas;
import beans.Aeronave;

public class AeronaveDao {

	public static void adicionarAeronave(Aeronave aeronave){
		Session session = GerarTabelas.preparaSessao();
		session.save(aeronave);
		session.beginTransaction().commit();
		session.close();
	}
	
	public static ArrayList<Aeronave> retornarAeronaves(){
		Session session = GerarTabelas.preparaSessao();
		ArrayList<Aeronave> aeronaves = (ArrayList<Aeronave>) session.createCriteria(Aeronave.class).list();
		return aeronaves;
	}
	
	public static Aeronave reotrnarAeronavePorHex(String hex){
		Session session = GerarTabelas.preparaSessao();
		return (Aeronave) session.createCriteria(Aeronave.class).add(Restrictions.eq("hex", hex)).uniqueResult();
	}
	
	public static void atualizarAeronave(Aeronave novaAeronave)
	{
		Session session = GerarTabelas.preparaSessao();
		Transaction transaction = session.beginTransaction();
		Aeronave aeronaveDb = (Aeronave) session.load(Aeronave.class, novaAeronave.getHex());
		aeronaveDb = novaAeronave;
		session.update(aeronaveDb);
		transaction.commit();
		session.close();
	}
	
}
