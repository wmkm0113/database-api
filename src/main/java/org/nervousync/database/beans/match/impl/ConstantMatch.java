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
 * <h2 class="en-US">Data column match constant value information</h2>
 * <h2 class="zh-CN">数据列匹配固定值信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 30, 2026 10:06:27 $
 */
@XmlType(name = "column_constant_value", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ConstantMatch extends BaseMatch {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -2465556413457909462L;

	/**
	 * <span class="en-US">Function name of the match value</span>
	 * <span class="zh-CN">匹配值函数名</span>
	 */
	@XmlElement(name = "match_function")
	private String matchFunction = null;
	/**
	 * <span class="en-US">Match value</span>
	 * <span class="zh-CN">匹配值</span>
	 */
	@XmlElement(name = "match_value")
	private Object matchValue;

	/**
	 * <h3 class="en-US">Constructor method for the constant match define</h3>
	 * <h3 class="zh-CN">常量匹配定义的构造方法</h3>
	 */
	public ConstantMatch() {
		super(MatchType.CONSTANT);
	}

	/**
	 * <h3 class="en-US">Getter method for the function name of the match value</h3>
	 * <h3 class="zh-CN">匹配值函数名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Function name of the match value</span>
	 * <span class="zh-CN">匹配值函数名</span>
	 */
	public String getMatchFunction() {
		return this.matchFunction;
	}

	/**
	 * <h3 class="en-US">Setter method for the function name of the match value</h3>
	 * <h3 class="zh-CN">匹配值函数名的 Setter 方法</h3>
	 *
	 * @param matchFunction <span class="en-US">Function name of the match value</span>
	 *                      <span class="zh-CN">匹配值函数名</span>
	 */
	public void setMatchFunction(final String matchFunction) {
		this.matchFunction = matchFunction;
	}

	/**
	 * <h3 class="en-US">Getter method for the match value</h3>
	 * <h3 class="zh-CN">匹配值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Match value</span>
	 * <span class="zh-CN">匹配值</span>
	 */
	public Object getMatchValue() {
		return this.matchValue;
	}

	/**
	 * <h3 class="en-US">Setter method for the match value</h3>
	 * <h3 class="zh-CN">匹配值的 Setter 方法</h3>
	 *
	 * @param matchValue <span class="en-US">Match value</span>
	 *                   <span class="zh-CN">匹配值</span>
	 */
	public void setMatchValue(final Object matchValue) {
		this.matchValue = matchValue;
	}
}
