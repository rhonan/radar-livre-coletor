package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.GerarTabelas;
import beans.Aeronave;
import beans.Aeroporto;

public class AeroportoDao {

	public static void adicionarAeroporto(Aeroporto aeroporto){
		Session session = GerarTabelas.preparaSessao();
		session.save(aeroporto);
		session.beginTransaction().commit();
		session.close();
	}
	
	public static ArrayList<Aeroporto> retornarAeroportos(){
		Session session = GerarTabelas.preparaSessao();
		ArrayList<Aeroporto> aeroportos = (ArrayList<Aeroporto>) session.createCriteria(Aeroporto.class).list();
		return aeroportos;
	}
	
	public static Aeroporto reotrnarAeroportoPorPrefixo(String prefixo){
		Session session = GerarTabelas.preparaSessao();
		return (Aeroporto) session.createCriteria(Aeroporto.class).add(Restrictions.eq("prefixo", prefixo)).uniqueResult();
	}
	
	public static void atualizarAeroporto(Aeroporto novoAeroporto)
	{
		Session session = GerarTabelas.preparaSessao();
		Transaction transaction = session.beginTransaction();
		Aeroporto aeroportoDb = (Aeroporto) session.load(Aeroporto.class, novoAeroporto.getPrefixo());
		aeroportoDb = novoAeroporto;
		session.update(aeroportoDb);
		transaction.commit();
		session.close();
	}
} 
