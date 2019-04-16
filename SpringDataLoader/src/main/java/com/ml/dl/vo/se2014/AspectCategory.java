/**
 * 
 */
package com.ml.dl.vo.se2014;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author TanmoyDas
 *
 */
@XmlRootElement(name="aspectCategory")
@XmlAccessorType (XmlAccessType.FIELD)
public class AspectCategory {

	@XmlAttribute
	private String category;
	@XmlAttribute
	private String polarity;

	
	public AspectCategory() {
		// Auto-generated constructor stub
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPolarity() {
		return polarity;
	}

	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

	@Override
	public String toString() {
		return "AspectCategory [category=" + category + ", polarity=" + polarity + "]";
	}
	
	
}
