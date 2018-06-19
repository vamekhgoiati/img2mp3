package me.img2mp3.service.impl;

import me.img2mp3.annotation.Image2Wav;
import me.img2mp3.annotation.Wav2Mp3;
import me.img2mp3.service.ConverterService;
import me.img2mp3.service.ImageService;
import org.springframework.stereotype.Service;

/**
 * @author Vamekhi
 *         17-06-2018
 */
@Service
public class ImageServiceImpl implements ImageService {

    private ConverterService image2wavConverter;
    private ConverterService wav2Mp3Converter;

    public ImageServiceImpl(@Image2Wav ConverterService image2wavConverter, @Wav2Mp3 ConverterService wav2Mp3Converter) {
        this.image2wavConverter = image2wavConverter;
        this.wav2Mp3Converter = wav2Mp3Converter;
    }

    @Override
    public byte[] convertImageToMp3(byte[] bytes) {
        byte[] wav = image2wavConverter.convert(bytes);
        byte[] mp3 = wav2Mp3Converter.convert(bytes);
        return mp3;
    }
}
