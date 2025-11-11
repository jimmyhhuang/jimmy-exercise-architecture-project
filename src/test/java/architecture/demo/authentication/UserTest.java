package architecture.demo.authentication;

import architecture.demo.dao.domain.authentication.UserInfo;
import architecture.demo.dao.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
public class UserTest {

	@Autowired
	UserInfoMapper userInfoMapper;

	@Test
	public void test() {
		UserInfo userInfo = userInfoMapper.selectById("U001");
		assertNotNull(userInfoMapper);
		assertNotNull(userInfo);
		assertEquals("U001", userInfo.getUserId());
	}
}
