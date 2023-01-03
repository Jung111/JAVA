package com.poseidon.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class IpGet {
// 클라이언트 ip 가져오기
	public String getUserIP(HttpServletRequest request) {
	String ip=request.getHeader("X-FORWARD-FOR");
	if (ip ==null) {
		ip = request.getHeader("Proxy-Client-IP");
	}
	if (ip == null) {
		ip = request.getHeader("WL-Proxy-Client-ip");
	}
	if (ip ==null) {
		ip = request.getHeader("HTTP_CLIENT_IP");
	}
	if (ip == null) {
		ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	}
	if (ip ==null) {
		ip = request.getRemoteAddr();
	}
		return ip;
	}
}
