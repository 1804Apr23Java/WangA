package com.revature.dao;

import java.util.List;

import com.revature.beans.City;
import com.revature.beans.Comment;

public interface CityDao {
	
	public List<City> getCity();

    public Comment getCityId(int id);

    public int addCity(City c);

    public void updateCity(City c);

    public void deleteCity(City c);


}
