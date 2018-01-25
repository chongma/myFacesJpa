package com.test.myFacesJpa.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ItemsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public String onload() {
		return null;
	}
	
}
