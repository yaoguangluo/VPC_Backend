package org.lyg.common;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class Minibuy
{
	
      public long randomCode()
      {
		return (long)(Math.random()*1000000)+1; 
      }
      
      public long getTime() throws IOException
      {
    	URL url = new URL("http://www.ntsc.ac.cn");
  		URLConnection uc = url.openConnection();
  		uc.connect();
  		return uc.getDate();
      }
      public String getKeyByKeyStore(KeyStore keyStore ) throws Exception
      {
    	Gson gson = new Gson();
  		return StringUtil.encode(gson.toJson(keyStore)); 
      }

	public KeyStore getKeyStoreByKey(String key) {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
		return gson.fromJson(StringUtil.decode(key), KeyStore.class);
	}

	public String strFomart(String address) {
		// TODO Auto-generated method stub
		String out="";
		for(int i=0;i<address.length();i++)
		{
			if(" ".equals(""+address.charAt(i)))
			{
				out+="%20";
			}else if("#".equals(""+address.charAt(i)))
			{
				out+="%23";
			}else{
				    out+=address.charAt(i);
				 }	
		}
		return out;
	}
      
}