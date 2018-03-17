package ${pkg};
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class Plugin extends JavaPlugin {

    private static FileConfiguration messages;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadMessages(this);
        Config config = new Config(getConfig());
        if (config.getGreetingEnable()) {
            getLogger().log(Level.INFO, Plugin.getMessage("greeting"));
        }
    }

    private void loadMessages(Plugin plugin) {
        File languageFile = new File(plugin.getDataFolder(), "language.yml");
        if (languageFile.exists()) {
            messages = YamlConfiguration.loadConfiguration(languageFile);
        } else {
            messages = YamlConfiguration.loadConfiguration(
                    new InputStreamReader(plugin.getResource("language.yml")));
            try {
                messages.save(languageFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getMessage(String key) {
        return messages.getString(key);
    }
}
