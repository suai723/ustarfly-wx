import com.sa.bean.AccessToken;
import com.sa.bean.Ticket;
import com.sa.bean.TicketData;
import com.sa.util.CodeUtil;
import com.sa.util.wxutil;
import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * Created by sa on 14-12-2.
 */
public class AccessTokenTest {
    @Test
    public  void accseeTest(){
//       JSONObject AccessToken=wxutil.getAccessToken();
//        String token = AccessToken.getString("access_token");
//        String expires_in = AccessToken.getString("expires_in");
//        System.out.println(token+" "+expires_in);

        AccessToken at =wxutil.getAccessToken();
        Ticket ticket = CodeUtil.getTicket(at,null);
        JSONObject s = CodeUtil.getCode(ticket);
    }
}
