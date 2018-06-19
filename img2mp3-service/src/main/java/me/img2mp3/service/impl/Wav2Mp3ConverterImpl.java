package me.img2mp3.service.impl;

import me.img2mp3.annotation.Wav2Mp3;
import me.img2mp3.service.ConverterService;
import org.springframework.stereotype.Service;

/**
 * @author Vamekhi
 *         17-06-2018
 */
@Service
@Wav2Mp3
public class Wav2Mp3ConverterImpl implements ConverterService {
    @Override
    public byte[] convert(byte[] content) {
        return new byte[0];
    }
}
