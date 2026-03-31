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

import org.nervousync.builder.AbstractBuilder;
import org.nervousync.builder.ParentBuilder;
import org.nervousync.database.query.QueryInfo;
import org.nervousync.database.query.core.BaseFrom;
import org.nervousync.database.query.core.BaseJoin;
import org.nervousync.database.query.from.FromQuery;
import org.nervousync.database.query.from.FromTable;
import org.nervousync.exceptions.builder.BuilderException;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Query from information builder</h2>
 * <h2 class="zh-CN">查询来源信息构建器</h2>
 *
 * @param <P> <span class="en-US">Parent builder generic type class</span>
 *            <span class="zh-CN">父构建器泛型类</span>
 * @param <T> <span class="en-US">Query from generic type</span>
 *            <span class="zh-CN">查询来源泛型类</span>
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
public abstract class FromBuilder<P extends ParentBuilder, T extends BaseFrom> extends AbstractBuilder<P, T> {

	/**
	 * <span class="en-US">Item alias name</span>
	 * <span class="zh-CN">查询项别名</span>
	 */
	protected final String aliasName;
	/**
	 * <span class="en-US">Related query information list</span>
	 * <span class="zh-CN">关联查询信息列表</span>
	 */
	protected List<BaseJoin> joinList = new ArrayList<>();

	/**
	 * <h3 class="en-US">Constructor method for the query from information builder</h3>
	 * <h3 class="zh-CN">查询来源信息构建器的构造方法</h3>
	 *
	 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
	 *                      <span class="zh-CN">父构建器实例对象</span>
	 * @param aliasName     <span class="en-US">Item alias name</span>
	 *                      <span class="zh-CN">查询项别名</span>
	 */
	protected FromBuilder(final P parentBuilder, final String aliasName) {
		super(parentBuilder);
		this.aliasName = aliasName;
	}

	@Override
	public void confirm(final Object object) {
		if (object instanceof JoinsBuilder.Joins) {
			this.joinList = ((JoinsBuilder.Joins) object).getJoinList();
		}
	}

	/**
	 * <h2 class="en-US">Query from table information builder</h2>
	 * <h2 class="zh-CN">查询来源数据表信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder generic type class</span>
	 *            <span class="zh-CN">父构建器泛型类</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class FromTableBuilder<P extends ParentBuilder> extends FromBuilder<P, FromTable> {

		/**
		 * <span class="en-US">Database name</span>
		 * <span class="zh-CN">数据库名</span>
		 */
		private final String databaseName;
		/**
		 * <span class="en-US">Data table name</span>
		 * <span class="zh-CN">数据表名</span>
		 */
		private final String tableName;

		/**
		 * <h3 class="en-US">Constructor method for the query from table information builder</h3>
		 * <h3 class="zh-CN">查询来源数据表信息构建器的构造方法</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param aliasName     <span class="en-US">Item alias name</span>
		 *                      <span class="zh-CN">查询项别名</span>
		 * @param databaseName <span class="en-US">Database name</span>
		 *                     <span class="zh-CN">数据库名</span>
		 * @param tableName <span class="en-US">Data table name</span>
		 *                  <span class="zh-CN">数据表名</span>
		 */
		FromTableBuilder(final P parentBuilder, final String aliasName, final String databaseName, final String tableName) {
			super(parentBuilder, aliasName);
			this.databaseName = databaseName;
			this.tableName = tableName;
		}

		/**
		 * <h3 class="en-US">Query joins information lists builder</h3>
		 * <h3 class="zh-CN">查询关联信息列表构建器构建器</h3>
		 *
		 * @return <span class="en-US">Query joins information lists builder instance object</span>
		 * <span class="zh-CN">查询关联信息列表构建器构建器实例对象</span>
		 */
		public JoinsBuilder<FromTableBuilder<P>> joins() {
			return new JoinsBuilder<>(this, this.joinList);
		}

		@Override
		public FromTable build() throws BuilderException {
			FromTable fromTable = new FromTable();

			fromTable.setDatabaseName(this.databaseName);
			fromTable.setTableName(this.tableName);
			fromTable.setAliasName(this.aliasName);
			fromTable.setJoinList(this.joinList);

			return fromTable;
		}
	}

	/**
	 * <h2 class="en-US">Query from sub-query information builder</h2>
	 * <h2 class="zh-CN">查询来源子查询信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder generic type class</span>
	 *            <span class="zh-CN">父构建器泛型类</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:59:16 $
	 */
	public static final class FromSubqueryBuilder<P extends ParentBuilder> extends FromBuilder<P, FromQuery> {

		/**
		 * <span class="en-US">Sub-query information</span>
		 * <span class="zh-CN">子查询信息</span>
		 */
		private QueryInfo queryInfo = null;

		/**
		 * <h3 class="en-US">Constructor method for the query from sub-query information builder</h3>
		 * <h3 class="zh-CN">查询来源子查询信息构建器的构造方法</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param aliasName     <span class="en-US">Item alias name</span>
		 *                      <span class="zh-CN">查询项别名</span>
		 */
		FromSubqueryBuilder(final P parentBuilder, final String aliasName) {
			super(parentBuilder, aliasName);
		}

		/**
		 * <h3 class="en-US">Sub-query information builder</h3>
		 * <h3 class="zh-CN">子查询构建器</h3>
		 *
		 * @return <span class="en-US">Sub-query information builder instance object</span>
		 * <span class="zh-CN">子查询构建器实例对象</span>
		 */
		public QueryBuilder<FromSubqueryBuilder<P>> queryBuilder() {
			return new QueryBuilder<>(this);
		}

		/**
		 * <h3 class="en-US">Query joins information lists builder</h3>
		 * <h3 class="zh-CN">查询关联信息列表构建器构建器</h3>
		 *
		 * @return <span class="en-US">Query joins information lists builder instance object</span>
		 * <span class="zh-CN">查询关联信息列表构建器构建器实例对象</span>
		 */
		JoinsBuilder<FromSubqueryBuilder<P>> joins() {
			return new JoinsBuilder<>(this, this.joinList);
		}

		@Override
		public void confirm(final Object object) {
			if (object instanceof QueryInfo) {
				this.queryInfo = (QueryInfo) object;
			} else {
				super.confirm(object);
			}
		}

		@Override
		public FromQuery build() throws BuilderException {
			FromQuery fromQuery = new FromQuery();
			fromQuery.setAliasName(this.aliasName);
			fromQuery.setQueryInfo(this.queryInfo);
			fromQuery.setJoinList(this.joinList);
			return fromQuery;
		}
	}
}
