package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.SessionDto;
import dto.Users;
import mybatis.SqlSessionBean;

public class UsersDao {
	private static UsersDao dao = new UsersDao();
	private UsersDao() {}
	public static UsersDao getInstance() {
		return dao;
	}
	SqlSessionFactory sqlFactory = SqlSessionBean.getSessionFactory();
	
	public SessionDto login(Map<String, String> map) {
		SessionDto dto = null;
		SqlSession mapper = sqlFactory.openSession();
		dto = mapper.selectOne("users.loginCheck", map);
		mapper.close();
		return dto;
	}
	
	public void regist(Users dto) {
		SqlSession mapper = sqlFactory.openSession();
		mapper.insert("users.regist", dto);
		mapper.commit();
		mapper.close();
	}
	
	public Users userInfo(String id) { //로그인한 유저정보 받기
		SqlSession mapper = sqlFactory.openSession();
		Users dto = mapper.selectOne("users.loginUserInfo", id);
		mapper.commit();
		mapper.close();
		return dto;
	}
	
	
}