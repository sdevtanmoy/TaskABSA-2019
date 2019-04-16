/**
 * 
 */
package com.ml.dl.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ml.dl.vo.se2014.Sentence;

/**
 * @author TanmoyDas
 *
 */
@Service
public class DataHandlerService {

	private static Map<String, List<Sentence>> _cache_seData = new HashMap<String, List<Sentence>>();
	
	@SuppressWarnings("unchecked")
	public <T> T getDataLoader(final String resource, Class<?> outputClass) throws JAXBException{
		try {
		 
			InputStream is = TypeReference.class.getResourceAsStream(resource);
			JAXBContext jaxbContext = JAXBContext.newInstance(outputClass);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 
			@SuppressWarnings("deprecation")
			T bean = (T) outputClass.newInstance();
			
			bean = (T)jaxbUnmarshaller.unmarshal(is);
		 
			return bean;
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public <T>void pushData(final String key, final List<Sentence> data) {
		_cache_seData.put(key, data);
	}
	
	public List<Sentence> getSentencesByKey(final String key){
		
		if(null != key && _cache_seData.containsKey(key)) {
			return _cache_seData.get(key);
		}
		return null;
	}
}
