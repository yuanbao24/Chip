package com.qyb.card.util;/*
亲元宝 2020/2/12  14:01
/**
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 * .............................................
 *          写字楼里写字间，写字间里程序员；
 *          程序人员写程序，又拿程序换酒钱。
 *          酒醒只在网上坐，酒醉还来网下眠；
 *          酒醉酒醒日复日，网上网下年复年。
 *          但愿老死电脑间，不愿鞠躬老板前；
 *          奔驰宝马贵者趣，公交自行程序员。
 *          别人笑我忒疯癫，我笑自己命太贱；
 *          不见满街漂亮妹，哪个归得程序员？
 */

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QrcodeUtil {

    /**
     * @param msg 二维码的内容
     * @param width 二维码的大小
     * @return 矩阵对象 */
    public static BitMatrix createQrcode(String msg, int width){
        //创建缓存图片对象
        BufferedImage bufImg=null;
        //存储图片相关信息
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        //设置图片相关信息 比如 分辨率 边距 编码格式等
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.MARGIN, 1);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            //创建位图矩阵 参数说明：1、二维码 内容2、要生成的格式 3、宽 4、高 5、相关信息
            return new MultiFormatWriter().encode(msg,
                    BarcodeFormat.QR_CODE, width, width, hints);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 生成多彩二维码
     * @param content 二维码的内容
     * @param width 二维码的大小*/
    public static BufferedImage createColor(String content,int width){
        BitMatrix matrix = createQrcode(content, width);
        if(matrix!=null) {

            // 二维矩阵转为一维像素数组
            int halfW = matrix.getWidth() / 2;
            int halfH = matrix.getHeight() / 2;
            int[] pixels = new int[width * width];

            for (int y = 0; y < matrix.getHeight(); y++) {
                for (int x = 0; x < matrix.getWidth(); x++) {
                    // 二维码颜色（RGB）
                    int num1 = (int) (50 - (50.0 - 13.0) / matrix.getHeight()
                            * (y + 1));
                    int num2 = (int) (165 - (165.0 - 72.0) / matrix.getHeight()
                            * (y + 1));
                    int num3 = (int) (162 - (162.0 - 107.0)
                            / matrix.getHeight() * (y + 1));
                    Color color = new Color(num1, num2, num3);
                    int colorInt = color.getRGB();
                    // 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
                    pixels[y * width + x] = matrix.get(x, y) ? colorInt : 16777215;// 0x000000:0xffffff
                }
            }

            BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
            image.getRaster().setDataElements(0, 0, width, width, pixels);
            return image;
        }else {
            return null;
        }
    }
    /**
     * 实现二维码的生成*/
    public static void createQRcode(String msg,int width,String filePath) {
        //1、创建ZXing核心对象
        BitMatrix matrix = createQrcode(msg, width);
        if(matrix!=null) {
            //设置颜色 0 或1  黑白色
            MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
            //生成缓存图片
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(matrix, config);
            //3、生成二维码图片
            try {
                ImageIO.write(bufferedImage, "png", new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //测试二维码生成
    public static void main(String[] args) throws IOException {
        //createQRcode("起来吧",400,"qilaiba.png");
        BufferedImage image=createColor("醒醒吧，少年",600);
        ImageIO.write(image,"jpeg",new File("xxb.jpeg"));
    }
}
