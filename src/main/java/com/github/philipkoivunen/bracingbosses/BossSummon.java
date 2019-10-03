package com.github.philipkoivunen.bracingbosses;

import com.github.hornta.carbon.ICommandHandler;
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
        WitherSkeleton witherSkeleton = (WitherSkeleton) world.spawnEntity(player.getLocation(), EntityType.WITHER_SKELETON);

        ItemStack diamondChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

        diamondChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);

        witherSkeleton.setHealth(20);
        witherSkeleton.getEquipment().setHelmet(new ItemStack(Material.CARVED_PUMPKIN));
        witherSkeleton.getEquipment().setChestplate(diamondChest);
        witherSkeleton.getEquipment().setLeggings(leggins);
        witherSkeleton.getEquipment().setBoots(boots);
        witherSkeleton.setCustomName("xxXPumpkinLordXxx");
        witherSkeleton.setCustomNameVisible(true);

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addEnchantment(Enchantment.FIRE_ASPECT, 1);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        witherSkeleton.getEquipment().setItemInMainHand(sword);
    }
}
