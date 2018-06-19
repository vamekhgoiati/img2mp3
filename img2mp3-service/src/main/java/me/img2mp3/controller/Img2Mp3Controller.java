package me.img2mp3.controller;

import me.img2mp3.model.ItemModel;
import me.img2mp3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Vamekhi
 *         17-06-2018
 */
@RestController
@RequestMapping("/img2mp3")
public class Img2Mp3Controller {

    private ItemService itemService;

    @Autowired
    public Img2Mp3Controller(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ResponseEntity<List<ItemModel>> getItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public ResponseEntity<ItemModel> getItem(@PathVariable("id") String id) {
        return new ResponseEntity<>(itemService.getItem(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ItemModel> saveItem(@RequestParam("image") MultipartFile image) throws IOException {
        return new ResponseEntity<>(itemService.saveItem(image), HttpStatus.OK);
    }
}
