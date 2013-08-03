package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.GerarTabelas;
import beans.Aeroporto;
import beans.Rota;

public class RotaDao {
	
	public static void adicionarRota(Rota rota){
		Session session = GerarTabelas.preparaSessao();
		session.save(rota);
		session.beginTransaction().commit();
		session.close();
	}
	
	public static ArrayList<Rota> retornarRotas(){
		Session session = GerarTabelas.preparaSessao();
		ArrayList<Rota> rotas = (ArrayList<Rota>) session.createCriteria(Rota.class).list();
		return rotas;
	}
	
	public static Rota reotrnarRotaPorId(long id){
		Session session = GerarTabelas.preparaSessao();
		return (Rota) session.createCriteria(Rota.class).add(Restrictions.eq("rota_id", id)).uniqueResult();
	}
	
	public static void atualizarRota(Rota novaRota)
	{
		Session session = GerarTabelas.preparaSessao();
		Transaction transaction = session.beginTransaction();
		Rota rotaDb = (Rota) session.load(Rota.class, novaRota.getRota_id());
		rotaDb = novaRota;
		session.update(rotaDb);
		transaction.commit();
		session.close();
	}
	
}