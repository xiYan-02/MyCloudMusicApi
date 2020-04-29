package com.example.mycloudmusicapi.response;

public class Response<T> {

    public Response(T data) {
        this.data = data;
    }

    public Response() {
    }

    /**
     * 响应码
     *
     * 默认为0，表示成功
     */
    private int status;

    /**
     * 错误提示
     */
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 正式数据
     *
     * 详情接口：就是一个对象
     * 列表接口：是一个分页对象
     */
    private T data;

    /**
     * 请求成功时调用
     * @param data
     * @return
     */
    public static Response success(Object data){
        Response response = new Response(data);
        response.setCode(ResponseCode.SUCCESS);
        return response;
    }

    /**
     * 自定义异常的处理方法
     * @return
     */
    public static Response filaed(ResponseCode responseCode,String message){
        Response response = new Response(null);
        response.setCode(responseCode);
        response.setMessage(message);
        return response;
    }

    /**
     * 系统异常的处理方法
     * @return
     */
    public static Response filaed(ResponseCode responseCode){
        Response response = new Response(null);
        response.setCode(responseCode);
        return response;
    }


    private void setCode(ResponseCode responseCode){
        this.status = responseCode.code();
        this.message = responseCode.message();
    }

}
