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
import org.nervousync.database.query.QueryInfo;
import org.nervousync.database.query.core.BaseParameter;
import org.nervousync.database.query.item.CalculateItem;
import org.nervousync.database.query.item.FunctionItem;
import org.nervousync.database.query.param.*;
import org.nervousync.exceptions.builder.BuilderException;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Parameter information list builder</h2>
 * <h2 class="zh-CN">参数信息列表构建器</h2>
 *
 * @param <P> <span class="en-US">Parent builder generic type class</span>
 *            <span class="zh-CN">父构建器泛型类</span>
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
public final class ParametersBuilder<P extends ParentBuilder> extends AbstractBuilder<P, ParametersBuilder.Parameters> {

	/**
	 * <span class="en-US">Parameter information list</span>
	 * <span class="zh-CN">参数列表</span>
	 */
	@Nonnull
	private final List<BaseParameter> parameterList = new ArrayList<>();

	/**
	 * <h3 class="en-US">Constructor method for the function parameters information list builder</h3>
	 * <h3 class="zh-CN">函数参数信息列表构建器的构造方法</h3>
	 *
	 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
	 *                      <span class="zh-CN">父构建器实例对象</span>
	 * @param parameterList <span class="en-US">Parameter information list</span>
	 *                      <span class="zh-CN">参数信息列表</span>
	 */
	public ParametersBuilder(final P parentBuilder, final List<BaseParameter> parameterList) {
		super(parentBuilder);
		if (parameterList != null) {
			this.parameterList.addAll(parameterList);
		}
	}

