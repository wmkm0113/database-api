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
import org.nervousync.database.query.QueryInfo;
import org.nervousync.database.query.condition.ColumnCondition;
import org.nervousync.database.query.condition.ExistCondition;
import org.nervousync.database.query.condition.GroupCondition;
import org.nervousync.database.query.core.AbstractCondition;
import org.nervousync.database.query.param.ArraysParameter;
import org.nervousync.database.query.param.ColumnParameter;
import org.nervousync.database.query.param.ConstantParameter;
import org.nervousync.database.query.param.RangesParameter;
import org.nervousync.exceptions.builder.BuilderException;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Query conditions information list builder</h2>
 * <h2 class="zh-CN">查询条件信息列表构建器</h2>
 *
 * @param <P> <span class="en-US">Parent builder generic type class</span>
 *            <span class="zh-CN">父构建器泛型类</span>
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
public final class ConditionsBuilder<P extends ParentBuilder> extends AbstractBuilder<P, ConditionsBuilder.Conditions> {

	/**
	 * <span class="en-US">Having condition flag</span>
	 * <span class="zh-CN">Having字句条件标记</span>
	 */
	private final boolean having;
	/**
	 * <span class="en-US">Query condition instance list</span>
	 * <span class="zh-CN">查询条件实例对象列表</span>
	 */
	@Nonnull
	private final List<AbstractCondition> conditionList = new ArrayList<>();

	/**
	 * <h3 class="en-US">Protected constructor for AbstractBuilder</h3>
	 * <h3 class="zh-CN">AbstractBuilder的构造函数</h3>
	 *
	 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
	 *                      <span class="zh-CN">父构建器实例对象</span>
	 * @param having        <span class="en-US">Having condition flag</span>
	 *                      <span class="zh-CN">Having字句条件标记</span>
	 * @param conditionList <span class="en-US">Query condition instance list</span>
	 *                      <span class="zh-CN">查询条件实例对象列表</span>
	 */
	public ConditionsBuilder(final P parentBuilder, final boolean having, final List<AbstractCondition> conditionList) {
		super(parentBuilder);
		this.having = having;
		if (conditionList != null) {
			this.conditionList.addAll(conditionList);
		}
	}

