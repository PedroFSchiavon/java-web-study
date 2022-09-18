package br.com.alura.produtos.dao;

import br.com.alura.produtos.modelo.Produto;
import br.com.alura.produtos.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {

		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Produto.class);
		configuration.addAnnotatedClass(Usuario.class);
		sessionFactory = configuration.buildSessionFactory();
		new SchemaExport(configuration).create(true, false);

	}

	public Session openSession() {
		return sessionFactory.openSession();
	}
}