package api.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/credentional.properties"
})
public interface ProjectConfig extends Config {

    @Key("token")
    String token();

    @Key("urlRestTest")
    String urlRestTest();

    @Key("responseTime")
    long responseTime();

}