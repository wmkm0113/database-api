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
import org.nervousync.database.enumerations.ConditionCode;
import org.nervousync.database.enumerations.ConnectionCode;
import org.nervousync.database.enumerations.JoinType;
import org.nervousync.database.query.QueryInfo;
import org.nervousync.database.query.core.AbstractJoin;
import org.nervousync.database.query.join.JoinInfo;
import org.nervousync.database.query.join.TableJoin;
import org.nervousync.exceptions.builder.BuilderException;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Query join information list builder</h2>
 * <h2 class="zh-CN">关联查询信息列表构建器</h2>
 *
 * @param <P> <span class="en-US">Parent builder generic type class</span>
 *            <span class="zh-CN">父构建器泛型类</span>
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
public final class JoinsBuilder<P extends ParentBuilder> extends AbstractBuilder<P, JoinsBuilder.Joins> {

	/**
	 * <span class="en-US">Related query information list</span>
	 * <span class="zh-CN">关联查询信息列表</span>
	 */
	@Nonnull
	private final List<AbstractJoin> joinList = new ArrayList<>();

	/**
	 * <h3 class="en-US">Constructor method for the query join information list builder</h3>
	 * <h3 class="zh-CN">查询关联信息列表构建器的构造方法</h3>
	 *
	 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
	 *                      <span class="zh-CN">父构建器实例对象</span>
	 * @param joinList      <span class="en-US">Related query joins information lists</span>
	 *                      <span class="zh-CN">关联查询信息列表</span>
	 */
	public JoinsBuilder(final P parentBuilder, final List<AbstractJoin> joinList) {
		super(parentBuilder);
		if (joinList != null) {
			this.joinList.addAll(joinList);
		}
	}

	/**
	 * <h3 class="en-US">Data table query joins information builder</h3>
	 * <h3 class="zh-CN">数据表关联构建器</h3>
	 *
	 * @param joinType     <span class="en-US">Table join type</span>
	 *                     <span class="zh-CN">数据表关联类型</span>
	 * @param aliasName    <span class="en-US">Alias name</span>
	 *                     <span class="zh-CN">别名</span>
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param tableName    <span class="en-US">Join table name</span>
	 *                     <span class="zh-CN">关联表名</span>
	 * @return <span class="en-US">Data table query joins information builder instance object</span>
	 * <span class="zh-CN">数据表关联构建器实例对象</span>
	 */
	public TableJoinBuilder<JoinsBuilder<P>> joinTable(@Nonnull final JoinType joinType, @Nonnull final String aliasName,
	                                                   @Nonnull final String databaseName, @Nonnull final String tableName) {
		return new TableJoinBuilder<>(this, joinType, aliasName, databaseName, tableName);
	}

	/**
	 * <h3 class="en-US">Sub-query joins information builder</h3>
	 * <h3 class="zh-CN">子查询关联构建器</h3>
	 *
	 * @param joinType  <span class="en-US">Table join type</span>
	 *                  <span class="zh-CN">数据表关联类型</span>
	 * @param aliasName <span class="en-US">Alias name</span>
	 *                  <span class="zh-CN">别名</span>
	 * @return <span class="en-US">Sub-query joins information builder instance object</span>
	 * <span class="zh-CN">子查询关联构建器实例对象</span>
	 */
	public QueryJoinBuilder<JoinsBuilder<P>> joinQuery(@Nonnull final JoinType joinType, @Nonnull final String aliasName) {
		return new QueryJoinBuilder<>(this, joinType, aliasName);
	}

	@Override
	public void confirm(final Object object) {
		if (object instanceof AbstractJoin) {
			this.joinList.add((AbstractJoin) object);
		}
	}

	@Override
	@Nonnull
	public Joins build() throws BuilderException {
		return new Joins(this.joinList);
	}

	/**
	 * <h2 class="en-US">Query join information list</h2>
	 * <h2 class="zh-CN">查询关联信息列表</h2>
	 *
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class Joins {

		/**
		 * <span class="en-US">Related query joins information lists</span>
		 * <span class="zh-CN">关联查询信息列表</span>
		 */
		@Nonnull
		private final List<AbstractJoin> joinList;

		/**
		 * <h3 class="en-US">Constructor method for the query join information list</h3>
		 * <h3 class="zh-CN">查询关联信息列表的构造方法</h3>
		 *
		 * @param joinList <span class="en-US">Related query joins information lists</span>
		 *                 <span class="zh-CN">关联查询信息列表</span>
		 */
		public Joins(@Nonnull final List<AbstractJoin> joinList) {
			this.joinList = joinList;
		}

