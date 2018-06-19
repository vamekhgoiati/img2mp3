package me.img2mp3.dao.impl;

import me.img2mp3.dao.ItemDao;
import me.img2mp3.entity.Item;
import me.img2mp3.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vamekhi
 *         17-06-2018
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    private ItemRepository itemRepository;

    @Autowired
    public ItemDaoImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getItem(String id) {
        return itemRepository.findById(id).orElse(new Item());
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
}