	/**
	 * <h3 class="en-US">Data column less condition information builder</h3>
	 * <h3 class="zh-CN">数据列小于条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> lessThan(@Nonnull final String databaseName,
	                                                             @Nonnull final String tableName,
	                                                             @Nonnull final String columnName) {
		return this.lessThan(ConnectionCode.AND, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column less or equal condition information builder</h3>
	 * <h3 class="zh-CN">数据列小于等于条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> lessEqual(@Nonnull final String databaseName,
	                                                              @Nonnull final String tableName,
	                                                              @Nonnull final String columnName) {
		return this.lessEqual(ConnectionCode.AND, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column greater condition information builder</h3>
	 * <h3 class="zh-CN">数据列大于条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> greaterThan(@Nonnull final String databaseName,
	                                                                @Nonnull final String tableName,
	                                                                @Nonnull final String columnName) {
		return this.greaterThan(ConnectionCode.AND, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column greater or equal condition information builder</h3>
	 * <h3 class="zh-CN">数据列大于等于条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> greaterEqual(@Nonnull final String databaseName,
	                                                                 @Nonnull final String tableName,
	                                                                 @Nonnull final String columnName) {
		return this.greaterEqual(ConnectionCode.AND, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column equal condition information builder</h3>
	 * <h3 class="zh-CN">数据列等于条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> equalThan(@Nonnull final String databaseName,
	                                                              @Nonnull final String tableName,
	                                                              @Nonnull final String columnName) {
		return this.equalThan(ConnectionCode.AND, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column not equal condition information builder</h3>
	 * <h3 class="zh-CN">数据列不等于条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> notEqual(@Nonnull final String databaseName,
	                                                             @Nonnull final String tableName,
	                                                             @Nonnull final String columnName) {
		return this.notEqual(ConnectionCode.AND, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column in arrays condition information builder</h3>
	 * <h3 class="zh-CN">数据列在数组中条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> in(@Nonnull final String databaseName, @Nonnull final String tableName,
	                               @Nonnull final String columnName, @Nonnull final Object[] arrayObjects) {
		return this.in(ConnectionCode.AND, databaseName, tableName, columnName, arrayObjects);
	}

	/**
	 * <h3 class="en-US">Data column not in arrays condition information builder</h3>
	 * <h3 class="zh-CN">数据列不在数组中条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> notIn(@Nonnull final String databaseName, @Nonnull final String tableName,
	                                  @Nonnull final String columnName, @Nonnull final Object[] arrayObjects) {
		return this.notIn(ConnectionCode.AND, databaseName, tableName, columnName, arrayObjects);
	}

	/**
	 * <h3 class="en-US">Data column in ranges condition information builder</h3>
	 * <h3 class="zh-CN">数据列在指定区间条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> betweenAnd(@Nonnull final String databaseName,
	                                       @Nonnull final String tableName, @Nonnull final String columnName,
	                                       @Nonnull final Object beginValue, @Nonnull final Object endValue) {
		return this.betweenAnd(ConnectionCode.AND, databaseName, tableName, columnName, beginValue, endValue);
	}

	/**
	 * <h3 class="en-US">Data column in ranges condition information builder</h3>
	 * <h3 class="zh-CN">数据列不在指定区间条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> notBetweenAnd(@Nonnull final String databaseName,
	                                          @Nonnull final String tableName, @Nonnull final String columnName,
	                                          @Nonnull final Object beginValue, @Nonnull final Object endValue) {
		return this.notBetweenAnd(ConnectionCode.AND, databaseName, tableName, columnName, beginValue, endValue);
	}

	/**
	 * <h3 class="en-US">Data column is null</h3>
	 * <h3 class="zh-CN">数据列为空</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> isNull(@Nonnull final String databaseName, @Nonnull final String tableName,
	                                   @Nonnull final String columnName) {
		return this.isNull(ConnectionCode.AND, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column not null</h3>
	 * <h3 class="zh-CN">数据列不为空</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> notNull(@Nonnull final String databaseName, @Nonnull final String tableName,
	                                    @Nonnull final String columnName) {
		return this.notNull(ConnectionCode.AND, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column similar condition information builder</h3>
	 * <h3 class="zh-CN">数据列模糊匹配条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> similar(@Nonnull final String databaseName, @Nonnull final String tableName,
	                                    @Nonnull final String columnName, @Nonnull final String pattern) {
		return this.similar(ConnectionCode.AND, databaseName, tableName, columnName, pattern);
	}

	/**
	 * <h3 class="en-US">Data column is not similar condition information builder</h3>
	 * <h3 class="zh-CN">数据列非模糊匹配条件信息构建器</h3>
	 *
	 * @param databaseName <span class="en-US">Database identify information</span>
	 *                     <span class="zh-CN">数据库识别信息</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param columnName   <span class="en-US">Data column name</span>
	 *                     <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> notSimilar(@Nonnull final String databaseName, @Nonnull final String tableName,
	                                       @Nonnull final String columnName, @Nonnull final String pattern) {
		return this.notSimilar(ConnectionCode.AND, databaseName, tableName, columnName, pattern);
	}

	/**
	 * <h3 class="en-US">Data exists condition information builder</h3>
	 * <h3 class="zh-CN">数据存在条件信息构建器</h3>
	 *
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ExistConditionBuilder<ConditionsBuilder<P>> exists() {
		return this.exists(ConnectionCode.AND);
	}

	/**
	 * <h3 class="en-US">Data don't exist condition information builder</h3>
	 * <h3 class="zh-CN">数据不存在条件信息构建器</h3>
	 *
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ExistConditionBuilder<ConditionsBuilder<P>> notExists() {
		return this.notExists(ConnectionCode.AND);
	}

	/**
	 * <h3 class="en-US">Data column less condition information builder</h3>
	 * <h3 class="zh-CN">数据列小于条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> lessThan(@Nonnull final ConnectionCode connectionCode,
	                                                             @Nonnull final String databaseName,
	                                                             @Nonnull final String tableName,
	                                                             @Nonnull final String columnName) {
		return this.column(connectionCode, ConditionCode.LESS_THAN, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column less or equal condition information builder</h3>
	 * <h3 class="zh-CN">数据列小于等于条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> lessEqual(@Nonnull final ConnectionCode connectionCode,
	                                                              @Nonnull final String databaseName,
	                                                              @Nonnull final String tableName,
	                                                              @Nonnull final String columnName) {
		return this.column(connectionCode, ConditionCode.LESS_EQUAL, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column greater condition information builder</h3>
	 * <h3 class="zh-CN">数据列大于条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> greaterThan(@Nonnull final ConnectionCode connectionCode,
	                                                                @Nonnull final String databaseName,
	                                                                @Nonnull final String tableName,
	                                                                @Nonnull final String columnName) {
		return this.column(connectionCode, ConditionCode.GREATER_THAN, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column greater or equal condition information builder</h3>
	 * <h3 class="zh-CN">数据列大于等于条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> greaterEqual(@Nonnull final ConnectionCode connectionCode,
	                                                                 @Nonnull final String databaseName,
	                                                                 @Nonnull final String tableName,
	                                                                 @Nonnull final String columnName) {
		return this.column(connectionCode, ConditionCode.GREATER_EQUAL, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column equal condition information builder</h3>
	 * <h3 class="zh-CN">数据列等于条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> equalThan(final ConnectionCode connectionCode,
	                                                              @Nonnull final String databaseName, final String tableName, final String columnName) {
		return this.column(connectionCode, ConditionCode.EQUAL_THAN, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column not equal condition information builder</h3>
	 * <h3 class="zh-CN">数据列不等于条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ColumnConditionBuilder<ConditionsBuilder<P>> notEqual(@Nonnull final ConnectionCode connectionCode,
	                                                             @Nonnull final String databaseName,
	                                                             @Nonnull final String tableName,
	                                                             @Nonnull final String columnName) {
		return this.column(connectionCode, ConditionCode.NOT_EQUAL, databaseName, tableName, columnName);
	}

	/**
	 * <h3 class="en-US">Data column in arrays condition information builder</h3>
	 * <h3 class="zh-CN">数据列在数组中条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> in(@Nonnull final ConnectionCode connectionCode,
	                               @Nonnull final String databaseName, @Nonnull final String tableName,
	                               @Nonnull final String columnName, @Nonnull final Object[] arrayObjects) {
		return this.column(connectionCode, ConditionCode.IN, databaseName, tableName, columnName)
				.inArray(arrayObjects)
				.confirm();
	}

	/**
	 * <h3 class="en-US">Data column not in arrays condition information builder</h3>
	 * <h3 class="zh-CN">数据列不在数组中条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> notIn(@Nonnull final ConnectionCode connectionCode,
	                                  @Nonnull final String databaseName, @Nonnull final String tableName,
	                                  @Nonnull final String columnName, @Nonnull final Object[] arrayObjects) {
		return this.column(connectionCode, ConditionCode.NOT_IN, databaseName, tableName, columnName)
				.inArray(arrayObjects)
				.confirm();
	}

	/**
	 * <h3 class="en-US">Data column in ranges condition information builder</h3>
	 * <h3 class="zh-CN">数据列在指定区间条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> betweenAnd(@Nonnull final ConnectionCode connectionCode,
	                                       @Nonnull final String databaseName,
	                                       @Nonnull final String tableName, @Nonnull final String columnName,
	                                       @Nonnull final Object beginValue, @Nonnull final Object endValue) {
		return this.column(connectionCode, ConditionCode.BETWEEN_AND, databaseName, tableName, columnName)
				.valueRange(beginValue, endValue)
				.confirm();
	}

	/**
	 * <h3 class="en-US">Data column in ranges condition information builder</h3>
	 * <h3 class="zh-CN">数据列不在指定区间条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> notBetweenAnd(@Nonnull final ConnectionCode connectionCode,
	                                          @Nonnull final String databaseName,
	                                          @Nonnull final String tableName, @Nonnull final String columnName,
	                                          @Nonnull final Object beginValue, @Nonnull final Object endValue) {
		return this.column(connectionCode, ConditionCode.NOT_BETWEEN_AND, databaseName, tableName, columnName)
				.valueRange(beginValue, endValue)
				.confirm();
	}

	/**
	 * <h3 class="en-US">Data column is null</h3>
	 * <h3 class="zh-CN">数据列为空</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> isNull(@Nonnull final ConnectionCode connectionCode,
	                                   @Nonnull final String databaseName, @Nonnull final String tableName,
	                                   @Nonnull final String columnName) {
		return this.column(connectionCode, ConditionCode.IS_NULL, databaseName, tableName, columnName).confirm();
	}

	/**
	 * <h3 class="en-US">Data column not null</h3>
	 * <h3 class="zh-CN">数据列不为空</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> notNull(@Nonnull final ConnectionCode connectionCode,
	                                    @Nonnull final String databaseName, @Nonnull final String tableName,
	                                    @Nonnull final String columnName) {
		return this.column(connectionCode, ConditionCode.NOT_NULL, databaseName, tableName, columnName).confirm();
	}

	/**
	 * <h3 class="en-US">Data column similar condition information builder</h3>
	 * <h3 class="zh-CN">数据列模糊匹配条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> similar(@Nonnull final ConnectionCode connectionCode,
	                                    @Nonnull final String databaseName, @Nonnull final String tableName,
	                                    @Nonnull final String columnName, @Nonnull final String pattern) {
		return this.column(connectionCode, ConditionCode.SIMILAR_THAN, databaseName, tableName, columnName)
				.matchValue(pattern)
				.confirm();
	}

	/**
	 * <h3 class="en-US">Data column is not similar condition information builder</h3>
	 * <h3 class="zh-CN">数据列非模糊匹配条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ConditionsBuilder<P> notSimilar(@Nonnull final ConnectionCode connectionCode,
	                                       @Nonnull final String databaseName, @Nonnull final String tableName,
	                                       @Nonnull final String columnName, @Nonnull final String pattern) {
		return this.column(connectionCode, ConditionCode.NOT_SIMILAR, databaseName, tableName, columnName)
				.matchValue(pattern)
				.confirm();
	}

	/**
	 * <h3 class="en-US">Data exists condition information builder</h3>
	 * <h3 class="zh-CN">数据存在条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ExistConditionBuilder<ConditionsBuilder<P>> exists(@Nonnull final ConnectionCode connectionCode) {
		return new ExistConditionBuilder<>(this, connectionCode, Boolean.FALSE);
	}

	/**
	 * <h3 class="en-US">Data don't exist condition information builder</h3>
	 * <h3 class="zh-CN">数据不存在条件信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	public ExistConditionBuilder<ConditionsBuilder<P>> notExists(@Nonnull final ConnectionCode connectionCode) {
		return new ExistConditionBuilder<>(this, connectionCode, Boolean.TRUE);
	}

	/**
	 * <h3 class="en-US">Group query condition information builder</h3>
	 * <h3 class="zh-CN">查询信息组构建器</h3>
	 *
	 * @return <span class="en-US">Group query condition information builder instance object</span>
	 * <span class="zh-CN">查询信息组构建器实例对象</span>
	 */
	public GroupConditionBuilder<ConditionsBuilder<P>> group() {
		return this.group(ConnectionCode.AND);
	}