		/**
		 * <h3 class="en-US">Getter method for the related query joins information lists</h3>
		 * <h3 class="zh-CN">关联查询信息列表的Getter方法</h3>
		 *
		 * @return <span class="en-US">Related query joins information list</span>
		 * <span class="zh-CN">关联查询信息列表</span>
		 */
		@Nonnull
		public List<AbstractJoin> getJoinList() {
			return this.joinList;
		}
	}

	/**
	 * <h2 class="en-US">Abstract class of query join information builder</h2>
	 * <h2 class="zh-CN">关联信息构建器抽象类</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder instance object</span>
	 *            <span class="zh-CN">父构建器实例对象</span>
	 * @param <T> <span class="en-US">Query join information generic type</span>
	 *            <span class="zh-CN">关联查询信息泛型类型</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static abstract class JoinBuilder<P extends ParentBuilder, T extends AbstractJoin>
			extends AbstractBuilder<P, T> {

		/**
		 * <span class="en-US">Query join information</span>
		 * <span class="zh-CN">关联查询信息</span>
		 */
		protected final T queryJoin;
		/**
		 * <span class="en-US">Join columns list</span>
		 * <span class="zh-CN">关联列信息列表</span>
		 */
		private final List<JoinInfo> joinInfos = new ArrayList<>();
		/**
		 * <span class="en-US">Related query information list</span>
		 * <span class="zh-CN">关联查询信息列表</span>
		 */
		protected List<AbstractJoin> joinList = new ArrayList<>();

		/**
		 * <h3 class="en-US">Constructor method for the abstract class of query join information builder</h3>
		 * <h3 class="zh-CN">关联信息构建器抽象类的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param queryJoin     <span class="en-US">Query join information</span>
		 *                      <span class="zh-CN">关联查询信息</span>
		 * @param aliasName     <span class="en-US">Alias name</span>
		 *                      <span class="zh-CN">别名</span>
		 */
		protected JoinBuilder(final P parentBuilder, @Nonnull final T queryJoin,
		                      @Nonnull final String aliasName) {
			super(parentBuilder);
			this.queryJoin = queryJoin;
			this.queryJoin.setAliasName(aliasName);
		}

		/**
		 * <h3 class="en-US">Add join information</h3>
		 * <h3 class="zh-CN">添加关联信息</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param conditionCode  <span class="en-US">Query condition code</span>
		 *                       <span class="zh-CN">查询条件运算代码</span>
		 * @param joinKey        <span class="en-US">Left table data column identify code</span>
		 *                       <span class="zh-CN">左表数据列识别代码</span>
		 * @param referenceKey   <span class="en-US">Right table data column identify code</span>
		 *                       <span class="zh-CN">右表数据列识别代码</span>
		 */
		protected void joinOn(@Nonnull final ConnectionCode connectionCode, @Nonnull final ConditionCode conditionCode,
		                      @Nonnull final String joinKey, @Nonnull final String referenceKey) {
			if (this.joinInfos.stream()
					.noneMatch(existJoin ->
							existJoin.match(conditionCode, joinKey, referenceKey))) {
				JoinInfo joinInfo = new JoinInfo();
				joinInfo.setConnectionCode(connectionCode);
				joinInfo.setConditionCode(conditionCode);
				joinInfo.setJoinKey(joinKey);
				joinInfo.setReferenceKey(referenceKey);
				this.joinInfos.add(joinInfo);
			}
		}

		@Override
		public void confirm(final Object object) {
			if (object instanceof JoinsBuilder.Joins) {
				this.joinList = ((JoinsBuilder.Joins) object).getJoinList();
			}
		}

		@Override
		public T build() throws BuilderException {
			this.queryJoin.setJoinInfos(this.joinInfos);
			this.queryJoin.setJoinList(this.joinList);
			return this.queryJoin;
		}
	}

	/**
	 * <h2 class="en-US">Data table query joins information builder</h2>
	 * <h2 class="zh-CN">数据表关联信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder instance object</span>
	 *            <span class="zh-CN">父构建器实例对象</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class TableJoinBuilder<P extends ParentBuilder> extends JoinBuilder<P, TableJoin> {

		/**
		 * <h3 class="en-US">Private constructor method for the data table query join information builder</h3>
		 * <h3 class="zh-CN">数据表关联信息构建器的私有构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param joinType      <span class="en-US">Table join type</span>
		 *                      <span class="zh-CN">数据表关联类型</span>
		 * @param aliasName     <span class="en-US">Alias name</span>
		 *                      <span class="zh-CN">别名</span>
		 * @param databaseName  <span class="en-US">Database name</span>
		 *                      <span class="zh-CN">数据库名</span>
		 * @param tableName     <span class="en-US">Join table name</span>
		 *                      <span class="zh-CN">关联表名</span>
		 */
		public TableJoinBuilder(final P parentBuilder, @Nonnull final JoinType joinType, @Nonnull final String aliasName,
		                        @Nonnull final String databaseName, @Nonnull final String tableName) {
			super(parentBuilder, new TableJoin(), aliasName);
			this.queryJoin.setJoinType(joinType);
			this.queryJoin.setDatabaseName(databaseName);
			this.queryJoin.setTableName(tableName);
		}

		/**
		 * <h3 class="en-US">Set join information</h3>
		 * <h3 class="zh-CN">设置关联信息</h3>
		 *
		 * @param joinKey      <span class="en-US">Left table data column identify code</span>
		 *                     <span class="zh-CN">左表数据列识别代码</span>
		 * @param referenceKey <span class="en-US">Right table data column identify code</span>
		 *                     <span class="zh-CN">右表数据列识别代码</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public TableJoinBuilder<P> on(@Nonnull final String joinKey, @Nonnull final String referenceKey) {
			return this.on(ConnectionCode.AND, ConditionCode.EQUAL_THAN, joinKey, referenceKey);
		}

		/**
		 * <h3 class="en-US">Set join information</h3>
		 * <h3 class="zh-CN">设置关联信息</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param joinKey        <span class="en-US">Left table data column identify code</span>
		 *                       <span class="zh-CN">左表数据列识别代码</span>
		 * @param referenceKey   <span class="en-US">Right table data column identify code</span>
		 *                       <span class="zh-CN">右表数据列识别代码</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public TableJoinBuilder<P> on(@Nonnull final ConnectionCode connectionCode,
		                              @Nonnull final String joinKey, @Nonnull final String referenceKey) {
			return this.on(connectionCode, ConditionCode.EQUAL_THAN, joinKey, referenceKey);
		}

		/**
		 * <h3 class="en-US">Set join information</h3>
		 * <h3 class="zh-CN">设置关联信息</h3>
		 *
		 * @param conditionCode <span class="en-US">Query condition code</span>
		 *                      <span class="zh-CN">查询条件运算代码</span>
		 * @param joinKey       <span class="en-US">Left table data column identify code</span>
		 *                      <span class="zh-CN">左表数据列识别代码</span>
		 * @param referenceKey  <span class="en-US">Right table data column identify code</span>
		 *                      <span class="zh-CN">右表数据列识别代码</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public TableJoinBuilder<P> on(@Nonnull final ConditionCode conditionCode,
		                              @Nonnull final String joinKey, @Nonnull final String referenceKey) {
			return this.on(ConnectionCode.AND, conditionCode, joinKey, referenceKey);
		}

		/**
		 * <h3 class="en-US">Set join information</h3>
		 * <h3 class="zh-CN">设置关联信息</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param conditionCode  <span class="en-US">Query condition code</span>
		 *                       <span class="zh-CN">查询条件运算代码</span>
		 * @param joinKey        <span class="en-US">Left table data column identify code</span>
		 *                       <span class="zh-CN">左表数据列识别代码</span>
		 * @param referenceKey   <span class="en-US">Right table data column identify code</span>
		 *                       <span class="zh-CN">右表数据列识别代码</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public TableJoinBuilder<P> on(@Nonnull final ConnectionCode connectionCode,
		                              @Nonnull final ConditionCode conditionCode,
		                              @Nonnull final String joinKey, @Nonnull final String referenceKey) {
			super.joinOn(connectionCode, conditionCode, joinKey, referenceKey);
			return this;
		}

		/**
		 * <h3 class="en-US">Query joins information lists builder</h3>
		 * <h3 class="zh-CN">查询关联信息列表构建器构建器</h3>
		 *
		 * @return <span class="en-US">Query joins information lists builder instance object</span>
		 * <span class="zh-CN">查询关联信息列表构建器构建器实例对象</span>
		 */
		JoinsBuilder<TableJoinBuilder<P>> joins() {
			return new JoinsBuilder<>(this, this.joinList);
		}
	}

	/**
	 * <h2 class="en-US">Sub-query joins information builder</h2>
	 * <h2 class="zh-CN">子查询关联信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder instance object</span>
	 *            <span class="zh-CN">父构建器实例对象</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class QueryJoinBuilder<P extends ParentBuilder> extends JoinBuilder<P, org.nervousync.database.query.join.QueryJoin> {

		/**
		 * <h3 class="en-US">Private constructor method for the sub-query join information builder</h3>
		 * <h3 class="zh-CN">子查询关联信息构建器的私有构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param joinType      <span class="en-US">Table join type</span>
		 *                      <span class="zh-CN">数据表关联类型</span>
		 * @param aliasName     <span class="en-US">Alias name</span>
		 *                      <span class="zh-CN">别名</span>
		 */
		public QueryJoinBuilder(final P parentBuilder, @Nonnull final JoinType joinType,
		                        @Nonnull final String aliasName) {
			super(parentBuilder, new org.nervousync.database.query.join.QueryJoin(), aliasName);
			this.queryJoin.setJoinType(joinType);
		}

		/**
		 * <h3 class="en-US">Sub-query builder instance object</h3>
		 * <h3 class="zh-CN">子查询构建器实例对象</h3>
		 *
		 * @return <span class="en-US">Sub-query builder instance object</span>
		 * <span class="zh-CN">子查询构建器实例对象</span>
		 */
		public QueryBuilder<QueryJoinBuilder<P>> queryBuilder() {
			return new QueryBuilder<>(this);
		}

		/**
		 * <h3 class="en-US">Set join information</h3>
		 * <h3 class="zh-CN">设置关联信息</h3>
		 *
		 * @param joinKey      <span class="en-US">Left table data column identify code</span>
		 *                     <span class="zh-CN">左表数据列识别代码</span>
		 * @param referenceKey <span class="en-US">Right table data column identify code</span>
		 *                     <span class="zh-CN">右表数据列识别代码</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public QueryJoinBuilder<P> on(@Nonnull final String joinKey, @Nonnull final String referenceKey) {
			return this.on(ConnectionCode.AND, ConditionCode.EQUAL_THAN, joinKey, referenceKey);
		}

		/**
		 * <h3 class="en-US">Set join information</h3>
		 * <h3 class="zh-CN">设置关联信息</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param joinKey        <span class="en-US">Left table data column identify code</span>
		 *                       <span class="zh-CN">左表数据列识别代码</span>
		 * @param referenceKey   <span class="en-US">Right table data column identify code</span>
		 *                       <span class="zh-CN">右表数据列识别代码</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public QueryJoinBuilder<P> on(@Nonnull final ConnectionCode connectionCode,
		                              @Nonnull final String joinKey, @Nonnull final String referenceKey) {
			return this.on(connectionCode, ConditionCode.EQUAL_THAN, joinKey, referenceKey);
		}

		/**
		 * <h3 class="en-US">Set join information</h3>
		 * <h3 class="zh-CN">设置关联信息</h3>
		 *
		 * @param conditionCode <span class="en-US">Query condition code</span>
		 *                      <span class="zh-CN">查询条件运算代码</span>
		 * @param joinKey       <span class="en-US">Left table data column identify code</span>
		 *                      <span class="zh-CN">左表数据列识别代码</span>
		 * @param referenceKey  <span class="en-US">Right table data column identify code</span>
		 *                      <span class="zh-CN">右表数据列识别代码</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public QueryJoinBuilder<P> on(@Nonnull final ConditionCode conditionCode,
		                              @Nonnull final String joinKey, @Nonnull final String referenceKey) {
			return this.on(ConnectionCode.AND, conditionCode, joinKey, referenceKey);
		}

		/**
		 * <h3 class="en-US">Set join information</h3>
		 * <h3 class="zh-CN">设置关联信息</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param conditionCode  <span class="en-US">Query condition code</span>
		 *                       <span class="zh-CN">查询条件运算代码</span>
		 * @param joinKey        <span class="en-US">Left table data column identify code</span>
		 *                       <span class="zh-CN">左表数据列识别代码</span>
		 * @param referenceKey   <span class="en-US">Right table data column identify code</span>
		 *                       <span class="zh-CN">右表数据列识别代码</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public QueryJoinBuilder<P> on(@Nonnull final ConnectionCode connectionCode,
		                              @Nonnull final ConditionCode conditionCode,
		                              @Nonnull final String joinKey, @Nonnull final String referenceKey) {
			super.joinOn(connectionCode, conditionCode, joinKey, referenceKey);
			return this;
		}

		/**
		 * <h3 class="en-US">Query joins information lists builder</h3>
		 * <h3 class="zh-CN">查询关联信息列表构建器构建器</h3>
		 *
		 * @return <span class="en-US">Query joins information lists builder instance object</span>
		 * <span class="zh-CN">查询关联信息列表构建器构建器实例对象</span>
		 */
		JoinsBuilder<QueryJoinBuilder<P>> joins() {
			return new JoinsBuilder<>(this, this.joinList);
		}

		@Override
		public void confirm(final Object object) {
			if (object instanceof QueryInfo) {
				this.queryJoin.setQueryInfo((QueryInfo) object);
			} else {
				super.confirm(object);
			}
		}
	}
}
