package dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.GerarTabelas;

import beans.Aeroporto;
import beans.Observacao;

public class ObservacaoDao {

	static Session session;
	
	public static void adicionarObservacao(Observacao observacao){
		session = GerarTabelas.preparaSessao();
		session.save(observacao);
		session.beginTransaction().commit();
		session.close();
	}
	
	public static ArrayList<Observacao> retornarObservacoes(){
		session = GerarTabelas.preparaSessao();
		ArrayList<Observacao> observacoes = (ArrayList<Observacao>) session.createCriteria(Observacao.class).list();
		return observacoes;
	}
	
	public static Observacao retornarObservacaoPorId(long id){
		session = GerarTabelas.preparaSessao();
		return (Observacao) session.createCriteria(Observacao.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
	
	public static void atualizarObservacao(Observacao novaObservacao)
	{
		session = GerarTabelas.preparaSessao();
		Transaction transaction = session.beginTransaction();
		Observacao observacaoDb = (Observacao) session.load(Observacao.class, novaObservacao.getId());
		observacaoDb = novaObservacao;
		session.update(observacaoDb);
		transaction.commit();
		session.close();
	}
	
}