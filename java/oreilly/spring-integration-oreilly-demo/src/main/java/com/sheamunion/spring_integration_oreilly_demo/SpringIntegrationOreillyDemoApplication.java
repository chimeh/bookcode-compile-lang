package com.sheamunion.spring_integration_oreilly_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringIntegrationOreillyDemoApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PersonJdbcRepository repository;

	private PersonRowMapper personRowMapper = new PersonRowMapper();

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationOreillyDemoApplication.class, args);
	}

	@Bean
	IntegrationFlow pollingFlow() {
		return IntegrationFlows.from(
				jdbcPollingChannelAdapter()
				, c -> c.poller(Pollers.fixedDelay(5000, TimeUnit.MILLISECONDS))
		).handle(this::handleThat).get();
	}

	@Bean
	public JdbcPollingChannelAdapter jdbcPollingChannelAdapter() {
		String lastProcessedEventSeq = "2";
		String selectNewEvents = String.format("SELECT * FROM person WHERE id > %s FETCH FIRST ROW ONLY", lastProcessedEventSeq);
		JdbcPollingChannelAdapter jdbcPollingChannelAdapter = new JdbcPollingChannelAdapter(dataSource, selectNewEvents);
		jdbcPollingChannelAdapter.setRowMapper(personRowMapper);
		return jdbcPollingChannelAdapter;
	}

	private Void handleThat(Object p, Map<String, Object> h) {
		ArrayList payload = (ArrayList) p;
		Person person = (Person) payload.get(0);
		String updateLastProcessedEventStoreQuery = String.format("INSERT INTO LAST_PROCESSED_EVENT_STORE VALUES(%s)", person.getId());
		System.out.println(updateLastProcessedEventStoreQuery);
		System.out.println(String.format("Handled event. Person: %s", person));
		return null;
	}

	class PersonRowMapper implements RowMapper<Person> {
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Long id = rs.getLong("id");
			String name = rs.getString("name");
			Person person = new Person();
			person.setId(id);
			person.setName(name);
			return person;
		}
	}
}
