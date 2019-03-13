package com.example.yuekao.bean;

/**
 * @Author：贾天阳
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:22
 * @Description：描述信息
 */
public class Json1 {
    private String code;
    private Datas data;
    private String httpStatusCode;

    @Override
    public String toString() {
        return "Json1{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", httpStatusCode='" + httpStatusCode + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public Json1(String code, Datas data, String httpStatusCode) {

        this.code = code;
        this.data = data;
        this.httpStatusCode = httpStatusCode;
    }
}
