package me.img2mp3.repo;

import me.img2mp3.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Vamekhi
 *         17-06-2018
 */
public interface ItemRepository extends MongoRepository<Item, String> {
}
