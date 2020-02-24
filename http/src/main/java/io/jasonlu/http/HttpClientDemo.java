package io.jasonlu.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Modified by louz on 2020/1/10.
 */
public class HttpClientDemo {
    public final static void main(String[] args) throws Exception {
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
        RequestConfig config = RequestConfig.custom().setExpectContinueEnabled(true).build();
        try (CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build()) {
            //第1步：创建httpPost对象
            String url = "http://localhost:8080/expect-demo";
            HttpPost httpPost = new HttpPost(url);

            //第2步：给httpPost设置JSON格式的参数
            String json = "{\n" +
                    " \"a\": \"long text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text long text long text long text long textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong textlong text\"\n" +
                    "}";
//            String json = "{\"a\": \"1\"}";
            StringEntity requestEntity = new StringEntity(json,"utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);

            //第3步：发送HttpPost请求，获取返回值
            System.out.printf("return value: %s%n", httpClient.execute(httpPost, new BasicResponseHandler())); //调接口获取返回值时，必须用此方法
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void getDemo(CloseableHttpClient httpClient) throws IOException {
        try {
            String uri = "http://webservices.amazon.com/onca/xml?AWSAccessKeyId=AKIAJPQG25W4A3KTYLQQ&AssociateTag=pricemonitor-20&IdType=ASIN&ItemId=B004QM968K&Operation=ItemLookup&ResponseGroup=OfferFull&Service=AWSECommerceService&Timestamp=2016-12-28T05%3A21%3A08Z&Signature=nbrITqwj07EjDq%2FG3A4sbmxAupxlpIHxzGauoIngDSI%3D";
            HttpGet httpget = new HttpGet(uri);

            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpClient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpClient.close();
        }
    }
}
