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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;

/**
 * <h2 class="en-US">Data column rename define</h2>
 * <h2 class="zh-CN">数据列重命名定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 24, 2026 09:31:19 $
 */
@XmlType(name = "column_rename", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ColumnRename implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -9210908657114297388L;

	/**
	 * <span class="en-US">Old column name</span>
	 * <span class="zh-CN">旧列名</span>
	 */
	private String oldName;
	/**
	 * <span class="en-US">New column name</span>
	 * <span class="zh-CN">新列名</span>
	 */
	private String newName;

	/**
	 * <h3 class="en-US">Constructor method for the data column rename define</h3>
	 * <h3 class="zh-CN">数据列重命名定义的构造方法</h3>
	 */
	public ColumnRename() {
	}

	/**
	 * <h3 class="en-US">Getter method for the old column name</h3>
	 * <h3 class="zh-CN">旧列名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Old column name</span>
	 * <span class="zh-CN">旧列名</span>
	 */
	public String getOldName() {
		return this.oldName;
	}

	/**
	 * <h3 class="en-US">Setter method for the old column name</h3>
	 * <h3 class="zh-CN">旧列名的 Setter 方法</h3>
	 *
	 * @param oldName <span class="en-US">Old column name</span>
	 *                <span class="zh-CN">旧列名</span>
	 */
	public void setOldName(final String oldName) {
		this.oldName = oldName;
	}

	/**
	 * <h3 class="en-US">Getter method for the new column name</h3>
	 * <h3 class="zh-CN">新列名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">New column name</span>
	 * <span class="zh-CN">新列名</span>
	 */
	public String getNewName() {
		return this.newName;
	}

	/**
	 * <h3 class="en-US">Setter method for the new column name</h3>
	 * <h3 class="zh-CN">新列名的 Setter 方法</h3>
	 *
	 * @param newName <span class="en-US">New column name</span>
	 *                <span class="zh-CN">新列名</span>
	 */
	public void setNewName(final String newName) {
		this.newName = newName;
	}
}
