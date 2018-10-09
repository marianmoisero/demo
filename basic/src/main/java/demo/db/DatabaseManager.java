package demo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.h2.jdbcx.JdbcConnectionPool;

public class DatabaseManager {

	static final Logger LOGGER = Logger.getLogger("DatabaseManager");

	public static DatabaseManager INSTANCE = new DatabaseManager();

	static final String QUERY_ALL = "SELECT * FROM ";

	JdbcConnectionPool connPool;

	private DatabaseManager() {
		connPool = JdbcConnectionPool.create("jdbc:h2:~/test", "sa", "");
	}

	Connection getConnection() throws SQLException {
		return connPool.getConnection();
	}

	void getAllRecs() {
		try (Connection conn = getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(QUERY_ALL)) {
			stmt.executeQuery();
//			stmt.execute()
//			conn.commit();
		} catch (Exception e) {
			LOGGER.severe("Error when getting all recs " + e.getMessage());
		}
	}
}
