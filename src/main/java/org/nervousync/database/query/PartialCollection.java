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

package org.nervousync.database.query;

import jakarta.xml.bind.annotation.*;
import org.nervousync.database.query.result.ResultMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Query result partial collection defines</h2>
 * <h2 class="zh-CN">查询结果集定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0 $ $Date: Jan 13, 2010 4:07:14 PM $
 */
@XmlType(name = "partial_collection", namespace = "https://nervousync.org/schemas/database")
@XmlRootElement(name = "partial_collection", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class PartialCollection implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = -7464063220078318116L;

	/**
	 * <span class="en-US">Collection of query results</span>
	 * <span class="zh-CN">结果集列表</span>
	 */
	@XmlElement(name = "result_map")
	@XmlElementWrapper(name = "result_list")
	private List<ResultMap> resultList;
	/**
	 * <span class="en-US">Current page number</span>
	 * <span class="zh-CN">当前页码</span>
	 */
	@XmlElement(name = "page_number")
	private Integer pageNumber;
	/**
	 * <span class="en-US">Limit size of per page</span>
	 * <span class="zh-CN">每页最大条数</span>
	 */
	@XmlElement(name = "page_size")
	private Integer pageSize;
	/**
	 * <span class="en-US">Total count of the query</span>
	 * <span class="zh-CN">查询总记录数</span>
	 */
	@XmlElement(name = "total_count")
	private Long totalCount;

	/**
	 * <h3 class="en-US">Constructor method for query result partial collection defines</h3>
	 * <h3 class="zh-CN">查询结果集定义的构造方法</h3>
	 */
	public PartialCollection() {
		this.resultList = new ArrayList<>();
	}

	/**
	 * <h3 class="en-US">Getter method for the collection of query results</h3>
	 * <h3 class="zh-CN">结果集列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Collection of query results</span>
	 * <span class="zh-CN">结果集列表</span>
	 */
	public List<ResultMap> getResultList() {
		return this.resultList;
	}

	/**
	 * <h3 class="en-US">Setter method for the collection of query results</h3>
	 * <h3 class="zh-CN">结果集列表的 Setter 方法</h3>
	 *
	 * @param resultList <span class="en-US">Collection of query results</span>
	 *                   <span class="zh-CN">结果集列表</span>
	 */
	public void setResultList(final List<ResultMap> resultList) {
		this.resultList = resultList;
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

	/**
	 * <h3 class="en-US">Getter method for the total number of elements in the query</h3>
	 * <h3 class="zh-CN">查询总记录数的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Total number of elements in the query</span>
	 * <span class="zh-CN">查询总记录数</span>
	 */
	public Long getTotalCount() {
		return this.totalCount;
	}

	/**
	 * <h3 class="en-US">Setter method for the total number of elements in the query</h3>
	 * <h3 class="zh-CN">查询总记录数的 Setter 方法</h3>
	 *
	 * @param totalCount <span class="en-US">Total number of elements in the query</span>
	 *                   <span class="zh-CN">查询总记录数</span>
	 */
	public void setTotalCount(final Long totalCount) {
		this.totalCount = totalCount;
	}
}
