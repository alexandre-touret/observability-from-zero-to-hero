package info.touret.observability.observabilityfromzerotohero;

import org.springframework.stereotype.Service;

@Service
public class ObservabilityService {

    public void breakMethod() {
        throw new IllegalStateException("Breaking method issue");
    }
}
