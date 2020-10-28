package store.market.administration.shared.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import store.market.shared.infrastructure.bus.event.DomainEventsInformation;
import store.market.shared.infrastructure.bus.event.postgres.MySqlDomainEventsConsumer;
import store.market.shared.infrastructure.bus.event.postgres.MySqlEventBus;
import store.market.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;

@Configuration
public class AdministrationMySqlEventBusConfiguration {

	private final SessionFactory sessionFactory;
	private final DomainEventsInformation domainEventsInformation;
	private final SpringApplicationEventBus bus;

	public AdministrationMySqlEventBusConfiguration(
			@Qualifier("administration-session_factory") SessionFactory sessionFactory,
			DomainEventsInformation domainEventsInformation, SpringApplicationEventBus bus) {
		this.sessionFactory = sessionFactory;
		this.domainEventsInformation = domainEventsInformation;
		this.bus = bus;
	}

	@Bean
	public MySqlEventBus AdministrationMysqlEventBus() {
		return new MySqlEventBus(sessionFactory);
	}

	@Bean
	public MySqlDomainEventsConsumer AdministrationMySqlDomainEventsConsumer() {
		return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
	}
}
