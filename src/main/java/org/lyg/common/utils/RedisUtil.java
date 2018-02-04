package org.lyg.common.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

public class  RedisUtil {
	    //Redis服务器IP
	    private static String ADDR = "35.162.177.50";
	    //Redis的端口号
	    private static int PORT = 6379;
	    //访问密码
	    private static String AUTH = "fengyue1985";
	    //可用连接实例的最大数目，默认值为8�?
	    //如果赋�?�?1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)�?
	    private static int MAX_ACTIVE = 1024;
	    //控制�?��pool�?��有多少个状�?为idle(空闲�?的jedis实例，默认�?也是8�?
	    private static int MAX_IDLE = 200;
	    //等待可用连接的最大时间，单位毫秒，默认�?�?1，表示永不超时�?如果超过等待时间，则直接抛出JedisConnectionException�?
	    private static int MAX_WAIT = 10000;
	    private static int TIMEOUT = 10000;
	    //在borrow�?��jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	    private static boolean TEST_ON_BORROW = true;
	    private static JedisPool jedisPool = null;
	    /**
	     * 初始化Redis连接�?
	     */
	    static {
	        try {
	            JedisPoolConfig config = new JedisPoolConfig();
	            config.setMaxIdle(MAX_IDLE);
	            config.setMaxTotal(MAX_ACTIVE);
	            config.setMaxWaitMillis(10000);
	            config.setTestOnBorrow(TEST_ON_BORROW);
	            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    /**
	     * 获取Jedis实例
	     * @return
	     */
	    public synchronized static Jedis getJedis() {
	        try {
	            if (jedisPool != null) {
	                Jedis resource = jedisPool.getResource();
	                return resource;
	            } else {
	                return null;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    /**
	     * 释放jedis资源
	     * @param jedis
	     */
	    public static void returnResource(final Jedis jedis) {
	        if (jedis != null) {
	            jedisPool.returnResource(jedis);
	        }
	    }
	    /**
	     * 设置商品信息
	     * @param jedis
	     */
	    public static void setGoodsMap(String goods_id,String value) {
	    	Jedis jedis  = RedisUtil.getJedis();
	    	Map<String,String> mapInfo = jedis.hgetAll("goodsMap");
	    	if(mapInfo.size()==0){
	    		mapInfo = new HashMap<String,String>();
	    		mapInfo.put(goods_id, value);
	    		jedis.hmset("goodsMap", mapInfo);
	    	}else{
	    		jedis.hmset("goodsMap", mapInfo);
	    	}
	    	 RedisUtil.returnResource(jedis);
	    }
	    /**
	     * 获取商品信息
	     * @param jedis
	     */
	    public static String getGoodsMap(String goods_id) {
			String result = null;
			Jedis jedis = RedisUtil.getJedis();
			Map<String, String> mapInfo = jedis.hgetAll("goodsMap");
			if (null != mapInfo) {
				result = mapInfo.get(goods_id);
			}
			RedisUtil.returnResource(jedis);
			return result;
		}
	    /**
	     * 设置各显示页面信息（少变化）
	     * @param jedis
	     */
	    public static void setPagesMap(String page,String value) {
	    	Jedis jedis  = RedisUtil.getJedis();
	    	Map<String,String> mapInfo = jedis.hgetAll("pagesMap");
	    	if(mapInfo.size()==0){
	    		mapInfo = new HashMap<String,String>();
	    		mapInfo.put(page, value);
	    		jedis.hmset("pagesMap", mapInfo);
	    	}else{
	    		jedis.hmset("pagesMap", mapInfo);
	    	}
	    	 RedisUtil.returnResource(jedis);
	    }
	    /**
	     * 获取各显示页面信息（少变化）
	     * @param jedis
	     */
	    public static String getPagesMap(String page) {
	    	String result = null;
	    	Jedis jedis  = RedisUtil.getJedis();
	    	Map<String,String> mapInfo = jedis.hgetAll("pagesMap");
	    	if(null!=mapInfo){
	    		result = mapInfo.get(page);
	    	}
	    	 RedisUtil.returnResource(jedis);
	    	return result;
	    }
}
