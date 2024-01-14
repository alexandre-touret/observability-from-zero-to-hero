package info.touret.observability.observabilityfromzerotohero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ObservabilityAPIController {

    private final ObservabilityService observabilityService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservabilityAPIController.class);

    public ObservabilityAPIController(ObservabilityService observabilityService) {
        this.observabilityService = observabilityService;
    }

    @GetMapping("/api/events")
    public ResponseEntity<ObservabilityEventDto> getEvent() throws ErrorResponseException {
        try {
            observabilityService.breakMethod();
            var observabilityEventDto = new ObservabilityEventDto(UUID.randomUUID().toString(), "OK");
            return ResponseEntity.ok(observabilityEventDto);
        } catch (Exception e) {
            var observabilityEventDto = new ObservabilityEventDto(UUID.randomUUID().toString(), "Error");
            LOGGER.error(e.getMessage());
            throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR, ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR), e);
        }
    }
}
