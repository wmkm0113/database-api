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

package org.nervousync.database.query.result;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * <h2 class="en-US">Query record defines</h2>
 * <h2 class="zh-CN">查询记录定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
@XmlType(name = "result_data", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ResultData implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 104929700534873339L;

	/**
	 * <span class="en-US">Data item information list</span>
	 * <span class="zh-CN">数据项信息列表</span>
	 */
	@XmlElement(name = "result_item")
	@XmlElementWrapper(name = "item_list")
	private List<ResultItem> itemList;

	/**
	 * <h3 class="en-US">Constructor method for the query result data defines</h3>
	 * <h3 class="zh-CN">查询结果项定义的构造方法</h3>
	 */
	public ResultData() {
	}

	/**
	 * <h3 class="en-US">Getter method for the data item information list</h3>
	 * <h3 class="zh-CN">数据项信息列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data item information list</span>
	 * <span class="zh-CN">数据项信息列表</span>
	 */
	public List<ResultItem> getItemList() {
		return this.itemList;
	}

	/**
	 * <h3 class="en-US">Setter method for the data item information list</h3>
	 * <h3 class="zh-CN">数据项信息列表的 Setter 方法</h3>
	 *
	 * @param itemList <span class="en-US">Data item information list</span>
	 *                 <span class="zh-CN">数据项信息列表</span>
	 */
	public void setItemList(final List<ResultItem> itemList) {
		this.itemList = itemList;
	}
}
