
package com.my.project.spring.wsdl2java;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>add complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="add"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="num1" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="num2" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "add", propOrder = {
    "num1",
    "num2"
})
public class Add {

    protected int num1;
    protected int num2;

    /**
     * 获取num1属性的值。
     * 
     */
    public int getNum1() {
        return num1;
    }

    /**
     * 设置num1属性的值。
     * 
     */
    public void setNum1(int value) {
        this.num1 = value;
    }

    /**
     * 获取num2属性的值。
     * 
     */
    public int getNum2() {
        return num2;
    }

    /**
     * 设置num2属性的值。
     * 
     */
    public void setNum2(int value) {
        this.num2 = value;
    }

}
