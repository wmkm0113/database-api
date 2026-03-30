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
 * <h2 class="en-US">Data table define</h2>
 * <h2 class="zh-CN">数据表定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 24, 2026 09:24:27 $
 */
@XmlType(name = "table_define", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "table_define", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class TableDefine implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -4170836751088930868L;

	/**
	 * <span class="en-US">Data column define information list</span>
	 * <span class="zh-CN">数据列定义信息列表</span>
	 */
	@Nonnull
	@XmlElement(name = "column_define")
	@XmlElementWrapper(name = "column_list")
	private List<ColumnDefine> columnDefines = new ArrayList<>();
	/**
	 * <span class="en-US">Index define information list</span>
	 * <span class="zh-CN">索引定义信息列表</span>
	 */
	@Nonnull
	@XmlElement(name = "index_define")
	@XmlElementWrapper(name = "index_list")
	private List<IndexDefine> indexDefines = new ArrayList<>();

	/**
	 * <h3 class="en-US">Constructor method for data table define</h3>
	 * <h3 class="zh-CN">数据表定义的构造方法</h3>
	 */
	public TableDefine() {
	}

	/**
	 * <h3 class="en-US">Getter method for the data column define information list</h3>
	 * <h3 class="zh-CN">数据列定义信息列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column define information list</span>
	 * <span class="zh-CN">数据列定义信息列表</span>
	 */
	@Nonnull
	public List<ColumnDefine> getColumnDefines() {
		return this.columnDefines;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column define information list</h3>
	 * <h3 class="zh-CN">数据列定义信息列表的 Setter 方法</h3>
	 *
	 * @param columnDefines <span class="en-US">Data column define information list</span>
	 *                      <span class="zh-CN">数据列定义信息列表</span>
	 */
	public void setColumnDefines(final List<ColumnDefine> columnDefines) {
		this.columnDefines = (columnDefines == null) ? Collections.emptyList() : columnDefines;
	}

	/**
	 * <h3 class="en-US">Getter method for the index define information list</h3>
	 * <h3 class="zh-CN">索引定义信息列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Index define information list</span>
	 * <span class="zh-CN">索引定义信息列表</span>
	 */
	@Nonnull
	public List<IndexDefine> getIndexDefines() {
		return this.indexDefines;
	}

	/**
	 * <h3 class="en-US">Setter method for the index define information list</h3>
	 * <h3 class="zh-CN">索引定义信息列表的 Setter 方法</h3>
	 *
	 * @param indexDefines <span class="en-US">Index define information list</span>
	 *                     <span class="zh-CN">索引定义信息列表</span>
	 */
	public void setIndexDefines(final List<IndexDefine> indexDefines) {
		this.indexDefines = (indexDefines == null) ? Collections.emptyList() : indexDefines;
	}
}
