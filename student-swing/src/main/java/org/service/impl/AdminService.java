package org.service.impl;

import org.entity.ManagerDO;
import org.service.IAdminService;
import org.util.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminService implements IAdminService {
    @Override
    public boolean validateAdmin(ManagerDO managerDO) {
        String sql = "select * from manager where username = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbHelper.getCon();
            if (conn == null) {
                return false;
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1, managerDO.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                String pwd = rs.getString("pwd");
                if (managerDO.getPwd().equals(pwd)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbHelper.closeRs(rs);
            DbHelper.closePs(ps);
            DbHelper.closeConn(conn);
        }
        return false;
    }
}
