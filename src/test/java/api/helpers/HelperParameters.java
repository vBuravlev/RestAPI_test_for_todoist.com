package api.helpers;

import api.config.Project;

public interface HelperParameters {
    Long MAX_TIMEOUT_RESPONSE = Project.config.responseTime();
}
