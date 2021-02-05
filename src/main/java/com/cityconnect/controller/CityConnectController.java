package com.cityconnect.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cityconnect.service.CityConnectService;

@RestController
public class CityConnectController {
@Autowired
CityConnectService service;

@GetMapping("connected")
public boolean getCityConnection(@RequestParam(value = "origin") String origin, @RequestParam(value = "destination") String destination) {

	boolean result = service.getCityConnection(origin, destination);
	return result;
}
	
}
