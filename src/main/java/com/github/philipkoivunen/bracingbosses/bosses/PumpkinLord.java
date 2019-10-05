package com.github.philipkoivunen.bracingbosses.bosses;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.inventory.ItemStack;

public class PumpkinLord extends Boss {
    private WitherSkeleton witherSkeleton;

    @Override
    void summon(World world, Location location) {
        this.witherSkeleton = (WitherSkeleton) world.spawnEntity(location, EntityType.WITHER_SKELETON);
    }

    @Override
    void armor() {
        ItemStack diamondChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

        diamondChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);

        this.witherSkeleton.setHealth(20);
        this.witherSkeleton.getEquipment().setHelmet(new ItemStack(Material.CARVED_PUMPKIN));
        this.witherSkeleton.getEquipment().setChestplate(diamondChest);
        this.witherSkeleton.getEquipment().setLeggings(leggins);
        this.witherSkeleton.getEquipment().setBoots(boots);
        this.witherSkeleton.setCustomName("Pumpkinlord");
        this.witherSkeleton.setCustomNameVisible(true);

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        this.witherSkeleton.getEquipment().setItemInMainHand(sword);
    }
}
