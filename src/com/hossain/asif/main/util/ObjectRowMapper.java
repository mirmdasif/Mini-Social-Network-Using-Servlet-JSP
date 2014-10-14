package com.hossain.asif.main.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by asif.hossain on 9/18/14.
 */
public interface ObjectRowMapper <E>{
    E mapRowToObject(ResultSet resultSet) throws SQLException;
}
