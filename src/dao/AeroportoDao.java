package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.GerarTabelas;
import beans.Aeronave;
import beans.Aeroporto;

public class AeroportoDao {
	
	private Session session;
	
	public void adicionarAeroporto(Aeroporto aeroporto){
		session = GerarTabelas.preparaSessao();
		session.save(aeroporto);
		session.beginTransaction().commit();
		session.close();
	}
	
	public ArrayList<Aeroporto> retornarAeroportos(){
		session = GerarTabelas.preparaSessao();
		ArrayList<Aeroporto> aeroportos = (ArrayList<Aeroporto>) session.createCriteria(Aeroporto.class).list();
		return aeroportos;
	}
	
	public Aeroporto reotrnarAeroportoPorPrefixo(String prefixo){
		session = GerarTabelas.preparaSessao();
		return (Aeroporto) session.createCriteria(Aeroporto.class).add(Restrictions.eq("prefixo", prefixo)).uniqueResult();
	}
	
	public void atualizarAeroporto(Aeroporto novoAeroporto)
	{
		session = GerarTabelas.preparaSessao();
		Transaction transaction = session.beginTransaction();
		Aeroporto aeroportoDb = (Aeroporto) session.load(Aeroporto.class, novoAeroporto.getPrefixo());
		aeroportoDb = novoAeroporto;
		session.update(aeroportoDb);
		transaction.commit();
		session.close();
	}
} 
