package com.mj.jwork.reservation.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.jwork.common.model.vo.PageInfo;
import com.mj.jwork.reservation.model.dao.CfrDao;
import com.mj.jwork.reservation.model.vo.CfRoom;

@Service
public class CfrServiceImpl implements CfrService{

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Autowired
	private CfrDao cDao;
	
	@Override
	public int enrollCfr(CfRoom cfr) {
		return 0;
	}

	@Override
	public int selectListCount() {
		return 0;
	}

	@Override
	public ArrayList<CfRoom> selectList(PageInfo pi) {
		return null;
	}
	
	

}