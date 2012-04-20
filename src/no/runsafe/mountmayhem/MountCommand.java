package no.runsafe.mountmayhem;

import no.runsafe.framework.command.ICommand;
import no.runsafe.framework.command.RunsafeCommand;
import no.runsafe.framework.command.RunsafeCommandHandler;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MountCommand extends RunsafeCommand
{

    public MountCommand()
    {
        super("mount", null);
    }

    @Override
    public boolean Execute(RunsafePlayer player, String[] args)
    {
        if (args.length == 2)
        {
            World world = player.getWorld().getRaw();

            player.sendMessage("Checking for: " + args[0]);
            Player firstPlayer = this.getPlayerByName(world, args[0]);

            player.sendMessage("Checking for: " + args[1]);
            Player secondPlayer = this.getPlayerByName(world, args[1]);

            if (firstPlayer != null && secondPlayer != null)
            {
                player.sendMessage("Mounting " + firstPlayer.getName() + " on " + secondPlayer.getName());
                secondPlayer.setPassenger(firstPlayer);
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
