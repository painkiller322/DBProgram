package impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DAO;
import model.Model;

public class EmpDAO {
//	초기값 선언
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	String name = null;

//	1.게시글 작성
	public void input(Model board) {
		conn = DAO.getConnect();// DB와 연동
		String sql = "insert into boards values((select max(id_num)+1 from boards) ,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getDepart());
			pstmt.setString(3, board.getSalary());
			pstmt.setString(4, board.getHire_date());
			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 사원조회
	public List<Model> search(String name) {
		conn = DAO.getConnect();
		String sql = "select * from boards where name = ? ";
		Model board = new Model();
		List<Model> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				board = new Model();
				board.setId_num(rs.getInt("id_num"));
				board.setName(rs.getString("name"));
				board.setDepart(rs.getString("depart"));
				board.setSalary(rs.getString("salary"));
				board.setHire_date(rs.getString("hire_date"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

//	부서변경
	public void update(Model board) {
		conn = DAO.getConnect();
		String sql = "update boards set depart = ? where id_num = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getDepart());
			pstmt.setInt(2, board.getId_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//부서검색
	public List<Model> look(String depart) {
		conn = DAO.getConnect();

		if (depart.equals("")) {
			String sql = "select id_num, name, depart, salary, hire_date,"
					+ "(select count(*) from boards where depart = depart ) as depart_count "
					+ " from boards";

			Model board = new Model();
			List<Model> list = new ArrayList<>();

			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					board = new Model();
					board.setId_num(rs.getInt("id_num"));
					board.setName(rs.getString("name"));
					board.setDepart(rs.getString("depart") + "(" + rs.getString("depart_count") + ")");
					board.setSalary(rs.getString("salary"));
					board.setHire_date(rs.getString("hire_date"));
					list.add(board);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;

		}

		else {
			String sql = "select id_num, name, depart, salary, hire_date,"
					+ "(select count(*) from boards where depart= depart ) as depart_count "
					+ " from boards where depart = ? ";
			Model board = new Model();
			List<Model> list = new ArrayList<>();

			try {
				pstmt = conn.prepareStatement(sql);
				 pstmt.setString(1, depart);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					board = new Model();
					board.setId_num(rs.getInt("id_num"));
					board.setName(rs.getString("name"));
					board.setDepart(rs.getString("depart") + "(" + rs.getString("depart_count") + ")");
					board.setSalary(rs.getString("salary"));
					board.setHire_date(rs.getString("hire_date"));
					list.add(board);
			

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}

	}

//	삭제
	public void delete(Model board) {
		conn = DAO.getConnect();
		String sql = "delete from boards where id_num = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getId_num());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
