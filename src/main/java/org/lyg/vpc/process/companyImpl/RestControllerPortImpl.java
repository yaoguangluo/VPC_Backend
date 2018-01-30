package org.lyg.vpc.process.companyImpl;

//import org.apache.camel.builder.RouteBuilder;
import lombok.extern.slf4j.Slf4j;
import org.lyg.vpc.controller.company.RestControllerPort;
import org.lyg.vpc.controller.company.department.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class RestControllerPortImpl implements RestControllerPort {
    //@Autowired
    //private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private HelloBean helloBean;

    public Map<String, Object> startResults(@QueryParam("aa") int aa) throws IOException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("end", aa);
        System.out.println("4444" + result.get("end"));
        String AA = helloBean.saySomething(aa);
        result.put("end", AA);
        log.info("good");
        return result;
        //return Response.status(Status.OK).entity(result).build();
            /*
             Session session = HibernateUtil.getSessionFactory().openSession();
			 session.beginTransaction();
	    	 Map<String, Object> result=new HashMap<String, Object>();
		 	 
		 	 String hql = "FROM Lolroler as l where l.name= :userName";
		 	
		 	 Query query = session.createQuery(hql);
		 	 result.put("end", results);

		 	 query.setString("userName", "Vi");
		 	 List<Lolroler> results = query.list(); 
		 	 session.getTransaction().commit();
			 return Response.status(Status.OK).entity(result).build();
			 */
            /*
            if(null == redisTemplate.opsForValue().get("click")){
				redisTemplate.opsForValue().set("click", "0" , 24000 , TimeUnit.HOURS);
			}else{
				String click = redisTemplate.opsForValue().get("click");
				long click_long = Long.parseLong(click);
				click_long += 1;
				redisTemplate.opsForValue().set("click", String.valueOf(click_long) , 24000 , TimeUnit.HOURS);
			}
			System.out.println(1111);
	    	EventDispatcher dispatcher = new EventDispatcher();
	        dispatcher.registerHandler(UserCreatedEvent.class, new UserCreatedEventHandler());
			System.out.println(2222);
	        User user = new User("iluwatar");
	        dispatcher.dispatch(new UserCreatedEvent(user));

			System.out.println(3333);
	    	 Map<String, Object> result=new HashMap<String, Object>();
	    	 result.put("end", user.getUsername());
	    	 System.out.println("4444"+result.get("end"));
	    	 return Response.status(Status.OK).entity(result).build();
	    	 */
    }

    public Map<String, Object> startResultsBb(@QueryParam("bb") int bb) throws IOException {
        Map<String, Object> output = new HashMap<>();
        try {
            URL url = new URL("http://localhost:8080/aa?aa=1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String out = "";
            String out1;
            System.out.println("Output from Server .... \n");
            while ((out1 = br.readLine()) != null) {
                out += out1;
            }
            output.put("result", out);
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}