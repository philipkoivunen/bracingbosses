package com.github.philipkoivunen.bracingbosses;

import com.github.hornta.carbon.ICommandHandler;
import com.github.philipkoivunen.bracingbosses.bosses.Boss;
import com.github.philipkoivunen.bracingbosses.bosses.PumpkinLord;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootTable;

public class BossSummon implements ICommandHandler {
    @Override
    public void handle(CommandSender commandSender, String[] strings, int i) {

        Player player = (Player) commandSender;
        World world = player.getWorld();
        Boss pumpkinLordBoss = new PumpkinLord();
        pumpkinLordBoss.setup(world, player.getLocation());
    }
}
