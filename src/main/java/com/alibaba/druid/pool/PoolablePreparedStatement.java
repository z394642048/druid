/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.pool;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import com.alibaba.druid.pool.PreparedStatementPool.MethodType;

/**
 * @author wenshao<szujobs@hotmail.com>
 */
public class PoolablePreparedStatement extends PoolableStatement implements PreparedStatement {

    private PreparedStatement          stmt;
    private final PreparedStatementKey key;

    public PoolablePreparedStatement(PoolableConnection conn, PreparedStatement stmt, PreparedStatementKey key){
        super(conn, stmt);
        this.stmt = stmt;
        this.key = key;
    }

    public PreparedStatementKey getKey() {
        return key;
    }

    public PreparedStatement getRawPreparedStatement() {
        return stmt;
    }

    public PreparedStatement getRawStatement() {
        return stmt;
    }

    @Override
    public void close() throws SQLException {
        if (isClosed()) {
            return;
        }

        conn.closePoolableStatement(this);
    }

    void closeInternal() throws SQLException {
        super.close();
    }

    void setClosed(boolean value) {
        this.closed = value;
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery();

            PoolableResultSet poolableResultSet = new PoolableResultSet(this, rs);
            resultSetTrace.add(poolableResultSet);

            return poolableResultSet;
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public int executeUpdate() throws SQLException {
        try {
            return stmt.executeUpdate();
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        try {
            stmt.setNull(parameterIndex, sqlType);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        try {
            stmt.setBoolean(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setByte(int parameterIndex, byte x) throws SQLException {
        try {
            stmt.setByte(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setShort(int parameterIndex, short x) throws SQLException {
        try {
            stmt.setShort(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setInt(int parameterIndex, int x) throws SQLException {
        try {
            stmt.setInt(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setLong(int parameterIndex, long x) throws SQLException {
        try {
            stmt.setLong(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setFloat(int parameterIndex, float x) throws SQLException {
        try {
            stmt.setFloat(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setDouble(int parameterIndex, double x) throws SQLException {
        try {
            stmt.setDouble(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        try {
            stmt.setBigDecimal(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setString(int parameterIndex, String x) throws SQLException {
        try {
            stmt.setString(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        try {
            stmt.setBytes(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setDate(int parameterIndex, Date x) throws SQLException {
        try {
            stmt.setDate(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setTime(int parameterIndex, Time x) throws SQLException {
        try {
            stmt.setTime(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        try {
            stmt.setTimestamp(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        try {
            stmt.setAsciiStream(parameterIndex, x, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    @Deprecated
    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        try {
            stmt.setUnicodeStream(parameterIndex, x, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        try {
            stmt.setBinaryStream(parameterIndex, x, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void clearParameters() throws SQLException {
        try {
            stmt.clearParameters();
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        try {
            stmt.setObject(parameterIndex, x, targetSqlType);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setObject(int parameterIndex, Object x) throws SQLException {
        try {
            stmt.setObject(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public boolean execute() throws SQLException {
        try {
            return stmt.execute();
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void addBatch() throws SQLException {
        try {
            stmt.addBatch();
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        try {
            stmt.setCharacterStream(parameterIndex, reader, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setRef(int parameterIndex, Ref x) throws SQLException {
        try {
            stmt.setRef(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        try {
            stmt.setBlob(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setClob(int parameterIndex, Clob x) throws SQLException {
        try {
            stmt.setClob(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setArray(int parameterIndex, Array x) throws SQLException {
        try {
            stmt.setArray(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        try {
            return stmt.getMetaData();
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        try {
            stmt.setDate(parameterIndex, x, cal);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        try {
            stmt.setTime(parameterIndex, x, cal);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        try {
            stmt.setTimestamp(parameterIndex, x, cal);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        try {
            stmt.setNull(parameterIndex, sqlType, typeName);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setURL(int parameterIndex, URL x) throws SQLException {
        try {
            stmt.setURL(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public ParameterMetaData getParameterMetaData() throws SQLException {
        try {
            return stmt.getParameterMetaData();
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        try {
            stmt.setRowId(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setNString(int parameterIndex, String value) throws SQLException {
        try {
            stmt.setNString(parameterIndex, value);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
        try {
            stmt.setNCharacterStream(parameterIndex, value, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setNClob(int parameterIndex, NClob value) throws SQLException {
        try {
            stmt.setNClob(parameterIndex, value);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
        try {
            stmt.setClob(parameterIndex, reader, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
        try {
            stmt.setBlob(parameterIndex, inputStream, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
        try {
            stmt.setNClob(parameterIndex, reader, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
        try {
            stmt.setSQLXML(parameterIndex, xmlObject);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
        try {
            stmt.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
        try {
            stmt.setAsciiStream(parameterIndex, x, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
        try {
            stmt.setBinaryStream(parameterIndex, x, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
        try {
            stmt.setCharacterStream(parameterIndex, reader, length);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
        try {
            stmt.setAsciiStream(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
        try {
            stmt.setBinaryStream(parameterIndex, x);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        try {
            stmt.setCharacterStream(parameterIndex, reader);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
        try {
            stmt.setNCharacterStream(parameterIndex, value);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setClob(int parameterIndex, Reader reader) throws SQLException {
        try {
            stmt.setClob(parameterIndex, reader);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
        try {
            stmt.setBlob(parameterIndex, inputStream);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    @Override
    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
        try {
            stmt.setNClob(parameterIndex, reader);
        } catch (Throwable t) {
            throw checkException(t);
        }
    }

    static class PreparedStatementKey {

        protected final String     sql;
        protected final String     catalog;

        protected final MethodType methodType;

        PreparedStatementKey(String sql, String catalog, MethodType methodType){
            if (sql == null) {
                throw new IllegalArgumentException("sql is null");
            }

            this.sql = sql;
            this.catalog = catalog;
            this.methodType = methodType;
        }

        public boolean equals(Object object) {
            PreparedStatementKey that = (PreparedStatementKey) object;

            if (!this.sql.equals(that.sql)) {
                return false;
            }

            if (this.catalog == null) {
                if (that.catalog != null) {
                    return false;
                }
            } else {
                if (!this.catalog.equals(that.catalog)) {
                    return false;
                }
            }

            if (!this.sql.equals(that.sql)) {
                return false;
            }

            if (this.methodType != that.methodType) {
                return false;
            }

            return true;
        }

        public int hashCode() {
            int catalogHashCode = catalog == null ? 0 : catalog.hashCode();
            int sqlHashCode = sql.hashCode();

            return sqlHashCode ^ catalogHashCode;
        }
    }
}
