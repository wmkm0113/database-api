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

package org.nervousync.database.beans;

import org.nervousync.database.exceptions.MultilingualSQLException;
import org.nervousync.utils.core.ClassUtils;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Wrapper;

/**
 * <h2 class="en-US">Implement class of java.sql.Wrapper</h2>
 * <h2 class="zh-CN">包装类实现</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Nov 12, 2020 18:51:19 $
 */
public abstract class WrapperImpl implements Wrapper, Serializable {

	/**
	 * <span class="en-US">Serial version UID</span>
	 * <span class="zh-CN">序列化UID</span>
	 */
	private static final long serialVersionUID = 45214350154588799L;

	@Override
	public final  <T> T unwrap(final Class<T> iface) throws SQLException {
		try {
			return iface.cast(this);
		} catch (ClassCastException e) {
			throw new MultilingualSQLException(0x00DB01000001L, e, iface.getName(), this.getClass().getName());
		}
	}

	@Override
	public final boolean isWrapperFor(final Class<?> iface) {
		return ClassUtils.isAssignable(iface, this.getClass());
	}
}
