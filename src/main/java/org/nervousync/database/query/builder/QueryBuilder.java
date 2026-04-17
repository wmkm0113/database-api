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

package org.nervousync.database.query.builder;

import jakarta.annotation.Nonnull;
import org.nervousync.builder.AbstractBuilder;
import org.nervousync.builder.ParentBuilder;
import org.nervousync.commons.Globals;
import org.nervousync.database.enumerations.OrderType;
import org.nervousync.database.exceptions.MultilingualSQLException;
import org.nervousync.database.query.QueryInfo;
import org.nervousync.database.query.core.AbstractCondition;
import org.nervousync.database.query.core.AbstractFrom;
import org.nervousync.database.query.core.AbstractItem;
import org.nervousync.database.query.group.GroupColumn;
import org.nervousync.database.query.order.OrderColumn;
import org.nervousync.database.query.pager.PageLimit;
import org.nervousync.exceptions.builder.BuilderException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <h2 class="en-US">Query information builder</h2>
 * <h2 class="zh-CN">查询信息构建器</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
public final class QueryBuilder<P extends ParentBuilder> extends AbstractBuilder<P, QueryInfo> {

	/**
	 * <span class="en-US">Query item instance list</span>
	 * <span class="zh-CN">查询项目实例对象列表</span>
	 */
	private List<AbstractItem> queryItems = new ArrayList<>();
	/**
	 * <span class="en-US">Query from information list</span>
	 * <span class="zh-CN">查询来源信息列表</span>
	 */
	private AbstractFrom queryFrom = null;
	/**
	 * <span class="en-US">Query condition instance list</span>
	 * <span class="zh-CN">查询条件实例对象列表</span>
	 */
	private List<AbstractCondition> whereClause = new ArrayList<>();
	/**
	 * <span class="en-US">Identify key</span>
	 * <span class="zh-CN">分组识别代码列表</span>
	 */
	private final List<GroupColumn> groupByColumns = new ArrayList<>();
	/**
	 * <span class="en-US">Group having condition instance list</span>
	 * <span class="zh-CN">分组筛选条件实例对象列表</span>
	 */
	private List<AbstractCondition> havingClause = new ArrayList<>();
	/**
	 * <span class="en-US">Query order by columns' list</span>
	 * <span class="zh-CN">查询排序数据列列表</span>
	 */
	private final List<OrderColumn> orderByColumns = new ArrayList<>();
	/**
	 * <span class="en-US">Query pager information</span>
	 * <span class="zh-CN">查询分页信息</span>
	 */
	private PageLimit pageLimit = null;

	/**
	 * <h3 class="en-US">Constructor method for the query information builder</h3>
	 * <h3 class="zh-CN">查询信息构建器的构造函数</h3>
	 */
	public QueryBuilder() {
		this(null);
	}

	/**
	 * <h3 class="en-US">Constructor method for the query information builder</h3>
	 * <h3 class="zh-CN">查询信息构建器的构造函数</h3>
	 */
	public QueryBuilder(final P parentBuilder) {
		super(parentBuilder);
	}

	/**
	 * <h3 class="en-US">Query items information list builder</h3>
	 * <h3 class="zh-CN">查询项目列表构建器</h3>
	 *
	 * @return <span class="en-US">Query items information list builder instance object</span>
	 * <span class="zh-CN">查询项目列表构建器实例对象</span>
	 */
	public ItemsBuilder<QueryBuilder<P>> items() {
		return new ItemsBuilder<>(this, this.queryItems);
	}

	/**
	 * <h3 class="en-US">Query from table information builder</h3>
	 * <h3 class="zh-CN">查询来源数据表信息构建器</h3>
	 *
	 * @param tableName <span class="en-US">Data table name</span>
	 *                  <span class="zh-CN">数据表名</span>
	 * @param aliasName <span class="en-US">Alias name</span>
	 *                  <span class="zh-CN">别名</span>
	 * @return <span class="en-US">Current builder instance object</span>
	 * <span class="zh-CN">当前构建器实例对象</span>
	 */
	public FromBuilder.FromTableBuilder<QueryBuilder<P>> fromTable(final String aliasName,
	                                                               final String databaseName, final String tableName) {
		return new FromBuilder.FromTableBuilder<>(this, aliasName, databaseName, tableName);
	}

	/**
	 * <h3 class="en-US">Query from table sub-query information builder</h3>
	 * <h3 class="zh-CN">查询来源子查询信息构建器</h3>
	 *
	 * @param aliasName <span class="en-US">Alias name</span>
	 *                  <span class="zh-CN">别名</span>
	 * @return <span class="en-US">Query from information list builder instance object</span>
	 * <span class="zh-CN">查询来源信息列表构建器实例对象</span>
	 */
	public FromBuilder.FromSubqueryBuilder<QueryBuilder<P>> fromSubquery(final String aliasName) {
		return new FromBuilder.FromSubqueryBuilder<>(this, aliasName);
	}

