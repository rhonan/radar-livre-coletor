package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.GerarTabelas;
import beans.Aeronave;

public class AeronaveDao {
	
	static Session session;
	
	public static void adicionarAeronave(Aeronave aeronave){
		session = GerarTabelas.preparaSessao();
		session.save(aeronave);
		session.beginTransaction().commit();
		session.close();
	}
	
	public static ArrayList<Aeronave> retornarAeronaves(){
		session = GerarTabelas.preparaSessao();
		ArrayList<Aeronave> aeronaves = (ArrayList<Aeronave>) session.createCriteria(Aeronave.class).list();
		return aeronaves;
	}
	
	public static Aeronave retornarAeronavePorHex(String hex){
		session = GerarTabelas.preparaSessao();
		Aeronave aeronave = (Aeronave) session.createCriteria(Aeronave.class).add(Restrictions.eq("hex", hex)).uniqueResult();
		session.close();
		return aeronave;
		//return (Aeronave) session.createCriteria(Aeronave.class).add(Restrictions.eq("hex", hex)).uniqueResult();
	}
	
	public static void atualizarAeronave(Aeronave novaAeronave)
	{
		session = GerarTabelas.preparaSessao();
		Transaction transaction = session.beginTransaction();
		Aeronave aeronaveDb = (Aeronave) session.load(Aeronave.class, novaAeronave.getHex());
		aeronaveDb = novaAeronave;
		session.update(aeronaveDb);
		transaction.commit();
		session.close();
	}
	
}
