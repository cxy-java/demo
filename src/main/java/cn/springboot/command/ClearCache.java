package cn.springboot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

@Component
public class ClearCache implements CommandMarker{
	private Logger logger = LoggerFactory.getLogger(ClearCache.class);
	@CliAvailabilityIndicator({ "clearCache" })
	public boolean isSimpleAvailable() {
		// always available
		return true;
	}

	@CliCommand(value = "clearCache", help = "please enter cachename!")
	public String simple(
			@CliOption(key = { "name" }, mandatory = true, help = "cache name") final String name) {
		String message = "";
		if("codeMap".equals(name)){
			logger.info("clear codeMap========");
			message = "success";
		}else if("dataMap".equals(name)){
			logger.info("clear dataMap========");
			message = "success";
		}else{
			logger.info("not cache========");
			message = "not cache";
		}
		return "clear: " + message;
	}
}
