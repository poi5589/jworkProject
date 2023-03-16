package com.mj.jwork.employee.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mj.jwork.common.model.vo.PageInfo;
import com.mj.jwork.employee.model.vo.Department;
import com.mj.jwork.employee.model.vo.Employee;
import com.mj.jwork.employee.model.vo.Team;

@Repository
public class EmployeeDao {

	// 로그인
	public Employee loginEmployee(SqlSessionTemplate sqlSession, Employee e) {
		return sqlSession.selectOne("employeeMapper.loginEmployee", e);
	}
	
	// 사원 정보 수정
	public int updateEmployee(SqlSessionTemplate sqlSession, Employee e) {
		return sqlSession.update("employeeMapper.updateEmployee", e);
	}
	
	// 사원 프로필 이미지 수정
	public int updateProfileImg(SqlSessionTemplate sqlSession, Employee e) {
		return sqlSession.update("employeeMapper.updateProfileImg", e);
	}

	//결재선 선택시 사원조회리스트(ajax)
	public ArrayList<Employee> ajaxSelectEmpList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("employeeMapper.ajaxSelectEmpList");
	}
	public ArrayList<Department> ajaxSelectDeptList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("employeeMapper.ajaxSelectDeptList");
	}
	public ArrayList<Team> ajaxSelectTeamList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("employeeMapper.ajaxSelectTeamList");
	}

	// 사내 주소록 리스트 조회
	public int selectAddressInListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("employeeMapper.selectAddressInListCount");
	}
	public ArrayList<Employee> selectAddressInList(SqlSessionTemplate sqlSession, int empNo, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("employeeMapper.selectAddressInList", empNo , rowBounds);
	}
	
	// 개인 주소록 리스트 조회
	public int selectAddressOutListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("employeeMapper.selectAddressOutListCount");
	}

	public ArrayList<Employee> selectAddressOutList(SqlSessionTemplate sqlSession, int empNo, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("employeeMapper.selectAddressOutList", empNo , rowBounds);
	}

	// 사내 주소록 상세 조회 페이지(ajax)
	public Employee ajaxSelectAddressEmployee(SqlSessionTemplate sqlSession, Employee e) {
		return sqlSession.selectOne("employeeMapper.ajaxSelectAddressEmployee", e);
	}
	
	// 메일 사원번호 입력시 사원조회 서비스 (ajax)
	public Employee selectEmployee(SqlSessionTemplate sqlSession, int empNo) {
		return sqlSession.selectOne("employeeMapper.selectEmployee", empNo);
	}

	

	


}
