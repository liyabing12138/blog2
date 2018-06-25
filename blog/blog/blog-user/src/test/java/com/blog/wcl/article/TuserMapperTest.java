package com.blog.wcl.article;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.wcl.user.entity.Tusers;
import com.blog.wcl.user.mapper.TusersMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TuserMapperTest {

	     @Autowired
	    private TusersMapper tusersMapper;
	     @Test
	     public void findList() throws Exception {
	         List<Tusers> tcontents = tusersMapper.findList(new Tusers());
	         Tusers Tcontents2 = (Tusers) tusersMapper.getById(1);
	         System.out.println(Tcontents2.toString());
	     }
	
}
