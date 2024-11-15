package com.xuecheng;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class PdfCompressor {

    public static void compressPdf(String inputPath, String outputPath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(inputPath))) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            PDDocument compressedDocument = new PDDocument();

            for (int i = 0; i < document.getNumberOfPages(); i++) {
                // 渲染页面为低DPI图像
                BufferedImage image = pdfRenderer.renderImageWithDPI(i, 72); // 72 DPI降低了质量
                PDPage page = new PDPage();
                compressedDocument.addPage(page);

                // 创建图像对象
                PDImageXObject pdImage = PDImageXObject.createFromByteArray(compressedDocument, toByteArray(image, "JPEG"), "JPEG");

                // 创建内容流，将图像添加到新页面
                try (PDPageContentStream contentStream = new PDPageContentStream(compressedDocument, page)) {
                    contentStream.drawImage(pdImage, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
                }
            }

            compressedDocument.save(outputPath);
            compressedDocument.close();
        }
    }

    private static byte[] toByteArray(BufferedImage image, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, format, baos);
        return baos.toByteArray();
    }

    public static void main(String[] args) {

        // 设置输入文件和输出文件路径
        String inputPath = "";
        String outputPath = "";


        try {
            compressPdf(inputPath, outputPath);
            System.out.println("PDF压缩完成！文件保存为：" + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
