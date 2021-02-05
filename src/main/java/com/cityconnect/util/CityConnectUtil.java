package com.cityconnect.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cityconnect.model.CityRoute;

@Component
public class CityConnectUtil {
	@Value("${route.path}")
	String path;
	public List<CityRoute> getCityRoutes(){
		BufferedReader br;
		 List<CityRoute> routelist = new ArrayList();
		try {
			br = new BufferedReader(new FileReader(path));
		
		String line;
        while ((line = br.readLine()) != null) 
        {
        	String[] arr = line.split(",");
           routelist.add(new CityRoute(arr[0].toLowerCase().strip(), arr[1].toLowerCase().strip()));
        }
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return routelist;
	}

}
