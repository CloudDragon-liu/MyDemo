package junit.test;

import java.util.Date;

import org.junit.Test;

import com.liuyunlong.dao.UserDao;
import com.liuyunlong.dao.impl.UserDaoImpl;
import com.liuyunlong.domain.User;

/** 
* @author  : liuyunlong
* @version ：2015年11月7日 上午11:48:07 
* */
public class TestDemo {

	@Test
	public void testAdd() {

		User user = new User();
		user.setUsername("liuyunlong2");
		user.setPassword("123456");
		user.setEmail("ggg@dd.com");
		user.setId(3);
		user.setNickname("4");
		user.setBirthday(new Date());

		UserDaoImpl daoImpl = new UserDaoImpl();
		daoImpl.add(user);

	}
}