	/**
	 * <h3 class="en-US">Query group by information builder</h3>
	 * <h3 class="zh-CN">查询分组列信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Query group by information builder instance object</span>
	 * <span class="zh-CN">查询分组列信息构建器实例对象</span>
	 */
	public QueryBuilder<P> groupBy(@Nonnull final String databaseName, @Nonnull final String tableName,
	                               @Nonnull final String columnName) {
		if (this.groupByColumns.stream().noneMatch(exist -> exist.match(databaseName, tableName, columnName))) {
			this.groupByColumns.add(new GroupColumn(databaseName, tableName, columnName));
		}
		return this;
	}

	/**
	 * <h3 class="en-US">Query conditions information builder</h3>
	 * <h3 class="zh-CN">查询条件组构建器</h3>
	 *
	 * @return <span class="en-US">Query conditions information builder instance object</span>
	 * <span class="zh-CN">查询条件组构建器实例对象</span>
	 */
	public ConditionsBuilder<QueryBuilder<P>> where() {
		return new ConditionsBuilder<>(this, Boolean.FALSE, this.whereClause);
	}

	/**
	 * <h3 class="en-US">Query group by information builder</h3>
	 * <h3 class="zh-CN">查询分组列信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @param orderType    <span class="en-US">Query order type</span>
	 *                     <span class="zh-CN">查询结果集排序类型</span>
	 * @return <span class="en-US">Query group by information builder instance object</span>
	 * <span class="zh-CN">查询分组列信息构建器实例对象</span>
	 */
	public QueryBuilder<P> orderBy(@Nonnull final String databaseName, @Nonnull final String tableName,
	                               @Nonnull final String columnName, @Nonnull final OrderType orderType) {
		AtomicBoolean exist = new AtomicBoolean(false);
		this.orderByColumns.replaceAll(orderColumn -> {
			if (orderColumn.match(databaseName, tableName, columnName)) {
				orderColumn.setOrderType(orderType);
				exist.set(Boolean.TRUE);
			}
			return orderColumn;
		});
		if (!exist.get()) {
			this.orderByColumns.add(new OrderColumn(databaseName, tableName, columnName, orderType));
		}
		return this;
	}

	/**
	 * <h3 class="en-US">Having conditions information builder</h3>
	 * <h3 class="zh-CN">Having条件组构建器</h3>
	 *
	 * @return <span class="en-US">Having conditions information builder instance object</span>
	 * <span class="zh-CN">Having条件组构建器实例对象</span>
	 */
	public ConditionsBuilder<QueryBuilder<P>> having() {
		return new ConditionsBuilder<>(this, Boolean.TRUE, this.havingClause);
	}

	/**
	 * <h3 class="en-US">Setting for pager information</h3>
	 * <h3 class="zh-CN">设置分页信息</h3>
	 *
	 * @param pageNumber <span class="en-US">Current page number</span>
	 *                   <span class="zh-CN">当前页数</span>
	 * @param pageSize   <span class="en-US">Page limit records count</span>
	 *                   <span class="zh-CN">每页的记录数</span>
	 * @return <span class="en-US">Current builder instance object</span>
	 * <span class="zh-CN">当前构建器实例对象</span>
	 * @throws SQLException <span class="en-US">If the configuration information is invalid</span>
	 *                      <span class="zh-CN">如果配置信息错误</span>
	 */
	public QueryBuilder<P> pager(final int pageNumber, final int pageSize) throws SQLException {
		if (pageNumber <= Globals.INITIALIZE_INT_VALUE || pageSize <= Globals.INITIALIZE_INT_VALUE) {
			throw new MultilingualSQLException(0x00DB00000002L, pageNumber, pageSize);
		}
		if (this.pageLimit == null) {
			this.pageLimit = new PageLimit();
		}
		this.pageLimit.setPageNumber(pageNumber);
		this.pageLimit.setPageSize(pageSize);
		return this;
	}

	@Override
	public QueryInfo build() throws BuilderException {
		QueryInfo queryInfo = new QueryInfo();
		queryInfo.setQueryItems(this.queryItems);
		queryInfo.setQueryFrom(this.queryFrom);
		queryInfo.setWhereClause(this.whereClause);
		queryInfo.setGroupByColumns(this.groupByColumns);
		queryInfo.setHavingClause(this.havingClause);
		queryInfo.setOrderByColumns(this.orderByColumns);
		queryInfo.setPageLimit(this.pageLimit);
		return queryInfo;
	}

	@Override
	protected void confirm(final Object object) throws BuilderException {
		if (object instanceof ItemsBuilder.Items) {
			this.queryItems = ((ItemsBuilder.Items) object).getItemList();
		} else if (object instanceof AbstractFrom) {
			this.queryFrom = (AbstractFrom) object;
		} else if (object instanceof ConditionsBuilder.Conditions) {
			ConditionsBuilder.Conditions conditions = (ConditionsBuilder.Conditions) object;
			if (conditions.isHaving()) {
				this.havingClause = conditions.getConditions();
			} else {
				this.whereClause = conditions.getConditions();
			}
		}
	}
}
