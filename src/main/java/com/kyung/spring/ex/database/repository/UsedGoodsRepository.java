package com.kyung.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.spring.ex.database.domain.UsedGoods;

// 데이터베이스 관련 처리
// 쿼리 수행
@Mapper
public interface UsedGoodsRepository {

	
	//usedGoods 모든 행 조회
	public List<UsedGoods> selectUsedGoodsList();// 인터페이스기 때문에 여기서는 구현x 구현은 xml로.
}
