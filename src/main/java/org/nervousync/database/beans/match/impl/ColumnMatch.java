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

package org.nervousync.database.beans.match.impl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.nervousync.database.beans.match.BaseMatch;
import org.nervousync.database.enumerations.MatchType;

/**
 * <h2 class="en-US">Data column match the target data column information</h2>
 * <h2 class="zh-CN">数据列匹配数据列信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 30, 2026 10:06:27 $
 */
@XmlType(name = "column_match_value", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ColumnMatch extends BaseMatch {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 6421659569120624593L;

	/**
	 * <span class="en-US">Target data table name</span>
	 * <span class="zh-CN">目标数据表名</span>
	 */
	@XmlElement(name = "target_table")
	private String targetTable;
	/**
	 * <span class="en-US">Target data column name</span>
	 * <span class="zh-CN">目标数据列名</span>
	 */
	@XmlElement(name = "target_column")
	private String targetColumn;

	/**
	 * <h3 class="en-US">Constructor method for the data column match the target data column information</h3>
	 * <h3 class="zh-CN">数据列匹配数据列信息的构造方法</h3>
	 */
	public ColumnMatch() {
		super(MatchType.COLUMN);
	}

	/**
	 * <h3 class="en-US">Getter method for the target data table name</h3>
	 * <h3 class="zh-CN">目标数据表名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Target data table name</span>
	 * <span class="zh-CN">目标数据表名</span>
	 */
	public String getTargetTable() {
		return this.targetTable;
	}

	/**
	 * <h3 class="en-US">Setter method for the target data table name</h3>
	 * <h3 class="zh-CN">目标数据表名的 Setter 方法</h3>
	 *
	 * @param targetTable <span class="en-US">Target data table name</span>
	 *                    <span class="zh-CN">目标数据表名</span>
	 */
	public void setTargetTable(final String targetTable) {
		this.targetTable = targetTable;
	}

	/**
	 * <h3 class="en-US">Getter method for the target data column name</h3>
	 * <h3 class="zh-CN">目标数据列名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Target data column name</span>
	 * <span class="zh-CN">目标数据列名</span>
	 */
	public String getTargetColumn() {
		return this.targetColumn;
	}

	/**
	 * <h3 class="en-US">Setter method for the target data column name</h3>
	 * <h3 class="zh-CN">目标数据列名的 Setter 方法</h3>
	 *
	 * @param targetColumn <span class="en-US">Target data column name</span>
	 *                     <span class="zh-CN">目标数据列名</span>
	 */
	public void setTargetColumn(final String targetColumn) {
		this.targetColumn = targetColumn;
	}
}
