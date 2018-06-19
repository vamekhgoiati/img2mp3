package me.img2mp3.service;

import me.img2mp3.model.ItemModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Vamekhi
 *         17-06-2018
 */
public interface ItemService {

    ItemModel getItem(String id);

    List<ItemModel> getAllItems();

    ItemModel saveItem(MultipartFile image) throws IOException;
}