	/**
	 * <h3 class="en-US">Group query condition information builder</h3>
	 * <h3 class="zh-CN">查询信息组构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @return <span class="en-US">Group query condition information builder instance object</span>
	 * <span class="zh-CN">查询信息组构建器实例对象</span>
	 */
	public GroupConditionBuilder<ConditionsBuilder<P>> group(@Nonnull final ConnectionCode connectionCode) {
		return new GroupConditionBuilder<>(this, connectionCode);
	}

	@Override
	public void confirm(final Object object) {
		if (object instanceof AbstractCondition) {
			this.conditionList.add((AbstractCondition) object);
		}
	}

	@Override
	public Conditions build() throws BuilderException {
		return new Conditions(this.conditionList, this.having);
	}

	/**
	 * <h3 class="en-US">Data column query condition information builder</h3>
	 * <h3 class="zh-CN">数据列查询信息构建器</h3>
	 *
	 * @param connectionCode <span class="en-US">Query connection code</span>
	 *                       <span class="zh-CN">查询条件连接代码</span>
	 * @param conditionCode  <span class="en-US">Query condition code</span>
	 *                       <span class="zh-CN">查询条件运算代码</span>
	 * @param databaseName   <span class="en-US">Database identify information</span>
	 *                       <span class="zh-CN">数据库识别信息</span>
	 * @param tableName      <span class="en-US">Data table name</span>
	 *                       <span class="zh-CN">数据表名</span>
	 * @param columnName     <span class="en-US">Data column name</span>
	 *                       <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column query condition information builder instance object</span>
	 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
	 */
	private ColumnConditionBuilder<ConditionsBuilder<P>> column(@Nonnull final ConnectionCode connectionCode,
	                                                            @Nonnull final ConditionCode conditionCode,
	                                                            @Nonnull final String databaseName,
	                                                            @Nonnull final String tableName,
	                                                            @Nonnull final String columnName) {
		return new ColumnConditionBuilder<>(this, connectionCode, conditionCode, databaseName, tableName, columnName);
	}

