package au.com.mineauz.minigamesregions.actions;

import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;

import au.com.mineauz.minigames.MinigamePlayer;
import au.com.mineauz.minigames.Minigames;
import au.com.mineauz.minigames.menu.Menu;
import au.com.mineauz.minigamesregions.Node;
import au.com.mineauz.minigamesregions.Region;

public class RevertAction extends AbstractAction {

	@Override
	public String getName() {
		return "REVERT";
	}

	@Override
	public String getCategory() {
		return "Minigame Actions";
	}
	
	@Override
	public void describe(Map<String, Object> out) {
	}

	@Override
	public boolean useInRegions() {
		return true;
	}

	@Override
	public boolean useInNodes() {
		return true;
	}

	@Override
	public void executeNodeAction(MinigamePlayer player,
			Node node) {
		debug(player,node);
		if(player == null || !player.isInMinigame()) return;
		if(!player.isDead())
			Minigames.plugin.pdata.revertToCheckpoint(player);
	}

	@Override
	public void executeRegionAction(MinigamePlayer player, Region region) {
		debug(player,region);
		if(player == null || !player.isInMinigame()) return;
		if(!player.isDead())
			Minigames.plugin.pdata.revertToCheckpoint(player);
	}

	@Override
	public void saveArguments(FileConfiguration config, String path) {
		
	}

	@Override
	public void loadArguments(FileConfiguration config, String path) {
	}

	@Override
	public boolean displayMenu(MinigamePlayer player, Menu previous) {
		return false;
	}

}
