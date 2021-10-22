package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.common.JNDI;

public class BoardDAO {
	String selectAll = "select * from board order by wdate desc";
	String insert = "insert into board(id, title, content) values (?,?,?)";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	List<BoardVO> datas = null;
	BoardVO data = null;
	boolean isSuccess = true;
	
	public List<BoardVO> board_selectDB_all(){
		datas = new ArrayList<BoardVO>();
		conn = JNDI.connect();
		try {
			pstmt = conn.prepareStatement(selectAll);		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				data = new BoardVO();
				data.setPk(rs.getInt("pk"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);		
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}		
		return datas;
	}
	
	public boolean board_insert(BoardVO vo) {
		conn = JNDI.connect();
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isSuccess=false;
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return isSuccess;	
	}
	
	
	

}
