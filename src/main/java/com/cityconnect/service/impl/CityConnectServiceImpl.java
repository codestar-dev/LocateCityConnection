package com.cityconnect.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cityconnect.model.CityRoute;
import com.cityconnect.service.CityConnectService;
import com.cityconnect.util.CityConnectUtil;

@Service
public class CityConnectServiceImpl implements CityConnectService{
	@Autowired
	CityConnectUtil util;

	@Override
	public boolean getCityConnection(String origin, String destination) {
		// TODO Auto-generated method stub
		List<CityRoute> routes = util.getCityRoutes();
		
		Set<String> visitedList = new HashSet();
		HashMap<String, List> adjacentList = new HashMap();
		LinkedList<String> queue = new LinkedList<String>();
		//Get Adjacent countries
		for (CityRoute route : routes) {
			if(adjacentList.get(route.getOrigin())!=null) {
				List<String> list = adjacentList.get(route.getOrigin());
				list.add(route.getDestination());
				adjacentList.put(route.getOrigin(), list);
			}else {
				List<String> list = new ArrayList();
				list.add(route.getDestination());
				adjacentList.put(route.getOrigin(), list);	
			}
			
		}
		System.out.println(adjacentList.toString());
		visitedList.add(origin);
		queue.add(origin);
		Iterator<String> itr;
	
		while(queue.size()!=0 && adjacentList.get(origin)!=null) {
			origin = queue.poll();
			String node;
			itr=adjacentList.get(origin).iterator();
			while(itr.hasNext()) {
				node= itr.next();
				if(node.equalsIgnoreCase(destination)) {
					return true;
				
				}
				
				if(visitedList.contains(node)) {
					visitedList.add(node);
					queue.add(node);
				}
			}
			
			
		}
		return false;
	}

}
