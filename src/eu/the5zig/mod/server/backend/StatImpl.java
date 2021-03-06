package eu.the5zig.mod.server.backend;

import eu.the5zig.mod.server.The5zigMod;
import eu.the5zig.mod.server.api.ModUser;
import eu.the5zig.mod.server.api.Stat;
import org.apache.commons.lang3.Validate;

public class StatImpl implements Stat {

	private ModUser modUser;
	private String name;
	private String score;

	public StatImpl(String name, ModUser modUser) {
		this.name = name;
		this.modUser = modUser;
	}

	@Override
	public String getScore() {
		return score;
	}

	@Override
	public void setScore(String score) {
		Validate.notNull(score, "Score cannot be null.");
		Validate.notEmpty(score, "Score cannot be empty.");
		Validate.validState(score.length() <= 100, "Length of score cannot exceed 100 characters.");

		this.score = score;
		The5zigMod.getInstance().getProtocolUtils().sendStat(modUser, this);
	}

	@Override
	public String getName() {
		return name;
	}
}
