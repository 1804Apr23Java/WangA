package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City implements Serializable {

	public City(int city_Id, String cityName, String citydesc, Commenter commenter) {
		super();
		this.city_Id = city_Id;
		this.cityName = cityName;
		this.citydesc = citydesc;
		this.commenter = commenter;
	}

	public City(String cityName, String citydesc, Commenter commenter) {
		super();
		this.cityName = cityName;
		this.citydesc = citydesc;
		this.commenter = commenter;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5958414847285356413L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citySequence")
	@SequenceGenerator(allocationSize = 1, name = "citiesSequence", sequenceName = "SQ_CITY_PK")
	@Column(name = "CITY_ID")
	private int city_Id;

	@Column(name = "CITYNAME")
	private String cityName;

	@Column(name = "CITYDESC")
	private String citydesc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMMENTER_ID")
	private Commenter commenter;

	public int getCity_Id() {
		return city_Id;
	}

	public void setCity_Id(int city_Id) {
		this.city_Id = city_Id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCitydesc() {
		return citydesc;
	}

	public void setCitydesc(String citydesc) {
		this.citydesc = citydesc;
	}

	public Commenter getCommenter() {
		return commenter;
	}

	public void setCommenter(Commenter commenter) {
		this.commenter = commenter;
	}

	@Override
	public String toString() {
		return "Cities [city_Id=" + city_Id + ", cityName=" + cityName + ", citydesc=" + citydesc + ", commenter="
				+ commenter + "]";
	}
	

}