	/**
	 * <h2 class="en-US">Data column conditions information builder</h2>
	 * <h2 class="zh-CN">数据列查询条件信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder generic type class</span>
	 *            <span class="zh-CN">父构建器泛型类</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class ColumnConditionBuilder<P extends ParentBuilder>
			extends ConditionBuilder<P, ColumnCondition> {

		/**
		 * <h3 class="en-US">Constructor method for the data column conditions information builder</h3>
		 * <h3 class="zh-CN">数据列查询条件信息构建器的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param connection    <span class="en-US">Query connection code</span>
		 *                      <span class="zh-CN">查询条件连接代码</span>
		 * @param condition     <span class="en-US">Query condition code</span>
		 *                      <span class="zh-CN">查询条件运算代码</span>
		 * @param databaseName  <span class="en-US">Database identify information</span>
		 *                      <span class="zh-CN">数据库识别信息</span>
		 * @param tableName     <span class="en-US">Data table name</span>
		 *                      <span class="zh-CN">数据表名</span>
		 * @param columnName    <span class="en-US">Data column name</span>
		 *                      <span class="zh-CN">数据列名</span>
		 */
		public ColumnConditionBuilder(final P parentBuilder, final ConnectionCode connection,
		                              final ConditionCode condition, @Nonnull final String databaseName,
		                              final String tableName, final String columnName) {
			super(parentBuilder, new ColumnCondition());
			this.condition.setConnectionCode(connection);
			this.condition.setConditionCode(condition);
			this.condition.setDatabaseName(databaseName);
			this.condition.setTableName(tableName);
			this.condition.setColumnName(columnName);
		}

		/**
		 * <h3 class="en-US">Set the execute function name</h3>
		 * <h3 class="zh-CN">设置查询匹配值运算函数名</h3>
		 *
		 * @param functionName <span class="en-US">Execute function name</span>
		 *                     <span class="zh-CN">运算函数名</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public ColumnConditionBuilder<P> function(final String functionName) {
			this.condition.setFunctionName(functionName);
			return this;
		}

		/**
		 * <h3 class="en-US">Calculate function parameter item builder</h3>
		 * <h3 class="zh-CN">计算参数信息构建器</h3>
		 *
		 * @return <span class="en-US">Calculate function parameter item builder instance object</span>
		 * <span class="zh-CN">计算参数信息构建器实例对象</span>
		 */
		public ParametersBuilder.CalculateParameterBuilder<ColumnConditionBuilder<P>> matchCalculate() {
			return new ParametersBuilder.CalculateParameterBuilder<>(this);
		}

		/**
		 * <h3 class="en-US">Set condition match value</h3>
		 * <h3 class="zh-CN">设置查询匹配值</h3>
		 *
		 * @param matchValue <span class="en-US">Condition match value</span>
		 *                   <span class="zh-CN">查询匹配值</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public ColumnConditionBuilder<P> matchValue(final Object matchValue) {
			this.condition.setParameter(new ConstantParameter(matchValue));
			return this;
		}

		/**
		 * <h3 class="en-US">Set condition match column information</h3>
		 * <h3 class="zh-CN">设置查询匹配数据列</h3>
		 *
		 * @param databaseName <span class="en-US">Database name</span>
		 *                     <span class="zh-CN">数据库名</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public ColumnConditionBuilder<P> matchColumn(@Nonnull final String databaseName, final String tableName, final String columnName) {
			this.condition.setParameter(new ColumnParameter(databaseName, tableName, columnName));
			return this;
		}

		/**
		 * <h3 class="en-US">Set condition ranges begin value and end value</h3>
		 * <h3 class="zh-CN">设置查询区间起始值和终止值</h3>
		 *
		 * @param beginValue <span class="en-US">Ranges begin value</span>
		 *                   <span class="zh-CN">区间起始值</span>
		 * @param endValue   <span class="en-US">Ranges end value</span>
		 *                   <span class="zh-CN">区间终止值</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		ColumnConditionBuilder<P> valueRange(@Nonnull final Object beginValue, @Nonnull final Object endValue) {
			this.condition.setParameter(new RangesParameter(beginValue, endValue));
			return this;
		}

		/**
		 * <h3 class="en-US">Set condition value array</h3>
		 * <h3 class="zh-CN">设置查询匹配值数组</h3>
		 *
		 * @param matchValues <span class="en-US">Condition value array</span>
		 *                    <span class="zh-CN">查询匹配值数组</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		ColumnConditionBuilder<P> inArray(@Nonnull final Object[] matchValues) {
			this.condition.setParameter(new ArraysParameter(matchValues));
			return this;
		}

		/**
		 * <h3 class="en-US">Query condition match function information builder</h3>
		 * <h3 class="zh-CN">查询匹配函数构建器</h3>
		 *
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public ParametersBuilder.FunctionParameterBuilder<ColumnConditionBuilder<P>> matchFunction() {
			return new ParametersBuilder.FunctionParameterBuilder<>(this);
		}

		/**
		 * <h3 class="en-US">Condition matches the scalar sub-query information builder</h3>
		 * <h3 class="zh-CN">匹配标量子查询构建器</h3>
		 *
		 * @return <span class="en-US">Sub-query builder instance object</span>
		 * <span class="zh-CN">子查询构建器实例对象</span>
		 */
		public ParametersBuilder.QueryParameterBuilder<ColumnConditionBuilder<P>> matchQuery() {
			return new ParametersBuilder.QueryParameterBuilder<>(this);
		}

