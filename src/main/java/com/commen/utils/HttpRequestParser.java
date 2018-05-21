package com.commen.utils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.*;

/**
 * HttpRequestParser工具类
 * @author yy
 */
public class HttpRequestParser {
    /**
     * 分析url字符串,采用utf-8解码
     * @param urlString
     * @return
     */
    public static Request parse(String urlString) {
        return parse(urlString, "utf-8");
    }

    /**
     * 分析url字符串,指定字符集进行解码
     * @param urlString
     * @param enc
     * @return
     */
    public static Request parse(String urlString, String enc) {
        if (urlString == null || urlString.length() == 0) {
            return new Request();
        }
        int questIndex = urlString.indexOf('?');
        if (questIndex == -1) {
            return new Request(urlString);
        }
        String url = urlString.substring(0, questIndex);
        String queryString = urlString.substring(questIndex + 1, urlString.length());
        return new Request(url, getParamsMap(queryString, enc));
    }

    private static Map<String, String[]> getParamsMap(String queryString, String enc) {
        Map<String, String[]> paramsMap = new HashMap<String, String[]>();
        if (queryString != null && queryString.length() > 0) {
            int ampersandIndex, lastAmpersandIndex = 0;
            String subStr, param, value;
            String[] paramPair, values, newValues;
            do {
                ampersandIndex = queryString.indexOf('&', lastAmpersandIndex) + 1;
                if (ampersandIndex > 0) {
                    subStr = queryString.substring(lastAmpersandIndex, ampersandIndex - 1);
                    lastAmpersandIndex = ampersandIndex;
                } else {
                    subStr = queryString.substring(lastAmpersandIndex);
                }
                paramPair = subStr.split("=");
                param = paramPair[0];
                value = paramPair.length == 1 ? "" : paramPair[1];
                try {
                    value = URLDecoder.decode(value, enc);
                } catch (UnsupportedEncodingException ignored) {
                }
                if (paramsMap.containsKey(param)) {
                    values = paramsMap.get(param);
                    int len = values.length;
                    newValues = new String[len + 1];
                    System.arraycopy(values, 0, newValues, 0, len);
                    newValues[len] = value;
                } else {
                    newValues = new String[] { value };
                }
                paramsMap.put(param, newValues);
            } while (ampersandIndex > 0);
        }
        return paramsMap;
    }

    /**
     * 请求对象
     * @author yy
     * @date Jun 21, 2009 2:17:31 PM
     */
    public static class Request implements HttpServletRequest {
        private String requestURI;
        private Map<String, String[]> parameterMap;

        Request() {
            this("");
        }

        Request(String requestURI) {
            this.requestURI = requestURI;
            parameterMap = new HashMap<String, String[]>();
        }

        Request(String requestURI, Map<String, String[]> parameterMap) {
            this.requestURI = requestURI;
            this.parameterMap = parameterMap;
        }

        public Object getAttribute(String name) {
            return null;
        }

        public Enumeration<String> getAttributeNames() {
            return null;
        }

        public String getCharacterEncoding() {
            return null;
        }

        public void setCharacterEncoding(String env) throws UnsupportedEncodingException {

        }

        public int getContentLength() {
            return 0;
        }

        public long getContentLengthLong() {
            return 0;
        }

        public String getContentType() {
            return null;
        }

        public ServletInputStream getInputStream() throws IOException {
            return null;
        }

        /**
         * 获得指定名称的参数
         * @param name
         * @return
         */
        public String getParameter(String name) {
            String[] values = parameterMap.get(name);
            if (values != null && values.length > 0) {
                return values[0];
            }
            return null;
        }

        /**
         * 获得所有的参数名称
         * @return
         */
        public Enumeration<String> getParameterNames() {
            return Collections.enumeration(parameterMap.keySet());
        }

        /**
         * 获得指定名称的参数值(多个)
         * @param name
         * @return
         */
        public String[] getParameterValues(String name) {
            return parameterMap.get(name);
        }

        public String getAuthType() {
            return null;
        }

        public Cookie[] getCookies() {
            return new Cookie[0];
        }

