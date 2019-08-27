package be.axxes.pmt;

import be.axxes.pmt.yearbook.BeforeCreateCheckinValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SpringBootApplication
public class ProjectManagementApplication extends RepositoryRestConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

	@Override
	public void configureValidatingRepositoryEventListener(
			ValidatingRepositoryEventListener v) {
		v.addValidator("beforeCreate", new BeforeCreateCheckinValidator());
	}
}
