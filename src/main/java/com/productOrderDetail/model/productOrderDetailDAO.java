package com.productOrderDetail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productOrderDetailDAO implements ProductOrderDetailDAO_interface {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/tia102g2?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";

	private static final String ADD_PRODUCTORDERDETAIL = "INSERT INTO ProductOrderDetail (productOrder_id, product_id, productOrderDetail_amount, productOrderDetail_price) VALUES (?,?,?,?)";
	private static final String UPDATE_PRODUCTORDERDETAIL = "UPDATE ProductOrderDetail set productOrder_id=?, product_id=?, productOrderDetail_amount=?, productOrderDetail_price=? WHERE productOrderDetail_id = ? ";

	private static final String GET_ALL_STMT = "SELECT * FROM productorderdetail";
	private static final String GET_PRODUCTORDER_ID = "SELECT * FROM productorderdetail WHERE productOrder_id = ?";

	// 建立連線
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(ProductOrderDetailVO productOrderDetailVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// TODO Auto-generated method stub

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(ADD_PRODUCTORDERDETAIL);

			pstmt.setInt(1, productOrderDetailVO.getProductOrder_id());
			pstmt.setInt(2, productOrderDetailVO.getproduct_id());
			pstmt.setInt(3, productOrderDetailVO.getProductOrderDetail_amount());
			pstmt.setInt(4, productOrderDetailVO.getProductOrderDetail_price());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(ProductOrderDetailVO productOrderDetailVO) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE_PRODUCTORDERDETAIL);

			pstmt.setInt(1, productOrderDetailVO.getProductOrder_id());
			pstmt.setInt(2, productOrderDetailVO.getproduct_id());
			pstmt.setInt(3, productOrderDetailVO.getProductOrderDetail_amount());
			pstmt.setInt(4, productOrderDetailVO.getProductOrderDetail_price());
			pstmt.setInt(5, productOrderDetailVO.getProductOrderDetail_id());
			

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

//	@Override
//	public ProductOrderDetailVO findByProductOrderDetailId(Integer productOrderDetail_id) {
//		// TODO Auto-generated method stub
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		ProductOrderDetailVO productOrderDetailVO = null;
//
//		try {
//			Class.forName(DRIVER);
//			con = DriverManager.getConnection(URL, USER, PASSWORD);
//			pstmt = con.prepareStatement(GET_ID);
//
//			pstmt.setInt(1, productOrderDetail_id);
//			productOrderDetailVO = new ProductOrderDetailVO();
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				productOrderDetailVO = new ProductOrderDetailVO();
//				productOrderDetailVO.setProductOrder_id(rs.getInt("ProductOrder_id"));
//				productOrderDetailVO.setproduct_id(rs.getInt("product_id"));
//				productOrderDetailVO.setProductOrderDetail_amount(rs.getInt("ProductOrderDetail_amount"));
//				productOrderDetailVO.setProductOrderDetail_price(rs.getInt("ProductOrderDetail_price"));
//
//			}
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//		return productOrderDetailVO;
//	}

//	@SuppressWarnings("unchecked")
	public List<ProductOrderDetailVO> findByProductOrderId(Integer productOrder_id) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProductOrderDetailVO> list = null;
		
		
		try {
		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		pstmt = con.prepareStatement(GET_PRODUCTORDER_ID);

		pstmt.setInt(1, productOrder_id);
		
		list = new ArrayList<ProductOrderDetailVO>();
		rs = pstmt.executeQuery();

		while (rs.next()) {

			ProductOrderDetailVO productOrderDetailVO= new ProductOrderDetailVO();
			
			productOrderDetailVO.setProductOrderDetail_id(rs.getInt("productOrderDetail_id"));
			productOrderDetailVO.setProductOrder_id(rs.getInt("ProductOrder_id"));
			productOrderDetailVO.setproduct_id(rs.getInt("product_id"));
			productOrderDetailVO.setProductOrderDetail_amount(rs.getInt("ProductOrderDetail_amount"));
			productOrderDetailVO.setProductOrderDetail_price(rs.getInt("ProductOrderDetail_price"));
			
			list.add(productOrderDetailVO);

		}
	} catch (ClassNotFoundException e) {
		throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		// Handle any SQL errors
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. " + se.getMessage());
		// Clean up JDBC resources
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
		
		return list;
	}

	@Override
	public List<ProductOrderDetailVO> getAll() {

		List<ProductOrderDetailVO> list = new ArrayList<>();
		ProductOrderDetailVO productOrderDetailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productOrderDetailVO = new ProductOrderDetailVO();

				productOrderDetailVO.setProductOrder_id(rs.getInt("ProductOrder_id"));
				productOrderDetailVO.setproduct_id(rs.getInt("product_id"));
				productOrderDetailVO.setProductOrderDetail_amount(rs.getInt("ProductOrderDetail_amount"));
				productOrderDetailVO.setProductOrderDetail_price(rs.getInt("ProductOrderDetail_price"));
				list.add(productOrderDetailVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return list;
	}

	
	public static void main(String[] args) {

		productOrderDetailDAO dao = new productOrderDetailDAO();

		// 新增
		ProductOrderDetailVO productOrderDetailVO1 = new ProductOrderDetailVO();
		productOrderDetailVO1.setProductOrder_id(64512);
		productOrderDetailVO1.setproduct_id(123);
		productOrderDetailVO1.setProductOrderDetail_amount(66);
		productOrderDetailVO1.setProductOrderDetail_price(77);
		dao.add(productOrderDetailVO1);

	}


}