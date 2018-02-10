package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.common.vo.PageResult;
import com.taotao.search.pojo.Item;
import com.taotao.search.service.SearchService;

@Controller
public class SearchController {
	  @Autowired
	  private SearchService searchService;

	    private static final int ROWS = 32;
	    /**
	     * 搜索功能
	     * @param keyword 搜索的关键词
	     * @param page 页码
	     * @return
	     */
	    @RequestMapping(value = "search", method = RequestMethod.GET)
	    public ModelAndView search(@RequestParam("q") String keyword,
	            @RequestParam(value = "page", defaultValue = "1") Integer page) {
	        ModelAndView mv = new ModelAndView("search");
	        // 搜索获取分页结果
	        PageResult<Item> result = this.searchService.queryItemList(keyword, page, ROWS);
	        // 查询关键词
	        mv.addObject("query", keyword);

	        // 商品列表
	        mv.addObject("itemList", result.getData());

	        // 当前页
	        mv.addObject("page", page);
	      
	        // 总页数
	        int total = result.getTotal().intValue();
	        mv.addObject("pages", (total + ROWS - 1) / ROWS);
	        return mv;
	        
	    }

	
}
