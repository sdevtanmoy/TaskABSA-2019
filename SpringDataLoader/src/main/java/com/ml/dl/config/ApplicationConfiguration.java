/**
 * 
 */
package com.ml.dl.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ml.dl.service.DataHandlerService;
import com.ml.dl.vo.se2014.Sentences;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author TanmoyDas
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableSwagger2
public class ApplicationConfiguration implements CommandLineRunner{

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	
	
	@Autowired
	private DataHandlerService dataLoadservice;
	
	@Value("${se.data.2014.train.restaurants}")
	private String se2014TrainRestaurantsDataUrl;
	
	@Value("${se.data.2014.train.laptops}")
	private String se2014TrainLaptopsDataUrl;
	
	@Override
	public void run(String... args) throws Exception {
		
		List<String> se2014DataUrls = Arrays.asList(
				se2014TrainRestaurantsDataUrl,
				se2014TrainLaptopsDataUrl);
		for(String dataUrl : se2014DataUrls) {
			LOGGER.info("going to data load for data url %s ", dataUrl);
			try {
				Sentences sentences = this.dataLoadservice.getDataLoader(dataUrl, Sentences.class);
				if(null != sentences) {
					this.dataLoadservice.pushData(dataUrl, sentences.getSentences());
				}
			} catch (Exception e) {
				LOGGER.error(" error occured while fetching data for url %s - exception is - ", dataUrl, e.getMessage());
			}
		}
		
	}

	@Bean
	public Docket productApi() {
		return 
				new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("com.ml.dl.controller"))
				.paths(regex("/api/data/se.*"))
				.build()
		
				.tags(
						new Tag("SemEval2014", semEval2014), 
						new Tag("SemEval2015", semEval2015), 
						new Tag("SemEval2016", semEval2016)
					)
		 
		;
		
	}
	
	@Value("${swagger.tag.se.2014}")
	private String semEval2014;
	@Value("${swagger.tag.se.2015}")
	private String semEval2015;
	@Value("${swagger.tag.se.2016}")
	private String semEval2016;
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Sentiment Analysis Data Service End-Point Service API")
				.description("API details for Sentiment Analysis Data Services")
				.termsOfServiceUrl("https://en.wikipedia.org/wiki/SemEval")
				.contact(new Contact("SemEval", "https://en.wikipedia.org/wiki/SemEval", "semevaltweet@googlegroups.com"))
				.license("SemEval-2017")
				.licenseUrl("http://alt.qcri.org/semeval2014/task4/index.php?id=data-and-tools")
				.version("1.0").build();
	}

}
