package org.lyg.common;

import org.aspectj.lang.JoinPoint;

public class DataSourceAspect{
	
    public void pointCut(){};    
      
     public void before(JoinPoint point)  
        {  
            Object target = point.getTarget();  
            System.out.println("target="+target.toString());  
            String m = point.getSignature().getName();
            try {  
                System.out.println(m);  

                if (m != null && m.startsWith("transaction")) { 
                    System.out.println("Annotation=WriteData");  
                    HandleDataSource.putDataSource("write");  
                }else{  
                    System.out.println("Annotation=ReadData");  
                    HandleDataSource.putDataSource("read");                	
                }                
                  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }

     public void after(JoinPoint point)  {

         System.out.println("Annotation=ReadData");  
         HandleDataSource.putDataSource("read");      
     }

}
