package com.github.philipkoivunen.bracingbosses;

import com.github.hornta.carbon.Carbon;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Bosses extends JavaPlugin {
    private Carbon carbon;

    @Override
    public  void onEnable() {
        carbon = new Carbon();

        carbon
                .addCommand("boss summon")
                .withHandler(new BossSummon());
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return carbon.handleAutoComplete(sender, command, args);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return  carbon.handleCommand(sender, command, args);
    }
}
