package com.example.restservice.model.response;

import com.example.restservice.model.data.Link;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkResponse {

	private String rel;
	private String href;
	
	public LinkResponse(@JsonProperty("link") Link link) {
		this.rel = link.getRel();
		this.href = link.getHref();
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
