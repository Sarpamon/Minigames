package au.com.mineauz.minigamesregions.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import au.com.mineauz.minigames.Minigames;
import au.com.mineauz.minigames.gametypes.MinigameType;
import au.com.mineauz.minigames.minigame.Team;
import au.com.mineauz.minigames.minigame.modules.TeamsModule;
import au.com.mineauz.minigames.script.ScriptObject;
import org.bukkit.configuration.file.FileConfiguration;

import au.com.mineauz.minigames.MinigamePlayer;
import au.com.mineauz.minigames.menu.Menu;
import au.com.mineauz.minigamesregions.Node;
import au.com.mineauz.minigamesregions.Region;

 public interface  ActionInterface {
	  String getName();
	  String getCategory();
	  void describe(Map<String, Object> out);
	  boolean useInRegions();
	  boolean useInNodes();
	  void executeRegionAction(MinigamePlayer player, Region region);
	  void executeNodeAction(MinigamePlayer player, Node node);
	  void saveArguments(FileConfiguration config, String path);
	  void loadArguments(FileConfiguration config, String path);
	  boolean displayMenu(MinigamePlayer player, Menu previous);
	  void debug(MinigamePlayer p, ScriptObject obj);



}