        public long getDateHeader(String name) {
            return 0;
        }

        public String getHeader(String name) {
            return null;
        }
        public Enumeration<String> getHeaders(String name) {
            return null;
        }

        public Enumeration<String> getHeaderNames() {
            return null;
        }

        public int getIntHeader(String name) {
            return 0;
        }

        public String getMethod() {
            return null;
        }

        public String getPathInfo() {
            return null;
        }

        public String getPathTranslated() {
            return null;
        }

        public String getContextPath() {
            return null;
        }

        public String getQueryString() {
            return null;
        }

        public String getRemoteUser() {
            return null;
        }

        public boolean isUserInRole(String role) {
            return false;
        }

        public Principal getUserPrincipal() {
            return null;
        }

        public String getRequestedSessionId() {
            return null;
        }

        /**
         * 获得请求的url地址
         * @return
         */
        public String getRequestURI() {
            return requestURI;
        }

        public StringBuffer getRequestURL() {
            return null;
        }

        public String getServletPath() {
            return null;
        }

        public HttpSession getSession(boolean create) {
            return null;
        }

        public HttpSession getSession() {
            return null;
        }

        public String changeSessionId() {
            return null;
        }

        public boolean isRequestedSessionIdValid() {
            return false;
        }

        public boolean isRequestedSessionIdFromCookie() {
            return false;
        }

        public boolean isRequestedSessionIdFromURL() {
            return false;
        }

        public boolean isRequestedSessionIdFromUrl() {
            return false;
        }

        public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
            return false;
        }

        public void login(String username, String password) throws ServletException {

        }

        public void logout() throws ServletException {

        }

        public Collection<Part> getParts() throws IOException, ServletException {
            return null;
        }

        public Part getPart(String name) throws IOException, ServletException {
            return null;
        }

        public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
            return null;
        }

        /**
         * 获得 参数-值Map
         * @return
         */
        public Map<String, String[]> getParameterMap() {
            return parameterMap;
        }

        public String getProtocol() {
            return null;
        }

        public String getScheme() {
            return null;
        }

        public String getServerName() {
            return null;
        }

        public int getServerPort() {
            return 0;
        }

        public BufferedReader getReader() throws IOException {
            return null;
        }

        public String getRemoteAddr() {
            return null;
        }

        public String getRemoteHost() {
            return null;
        }

        public void setAttribute(String name, Object o) {

        }

        public void removeAttribute(String name) {

        }

        public Locale getLocale() {
            return null;
        }

        public Enumeration<Locale> getLocales() {
            return null;
        }

        public boolean isSecure() {
            return false;
        }

        public RequestDispatcher getRequestDispatcher(String path) {
            return null;
        }

        public String getRealPath(String path) {
            return null;
        }

        public int getRemotePort() {
            return 0;
        }

        public String getLocalName() {
            return null;
        }

        public String getLocalAddr() {
            return null;
        }

        public int getLocalPort() {
            return 0;
        }

        public ServletContext getServletContext() {
            return null;
        }

        public AsyncContext startAsync() throws IllegalStateException {
            return null;
        }

        public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
            return null;
        }

        public boolean isAsyncStarted() {
            return false;
        }

        public boolean isAsyncSupported() {
            return false;
        }

        public AsyncContext getAsyncContext() {
            return null;
        }

        public DispatcherType getDispatcherType() {
            return null;
        }

        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder();
            buf.append("{");
            buf.append("\n  url = ").append(this.requestURI);
            buf.append("\n  paramsMap = {");
            if (this.parameterMap.size() > 0) {
                for (Map.Entry<String, String[]> e : this.parameterMap.entrySet()) {
                    buf.append(e.getKey()).append("=").append(Arrays.toString(e.getValue())).append(",");
                }
                buf.deleteCharAt(buf.length() - 1);
            }
            buf.append("}\n}");
            return buf.toString();
        }
        //  剩下的函数,自己根据需求实现了,一般返回0或者null即可
        //  这里就不贴了,HttpServletRequest的接口方法也太多了
    }
}