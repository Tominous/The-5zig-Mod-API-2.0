package eu.the5zig.mod.server.api;

import java.awt.image.BufferedImage;

/**
 * Created by 5zig.
 * All rights reserved © 2015
 */
public interface StatsManager {

	/**
	 * Gets a Stat specified by its name.
	 *
	 * @param name The name of the stat.
	 * @return The Stat.
	 * @throws RuntimeException if you want to add more then 10 stat items.
	 */
	Stat getStat(String name);

	/**
	 * Resets a Stat of the Player specified by its name
	 *
	 * @param name The name of the stat.
	 */
	void resetStat(String name);

	/**
	 * Checks if the Stat already exists.
	 *
	 * @param name The name of the stat.
	 * @return If the Stat exists.
	 */
	boolean hasStat(String name);

	/**
	 * @return the amount of created stats.
	 */
	int getStatCount();

	/**
	 * Gets the Display Name of the Stat. The Display Name is shown as a 'Label' or Title for all following stats.
	 *
	 * @return The Display Name of the Stat.
	 */
	String getDisplayName();

	/**
	 * Sets the Display Name of the Stat. The Display Name is shown as a 'Label' or Title for all following stats.<br>
	 * Maximum length for the Display Name is 32 characters.
	 *
	 * @param displayName The new Display Name.
	 */
	void setDisplayName(String displayName);

	/**
	 * Sends a Large Text to the Client. The Text will be displayed like a Minecraft 1.8 Title, but it is a lot smaller, and therefore more text can be displayed.
	 * The Text will be also splitted into multiple lines by the client itself, if it is too long. The Large Text still cannot be longer than 250 characters.
	 * <p/>
	 * Use {@code \n} to force a new line. The client can render a maximum of 10 lines!
	 * <p/>
	 * You can only have one large text at the same time. Calling this method, of there is still a large text active will simply override it.
	 * <p/>
	 * Use {@link eu.the5zig.mod.server.api.StatsManager#resetLargeText()} to reset the Large Text.
	 *
	 * @param text The text that should be displayed.
	 */
	void sendLargeText(String text);

	/**
	 * Resets a Large Text if there is one.
	 */
	void resetLargeText();

	/**
	 * Sends an Image to the Mod User. The Image will be sent as Base64 encoded String.
	 * <p/>
	 * Max. image size is {@link Short#MAX_VALUE}. The image must be 64x64 pixels.
	 * <p/>
	 * This method should be called asynchronously.
	 *
	 * @param image The BufferedImage that should be sent.
	 */
	void sendImage(BufferedImage image);

	/**
	 * Sends an Image to the Mod User.
	 * The image needs to be already registered through {@link ImageRegistry#register(String, BufferedImage)}
	 * It is recommended to use this method over {@link #sendImage(BufferedImage image)}
	 * so that the server doesn't have to read the image from the hard drive every time and recalculate the Base64String.
	 * <p/>
	 *
	 * @param key The registered key of the image.
	 */
	void sendImage(String key);

	/**
	 * Removes the Image from the Mod User.
	 */
	void resetImage();

	/**
	 * Clears all stats. Does <b>not</b> reset the Large Text!
	 */
	void clearStats();

	/**
	 * Starts a large countdown for the player. Will be displayed in the middle of the screen.
	 * <b>Requires Protocol Version 2 of client!</b>
	 *
	 * @param name The display name of the countdown.
	 * @param ms   The time in milliseconds the countdown should last.
	 */
	void startCountdown(String name, long ms);

	/**
	 * Resets a countdown of the player.
	 */
	void resetCountdown();

	/**
	 * Sets the Server Lobby of the player. Will be displayed in the friends list of the mod as well.
	 *
	 * @param lobby the lobby of the player or {@code null} to reset.
	 */
	void setLobby(String lobby);

}
