package au.com.mineauz.minigames.sounds;

import org.bukkit.Bukkit;

import au.com.mineauz.minigames.MinigamePlayer;
import au.com.mineauz.minigames.Minigames;
import au.com.mineauz.minigames.minigame.Minigame;
import au.com.mineauz.minigames.minigame.Team;

public class PlayMGSound {
	
	private static boolean shouldPlay = Minigames.plugin.getConfig().getBoolean("playSounds");
	
	public static void playSound(MinigamePlayer player, MGSound sound){
		if(!shouldPlay) return;
		
		if(sound.getCount() == 1)
			player.getPlayer().playSound(player.getLocation(), sound.getSound(), sound.getVolume(), sound.getPitch());
		else{
			playLoop(player, sound.clone());
		}
	}
	
	private static void playLoop(MinigamePlayer player, MGSound  sound){
		final MinigamePlayer fplayer = player;
		final MGSound fsound = sound;
		Bukkit.getScheduler().scheduleSyncDelayedTask(Minigames.plugin, new Runnable() {
			
			@Override
			public void run() {
				fplayer.getPlayer().playSound(fplayer.getLocation(), fsound.getSound(), fsound.getVolume(), fsound.getPitch());
				fsound.setTimesPlayed(fsound.getTimesPlayed() + 1);
				if(fsound.getTimesPlayed() < fsound.getCount())
					playLoop(fplayer, fsound);
			}
		}, sound.getDelay());
	}
	
	public static void playSound(Minigame minigame, MGSound sound){
		for(MinigamePlayer player : minigame.getPlayers())
			playSound(player, sound);
	}
	
	public static void playSound(Team team, MGSound sound){
		for(MinigamePlayer player : team.getPlayers())
			playSound(player, sound);
	}
}
