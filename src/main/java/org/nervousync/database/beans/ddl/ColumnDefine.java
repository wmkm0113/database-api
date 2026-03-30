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

package org.nervousync.database.beans.ddl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.nervousync.commons.Globals;
import org.nervousync.database.enumerations.GenerationType;

import java.io.Serializable;

/**
 * <h2 class="en-US">Data column define</h2>
 * <h2 class="zh-CN">数据列定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 24, 2026 09:24:27 $
 */
@XmlType(name = "column_define", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ColumnDefine implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -1524005042879648546L;

	/**
	 * <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	@XmlElement(name = "column_name")
	private String columnName;
	/**
	 * <span class="en-US">JDBC data type code</span>
	 * <span class="zh-CN">JDBC数据类型代码</span>
	 */
	@XmlElement(name = "jdbc_type")
	private int jdbcType;
	/**
	 * <span class="en-US">Data column is nullable</span>
	 * <span class="zh-CN">数据列允许为空值</span>
	 */
	@XmlElement
	private boolean nullable;
	/**
	 * <span class="en-US">Data column length</span>
	 * <span class="zh-CN">数据列长度</span>
	 */
	@XmlElement
	private int length;
	/**
	 * <span class="en-US">Data column precision</span>
	 * <span class="zh-CN">数据列精度</span>
	 */
	@XmlElement
	private int precision;
	/**
	 * <span class="en-US">Data column scale</span>
	 * <span class="zh-CN">数据列小数位数</span>
	 */
	@XmlElement
	private int scale;
	/**
	 * <span class="en-US">Data column default value</span>
	 * <span class="zh-CN">数据列默认值</span>
	 */
	@XmlElement(name = "default_value")
	private String defaultValue;
	/**
	 * <span class="en-US">Data column is primary key</span>
	 * <span class="zh-CN">数据列是否为主键</span>
	 */
	@XmlElement(name = "primary_key")
	private boolean primaryKey;
	/**
	 * <span class="en-US">Data column is unique</span>
	 * <span class="zh-CN">数据列是否唯一约束</span>
	 */
	@XmlElement
	private boolean unique;
	/**
	 * <span class="en-US">Data column is updatable</span>
	 * <span class="zh-CN">数据列可更新</span>
	 */
	@XmlElement
	private boolean updatable;
	/**
	 * <span class="en-US">Generation type</span>
	 * <span class="zh-CN">生成器类型</span>
	 */
	@XmlElement(name = "generation_type")
	private GenerationType generationType = GenerationType.NONE;
	/**
	 * <span class="en-US">Generator name</span>
	 * <span class="zh-CN">生成器名称</span>
	 */
	@XmlElement(name = "generator_name")
	private String generatorName = Globals.DEFAULT_VALUE_STRING;

	/**
	 * <h3 class="en-US">Constructor method for data column define</h3>
	 * <h3 class="zh-CN">数据列定义的构造方法</h3>
	 */
	public ColumnDefine() {
	}

	/**
	 * <h3 class="en-US">Getter method for the data column name</h3>
	 * <h3 class="zh-CN">数据列名的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	public String getColumnName() {
		return this.columnName;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column name</h3>
	 * <h3 class="zh-CN">数据列名的 Setter 方法</h3>
	 *
	 * @param columnName <span class="en-US">Data column name</span>
	 *                   <span class="zh-CN">数据列名</span>
	 */
	public void setColumnName(final String columnName) {
		this.columnName = columnName;
	}

	/**
	 * <h3 class="en-US">Getter method for the JDBC data type code</h3>
	 * <h3 class="zh-CN">JDBC数据类型代码的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">JDBC data type code</span>
	 * <span class="zh-CN">JDBC数据类型代码</span>
	 */
	public int getJdbcType() {
		return this.jdbcType;
	}

	/**
	 * <h3 class="en-US">Setter method for the JDBC data type code</h3>
	 * <h3 class="zh-CN">JDBC数据类型代码的 Setter 方法</h3>
	 *
	 * @param jdbcType <span class="en-US">JDBC data type code</span>
	 *                 <span class="zh-CN">JDBC数据类型代码</span>
	 */
	public void setJdbcType(final int jdbcType) {
		this.jdbcType = jdbcType;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column is nullable</h3>
	 * <h3 class="zh-CN">数据列允许为空值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column is nullable</span>
	 * <span class="zh-CN">数据列允许为空值</span>
	 */
	public boolean isNullable() {
		return this.nullable;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column is nullable</h3>
	 * <h3 class="zh-CN">数据列允许为空值的 Setter 方法</h3>
	 *
	 * @param nullable <span class="en-US">Data column is nullable</span>
	 *                 <span class="zh-CN">数据列允许为空值</span>
	 */
	public void setNullable(final boolean nullable) {
		this.nullable = nullable;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column length</h3>
	 * <h3 class="zh-CN">数据列长度的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column length</span>
	 * <span class="zh-CN">数据列长度</span>
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column length</h3>
	 * <h3 class="zh-CN">数据列长度的 Setter 方法</h3>
	 *
	 * @param length <span class="en-US">Data column length</span>
	 *               <span class="zh-CN">数据列长度</span>
	 */
	public void setLength(final int length) {
		this.length = length;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column precision</h3>
	 * <h3 class="zh-CN">数据列精度的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column precision</span>
	 * <span class="zh-CN">数据列精度</span>
	 */
	public int getPrecision() {
		return this.precision;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column precision</h3>
	 * <h3 class="zh-CN">数据列精度的 Setter 方法</h3>
	 *
	 * @param precision <span class="en-US">Data column precision</span>
	 *                  <span class="zh-CN">数据列精度</span>
	 */
	public void setPrecision(final int precision) {
		this.precision = precision;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column scale</h3>
	 * <h3 class="zh-CN">数据列小数位数的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column scale</span>
	 * <span class="zh-CN">数据列小数位数</span>
	 */
	public int getScale() {
		return this.scale;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column scale</h3>
	 * <h3 class="zh-CN">数据列小数位数的 Setter 方法</h3>
	 *
	 * @param scale <span class="en-US">Data column scale</span>
	 *              <span class="zh-CN">数据列小数位数</span>
	 */
	public void setScale(final int scale) {
		this.scale = scale;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column default value</h3>
	 * <h3 class="zh-CN">数据列默认值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column default value</span>
	 * <span class="zh-CN">数据列默认值</span>
	 */
	public String getDefaultValue() {
		return this.defaultValue;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column default value</h3>
	 * <h3 class="zh-CN">数据列默认值的 Setter 方法</h3>
	 *
	 * @param defaultValue <span class="en-US">Data column default value</span>
	 *                     <span class="zh-CN">数据列默认值</span>
	 */
	public void setDefaultValue(final String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column is a primary key</h3>
	 * <h3 class="zh-CN">数据列是否为主键的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column is primary key</span>
	 * <span class="zh-CN">数据列是否为主键</span>
	 */
	public boolean isPrimaryKey() {
		return this.primaryKey;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column is a primary key</h3>
	 * <h3 class="zh-CN">数据列是否为主键的 Setter 方法</h3>
	 *
	 * @param primaryKey <span class="en-US">Data column is primary key</span>
	 *                   <span class="zh-CN">数据列是否为主键</span>
	 */
	public void setPrimaryKey(final boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column is unique</h3>
	 * <h3 class="zh-CN">数据列是否唯一约束的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column is unique</span>
	 * <span class="zh-CN">数据列是否唯一约束</span>
	 */
	public boolean isUnique() {
		return this.unique;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column is unique</h3>
	 * <h3 class="zh-CN">数据列是否唯一约束的 Setter 方法</h3>
	 *
	 * @param unique <span class="en-US">Data column is unique</span>
	 *               <span class="zh-CN">数据列是否唯一约束</span>
	 */
	public void setUnique(final boolean unique) {
		this.unique = unique;
	}

	/**
	 * <h3 class="en-US">Getter method for the data column is updatable</h3>
	 * <h3 class="zh-CN">数据列可更新的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column is updatable</span>
	 * <span class="zh-CN">数据列可更新</span>
	 */
	public boolean isUpdatable() {
		return this.updatable;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column is updatable</h3>
	 * <h3 class="zh-CN">数据列可更新的 Setter 方法</h3>
	 *
	 * @param updatable <span class="en-US">Data column is updatable</span>
	 *                  <span class="zh-CN">数据列可更新</span>
	 */
	public void setUpdatable(final boolean updatable) {
		this.updatable = updatable;
	}

	/**
	 * <h3 class="en-US">Getter method for the generation type</h3>
	 * <h3 class="zh-CN">生成器类型的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Generation type</span>
	 * <span class="zh-CN">生成器类型</span>
	 */
	public GenerationType getGenerationType() {
		return this.generationType;
	}

	/**
	 * <h3 class="en-US">Setter method for the generation type</h3>
	 * <h3 class="zh-CN">生成器类型的 Setter 方法</h3>
	 *
	 * @param generationType <span class="en-US">Generation type</span>
	 *                       <span class="zh-CN">生成器类型</span>
	 */
	public void setGenerationType(final GenerationType generationType) {
		this.generationType = generationType;
	}

	/**
	 * <h3 class="en-US">Getter method for the generator name</h3>
	 * <h3 class="zh-CN">生成器名称的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Generator name</span>
	 * <span class="zh-CN">生成器名称</span>
	 */
	public String getGeneratorName() {
		return this.generatorName;
	}

	/**
	 * <h3 class="en-US">Setter method for the generator name</h3>
	 * <h3 class="zh-CN">生成器名称的 Setter 方法</h3>
	 *
	 * @param generatorName <span class="en-US">Generator name</span>
	 *                      <span class="zh-CN">生成器名称</span>
	 */
	public void setGeneratorName(final String generatorName) {
		this.generatorName = generatorName;
	}
}