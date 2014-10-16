package com.hossain.asif.main.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asif.hossain on 9/18/14.
 */
public class DatabaseTemplate {
    public static void execute(String query) {
        Connection conToUse = null;
        Statement stmt = null;
        try {

            conToUse = DatabaseConnectionPool.getConnection();
            stmt = conToUse.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {
                closeConnection(conToUse);
                throw new RuntimeException(e);
            }


        }
    }

    public static <E> List<E> executeQueryForObject(ObjectRowMapper<E> objectRowMapper, String query, Object... objects) {

        PreparedStatement preparedStatement = createPreparedStatement(query,objects);
        ResultSet resultSet =null;
        List<E> listOfE = new ArrayList<E>();
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listOfE.add(objectRowMapper.mapRowToObject(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        return listOfE;
    }

    public static void executeInsertQuery(String query, Object... parameters) {
        PreparedStatement preparedStatement = createPreparedStatement(query,parameters);
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private static PreparedStatement createPreparedStatement(String query,Object... parameters) {
        Connection conToUse;
        PreparedStatement preparedStatement = null;

        try {
            conToUse = DatabaseConnectionPool.getConnection();
            preparedStatement = conToUse.prepareStatement(query);
            int i = 1;
            for (Object parameter : parameters) {
                if (parameter instanceof String) {
                    preparedStatement.setString(i, (String) parameter);
                } else if (parameter instanceof Integer) {
                    preparedStatement.setInt(i, (Integer) parameter);
                } else if (parameter instanceof Long) {
                    preparedStatement.setLong(i, (Long) parameter);
                } else if (parameter instanceof Float) {
                    preparedStatement.setFloat(i, (Float) parameter);
                } else if (parameter instanceof Double) {
                    preparedStatement.setDouble(i, (Double) parameter);
                } else if (parameter instanceof Date) {
                    preparedStatement.setDate(i, (Date) parameter);
                } else if (parameter instanceof Blob) {
                    preparedStatement.setBlob(i, (Blob) parameter);
                }
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return preparedStatement;
    }

    private static void closeConnection(Connection conToClose) {
        try {
            conToClose.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
