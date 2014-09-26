package mytest.spring.model;

import org.hibernate.validator.constraints.NotEmpty;


public class SearchForm {
	
	@NotEmpty
	private String textToSearch;

	public String getTextToSearch() {
		return textToSearch;
	}

	public void setTextToSearch(String textToSearch) {
		this.textToSearch = textToSearch;
	}

	
	
	
	
	
	
	
}


