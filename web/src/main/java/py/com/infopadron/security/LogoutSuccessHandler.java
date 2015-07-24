package py.com.infopadron.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import py.com.infopadron.helper.Conexiones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

  @Override
  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

//	  Conexiones db = new Conexiones();
//	  Connection conn=db.connect();
//	  PreparedStatement pst=null;
//	  
//	  String sqlUpdate="update sys.sessions set active=false, logout_date=current_timestamp where sessionid=?";
//		try {
//			pst = conn.prepareStatement(sqlUpdate);
//			pst.setString(1, request.getRequestedSessionId());
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
	  
	  logger.info("===============USER=========================");
	  logger.info("logout user");
	  logger.info("request.getRequestedSessionId(): "+request.getRequestedSessionId());
	  logger.info("========================================");
	  
    // super.onLogoutSuccess(request, response, authentication);
  }
}
