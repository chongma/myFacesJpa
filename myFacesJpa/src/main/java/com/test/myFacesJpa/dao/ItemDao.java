package com.test.myFacesJpa.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.test.myFacesJpa.entities.Item;

@ApplicationScoped
public class ItemDao {

	@Inject
	private EntityManager em;

	public List<Item> select() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Item> cq = cb.createQuery(Item.class);
		Root<Item> item = cq.from(Item.class);
		cq.select(item);
		cq.distinct(true);
		TypedQuery<Item> query = em.createQuery(cq);
		List<Item> itemList = query.getResultList();
		return itemList;
	}

	public void delete(Item item) {
		item = em.find(Item.class, item.getId());
		em.remove(item);
	}

	public Item create() {
		Item item = new Item();
		item.setName("Another item");
		em.persist(item);
		return item;
	}

}
