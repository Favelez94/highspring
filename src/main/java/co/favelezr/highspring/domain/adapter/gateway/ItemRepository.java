package co.favelezr.highspring.domain.adapter.gateway;

import co.favelezr.highspring.domain.model.Item;

import java.util.List;

public interface ItemRepository {

    List<Item> findAll();
}