	/**
	 * <h3 class="en-US">Calculate function parameter item builder</h3>
	 * <h3 class="zh-CN">计算参数信息构建器</h3>
	 *
	 * @return <span class="en-US">Calculate function parameter item builder instance object</span>
	 * <span class="zh-CN">计算参数信息构建器实例对象</span>
	 */
	public CalculateParameterBuilder<ParametersBuilder<P>> calculate() {
		return new CalculateParameterBuilder<>(this);
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
	public ParametersBuilder<P> column(@Nonnull final String databaseName, @Nonnull final String tableName,
	                                   @Nonnull final String columnName) {
		ColumnParameter columnParameter = new ColumnParameter();
		columnParameter.setDatabaseName(databaseName);
		columnParameter.setTableName(tableName);
		columnParameter.setColumnName(columnName);
		this.parameterList.add(columnParameter);
		return this;
	}

	/**
	 * <h3 class="en-US">Constant value item information builder</h3>
	 * <h3 class="zh-CN">常量值查询项构建器</h3>
	 *
	 * @param constantValue <span class="en-US">Constant value</span>
	 *                      <span class="zh-CN">常量值</span>
	 * @return <span class="en-US">Constant value item information builder instance object</span>
	 * <span class="zh-CN">常量值查询项构建器实例对象</span>
	 */
	public ParametersBuilder<P> constant(@Nonnull final Object constantValue) {
		ConstantParameter constantParameter = new ConstantParameter();
		constantParameter.setParameterValue(constantValue);
		this.parameterList.add(constantParameter);
		return this;
	}

	/**
	 * <h3 class="en-US">Function parameter item builder</h3>
	 * <h3 class="zh-CN">函数参数信息构建器</h3>
	 *
	 * @return <span class="en-US">Function parameter item builder instance object</span>
	 * <span class="zh-CN">函数参数信息构建器实例对象</span>
	 */
	public FunctionParameterBuilder<ParametersBuilder<P>> function() {
		return new FunctionParameterBuilder<>(this);
	}

	@Override
	public void confirm(final Object object) {
		if (object instanceof BaseParameter) {
			this.parameterList.add((BaseParameter) object);
		}
	}

	@Override
	public Parameters build() throws BuilderException {
		return new Parameters(this.parameterList);
	}

	/**
	 * <h2 class="en-US">Parameter information list</h2>
	 * <h2 class="zh-CN">参数信息列表</h2>
	 *
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
	 */
	public static final class Parameters {

		/**
		 * <span class="en-US">Parameter information list</span>
		 * <span class="zh-CN">参数信息列表</span>
		 */
		@Nonnull
		private final List<BaseParameter> parameters;

		/**
		 * <h3 class="en-US">Constructor method for the parameter information list</h3>
		 * <h3 class="zh-CN">参数信息列表的构造方法</h3>
		 *
		 * @param parameters <span class="en-US">Parameter information list</span>
		 *                   <span class="zh-CN">参数信息列表</span>
		 */
		public Parameters(@Nonnull final List<BaseParameter> parameters) {
			this.parameters = parameters;
		}

		/**
		 * <h3 class="en-US">Getter method for the parameter information list</h3>
		 * <h3 class="zh-CN">参数信息列表的Getter方法</h3>
		 *
		 * @return <span class="en-US">Parameter information list</span>
		 * <span class="zh-CN">参数信息列表</span>
		 */
		@Nonnull
		public List<BaseParameter> getParameters() {
			return this.parameters;
		}
	}

	/**
	 * <h2 class="en-US">Abstract class for parameter information builder</h2>
	 * <h2 class="zh-CN">参数信息构建器抽象类</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder generic type class</span>
	 *            <span class="zh-CN">父构建器泛型类</span>
	 * @param <T> <span class="en-US">Parameter information generic type class</span>
	 *            <span class="zh-CN">参数信息泛型类</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 11:42:46 $
	 */
	public static abstract class ParameterBuilder<P extends ParentBuilder, T extends BaseParameter>
			extends AbstractBuilder<P, T> {

		/**
		 * <span class="en-US">Parameter information instance object</span>
		 * <span class="zh-CN">参数信息实例对象</span>
		 */
		protected final T parameter;

		/**
		 * <h3 class="en-US">Protected constructor for AbstractBuilder</h3>
		 * <h3 class="zh-CN">AbstractBuilder的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 * @param parameter     <span class="en-US">Parameter information instance object</span>
		 *                      <span class="zh-CN">参数信息实例对象</span>
		 */
		protected ParameterBuilder(final P parentBuilder, final T parameter) {
			super(parentBuilder);
			this.parameter = parameter;
		}

		@Override
		public final T build() throws BuilderException {
			return this.parameter;
		}
	}

	/**
	 * <h2 class="en-US">Calculate parameter information builder</h2>
	 * <h2 class="zh-CN">计算参数信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder generic type class</span>
	 *            <span class="zh-CN">父构建器泛型类</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 11:42:46 $
	 */
	public static final class CalculateParameterBuilder<P extends ParentBuilder>
			extends ParameterBuilder<P, CalculateParameter> {

		/**
		 * <h3 class="en-US">Constructor method for calculating parameter information builder</h3>
		 * <h3 class="zh-CN">计算参数信息构建器的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 */
		CalculateParameterBuilder(final P parentBuilder) {
			super(parentBuilder, new CalculateParameter());
		}

		/**
		 * <h3 class="en-US">Calculate item builder instance object</h3>
		 * <h3 class="zh-CN">计算项目构建器实例对象</h3>
		 *
		 * @param calculateCode <span class="en-US">Enumeration value of calculate code</span>
		 *                      <span class="zh-CN">计算代码的枚举值</span>
		 * @param jdbcType      <span class="en-US">Jdbc type code</span>
		 *                      <span class="zh-CN">JDBC类型代码</span>
		 * @return <span class="en-US">Calculate item builder instance object</span>
		 * <span class="zh-CN">计算项目构建器实例对象</span>
		 */
		public ItemsBuilder.CalculateItemBuilder<CalculateParameterBuilder<P>> calculate(final CalculateCode calculateCode,
		                                                                                 @MagicConstant(valuesFromClass = Types.class) final int jdbcType) {
			return new ItemsBuilder.CalculateItemBuilder<>(this, calculateCode, jdbcType);
		}

		@Override
		public void confirm(final Object object) {
			if (object instanceof CalculateItem) {
				this.parameter.setCalculateItem((CalculateItem) object);
			}
		}
	}

	/**
	 * <h2 class="en-US">Function type parameter information builder</h2>
	 * <h2 class="zh-CN">函数型参数信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder generic type class</span>
	 *            <span class="zh-CN">父构建器泛型类</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 11:42:46 $
	 */
	public static final class FunctionParameterBuilder<P extends ParentBuilder>
			extends ParameterBuilder<P, FunctionParameter> {

		/**
		 * <h3 class="en-US">Constructor method for the function type parameter information builder</h3>
		 * <h3 class="zh-CN">函数型参数信息构建器的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 */
		FunctionParameterBuilder(final P parentBuilder) {
			super(parentBuilder, new FunctionParameter());
		}

		/**
		 * <h3 class="en-US">Function item builder instance object</h3>
		 * <h3 class="zh-CN">函数信息构建器实例对象</h3>
		 *
		 * @param functionName <span class="en-US">Function name</span>
		 *                     <span class="zh-CN">函数名</span>
		 * @param jdbcType     <span class="en-US">Jdbc type code</span>
		 *                     <span class="zh-CN">JDBC类型代码</span>
		 * @return <span class="en-US">Calculate item builder instance object</span>
		 * <span class="zh-CN">计算项目构建器实例对象</span>
		 */
		public ItemsBuilder.FunctionItemBuilder<FunctionParameterBuilder<P>> functionName(final String functionName,
		                                                                                  @MagicConstant(valuesFromClass = Types.class) final int jdbcType) {
			return new ItemsBuilder.FunctionItemBuilder<>(this, functionName, jdbcType);
		}

		@Override
		public void confirm(final Object object) {
			if (object instanceof FunctionItem) {
				this.parameter.setFunctionItem((FunctionItem) object);
			}
		}
	}

	/**
	 * <h2 class="en-US">Sub-query parameter information builder</h2>
	 * <h2 class="zh-CN">子查询参数信息构建器</h2>
	 *
	 * @param <P> <span class="en-US">Parent builder generic type class</span>
	 *            <span class="zh-CN">父构建器泛型类</span>
	 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
	 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 11:42:46 $
	 */
	public static final class QueryParameterBuilder<P extends ParentBuilder>
			extends ParameterBuilder<P, QueryParameter> {

		/**
		 * <h3 class="en-US">Constructor method for the sub-query parameter information builder</h3>
		 * <h3 class="zh-CN">子查询参数信息构建器的构造函数</h3>
		 *
		 * @param parentBuilder <span class="en-US">Parent builder instance object</span>
		 *                      <span class="zh-CN">父构建器实例对象</span>
		 */
		QueryParameterBuilder(final P parentBuilder) {
			super(parentBuilder, new QueryParameter());
		}

		/**
		 * <h3 class="en-US">Setting function name</h3>
		 * <h3 class="zh-CN">设置函数名</h3>
		 *
		 * @param functionName <span class="en-US">Function name</span>
		 *                     <span class="zh-CN">函数名</span>
		 * @return <span class="en-US">Current builder instance object</span>
		 * <span class="zh-CN">当前构建器实例对象</span>
		 */
		public QueryParameterBuilder<P> functionName(final String functionName) {
			this.parameter.setFunctionName(functionName);
			return this;
		}

		/**
		 * <h3 class="en-US">Sub-query information builder</h3>
		 * <h3 class="zh-CN">子查询构建器</h3>
		 *
		 * @return <span class="en-US">Sub-query information builder instance object</span>
		 * <span class="zh-CN">子查询构建器实例对象</span>
		 */
		public QueryBuilder<QueryParameterBuilder<P>> queryBuilder() {
			return new QueryBuilder<>(this);
		}

		@Override
		public void confirm(final Object object) {
			if (object instanceof QueryInfo) {
				this.parameter.setQueryInfo((QueryInfo) object);
			}
		}
	}
}
