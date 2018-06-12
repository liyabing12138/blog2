package com.blog.wcl.consumer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.wcl.article.entity.Tmetas;
import com.blog.wcl.consumer.model.RestResponseBo;
import com.blog.wcl.consumer.service.TmetasServiceInterface;
import com.blog.wcl.consumer.util.Types;

@Controller
@RequestMapping("admin/category")
public class CategoryController {


	@Autowired
	private TmetasServiceInterface tmetasServiceInterface;
	
	
	/**
     * 分类页
     * @param request
     * @return
     */
    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
    	Tmetas tmetas1 = new Tmetas();
    	tmetas1.setType(Types.CATEGORY.getType());
    	Tmetas tmetas2 = new Tmetas();
    	tmetas2.setType(Types.TAG.getType());
        List<Tmetas> categories = tmetasServiceInterface.findList(tmetas1);
        List<Tmetas> tags = tmetasServiceInterface.findList(tmetas2);
        request.setAttribute("categories", categories);
        request.setAttribute("tags", tags);
        return "admin/category";
    }
	
	
    @PostMapping(value = "save")
    @ResponseBody
    public RestResponseBo saveCategory(@RequestParam String cname, @RequestParam Integer mid) {
        try {
        	Tmetas tmetas1 = new Tmetas();
        	tmetas1.setType(Types.CATEGORY.getType());
        	tmetas1.setName(cname);
        	tmetas1.setMid(mid);
        	tmetasServiceInterface.saveTmetas(tmetas1);
        } catch (Exception e) {
            String msg = "分类保存失败";
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    /**
     * 删除分类
     * @param mid
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam int mid) {
        try {
        	tmetasServiceInterface.delete(mid);
        } catch (Exception e) {
            String msg = "删除失败";
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }
	
	
}
