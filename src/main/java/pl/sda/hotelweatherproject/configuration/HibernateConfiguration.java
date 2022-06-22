package pl.sda.hotelweatherproject.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sda.hotelweatherproject.dtos.WorldCitiesDto;

public class HibernateConfiguration {

    public Session Configuration() {

        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        configuration.addAnnotatedClass(WorldCitiesDto.class);
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        return currentSession;
    }

}
