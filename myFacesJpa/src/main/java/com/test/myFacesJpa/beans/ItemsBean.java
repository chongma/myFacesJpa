package com.test.myFacesJpa.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.test.myFacesJpa.entities.Item;

@Named
@ViewScoped
public class ItemsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Item> items;
	private Item item;
	private int counter;

	public String onload() {
		initialise();
		return null;
	}

	private void initialise() {
		items = new ArrayList<>();
	}

	public String deleteInfo() {
		items.remove(getItem());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted item", null));
		return null;
	}

	public String deleteError() {
		items.remove(getItem());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deleted item", null));
		return null;
	}

	public String add() {
		counter++;
		Item item = new Item();
		item.setId(counter);
		item.setName("ANOTHER ITEM");
		items.add(item);
		return null;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
