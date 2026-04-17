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
import org.intellij.lang.annotations.MagicConstant;
import org.nervousync.builder.AbstractBuilder;
import org.nervousync.builder.ParentBuilder;
import org.nervousync.database.enumerations.CalculateCode;
import org.nervousync.database.enumerations.ItemType;
import org.nervousync.database.query.QueryInfo;
import org.nervousync.database.query.core.AbstractItem;
import org.nervousync.database.query.item.*;
import org.nervousync.exceptions.builder.BuilderException;
import org.nervousync.utils.core.StringUtils;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <h2 class="en-US">Query items information list builder</h2>
 * <h2 class="zh-CN">查询项目信息列表构建器</h2>
 *
 * @param <P> <span class="en-US">Parent builder generic type class</span>
 *            <span class="zh-CN">父构建器泛型类</span>
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
public final class ItemsBuilder<P extends ParentBuilder> extends AbstractBuilder<P, ItemsBuilder.Items> {

	/**
	 * <span class="en-US">Query item instance list</span>
	 * <span class="zh-CN">查询项目实例对象列表</span>
	 */
	@Nonnull
	private final List<AbstractItem> itemList = new ArrayList<>();

	/**
	 * <h3 class="en-US">Constructor method for the query items information list builder</h3>
	 * <h3 class="zh-CN">查询项目信息列表构建器的构造函数</h3>
	 *
	 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
	 *                      <span class="zh-CN">父构建器实例对象</span>
	 * @param itemList      <span class="en-US">Query item instance list</span>
	 *                      <span class="zh-CN">查询项目实例对象列表</span>
	 */
	public ItemsBuilder(final P parentBuilder, final List<AbstractItem> itemList) {
		super(parentBuilder);
		if (itemList != null) {
			this.itemList.addAll(itemList);
		}
	}

	/**
	 * <h3 class="en-US">Calculate item information builder</h3>
	 * <h3 class="zh-CN">计算查询项构建器</h3>
	 *
	 * @param calculateCode <span class="en-US">Enumeration value of calculate code</span>
	 *                      <span class="zh-CN">计算代码的枚举值</span>
	 * @param jdbcType      <span class="en-US">Jdbc type code</span>
	 *                      <span class="zh-CN">JDBC类型代码</span>
	 * @return <span class="en-US">Calculate item information builder instance object</span>
	 * <span class="zh-CN">计算查询项构建器实例对象</span>
	 */
	public ItemsBuilder.CalculateItemBuilder<ItemsBuilder<P>> calculate(@Nonnull final CalculateCode calculateCode,
	                                                                    @MagicConstant(valuesFromClass = Types.class) final int jdbcType) {
		return new CalculateItemBuilder<>(this, calculateCode, jdbcType);
	}

	/**
	 * <h3 class="en-US">Data column item information builder</h3>
	 * <h3 class="zh-CN">数据列查询项构建器</h3>
	 *
	 * @param tableName  <span class="en-US">Data table name</span>
	 *                   <span class="zh-CN">数据表名</span>
	 * @param columnName <span class="en-US">Data column name</span>
	 *                   <span class="zh-CN">数据列名</span>
	 * @return <span class="en-US">Data column item information builder instance object</span>
	 * <span class="zh-CN">数据列查询项构建器实例对象</span>
	 */
	public ItemsBuilder<P> column(@Nonnull final String databaseName, @Nonnull final String tableName,
	                              @Nonnull final String columnName, final String aliasName,
	                              @MagicConstant(valuesFromClass = Types.class) final int jdbcType,
	                              final boolean distinct) {
		AtomicBoolean exist = new AtomicBoolean(Boolean.FALSE);
		this.itemList.replaceAll(baseItem -> {
			if (ItemType.COLUMN.equals(baseItem.getItemType())) {
				baseItem.setJdbcType(jdbcType);
				if (StringUtils.notBlank(aliasName)) {
					baseItem.setAliasName(aliasName);
				}
				((ColumnItem) baseItem).setDistinct(distinct);
				exist.set(Boolean.TRUE);
			}
			return baseItem;
		});
		if (!exist.get()) {
			ColumnItem columnItem = new ColumnItem();
			columnItem.setAliasName(aliasName);
			columnItem.setJdbcType(jdbcType);
			columnItem.setDatabaseName(databaseName);
			columnItem.setTableName(tableName);
			columnItem.setColumnName(columnName);
			columnItem.setDistinct(distinct);
			this.itemList.add(columnItem);
		}
		return this;
	}

