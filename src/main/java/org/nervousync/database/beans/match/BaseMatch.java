/*
 * Licensed to the Nervousync Studio (NSYC) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.nervousync.database.beans.match;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import org.nervousync.database.beans.WrapperImpl;
import org.nervousync.database.enumerations.ConditionCode;
import org.nervousync.database.enumerations.ConnectionCode;
import org.nervousync.database.enumerations.MatchType;

import java.io.Serializable;
import java.sql.Types;

/**
 * <h2 class="en-US">Data column match information</h2>
 * <h2 class="zh-CN">数据列匹配信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 30, 2026 10:06:27 $
 */
@XmlTransient
@XmlAccessorType(XmlAccessType.NONE)
public abstract class BaseMatch extends WrapperImpl implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 2328804426652973165L;

	/**
	 * <span class="en-US">Enumeration value of the match type</span>
	 * <span class="zh-CN">匹配类型枚举值</span>
	 */
	@JsonIgnore
	private final MatchType matchType;
	/**
	 * <span class="en-US">Query connection code</span>
	 * <span class="zh-CN">查询条件连接代码</span>
	 */
	@XmlElement(name = "connection_code")
	private ConnectionCode connectionCode;
	/**
	 * <span class="en-US">Query condition code</span>
	 * <span class="zh-CN">查询条件运算代码</span>
	 */
	@XmlElement(name = "condition_code")
	private ConditionCode conditionCode = ConditionCode.EQUAL_THAN;
	/**
	 * <span class="en-US">Data table name</span>
	 * <span class="zh-CN">数据表名</span>
	 */
	@XmlElement(name = "table_name")
	private String tableName;
	/**
	 * <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	@XmlElement(name = "column_name")
	private String columnName;
	/**
	 * <span class="en-US">Jdbc type code</span>
	 * <span class="zh-CN">JDBC类型代码</span>
	 */
	@XmlElement(name = "jdbc_type")
	private int jdbcType = Types.NULL;
	/**
	 * <span class="en-US">Function name</span>
	 * <span class="zh-CN">函数名</span>
	 */
	@XmlElement(name = "function_name")
	private String functionName = null;

	/**
	 * <h3 class="en-US">Constructor method for the data column match information</h3>
	 * <h3 class="zh-CN">数据列匹配信息的构造方法</h3>
	 *
	 * @param matchType <span class="en-US">Enumeration value of the match type</span>
	 *                  <span class="zh-CN">匹配类型枚举值</span>
	 */
	protected BaseMatch(final MatchType matchType) {
		this.matchType = matchType;
	}

	/**
	 * <h3 class="en-US">Getter method for the enumeration value of the match type</h3>
	 * <h3 class="zh-CN">匹配类型枚举值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Enumeration value of the match type</span>
	 * <span class="zh-CN">匹配类型枚举值</span>
	 */
	public MatchType getMatchType() {
		return this.matchType;
	}

	/**
	 * <h3 class="en-US">Getter method for the query connection code</h3>
	 * <h3 class="zh-CN">查询条件连接代码的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Query connection code</span>
	 * <span class="zh-CN">查询条件连接代码</span>
	 */
	public final ConnectionCode getConnectionCode() {
		return this.connectionCode;
	}

	/**
	 * <h3 class="en-US">Setter method for the query connection code</h3>
	 * <h3 class="zh-CN">查询条件连接代码的 Setter 方法</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 */
	public final void setConnectionCode(final ConnectionCode connectionCode) {
		this.connectionCode = connectionCode;
	}

	/**
	 * <h3 class="en-US">Getter method for the query condition code</h3>
	 * <h3 class="zh-CN">查询条件运算代码的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Query condition code</span>
	 * <span class="zh-CN">查询条件运算代码</span>
	 */
	public ConditionCode getConditionCode() {
		return this.conditionCode;
	}

	/**
	 * <h3 class="en-US">Setter method for the query condition code</h3>
	 * <h3 class="zh-CN">查询条件运算代码的 Setter 方法</h3>
	 *
	 * @param conditionCode <span class="en-US">Query condition code</span>
	 *                      <span class="zh-CN">查询条件运算代码</span>
	 */
	public void setConditionCode(final ConditionCode conditionCode) {
		this.conditionCode = conditionCode;
	}

	/**
	 * <h3 class="en-US">Getter method for the data table name</h3>
	 * <h3 class="zh-CN">数据表名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data table name</span>
	 * <span class="zh-CN">数据表名</span>
	 */
	public final String getTableName() {
		return this.tableName;
	}

	/**
	 * <h3 class="en-US">Setter method for the data table name</h3>
	 * <h3 class="zh-CN">数据表名的 Setter 方法</h3>
	 *
	 * @param tableName <span class="en-US">Data table name</span>
	 *                  <span class="zh-CN">数据表名</span>
	 */
	public final void setTableName(final String tableName) {
		this.tableName = tableName;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column name</h3>
	 * <h3 class="zh-CN">数据列名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	public final String getColumnName() {
		return this.columnName;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column name</h3>
	 * <h3 class="zh-CN">数据列名的 Setter 方法</h3>
	 *
	 * @param columnName <span class="en-US">Data column name</span>
	 *                   <span class="zh-CN">数据列名</span>
	 */
	public final void setColumnName(final String columnName) {
		this.columnName = columnName;
	}

	/**
	 * <h3 class="en-US">Getter method for the JDBC type code</h3>
	 * <h3 class="zh-CN">JDBC类型代码的Getter方法</h3>
	 *
	 * @return <span class="en-US">JDBC type code</span>
	 * <span class="zh-CN">JDBC类型代码</span>
	 */
	public final int getJdbcType() {
		return this.jdbcType;
	}

	/**
	 * <h3 class="en-US">Setter method for the JDBC type code</h3>
	 * <h3 class="zh-CN">JDBC类型代码的Setter方法</h3>
	 *
	 * @param jdbcType <span class="en-US">Jdbc type code</span>
	 *                 <span class="zh-CN">JDBC类型代码</span>
	 */
	public final void setJdbcType(final int jdbcType) {
		this.jdbcType = jdbcType;
	}

	/**
	 * <h3 class="en-US">Getter method for function name</h3>
	 * <h3 class="zh-CN">函数名的Getter方法</h3>
	 *
	 * @return <span class="en-US">Function name</span>
	 * <span class="zh-CN">函数名</span>
	 */
	public final String getFunctionName() {
		return this.functionName;
	}

	/**
	 * <h3 class="en-US">Setter method for function name</h3>
	 * <h3 class="zh-CN">函数名的Setter方法</h3>
	 *
	 * @param functionName <span class="en-US">Function name</span>
	 *                     <span class="zh-CN">函数名</span>
	 */
	public final void setFunctionName(final String functionName) {
		this.functionName = functionName;
	}
}
