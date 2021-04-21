package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

@RestController
public class RepalController {
	@Autowired
	BoardService service;
	
	@GetMapping("/reply/test")
	public BoardVO restTest() {
		
		return service.get(120L);
	}
	@GetMapping("/reply/test2")
		public ResponseEntity <List<BoardVO>> restTest2(){
		Criteria cri = new Criteria();
		return new ResponseEntity<List<BoardVO>>(service.getList(cri),HttpStatus.OK);
	}
	@GetMapping("/reply/test/{pageNum}")
	public ResponseEntity <List<BoardVO>> restTest3(@PathVariable("pageNum") int pageNum){
		Criteria cri = new Criteria(pageNum,20);
		return new ResponseEntity<List<BoardVO>>(service.getList(cri),HttpStatus.OK);
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[]getPath(
			@PathVariable("cat") String cat, @PathVariable("pid") Integer pid
			){
		return new String[] {"category: " + cat, "productid: " +pid};
	}
}
