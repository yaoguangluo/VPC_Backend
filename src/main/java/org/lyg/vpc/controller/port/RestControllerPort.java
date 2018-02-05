package org.lyg.vpc.controller.port;

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
    @RequestLimit(count = 1, time = 60000)
    @GET
    @RequestMapping("/aa")
    @Produces("application/json;charset=utf-8")
    public Map<String, Object> startResults(@QueryParam("aa") int aa) throws IOException;

    @RequestLimit(count = 1, time = 60000)
    @GET
    @RequestMapping("/bb")
    @Produces("application/json;charset=utf-8")
    public Map<String, Object> startResultsBb(@QueryParam("bb") int bb) throws IOException;
}