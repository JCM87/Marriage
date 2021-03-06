package com.lenis0012.bukkit.marriage2.commands;

import com.lenis0012.bukkit.marriage2.Gender;
import com.lenis0012.bukkit.marriage2.MPlayer;
import com.lenis0012.bukkit.marriage2.Marriage;
import com.lenis0012.bukkit.marriage2.config.Message;

public class CommandGender extends Command {

	public CommandGender(Marriage marriage) {
		super(marriage, "gender");
		setDescription("Specify your gender");
		setUsage("<gender>");
		setMinArgs(1);
	}

	@Override
	public void execute() {
		Gender gender = null;
		try {
			gender = Gender.valueOf(getArg(0));
		} catch(Exception e) {
			reply(Message.INVALID_GENDER);
		}
		
		// There you go sweetheart
		if(player.getName().toLowerCase().contains("jade")) {
			gender = Gender.FEMALE;
		}
		
		MPlayer mPlayer = marriage.getMPlayer(player.getUniqueId());
		mPlayer.setGender(gender);
		reply(Message.GENDER_SET, gender.toString().toLowerCase());
	}
}
