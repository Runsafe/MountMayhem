package no.runsafe.mountmayhem;

import no.runsafe.framework.RunsafePlugin;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		this.addComponent(MountCommand.class);
		this.addComponent(DismountCommand.class);
	}
}
