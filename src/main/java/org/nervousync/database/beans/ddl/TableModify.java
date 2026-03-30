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

package org.nervousync.database.beans.ddl;

import jakarta.annotation.Nonnull;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h2 class="en-US">Data table modify define</h2>
 * <h2 class="zh-CN">数据表修改定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 24, 2026 09:24:27 $
 */
@XmlType(name = "table_modify", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "table_modify", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class TableModify implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -102888010443077098L;

	/**
	 * <span class="en-US">Add data column define information list</span>
	 * <span class="zh-CN">新增的数据列定义信息列表</span>
	 */
	@Nonnull
	@XmlElement(name = "column_define")
	@XmlElementWrapper(name = "add_column_list")
	private List<ColumnDefine> addColumns = new ArrayList<>();
	/**
	 * <span class="en-US">Modify data column define information list</span>
	 * <span class="zh-CN">修改的数据列定义信息列表</span>
	 */
	@Nonnull
	@XmlElement(name = "column_define")
	@XmlElementWrapper(name = "modify_column_list")
	private List<ColumnDefine> modifyColumns = new ArrayList<>();
	/**
	 * <span class="en-US">Rename data column define information list</span>
	 * <span class="zh-CN">重命名数据列定义信息列表</span>
	 */
	@Nonnull
	@XmlElement(name = "column_rename")
	@XmlElementWrapper(name = "rename_column_list")
	private List<ColumnRename> renameColumns = new ArrayList<>();
	/**
	 * <span class="en-US">Drop column name list</span>
	 * <span class="zh-CN">删除的数据列名列表</span>
	 */
	@Nonnull
	@XmlElement(name = "column_name")
	@XmlElementWrapper(name = "drop_column_list")
	private List<String> dropColumns = new ArrayList<>();

	/**
	 * <h3 class="en-US">Constructor method for the data table modify define</h3>
	 * <h3 class="zh-CN">数据表修改定义的构造方法</h3>
	 */
	public TableModify() {
	}

	/**
	 * <h3 class="en-US">Getter method for </h3>
	 * <h3 class="zh-CN">的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Add data column define information list</span>
	 * <span class="zh-CN">新增的数据列定义信息列表</span>
	 */
	@Nonnull
	public List<ColumnDefine> getAddColumns() {
		return this.addColumns;
	}

	/**
	 * <h3 class="en-US">Setter method for </h3>
	 * <h3 class="zh-CN">的 Setter 方法</h3>
	 *
	 * @param addColumns <span class="en-US">Add data column define information list</span>
	 *                   <span class="zh-CN">新增的数据列定义信息列表</span>
	 */
	public void setAddColumns(final List<ColumnDefine> addColumns) {
		this.addColumns = (addColumns == null) ? Collections.emptyList() : addColumns;
	}

	/**
	 * <h3 class="en-US">Getter method for </h3>
	 * <h3 class="zh-CN">的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Modify data column define information list</span>
	 * <span class="zh-CN">修改的数据列定义信息列表</span>
	 */
	@Nonnull
	public List<ColumnDefine> getModifyColumns() {
		return this.modifyColumns;
	}

	/**
	 * <h3 class="en-US">Setter method for </h3>
	 * <h3 class="zh-CN">的 Setter 方法</h3>
	 *
	 * @param modifyColumns <span class="en-US">Modify data column define information list</span>
	 *                      <span class="zh-CN">修改的数据列定义信息列表</span>
	 */
	public void setModifyColumns(final List<ColumnDefine> modifyColumns) {
		this.modifyColumns = (modifyColumns == null) ? Collections.emptyList() : modifyColumns;
	}

	/**
	 * <h3 class="en-US">Getter method for </h3>
	 * <h3 class="zh-CN">的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Rename data column define information list</span>
	 * <span class="zh-CN">重命名数据列定义信息列表</span>
	 */
	@Nonnull
	public List<ColumnRename> getRenameColumns() {
		return this.renameColumns;
	}

	/**
	 * <h3 class="en-US">Setter method for </h3>
	 * <h3 class="zh-CN">的 Setter 方法</h3>
	 *
	 * @param renameColumns <span class="en-US">Rename data column define information list</span>
	 *                      <span class="zh-CN">重命名数据列定义信息列表</span>
	 */
	public void setRenameColumns(final List<ColumnRename> renameColumns) {
		this.renameColumns = (renameColumns == null) ? Collections.emptyList() : renameColumns;
	}

	/**
	 * <h3 class="en-US">Getter method for </h3>
	 * <h3 class="zh-CN">的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Drop column name list</span>
	 * <span class="zh-CN">删除的数据列名列表</span>
	 */
	@Nonnull
	public List<String> getDropColumns() {
		return this.dropColumns;
	}

	/**
	 * <h3 class="en-US">Setter method for </h3>
	 * <h3 class="zh-CN">的 Setter 方法</h3>
	 *
	 * @param dropColumns <span class="en-US">Drop column name list</span>
	 *                    <span class="zh-CN">删除的数据列名列表</span>
	 */
	public void setDropColumns(final List<String> dropColumns) {
		this.dropColumns = (dropColumns == null) ? Collections.emptyList() : dropColumns;
	}
}
