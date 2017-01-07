package io.jasonlu.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by louz on 2016/12/28.
 */
public class HttpClientDemo {
    public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
//            String uri = "http://httpbin.org/";
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
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
    }
}
