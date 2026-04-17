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
import java.util.ArrayList;
import java.util.List;

/**
 * <h2 class="en-US">Query result map defines</h2>
 * <h2 class="zh-CN">查询结果集定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Oct 28, 2020 11:46:08 $
 */
@XmlType(name = "result_list", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class ResultList implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 2314522560232437367L;

	/**
	 * <span class="en-US">Data column meta information list</span>
	 * <span class="zh-CN">数据列元数据信息列表</span>
	 */
	@XmlElement(name = "meta_data")
	@XmlElementWrapper(name = "meta_list")
	private List<ResultMeta> metaList;
	/**
	 * <span class="en-US">Data record information list</span>
	 * <span class="zh-CN">数据记录信息列表</span>
	 */
	@XmlElement(name = "result_data")
	@XmlElementWrapper(name = "data_list")
	private List<ResultData> dataList;

	/**
	 * <h3 class="en-US">Constructor method for the query result map defines</h3>
	 * <h3 class="zh-CN">查询结果集定义的构造方法</h3>
	 */
	public ResultList() {
		this.metaList = new ArrayList<>();
		this.dataList = new ArrayList<>();
	}

	/**
	 * <h3 class="en-US">Getter method for the data column meta information list</h3>
	 * <h3 class="zh-CN">数据列元数据信息列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data column meta information list</span>
	 * <span class="zh-CN">数据列元数据信息列表</span>
	 */
	public List<ResultMeta> getMetaList() {
		return this.metaList;
	}

	/**
	 * <h3 class="en-US">Setter method for the data column meta information list</h3>
	 * <h3 class="zh-CN">数据列元数据信息列表的 Setter 方法</h3>
	 *
	 * @param metaList <span class="en-US">Data column meta information list</span>
	 *                 <span class="zh-CN">数据列元数据信息列表</span>
	 */
	public void setMetaList(final List<ResultMeta> metaList) {
		this.metaList = metaList;
	}

	/**
	 * <h3 class="en-US">Getter method for the data record information list</h3>
	 * <h3 class="zh-CN">数据记录信息列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Data record information list</span>
	 * <span class="zh-CN">数据记录信息列表</span>
	 */
	public List<ResultData> getDataList() {
		return this.dataList;
	}

	/**
	 * <h3 class="en-US">Setter method for the data record information list</h3>
	 * <h3 class="zh-CN">数据记录信息列表的 Setter 方法</h3>
	 *
	 * @param dataList <span class="en-US">Data record information list</span>
	 *                 <span class="zh-CN">数据记录信息列表</span>
	 */
	public void setDataList(final List<ResultData> dataList) {
		this.dataList = dataList;
	}
}
