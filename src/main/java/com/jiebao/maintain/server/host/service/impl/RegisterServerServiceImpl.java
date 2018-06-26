package com.jiebao.maintain.server.host.service.impl;

import com.jiebao.maintain.pub.vo.HostVO;
import com.jiebao.maintain.pub.vo.ResultVO;
import com.jiebao.maintain.server.host.service.RegisterServerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterServerServiceImpl implements RegisterServerService {
	private Map<String,HostVO> clients = new HashMap<String,HostVO>();


	public Map<String, HostVO> getClients() {
		return clients;
	}

	private ResultVO setClients(Map<String, HostVO> clients) {
		this.clients = clients;
		return new ResultVO("SUCCESS","setClients SUCCESS");
	}

	/**
	 * 01
	 * @param ip
	 * @param client
	 * @return
	 */
	@Override
	public ResultVO addNewClient(String ip, HostVO client){
		if(ip == null || "".equalsIgnoreCase(ip)){
			return new ResultVO("ERROR","客户端ip不能为空");
		}
		if(client == null){
			return new ResultVO("ERROR","客户端信息不能为空");
		}
		if(this.clients.get(ip) == null){
			client.setState(HostVO.Status.STOPED);
			this.clients.put(ip, client);
			return new ResultVO("SUCCESS","addNewClients SUCCESS",client);
		}else{
			return new ResultVO("ERROR","客户端信息已经存在");
		}
	}

	/**
	 * 02
	 * @param ip
	 * @param client
	 * @return
	 */
	@Override
	public ResultVO resetClient(String ip, HostVO client){
		if(ip == null || "".equalsIgnoreCase(ip)){
			return new ResultVO("ERROR","客户端ip不能为空");
		}
		if(client == null){
			return new ResultVO("ERROR","客户端信息不能为空");
		}
		this.clients.put(ip, client);
		return new ResultVO("SUCCESS","resetClients SUCCESS",client);
	}

	@Override
	public ResultVO removeClientById(String ip) {
		if(ip == null || "".equalsIgnoreCase(ip)){
			return new ResultVO("ERROR","客户端ip不能为空");
		}
		HostVO client = this.clients.get(ip);
		if(client != null && client.getState() != HostVO.Status.STOPED){
			client.setState(HostVO.Status.STOPED);
			return new ResultVO("SUCCESS","removeClient SUCCESS",client);
		}else{
			if(client == null){
				return new ResultVO("WARN","客户端IP不存在");
			}else{
				return new ResultVO("WARN","客户端状态为"+client.getState());
			}
		}
	}

	@Override
	public ResultVO suspeedClientById(String ip) {
		if(ip == null || "".equalsIgnoreCase(ip)){
			return new ResultVO("ERROR","客户端ip不能为空");
		}
		HostVO client = this.clients.get(ip);
		client.setState(HostVO.Status.SUSPEED);
		return new ResultVO("SUCCESS","suspeedClient SUCCESS",client);
	}
	@Override
	public ResultVO loadClientById(String ip) {
		if(ip == null || "".equalsIgnoreCase(ip)){
			return new ResultVO("ERROR","客户端ip不能为空");
		}
		HostVO oldClient = this.clients.get(ip);
		if(oldClient == null){
			return new ResultVO("ERROR", "该客户端ip未注册");
		}
		oldClient.setState(HostVO.Status.RUNNING);

		return new ResultVO("SUCCESS", "", this.clients.get(ip));
	}
	@Override
	public ResultVO getClientById(String ip) {
		if(ip == null || "".equalsIgnoreCase(ip)){
			return new ResultVO("ERROR","客户端ip不能为空");
		}
		return new ResultVO("SUCCESS", "", this.clients.get(ip));
	}

	@Override
	public ResultVO getAllClients() {
		return new ResultVO("SUCCESS","getAllClients SUCCESS",this.clients);
	}


	@Override
	public ResultVO saveClients() {
		return new ResultVO("SUCCESS","reloadClients 还没实现");
	}

	@Override
	public ResultVO reloadALLClients() {
		return new ResultVO("SUCCESS","reloadClients 还没实现");
	}

}
