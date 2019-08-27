package be.axxes.pmt.yearbook;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@RepositoryEventHandler
@Component
public class CheckinEventHandler {
    private static final Logger LOGGER = getLogger(CheckinEventHandler.class);

    private final MeterRegistry registry;

    @Autowired
    public CheckinEventHandler(MeterRegistry registry) {
        this.registry = registry;
    }

    @HandleBeforeCreate
    public void handle(Checkin checkin) {
        LOGGER.info(String.format("checkin created by %s", checkin.getUser()));
        registry.counter("checkin.created").increment();
    }

    @HandleBeforeDelete
    public void handleDelete(Checkin checkin) {
        LOGGER.info(String.format("checkin removed by %s", checkin.getUser()));
        registry.counter("checkin.deleted").increment();
    }
}
