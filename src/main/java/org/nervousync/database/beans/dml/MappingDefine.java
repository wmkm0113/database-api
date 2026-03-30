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

package org.nervousync.database.beans.dml;

import jakarta.xml.bind.annotation.*;
import org.nervousync.database.beans.ColumnValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Data information mapping table define</h2>
 * <h2 class="zh-CN">数据信息映射表定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 30, 2026 10:06:27 $
 */
@XmlRootElement(name = "mapping_define", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class MappingDefine implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -9035385119182722267L;

	/**
	 * <span class="en-US">Identify code</span>
	 * <span class="zh-CN">识别代码</span>
	 */
	@XmlElement(name = "identify_code")
	private long identifyCode;
	/**
	 * <span class="en-US">Data column assignment list</span>
	 * <span class="zh-CN">数据列赋值列表</span>
	 */
	@XmlElement(name = "column_value")
	@XmlElementWrapper(name = "column_value_list")
	private List<ColumnValue> columnValues;

	/**
	 * <h3 class="en-US">Constructor method for the insert data define</h3>
	 * <h3 class="zh-CN">新增数据定义的构造方法</h3>
	 */
	public MappingDefine() {
		this.columnValues = new ArrayList<>();
	}

	/**
	 * <h3 class="en-US">Getter method for the identify code</h3>
	 * <h3 class="zh-CN">识别代码的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Identify code</span>
	 * <span class="zh-CN">识别代码</span>
	 */
	public long getIdentifyCode() {
		return this.identifyCode;
	}

	/**
	 * <h3 class="en-US">Setter method for the identify code</h3>
	 * <h3 class="zh-CN">识别代码的 Setter 方法</h3>
	 *
	 * @param identifyCode <span class="en-US">Identify code</span>
	 *                     <span class="zh-CN">识别代码</span>
	 */
	public void setIdentifyCode(final long identifyCode) {
		this.identifyCode = identifyCode;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column assignment list</h3>
	 * <h3 class="zh-CN">数据列赋值列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column assignment list</span>
	 * <span class="zh-CN">数据列赋值列表</span>
	 */
	public List<ColumnValue> getColumnValues() {
		return this.columnValues;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column assignment list</h3>
	 * <h3 class="zh-CN">数据列赋值列表的 Setter 方法</h3>
	 *
	 * @param columnValues <span class="en-US">Data column assignment list</span>
	 *                     <span class="zh-CN">数据列赋值列表</span>
	 */
	public void setColumnValues(final List<ColumnValue> columnValues) {
		this.columnValues = columnValues;
	}
}
