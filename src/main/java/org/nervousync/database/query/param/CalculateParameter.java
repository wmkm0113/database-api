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
import org.nervousync.database.query.item.CalculateItem;

/**
 * <h2 class="en-US">Calculate data parameter information define</h2>
 * <h2 class="zh-CN">计算值参数定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 18:05:28 $
 */
@XmlType(name = "calculate_parameter", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "calculate_parameter", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class CalculateParameter extends BaseParameter {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 7516729127131470411L;

	/**
	 * <span class="en-US">Calculate result value information</span>
	 * <span class="zh-CN">计算结果值信息</span>
	 */
	@XmlElement(name = "calculate_item")
	private CalculateItem calculateItem;

	/**
	 * <h3 class="en-US">Protect constructor method for abstract class for parameter information define</h3>
	 * <h3 class="zh-CN">参数信息定义抽象类的构造方法</h3>
	 */
	public CalculateParameter() {
		super(ItemType.CALCULATE);
	}

	/**
	 * <h3 class="en-US">Getter method for the calculate result value information</h3>
	 * <h3 class="zh-CN">计算结果值信息的 Getter 方法</h3>
	 *
	 * @return
	 * <span class="en-US">Calculate result value information</span>
	 * <span class="zh-CN">计算结果值信息</span>
	 */
	public CalculateItem getCalculateItem() {
		return this.calculateItem;
	}

	/**
	 * <h3 class="en-US">Setter method for the calculate result value information</h3>
	 * <h3 class="zh-CN">计算结果值信息的 Setter 方法</h3>
	 *
	 * @param calculateItem
	 * <span class="en-US">Calculate result value information</span>
	 * <span class="zh-CN">计算结果值信息</span>
	 */
	public void setCalculateItem(final CalculateItem calculateItem) {
		this.calculateItem = calculateItem;
	}
}
