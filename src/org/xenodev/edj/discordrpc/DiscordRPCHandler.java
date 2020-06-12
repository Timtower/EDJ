/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/27/2020 09:09
*/

package org.xenodev.edj.discordrpc;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class DiscordRPCHandler {
	
	private DiscordRPC lib;
	private DiscordRichPresence presence;
	
	/**
	 * This will create a new DiscordRPC object with your application id.
	 * <p>
	 * <b>NOTICE:</b> {@link #updateRPCImage(RPCImageType, Ship, String)} will not work with
	 * a custom rich presence application, please use {@link #DiscordRPCHandler()} to use the default
	 * DiscordRPC which supports {@link #updateRPCImage(RPCImageType, Ship, String)}.
	 * <p>
	 * To update the image on your own application look into {@link #updateRPCImage(RPCImageType, String, String)}.
	 * <p>
	 * @param appId the id of your custom application created at the <a href="https://discord.com/developers/applications">Discord Developer Portal</a>
	 * 
	 */
	public DiscordRPCHandler(String appId) {
		presence = new DiscordRichPresence();
		lib.Discord_Initialize(appId, new DiscordEventHandlers(), true, "");
		lib.Discord_UpdatePresence(presence);
		// in a worker thread
		new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				lib.Discord_RunCallbacks();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ignored) {}
			}
		}, "RPC-Callback-Handler").start();
	}
	
	/**
	 * This will create the default DiscordRPC which can use {@link #updateRPCImage(RPCImageType, Ship, String)}.
	 * 
	 */
	public DiscordRPCHandler() {
		lib = DiscordRPC.INSTANCE;
		String applicationId = "715123517821026334";
		String steamId = "";
		presence = new DiscordRichPresence();
		
		lib.Discord_Initialize(applicationId, new DiscordEventHandlers(), true, steamId);
		presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
		presence.details = "Just started";
		presence.state = "in Main Menu";
		lib.Discord_UpdatePresence(presence);
		// in a worker thread
		new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				lib.Discord_RunCallbacks();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ignored) {}
			}
		}, "RPC-Callback-Handler").start();
		
	}
	
	/**
	 * Update the default rich presence application with images from the application assets and a hover over message.
	 * <p>
	 * <img src="https://i.imgur.com/EyRldbG.png" width=200px height=200px /> <img src="https://i.imgur.com/Fh0fgWN.png" width=200px height=200px />
	 * <p>
	 * @param type Whether to set the image and message to the big or small slot.
	 * @param rpcImage The predefined image available from the default application.
	 * @param text The message shown when hovering over the image.
	 */
	public void updateRPCImage(RPCImageType type, RPCImage rpcImage, String text) {
		if(type == RPCImageType.SMALL) {
			presence.smallImageKey = rpcImage.name().toLowerCase().replace("_", "-");
			presence.smallImageText = text;
		}else {
			presence.largeImageKey = rpcImage.name().toLowerCase().replace("_", "-");
			presence.largeImageText = text;
		}
		
		lib.Discord_UpdatePresence(presence);
	}
	
	/**
	 * Update your rich presence application with images from the application assets and a hover over message.
	 * <p>
	 * <img src="https://i.imgur.com/EyRldbG.png" width=200px height=200px /> <img src="https://i.imgur.com/Fh0fgWN.png" width=200px height=200px />
	 * <p>
	 * @param type Whether to set the image and message to the big or small slot.
	 * @param imageKey A string key to find the image in the application assets.
	 * @param text The message shown when hovering over the image.
	 */
	public void updateRPCImage(RPCImageType type, String imageKey, String text) {
		if(type == RPCImageType.SMALL) {
			presence.smallImageKey = imageKey;
			presence.smallImageText = text;
		}else {
			presence.largeImageKey = imageKey;
			presence.largeImageText = text;
		}
		
		lib.Discord_UpdatePresence(presence);
	}
	
	/**
	 * Update the detail message of the rich presence.
	 * <p>
	 * <img src="https://i.imgur.com/EPM4ydj.png" width=200px height=200px />
	 * <p>
	 * @param text The message to set. 
	 */
	public void updateDetailText(String text) {
		presence.details = text;
		lib.Discord_UpdatePresence(presence);
	}
	
	/**
	 * Update the state message of the rich presence.
	 * <p>
	 * <img src="https://i.imgur.com/EPM4ydj.png" width=200px height=200px />
	 * <p>
	 * @param text The message to set. 
	 */
	public void updateStateText(String text) {
		presence.state = text;
		lib.Discord_UpdatePresence(presence);
	}

}
