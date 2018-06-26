package com.jiebao.maintain.server.host.controller;

import com.jiebao.maintain.pub.vo.HostVO;
import com.jiebao.maintain.pub.vo.ResponseVO;
import com.jiebao.maintain.pub.vo.ResultVO;
import com.jiebao.maintain.server.host.service.RegisterServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "regist")
public class RegisterServerController {

	@Autowired
	RegisterServerService registerServerService;

	@RequestMapping(value = "clientRegist", method = RequestMethod.POST)
	public ResponseVO clientRegist(@RequestBody HostVO clientRegistInfo){
		ResponseVO response = new ResponseVO();

		ResultVO result = registerServerService.addNewClient(clientRegistInfo.getIp(), clientRegistInfo);
		if("SUCCESS".equalsIgnoreCase(result.getCode())){
			response.setCode(ResponseVO.ResponseCodes.SUCCESS);
		}else{
			response.setCode(ResponseVO.ResponseCodes.FAILED);
		}
		response.setMessage(result.getMessage());

		return response;
	}

	@RequestMapping(value = "clientOnline", method = RequestMethod.POST)
	public ResponseVO clientOnLine(@RequestBody Map<String, Object> param){
		ResponseVO response = new ResponseVO();
		String paramIp = ""+param.get("ip");
		if(paramIp == null || "".equalsIgnoreCase(paramIp)){
			response.set(ResponseVO.ResponseCodes.FAILED,"参数ip不能为空");
			return response;
		}
		ResultVO result = registerServerService.loadClientById(paramIp);

		if("SUCCESS".equalsIgnoreCase(result.getCode())){
			response.setCode(ResponseVO.ResponseCodes.SUCCESS);
		}else{
			response.setCode(ResponseVO.ResponseCodes.FAILED);
		}
		response.setMessage(result.getMessage());

		return response;
	}

	@RequestMapping(value = "clientOutline", method = RequestMethod.POST)
	public ResponseVO clientOutLine(@RequestBody Map<String, Object> param){
		ResponseVO response = new ResponseVO();
		String paramIp = ""+param.get("ip");
		if(paramIp == null || "".equalsIgnoreCase(paramIp)){
			response.set(ResponseVO.ResponseCodes.FAILED,"参数ip不能为空");
			return response;
		}

		ResultVO result = registerServerService.suspeedClientById(paramIp);
		if("SUCCESS".equalsIgnoreCase(result.getCode())){
			response.setCode(ResponseVO.ResponseCodes.SUCCESS);
		}else{
			response.setCode(ResponseVO.ResponseCodes.FAILED);
		}
		response.setMessage(result.getMessage());

		return response;
	}

	@RequestMapping(value = "allClientRegInfo", method = RequestMethod.POST)
	public ResponseVO allClientRegInfo(@RequestBody Map<String, Object> param){
		ResultVO result = registerServerService.getAllClients();
		return new ResponseVO(ResponseVO.ResponseCodes.SUCCESS,"获取所有客户机器信息成功",result.getData());
	}
}
