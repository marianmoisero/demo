package demo.ws;

import java.util.logging.Logger;

import spark.Spark;

public class DemoRestWs {

	static final Logger LOGGER = Logger.getLogger("DemoRestWs");

	static final int WS_PORT = 9999;

	public static void runService() {
		Spark.port(WS_PORT);
		
		Spark.get("/health", (req, resp) -> {resp.header("Content-type", "text/plain");
		return "Spark server is up and running!";}); 
		
		Spark.awaitInitialization();
	}
}
