package com.cyx.java_web.web_03_CRUD.web.servlet.login;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@WebServlet("/verificationCode")
public class verificationCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 6823159840774799239L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取随机生成的 UUID，并转换成 String 类型，再截取前 4 位字符用来做验证码
        String verificationCode = UUID.randomUUID().toString().substring(0, 4);
        // 将生成的验证码放入 Session 中，用来验证与用户填写的是否一致
        req.getSession().setAttribute("VERIFICATION_CODE_IN_SESSION", verificationCode);

        // 创建图片对象
        int width = 80;                                  // 所创造图像宽度
        int height = 40;                                 // 所创造图像高度
        int imageType = BufferedImage.TYPE_INT_RGB;      // 所创造图像的类型
        BufferedImage image = new BufferedImage(width, height, imageType);

        // 获取画板
        Graphics graphics = image.createGraphics();
        // 设置背景色
        graphics.setColor(Color.CYAN);
        // 填充指定的矩形
        graphics.fillRect(1, 1, width - 2, height - 2);


        // 设置随机数颜色
        graphics.setColor(Color.RED);
        // 设置字体样式 Font(String name, int style, int size)
        Font font = new Font("宋体", Font.BOLD + Font.ITALIC, 20);
        // 将此图形上下文的字体设置为指定字体
        graphics.setFont(font);
        // 在图形指定坐标绘制指定文字
        graphics.drawString(verificationCode, 10, 28);
        // 干扰线
        graphics.setColor(Color.GRAY);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            graphics.fillRect(random.nextInt(width), random.nextInt(height), 2, 2);
        }

        // 关闭（释放资源）
        graphics.dispose();
        // 把图片资源以流的方式保存出去
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
}