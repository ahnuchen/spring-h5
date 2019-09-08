package com.ccy.makaserver.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class TemplateUtils {
/*  public static void main(String[] args) {
    Context context = new Context();
    context.setVariable("world","world");
    boolean temp = process("temp", context, "E:/html/index.html");
    System.out.println(temp);

  }*/
  /**
   * 生成静态文件
   * @param freeTempName 模板名称
   * @param context 数据内容
   * @param outFilePath 输出路径
   * @return
   */
  public static boolean process(String freeTempName,Context context,String outFilePath){

    FileWriter fileWriter = null;
    try {
      ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
      resolver.setPrefix("templates/");//存放模板路径
      resolver.setSuffix(".html");//模板文件后缀名
      resolver.setCharacterEncoding("UTF-8");//设置字符集
      TemplateEngine templateEngine = new TemplateEngine();
      templateEngine.setTemplateResolver(resolver);
      fileWriter = new FileWriter(outFilePath);
      templateEngine.process(freeTempName, context,fileWriter);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    } finally {
      try {
        fileWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
    }
    return true;
  }



}
