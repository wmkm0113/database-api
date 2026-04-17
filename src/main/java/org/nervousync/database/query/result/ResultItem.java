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

import java.io.Serializable;

/**
 * <h2 class="en-US">Query result data defines</h2>
 * <h2 class="zh-CN">查询结果项定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
@XmlType(name = "result_item", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ResultItem implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -8186067805766488838L;

	/**
	 * <span class="en-US">Label name</span>
	 * <span class="zh-CN">标签名</span>
	 */
	@XmlElement(name = "label_name")
	private String labelName;
	/**
	 * <span class="en-US">Value of the data column</span>
	 * <span class="zh-CN">数据列的值</span>
	 */
	@XmlElement
	private Object value;

	/**
	 * <h3 class="en-US">Constructor method for the query result data defines</h3>
	 * <h3 class="zh-CN">查询结果项定义的构造方法</h3>
	 */
	public ResultItem() {
	}

	/**
	 * <h3 class="en-US">Getter method for the label name</h3>
	 * <h3 class="zh-CN">标签名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Label name</span>
	 * <span class="zh-CN">标签名</span>
	 */
	public String getLabelName() {
		return this.labelName;
	}

	/**
	 * <h3 class="en-US">Setter method for the label name</h3>
	 * <h3 class="zh-CN">标签名的 Setter 方法</h3>
	 *
	 * @param labelName <span class="en-US">Label name</span>
	 *                  <span class="zh-CN">标签名</span>
	 */
	public void setLabelName(final String labelName) {
		this.labelName = labelName;
	}

	/**
	 * <h3 class="en-US">Getter method for the value of the data column</h3>
	 * <h3 class="zh-CN">数据列的值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Value of the data column</span>
	 * <span class="zh-CN">数据列的值</span>
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * <h3 class="en-US">Setter method for the value of the data column</h3>
	 * <h3 class="zh-CN">数据列的值的 Setter 方法</h3>
	 *
	 * @param value <span class="en-US">Value of the data column</span>
	 *              <span class="zh-CN">数据列的值</span>
	 */
	public void setValue(final Object value) {
		this.value = value;
	}
}
