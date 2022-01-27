package br.com.yann.rssreader.factory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.yann.rssreader.factory.interfaces.RequestXmlInterface;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Stateless
@ManagedBean 
public class RequestXmlFromHttpFactory implements RequestXmlInterface {
  
    
    //TODO implement o not found
  
    private String xml=""; 

    final private OkHttpClient client;
    @Inject

    public RequestXmlFromHttpFactory() {
      client = new OkHttpClient().newBuilder()
                  .connectTimeout(1, TimeUnit.MINUTES)
                  .readTimeout(1, TimeUnit.MINUTES)
                  .callTimeout(1, TimeUnit.MINUTES)
                  .build();
    }
 
     public String getXml(String url) throws IOException  {
  
      Request request = new Request.Builder()
                                    .url(url)
                                    .header("Content-Type", "application/xml")
                                   .build();
       
      Response  response = client.newCall(request).execute();
      this.xml = response.body().string();  
  
      return  this.xml;
      
    }

  

  


  
}

