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

package org.nervousync.database.beans.dml;

import jakarta.xml.bind.annotation.*;
import org.nervousync.database.beans.match.BaseMatch;
import org.nervousync.database.beans.match.impl.ColumnMatch;
import org.nervousync.database.beans.match.impl.ConstantMatch;
import org.nervousync.database.query.from.FromTable;

import java.io.Serializable;
import java.util.List;

/**
 * <h2 class="en-US">Data filter match define</h2>
 * <h2 class="zh-CN">数据查询匹配定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Mar 30, 2026 10:06:27 $
 */
@XmlRootElement(name = "filter_define", namespace = "https://nervousync.org/schemas/database")
@XmlAccessorType(XmlAccessType.NONE)
public final class FilterDefine implements Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 2283185718222507016L;

	/**
	 * <span class="en-US">Related query information</span>
	 * <span class="zh-CN">关联查询信息</span>
	 */
	@XmlElement(name = "from_table")
	private FromTable fromTable;
	/**
	 * <span class="en-US">Match information list</span>
	 * <span class="zh-CN">匹配信息列表</span>
	 */
	@XmlElementRefs({
			@XmlElementRef(name = "column_match", type = ColumnMatch.class),
			@XmlElementRef(name = "constant_match", type = ConstantMatch.class)
	})
	@XmlElementWrapper(name = "match_list")
	private List<BaseMatch> matchList;

	/**
	 * <h3 class="en-US">Constructor method for the data filter match define</h3>
	 * <h3 class="zh-CN">数据查询匹配定义的构造方法</h3>
	 */
	public FilterDefine() {
	}

	/**
	 * <h3 class="en-US">Getter method for the related query information</h3>
	 * <h3 class="zh-CN">关联查询信息的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Related query information</span>
	 * <span class="zh-CN">关联查询信息</span>
	 */
	public FromTable getFromTable() {
		return this.fromTable;
	}

	/**
	 * <h3 class="en-US">Setter method for the related query information</h3>
	 * <h3 class="zh-CN">关联查询信息的 Setter 方法</h3>
	 *
	 * @param fromTable <span class="en-US">Related query information</span>
	 *                  <span class="zh-CN">关联查询信息</span>
	 */
	public void setFromTable(final FromTable fromTable) {
		this.fromTable = fromTable;
	}

	/**
	 * <h3 class="en-US">Getter method for the match information list</h3>
	 * <h3 class="zh-CN">匹配信息列表的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Match information list</span>
	 * <span class="zh-CN">匹配信息列表</span>
	 */
	public List<BaseMatch> getMatchList() {
		return this.matchList;
	}

	/**
	 * <h3 class="en-US">Setter method for the match information list</h3>
	 * <h3 class="zh-CN">匹配信息列表的 Setter 方法</h3>
	 *
	 * @param matchList <span class="en-US">Match information list</span>
	 *                  <span class="zh-CN">匹配信息列表</span>
	 */
	public void setMatchList(final List<BaseMatch> matchList) {
		this.matchList = matchList;
	}
}
