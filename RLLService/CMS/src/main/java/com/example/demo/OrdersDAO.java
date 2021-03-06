package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class OrdersDAO {
	@Autowired  
    JdbcTemplate jdbc;
	
	public List<Orders> showVendorPendingOrders(int venId) {
		String cmd = "select * from Orders where ORD_STATUS='PENDING' AND ven_id=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {venId}, new RowMapper<Orders>() {

			@Override
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getInt("ord_id"));
				orders.setCus_id(rs.getInt("cus_id"));
				orders.setVen_id(rs.getInt("ven_id"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMen_id(rs.getInt("men_id"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
			}
			
		});
		return ordersList;
	}
	
	public List<Orders> showVendorOrders(int venId) {
		String cmd = "select * from Orders where ven_id=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {venId}, new RowMapper<Orders>() {

			@Override
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getInt("ord_id"));
				orders.setCus_id(rs.getInt("cus_id"));
				orders.setVen_id(rs.getInt("ven_id"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMen_id(rs.getInt("men_id"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
			}
			
		});
		return ordersList;
	}
	
	public List<Orders> showCustomerOrders(int custId) {
		String cmd = "select * from Orders where  cus_id=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {custId}, new RowMapper<Orders>() {

			@Override
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getInt("ord_id"));
				orders.setCus_id(rs.getInt("cus_id"));
				orders.setVen_id(rs.getInt("ven_id"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMen_id(rs.getInt("men_id"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
			}
			
		});
		return ordersList;
	}
	public List<Orders> showCustomerPendingOrders(int custId) {
		String cmd = "select * from Orders where ORD_STATUS='PENDING' AND cus_id=?";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {custId}, new RowMapper<Orders>() {

			@Override
			public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setOrd_id(rs.getInt("ord_id"));
				orders.setCus_id(rs.getInt("cus_id"));
				orders.setVen_id(rs.getInt("ven_id"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMen_id(rs.getInt("men_id"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_quantity(rs.getInt("ord_quantity"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
			
		}
		});
		return ordersList;
		}
	public Orders searchByOrderId(int ordId) {
        String cmd = "select * from Orders where ord_id=?";
        List<Orders> ordersList=null;
        ordersList=jdbc.query(cmd,new Object[] {ordId}, new RowMapper<Orders>() {
            @Override
            public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                Orders orders = new Orders();
                orders.setOrd_id(rs.getInt("ord_id"));
				orders.setCus_id(rs.getInt("cus_id"));
				orders.setVen_id(rs.getInt("ven_id"));
				orders.setWal_source(rs.getString("wal_source"));
				orders.setMen_id(rs.getInt("men_id"));
				orders.setOrd_date(rs.getDate("ord_date"));
				orders.setOrd_billamount(rs.getDouble("ord_billamount"));
				orders.setOrd_status(rs.getString("ord_status"));
				orders.setOrd_comments(rs.getString("ord_comments"));
				return orders;
            }
            
        });
        return ordersList.get(0);
    }
	 public int generateordid() {
	    	String cmd = " select case when max(ord_id) is NULL"
					+ " then 1 else max(ord_id)+1 end ord_id from orders ";
	    	List str=jdbc.query(cmd, new RowMapper() {
	            @Override
	            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	                // TODO Auto-generated method stub
	                return rs.getInt("ord_id");
	            }
	            
	        });
	        return (int) str.get(0);
	    }
	 
		public String updateStatus(int ordId,String ordStatus) {
			String cmd = "Update Orders set ORD_STATUS=? WHERE ord_Id=?";
			jdbc.update(cmd, new Object[] {ordStatus,ordId});
			return "Order Accepted...";
		}

		

}


