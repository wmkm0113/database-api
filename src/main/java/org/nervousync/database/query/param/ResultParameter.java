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

package org.nervousync.database.query.param;

import jakarta.annotation.Nonnull;
import org.nervousync.database.enumerations.ItemType;
import org.nervousync.database.query.core.AbstractParameter;

/**
 * <h2 class="en-US">Query result parameter information define</h2>
 * <h2 class="zh-CN">查询结果参数定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 9, 2020 18:02:27 $
 */
public final class ResultParameter extends AbstractParameter {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -6794396805839283654L;

	/**
	 * <span class="en-US">Identify code</span>
	 * <span class="zh-CN">识别代码</span>
	 */
	private final Long identifyCode;
	/**
	 * <span class="en-US">Data column name</span>
	 * <span class="zh-CN">数据列名</span>
	 */
	private final String columnName;

	/**
	 * <h3 class="en-US">Constructor method for the query result parameter information define</h3>
	 * <h3 class="zh-CN">查询结果参数定义的构造方法</h3>
	 */
	public ResultParameter(@Nonnull final Long identifyCode, @Nonnull final String columnName) {
		super(ItemType.RESULT);
		this.identifyCode = identifyCode;
		this.columnName = columnName;
	}

	/**
	 * <h3 class="en-US">Getter method for the identify code</h3>
	 * <h3 class="zh-CN">识别代码的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Identify code</span>
	 * <span class="zh-CN">识别代码</span>
	 */
	public Long getIdentifyCode() {
		return this.identifyCode;
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
}
