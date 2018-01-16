package org.lyg.cache;

import org.lyg.cache.Cache;

import java.util.*;

//Description: 绠＄悊缂撳瓨 

//鍙墿灞曠殑鍔熻兘锛氬綋chche鍒板唴�?樻孩鍑烘椂蹇呴�?娓呴櫎鎺夋渶鏃╂湡鐨勪竴浜涚紦�?樺璞★紝杩欏氨瑕佹眰�?规瘡涓紦�?樺璞�?繚�?樺垱寤烘椂闂�?

public class CacheManager { 
   private static HashMap cacheMap = new HashMap(); 

   //鍗曞疄渚嬫�?閫犳柟娉�?
   private CacheManager() { 
       super(); 
   } 
   //鑾峰彇甯冨皵鍊肩殑缂撳瓨 
   public static boolean getSimpleFlag(String key){ 
       try{ 
           return (Boolean) cacheMap.get(key); 
       }catch(NullPointerException e){ 
           return false; 
       } 
   } 
   public static long getServerStartdt(String key){ 
       try { 
           return (Long)cacheMap.get(key); 
       } catch (Exception ex) { 
           return 0; 
       } 
   } 
   //璁剧疆甯冨皵鍊肩殑缂撳瓨 
   public synchronized static boolean setSimpleFlag(String key,boolean flag){ 
       if (flag && getSimpleFlag(key)) {//鍋囧涓虹湡涓嶅厑璁歌瑕嗙�?
           return false; 
       }else{ 
           cacheMap.put(key, flag); 
           return true; 
       } 
   } 
   public synchronized static boolean setSimpleFlag(String key,long serverbegrundt){ 
       if (cacheMap.get(key) == null) { 
           cacheMap.put(key,serverbegrundt); 
           return true; 
       }else{ 
           return false; 
       } 
   } 


   //寰楀埌缂撳瓨銆傚悓姝ラ潤鎬佹柟娉�?
   //private synchronized static Cache getCache(String key) { 
   private  synchronized static Cache getCache(String key) {
       return (Cache) cacheMap.get(key); 
   } 

   //鍒ゆ柇鏄惁瀛樺湪涓�釜缂撳�?
  // private synchronized static boolean hasCache(String key) { 
   private synchronized static boolean hasCache(String key) { 
       return cacheMap.containsKey(key); 
   } 

   //娓呴櫎鎵�湁缂撳�?
   public synchronized static void clearAll() { 
       cacheMap.clear(); 
   } 

   //娓呴櫎鏌愪竴绫荤壒�?氱紦瀛�閫氳繃閬嶅巻HASHMAP涓嬬殑鎵�湁瀵硅薄锛屾潵鍒ゆ柇�?冪殑KEY涓庝紶鍏ョ殑TYPE鏄惁鍖归厤 
   public synchronized static void clearAll(String type) { 
       Iterator i = cacheMap.entrySet().iterator(); 
       String key; 
       ArrayList arr = new ArrayList(); 
       try { 
           while (i.hasNext()) { 
               java.util.Map.Entry entry = (java.util.Map.Entry) i.next(); 
               key = (String) entry.getKey(); 
               if (key.startsWith(type)) { //濡傛灉鍖归厤鍒欏垹闄ゆ帀 
                   arr.add(key); 
               } 
           } 
           for (int k = 0; k < arr.size(); k++) { 
               clearOnly((String) arr.get(k)); 
           } 
       } catch (Exception ex) { 
           ex.printStackTrace(); 
       } 
   } 

   //娓呴櫎鎸囧畾鐨勭紦�?�?
   public synchronized static void clearOnly(String key) { 
       cacheMap.remove(key); 
   } 

   //杞藉叆缂撳瓨 
   //public synchronized static void putCache(String key, Cache obj) { 
   public synchronized static void putCache(String key, Cache obj) { 
      cacheMap.put(key, obj); 
   } 

