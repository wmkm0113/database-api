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

package org.nervousync.database.query.param;

import jakarta.xml.bind.annotation.*;
import org.nervousync.database.enumerations.ItemType;
import org.nervousync.database.query.core.BaseParameter;

/**
 * <h2 class="en-US">Query column parameter information define</h2>
 * <h2 class="zh-CN">数据列参数定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 11:45:29 $
 */
@XmlType(name = "column_parameter", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "column_parameter", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ColumnParameter extends BaseParameter {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -42421588929491128L;

	/**
	 * <span class="en-US">Database name</span>
	 * <span class="zh-CN">数据库名</span>
	 */
	@XmlElement(name = "database_name")
	private String databaseName;
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
	 * <h3 class="en-US">Constructor method for query column parameter information define</h3>
	 * <h3 class="zh-CN">数据列参数定义的构造方法</h3>
	 */
	public ColumnParameter() {
		super(ItemType.COLUMN);
	}

	/**
	 * <h3 class="en-US">Constructor method for query column parameter information define</h3>
	 * <h3 class="zh-CN">数据列参数定义的构造方法</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 */
	public ColumnParameter(final String databaseName, final String tableName, final String columnName) {
		super(ItemType.COLUMN);
		this.databaseName = databaseName;
		this.tableName = tableName;
		this.columnName = columnName;
	}

	/**
	 * <h3 class="en-US">Getter method for the database name</h3>
	 * <h3 class="zh-CN">数据库名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Database name</span>
	 * <span class="zh-CN">数据库名</span>
	 */
	public String getDatabaseName() {
		return this.databaseName;
	}

	/**
	 * <h3 class="en-US">Setter method for the database name</h3>
	 * <h3 class="zh-CN">数据库名的 Setter 方法</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 */
	public void setDatabaseName(final String databaseName) {
		this.databaseName = databaseName;
	}

	/**
	 * <h3 class="en-US">Getter method for data table name</h3>
	 * <h3 class="zh-CN">数据表名的Getter方法</h3>
	 *
	 * @return <span class="en-US">Data table name</span>
	 * <span class="zh-CN">数据表名</span>
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * <h3 class="en-US">Setter method for data table name</h3>
	 * <h3 class="zh-CN">数据表名的Setter方法</h3>
	 *
	 * @param tableName <span class="en-US">Data table name</span>
	 *                  <span class="zh-CN">数据表名</span>
	 */
	public void setTableName(final String tableName) {
		this.tableName = tableName;
	}

	/**
	 * <h3 class="en-US">Getter method for data column name</h3>
	 * <h3 class="zh-CN">数据列名的Getter方法</h3>
	 *
	 * @return <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	public String getColumnName() {
		return this.columnName;
	}

	/**
	 * <h3 class="en-US">Setter method for data column name</h3>
	 * <h3 class="zh-CN">数据列名的Setter方法</h3>
	 *
	 * @param columnName <span class="en-US">Data column name</span>
	 *                   <span class="zh-CN">数据列名</span>
	 */
	public void setColumnName(final String columnName) {
		this.columnName = columnName;
	}
}
