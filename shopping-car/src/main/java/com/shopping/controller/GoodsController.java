package com.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.base.po.Result;
import com.shopping.entity.Goods;
import com.shopping.service.GoodsService;

@Controller
@RequestMapping("goods")
@CrossOrigin
public class GoodsController {
	private final String prefix = "shopping";
	@Autowired
	private GoodsService goodsService;
	 /**
		 * Using file.Transto to save uploaded files
	     */
    @RequestMapping("list")
    public String  listGoods(HttpServletRequest request,String name) throws IOException {
    	List<Goods> goodses = goodsService.listGoods(name);
    	request.setAttribute("goods", goodses);
        return prefix + "/goods";
    }
	
	/**
	 * Using file.Transto to save uploaded files
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public Result<String>  fileUpload2(HttpServletRequest request,
    		@RequestParam("file") CommonsMultipartFile file) throws IOException {
    	String appPath = request.getSession().getServletContext().getRealPath("/");
        long  startTime=System.currentTimeMillis();
        String suffix = "images/"+startTime+file.getOriginalFilename();
        String path=appPath+suffix;
        File newFile=new File(path);
        //using CommonsMultipartFile to write the file 
        file.transferTo(newFile);
        return Result.success(suffix, null); 
    }
    /**
     */
    @RequestMapping("add")
    public String  addGoods(Goods goods) throws IOException {
    	goodsService.addGoods(goods);
        return "redirect:list";
    }
    
}
