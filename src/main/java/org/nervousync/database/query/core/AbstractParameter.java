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

package org.nervousync.database.query.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlTransient;
import org.nervousync.database.beans.WrapperImpl;
import org.nervousync.database.enumerations.ItemType;
import org.nervousync.database.query.param.*;

/**
 * <h2 class="en-US">Abstract class for parameter information define</h2>
 * <h2 class="zh-CN">参数信息定义抽象类</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 11:42:46 $
 */
@XmlSeeAlso({ArraysParameter.class, CalculateParameter.class, ColumnParameter.class, ConstantParameter.class, FunctionParameter.class, SubQueryParameter.class, RangesParameter.class})
@XmlTransient
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractParameter extends WrapperImpl {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 3637722387304256057L;

	/**
	 * <span class="en-US">Parameter type</span>
	 * <span class="zh-CN">参数类型</span>
	 */
	@JsonIgnore
	private final ItemType itemType;

	/**
	 * <h3 class="en-US">Protect constructor method for abstract class for parameter information define</h3>
	 * <h3 class="zh-CN">参数信息定义抽象类的构造方法</h3>
	 *
	 * @param itemType <span class="en-US">Parameter type</span>
	 *                 <span class="zh-CN">参数类型</span>
	 */
	protected AbstractParameter(final ItemType itemType) {
		this.itemType = itemType;
	}

	/**
	 * <h3 class="en-US">Getter method for parameter type</h3>
	 * <h3 class="zh-CN">参数类型的Getter方法</h3>
	 *
	 * @return <span class="en-US">Parameter type</span>
	 * <span class="zh-CN">参数类型</span>
	 */
	public final ItemType getItemType() {
		return this.itemType;
	}
}
