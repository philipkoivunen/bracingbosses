package com.github.philipkoivunen.bracingbosses.bosses;

import org.bukkit.Location;
import org.bukkit.World;

public abstract class Boss {
    abstract void summon(World world, Location location);
    abstract void armor();
    private World world;
    private Location location;


    public final void setup(World world, Location location){
        this.world = world;
        this.location = location;
        summon(world, location);

        armor();
    }
}
