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

package org.nervousync.database.query.condition;

import jakarta.xml.bind.annotation.*;
import org.nervousync.database.enumerations.ConditionType;
import org.nervousync.database.query.QueryInfo;
import org.nervousync.database.query.core.AbstractCondition;

/**
 * <h2 class="en-US">EXIST or NOT EXIST condition information</h2>
 * <h2 class="zh-CN">EXIST 或 NOT EXIST查询信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 23, 2026 20:10:21 $
 */
@XmlType(name = "exist_condition", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "exist_condition", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ExistCondition extends AbstractCondition {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -4924421033357706688L;

	/**
	 * <span class="en-US">NOT prefix</span>
	 * <span class="zh-CN">NOT前缀</span>
	 */
	@XmlElement
	private boolean not = Boolean.FALSE;
	/**
	 * <span class="en-US">Sub-query information</span>
	 * <span class="zh-CN">子查询信息</span>
	 */
	@XmlElement(name = "sub_query")
	private QueryInfo queryInfo;

	/**
	 * <h3 class="en-US">Constructor method for the EXIST or NOT EXIST condition information</h3>
	 * <h3 class="zh-CN">EXIST 或 NOT EXIST查询信息的构造方法</h3>
	 */
	public ExistCondition() {
		super(ConditionType.EXIST);
	}

	/**
	 * <h3 class="en-US">Getter method for the NOT prefix</h3>
	 * <h3 class="zh-CN">NOT前缀的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">NOT prefix</span>
	 * <span class="zh-CN">NOT前缀</span>
	 */
	public boolean isNot() {
		return this.not;
	}

	/**
	 * <h3 class="en-US">Setter method for the NOT prefix</h3>
	 * <h3 class="zh-CN">NOT前缀的 Setter 方法</h3>
	 *
	 * @param not <span class="en-US">NOT prefix</span>
	 *            <span class="zh-CN">NOT前缀</span>
	 */
	public void setNot(final boolean not) {
		this.not = not;
	}

	/**
	 * <h3 class="en-US">Getter method for the sub-query information</h3>
	 * <h3 class="zh-CN">子查询信息的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Sub-query information</span>
	 * <span class="zh-CN">子查询信息</span>
	 */
	public QueryInfo getQueryInfo() {
		return this.queryInfo;
	}

	/**
	 * <h3 class="en-US">Setter method for the sub-query information</h3>
	 * <h3 class="zh-CN">子查询信息的 Setter 方法</h3>
	 *
	 * @param queryInfo <span class="en-US">Sub-query information</span>
	 *                  <span class="zh-CN">子查询信息</span>
	 */
	public void setQueryInfo(final QueryInfo queryInfo) {
		this.queryInfo = queryInfo;
	}
}
