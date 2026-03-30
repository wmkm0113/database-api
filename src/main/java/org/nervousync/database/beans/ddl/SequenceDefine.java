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

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

/**
 * <h2 class="en-US">Sequence configure information</h2>
 * <h2 class="zh-CN">序列配置信息</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 24, 2026 10:05:12 $
 */
@XmlType(name = "sequence_define", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "sequence_define", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class SequenceDefine implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 4066313468387857820L;

	/**
	 * <span class="en-US">JDBC data type code</span>
	 * <span class="zh-CN">JDBC数据类型代码</span>
	 */
	@XmlElement(name = "jdbc_type")
	private int jdbcType;
	/**
	 * <span class="en-US">Initialize value</span>
	 * <span class="zh-CN">初始值</span>
	 */
	@XmlElement(name = "initial_value")
	private long initialValue;
	/**
	 * <span class="en-US">Increment value</span>
	 * <span class="zh-CN">增长值</span>
	 */
	@XmlElement(name = "increment_value")
	private long incrementValue;
	/**
	 * <span class="en-US">Minimum value</span>
	 * <span class="zh-CN">最小值</span>
	 */
	@XmlElement(name = "min_value")
	private long minValue;
	/**
	 * <span class="en-US">Maximum value</span>
	 * <span class="zh-CN">最大值</span>
	 */
	@XmlElement(name = "max_value")
	private long maxValue;
	/**
	 * <span class="en-US">Cycle flag</span>
	 * <span class="zh-CN">循环标记</span>
	 */
	@XmlElement
	private boolean cycle;
	/**
	 * <span class="en-US">Cache size, -1 for NO CACHE</span>
	 * <span class="zh-CN">缓存大小，-1为无缓存</span>
	 */
	@XmlElement(name = "cache_size")
	private int cacheSize;

	/**
	 * <h3 class="en-US">Constructor method for the sequence configure information</h3>
	 * <h3 class="zh-CN">序列配置信息的构造方法</h3>
	 */
	public SequenceDefine() {
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
	 * <h3 class="en-US">Getter method for the initialized value</h3>
	 * <h3 class="zh-CN">初始值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Initialize value</span>
	 * <span class="zh-CN">初始值</span>
	 */
	public long getInitialValue() {
		return this.initialValue;
	}

	/**
	 * <h3 class="en-US">Setter method for the initialize value</h3>
	 * <h3 class="zh-CN">初始值的 Setter 方法</h3>
	 *
	 * @param initialValue <span class="en-US">Initialize value</span>
	 *                     <span class="zh-CN">初始值</span>
	 */
	public void setInitialValue(final long initialValue) {
		this.initialValue = initialValue;
	}

	/**
	 * <h3 class="en-US">Getter method for the increment value</h3>
	 * <h3 class="zh-CN">增长值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Increment value</span>
	 * <span class="zh-CN">增长值</span>
	 */
	public long getIncrementValue() {
		return this.incrementValue;
	}

	/**
	 * <h3 class="en-US">Setter method for the increment value</h3>
	 * <h3 class="zh-CN">增长值的 Setter 方法</h3>
	 *
	 * @param incrementValue <span class="en-US">Increment value</span>
	 *                       <span class="zh-CN">增长值</span>
	 */
	public void setIncrementValue(final long incrementValue) {
		this.incrementValue = incrementValue;
	}

	/**
	 * <h3 class="en-US">Getter method for the minimum value</h3>
	 * <h3 class="zh-CN">最小值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Minimum value</span>
	 * <span class="zh-CN">最小值</span>
	 */
	public long getMinValue() {
		return this.minValue;
	}

	/**
	 * <h3 class="en-US">Setter method for the minimum value</h3>
	 * <h3 class="zh-CN">最小值的 Setter 方法</h3>
	 *
	 * @param minValue <span class="en-US">Minimum value</span>
	 *                 <span class="zh-CN">最小值</span>
	 */
	public void setMinValue(final long minValue) {
		this.minValue = minValue;
	}

	/**
	 * <h3 class="en-US">Getter method for the maximum value</h3>
	 * <h3 class="zh-CN">最大值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Maximum value</span>
	 * <span class="zh-CN">最大值</span>
	 */
	public long getMaxValue() {
		return this.maxValue;
	}

	/**
	 * <h3 class="en-US">Setter method for the maximum value</h3>
	 * <h3 class="zh-CN">最大值的 Setter 方法</h3>
	 *
	 * @param maxValue <span class="en-US">Maximum value</span>
	 *                 <span class="zh-CN">最大值</span>
	 */
	public void setMaxValue(final long maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * <h3 class="en-US">Getter method for the cycle flag</h3>
	 * <h3 class="zh-CN">循环标记的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Cycle flag</span>
	 * <span class="zh-CN">循环标记</span>
	 */
	public boolean isCycle() {
		return this.cycle;
	}

	/**
	 * <h3 class="en-US">Setter method for the cycle flag</h3>
	 * <h3 class="zh-CN">循环标记的 Setter 方法</h3>
	 *
	 * @param cycle <span class="en-US">Cycle flag</span>
	 *              <span class="zh-CN">循环标记</span>
	 */
	public void setCycle(final boolean cycle) {
		this.cycle = cycle;
	}

	/**
	 * <h3 class="en-US">Getter method for the cache size</h3>
	 * <h3 class="zh-CN">缓存大小的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Cache size, -1 for NO CACHE</span>
	 * <span class="zh-CN">缓存大小，-1为无缓存</span>
	 */
	public int getCacheSize() {
		return this.cacheSize;
	}

	/**
	 * <h3 class="en-US">Setter method for the cache size</h3>
	 * <h3 class="zh-CN">缓存大小的 Setter 方法</h3>
	 *
	 * @param cacheSize <span class="en-US">Cache size, -1 for NO CACHE</span>
	 *                  <span class="zh-CN">缓存大小，-1为无缓存</span>
	 */
	public void setCacheSize(final int cacheSize) {
		this.cacheSize = cacheSize;
	}
}
