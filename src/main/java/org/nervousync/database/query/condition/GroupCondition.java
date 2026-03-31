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
import org.nervousync.database.query.core.BaseCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Query column condition information group define</h2>
 * <h2 class="zh-CN">查询匹配条件组定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 19:12:02 $
 */
@XmlType(name = "group_condition", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "group_condition", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class GroupCondition extends BaseCondition {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 2863865753436845711L;

	/**
	 * <span class="en-US">Match condition list</span>
	 * <span class="zh-CN">匹配条件列表</span>
	 */
	@XmlElements({
			@XmlElement(name = "column_condition", type = ColumnCondition.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "group_condition", type = GroupCondition.class, namespace = "https://nervousync.org/schemas/database")
	})
	@XmlElementWrapper(name = "condition_list")
	private List<BaseCondition> conditionList = new ArrayList<>();

	/**
	 * <h3 class="en-US">Constructor method for the query column condition information group define</h3>
	 * <h3 class="zh-CN">查询匹配条件组定义的构造方法</h3>
	 */
	public GroupCondition() {
		super(ConditionType.GROUP);
	}

	/**
	 * <h3 class="en-US">Getter method for the match condition list</h3>
	 * <h3 class="zh-CN">匹配条件列表的Getter方法</h3>
	 *
	 * @return <span class="en-US">Match condition list</span>
	 * <span class="zh-CN">匹配条件列表</span>
	 */
	public List<BaseCondition> getConditionList() {
		return conditionList;
	}

	/**
	 * <h3 class="en-US">Setter method for the match condition list</h3>
	 * <h3 class="zh-CN">匹配条件列表的Setter方法</h3>
	 *
	 * @param conditionList <span class="en-US">Match condition list</span>
	 *                      <span class="zh-CN">匹配条件列表</span>
	 */
	public void setConditionList(List<BaseCondition> conditionList) {
		this.conditionList = conditionList;
	}
}
