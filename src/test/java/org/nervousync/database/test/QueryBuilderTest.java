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

package org.nervousync.database.test;

import org.junit.jupiter.api.*;
import org.nervousync.commons.Globals;
import org.nervousync.database.enumerations.CalculateCode;
import org.nervousync.database.enumerations.ConnectionCode;
import org.nervousync.database.enumerations.JoinType;
import org.nervousync.database.enumerations.OrderType;
import org.nervousync.database.query.QueryInfo;
import org.nervousync.database.query.builder.QueryBuilder;
import org.nervousync.enumerations.beans.StringType;
import org.nervousync.enumerations.logger.LogLevel;
import org.nervousync.utils.core.BeanUtils;
import org.nervousync.utils.logger.LoggerUtils;

import java.sql.Types;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public final class QueryBuilderTest {

	private transient final LoggerUtils.Logger logger = LoggerUtils.getLogger(this.getClass());

	static {
		LoggerUtils.initLoggerConfigure(LogLevel.DEBUG);
	}

	@Test
	@Order(10)
	public void simpleAndQuery() throws Exception {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName").confirm()
						//	Configure query items
						.items()
						.constant(1, "CONV", Types.INTEGER)
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.function("MAX", Types.INTEGER).aliasName("FUNC")
						.parameters()
						.column("", "tableName", "columnName2")
						.confirm()	//	Confirm function item
						.confirm()
						.calculate(CalculateCode.ADD, Types.INTEGER).aliasName("TOTAL")
						.parameters()
						.column("", "tableName", "columnName1")
						.column("", "tableName", "columnName2")
						.confirm()	//	Confirm calculate parameters
						.confirm()	//	Confirm calculate item
						.confirm()
						//	Configure where clause
						.where()
						.greaterThan("", "tableName", "columnName1").matchValue(1).confirm()	//	Confirm condition
						.greaterEqual("", "tableName", "columnName1").matchValue(1).confirm()	//	Confirm condition
						.lessThan("", "tableName", "columnName1").matchValue(1).confirm()	//	Confirm condition
						.lessEqual("", "tableName", "columnName1").matchValue(1).confirm()	//	Confirm condition
						.equalThan("", "tableName", "columnName1").matchValue(1).confirm()	//	Confirm condition
						.notEqual("", "tableName", "columnName1").matchValue(1).confirm()	//	Confirm condition
						.betweenAnd("", "tableName", "columnName2", 5, 10)	//	Confirm condition
						.notBetweenAnd("", "tableName", "columnName2", 5, 10)	//	Confirm condition
						.in("", "tableName", "columnName3", new Object[]{"a", "b", "c", "d", "e", "f"})	//	Confirm condition
						.notIn("", "tableName", "columnName3", new Object[]{"a", "b", "c", "d", "e", "f"})	//	Confirm condition
						.similar("", "tableName", "columnName1", "%a")	//	Confirm condition
						.notSimilar("", "tableName", "columnName1", "%a")	//	Confirm condition
						.isNull("", "tableName", "columnName1")
						.notNull("", "tableName", "columnName2")
						.confirm()	//	Confirm where clause
						.orderBy("", "tableName", "columnName1", OrderType.ASC)
						.groupBy("", "tableName", "columnName2")
						.pager(1, 20)
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.XML));
	}

	@Test
	@Order(15)
	public void simpleOrQuery() throws Exception {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName").confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.greaterThan(ConnectionCode.OR, "", "tableName", "columnName1").matchValue(1).confirm()
						.greaterEqual(ConnectionCode.OR, "", "tableName", "columnName1").matchValue(1).confirm()
						.lessThan(ConnectionCode.OR, "", "tableName", "columnName1").matchValue(1).confirm()
						.lessEqual(ConnectionCode.OR, "", "tableName", "columnName1").matchValue(1).confirm()
						.equalThan(ConnectionCode.OR, "", "tableName", "columnName1").matchValue(1).confirm()
						.notEqual(ConnectionCode.OR, "", "tableName", "columnName1").matchValue(1).confirm()
						.betweenAnd(ConnectionCode.OR, "", "tableName", "columnName2", 5, 10)
						.notBetweenAnd(ConnectionCode.OR, "", "tableName", "columnName2", 5, 10)
						.in(ConnectionCode.OR, "", "tableName", "columnName3", new Object[]{"a", "b", "c", "d", "e", "f"})
						.notIn(ConnectionCode.OR, "", "tableName", "columnName3", new Object[]{"a", "b", "c", "d", "e", "f"})
						.similar(ConnectionCode.OR, "", "tableName", "columnName1", "%a")
						.notSimilar(ConnectionCode.OR, "", "tableName", "columnName1", "%a")
						.isNull(ConnectionCode.OR, "", "tableName", "columnName1")
						.notNull(ConnectionCode.OR, "", "tableName", "columnName2")
						.confirm()
						.orderBy("", "tableName", "columnName1", OrderType.ASC)
						.groupBy("", "tableName", "columnName2")
						.pager(1, 20)
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.JSON));
	}

	@Test
	@Order(18)
	public void simpleGroupQuery() throws Exception {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName").confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.group()
						.greaterThan("", "tableName", "columnName1").matchValue(1).confirm()
						.greaterEqual("", "tableName", "columnName1").matchValue(1).confirm()
						.lessThan("", "tableName", "columnName1").matchValue(1).confirm()
						.lessEqual("", "tableName", "columnName1").matchValue(1).confirm()
						.equalThan("", "tableName", "columnName1").matchValue(1).confirm()
						.notEqual("", "tableName", "columnName1").matchValue(1).confirm()
						.betweenAnd("", "tableName", "columnName2", 5, 10)
						.notBetweenAnd("", "tableName", "columnName2", 5, 10)
						.in("", "tableName", "columnName3", new Object[]{"a", "b", "c", "d", "e", "f"})
						.notIn("", "tableName", "columnName3", new Object[]{"a", "b", "c", "d", "e", "f"})
						.similar("", "tableName", "columnName1", "%a")
						.notSimilar("", "tableName", "columnName1", "%a")
						.isNull("", "tableName", "columnName1")
						.notNull("", "tableName", "columnName2")
						.exists()
						.queryBuilder()
						.fromTable("", "", "subQueryTable").confirm()
						.items()
						.column("", "subQueryTable", "subColumn", "", Types.VARCHAR, Boolean.FALSE)
						.confirm()
						.where()
						.equalThan("", "subQueryTable", "subColumn").matchValue(2).confirm()
						.notExists()
						.queryBuilder()
						.fromSubquery("sub1")
						.queryBuilder()
						.fromTable("", "", "subQueryTable").confirm()
						.items()
						.column("", "subQueryTable", "subColumn", "", Types.VARCHAR, Boolean.FALSE)
						.confirm()
						.where()
						.equalThan("", "subQueryTable", "subColumn").matchValue(2).confirm()
						.confirm()
						.confirm()
						.confirm()
						.orderBy("", "tableName", "columnName1", OrderType.ASC)
						.groupBy("", "tableName", "columnName2")
						.pager(1, 20)
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.XML));
	}

	@Test
	@Order(20)
	public void joinAndQuery() {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.joins()
						.joinTable(JoinType.LEFT, "joinAlias", "databaseName", "joinTable")
						.on("currentColumn", "joinColumn")
						.confirm()
						.confirm()
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.greaterThan("", "tableName", "columnName1")
						.matchFunction()
						.functionName("MAX", Types.INTEGER)
						.parameters()
						.constant("1")
						.function()
						.functionName("MIN", Types.INTEGER)
						.parameters()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.greaterEqual("", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.lessThan("", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.lessEqual("", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.equalThan("", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.notEqual("", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.confirm()
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.JSON));
	}

	@Test
	@Order(25)
	public void joinOrQuery() {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.joins()
						.joinTable(JoinType.LEFT, "joinAlias", "databaseName", "joinTable")
						.on("currentColumn", "joinColumn")
						.confirm()
						.confirm()
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.greaterThan(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.greaterEqual(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.lessThan(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.lessEqual(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.equalThan(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.notEqual(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.confirm()
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.XML));
	}

	@Test
	@Order(28)
	public void joinSubQuery() {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.joins()
						.joinQuery(JoinType.LEFT, "tableName")
						.queryBuilder()
						.fromTable("aliasName", "", "joinTable")
						.confirm()
						.items()
						.column("", "joinTable", "joinColumn", "", Types.VARCHAR, Boolean.FALSE)
						.confirm()
						.where()
						.equalThan("", "joinTable", "joinColumn").matchValue(1).confirm()
						.confirm()
						.confirm()
						.on("currentColumn", "joinColumn")
						.confirm()
						.confirm()
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.greaterThan(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.greaterEqual(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.lessThan(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.lessEqual(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.equalThan(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.notEqual(ConnectionCode.OR, "", "tableName", "columnName1").matchColumn("", "matchTable", "matchColumn").confirm()
						.confirm()
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.JSON));
	}

	@Test
	@Order(30)
	public void functionAndQuery() {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.joins()
						.joinTable(JoinType.LEFT, "joinAlias", "databaseName", "joinTable")
						.on("currentColumn", "joinColumn")
						.confirm()
						.confirm()
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.greaterThan("", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.greaterEqual("", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.lessThan("", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.lessEqual("", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.equalThan("", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.notEqual("", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.confirm()
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.XML));
	}

	@Test
	@Order(35)
	public void functionOrQuery() {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.joins()
						.joinTable(JoinType.LEFT, "joinAlias", "databaseName", "joinTable")
						.on("currentColumn", "joinColumn")
						.confirm()
						.confirm()
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.greaterThan(ConnectionCode.OR, "", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.greaterEqual(ConnectionCode.OR, "", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.lessThan(ConnectionCode.OR, "", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.lessEqual(ConnectionCode.OR, "", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.equalThan(ConnectionCode.OR, "", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.notEqual(ConnectionCode.OR, "", "tableName", "columnName1").function("COUNT").matchColumn("", "joinTable", "joinColumn").confirm()
						.confirm()
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.JSON));
	}

	@Test
	@Order(40)
	public void subQueryAndQuery() {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.joins()
						.joinTable(JoinType.LEFT, "joinAlias", "databaseName", "joinTable")
						.on("currentColumn", "joinColumn")
						.confirm()
						.confirm()
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.greaterThan("", "tableName", "columnName1")
						.matchQuery()
						.queryBuilder()
						.fromTable("","", "subQueryTable")
						.confirm()
						.items()
						.column("", "subQueryTable", "subColumn", "", Types.VARCHAR, Boolean.FALSE).confirm()
						.where()
						.equalThan("", "subQueryTable", "subColumn").matchValue(2).confirm()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.XML));
	}

	@Test
	@Order(45)
	public void subQueryOrQuery() {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.joins()
						.joinTable(JoinType.LEFT, "joinAlias", "databaseName", "joinTable")
						.on("currentColumn", "joinColumn")
						.confirm()
						.confirm()
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.greaterEqual(ConnectionCode.OR, "", "tableName", "columnName1")
						.matchQuery()
						.queryBuilder()
						.fromTable("","", "subQueryTable")
						.confirm()
						.items()
						.column("", "subQueryTable", "subColumn", "", Types.VARCHAR, Boolean.FALSE).confirm()
						.where()
						.equalThan("", "subQueryTable", "subColumn").matchValue(2).confirm()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.JSON));
	}

	@Test
	@Order(50)
	public void existQuery() {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.joins()
						.joinTable(JoinType.LEFT, "joinAlias", "databaseName", "joinTable")
						.on("currentColumn", "joinColumn")
						.confirm()
						.confirm()
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.exists()
						.queryBuilder()
						.fromTable("","", "subQueryTable")
						.confirm()
						.items()
						.column("", "subQueryTable", "subColumn", "", Types.VARCHAR, Boolean.FALSE).confirm()
						.where()
						.equalThan("", "subQueryTable", "subColumn").matchValue(2).confirm()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.XML));
	}

	@Test
	@Order(55)
	public void notExistQuery() {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.joins()
						.joinTable(JoinType.LEFT, "joinAlias", "databaseName", "joinTable")
						.on("currentColumn", "joinColumn")
						.confirm()
						.confirm()
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.where()
						.notExists()
						.queryBuilder()
						.fromTable("","", "subQueryTable")
						.confirm()
						.items()
						.column("", "subQueryTable", "subColumn", "", Types.VARCHAR, Boolean.FALSE).confirm()
						.where()
						.equalThan("", "subQueryTable", "subColumn").matchValue(2).confirm()
						.confirm()
						.groupBy("", "column1", "column2")
						.having()
						.lessThan(ConnectionCode.OR, "", "tableName", "columnName1").matchValue(1).confirm()
						.confirm()
						.confirm()
						.confirm()
						.confirm()
						.build();
		this.logger.info("Generated_Result", BeanUtils.objectToString(queryInfo, StringType.JSON));
	}

	@Test
	@Order(60)
	public void havingQuery() throws Exception {
		QueryInfo queryInfo =
				new QueryBuilder<>()
						.fromTable("", "", "tableName")
						.confirm()
						.items()
						.column("", "tableName", "columnName1", "", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName2", "aliasName2", Types.VARCHAR, Boolean.FALSE)
						.column("", "tableName", "columnName3", "aliasName3", Types.VARCHAR, Boolean.TRUE)
						.confirm()
						.groupBy("", "tableName", "groupByColumn")
						.having()
						.greaterThan("", "tableName", "columnName1").matchValue(1).confirm()
						.greaterEqual("", "tableName", "columnName1").matchValue(1).confirm()
						.lessThan("", "tableName", "columnName1").matchValue(1).confirm()
						.lessEqual("", "tableName", "columnName1").matchValue(1).confirm()
						.equalThan("", "tableName", "columnName1").matchValue(1).confirm()
						.notEqual("", "tableName", "columnName1").matchValue(1).confirm()
						.betweenAnd("", "tableName", "columnName2", 5, 10)
						.notBetweenAnd("", "tableName", "columnName2", 5, 10)
						.in("", "tableName", "columnName3", new Object[]{"a", "b", "c", "d", "e", "f"})
						.notIn("", "tableName", "columnName3", new Object[]{"a", "b", "c", "d", "e", "f"})
						.similar("", "tableName", "columnName1", "%a")
						.notSimilar("", "tableName", "columnName1", "%a")
						.isNull("", "tableName", "columnName1")
						.notNull("", "tableName", "columnName2")
						.confirm()
						.orderBy("", "tableName", "columnName1", OrderType.ASC)
						.groupBy("", "tableName", "columnName2")
						.pager(1, 20)
						.build();
		String xmlData = BeanUtils.objectToString(queryInfo, StringType.XML);
		this.logger.info("Generated_Result", xmlData);
		QueryInfo parsedQuery = BeanUtils.stringToObject(xmlData, StringType.XML, Globals.DEFAULT_ENCODING, QueryInfo.class, "https://nervousync.org/schemas/database");
		this.logger.info("Generated_Result", BeanUtils.objectToString(parsedQuery, StringType.YAML));
	}
}
