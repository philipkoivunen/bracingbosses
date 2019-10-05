package com.github.philipkoivunen.bracingbosses;

import com.github.hornta.carbon.Carbon;
import com.github.hornta.carbon.CarbonCommand;
import com.github.hornta.carbon.config.ConfigType;
import com.github.hornta.carbon.config.Configuration;
import com.github.hornta.carbon.config.ConfigurationBuilder;
import com.github.hornta.carbon.message.MessageManager;
import com.github.hornta.carbon.message.MessagesBuilder;
import com.github.hornta.carbon.message.Translation;
import com.github.hornta.carbon.message.Translations;
import com.github.philipkoivunen.bracingbosses.constants.ConfigConstants;
import com.github.philipkoivunen.bracingbosses.constants.MessageConstants;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Level;

public class Bosses extends JavaPlugin {
    private static Bosses instance;
    private Carbon carbon;
    private Configuration configuration;
    private Translations translations;
    private MessageManager messageManager;

    @Override
    public  void onEnable() {
        carbon = new Carbon();
        this.instance = this;

        try {
            configuration = new ConfigurationBuilder(this)
                    .add(ConfigConstants.LANGUAGE, "language", ConfigType.STRING.STRING, "english")
                    .add(ConfigConstants.PUMPKIN_LORD_SPAWN, "pumpkinlordspawn", ConfigType.STRING.STRING, "english")
                    .build();
        } catch (Exception e) {
            setEnabled(false);
            getLogger().log(Level.SEVERE, e.getMessage(), e);
            return;
        }

        carbon.setNoPermissionHandler((CommandSender sender, CarbonCommand command) -> {
            MessageManager.sendMessage(sender, MessageConstants.NO_PERMISSION);
        });

        messageManager = new MessagesBuilder()
                .add(MessageConstants.SUMMON_FAILED,"summon_failure")
                .add(MessageConstants.SUMMON_SUCCESS,"summon_success")
                .add(MessageConstants.CONFIGURATION_RELOADED, "configuration_reloaded")
                .add(MessageConstants.CONFIGURATION_RELOAD_FAILED, "configuration_reload_failed")
                .add(MessageConstants.NO_PERMISSION, "no_permission")
                .build();

        translations = new Translations(this, messageManager);
        Translation translation = translations.createTranslation(configuration.get(ConfigConstants.LANGUAGE));
        Translation fallbackTranslation = translations.createTranslation("english");
        messageManager.setTranslation(translation, fallbackTranslation);

        carbon
            .addCommand("boss summon")
            .withHandler(new BossSummon())
            .requiresPermission("bossybosses.summon");

        carbon
                .addCommand("boss reload")
                .withHandler(new TrailsReload())
                .requiresPermission("bossybosses.reload");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return carbon.handleAutoComplete(sender, command, args);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return  carbon.handleCommand(sender, command, args);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Translations getTranslations() {
        return translations;
    }

    public static Bosses getInstance() {
        return instance;
    }
}
