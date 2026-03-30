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

package org.nervousync.database.remote;

import jakarta.annotation.Nonnull;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.ws.WebServiceClient;
import org.nervousync.annotations.beans.DataTransfer;
import org.nervousync.database.beans.ddl.IndexDefine;
import org.nervousync.database.beans.ddl.SequenceDefine;
import org.nervousync.database.beans.ddl.TableDefine;
import org.nervousync.database.beans.ddl.TableModify;
import org.nervousync.database.beans.dml.FilterDefine;
import org.nervousync.database.beans.dml.MappingDefine;
import org.nervousync.database.query.PartialCollection;
import org.nervousync.database.query.QueryInfo;
import org.nervousync.xml.adapters.beans.JsonBeanAdapter;

import java.util.Map;

/**
 * <h2 class="en-US">Data source operator interface</h2>
 * <h2 class="zh-CN">数据源操作器接口</h2>
 *
 * @author Steven Wee	<a href="mailto:wmkm0113@gmail.com">wmkm0113@gmail.com</a>
 * @version $Revision: 1.0.0 $ $Date: Nov 12, 2020 12:16:28 $
 */
@WebServiceClient
public interface RemoteClient {

	/**
	 * <h3 class="en-US">Begin transactional</h3>
	 * <h3 class="zh-CN">开启事务</h3>
	 *
	 * @param txCode    <span class="en-US">Transactional identify code</span>
	 *                  <span class="zh-CN">事务识别代码</span>
	 * @param isolation <span class="en-US">Isolation level</span>
	 *                  <span class="zh-CN">事务等级</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@GET
	@Path("/transactional/begin/{txCode}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean beginTransactional(@WebParam @PathParam("txCode") final long txCode,
	                           @WebParam @QueryParam("isolation") final int isolation);

	/**
	 * <h3 class="en-US">Rollback transactional</h3>
	 * <h3 class="zh-CN">回滚事务</h3>
	 *
	 * @param txCode <span class="en-US">Transactional identify code</span>
	 *               <span class="zh-CN">事务识别代码</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@GET
	@Path("/transactional/rollback/{txCode}")
	@Produces(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean rollback(@WebParam @PathParam("txCode") final Long txCode);

	/**
	 * <h3 class="en-US">Submit transactional execute</h3>
	 * <h3 class="zh-CN">提交事务执行</h3>
	 *
	 * @param txCode <span class="en-US">Transactional identify code</span>
	 *               <span class="zh-CN">事务识别代码</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@GET
	@Path("/transactional/commit/{txCode}")
	@Produces(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean commit(@WebParam @PathParam("txCode") final Long txCode);

	/**
	 * <h3 class="en-US">Create database</h3>
	 * <h3 class="zh-CN">创建数据库</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@POST
	@Path("/database/{databaseName}")
	@Produces(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean createDatabase(@Nonnull @WebParam @PathParam("databaseName") final String databaseName);

	/**
	 * <h3 class="en-US">Drop database</h3>
	 * <h3 class="zh-CN">删除数据库</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@DELETE
	@Path("/database/{databaseName}")
	@Produces(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean dropDatabase(@Nonnull @WebParam @PathParam("databaseName") final String databaseName);

	/**
	 * <h3 class="en-US">Create a data table</h3>
	 * <h3 class="zh-CN">创建数据表</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param tableDefine  <span class="en-US">Data table structure define information</span>
	 *                     <span class="zh-CN">数据表结构定义信息</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@POST
	@Path("/table/{databaseName}/{tableName}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	Boolean createTable(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                    @Nonnull @WebParam @PathParam("tableName") final String tableName,
	                    @Nonnull @WebParam @QueryParam("define")
	                    @DataTransfer(adapter = JsonBeanAdapter.class,
			                    initParam = "org.nervousync.database.beans.ddl.TableDefine") final TableDefine tableDefine);

	/**
	 * <h3 class="en-US">Modify the data table structure information</h3>
	 * <h3 class="zh-CN">修改数据表结构信息</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param tableModify  <span class="en-US">Data table structure modified information</span>
	 *                     <span class="zh-CN">数据表结构修改信息</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@PUT
	@Path("/table/{databaseName}/{tableName}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	Boolean alterTable(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                   @Nonnull @WebParam @PathParam("tableName") final String tableName,
	                   @Nonnull @WebParam @QueryParam("define")
	                   @DataTransfer(adapter = JsonBeanAdapter.class,
			                   initParam = "org.nervousync.database.beans.ddl.TableModify") final TableModify tableModify);

	/**
	 * <h3 class="en-US">Create an index</h3>
	 * <h3 class="zh-CN">创建索引</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param indexDefine  <span class="en-US">Index define information</span>
	 *                     <span class="zh-CN">索引定义信息</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@POST
	@Path("/index/{databaseName}/{tableName}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	Boolean createIndex(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                    @Nonnull @WebParam @PathParam("tableName") final String tableName,
	                    @Nonnull @WebParam @QueryParam("define")
	                    @DataTransfer(adapter = JsonBeanAdapter.class,
			                    initParam = "org.nervousync.database.beans.ddl.IndexDefine") final IndexDefine indexDefine);

	/**
	 * <h3 class="en-US">Drop an index</h3>
	 * <h3 class="zh-CN">删除索引</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param indexName    <span class="en-US">Index name</span>
	 *                     <span class="zh-CN">索引名</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@DELETE
	@Path("/index/{databaseName}/{tableName}/{indexName}")
	@Produces(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean dropIndex(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                  @Nonnull @WebParam @PathParam("tableName") final String tableName,
	                  @Nonnull @WebParam @PathParam("indexName") final String indexName);

	/**
	 * <h3 class="en-US">Create a sequence</h3>
	 * <h3 class="zh-CN">创建序列</h3>
	 *
	 * @param databaseName   <span class="en-US">Database name</span>
	 *                       <span class="zh-CN">数据库名</span>
	 * @param sequenceName   <span class="en-US">Sequence name</span>
	 *                       <span class="zh-CN">序列名</span>
	 * @param sequenceDefine <span class="en-US">Sequence define information</span>
	 *                       <span class="zh-CN">序列定义信息</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@POST
	@Path("/sequence/{databaseName}/{sequenceName}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	Boolean createSequence(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                       @Nonnull @WebParam @PathParam("sequenceName") final String sequenceName,
	                       @Nonnull @WebParam @QueryParam("define")
	                       @DataTransfer(adapter = JsonBeanAdapter.class,
			                       initParam = "org.nervousync.database.beans.ddl.SequenceDefine") final SequenceDefine sequenceDefine);

	/**
	 * <h3 class="en-US">Drop a sequence</h3>
	 * <h3 class="zh-CN">删除序列</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param sequenceName <span class="en-US">Sequence name</span>
	 *                     <span class="zh-CN">序列名</span>
	 * @return <span class="en-US">Execute result</span>
	 * <span class="zh-CN">执行结果</span>
	 */
	@DELETE
	@Path("/sequence/{databaseName}/{sequenceName}")
	@Produces(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean dropSequence(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                     @Nonnull @WebParam @PathParam("sequenceName") final String sequenceName);

	/**
	 * <h3 class="en-US">Truncate all data tables</h3>
	 * <h3 class="zh-CN">清空所有数据表</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @return <span class="en-US">Response data</span>
	 * <span class="zh-CN">响应数据</span>
	 */
	@DELETE
	@Path("/truncate/{databaseName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean truncateTables(@Nonnull @WebParam @PathParam("databaseName") final String databaseName);

	/**
	 * <h3 class="en-US">Truncate data table</h3>
	 * <h3 class="zh-CN">清空数据表</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @return <span class="en-US">Response data</span>
	 * <span class="zh-CN">响应数据</span>
	 */
	@DELETE
	@Path("/truncate/{databaseName}/{tableName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean truncateTable(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                      @Nonnull @WebParam @PathParam("tableName") final String tableName);

	/**
	 * <h3 class="en-US">Drop all data tables</h3>
	 * <h3 class="zh-CN">删除所有数据表</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param dropOption   <span class="en-US">Cascading delete options</span>
	 *                     <span class="zh-CN">级联删除选项</span>
	 * @return <span class="en-US">Response data</span>
	 * <span class="zh-CN">响应数据</span>
	 */
	@DELETE
	@Path("/drop/{databaseName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean dropTables(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                   @Nonnull @WebParam @QueryParam("option") final String dropOption);

	/**
	 * <h3 class="en-US">Drop the data table</h3>
	 * <h3 class="zh-CN">删除数据表</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param dropOption   <span class="en-US">Cascading delete options</span>
	 *                     <span class="zh-CN">级联删除选项</span>
	 * @return <span class="en-US">Response data</span>
	 * <span class="zh-CN">响应数据</span>
	 */
	@DELETE
	@Path("/drop/{databaseName}/{tableName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@WebMethod
	Boolean dropTable(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                  @Nonnull @WebParam @PathParam("tableName") final String tableName,
	                  @Nonnull @WebParam @QueryParam("option") final String dropOption);

	/**
	 * <h3 class="en-US">Execute insert record command</h3>
	 * <h3 class="zh-CN">执行插入数据命令</h3>
	 *
	 * @param databaseName  <span class="en-US">Database name</span>
	 *                      <span class="zh-CN">数据库名</span>
	 * @param tableName     <span class="en-US">Data table name</span>
	 *                      <span class="zh-CN">数据表名</span>
	 * @param mappingDefine <span class="en-US">Data information mapping table</span>
	 *                      <span class="zh-CN">数据信息映射表</span>
	 * @return <span class="en-US">Primary key values mapping table generated by database</span>
	 * <span class="zh-CN">数据库生成的主键值数据映射表</span>
	 */
	@POST
	@Path("/{databaseName}/{tableName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	Map<String, Object> insert(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	                           @Nonnull @WebParam @PathParam("tableName") final String tableName,
	                           @Nonnull @WebParam @QueryParam("data")
	                           @DataTransfer(adapter = JsonBeanAdapter.class,
			                           initParam = "org.nervousync.database.beans.dml.MappingDefine") final MappingDefine mappingDefine);

	/**
	 * <h3 class="en-US">Execute update record command</h3>
	 * <h3 class="zh-CN">执行更新记录命令</h3>
	 *
	 * @param databaseName  <span class="en-US">Database name</span>
	 *                      <span class="zh-CN">数据库名</span>
	 * @param tableName     <span class="en-US">Data table name</span>
	 *                      <span class="zh-CN">数据表名</span>
	 * @param filterDefine  <span class="en-US">Data filter match mapping table</span>
	 *                      <span class="zh-CN">数据查询匹配映射表</span>
	 * @param mappingDefine <span class="en-US">Data information mapping table</span>
	 *                      <span class="zh-CN">数据信息映射表</span>
	 * @return <span class="en-US">Updated records count</span>
	 * <span class="zh-CN">更新记录条数</span>
	 */
	@PUT
	@Path("/{databaseName}/{tableName}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	Integer update(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	               @Nonnull @WebParam @PathParam("tableName") final String tableName,
	               @Nonnull @WebParam @QueryParam("filter")
	               @DataTransfer(adapter = JsonBeanAdapter.class,
			               initParam = "org.nervousync.database.beans.dml.FilterDefine") final FilterDefine filterDefine,
	               @Nonnull @WebParam @QueryParam("data")
	               @DataTransfer(adapter = JsonBeanAdapter.class,
			               initParam = "org.nervousync.database.beans.dml.MappingDefine") final MappingDefine mappingDefine);

	/**
	 * <h3 class="en-US">Execute delete record command</h3>
	 * <h3 class="zh-CN">执行删除记录命令</h3>
	 *
	 * @param databaseName <span class="en-US">Database name</span>
	 *                     <span class="zh-CN">数据库名</span>
	 * @param tableName    <span class="en-US">Data table name</span>
	 *                     <span class="zh-CN">数据表名</span>
	 * @param filterDefine <span class="en-US">Data filter match mapping table</span>
	 *                     <span class="zh-CN">数据查询匹配映射表</span>
	 * @return <span class="en-US">Deleted records count</span>
	 * <span class="zh-CN">删除记录条数</span>
	 */
	@DELETE
	@Path("/{databaseName}/{tableName}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	Integer delete(@Nonnull @WebParam @PathParam("databaseName") final String databaseName,
	               @Nonnull @WebParam @PathParam("tableName") final String tableName,
	               @Nonnull @WebParam @QueryParam("filter")
	               @DataTransfer(adapter = JsonBeanAdapter.class,
			               initParam = "org.nervousync.database.beans.dml.FilterDefine") final FilterDefine filterDefine);

	/**
	 * <h3 class="en-US">Execute query record command</h3>
	 * <h3 class="zh-CN">执行数据检索命令</h3>
	 *
	 * @param queryInfo <span class="en-US">Query record information</span>
	 *                  <span class="zh-CN">数据检索信息</span>
	 * @return <span class="en-US">List of data mapping tables for retrieved records</span>
	 * <span class="zh-CN">检索到记录的数据映射表列表</span>
	 */
	@POST
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	PartialCollection query(@Nonnull @WebParam @QueryParam("query")
	                        @DataTransfer(adapter = JsonBeanAdapter.class,
			                        initParam = "org.nervousync.database.query.QueryInfo") final QueryInfo queryInfo);

	/**
	 * <h3 class="en-US">Query total record count</h3>
	 * <h3 class="zh-CN">查询总记录数</h3>
	 *
	 * @param queryInfo <span class="en-US">Query record information</span>
	 *                  <span class="zh-CN">数据检索信息</span>
	 * @return <span class="en-US">Total record count</span>
	 * <span class="zh-CN">总记录条数</span>
	 */
	@GET
	@Path("/search/count")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@WebMethod
	Long queryTotal(@Nonnull @WebParam @QueryParam("query")
	                @DataTransfer(adapter = JsonBeanAdapter.class,
			                initParam = "org.nervousync.database.query.QueryInfo") final QueryInfo queryInfo);
}
