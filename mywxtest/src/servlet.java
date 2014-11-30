import com.sa.service.CoreService;
import com.sa.util.SignUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by sa on 14-11-29.
 */
public class servlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(servlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        PrintWriter out=null;
        try {
            // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");


            //调用核心业务类接收消息、处理消息
            String respMessage = CoreService.processRequest(request);

            //响应消息
            out = response.getWriter();
            out.print(respMessage);
            logger.info("this is a test message");

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally{
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this is a test");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
    }
}
