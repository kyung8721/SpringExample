package com.kyung.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyung.spring.ex.database.domain.UsedGoods;
import com.kyung.spring.ex.database.service.UsedGoodsService;

//request와 response 처리 담당
@Controller
public class UsedGoodsController {

	// 객체 관리를 스프링에 위임
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	
	@RequestMapping("/db/usedGoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		//테이블을 조회한 결과는 response에 저장
		//중고물품 게시글 리스트 얻어오기
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		return usedGoodsList;
		
	}
}
