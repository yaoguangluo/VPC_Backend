///*
package org.lyg.common.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.lyg.common.exceptions.RequestLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class TestAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void pointCut() {
        System.out.println(1);
    }

    @AfterReturning("execution(* org.lyg.*.*(..))")
    public void doAfter(JoinPoint jp) {
        System.out.println("log Ending method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
    }

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        time = System.currentTimeMillis() - time;
        System.out.println("process time: " + time + " ms");
        return retVal;
    }

    @Before("execution(* org.lyg.*.*(..))")
    public void doBefore(JoinPoint jp) {
        System.out.println("log Begining method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
    }
   // @Before()
    public void doThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("method " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");
        System.out.println(ex.getMessage());
    }
/*
    @Before("execution(* org.lyg.vpc.controller.business.company.*.*(..))")
    public void requestLimit(final JoinPoint joinPoint) throws RequestLimitException {
        try {
            String ip = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().getRemoteAddr();
            String url = joinPoint.getTarget().getClass().getName();
            String key = "req_limit_".concat(url).concat(ip);
            if (CacheManager.getCacheInfo(key) == null) {
                Cache c = new Cache();
                c.setValue(1);
                c.setTimeOut(System.currentTimeMillis() + 2000);
                CacheManager.putCache(key, c);
            } else if (CacheManager.getCacheInfo(key).isExpired()) {
                Cache c = new Cache();
                c.setValue(1);
                c.setTimeOut(System.currentTimeMillis() + 2000);
                CacheManager.putCache(key, c);
            } else if (!CacheManager.getCacheInfo(key).isExpired()
                    && (int) CacheManager.getCacheInfo(key).getValue() <= 4) {
                Cache c = new Cache();
                c.setValue((int) CacheManager.getCacheInfo(key).getValue() + 1);
                c.setTimeOut(System.currentTimeMillis() + 2000);
                CacheManager.putCache(key, c);
            } else if (!CacheManager.getCacheInfo(key).isExpired()
                    && (int) CacheManager.getCacheInfo(key).getValue() > 4) {
                throw new RequestLimitException();
            }
        } catch (RequestLimitException e) {
            throw e;
        } catch (Exception e) {
            log.error("发生异常: ", e);
        }
    }
*/
   // @Before("pointCut()")
    @Before("execution(* org.lyg.vpc.controller.company.*.*(..))")
    public void requestLimit(final JoinPoint joinPoint) throws RequestLimitException {
        ///*
        try {
            String ip = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().getRemoteAddr();
            String url = joinPoint.getTarget().getClass().getName();
            String key = "req_limit_".concat(url).concat(ip);
            if (redisTemplate.opsForValue().get(key) == null) {
                redisTemplate.opsForValue().set(key, "1", 2000, TimeUnit.MILLISECONDS);
            } else if (redisTemplate.opsForValue().get(key).isEmpty()){
                redisTemplate.opsForValue().set(key, "1", 2000, TimeUnit.MILLISECONDS);
            } else if (!redisTemplate.opsForValue().get(key).isEmpty()
                    && Integer.valueOf(redisTemplate.opsForValue().get(key)) <= 4) {
                int digit = Integer.valueOf(redisTemplate.opsForValue().get(key)) + 1;
                redisTemplate.opsForValue().set(key, "" + digit, 2000, TimeUnit.MILLISECONDS);
            } else if (!redisTemplate.opsForValue().get(key).isEmpty()
                    && Integer.valueOf(redisTemplate.opsForValue().get(key)) > 4) {
                throw new RequestLimitException();
            }
        } catch (RequestLimitException e) {
            throw e;
        } catch (Exception e) {
            log.error("发生异常: ", e);
        }
        //*/
    }

}//*/