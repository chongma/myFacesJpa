package com.test.myFacesJpa.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import javax.transaction.Transactional;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import com.test.myFacesJpa.dao.ItemDao;
import com.test.myFacesJpa.entities.Item;

@Named
@ViewScoped
public class ItemsBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ItemDao itemDao;

	private List<Item> items;
	private Item item;

	public String onload() {
		update();
		return null;
	}

	private void update() {
		setItems(itemDao.select());
	}

	@Transactional
	public String delete() {
		itemDao.delete(getItem());
		update();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deleted item", null));
		// FacesContext.getCurrentInstance().addMessage(null,
		// new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted item", null));
		return null;
	}

	@Transactional
	public String add() {
		itemDao.create();
		update();
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
