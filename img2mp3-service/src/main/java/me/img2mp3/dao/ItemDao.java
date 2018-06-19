package me.img2mp3.dao;

import me.img2mp3.entity.Item;

import java.util.List;

/**
 * @author Vamekhi
 *         17-06-2018
 */
public interface ItemDao {
    Item getItem(String id);
    List<Item> getAllItems();
    Item saveItem(Item item);

}
