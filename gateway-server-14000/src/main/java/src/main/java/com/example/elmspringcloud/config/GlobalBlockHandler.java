//package src.main.java.com.example.elmspringcloud.config;
//
//import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//
//@Component
//public class GlobalBlockHandler implements BlockExceptionHandler {
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
//        // 返回自定义的 fallback 数据或提示信息
//        response.getWriter().write("Service Unavailable");
////        response.setStatus(403);
//    }
//}
