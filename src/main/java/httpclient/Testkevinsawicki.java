package httpclient;


import com.github.kevinsawicki.http.HttpRequest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 测试框架kevinsawicki
 * @author: Ding Yawu
 * @create: 2022/1/22 13:22
 */
public class Testkevinsawicki {


  /**
   * 发送一个Get请求获取响应报文
   */
  public static void test1(){
      HttpRequest httpRequest = HttpRequest.get("http://www.baidu.com");
      httpRequest.receive(System.out);

      String response = HttpRequest.get("http://www.baidu.com").body();
      System.out.println("Response was: "+response);
      int code = HttpRequest.get("http://www.baidu.com").code();
      System.out.println(code);
  }


    /**
     * 发送一个带查询参数的Get请求获取响应报文
     * print result:GET http://www.baidu.com?q=baseball%20gloves&size=100
     */
    public static void test2(){
        HttpRequest request = HttpRequest.get("http://www.baidu.com",true,'q',"baseball gloves","size",100);
        System.out.println(request.toString());
    }


    /**
     * 发送一个带查询参数的Get请求获取响应报文
     * 实现功能同test2
     *
     */
    public static void test3(){
        Map data = new HashMap();
        data.put("q", "baseball gloves");
        data.put("size", "100");
        HttpRequest request = HttpRequest.get("http://www.baidu.com").form(data);
        String resp =request.body();
        System.out.println("---------------response parameter:" + resp);
    }


    /**
     * 常用http请求配置
     *
     * */
    public static void test4() {
        HttpRequest request = HttpRequest.get("https://google.com");
        //信任所有证书
        request.trustAllCerts();
        //信任所有地址
        request.trustAllHosts();
        //设置请求超时时间
        request.connectTimeout(60000);
        //设置读取超时时间
        request.readTimeout(60000);
    }

    /**
     * 设置支持Builder模式
     *
     */
    public static void test5() {
        Map data = new HashMap();
        data.put("q", "baseball gloves");
        data.put("size", "100");
        String resp = HttpRequest.post("http://www.baidu.com").trustAllCerts().trustAllHosts()
                .form(data)
                .connectTimeout(60000)
                .readTimeout(60000)
                .body();
        System.out.println(resp);
    }

    public static void test6() {

    }

    public static void main(String[] args) {
        test6();
    }
}