	/**
	 * <h3 class="en-US">Constant value item information builder</h3>
	 * <h3 class="zh-CN">常量值查询项构建器</h3>
	 *
	 * @param constantValue <span class="en-US">Constant value</span>
	 *                      <span class="zh-CN">常量值</span>
	 * @param aliasName     <span class="en-US">Alias name</span>
	 *                      <span class="zh-CN">别名</span>
	 * @param jdbcType      <span class="en-US">Jdbc type code</span>
	 *                      <span class="zh-CN">JDBC类型代码</span>
	 * @return <span class="en-US">Constant value item information builder instance object</span>
	 * <span class="zh-CN">常量值查询项构建器实例对象</span>
	 */
	public ItemsBuilder<P> constant(@Nonnull final Object constantValue,
	                                @Nonnull final String aliasName,
	                                @MagicConstant(valuesFromClass = Types.class) final int jdbcType) {
		AtomicBoolean exist = new AtomicBoolean(Boolean.FALSE);
		this.itemList.replaceAll(baseItem -> {
			if (ItemType.CONSTANT.equals(baseItem.getItemType())) {
				baseItem.setJdbcType(jdbcType);
				if (StringUtils.notBlank(aliasName)) {
					baseItem.setAliasName(aliasName);
				}
				((ConstantItem) baseItem).setConstantValue(constantValue);
				exist.set(Boolean.TRUE);
			}
			return baseItem;
		});
		if (!exist.get()) {
			ConstantItem constantItem = new ConstantItem();
			constantItem.setAliasName(aliasName);
			constantItem.setJdbcType(jdbcType);
			constantItem.setConstantValue(constantValue);
			this.itemList.add(constantItem);
		}
		return this;
	}

	/**
	 * <h3 class="en-US">Function query item information builder</h3>
	 * <h3 class="zh-CN">函数查询项构建器</h3>
	 *
	 * @param functionName <span class="en-US">Function name</span>
	 *                     <span class="zh-CN">函数名</span>
	 * @param jdbcType     <span class="en-US">Jdbc type code</span>
	 *                     <span class="zh-CN">JDBC类型代码</span>
	 * @return <span class="en-US">Function query item information builder instance object</span>
	 * <span class="zh-CN">函数查询项构建器实例对象</span>
	 */
	public ItemsBuilder.FunctionItemBuilder<ItemsBuilder<P>> function(@Nonnull final String functionName,
	                                                                  @MagicConstant(valuesFromClass = Types.class) final int jdbcType) {
		return new FunctionItemBuilder<>(this, functionName, jdbcType);
	}

	/**
	 * <h3 class="en-US">Query information builder</h3>
	 * <h3 class="zh-CN">查询信息构建器</h3>
	 *
	 * @return <span class="en-US">Query information builder instance object</span>
	 * <span class="zh-CN">查询信息构建器实例对象</span>
	 */
	public SubQueryItemBuilder<ItemsBuilder<P>> subQuery() {
		return new SubQueryItemBuilder<>(this);
	}

	@Override
	public void confirm(final Object object) {
		if (object instanceof AbstractItem) {
			this.itemList.add((AbstractItem) object);
		}
	}

	@Override
	public Items build() {
		return new Items(this.itemList);
	}

	/**
	 * <h2 class="en-US">Query items information list</h2>
	 * <h2 class="zh-CN">查询项目信息列表</h2>
	 *
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class Items {

		/**
		 * <span class="en-US">Query item instance list</span>
		 * <span class="zh-CN">查询项目实例对象列表</span>
		 */
		@Nonnull
		private final List<AbstractItem> itemList;

