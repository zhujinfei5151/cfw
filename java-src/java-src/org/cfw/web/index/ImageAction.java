package org.cfw.web.index;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.cfw.common.util.ImageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageAction {

    private InputStream imageStream;

    public InputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(InputStream imageStream) {
        this.imageStream = imageStream;
    }

    public String execute() {
        Map<String, BufferedImage> map = ImageUtil.getImage();
        // 获取验证图片上的字符，保存到session
        String key = map.keySet().iterator().next();
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("code", key);
        // 获取验证图片，以stream方式响应
        BufferedImage image = map.get(key);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(bos);
        try {
            jpeg.encode(image);
            byte[] bts = bos.toByteArray();
            imageStream = new ByteArrayInputStream(bts);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
