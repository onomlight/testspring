import static org.junit.Assert.*;


import org.junit.Test;

import lombok.extern.log4j.Log4j;


@Log4j
public class logLevelTest {

	@Test
	public void test() {
		log.trace("traceTest");
		log.debug("DebugTest");
		log.info("info Test");
		log.warn("warn Test");
	}

}
