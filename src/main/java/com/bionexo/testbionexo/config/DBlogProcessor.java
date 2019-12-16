package com.bionexo.testbionexo.config;

import org.springframework.batch.item.ItemProcessor;

import com.bionexo.testbionexo.model.HealthUnit;

public class DBlogProcessor implements ItemProcessor<HealthUnit, HealthUnit> {
   
	public HealthUnit process(HealthUnit healthUnit) throws Exception{
      System.out.println("Inserting Hotels : " + healthUnit);
      return healthUnit;
   }
}
