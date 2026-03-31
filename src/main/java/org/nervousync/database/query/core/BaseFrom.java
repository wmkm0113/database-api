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
import jakarta.xml.bind.annotation.*;
import org.nervousync.database.beans.WrapperImpl;
import org.nervousync.database.enumerations.CategoryType;
import org.nervousync.database.query.from.FromQuery;
import org.nervousync.database.query.from.FromTable;
import org.nervousync.database.query.join.QueryJoin;
import org.nervousync.database.query.join.TableJoin;

import java.util.List;

/**
 * <h2 class="en-US">Abstract query from definition</h2>
 * <h2 class="zh-CN">抽象查询来源信息定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 11:30:54 $
 */
@XmlSeeAlso({FromTable.class, FromQuery.class})
@XmlTransient
@XmlAccessorType(XmlAccessType.NONE)
public abstract class BaseFrom extends WrapperImpl {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 6062648738775104298L;

	/**
	 * <span class="en-US">Enumeration value of the query from type</span>
	 * <span class="zh-CN">查询来源类型的枚举值</span>
	 */
	@JsonIgnore
	private final CategoryType categoryType;
	/**
	 * <span class="en-US">Item alias name</span>
	 * <span class="zh-CN">查询项别名</span>
	 */
	@XmlElement(name = "alias_name")
	private String aliasName;
	/**
	 * <span class="en-US">Related query information list</span>
	 * <span class="zh-CN">关联查询信息列表</span>
	 */
	@XmlElementRefs({
			@XmlElementRef(name = "table_join", type = TableJoin.class),
			@XmlElementRef(name = "query_join", type = QueryJoin.class),

	})
	@XmlElementWrapper(name = "join_list")
	private List<BaseJoin> joinList;

	/**
	 * <h3 class="en-US">Protect constructor method for the abstract query from definition</h3>
	 * <h3 class="zh-CN">抽象查询来源信息定义的构造方法</h3>
	 *
	 * @param categoryType <span class="en-US">Enumeration value of the query from type</span>
	 *                     <span class="zh-CN">查询来源类型的枚举值</span>
	 */
	protected BaseFrom(final CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	/**
	 * <h3 class="en-US">Getter method for the enumeration value of the query from type</h3>
	 * <h3 class="zh-CN">查询来源类型的枚举值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Enumeration value of the query from type</span>
	 * <span class="zh-CN">查询来源类型的枚举值</span>
	 */
	public CategoryType getCategoryType() {
		return this.categoryType;
	}

	/**
	 * <h3 class="en-US">Getter method for alias name</h3>
	 * <h3 class="zh-CN">别名的Getter方法</h3>
	 *
	 * @return <span class="en-US">Alias name</span>
	 * <span class="zh-CN">别名</span>
	 */
	public final String getAliasName() {
		return aliasName;
	}

	/**
	 * <h3 class="en-US">Setter method for alias name</h3>
	 * <h3 class="zh-CN">别名的Setter方法</h3>
	 *
	 * @param aliasName <span class="en-US">Alias name</span>
	 *                  <span class="zh-CN">别名</span>
	 */
	public final void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	/**
	 * <h3 class="en-US">Getter method for the related query information list</h3>
	 * <h3 class="zh-CN">关联查询信息列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Related query information list</span>
	 * <span class="zh-CN">关联查询信息列表</span>
	 */
	public List<BaseJoin> getJoinList() {
		return this.joinList;
	}

	/**
	 * <h3 class="en-US">Setter method for the related query information list</h3>
	 * <h3 class="zh-CN">关联查询信息列表的 Setter 方法</h3>
	 *
	 * @param joinList <span class="en-US">Related query information list</span>
	 *                 <span class="zh-CN">关联查询信息列表</span>
	 */
	public void setJoinList(final List<BaseJoin> joinList) {
		this.joinList = joinList;
	}
}
