package pic;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @program: picLocal
 * @description:
 * @author: bin
 * @create: 2021-07-22 14:35
 **/
public class test {

    private final String defPath = "C:\\Users\\Administrator\\Desktop";

    @Test
    public void test() throws IOException {
        String fileName = "葫芦娃-" + System.currentTimeMillis();
        File file = new File(defPath, fileName);
        if (!file.exists()) file.mkdirs();
        URL url = new URL("https://mmbiz.qpic.cn/mmbiz_jpg/KqyAKRAIJMwLCjVD7uFcOqteuos9Vd8aNALHmEjFEDnGDUswArH10ceUg5Mdol6vQbYAEfJ5mqpzJl1LibbJ0xA/640");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream stream = conn.getInputStream();
        BufferedImage read = ImageIO.read(stream);
        File pFile = new File(file, 1 + ".jpg" );
        ImageIO.write(read, "jpg", pFile);
    }
}
