package com.pic.api;

import cn.hutool.core.img.Img;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @program: picLocal
 * @description:
 * @author: bin
 * @create: 2021-07-22 09:20
 **/
@RestController
public class Api {

    private Logger logger = LoggerFactory.getLogger(Api.class);

    private final String defPath = "C:\\Users\\Administrator\\Desktop";


    @PostMapping("downLocal")
    public ResponseEntity downLocal(@RequestParam("picSrc[]") List<String> picSrc) throws IOException {
        logger.info("pic num:{}", picSrc.size());
        String fileName = "bin-" + System.currentTimeMillis();
        File file = new File(defPath, fileName);
        if (!file.exists()) file.mkdirs();
        for (int i = 0; i < picSrc.size(); i++) {
            String s = picSrc.get(i);
            String[] split = s.split("\\?");
            try {
                String suffix = s.contains("jpg") ? "jpg" : "png";
                URL url = new URL(split[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                InputStream stream = conn.getInputStream();
                BufferedImage read = ImageIO.read(stream);
                File pFile = new File(file, i + "." + suffix);
                ImageIO.write(read, suffix, pFile);
                logger.info("pic:{},download local success,path:{}", s, pFile.getPath());
            } catch (Exception e) {
                logger.error("url:{}, error:{}", s, e);
            }
        }

        logger.info("now pic url download all end!");
        return null;
    }
}
