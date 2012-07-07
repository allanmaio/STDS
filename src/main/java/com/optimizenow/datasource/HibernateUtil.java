package com.optimizenow.datasource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.optimizenow.model.Endereco;
import com.optimizenow.model.InformacoesFinanceiras;
import com.optimizenow.model.Loja;
import com.optimizenow.model.Lojista;
import com.optimizenow.model.Ponto;
import com.optimizenow.model.Ramo;
import com.optimizenow.model.UnidadeComercial;


public class HibernateUtil {

	private static Log log = LogFactory.getLog(HibernateUtil.class);

	private static Configuration configuration;

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	static {
		try {

			configuration = new AnnotationConfiguration().addAnnotatedClass(
					UnidadeComercial.class)
					.addAnnotatedClass(Loja.class)
					.addAnnotatedClass(Lojista.class)
					.addAnnotatedClass(Ponto.class)
					.addAnnotatedClass(Endereco.class)
					.addAnnotatedClass(Ramo.class)
					.addAnnotatedClass(InformacoesFinanceiras.class)
					.addAnnotatedClass(Endereco.class);

			configuration.configure();

			sessionFactory = configuration.buildSessionFactory();

		} catch (Throwable ex) {
			// We have to catch Throwable, otherwise we will miss
			// NoClassDefFoundError and other subclasses of Error
			log.error("Building SessionFactory failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Returns the original Hibernate configuration.
	 * 
	 * @return Configuration
	 */
	public static Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * Returns the global SessionFactory.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Closes the current SessionFactory and releases all resources.
	 * <p>
	 * The only other method that can be called on HibernateUtil after this one
	 * is rebuildSessionFactory(Configuration).
	 */
	public static void shutdown() {
		log.debug("Shutting down Hibernate.");
		// Close caches and connection pools
		getSessionFactory().close();
		org.hsqldb.DatabaseManager.closeDatabases(0);
		System.out.println("Fechou a conexao!");
		// Clear static variables
		configuration = null;
		sessionFactory = null;
	}

	/**
	 * Rebuild the SessionFactory with the static Configuration.
	 * <p>
	 * This method also closes the old SessionFactory before, if still open.
	 * Note that this method should only be used with static SessionFactory
	 * management, not with JNDI or any other external registry.
	 */
	public static void rebuildSessionFactory() {
		log.debug("Using current Configuration for rebuild.");
		rebuildSessionFactory(configuration);
	}

	/**
	 * Rebuild the SessionFactory with the given Hibernate Configuration.
	 * <p>
	 * HibernateUtil does not configure() the given Configuration object, it
	 * directly calls buildSessionFactory(). This method also closes the old
	 * SessionFactory before, if still open.
	 * 
	 * @param cfg
	 */
	public static void rebuildSessionFactory(final Configuration cfg) {
		log.debug("Rebuilding the SessionFactory from given Configuration.");
		synchronized (sessionFactory) {
			if (sessionFactory != null && !sessionFactory.isClosed()) {
				sessionFactory.close();
			}
			if (cfg.getProperty(Environment.SESSION_FACTORY_NAME) == null) {
				sessionFactory = cfg.buildSessionFactory();
			} else {
				cfg.buildSessionFactory();
			}
			configuration = cfg;
		}
	}

}
