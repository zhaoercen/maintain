package com.jiebao.maintain.client.register.controller;

import com.jiebao.maintain.pub.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationHome;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping(value = "regist")
public class RegisterClientController {

	@Value("${server.port}")
	private int port;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	@GetMapping("/ohye")
	public ResponseVO registToServer(String opType){
		RestTemplate client = restTemplateBuilder.build();
		String url = "http://127.0.0.1:8080/regist/clientRegist";
		HashMap params = new HashMap();
		params.put("ip", "888"+new Date());
		params.put("port", port);
		params.put("type", "888");
		ResponseVO result = client.postForObject(url,params,ResponseVO.class);
		return result;
	}


}
