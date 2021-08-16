import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        saveEntity();
        login();
        getEntity();
        downloadfile();
        dashboard();
    }

    private static void dashboard() throws IOException {
        CloseableHttpClient client = getCloseableHttpClient();
        HttpPost httpPost = new HttpPost("https://eportal.incometax.gov.in/iec/loginapi/auth/dashboard");
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("sec-ch-ua", "\" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"91\", \"Chromium\";v=\"91\"");
        httpPost.addHeader("Accept", "application/json, text/plain, */*");
        httpPost.addHeader("sec-ch-ua-mobile", "?0");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Origin", "https://eportal.incometax.gov.in");
        httpPost.addHeader("Sec-Fetch-Site", "same-origin");
        httpPost.addHeader("Sec-Fetch-Mode", "cors");
        httpPost.addHeader("Sec-Fetch-Dest", "empty");
        httpPost.addHeader("Referer", "https://eportal.incometax.gov.in/iec/foservices/");
        httpPost.addHeader("Accept-Language", "en-US,en;q=0.9,lb;q=0.8");
        httpPost.addHeader("Cookie", "AuthToken=c0dca4b683ea42f292bab8fe2705bebe");
        String body = "{\"header\":{\"formname\":\"FO-013-DSBRD\"},\"serviceName\":\"dashboardMenuService\",\"roleCd\":\"\"}";
        StringEntity data = new StringEntity(body, ContentType.APPLICATION_JSON);
        httpPost.setEntity(data);
        CloseableHttpResponse closeableHttpResponse = client.execute(httpPost);
        int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("status code...... :" + statuscode);
        String json = EntityUtils.toString(closeableHttpResponse.getEntity());
        System.out.println("................json.............." + json);
        Header[] headerArray = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header : headerArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Headers Array" + allHeaders);

    }

    private static void downloadfile() throws IOException {
        CloseableHttpClient client = getCloseableHttpClient();
        HttpPost httpPost = new HttpPost("https://eportal.incometax.gov.in/iec/itrweb/auth/v0.1/returns/downloadfile");
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("sec-ch-ua", "\"Chromium\";v=\"92\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"92\"");
        httpPost.addHeader("Accept", "application/json, text/plain, */*");
        httpPost.addHeader("sec-ch-ua-mobile", "?0");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Origin", "https://eportal.incometax.gov.in");
        httpPost.addHeader("Sec-Fetch-Site", "same-origin");
        httpPost.addHeader("Sec-Fetch-Mode", "cors");
        httpPost.addHeader("Sec-Fetch-Dest", "empty");
        httpPost.addHeader("Referer", "https://eportal.incometax.gov.in/iec/foservices/");
        httpPost.addHeader("Accept-Language", "en-US,en;q=0.9,lb;q=0.8");
        httpPost.addHeader("Cookie", "AuthToken=7e6a668d6f8f4734b9e484801b8f4140");
        String body = "{\"ackNum\":\"977648670311220\"}";
        StringEntity data = new StringEntity(body, ContentType.APPLICATION_JSON);
        httpPost.setEntity(data);
        CloseableHttpResponse closeableHttpResponse = client.execute(httpPost);
        int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("status code...... :" + statuscode);
        String json = EntityUtils.toString(closeableHttpResponse.getEntity());
        System.out.println("................json.............." + json);
        Header[] headerArray = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header : headerArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Headers Array" + allHeaders);
    }

    private static void getEntity() throws IOException {
        CloseableHttpClient client = getCloseableHttpClient();
        HttpPost httpPost = new HttpPost("https://eportal.incometax.gov.in/iec/servicesapi/auth/getEntity");
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("sec-ch-ua", "\"Chromium\";v=\"92\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"92\"");
        httpPost.addHeader("Accept", "application/json, text/plain, */*");
        httpPost.addHeader("sec-ch-ua-mobile", "?0");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Origin", "https://eportal.incometax.gov.in");
        httpPost.addHeader("Sec-Fetch-Site", "same-origin");
        httpPost.addHeader("Sec-Fetch-Mode", "cors");
        httpPost.addHeader("Sec-Fetch-Dest", "empty");
        httpPost.addHeader("Referer", "https://eportal.incometax.gov.in/iec/foservices/");
        httpPost.addHeader("Accept-Language", "en-US,en;q=0.9,lb;q=0.8");
        httpPost.addHeader("Cookie", "AuthToken=7e6a668d6f8f4734b9e484801b8f4140");
        String body = "{\"header\":{\"formName\":\"FO-006-ITRST\"},\"serviceName\":\"itrStatusService\",\"entityNum\":\"ALGPJ6855K\"}";
        StringEntity data = new StringEntity(body, ContentType.APPLICATION_JSON);
        httpPost.setEntity(data);
        CloseableHttpResponse closeableHttpResponse = client.execute(httpPost);
        int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("status code...... :" + statuscode);
        String json = EntityUtils.toString(closeableHttpResponse.getEntity());
        System.out.println("................json.............." + json);
        Header[] headerArray = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header : headerArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Headers Array" + allHeaders);


    }

    private static void login() throws IOException {
        CloseableHttpClient client = getCloseableHttpClient();
        HttpPost httpPost = new HttpPost("http://eportal.incometax.gov.in/iec/loginapi/login");
        httpPost.addHeader("Content-Type", "application/json");
        String body = "{\"errors\":[],\"reqId\":\"FOS000062556903\",\"entity\":\"AAACB6668A\",\"entityType\":\"PAN\",\"role\":\"CO\",\"uidValdtnFlg\":\"true\",\"aadhaarMobileValidated\":\"false\",\"secAccssMsg\":\"\",\"secLoginOptions\":\"\",\"aadhaarLinkedWithUserId\":\"Y\",\"exemptedPan\":\"false\",\"userConsent\":\"\",\"imgByte\":null,\"pass\":\"amFnaXdhbGFAMTIzNDU=\",\"passValdtnFlg\":null,\"otpGenerationFlag\":null,\"otp\":null,\"otpValdtnFlg\":null,\"otpSourceFlag\":null,\"contactPan\":null,\"contactMobile\":null,\"contactEmail\":null,\"email\":null,\"mobileNo\":null,\"forgnDirEmailId\":null,\"imagePath\":null,\"serviceName\":\"loginService\"}";
        StringEntity data = new StringEntity(body, ContentType.APPLICATION_JSON);
        httpPost.setEntity(data);
        CloseableHttpResponse closeableHttpResponse = client.execute(httpPost);
        int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("status code...... :" + statuscode);
        String json = EntityUtils.toString(closeableHttpResponse.getEntity());
        System.out.println("................json.............." + json);
        Header[] headerArray = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header : headerArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Headers Array" + allHeaders);


    }

    private static void saveEntity() throws IOException {
        CloseableHttpClient client = getCloseableHttpClient();
        HttpPost httpPost = new HttpPost("https://eportal.incometax.gov.in/iec/servicesapi/saveEntity");
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("sec-ch-ua", "\" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"91\", \"Chromium\";v=\"91\"");
        httpPost.addHeader("Accept", "application/json, text/plain, */*");
        httpPost.addHeader("sec-ch-ua-mobile", "?0");
        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Origin", "https://eportal.incometax.gov.in");
        httpPost.addHeader("Sec-Fetch-Site", "same-origin");
        httpPost.addHeader("Sec-Fetch-Mode", "cors");
        httpPost.addHeader("Sec-Fetch-Dest", "empty");
        httpPost.addHeader("Referer", "https://eportal.incometax.gov.in/iec/foservices/");
        httpPost.addHeader("Accept-Language", "en-US,en;q=0.9,lb;q=0.8");
        String body = "{\"serviceName\":\"itrStatusService\",\"ackNum\":\"121212301293819\",\"mobNum\":\"9643101022\"}";
        StringEntity data = new StringEntity(body, ContentType.APPLICATION_JSON);
        httpPost.setEntity(data);
        CloseableHttpResponse closeableHttpResponse = client.execute(httpPost);
        int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("status code...... :" + statuscode);
        String json = EntityUtils.toString(closeableHttpResponse.getEntity());
        System.out.println("................json.............." + json);
        // String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        //JSONObject responseJson = new JSONObject(responseString);
        // System.out.println("Response Json from APi............> " + responseJson);
        Header[] headerArray = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header : headerArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Headers Array" + allHeaders);

    }


    public static CloseableHttpClient getCloseableHttpClient() {
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.custom().
                    setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).
                    setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                        public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                            return true;
                        }
                    }).build()).build();
        } catch (KeyManagementException e) {
            // LOGGER.error("KeyManagementException in creating http client instance", e);
        } catch (NoSuchAlgorithmException e) {
            // LOGGER.error("NoSuchAlgorithmException in creating http client instance", e);
        } catch (KeyStoreException e) {
            // LOGGER.error("KeyStoreException in creating http client instance", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpClient;
    }
}
