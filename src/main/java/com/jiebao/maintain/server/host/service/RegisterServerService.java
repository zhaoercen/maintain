package com.jiebao.maintain.server.host.service;

import com.jiebao.maintain.pub.vo.HostVO;
import com.jiebao.maintain.pub.vo.ResultVO;

public interface RegisterServerService {
	public ResultVO addNewClient(String ip, HostVO client);
	public ResultVO resetClient(String ip, HostVO client);
	public ResultVO removeClientById(String ip);
	public ResultVO suspeedClientById(String ip);
	public ResultVO loadClientById(String ip);
	public ResultVO getClientById(String ip);
	public ResultVO getAllClients();
	public ResultVO reloadALLClients();
	public ResultVO saveClients();
}
