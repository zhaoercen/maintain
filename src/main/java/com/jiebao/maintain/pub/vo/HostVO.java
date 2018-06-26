package com.jiebao.maintain.pub.vo;

public class HostVO {
	String ip;//agent机器的ip
	String port;
	Status state;
	String environment; //environment 环境


	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Status getState() {
		return state;
	}

	public void setState(Status state) {
		this.state = state;
	}

	public enum Status{
		STOPED,RUNNING,SUSPEED
	}
}
