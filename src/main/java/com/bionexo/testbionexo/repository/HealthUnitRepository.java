package com.bionexo.testbionexo.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.List;

import com.bionexo.testbionexo.model.Geocode;
import com.bionexo.testbionexo.model.HealthUnit;
import com.bionexo.testbionexo.model.Score;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class HealthUnitRepository  {
	private static final Map<Integer, HealthUnit> MAP_HEALTHUNIT_DB = new HashMap<Integer, HealthUnit>();
	
	public HealthUnit findHealthUnit(Integer id) {
		return MAP_HEALTHUNIT_DB.get(id);
	}
	
	
	public void readCsvFile(String csvFile) throws JsonGenerationException, JsonMappingException, IOException {
		
		Pattern pattern = Pattern.compile(",");
		try (BufferedReader in = new BufferedReader(new FileReader(csvFile));) {
			List<HealthUnit> healthUnitList = in.lines().skip(1).map(line -> {
		        String[] x = pattern.split(line);
		        Geocode geocode = new Geocode(Double.parseDouble(x[0]), Double.parseDouble(x[1]));
		        Score score = new Score(x[9], x[10], x[11], x[12]);
		        HealthUnit healthUnit = new HealthUnit(Integer.parseInt(x[3]), x[4], x[5] + ", " + x[6], x[7], x[8], score, geocode);
		        MAP_HEALTHUNIT_DB.put(Integer.parseInt(x[3]), healthUnit);
		        return healthUnit;
		    }).collect(Collectors.toList());			
		}
	}
}