   //鑾峰彇缂撳瓨淇℃�?
   public synchronized static Cache getCacheInfo(String key) { 
       if (hasCache(key)) 
       { 
           Cache cache = getCache(key); 
           if (cacheExpired(cache)) 
           { //璋冪敤鍒ゆ柇鏄惁缁堟鏂规�?
               cache.setExpired(true); 
           } 
           return cache; 
       }else 
           return null; 
   } 
   //杞藉叆缂撳瓨淇℃�?
   public static void putCacheInfo(String key, Cache obj, long dt,boolean expired) { 
       Cache cache = new Cache(); 
       cache.setKey(key); 
       cache.setTimeOut(dt + System.currentTimeMillis()); //璁剧疆澶氫箙鍚庢洿鏂扮紦瀛�
       cache.setValue(obj); 
       cache.setExpired(expired); //缂撳瓨榛樿杞藉叆鏃讹紝缁堟鐘舵�涓篎ALSE 
       cacheMap.put(key, cache); 
   } 
   //閲嶅啓杞藉叆缂撳瓨淇℃伅鏂规�?
   public static void putCacheInfo(String key,Cache obj,long dt){ 
       Cache cache = new Cache(); 
       cache.setKey(key); 
       cache.setTimeOut(dt+System.currentTimeMillis()); 
       cache.setValue(obj); 
       cache.setExpired(false); 
       cacheMap.put(key,cache); 
   } 
   //鍒ゆ柇缂撳瓨鏄惁缁堟 
   public static boolean cacheExpired(Cache cache) { 
       if (null == cache) { //浼犲叆鐨勭紦瀛樹笉�?樺湪 
           return false; 
       } 
       long nowDt = System.currentTimeMillis(); //绯荤粺褰撳墠鐨勬绉掓暟 
       long cacheDt = cache.getTimeOut(); //缂撳瓨鍐呯殑杩囨湡姣鏁�
       if (cacheDt <= 0||cacheDt > nowDt) { //杩囨湡鏃堕棿灏忎簬绛変簬闆舵�?鎴栬�杩囨湡鏃堕棿澶т簬褰撳墠鏃堕棿鏃讹紝鍒欎负FALSE 
           return false; 
       } else { //澶т簬杩囨湡鏃堕棿 鍗宠繃鏈�?
           return true; 
       } 
   } 
   //鑾峰彇缂撳瓨涓殑澶у�?
   public synchronized static int getCacheSize() { 
       return cacheMap.size(); 
   } 
   //鑾峰彇鎸囧畾鐨勭被鍨嬬殑澶у皬 
   public static int getCacheSize(String type) { 
       int k = 0; 
       Iterator i = cacheMap.entrySet().iterator(); 
       String key; 
       try { 
           while (i.hasNext()) { 
               java.util.Map.Entry entry = (java.util.Map.Entry) i.next(); 
               key = (String) entry.getKey(); 
               if (key.indexOf(type) != -1) { //濡傛灉鍖归厤鍒欏垹闄ゆ帀 
                   k++; 
               } 
           } 
       } catch (Exception ex) { 
           ex.printStackTrace(); 
       } 
       return k; 
   } 
   //鑾峰彇缂撳瓨瀵硅薄涓殑鎵�湁閿�鍚嶇О 
   public static ArrayList getCacheAllkey() { 
       ArrayList a = new ArrayList(); 
       try { 
           Iterator i = cacheMap.entrySet().iterator(); 
           while (i.hasNext()) { 
               java.util.Map.Entry entry = (java.util.Map.Entry) i.next(); 
               a.add((String) entry.getKey()); 
           } 
       } catch (Exception ex) {} finally { 
           return a; 
       } 
   } 
   //鑾峰彇缂撳瓨瀵硅薄涓寚瀹氱被鍨�鐨勯敭鍊煎悕绉�?
   public static ArrayList getCacheListkey(String type) { 
       ArrayList a = new ArrayList(); 
       String key; 
       try { 
           Iterator i = cacheMap.entrySet().iterator(); 
           while (i.hasNext()) { 
               java.util.Map.Entry entry = (java.util.Map.Entry) i.next(); 
               key = (String) entry.getKey(); 
               if (key.indexOf(type) != -1) { 
                   a.add(key); 
               } 
           } 
       } catch (Exception ex) {} finally { 
           return a; 
       } 
   }
} 