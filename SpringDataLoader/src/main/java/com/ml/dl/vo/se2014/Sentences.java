/**
 * 
 */
package com.ml.dl.vo.se2014;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TanmoyDas
 *
 */
@XmlRootElement(name = "sentences")
@XmlAccessorType (XmlAccessType.FIELD)
public class Sentences {
	
	@XmlElement(name = "sentence")
	private List<Sentence> sentences;

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}
	
	

}
