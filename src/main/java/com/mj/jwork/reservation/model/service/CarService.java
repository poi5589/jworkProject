package com.mj.jwork.reservation.model.service;

import java.util.ArrayList;

import com.mj.jwork.common.model.vo.PageInfo;
import com.mj.jwork.reservation.model.vo.Car;

public interface CarService {
	
	
	//차량 등록 
	int insertCar(Car c);
	
	//리스트 조회(차량관리페이지)
	int selectListCount();
	ArrayList<Car> selectList(PageInfo pi);
	
	
	//차량삭제
	int deleteCar(String carName);
	
	//차량상세조회 (1개)
	Car selectCar(String carName);
	
	//차량이름조회
	ArrayList<Car> selectNList();
	
	//차량정보 업데이트
	int updateCar(Car c);
}
