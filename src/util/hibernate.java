package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import model.Administrateur;
import model.Boisson;
import model.Commande;
import model.Date;
import model.Menu;
import model.Plat;
import model.StockBoisson;
import model.StockPlat;
import model.Ticket;

public class hibernate {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db?useSSL=false");//nom bd
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

              // settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Administrateur.class); 
                configuration.addAnnotatedClass(Boisson.class);
                configuration.addAnnotatedClass(Plat.class);
                configuration.addAnnotatedClass(Commande.class);
                configuration.addAnnotatedClass(Date.class);
                configuration.addAnnotatedClass(Menu.class);
                configuration.addAnnotatedClass(StockPlat.class);
                configuration.addAnnotatedClass(StockBoisson.class);
                configuration.addAnnotatedClass(Ticket.class);//les classes

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
        return sessionFactory;
    }
}