package org.service.impl;

import org.dto.TableDTO;
import org.entity.StudentDO;
import org.entity.StudentRequest;
import org.service.IStudentService;
import org.util.DbHelper;

import java.sql.*;
import java.util.Vector;

public class StudentService implements IStudentService {
    @Override
    public TableDTO queryAll(StudentRequest request) {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("select * from student ");
        if (request.getSearchKey() != null && !"".equals(request.getSearchKey().trim())) {
            sbSql.append(" where xingming like '%" + request.getSearchKey().trim() + "%' ");
        }
        sbSql.append(" order by id limit ").append(request.getStartPage()).append(",").append(request.getPageSize());

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TableDTO tableDTO = new TableDTO();

        try {
            conn = DbHelper.getCon();
            ps = conn.prepareStatement(sbSql.toString());
            rs = ps.executeQuery();
            // 查询记录
            tableDTO.setData(fillData(rs));
            // 清空
            sbSql.setLength(0);

            // 查询总量
            sbSql.append("select count(*) from student");
            if (request.getSearchKey() != null && !"".equals(request.getSearchKey().trim())) {
                sbSql.append(" where xingming like '%" + request.getSearchKey().trim() + "%' ");
            }
            ps = conn.prepareStatement(sbSql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                int count = rs.getInt(1);
                tableDTO.setTotalCount(count);
            }
            return tableDTO;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbHelper.closeRs(rs);
            DbHelper.closePs(ps);
            DbHelper.closeConn(conn);
        }
        return null;
    }

    public boolean add(StudentDO studentDO) {

        StringBuilder sbSql = new StringBuilder();
        sbSql.append(" insert into Student (xingming,bianhao,shengri,jiaxiang,yuwen_defeng,yingyu_defeng,shuxue_defeng) ");
        sbSql.append(" values (?,?,?,?,?,?,?) ");

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbHelper.getCon();
            ps = conn.prepareStatement(sbSql.toString());
            ps.setString(1, studentDO.getXingming());
            ps.setString(2, studentDO.getBianhao());
            ps.setDate(3, (Date) studentDO.getShengri());
            ps.setString(4, studentDO.getJiaxiang());
            ps.setDouble(5, studentDO.getYuwen_defeng());
            ps.setDouble(6, studentDO.getYingyu_defeng());
            ps.setDouble(7, studentDO.getShuxue_defeng());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbHelper.closePs(ps);
            DbHelper.closeConn(conn);
        }
        return false;
    }

    @Override
    public boolean update(StudentDO studentDO) {

        StringBuilder sbSql = new StringBuilder();
        // UPDATE student set xingming='李四',shengri=DATE(NOW()),jiaxiang='四川',yuwen_defeng=100,yingyu_defeng=110,shuxue_defeng=120 WHERE bianhao = 'BH000001'
        sbSql.append(" UPDATE student set xingming = ?, shengri = ?, jiaxiang = ?, yuwen_defeng = ?, yingyu_defeng = ?, shuxue_defeng = ?  ");
        sbSql.append(" WHERE bianhao = ? ");

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbHelper.getCon();
            ps = conn.prepareStatement(sbSql.toString());
            ps.setString(1, studentDO.getXingming());
            ps.setDate(2, (Date) studentDO.getShengri());
            ps.setString(3, studentDO.getJiaxiang());
            ps.setDouble(4, studentDO.getYuwen_defeng());
            ps.setDouble(5, studentDO.getYingyu_defeng());
            ps.setDouble(6, studentDO.getShuxue_defeng());
            ps.setString(7, studentDO.getBianhao());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbHelper.closePs(ps);
            DbHelper.closeConn(conn);
        }
        return false;
    }

    @Override
    public boolean delete(int[] ids) {
        // 多行删除
        // DELETE FROM student WHERE id in (1,2,3,4,5)

        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM student  WHERE id in ( ");

        int length = ids.length;
        for (int i = 0; i < length; i++) {
            if (i == (length - 1)) {
                sql.append(" ? ");
            } else {
                sql.append(" ?, ");
            }
        }
        sql.append(" ) ");

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbHelper.getCon();
            ps = conn.prepareStatement(sql.toString());
            // 这一步主要是为了参数化, 如果不用这个循环的话,在开始拼接sql时直接可以把值拼接了
            for (int i = 0; i < length; i++) {
                ps.setInt(i + 1, ids[i]);
            }
            return ps.executeUpdate() == length;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbHelper.closePs(ps);
            DbHelper.closeConn(conn);
        }
        return false;
    }

    @Override
    public StudentDO queryById(int id) {
        String sql = " select * from Student where id = ? ";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StudentDO studentDO = new StudentDO();

        try {
            conn = DbHelper.getCon();
            ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                studentDO.setXingming(rs.getString("xingming"));
                studentDO.setBianhao(rs.getString("bianhao"));
                studentDO.setShengri(rs.getDate("shengri"));
                studentDO.setJiaxiang(rs.getString("jiaxiang"));
                studentDO.setYuwen_defeng(rs.getDouble("yuwen_defeng"));
                studentDO.setYingyu_defeng(rs.getDouble("yingyu_defeng"));
                studentDO.setShuxue_defeng(rs.getDouble("shuxue_defeng"));
                return studentDO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbHelper.closeRs(rs);
            DbHelper.closePs(ps);
            DbHelper.closeConn(conn);
        }
        return studentDO;
    }

    private Vector<Vector<Object>> fillData(ResultSet rs) throws SQLException {
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> oneRecord = new Vector<>();
            Integer id = rs.getInt("id");
            String xingming = rs.getString("xingming");
            String bianhao = rs.getString("bianhao");
            Date shengri = rs.getDate("shengri");
            String jiaxiang = rs.getString("jiaxiang");
            Double yuwendefeng = rs.getDouble("yuwen_defeng");
            Double yingyudefeng = rs.getDouble("yingyu_defeng");
            Double shuxuedefeng = rs.getDouble("shuxue_defeng");
            Double totalDefeng = yuwendefeng + yingyudefeng + shuxuedefeng;
            oneRecord.addElement(id);
            oneRecord.addElement(xingming);
            oneRecord.addElement(bianhao);
            oneRecord.addElement(shengri);
            oneRecord.addElement(jiaxiang);
            oneRecord.addElement(yuwendefeng);
            oneRecord.addElement(yingyudefeng);
            oneRecord.addElement(shuxuedefeng);
            oneRecord.addElement(totalDefeng);
            data.addElement(oneRecord);
        }
        return data;
    }
}
