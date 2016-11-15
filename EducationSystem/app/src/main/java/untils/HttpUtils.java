package untils;

import android.os.Handler;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

/**
 * Created by tianyun chen on 2016/10/19.
 */
public class HttpUtils {
    private URL url;
    private HttpURLConnection connection;
    private byte[] mydata;
    private Handler mHandler;
    private final  static  String PUBLICK_KEY = "123456789";
    public HttpUtils(String url,String apiName) {
        try {
            this.url = new URL(url+apiName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void loadData(Map<String,String> paramers){
        StringBuffer buffer = new StringBuffer();
        for(Map.Entry<String,String> entry:paramers.entrySet()){
            try {
                buffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(),"UTF-8"))
                        .append("&");

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        buffer.deleteCharAt(buffer.length()-1);
        Log.d("HttpUtils",buffer.toString());
        mydata = buffer.toString().getBytes();

    }

    public InputStream excusePost(){
        try {
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(3000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(mydata.length));
            connection.connect();
            OutputStream outputStream =  connection.getOutputStream();
            outputStream.write(mydata,0,mydata.length);
            int responseCode = connection.getResponseCode();
            if(responseCode==200){
                Log.d("HttpUtils","connection:good");

                return  connection.getInputStream();

                //encodeStream(connection.getInputStream());
            }else
            {
                Log.d("HttpUtils","connection:bad"+responseCode);

                //Log.d("Http","exception");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