		@Override
		public ColumnCondition build() throws BuilderException {
			return this.condition;
		}
	}

	/**
	 * <h2 class="en-US">Exist conditions information builder</h2>
	 * <h2 class="zh-CN">查询存在信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder generic type class</span>
	 *            <span class="zh-CN">父构建器泛型类</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class ExistConditionBuilder<P extends ParentBuilder> extends ConditionBuilder<P, ExistCondition> {

		/**
		 * <span class="en-US">NOT prefix</span>
		 * <span class="zh-CN">NOT前缀</span>
		 */
		private final boolean not;
		/**
		 * <span class="en-US">Sub-query information</span>
		 * <span class="zh-CN">子查询信息</span>
		 */
		private QueryInfo queryInfo;

		/**
		 * <h3 class="en-US">Constructor method for the exist conditions information builder</h3>
		 * <h3 class="zh-CN">查询存在信息构建器的构造方法</h3>
		 *
		 * @param parentBuilder  <span class="en-US">Parent builder instance object</span>
		 *                       <span class="zh-CN">父构建器实例对象</span>
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param not            <span class="en-US">NOT prefix</span>
		 *                       <span class="zh-CN">NOT前缀</span>
		 */
		public ExistConditionBuilder(final P parentBuilder, @Nonnull final ConnectionCode connectionCode, final boolean not) {
			super(parentBuilder, new ExistCondition());
			this.condition.setConnectionCode(connectionCode);
			this.not = not;
		}

		/**
		 * <h3 class="en-US">Sub-query information builder</h3>
		 * <h3 class="zh-CN">子查询构建器</h3>
		 *
		 * @return <span class="en-US">Sub-query information builder instance object</span>
		 * <span class="zh-CN">子查询构建器实例对象</span>
		 */
		public QueryBuilder<ExistConditionBuilder<P>> queryBuilder() {
			return new QueryBuilder<>(this);
		}

		@Override
		public void confirm(final Object object) throws BuilderException {
			if (object instanceof QueryInfo) {
				this.queryInfo = (QueryInfo) object;
			}
		}

		@Override
		public ExistCondition build() throws BuilderException {
			this.condition.setNot(this.not);
			this.condition.setQueryInfo(this.queryInfo);
			return this.condition;
		}
	}

	/**
	 * <h2 class="en-US">Group conditions information builder</h2>
	 * <h2 class="zh-CN">查询条件组信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder generic type class</span>
	 *            <span class="zh-CN">父构建器泛型类</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class GroupConditionBuilder<P extends ParentBuilder>
			extends ConditionBuilder<P, GroupCondition> {

		/**
		 * <span class="en-US">Match condition list</span>
		 * <span class="zh-CN">匹配条件列表</span>
		 */
		private final List<AbstractCondition> conditionList;

		/**
		 * <h3 class="en-US">Constructor method for the group conditions information builder</h3>
		 * <h3 class="zh-CN">查询条件组信息构建器的构造函数</h3>
		 *
		 * @param parentBuilder  <span class="en-US">Parent builder instance object</span>
		 *                       <span class="zh-CN">父构建器实例对象</span>
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 */
		public GroupConditionBuilder(final P parentBuilder, @Nonnull final ConnectionCode connectionCode) {
			super(parentBuilder, new GroupCondition());
			this.condition.setConnectionCode(connectionCode);
			this.conditionList = new ArrayList<>();
		}

		/**
		 * <h3 class="en-US">Data column less condition information builder</h3>
		 * <h3 class="zh-CN">数据列小于条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> lessThan(@Nonnull final String databaseName,
		                                                                 @Nonnull final String tableName,
		                                                                 @Nonnull final String columnName) {
			return this.lessThan(ConnectionCode.AND, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column less or equal condition information builder</h3>
		 * <h3 class="zh-CN">数据列小于等于条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> lessEqual(@Nonnull final String databaseName,
		                                                                  @Nonnull final String tableName,
		                                                                  @Nonnull final String columnName) {
			return this.lessEqual(ConnectionCode.AND, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column greater condition information builder</h3>
		 * <h3 class="zh-CN">数据列大于条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> greaterThan(@Nonnull final String databaseName,
		                                                                    @Nonnull final String tableName,
		                                                                    @Nonnull final String columnName) {
			return this.greaterThan(ConnectionCode.AND, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column greater or equal condition information builder</h3>
		 * <h3 class="zh-CN">数据列大于等于条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> greaterEqual(@Nonnull final String databaseName,
		                                                                     @Nonnull final String tableName,
		                                                                     @Nonnull final String columnName) {
			return this.greaterEqual(ConnectionCode.AND, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column equal condition information builder</h3>
		 * <h3 class="zh-CN">数据列等于条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> equalThan(@Nonnull final String databaseName,
		                                                                  @Nonnull final String tableName,
		                                                                  @Nonnull final String columnName) {
			return this.equalThan(ConnectionCode.AND, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column not equal condition information builder</h3>
		 * <h3 class="zh-CN">数据列不等于条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> notEqual(@Nonnull final String databaseName,
		                                                                 @Nonnull final String tableName,
		                                                                 @Nonnull final String columnName) {
			return this.notEqual(ConnectionCode.AND, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column in arrays condition information builder</h3>
		 * <h3 class="zh-CN">数据列在数组中条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> in(@Nonnull final String databaseName, @Nonnull final String tableName,
		                                   @Nonnull final String columnName, @Nonnull final Object[] arrayObjects) {
			return this.in(ConnectionCode.AND, databaseName, tableName, columnName, arrayObjects);
		}

		/**
		 * <h3 class="en-US">Data column not in arrays condition information builder</h3>
		 * <h3 class="zh-CN">数据列不在数组中条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> notIn(@Nonnull final String databaseName, @Nonnull final String tableName,
		                                      @Nonnull final String columnName, @Nonnull final Object[] arrayObjects) {
			return this.notIn(ConnectionCode.AND, databaseName, tableName, columnName, arrayObjects);
		}

		/**
		 * <h3 class="en-US">Data column in ranges condition information builder</h3>
		 * <h3 class="zh-CN">数据列在指定区间条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> betweenAnd(@Nonnull final String databaseName,
		                                           @Nonnull final String tableName, @Nonnull final String columnName,
		                                           @Nonnull final Object beginValue, @Nonnull final Object endValue) {
			return this.betweenAnd(ConnectionCode.AND, databaseName, tableName, columnName, beginValue, endValue);
		}

		/**
		 * <h3 class="en-US">Data column in ranges condition information builder</h3>
		 * <h3 class="zh-CN">数据列不在指定区间条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> notBetweenAnd(@Nonnull final String databaseName,
		                                              @Nonnull final String tableName, @Nonnull final String columnName,
		                                              @Nonnull final Object beginValue, @Nonnull final Object endValue) {
			return this.notBetweenAnd(ConnectionCode.AND, databaseName, tableName, columnName, beginValue, endValue);
		}

		/**
		 * <h3 class="en-US">Data column is null</h3>
		 * <h3 class="zh-CN">数据列为空</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> isNull(@Nonnull final String databaseName, @Nonnull final String tableName,
		                                       @Nonnull final String columnName) {
			return this.isNull(ConnectionCode.AND, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column not null</h3>
		 * <h3 class="zh-CN">数据列不为空</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> notNull(@Nonnull final String databaseName, @Nonnull final String tableName,
		                                        @Nonnull final String columnName) {
			return this.notNull(ConnectionCode.AND, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column similar condition information builder</h3>
		 * <h3 class="zh-CN">数据列模糊匹配条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> similar(@Nonnull final String databaseName, @Nonnull final String tableName,
		                                        @Nonnull final String columnName, @Nonnull final String pattern) {
			return this.similar(ConnectionCode.AND, databaseName, tableName, columnName, pattern);
		}

		/**
		 * <h3 class="en-US">Data column is not similar condition information builder</h3>
		 * <h3 class="zh-CN">数据列非模糊匹配条件信息构建器</h3>
		 *
		 * @param databaseName <span class="en-US">Database identify information</span>
		 *                     <span class="zh-CN">数据库识别信息</span>
		 * @param tableName    <span class="en-US">Data table name</span>
		 *                     <span class="zh-CN">数据表名</span>
		 * @param columnName   <span class="en-US">Data column name</span>
		 *                     <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> notSimilar(@Nonnull final String databaseName, @Nonnull final String tableName,
		                                           @Nonnull final String columnName, @Nonnull final String pattern) {
			return this.notSimilar(ConnectionCode.AND, databaseName, tableName, columnName, pattern);
		}

		/**
		 * <h3 class="en-US">Data exists condition information builder</h3>
		 * <h3 class="zh-CN">数据存在条件信息构建器</h3>
		 *
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ExistConditionBuilder<GroupConditionBuilder<P>> exists() {
			return this.exists(ConnectionCode.AND);
		}

		/**
		 * <h3 class="en-US">Data don't exist condition information builder</h3>
		 * <h3 class="zh-CN">数据不存在条件信息构建器</h3>
		 *
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ExistConditionBuilder<GroupConditionBuilder<P>> notExists() {
			return this.notExists(ConnectionCode.AND);
		}

		/**
		 * <h3 class="en-US">Data column less condition information builder</h3>
		 * <h3 class="zh-CN">数据列小于条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> lessThan(@Nonnull final ConnectionCode connectionCode,
		                                                                 @Nonnull final String databaseName,
		                                                                 @Nonnull final String tableName,
		                                                                 @Nonnull final String columnName) {
			return this.column(connectionCode, ConditionCode.LESS_THAN, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column less or equal condition information builder</h3>
		 * <h3 class="zh-CN">数据列小于等于条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> lessEqual(@Nonnull final ConnectionCode connectionCode,
		                                                                  @Nonnull final String databaseName,
		                                                                  @Nonnull final String tableName,
		                                                                  @Nonnull final String columnName) {
			return this.column(connectionCode, ConditionCode.LESS_EQUAL, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column greater condition information builder</h3>
		 * <h3 class="zh-CN">数据列大于条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> greaterThan(@Nonnull final ConnectionCode connectionCode,
		                                                                    @Nonnull final String databaseName,
		                                                                    @Nonnull final String tableName,
		                                                                    @Nonnull final String columnName) {
			return this.column(connectionCode, ConditionCode.GREATER_THAN, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column greater or equal condition information builder</h3>
		 * <h3 class="zh-CN">数据列大于等于条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> greaterEqual(@Nonnull final ConnectionCode connectionCode,
		                                                                     @Nonnull final String databaseName,
		                                                                     @Nonnull final String tableName,
		                                                                     @Nonnull final String columnName) {
			return this.column(connectionCode, ConditionCode.GREATER_EQUAL, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column equal condition information builder</h3>
		 * <h3 class="zh-CN">数据列等于条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> equalThan(@Nonnull final ConnectionCode connectionCode,
		                                                                  @Nonnull final String databaseName,
		                                                                  @Nonnull final String tableName,
		                                                                  @Nonnull final String columnName) {
			return this.column(connectionCode, ConditionCode.EQUAL_THAN, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column not equal condition information builder</h3>
		 * <h3 class="zh-CN">数据列不等于条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ColumnConditionBuilder<GroupConditionBuilder<P>> notEqual(@Nonnull final ConnectionCode connectionCode,
		                                                                 @Nonnull final String databaseName,
		                                                                 @Nonnull final String tableName,
		                                                                 @Nonnull final String columnName) {
			return this.column(connectionCode, ConditionCode.NOT_EQUAL, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Data column in arrays condition information builder</h3>
		 * <h3 class="zh-CN">数据列在数组中条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> in(@Nonnull final ConnectionCode connectionCode,
		                                   @Nonnull final String databaseName, @Nonnull final String tableName,
		                                   @Nonnull final String columnName, @Nonnull final Object[] arrayObjects) {
			return this.column(connectionCode, ConditionCode.IN, databaseName, tableName, columnName)
					.inArray(arrayObjects)
					.confirm();
		}

		/**
		 * <h3 class="en-US">Data column not in arrays condition information builder</h3>
		 * <h3 class="zh-CN">数据列不在数组中条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> notIn(@Nonnull final ConnectionCode connectionCode,
		                                      @Nonnull final String databaseName, @Nonnull final String tableName,
		                                      @Nonnull final String columnName, @Nonnull final Object[] arrayObjects) {
			return this.column(connectionCode, ConditionCode.NOT_IN, databaseName, tableName, columnName)
					.inArray(arrayObjects)
					.confirm();
		}

		/**
		 * <h3 class="en-US">Data column in ranges condition information builder</h3>
		 * <h3 class="zh-CN">数据列在指定区间条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> betweenAnd(@Nonnull final ConnectionCode connectionCode,
		                                           @Nonnull final String databaseName,
		                                           @Nonnull final String tableName, @Nonnull final String columnName,
		                                           @Nonnull final Object beginValue, @Nonnull final Object endValue) {
			return this.column(connectionCode, ConditionCode.BETWEEN_AND, databaseName, tableName, columnName)
					.valueRange(beginValue, endValue)
					.confirm();
		}

		/**
		 * <h3 class="en-US">Data column in ranges condition information builder</h3>
		 * <h3 class="zh-CN">数据列不在指定区间条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> notBetweenAnd(@Nonnull final ConnectionCode connectionCode,
		                                              @Nonnull final String databaseName,
		                                              @Nonnull final String tableName, @Nonnull final String columnName,
		                                              @Nonnull final Object beginValue, @Nonnull final Object endValue) {
			return this.column(connectionCode, ConditionCode.NOT_BETWEEN_AND, databaseName, tableName, columnName)
					.valueRange(beginValue, endValue)
					.confirm();
		}

		/**
		 * <h3 class="en-US">Data column is null</h3>
		 * <h3 class="zh-CN">数据列为空</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> isNull(@Nonnull final ConnectionCode connectionCode,
		                                       @Nonnull final String databaseName, @Nonnull final String tableName,
		                                       @Nonnull final String columnName) {
			return this.column(connectionCode, ConditionCode.IS_NULL, databaseName, tableName, columnName).confirm();
		}

		/**
		 * <h3 class="en-US">Data column not null condition information builder</h3>
		 * <h3 class="zh-CN">数据列不为空条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> notNull(@Nonnull final ConnectionCode connectionCode,
		                                        @Nonnull final String databaseName, @Nonnull final String tableName,
		                                        @Nonnull final String columnName) {
			return this.column(connectionCode, ConditionCode.NOT_NULL, databaseName, tableName, columnName).confirm();
		}

		/**
		 * <h3 class="en-US">Data column similar condition information builder</h3>
		 * <h3 class="zh-CN">数据列模糊匹配条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> similar(@Nonnull final ConnectionCode connectionCode,
		                                        @Nonnull final String databaseName, @Nonnull final String tableName,
		                                        @Nonnull final String columnName, @Nonnull final String pattern) {
			return this.column(connectionCode, ConditionCode.SIMILAR_THAN, databaseName, tableName, columnName)
					.matchValue(pattern)
					.confirm();
		}

		/**
		 * <h3 class="en-US">Data column is not similar condition information builder</h3>
		 * <h3 class="zh-CN">数据列非模糊匹配条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public GroupConditionBuilder<P> notSimilar(@Nonnull final ConnectionCode connectionCode,
		                                           @Nonnull final String databaseName, @Nonnull final String tableName,
		                                           @Nonnull final String columnName, @Nonnull final String pattern) {
			return this.column(connectionCode, ConditionCode.NOT_SIMILAR, databaseName, tableName, columnName)
					.matchValue(pattern)
					.confirm();
		}

		/**
		 * <h3 class="en-US">Data exists condition information builder</h3>
		 * <h3 class="zh-CN">数据存在条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ExistConditionBuilder<GroupConditionBuilder<P>> exists(@Nonnull final ConnectionCode connectionCode) {
			return new ExistConditionBuilder<>(this, connectionCode, Boolean.FALSE);
		}

		/**
		 * <h3 class="en-US">Data don't exist condition information builder</h3>
		 * <h3 class="zh-CN">数据不存在条件信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		public ExistConditionBuilder<GroupConditionBuilder<P>> notExists(@Nonnull final ConnectionCode connectionCode) {
			return new ExistConditionBuilder<>(this, connectionCode, Boolean.TRUE);
		}

		/**
		 * <h3 class="en-US">Data column query condition information builder</h3>
		 * <h3 class="zh-CN">数据列查询信息构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @param conditionCode  <span class="en-US">Query condition code</span>
		 *                       <span class="zh-CN">查询条件运算代码</span>
		 * @param databaseName   <span class="en-US">Database identify information</span>
		 *                       <span class="zh-CN">数据库识别信息</span>
		 * @param tableName      <span class="en-US">Data table name</span>
		 *                       <span class="zh-CN">数据表名</span>
		 * @param columnName     <span class="en-US">Data column name</span>
		 *                       <span class="zh-CN">数据列名</span>
		 * @return <span class="en-US">Data column query condition information builder instance object</span>
		 * <span class="zh-CN">数据列查询信息构建器实例对象</span>
		 */
		private ColumnConditionBuilder<GroupConditionBuilder<P>> column(@Nonnull final ConnectionCode connectionCode,
		                                                                @Nonnull final ConditionCode conditionCode,
		                                                                @Nonnull final String databaseName,
		                                                                @Nonnull final String tableName,
		                                                                @Nonnull final String columnName) {
			return new ColumnConditionBuilder<>(this, connectionCode, conditionCode, databaseName, tableName, columnName);
		}

		/**
		 * <h3 class="en-US">Group query condition information builder</h3>
		 * <h3 class="zh-CN">查询信息组构建器</h3>
		 *
		 * @return <span class="en-US">Group query condition information builder instance object</span>
		 * <span class="zh-CN">查询信息组构建器实例对象</span>
		 */
		public GroupConditionBuilder<GroupConditionBuilder<P>> group() {
			return this.group(ConnectionCode.AND);
		}

		/**
		 * <h3 class="en-US">Group query condition information builder</h3>
		 * <h3 class="zh-CN">查询信息组构建器</h3>
		 *
		 * @param connectionCode <span class="en-US">Query connection code</span>
		 *                       <span class="zh-CN">查询条件连接代码</span>
		 * @return <span class="en-US">Group query condition information builder instance object</span>
		 * <span class="zh-CN">查询信息组构建器实例对象</span>
		 */
		public GroupConditionBuilder<GroupConditionBuilder<P>> group(@Nonnull final ConnectionCode connectionCode) {
			return new GroupConditionBuilder<>(this, connectionCode);
		}

		@Override
		public void confirm(final Object object) throws BuilderException {
			if (object instanceof AbstractCondition) {
				this.conditionList.add((AbstractCondition) object);
			}
		}

		@Override
		public GroupCondition build() {
			this.condition.setConditionList(this.conditionList);
			return this.condition;
		}
	}

	/**
	 * <h2 class="en-US">Query conditions information</h2>
	 * <h2 class="zh-CN">查询条件信息列表</h2>
	 *
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class Conditions {

		/**
		 * <span class="en-US">Query condition instance list</span>
		 * <span class="zh-CN">查询条件实例对象列表</span>
		 */
		@Nonnull
		private final List<AbstractCondition> conditions;
		/**
		 * <span class="en-US">Having condition flag</span>
		 * <span class="zh-CN">Having字句条件标记</span>
		 */
		private final boolean having;

		/**
		 * <h3 class="en-US">Constructor method for the query conditions information</h3>
		 * <h3 class="zh-CN">查询条件信息列表的构造方法</h3>
		 *
		 * @param conditions <span class="en-US">Query condition instance list</span>
		 *                   <span class="zh-CN">查询条件实例对象列表</span>
		 * @param having     <span class="en-US">Having condition flag</span>
		 *                   <span class="zh-CN">Having字句条件标记</span>
		 */
		public Conditions(@Nonnull final List<AbstractCondition> conditions, final boolean having) {
			this.conditions = conditions;
			this.having = having;
		}

		/**
		 * <h3 class="en-US">Getter method for the query condition instance list</h3>
		 * <h3 class="zh-CN">查询条件实例对象列表的Getter方法</h3>
		 *
		 * @return <span class="en-US">Query condition instance list</span>
		 * <span class="zh-CN">查询条件实例对象列表</span>
		 */
		@Nonnull
		public List<AbstractCondition> getConditions() {
			return this.conditions;
		}

		/**
		 * <h3 class="en-US">Getter method for the having condition flag</h3>
		 * <h3 class="zh-CN">Having字句条件标记的Getter方法</h3>
		 *
		 * @return <span class="en-US">Having condition flag</span>
		 * <span class="zh-CN">Having字句条件标记</span>
		 */
		public boolean isHaving() {
			return this.having;
		}
	}

	/**
	 * <h2 class="en-US">Abstract class for query conditions information builder</h2>
	 * <h2 class="zh-CN">查询条件信息构建器抽象类</h2>
	 *
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	private static abstract class ConditionBuilder<P extends ParentBuilder, T extends AbstractCondition>
			extends AbstractBuilder<P, T> {

		/**
		 * <span class="en-US">Query condition instance object</span>
		 * <span class="zh-CN">查询条件实例对象</span>
		 */
		protected final T condition;

		/**
		 * <h3 class="en-US">Protected constructor for AbstractBuilder</h3>
		 * <h3 class="zh-CN">AbstractBuilder的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 */
		protected ConditionBuilder(final P parentBuilder, final T condition) {
			super(parentBuilder);
			this.condition = condition;
		}
	}
}
