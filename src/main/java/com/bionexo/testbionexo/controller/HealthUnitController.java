package com.bionexo.testbionexo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bionexo.testbionexo.model.HealthUnit;;

@RestController
@RequestMapping("/api/v1/find_ubs")
public class HealthUnitController {
	
	@GetMapping(params = { "page", "size"})
	public List<HealthUnit> find(@RequestParam("page") int page, 
			  @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
			  HttpServletResponse response) {
		
		Page<HealthUnit> resultPage = service.findPaginated(page, size);
	    if (page > resultPage.getTotalPages()) {
	        throw new MyResourceNotFoundException();
	    }
	    eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Foo>(
	      Foo.class, uriBuilder, response, page, resultPage.getTotalPages(), size));
	 
	    return resultPage.getContent();
		}
}
