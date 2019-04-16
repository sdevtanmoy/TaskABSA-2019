/**
 * 
 */
package com.ml.dl.vo.se2014;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TanmoyDas
 *
 */
@XmlRootElement(name="sentence")
@XmlAccessorType (XmlAccessType.FIELD)
public class Sentence {

	@XmlAttribute
	private String id;
	
	private String text;
	
	@XmlElementWrapper(name = "aspectTerms") 
	@XmlElement(name = "aspectTerm")
	private List<AspectTerm> aspectTerms;
	
	@XmlElementWrapper(name = "aspectCategories")
	@XmlElement(name = "aspectCategory")
	private List<AspectCategory> aspectCategories;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<AspectTerm> getAspectTerms() {
		return aspectTerms;
	}

	public void setAspectTerms(List<AspectTerm> aspectTerms) {
		this.aspectTerms = aspectTerms;
	}

	public List<AspectCategory> getAspectCategories() {
		return aspectCategories;
	}

	public void setAspectCategories(List<AspectCategory> aspectCategories) {
		this.aspectCategories = aspectCategories;
	}

	@Override
	public String toString() {
		return "Sentence [id=" + id + ", text=" + text + ", aspectTerms=" + aspectTerms + ", aspectCategories="
				+ aspectCategories + "]";
	}
	
	
}
