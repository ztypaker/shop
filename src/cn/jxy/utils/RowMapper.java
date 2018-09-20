package cn.jxy.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
//为每个方法定制一个ROWMAPPER
public interface RowMapper<T> {
    public abstract T mapRow(ResultSet arg0) throws SQLException;
}
