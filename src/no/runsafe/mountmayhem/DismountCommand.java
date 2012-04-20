package no.runsafe.mountmayhem;

import no.runsafe.framework.command.RunsafeCommand;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Iterator;
import java.util.List;

public class DismountCommand extends RunsafeCommand
{
    public DismountCommand()
    {
        super("dismount", null);
    }

    @Override
    public boolean Execute(RunsafePlayer player, String[] args)
    {
        if (args.length == 1)
        {
            World world = player.getWorld().getRaw();

            Player firstPlayer = this.getPlayerByName(world, args[0]);

            if (firstPlayer != null)
            {
                player.sendMessage("Dismounting " + firstPlayer.getName());
                firstPlayer.leaveVehicle();
                return true;
            }
        }
        return false;
    }

    private Player getPlayerByName(World world, String name)
    {
        List<Player> players = world.getPlayers();

        Iterator<Player> playerIterator = players.iterator();

        while (playerIterator.hasNext())
        {
            Player thePlayer = playerIterator.next();

            if (thePlayer.getName().equalsIgnoreCase(name))
                return thePlayer;
        }

        return null;
    }
}
