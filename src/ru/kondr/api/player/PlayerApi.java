package ru.kondr.api.player;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.*;

public class PlayerApi
{
    public static List<Player> getPlayersNear(final Location playerLocation, final int range) {
        final List<Player> players = new ArrayList<Player>();
        final double squaredDistance = Math.pow(range, 2.0);
        for (final Player player : playerLocation.getWorld().getPlayers()) {
            if (range > 0 && playerLocation.distanceSquared(player.getLocation()) > squaredDistance) {
                continue;
            }
            players.add(player);
        }
        return players;
    }
    
    public static List<Player> getPlayersHasPermission(final String permission) {
        final List<Player> players = new ArrayList<Player>();
        for (final Player p : Bukkit.getOnlinePlayers()) {
            if (!p.hasPermission(permission)) {
                continue;
            }
            players.add(p);
        }
        return players;
    }
}
