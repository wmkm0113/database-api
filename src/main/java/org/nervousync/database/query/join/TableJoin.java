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

package org.nervousync.database.query.join;

import jakarta.xml.bind.annotation.*;
import org.nervousync.database.enumerations.CategoryType;
import org.nervousync.database.query.core.BaseJoin;

/**
 * <h2 class="en-US">Query join data table information defines</h2>
 * <h2 class="zh-CN">查询关联数据表信息定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Jul 30, 2023 15:57:33 $
 */
@XmlType(name = "table_join", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "table_join", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class TableJoin extends BaseJoin {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 412944345751923906L;

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
	 * <h3 class="en-US">Constructor method for the query join data table information defines</h3>
	 * <h3 class="zh-CN">查询关联数据表信息定义的构造方法</h3>
	 */
	public TableJoin() {
		super(CategoryType.Table);
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
	 * <h3 class="en-US">Getter method for the data table name</h3>
	 * <h3 class="zh-CN">数据表名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data table name</span>
	 * <span class="zh-CN">数据表名</span>
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * <h3 class="en-US">Setter method for the data table name</h3>
	 * <h3 class="zh-CN">数据表名的 Setter 方法</h3>
	 *
	 * @param tableName <span class="en-US">Data table name</span>
	 *                  <span class="zh-CN">数据表名</span>
	 */
	public void setTableName(final String tableName) {
		this.tableName = tableName;
	}
}
