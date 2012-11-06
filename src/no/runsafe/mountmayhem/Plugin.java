package no.runsafe.mountmayhem;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.command.ICommand;
import no.runsafe.framework.command.RunsafeCommand;

import java.util.ArrayList;

public class Plugin extends RunsafePlugin
{
    @Override
    protected void PluginSetup()
    {
        this.addComponent(MountCommand.class);
        this.addComponent(DismountCommand.class);

        //ArrayList<ICommand> subCommands = new ArrayList<ICommand>();
        //subCommands.add(this.getComponent(MountCommand.class));

        //RunsafeCommand myCommand = new RunsafeCommand("mount", subCommands);
       // this.addComponent(myCommand);
    }
}
