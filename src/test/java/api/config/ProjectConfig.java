package api.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/credential_example.properties"
})
public interface ProjectConfig extends Config {

    String token();

    String urlRestTest();

    long responseTime();

}