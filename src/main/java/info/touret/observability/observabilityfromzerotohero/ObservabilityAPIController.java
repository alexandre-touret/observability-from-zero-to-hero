package info.touret.observability.observabilityfromzerotohero;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ObservabilityAPIController {

    @GetMapping("/api/event")
    public ResponseEntity<ObservabilityEventDto> getEvent() {
        return ResponseEntity.ok(new ObservabilityEventDto(UUID.randomUUID().toString(), "Message"));
    }
}
