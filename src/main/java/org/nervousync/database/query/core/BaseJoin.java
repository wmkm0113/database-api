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

package org.nervousync.database.query.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.*;
import org.nervousync.database.beans.WrapperImpl;
import org.nervousync.database.enumerations.CategoryType;
import org.nervousync.database.enumerations.JoinType;
import org.nervousync.database.query.join.JoinInfo;
import org.nervousync.database.query.join.QueryJoin;
import org.nervousync.database.query.join.TableJoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h2 class="en-US">Abstract query join information defines</h2>
 * <h2 class="zh-CN">查询关联信息抽象定义</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Jul 30, 2023 15:57:33 $
 */
@XmlSeeAlso({TableJoin.class, QueryJoin.class})
@XmlTransient
@XmlAccessorType(XmlAccessType.NONE)
public abstract class BaseJoin extends WrapperImpl {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 5429421831753628828L;

	/**
	 * <span class="en-US">Enumeration value of category type</span>
	 * <span class="zh-CN">分类类型的枚举值</span>
	 */
	@JsonIgnore
	private final CategoryType categoryType;
	/**
	 * <span class="en-US">Join table alias name</span>
	 * <span class="zh-CN">关联表别名</span>
	 */
	@XmlElement(name = "alias_name")
	private String aliasName;
	/**
	 * <span class="en-US">Table join type</span>
	 * <span class="zh-CN">数据表关联类型</span>
	 */
	@XmlElement(name = "join_type")
	private JoinType joinType;
	/**
	 * <span class="en-US">Join columns list</span>
	 * <span class="zh-CN">关联列信息列表</span>
	 */
	@XmlElement(name = "join_info")
	@XmlElementWrapper(name = "join_info_list")
	private List<JoinInfo> joinInfos = new ArrayList<>();

	/**
	 * <h3 class="en-US">Constructor method for the abstract query join information defines</h3>
	 * <h3 class="zh-CN">查询关联信息抽象定义的构造方法</h3>
	 *
	 * @param categoryType <span class="en-US">Enumeration value of category type</span>
	 *                     <span class="zh-CN">分类类型的枚举值</span>
	 */
	protected BaseJoin(final CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	/**
	 * <h3 class="en-US">Getter method for the enumeration value of the category type</h3>
	 * <h3 class="zh-CN">分类类型的枚举值的 Getter 方法</h3>
	 *
	 * @return <span class="en-US">Enumeration value of category type</span>
	 * <span class="zh-CN">分类类型的枚举值</span>
	 */
	public CategoryType getCategoryType() {
		return this.categoryType;
	}

	/**
	 * <h3 class="en-US">Getter method for join table alias name</h3>
	 * <h3 class="zh-CN">关联表别名的Getter方法</h3>
	 *
	 * @return <span class="en-US">Join table alias name</span>
	 * <span class="zh-CN">关联表别名</span>
	 */
	public String getAliasName() {
		return this.aliasName;
	}

	/**
	 * <h3 class="en-US">Setter method for join table alias name</h3>
	 * <h3 class="zh-CN">关联表别名的Setter方法</h3>
	 *
	 * @param aliasName <span class="en-US">Join table alias name</span>
	 *                  <span class="zh-CN">关联表别名</span>
	 */
	public void setAliasName(final String aliasName) {
		this.aliasName = aliasName;
	}

	/**
	 * <h3 class="en-US">Getter method for the table join type</h3>
	 * <h3 class="zh-CN">数据表关联类型的Getter方法</h3>
	 *
	 * @return <span class="en-US">Table join type</span>
	 * <span class="zh-CN">数据表关联类型</span>
	 */
	public JoinType getJoinType() {
		return this.joinType;
	}

	/**
	 * <h3 class="en-US">Setter method for the table join type</h3>
	 * <h3 class="zh-CN">数据表关联类型的Setter方法</h3>
	 *
	 * @param joinType <span class="en-US">Table join type</span>
	 *                 <span class="zh-CN">数据表关联类型</span>
	 */
	public void setJoinType(final JoinType joinType) {
		this.joinType = joinType;
	}

	/**
	 * <h3 class="en-US">Getter method for the join columns list</h3>
	 * <h3 class="zh-CN">关联列信息列表的Getter方法</h3>
	 *
	 * @return <span class="en-US">Join columns list</span>
	 * <span class="zh-CN">关联列信息列表</span>
	 */
	public List<JoinInfo> getJoinInfos() {
		return this.joinInfos;
	}

	/**
	 * <h3 class="en-US">Setter method for the join columns list</h3>
	 * <h3 class="zh-CN">关联列信息列表的Setter方法</h3>
	 *
	 * @param joinInfos <span class="en-US">Join columns list</span>
	 *                  <span class="zh-CN">关联列信息列表</span>
	 */
	public void setJoinInfos(final List<JoinInfo> joinInfos) {
		this.joinInfos = (joinInfos == null) ? Collections.emptyList() : joinInfos;
	}
}
