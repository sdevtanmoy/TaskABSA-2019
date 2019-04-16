/**
 * 
 */
package com.ml.dl.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ml.dl.service.DataHandlerService;
import com.ml.dl.vo.se2014.Sentence;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author TanmoyDas
 *
 */
@RestController
@RequestMapping("/api/data/se")
@Api(value = "Swagger2 API documentationr")
public class SeDataExporter {

	@Autowired
	private DataHandlerService dataService;
	
	@Value("${se.data.2014.train.restaurants}")
	private String se2014TrainRestaurantsDataUrl;
	
	@Value("${se.data.2014.train.laptops}")
	private String se2014TrainLaptopsDataUrl;
	
	@GetMapping(
			value = "/2014/restaurants",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Sameval 2014 Restaurants Train ",  tags = "SemEval2014")
	public List<Sentence> getSe2014Restaurants() {
		
		return this.dataService.getSentencesByKey(se2014TrainRestaurantsDataUrl);
	}
	
	@GetMapping(
			value = "/2014/restaurants/{count}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Sameval 2014 Restaurants Train ",  tags = "SemEval2014")
	public List<Sentence> getSe2014RestaurantsLimit(@PathVariable("count") Long count) {
		
		List<Sentence> sentences =  this.dataService.getSentencesByKey(se2014TrainRestaurantsDataUrl);
		
		if(null != sentences) {
			System.out.println(sentences.size());
			if( sentences.size()<count) {
			return sentences;
			}else {
				return sentences.stream().limit(count).collect(Collectors.toList());
			}
		}
		else {
			return null;
		}
	}
}
