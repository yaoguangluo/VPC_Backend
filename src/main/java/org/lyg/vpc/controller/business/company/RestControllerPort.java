package org.lyg.vpc.controller.business.company;

import org.lyg.common.RequestLimit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.Map;

@RestController
public interface RestControllerPort {
    @GET
    @RequestMapping("/aa")
    @Produces("application/json;charset=utf-8")
    public Map<String, Object> startResults(@QueryParam("aa") int aa) throws IOException;

    @RequestLimit(count=1,time=60000)
    @GET
    @RequestMapping("/bb")
    @Produces("application/json;charset=utf-8")
    public Map<String, Object> startResultsBb(@QueryParam("bb") int bb) throws IOException;
    /*{
       /*
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

    }*/
}