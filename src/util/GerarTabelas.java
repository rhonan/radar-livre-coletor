package util;

import java.util.ArrayList;
import java.util.List;

import beans.Aeronave;
import beans.Aeroporto;
import beans.Rota;
import beans.Observacao;
import beans.RotaAeroporto;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GerarTabelas {

	private static final AnnotationConfiguration annotConfig = adicionaClassesConfiguracao(initialize());
	private static final SessionFactory sf = annotConfig.buildSessionFactory();;
	
	public static void exportarEsquema(List<Class<? extends Object>> classes) {
		AnnotationConfiguration annotConfig = adicionaClassesConfiguracao(classes);

		SchemaExport se = new SchemaExport(annotConfig);
		se.create(true, true);
	}

	private static AnnotationConfiguration adicionaClassesConfiguracao(
			List<Class<? extends Object>> classes) {
		AnnotationConfiguration annotConfig = new AnnotationConfiguration(); // dom4j.jar,
																				// slf4j
																				// api
																				// e
																				// log4j

		for (Class classe : classes) {
			annotConfig.addAnnotatedClass(classe);
		}
		return annotConfig;
	}

	public static Session preparaSessao() {
		//AnnotationConfiguration annotConfig = adicionaClassesConfiguracao(initialize());
		//SessionFactory sf = annotConfig.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}

	static void reiniciaEsquemaBD() {
		exportarEsquema(initialize());
	}

	private static List<Class<? extends Object>> initialize() {
		List<Class<? extends Object>> classes = new ArrayList<Class<? extends Object>>();

		// classes.add(SuaClasseAqui.class);
		classes.add(Aeronave.class);
		classes.add(Aeroporto.class);
		classes.add(Rota.class);
		classes.add(Observacao.class);
		classes.add(RotaAeroporto.class);
		
		return classes;
	}

}
