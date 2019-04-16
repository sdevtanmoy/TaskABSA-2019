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
@XmlRootElement(name="aspectTerm")
@XmlAccessorType (XmlAccessType.FIELD)
public class AspectTerm {

	@XmlAttribute
	private String term;
	@XmlAttribute
	private String polarity;
	@XmlAttribute
	private int from;
	@XmlAttribute
	private int to;
	
	
	public AspectTerm() {
		// Auto-generated constructor stub
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getPolarity() {
		return polarity;
	}

	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "AspectTerm [term=" + term + ", polarity=" + polarity + ", from=" + from + ", to=" + to + "]";
	}
	
	
}
