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
 * <h2 class="en-US">Ranges data parameter information define</h2>
 * <h2 class="zh-CN">范围值参数定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 18:02:27 $
 */
@XmlType(name = "ranges_parameter", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class RangesParameter extends BaseParameter {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 654320131256596275L;

	/**
	 * <span class="en-US">Begin value</span>
	 * <span class="zh-CN">起始值</span>
	 */
	@XmlElement(name = "begin_value")
	private Object beginValue;
	/**
	 * <span class="en-US">End value</span>
	 * <span class="zh-CN">终止值</span>
	 */
	@XmlElement(name = "end_value")
	private Object endValue;

	/**
	 * <h3 class="en-US">Constructor method for ranges data parameter information define</h3>
	 * <h3 class="zh-CN">范围值参数定义的构造方法</h3>
	 */
	public RangesParameter() {
		super(ItemType.RANGE);
	}

	/**
	 * <h3 class="en-US">Constructor method for ranges data parameter information define</h3>
	 * <h3 class="zh-CN">范围值参数定义的构造方法</h3>
	 *
	 * @param beginValue <span class="en-US">Begin value</span>
	 *                   <span class="zh-CN">起始值</span>
	 * @param endValue   <span class="en-US">End value</span>
	 *                   <span class="zh-CN">终止值</span>
	 */
	public RangesParameter(final Object beginValue, final Object endValue) {
		super(ItemType.RANGE);
		this.beginValue = beginValue;
		this.endValue = endValue;
	}

	/**
	 * <h3 class="en-US">Getter method for begin value</h3>
	 * <h3 class="zh-CN">起始值的Getter方法</h3>
	 *
	 * @return <span class="en-US">Begin value</span>
	 * <span class="zh-CN">起始值</span>
	 */
	public Object getBeginValue() {
		return this.beginValue;
	}

	/**
	 * <h3 class="en-US">Setter method for begin value</h3>
	 * <h3 class="zh-CN">起始值的Setter方法</h3>
	 *
	 * @param beginValue <span class="en-US">Begin value</span>
	 *                   <span class="zh-CN">起始值</span>
	 */
	public void setBeginValue(final Object beginValue) {
		this.beginValue = beginValue;
	}

	/**
	 * <h3 class="en-US">Getter method for end value</h3>
	 * <h3 class="zh-CN">终止值的Getter方法</h3>
	 *
	 * @return <span class="en-US">End value</span>
	 * <span class="zh-CN">终止值</span>
	 */
	public Object getEndValue() {
		return this.endValue;
	}

	/**
	 * <h3 class="en-US">Setter method for end value</h3>
	 * <h3 class="zh-CN">终止值的Setter方法</h3>
	 *
	 * @param endValue <span class="en-US">End value</span>
	 *                 <span class="zh-CN">终止值</span>
	 */
	public void setEndValue(final Object endValue) {
		this.endValue = endValue;
	}
}
