package com.scu.algorithm;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class InsertToXml {
    public boolean createXml(String pathname){
        boolean b = false;
        Document document = DocumentHelper.createDocument();//创建document
        Element human=document.addElement("human");//添加根元素
        human.addComment("文档的根human已经创建。");//添加注释
        List<Person> al = new MySQLTest().getMm();
        Element person = human.addElement("person");
        for(Person temp : al){
            person.addElement("id").addText(String.valueOf(temp.getId()));
            person.addElement("name").addText(temp.getName());;
        }
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("gb2312");
            XMLWriter writer = new XMLWriter(new FileWriter(new File(pathname)),format);
            writer.write(document);
            writer.close();
            b=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
    public static void main(String[] args) {
        String pathname="C://Users//YWP//Desktop//centre.xml";
        InsertToXml insertToXml = new InsertToXml();
        insertToXml.createXml(pathname);
    }
}
