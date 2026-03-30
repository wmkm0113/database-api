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

package org.nervousync.database.query.pager;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;

/**
 * <h2 class="en-US">Query pager define</h2>
 * <h2 class="zh-CN">查询分页信息定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Sep 14， 2020 17:15:28 $
 */
@XmlType(name = "page_limit", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class PageLimit implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 1338395901488025004L;

	/**
	 * <span class="en-US">Current page number</span>
	 * <span class="zh-CN">当前页码</span>
	 */
	private Integer pageNumber;
	/**
	 * <span class="en-US">Limit size of per page</span>
	 * <span class="zh-CN">每页最大条数</span>
	 */
	private Integer pageSize;

	/**
	 * <h3 class="en-US">Constructor method for the query pager define</h3>
	 * <h3 class="zh-CN">查询分页信息定义的构造方法</h3>
	 */
	public PageLimit() {
	}

	/**
	 * <h3 class="en-US">Getter method for the current page number</h3>
	 * <h3 class="zh-CN">当前页码的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Current page number</span>
	 * <span class="zh-CN">当前页码</span>
	 */
	public Integer getPageNumber() {
		return this.pageNumber;
	}

	/**
	 * <h3 class="en-US">Setter method for the current page number</h3>
	 * <h3 class="zh-CN">当前页码的 Setter 方法</h3>
	 *
	 * @param pageNumber <span class="en-US">Current page number</span>
	 *                   <span class="zh-CN">当前页码</span>
	 */
	public void setPageNumber(final Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * <h3 class="en-US">Getter method for the limit size of per page</h3>
	 * <h3 class="zh-CN">每页最大条数的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Limit size of per page</span>
	 * <span class="zh-CN">每页最大条数</span>
	 */
	public Integer getPageSize() {
		return this.pageSize;
	}

	/**
	 * <h3 class="en-US">Setter method for the limit size of per page</h3>
	 * <h3 class="zh-CN">每页最大条数的 Setter 方法</h3>
	 *
	 * @param pageSize <span class="en-US">Limit size of per page</span>
	 *                 <span class="zh-CN">每页最大条数</span>
	 */
	public void setPageSize(final Integer pageSize) {
		this.pageSize = pageSize;
	}
}
