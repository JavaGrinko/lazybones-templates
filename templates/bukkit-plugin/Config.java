package ${pkg};

import lombok.Data;
import org.bukkit.configuration.file.FileConfiguration;

@Data
public class Config {
    private Boolean greetingEnable;
    Config(FileConfiguration configuration) {
        greetingEnable = configuration.getBoolean("${pluginName}.greeting-enable");
    }
}