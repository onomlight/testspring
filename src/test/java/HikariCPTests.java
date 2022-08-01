import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HikariCPTests {

	@Autowired
	private DataSource ds;
	
	@Test
	public void test() {
			try {
				Connection conn=ds.getConnection(); // db커넥션에 객체를 받아와서 출력하는
				log.info(conn);
				PreparedStatement pstmt = conn.prepareStatement("");
			} catch (SQLException e) {
				 
				log.error(e.getMessage());
			}
	}

}
