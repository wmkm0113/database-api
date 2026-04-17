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

package org.nervousync.database.beans;

import jakarta.xml.bind.annotation.*;
import org.nervousync.database.query.core.AbstractParameter;
import org.nervousync.database.query.param.*;

import java.io.Serializable;

/**
 * <h2 class="en-US">Data column assignment information</h2>
 * <h2 class="zh-CN">数据列赋值信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 30, 2026 10:06:27 $
 */
@XmlType(name = "column_value", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ColumnValue implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 7668672222249736535L;

	/**
	 * <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	@XmlElement(name = "column_name")
	private String name;
	/**
	 * <span class="en-US">Condition parameter information</span>
	 * <span class="zh-CN">匹配参数信息</span>
	 */
	@XmlElements({
			@XmlElement(name = "calculate_parameter", type = CalculateParameter.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "column_parameter", type = ColumnParameter.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "constant_parameter", type = ConstantParameter.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "function_parameter", type = FunctionParameter.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "query_parameter", type = SubQueryParameter.class, namespace = "https://nervousync.org/schemas/database")
	})
	private AbstractParameter parameter;

	/**
	 * <h3 class="en-US">Constructor method for the data column assignment information</h3>
	 * <h3 class="zh-CN">数据列赋值信息的构造方法</h3>
	 */
	public ColumnValue() {
	}

	/**
	 * <h3 class="en-US">Getter method for the data column name</h3>
	 * <h3 class="zh-CN">数据列名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column name</h3>
	 * <h3 class="zh-CN">数据列名的 Setter 方法</h3>
	 *
	 * @param name <span class="en-US">Data column name</span>
	 *             <span class="zh-CN">数据列名</span>
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * <h3 class="en-US">Getter method for the condition parameter information</h3>
	 * <h3 class="zh-CN">匹配参数信息的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Condition parameter information</span>
	 * <span class="zh-CN">匹配参数信息</span>
	 */
	public AbstractParameter getParameter() {
		return this.parameter;
	}

	/**
	 * <h3 class="en-US">Setter method for the condition parameter information</h3>
	 * <h3 class="zh-CN">匹配参数信息的 Setter 方法</h3>
	 *
	 * @param parameter <span class="en-US">Condition parameter information</span>
	 *                  <span class="zh-CN">匹配参数信息</span>
	 */
	public void setParameter(final AbstractParameter parameter) {
		this.parameter = parameter;
	}
}
