package org.xenodev.edj;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class DiscordRP {
	
	private DiscordRPC lib;
	private DiscordRichPresence presence;
	
	public DiscordRP() {
		lib = DiscordRPC.INSTANCE;
        String applicationId = "553621944881381376";
        String steamId = "359320";
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        lib.Discord_Initialize(applicationId, handlers, true, steamId);
        presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        presence.details = "Starting game...";
        presence.state = "Main Menu";
        presence.smallImageKey = "";
        presence.smallImageText = "";
        presence.largeImageKey = "edlogo";
        presence.largeImageText = "";
        lib.Discord_UpdatePresence(presence);
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();
    }
	
	public void update(String smallImageKey, String smallImageText, String largeImageKey, String largeImageText, String details, String state) {
        presence.smallImageKey = smallImageKey;
        presence.smallImageText = smallImageText;
        presence.largeImageKey = largeImageKey;
        presence.largeImageText = largeImageText;
        presence.details = details;
        presence.state = state;
        lib.Discord_UpdatePresence(presence);
	}

}
