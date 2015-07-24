package py.com.infopadron.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import py.com.infopadron.domain.UserEntity;
import py.com.infopadron.helper.Conexiones;
import py.com.infopadron.service.UserService;
import py.com.infopadron.security.SessionManager;
import py.com.infopadron.security.UserCurrentInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Autowired
  private UserService userService;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
    String principal = (String) authentication.getPrincipal();
    
    UserEntity userEntity = userService.findByMail(principal);

    UserCurrentInfo user = UserCurrentInfo.fromUserEntity(userEntity);

    SessionManager sessionManager = new SessionManager(request);
    sessionManager.setUser(user);
    
    logger.info("===============USER=========================");
    logger.info("user mail: "+user.getEmail());
    logger.info("user trader name"+user.getTraderName());
    logger.info("sessionid: "+request.getSession().getId());
    logger.info("=========================================");
     
//      Conexiones db = new Conexiones();
//	  Connection conn=db.connect();
//	  PreparedStatement pst=null;
//	  String sqlInsert="insert into sys.sessions (sessionid,active,app_name,userid,login_date) values(?,?,?,?,current_timestamp)";
//		try {
//			pst = conn.prepareStatement(sqlInsert);
//			pst.setString(1, request.getSession().getId());
//			pst.setBoolean(2, true);
//			pst.setString(3, user.getEmail());
//			pst.setInt(4, Integer.parseInt(user.getUserId().toString()));
//			pst.executeUpdate();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
    


  }

}
