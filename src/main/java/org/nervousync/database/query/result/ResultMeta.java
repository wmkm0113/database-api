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

package org.nervousync.database.query.result;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.intellij.lang.annotations.MagicConstant;
import org.nervousync.commons.Globals;

import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.sql.Types;

/**
 * <h2 class="en-US">Query result data column meta information</h2>
 * <h2 class="zh-CN">查询结果数据列元数据</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 12:07:36 $
 */
@XmlType(name = "result_meta", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ResultMeta implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -5902635950652896684L;

	/**
	 * <span class="en-US">Auto increment flag</span>
	 * <span class="zh-CN">自增长标记</span>
	 */
	@XmlElement(name = "auto_increment")
	private boolean autoIncrement = false;
	/**
	 * <span class="en-US">Case sensitive flag</span>
	 * <span class="zh-CN">区分大小写标记</span>
	 */
	@XmlElement(name = "case_sensitive")
	private boolean caseSensitive = false;
	/**
	 * <span class="en-US">Using for search data flag</span>
	 * <span class="zh-CN">用于检索数据标记</span>
	 */
	@XmlElement
	private boolean searchable = false;
	/**
	 * <span class="en-US">Currency flag</span>
	 * <span class="zh-CN">货币类型标记</span>
	 */
	@XmlElement
	private boolean currency = false;
	/**
	 * <span class="en-US">Signed data value flag</span>
	 * <span class="zh-CN">数据值带符号标记</span>
	 */
	@XmlElement
	private boolean signed = false;
	/**
	 * <span class="en-US">Read-only flag</span>
	 * <span class="zh-CN">只读标记</span>
	 */
	@XmlElement(name = "read_only")
	private boolean readOnly = true;
	/**
	 * <span class="en-US">Data writable flag</span>
	 * <span class="zh-CN">数据可写标记</span>
	 */
	@XmlElement
	private boolean writable = false;
	/**
	 * <span class="en-US">Flag indicating successful data write</span>
	 * <span class="zh-CN">数据一定写成功标记</span>
	 */
	@XmlElement(name = "definitely_writable")
	private boolean definitelyWritable = false;
	/**
	 * <span class="en-US">Data column null value marker</span>
	 * <span class="zh-CN">数据列 Null 值标记</span>
	 */
	@XmlElement
	@MagicConstant(valuesFromClass = ResultSetMetaData.class)
	private int nullable = ResultSetMetaData.columnNullableUnknown;
	/**
	 * <span class="en-US">Display data length</span>
	 * <span class="zh-CN">显示的数据长度</span>
	 */
	@XmlElement(name = "display_size")
	private int displaySize = Globals.DEFAULT_VALUE_INT;
	/**
	 * <span class="en-US">JDBC type code of the data column</span>
	 * <span class="zh-CN">数据列的 JDBC 类型代码</span>
	 */
	@XmlElement(name = "column_type")
	private int columnType = Types.OTHER;
	/**
	 * <span class="en-US">Data column precision</span>
	 * <span class="zh-CN">数据列精度</span>
	 */
	@XmlElement
	private int precision = Globals.DEFAULT_VALUE_INT;
	/**
	 * <span class="en-US">Number of decimal places</span>
	 * <span class="zh-CN">数据精度小数位数</span>
	 */
	@XmlElement
	private int scale = Globals.DEFAULT_VALUE_INT;
	/**
	 * <span class="en-US">Data column alias name</span>
	 * <span class="zh-CN">数据列别名</span>
	 */
	@XmlElement(name = "column_label")
	private String columnLabel = null;
	/**
	 * <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	@XmlElement(name = "column_name")
	private String columnName = null;
	/**
	 * <span class="en-US">Database schema name</span>
	 * <span class="zh-CN">数据库架构名称</span>
	 */
	@XmlElement(name = "schema_name")
	private String schemaName = null;
	/**
	 * <span class="en-US">Data table name</span>
	 * <span class="zh-CN">数据表名称</span>
	 */
	@XmlElement(name = "table_name")
	private String tableName = null;
	/**
	 * <span class="en-US">Database catalog name</span>
	 * <span class="zh-CN">数据库目录名称</span>
	 */
	@XmlElement(name = "category_name")
	private String catalogName = null;
	/**
	 * <span class="en-US">SQL type string</span>
	 * <span class="zh-CN">SQL 类型字符串</span>
	 */
	@XmlElement(name = "type_name")
	private String typeName = null;
	/**
	 * <span class="en-US">Java class name</span>
	 * <span class="zh-CN">Java 类名</span>
	 */
	@XmlElement(name = "class_name")
	private String className = null;

	public ResultMeta() {
	}

	/**
	 * <h3 class="en-US">Getter method for the auto increment flag</h3>
	 * <h3 class="zh-CN">自增长标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Auto increment flag</span>
	 * <span class="zh-CN">自增长标记</span>
	 */
	public boolean isAutoIncrement() {
		return this.autoIncrement;
	}

	/**
	 * <h3 class="en-US">Setter method for the auto increment flag</h3>
	 * <h3 class="zh-CN">自增长标记的 Setter 方法</h3>
	 *
	 * @param autoIncrement <span class="en-US">Auto increment flag</span>
	 *                      <span class="zh-CN">自增长标记</span>
	 */
	public void setAutoIncrement(final boolean autoIncrement) {
		this.autoIncrement = autoIncrement;
	}

	/**
	 * <h3 class="en-US">Getter method for the case-sensitive flag</h3>
	 * <h3 class="zh-CN">区分大小写标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Case-sensitive flag</span>
	 * <span class="zh-CN">区分大小写标记</span>
	 */
	public boolean isCaseSensitive() {
		return this.caseSensitive;
	}

	/**
	 * <h3 class="en-US">Setter method for the case-sensitive flag</h3>
	 * <h3 class="zh-CN">区分大小写标记的 Setter 方法</h3>
	 *
	 * @param caseSensitive <span class="en-US">Case-sensitive flag</span>
	 *                      <span class="zh-CN">区分大小写标记</span>
	 */
	public void setCaseSensitive(final boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	/**
	 * <h3 class="en-US">Getter method for the using for search data flag</h3>
	 * <h3 class="zh-CN">用于检索数据标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Using for search data flag</span>
	 * <span class="zh-CN">用于检索数据标记</span>
	 */
	public boolean isSearchable() {
		return this.searchable;
	}

	/**
	 * <h3 class="en-US">Setter method for the using for search data flag</h3>
	 * <h3 class="zh-CN">用于检索数据标记的 Setter 方法</h3>
	 *
	 * @param searchable <span class="en-US">Using for search data flag</span>
	 *                   <span class="zh-CN">用于检索数据标记</span>
	 */
	public void setSearchable(final boolean searchable) {
		this.searchable = searchable;
	}

	/**
	 * <h3 class="en-US">Getter method for the currency flag</h3>
	 * <h3 class="zh-CN">货币类型标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Currency flag</span>
	 * <span class="zh-CN">货币类型标记</span>
	 */
	public boolean isCurrency() {
		return this.currency;
	}

	/**
	 * <h3 class="en-US">Setter method for the currency flag</h3>
	 * <h3 class="zh-CN">货币类型标记的 Setter 方法</h3>
	 *
	 * @param currency <span class="en-US">Currency flag</span>
	 *                 <span class="zh-CN">货币类型标记</span>
	 */
	public void setCurrency(final boolean currency) {
		this.currency = currency;
	}

	/**
	 * <h3 class="en-US">Getter method for the signed data value flag</h3>
	 * <h3 class="zh-CN">数据值带符号标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Signed data value flag</span>
	 * <span class="zh-CN">数据值带符号标记</span>
	 */
	public boolean isSigned() {
		return this.signed;
	}

	/**
	 * <h3 class="en-US">Setter method for the signed data value flag</h3>
	 * <h3 class="zh-CN">数据值带符号标记的 Setter 方法</h3>
	 *
	 * @param signed <span class="en-US">Signed data value flag</span>
	 *               <span class="zh-CN">数据值带符号标记</span>
	 */
	public void setSigned(final boolean signed) {
		this.signed = signed;
	}

	/**
	 * <h3 class="en-US">Getter method for the read-only flag</h3>
	 * <h3 class="zh-CN">只读标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Read-only flag</span>
	 * <span class="zh-CN">只读标记</span>
	 */
	public boolean isReadOnly() {
		return this.readOnly;
	}

	/**
	 * <h3 class="en-US">Setter method for the read-only flag</h3>
	 * <h3 class="zh-CN">只读标记的 Setter 方法</h3>
	 *
	 * @param readOnly <span class="en-US">Read-only flag</span>
	 *                 <span class="zh-CN">只读标记</span>
	 */
	public void setReadOnly(final boolean readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * <h3 class="en-US">Getter method for the data writable flag</h3>
	 * <h3 class="zh-CN">数据可写标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data writable flag</span>
	 * <span class="zh-CN">数据可写标记</span>
	 */
	public boolean isWritable() {
		return this.writable;
	}

	/**
	 * <h3 class="en-US">Setter method for the data writable flag</h3>
	 * <h3 class="zh-CN">数据可写标记的 Setter 方法</h3>
	 *
	 * @param writable <span class="en-US">Data writable flag</span>
	 *                 <span class="zh-CN">数据可写标记</span>
	 */
	public void setWritable(final boolean writable) {
		this.writable = writable;
	}

	/**
	 * <h3 class="en-US">Getter method for the flag indicating successful data write</h3>
	 * <h3 class="zh-CN">数据一定写成功标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Flag indicating successful data write</span>
	 * <span class="zh-CN">数据一定写成功标记</span>
	 */
	public boolean isDefinitelyWritable() {
		return this.definitelyWritable;
	}

	/**
	 * <h3 class="en-US">Setter method for the flag indicating successful data write</h3>
	 * <h3 class="zh-CN">数据一定写成功标记的 Setter 方法</h3>
	 *
	 * @param definitelyWritable <span class="en-US">Flag indicating successful data write</span>
	 *                           <span class="zh-CN">数据一定写成功标记</span>
	 */
	public void setDefinitelyWritable(final boolean definitelyWritable) {
		this.definitelyWritable = definitelyWritable;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column null value marker</h3>
	 * <h3 class="zh-CN">数据列 Null 值标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column null value marker</span>
	 * <span class="zh-CN">数据列 Null 值标记</span>
	 */
	@MagicConstant(valuesFromClass = ResultSetMetaData.class)
	public int getNullable() {
		return this.nullable;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column null value marker</h3>
	 * <h3 class="zh-CN">数据列 Null 值标记的 Setter 方法</h3>
	 *
	 * @param nullable <span class="en-US">Data column null value marker</span>
	 *                 <span class="zh-CN">数据列 Null 值标记</span>
	 */
	public void setNullable(@MagicConstant(valuesFromClass = ResultSetMetaData.class) final int nullable) {
		this.nullable = nullable;
	}

	/**
	 * <h3 class="en-US">Getter method for the display data length</h3>
	 * <h3 class="zh-CN">显示的数据长度的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Display data length</span>
	 * <span class="zh-CN">显示的数据长度</span>
	 */
	public int getDisplaySize() {
		return this.displaySize;
	}

	/**
	 * <h3 class="en-US">Setter method for the display data length</h3>
	 * <h3 class="zh-CN">显示的数据长度的 Setter 方法</h3>
	 *
	 * @param displaySize <span class="en-US">Display data length</span>
	 *                    <span class="zh-CN">显示的数据长度</span>
	 */
	public void setDisplaySize(final int displaySize) {
		this.displaySize = displaySize;
	}

	/**
	 * <h3 class="en-US">Getter method for the JDBC type code of the data column</h3>
	 * <h3 class="zh-CN">数据列的 JDBC 类型代码的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">JDBC type code of the data column</span>
	 * <span class="zh-CN">数据列的 JDBC 类型代码</span>
	 */
	public int getColumnType() {
		return this.columnType;
	}

	/**
	 * <h3 class="en-US">Setter method for the JDBC type code of the data column</h3>
	 * <h3 class="zh-CN">数据列的 JDBC 类型代码的 Setter 方法</h3>
	 *
	 * @param columnType <span class="en-US">JDBC type code of the data column</span>
	 *                   <span class="zh-CN">数据列的 JDBC 类型代码</span>
	 */
	public void setColumnType(final int columnType) {
		this.columnType = columnType;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column precision</h3>
	 * <h3 class="zh-CN">数据列精度的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column precision</span>
	 * <span class="zh-CN">数据列精度</span>
	 */
	public int getPrecision() {
		return this.precision;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column precision</h3>
	 * <h3 class="zh-CN">数据列精度的 Setter 方法</h3>
	 *
	 * @param precision <span class="en-US">Data column precision</span>
	 *                  <span class="zh-CN">数据列精度</span>
	 */
	public void setPrecision(final int precision) {
		this.precision = precision;
	}

	/**
	 * <h3 class="en-US">Getter method for the number of decimal places</h3>
	 * <h3 class="zh-CN">数据精度小数位数的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Number of decimal places</span>
	 * <span class="zh-CN">数据精度小数位数</span>
	 */
	public int getScale() {
		return this.scale;
	}

	/**
	 * <h3 class="en-US">Setter method for the number of decimal places</h3>
	 * <h3 class="zh-CN">数据精度小数位数的 Setter 方法</h3>
	 *
	 * @param scale <span class="en-US">Number of decimal places</span>
	 *              <span class="zh-CN">数据精度小数位数</span>
	 */
	public void setScale(final int scale) {
		this.scale = scale;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column alias name</h3>
	 * <h3 class="zh-CN">数据列别名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column alias name</span>
	 * <span class="zh-CN">数据列别名</span>
	 */
	public String getColumnLabel() {
		return this.columnLabel;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column alias name</h3>
	 * <h3 class="zh-CN">数据列别名的 Setter 方法</h3>
	 *
	 * @param columnLabel <span class="en-US">Data column alias name</span>
	 *                    <span class="zh-CN">数据列别名</span>
	 */
	public void setColumnLabel(final String columnLabel) {
		this.columnLabel = columnLabel;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column name</h3>
	 * <h3 class="zh-CN">数据列名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	public String getColumnName() {
		return this.columnName;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column name</h3>
	 * <h3 class="zh-CN">数据列名的 Setter 方法</h3>
	 *
	 * @param columnName <span class="en-US">Data column name</span>
	 *                   <span class="zh-CN">数据列名</span>
	 */
	public void setColumnName(final String columnName) {
		this.columnName = columnName;
	}

	/**
	 * <h3 class="en-US">Getter method for the database schema name</h3>
	 * <h3 class="zh-CN">数据库架构名称的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Database schema name</span>
	 * <span class="zh-CN">数据库架构名称</span>
	 */
	public String getSchemaName() {
		return this.schemaName;
	}

	/**
	 * <h3 class="en-US">Setter method for the database schema name</h3>
	 * <h3 class="zh-CN">数据库架构名称的 Setter 方法</h3>
	 *
	 * @param schemaName <span class="en-US">Database schema name</span>
	 *                   <span class="zh-CN">数据库架构名称</span>
	 */
	public void setSchemaName(final String schemaName) {
		this.schemaName = schemaName;
	}

	/**
	 * <h3 class="en-US">Getter method for the data table name</h3>
	 * <h3 class="zh-CN">数据表名称的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data table name</span>
	 * <span class="zh-CN">数据表名称</span>
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * <h3 class="en-US">Setter method for the data table name</h3>
	 * <h3 class="zh-CN">数据表名称的 Setter 方法</h3>
	 *
	 * @param tableName <span class="en-US">Data table name</span>
	 *                  <span class="zh-CN">数据表名称</span>
	 */
	public void setTableName(final String tableName) {
		this.tableName = tableName;
	}

	/**
	 * <h3 class="en-US">Getter method for the database catalog name</h3>
	 * <h3 class="zh-CN">数据库目录名称的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Database catalog name</span>
	 * <span class="zh-CN">数据库目录名称</span>
	 */
	public String getCatalogName() {
		return this.catalogName;
	}

	/**
	 * <h3 class="en-US">Setter method for the database catalog name</h3>
	 * <h3 class="zh-CN">数据库目录名称的 Setter 方法</h3>
	 *
	 * @param catalogName <span class="en-US">Database catalog name</span>
	 *                    <span class="zh-CN">数据库目录名称</span>
	 */
	public void setCatalogName(final String catalogName) {
		this.catalogName = catalogName;
	}

	/**
	 * <h3 class="en-US">Getter method for the SQL type string</h3>
	 * <h3 class="zh-CN">SQL 类型字符串的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">SQL type string</span>
	 * <span class="zh-CN">SQL 类型字符串</span>
	 */
	public String getTypeName() {
		return this.typeName;
	}

	/**
	 * <h3 class="en-US">Setter method for the SQL type string</h3>
	 * <h3 class="zh-CN">SQL 类型字符串的 Setter 方法</h3>
	 *
	 * @param typeName <span class="en-US">SQL type string</span>
	 *                 <span class="zh-CN">SQL 类型字符串</span>
	 */
	public void setTypeName(final String typeName) {
		this.typeName = typeName;
	}

	/**
	 * <h3 class="en-US">Getter method for the Java class name</h3>
	 * <h3 class="zh-CN">Java 类名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Java class name</span>
	 * <span class="zh-CN">Java 类名</span>
	 */
	public String getClassName() {
		return this.className;
	}

	/**
	 * <h3 class="en-US">Setter method for the Java class name</h3>
	 * <h3 class="zh-CN">Java 类名的 Setter 方法</h3>
	 *
	 * @param className <span class="en-US">Java class name</span>
	 *                  <span class="zh-CN">Java 类名</span>
	 */
	public void setClassName(final String className) {
		this.className = className;
	}
}
