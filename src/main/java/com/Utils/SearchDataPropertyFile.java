package com.Utils;

import com.Controllers.MainController;

public class SearchDataPropertyFile extends MainController{
	private String actualTitle = PropertyFileReader.propertiesReader(searchData, "actualTitle");

	public String getactualTitle() {

		return actualTitle;
	}

}
