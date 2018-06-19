package me.img2mp3.entity;

import org.springframework.data.annotation.Id;

/**
 * @author Vamekhi
 *         17-06-2018
 */
public class Item {

    @Id
    String id;
    private byte[] image;
    private byte[] mp3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getMp3() {
        return mp3;
    }

    public void setMp3(byte[] mp3) {
        this.mp3 = mp3;
    }
}
