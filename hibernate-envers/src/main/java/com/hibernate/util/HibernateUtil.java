package com.hibernate.util;

import org.hibernate.SessionFactory; 
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	static {
		if (sessionFactory == null) {
			try {
				BootstrapServiceRegistry bootstrapRegistry = new BootstrapServiceRegistryBuilder().build();
				standardServiceRegistry = new StandardServiceRegistryBuilder(bootstrapRegistry).configure().build();

				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

				Metadata metadata = metadataSources.getMetadataBuilder().build();

				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if (standardServiceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
				}
			}
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}