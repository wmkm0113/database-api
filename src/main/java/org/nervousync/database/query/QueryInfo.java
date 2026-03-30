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

package org.nervousync.database.query;

import jakarta.annotation.Nonnull;
import jakarta.xml.bind.annotation.*;
import org.nervousync.database.query.condition.ColumnCondition;
import org.nervousync.database.query.condition.GroupCondition;
import org.nervousync.database.query.core.BaseCondition;
import org.nervousync.database.query.core.BaseFrom;
import org.nervousync.database.query.core.BaseItem;
import org.nervousync.database.query.from.FromQuery;
import org.nervousync.database.query.from.FromTable;
import org.nervousync.database.query.group.GroupColumn;
import org.nervousync.database.query.item.*;
import org.nervousync.database.query.order.OrderColumn;
import org.nervousync.database.query.pager.PageLimit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Query information defines</h2>
 * <h2 class="zh-CN">查询信息定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
@XmlRootElement(name = "query_info", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class QueryInfo implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 549973159743148887L;

	/**
	 * <span class="en-US">Query item instance list</span>
	 * <span class="zh-CN">查询项目实例对象列表</span>
	 */
	@Nonnull
	@XmlElements({
			@XmlElement(name = "calculate_item", type = CalculateItem.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "column_item", type = ColumnItem.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "constant_item", type = ConstantItem.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "function_item", type = FunctionItem.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "sub_query_item", type = SubQueryItem.class, namespace = "https://nervousync.org/schemas/database")
	})
	@XmlElementWrapper(name = "item_list")
	private List<BaseItem> queryItems = new ArrayList<>();
	/**
	 * <span class="en-US">Query from information</span>
	 * <span class="zh-CN">查询来源信息</span>
	 */
	@XmlElements({
			@XmlElement(name = "from_sub_query", type = FromQuery.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "from_table", type = FromTable.class, namespace = "https://nervousync.org/schemas/database")
	})
	private BaseFrom queryFrom;
	/**
	 * <span class="en-US">Query condition instance list</span>
	 * <span class="zh-CN">查询条件实例对象列表</span>
	 */
	@XmlElements({
			@XmlElement(name = "column_condition", type = ColumnCondition.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "group_condition", type = GroupCondition.class, namespace = "https://nervousync.org/schemas/database")
	})
	@XmlElementWrapper(name = "condition_list")
	private List<BaseCondition> whereClause;
	/**
	 * <span class="en-US">Identify key</span>
	 * <span class="zh-CN">分组识别代码列表</span>
	 */
	@XmlElement(name = "group_column", type = GroupColumn.class, namespace = "https://nervousync.org/schemas/database")
	@XmlElementWrapper(name = "group_list")
	private List<GroupColumn> groupByColumns;
	/**
	 * <span class="en-US">Group having condition instance list</span>
	 * <span class="zh-CN">分组筛选条件实例对象列表</span>
	 */
	@XmlElements({
			@XmlElement(name = "column_condition", type = ColumnCondition.class, namespace = "https://nervousync.org/schemas/database"),
			@XmlElement(name = "group_condition", type = GroupCondition.class, namespace = "https://nervousync.org/schemas/database")
	})
	@XmlElementWrapper(name = "condition_list")
	private List<BaseCondition> havingClause;
	/**
	 * <span class="en-US">Query order by columns' list</span>
	 * <span class="zh-CN">查询排序数据列列表</span>
	 */
	@XmlElement(name = "order_column", type = OrderColumn.class, namespace = "https://nervousync.org/schemas/database")
	@XmlElementWrapper(name = "order_list")
	private List<OrderColumn> orderByColumns;
	/**
	 * <span class="en-US">Query pager information</span>
	 * <span class="zh-CN">查询分页信息</span>
	 */
	@XmlElement(name = "page_limit")
	private PageLimit pageLimit;

	/**
	 * <h3 class="en-US">Constructor method for query information define</h3>
	 * <h3 class="zh-CN">查询条件信息的构造方法</h3>
	 */
	public QueryInfo() {
	}

	/**
	 * <h3 class="en-US">Getter method for the query item instance list</h3>
	 * <h3 class="zh-CN">查询项目实例对象列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Query item instance list</span>
	 * <span class="zh-CN">查询项目实例对象列表</span>
	 */
	@Nonnull
	public List<BaseItem> getQueryItems() {
		return this.queryItems;
	}

	/**
	 * <h3 class="en-US">Setter method for the query item instance list</h3>
	 * <h3 class="zh-CN">查询项目实例对象列表的 Setter 方法</h3>
	 *
	 * @param queryItems <span class="en-US">Query item instance list</span>
	 *                   <span class="zh-CN">查询项目实例对象列表</span>
	 */
	public void setQueryItems(@Nonnull final List<BaseItem> queryItems) {
		this.queryItems = queryItems;
	}

	/**
	 * <h3 class="en-US">Getter method for the query from information</h3>
	 * <h3 class="zh-CN">查询来源信息的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Query from information</span>
	 * <span class="zh-CN">查询来源信息</span>
	 */
	public BaseFrom getQueryFrom() {
		return this.queryFrom;
	}

	/**
	 * <h3 class="en-US">Setter method for the query from information</h3>
	 * <h3 class="zh-CN">查询来源信息的 Setter 方法</h3>
	 *
	 * @param queryFrom <span class="en-US">Query from information</span>
	 *                  <span class="zh-CN">查询来源信息</span>
	 */
	public void setQueryFrom(final BaseFrom queryFrom) {
		this.queryFrom = queryFrom;
	}

	/**
	 * <h3 class="en-US">Getter method for the query condition instance list</h3>
	 * <h3 class="zh-CN">查询条件实例对象列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Query condition instance list</span>
	 * <span class="zh-CN">查询条件实例对象列表</span>
	 */
	public List<BaseCondition> getWhereClause() {
		return this.whereClause;
	}

	/**
	 * <h3 class="en-US">Setter method for the query condition instance list</h3>
	 * <h3 class="zh-CN">查询条件实例对象列表的 Setter 方法</h3>
	 *
	 * @param whereClause <span class="en-US">Query condition instance list</span>
	 *                    <span class="zh-CN">查询条件实例对象列表</span>
	 */
	public void setWhereClause(final List<BaseCondition> whereClause) {
		this.whereClause = whereClause;
	}

	/**
	 * <h3 class="en-US">Getter method for the group by column information list</h3>
	 * <h3 class="zh-CN">分组数据列信息列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Group by column information list</span>
	 * <span class="zh-CN">分组数据列信息列表</span>
	 */
	public List<GroupColumn> getGroupByColumns() {
		return this.groupByColumns;
	}

	/**
	 * <h3 class="en-US">Setter method for the group by column information list</h3>
	 * <h3 class="zh-CN">分组数据列信息列表的 Setter 方法</h3>
	 *
	 * @param groupByColumns <span class="en-US">Group by column information list</span>
	 *                       <span class="zh-CN">分组数据列信息列表</span>
	 */
	public void setGroupByColumns(final List<GroupColumn> groupByColumns) {
		this.groupByColumns = groupByColumns;
	}

	/**
	 * <h3 class="en-US">Getter method for the group having condition instance lists</h3>
	 * <h3 class="zh-CN">分组筛选条件实例对象列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Group having condition instance list</span>
	 * <span class="zh-CN">分组筛选条件实例对象列表</span>
	 */
	public List<BaseCondition> getHavingClause() {
		return this.havingClause;
	}

	/**
	 * <h3 class="en-US">Setter method for the group having condition instance lists</h3>
	 * <h3 class="zh-CN">分组筛选条件实例对象列表的 Setter 方法</h3>
	 *
	 * @param havingClause <span class="en-US">Group having condition instance list</span>
	 *                     <span class="zh-CN">分组筛选条件实例对象列表</span>
	 */
	public void setHavingClause(final List<BaseCondition> havingClause) {
		this.havingClause = havingClause;
	}

	/**
	 * <h3 class="en-US">Getter method for the query order by columns' list</h3>
	 * <h3 class="zh-CN">查询排序数据列列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Query order by columns' list</span>
	 * <span class="zh-CN">查询排序数据列列表</span>
	 */
	public List<OrderColumn> getOrderByColumns() {
		return this.orderByColumns;
	}

	/**
	 * <h3 class="en-US">Setter method for the query order by columns' list</h3>
	 * <h3 class="zh-CN">查询排序数据列列表的 Setter 方法</h3>
	 *
	 * @param orderByColumns <span class="en-US">Query order by columns' list</span>
	 *                       <span class="zh-CN">查询排序数据列列表</span>
	 */
	public void setOrderByColumns(final List<OrderColumn> orderByColumns) {
		this.orderByColumns = orderByColumns;
	}

	/**
	 * <h3 class="en-US">Getter method for the query pager information</h3>
	 * <h3 class="zh-CN">查询分页信息的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Query pager information</span>
	 * <span class="zh-CN">查询分页信息</span>
	 */
	public PageLimit getPageLimit() {
		return this.pageLimit;
	}

	/**
	 * <h3 class="en-US">Setter method for the query pager information</h3>
	 * <h3 class="zh-CN">查询分页信息的 Setter 方法</h3>
	 *
	 * @param pageLimit <span class="en-US">Query pager information</span>
	 *                  <span class="zh-CN">查询分页信息</span>
	 */
	public void setPageLimit(final PageLimit pageLimit) {
		this.pageLimit = pageLimit;
	}
}
