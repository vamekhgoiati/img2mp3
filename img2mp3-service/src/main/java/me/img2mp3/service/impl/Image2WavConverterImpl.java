package me.img2mp3.service.impl;

import me.img2mp3.annotation.Image2Wav;
import me.img2mp3.service.ConverterService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vamekhi
 *         17-06-2018
 */
@Service
@Image2Wav
public class Image2WavConverterImpl implements ConverterService {
    private static final Logger LOGGER = Logger.getLogger(Image2WavConverterImpl.class.getName());

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    @Override
    public byte[] convert(byte[] content) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(content)) {
            BufferedImage image = ImageIO.read(bais);
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int pixel = image.getRGB(j, i);
                    int r = ((pixel >> 16) & 0xFF);
                    int g = ((pixel >> 8) & 0xFF);
                    int b = (pixel & 0xFF);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        return new byte[0];
    }
}
