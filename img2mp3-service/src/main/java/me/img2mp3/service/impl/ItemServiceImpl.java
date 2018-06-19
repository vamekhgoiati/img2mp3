package me.img2mp3.service.impl;

import me.img2mp3.dao.ItemDao;
import me.img2mp3.entity.Item;
import me.img2mp3.model.ItemModel;
import me.img2mp3.service.ImageService;
import me.img2mp3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vamekhi
 *         17-06-2018
 */
@Service
public class ItemServiceImpl implements ItemService {

    private ImageService imageService;
    private ItemDao itemDao;

    @Autowired
    public ItemServiceImpl(ItemDao itemDao, ImageService imageService) {
        this.itemDao = itemDao;
        this.imageService = imageService;
    }

    @Override
    public ItemModel getItem(String id) {
        return itemToItemModel(itemDao.getItem(id));
    }

    @Override
    public List<ItemModel> getAllItems() {
        return itemDao.getAllItems().stream().map(this::itemToItemModel).collect(Collectors.toList());
    }

    @Override
    public ItemModel saveItem(MultipartFile image) throws IOException {
        Item item = new Item();
        item.setImage(image.getBytes());
        item.setMp3(imageService.convertImageToMp3(image.getBytes()));
        return itemToItemModel(itemDao.saveItem(item));
    }

    private ItemModel itemToItemModel(Item item) {
        ItemModel itemModel = new ItemModel();
        itemModel.setId(item.getId());
        itemModel.setImage(Base64Utils.encodeToString(item.getImage()));
        itemModel.setMp3(Base64Utils.encodeToString(item.getMp3()));
        return itemModel;
    }
}
