package dio.designPatters.config;

import org.springframework.stereotype.Component;

//Usando conceito Singleton para configuração do sistema

@Component
public class SystemConfig {
    private static SystemConfig instance;

    private String systemName;
    private String systemVersion;

    private SystemConfig() {
        this.systemName = "MySystem";
        this.systemVersion = "1.0.0";
    }

    public static SystemConfig getInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }
}