		/**
		 * <h3 class="en-US">Constructor method for the query items information</h3>
		 * <h3 class="zh-CN">查询项目信息列表的构造方法</h3>
		 *
		 * @param itemList <span class="en-US">Query item instance list</span>
		 *                 <span class="zh-CN">查询项目实例对象列表</span>
		 */
		public Items(@Nonnull final List<AbstractItem> itemList) {
			this.itemList = itemList;
		}

		/**
		 * <h3 class="en-US">Getter method for the query item instance list</h3>
		 * <h3 class="zh-CN">查询项目实例对象列表的Getter方法</h3>
		 *
		 * @return <span class="en-US">Query item instance list</span>
		 * <span class="zh-CN">查询项目实例对象列表</span>
		 */
		@Nonnull
		public List<AbstractItem> getItemList() {
			return this.itemList;
		}
	}

	/**
	 * <h2 class="en-US">Abstract class of query item information builder</h2>
	 * <h2 class="zh-CN">查询项信息构建器抽象类</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder instance object</span>
	 *            <span class="zh-CN">父构建器实例对象</span>
	 * @param <T> <span class="en-US">Query item generic type</span>
	 *            <span class="zh-CN">查询项泛型类型</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static abstract class QueryItemBuilder<P extends ParentBuilder, T extends AbstractItem>
			extends AbstractBuilder<P, T> {

		/**
		 * <span class="en-US">Query item instance object</span>
		 * <span class="zh-CN">查询项实例对象</span>
		 */
		protected final T item;

		/**
		 * <h3 class="en-US">Protected constructor for AbstractBuilder</h3>
		 * <h3 class="zh-CN">AbstractBuilder的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param item          <span class="en-US">Query item instance object</span>
		 *                      <span class="zh-CN">查询项实例对象</span>
		 */
		protected QueryItemBuilder(final P parentBuilder, final T item) {
			super(parentBuilder);
			this.item = item;
		}

		@Override
		public final T build() throws BuilderException {
			return this.item;
		}
	}

	/**
	 * <h2 class="en-US">Calculate query item information builder</h2>
	 * <h2 class="zh-CN">计算查询项信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder instance object</span>
	 *            <span class="zh-CN">父构建器实例对象</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class CalculateItemBuilder<P extends ParentBuilder> extends QueryItemBuilder<P, CalculateItem> {

		/**
		 * <h3 class="en-US">Constructor method for the calculated query item information builder</h3>
		 * <h3 class="zh-CN">计算查询项信息构建器的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param calculateCode <span class="en-US">Enumeration value of calculate code</span>
		 *                      <span class="zh-CN">计算代码的枚举值</span>
		 * @param jdbcType      <span class="en-US">Jdbc type code</span>
		 *                      <span class="zh-CN">JDBC类型代码</span>
		 */
		CalculateItemBuilder(final P parentBuilder, @Nonnull final CalculateCode calculateCode,
		                     @MagicConstant(valuesFromClass = Types.class) final int jdbcType) {
			super(parentBuilder, new CalculateItem());
			this.item.setCalculateCode(calculateCode);
			this.item.setJdbcType(jdbcType);
		}

		/**
		 * <h3 class="en-US">Parameter items builder</h3>
		 * <h3 class="zh-CN">参数信息构建器</h3>
		 *
		 * @return <span class="en-US">Parameter items builder instance object</span>
		 * <span class="zh-CN">参数信息构建器实例对象</span>
		 */
		public ParametersBuilder<CalculateItemBuilder<P>> parameters() {
			return new ParametersBuilder<>(this, this.item.getCalculateParameters());
		}

		/**
		 * <h3 class="en-US">Set alias name</h3>
		 * <h3 class="zh-CN">设置别名</h3>
		 *
		 * @param aliasName <span class="en-US">Alias name</span>
		 *                  <span class="zh-CN">别名</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public CalculateItemBuilder<P> aliasName(final String aliasName) {
			this.item.setAliasName(aliasName);
			return this;
		}

		@Override
		public void confirm(final Object object) {
			if (object instanceof ParametersBuilder.Parameters) {
				this.item.setCalculateParameters(((ParametersBuilder.Parameters) object).getParameters());
			}
		}
	}

	/**
	 * <h2 class="en-US">Function query item information builder</h2>
	 * <h2 class="zh-CN">函数查询项信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder instance object</span>
	 *            <span class="zh-CN">父构建器实例对象</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class FunctionItemBuilder<P extends ParentBuilder> extends QueryItemBuilder<P, FunctionItem> {

		/**
		 * <h3 class="en-US">Constructor method for the function query item information builder</h3>
		 * <h3 class="zh-CN">函数查询项信息构建器的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param functionName  <span class="en-US">Function name</span>
		 *                      <span class="zh-CN">函数名</span>
		 * @param jdbcType      <span class="en-US">Jdbc type code</span>
		 *                      <span class="zh-CN">JDBC类型代码</span>
		 */
		FunctionItemBuilder(final P parentBuilder, final String functionName,
		                    @MagicConstant(valuesFromClass = Types.class) final int jdbcType) {
			super(parentBuilder, new FunctionItem());
			this.item.setFunctionName(functionName);
			this.item.setJdbcType(jdbcType);
		}

		/**
		 * <h3 class="en-US">Set alias name</h3>
		 * <h3 class="zh-CN">设置别名</h3>
		 *
		 * @param aliasName <span class="en-US">Alias name</span>
		 *                  <span class="zh-CN">别名</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public FunctionItemBuilder<P> aliasName(final String aliasName) {
			this.item.setAliasName(aliasName);
			return this;
		}

		/**
		 * <h3 class="en-US">Function parameters builder</h3>
		 * <h3 class="zh-CN">函数参数信息构建器</h3>
		 *
		 * @return <span class="en-US">Function parameters builder instance object</span>
		 * <span class="zh-CN">函数参数信息构建器实例对象</span>
		 */
		public ParametersBuilder<FunctionItemBuilder<P>> parameters() {
			return new ParametersBuilder<>(this, this.item.getFunctionParameters());
		}

		@Override
		public void confirm(final Object object) {
			if (object instanceof ParametersBuilder.Parameters) {
				this.item.setFunctionParameters(((ParametersBuilder.Parameters) object).getParameters());
			}
		}
	}

	/**
	 * <h2 class="en-US">Sub-query item information builder</h2>
	 * <h2 class="zh-CN">子查询信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder instance object</span>
	 *            <span class="zh-CN">父构建器实例对象</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class SubQueryItemBuilder<P extends ParentBuilder> extends QueryItemBuilder<P, QueryItem> {

		/**
		 * <h3 class="en-US">Constructor method for the sub-query item information builder</h3>
		 * <h3 class="zh-CN">子查询信息构建器的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 */
		SubQueryItemBuilder(final P parentBuilder) {
			super(parentBuilder, new QueryItem());
		}

		/**
		 * <h3 class="en-US">Set alias name</h3>
		 * <h3 class="zh-CN">设置别名</h3>
		 *
		 * @param aliasName <span class="en-US">Alias name</span>
		 *                  <span class="zh-CN">别名</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public SubQueryItemBuilder<P> aliasName(final String aliasName) {
			this.item.setAliasName(aliasName);
			return this;
		}

		/**
		 * <h3 class="en-US">Condition match sub-query information builder</h3>
		 * <h3 class="zh-CN">匹配子查询构建器</h3>
		 *
		 * @return <span class="en-US">Sub-query builder instance object</span>
		 * <span class="zh-CN">子查询构建器实例对象</span>
		 */
		public QueryBuilder<SubQueryItemBuilder<P>> queryBuilder() {
			return new QueryBuilder<>(this);
		}

		/**
		 * <h3 class="en-US">Set JDBC type code</h3>
		 * <h3 class="zh-CN">设置JDBC类型代码</h3>
		 *
		 * @param jdbcType <span class="en-US">JDBC type code</span>
		 *                 <span class="zh-CN">JDBC类型代码</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public SubQueryItemBuilder<P> jdbcType(@MagicConstant(valuesFromClass = Types.class) final int jdbcType) {
			this.item.setJdbcType(jdbcType);
			return this;
		}

		@Override
		public void confirm(final Object object) {
			if (object instanceof QueryInfo) {
				this.item.setQueryInfo((QueryInfo) object);
			}
		}
	}
}
