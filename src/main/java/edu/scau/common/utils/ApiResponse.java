package edu.scau.common.utils;


/**
 * 完整的响应对象
 *
 * @param <T>
 */
public class ApiResponse<T> {
    private int event;        // 返回码，0为成功
    private String msg;        // 返回信息
    private T obj;                // 单个对象
    private int currentPage;    // 当前页数
    private int pageSize;        // 每页显示数量
    private int maxCount;        // 总条数
    private int maxPage;        // 总页数
    public static String URL = "http://8.129.172.254:8080/";
    public ApiResponse() {
    }

    public ApiResponse(int event, String msg, T obj, int currentPage, int pageSize, int maxCount, int maxPage) {
        this.event = event;
        this.msg = msg;
        this.obj = obj;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.maxCount = maxCount;
        this.maxPage = maxPage;
    }

    // 构造函数，初始化code和msg
    public ApiResponse(int event, String msg) {
        this.event = event;
        this.msg = msg;
    }
    public ApiResponse(int event, String msg, T obj){
        this.event = event;
        this.msg = msg;
        this.obj = obj;
    }


    // 判断结果是否成功
    public boolean isSuccess() {
        return event == 0;
    }

    /**
     * @return the event
     */
    public int getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(int event) {
        this.event = event;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the obj
     */
    public T getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj) {
        this.obj = obj;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the maxCount
     */
    public int getMaxCount() {
        return maxCount;
    }

    /**
     * @param maxCount the maxCount to set
     */
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * @return the maxPage
     */
    public int getMaxPage() {
        return maxPage;
    }

    /**
     * @param maxPage the maxPage to set
     */
    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }
}
