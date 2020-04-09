package app.http.sql.impl;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

import app.http.annotation.*;
import app.http.entity.User;
import app.http.sql.SqlUtil;

public class Sql implements SqlUtil{

	public Sql() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String query(User user) {
		String sql = "SELECT * FROM `" + this.getTableName(user) + "`";
		List<Object> value = new ArrayList<>();
		List<String> list = this.getColumnName(user, value);
		sql += this.makeWhere(list, value) + ";";
		
		return sql;
	}

	@Override
	public String insert(User user) {
		String sql = "INSERT INTO `"+ this.getTableName(user) + "` (";
		List<Object> value = new ArrayList<>();
		List<String> list = this.getColumnName(user, value);
		String column = "";
		String values = "";
		for(int i = 0; i < list.size(); i++) {
			if(i == list.size() - 1) {
				if(value.get(i).getClass().getSimpleName().equals("String")) {
					column += "`" + list.get(i).toString() + "`";
					values += "'" + value.get(i).toString() + "'";
				}else {
					column += "`" + list.get(i).toString() + "`";
					values += value.get(i).toString();
				}
				break;
			}
			
			if(value.get(i).getClass().getSimpleName().equals("String")) {
				column += "`" + list.get(i).toString() + "`, ";
				values += "'" + value.get(i).toString() + "', ";
			}else {
				column += "`" + list.get(i).toString() + "`, ";
				values += value.get(i).toString() + ", ";
			}
		}
		sql += column + ") VALUES (" + values + ");";
		
		return sql;
	}

	@Override
	public String insert(List<User> users) {
		String sql = "INSERT INTO `" + this.getTableName(users.get(0)) + "` ";
		String column = "(";
		String realValue = "";
		for(int i = 0; i < users.size(); i++) {
			String values = "(";
			List<Object> value = new ArrayList<>();
			List<String> list = this.getColumnName(users.get(i), value);
			for(int j = 0; j < list.size(); j++) {
				if(j == list.size() - 1) {
					if(value.get(j).getClass().getSimpleName().equals("String")) {
						if(i == 0) {
							column += "`" + list.get(j).toString() + "`)";
						}
						values += "'" + value.get(j).toString() + "')";
					} else {
						if(i == 0) {
							column += "`" + list.get(j).toString() + "`)";
						}
						values += value.get(j).toString() + ")";
					}
					break;
				}
				
				if(value.get(j).getClass().getSimpleName().equals("String")) {
					if(i == 0) {
						column += "`" + list.get(j).toString() + "`, ";
					}
					values += "'" + value.get(j).toString() + "', ";
				} else {
					if(i == 0) {
						column += "`" + list.get(j).toString() + "`, ";
					}
					values += value.get(j).toString() + ", ";
				}
			}
			if(i == users.size() - 1) {
				realValue += values;
				break;
			}
			realValue += values + ", ";
		}
		sql += column + " VALUES " + realValue + ";";
		return sql;
	}

	@Override
	public String delete(User user) {
		String sql = "DELETE FROM `" + this.getTableName(user) + "`";
		List<Object> value = new ArrayList<>();
		List<String> list = this.getColumnName(user, value);
		sql += this.makeWhere(list, value) + ";";
		return sql;
	}

	@Override
	public String update(User user) {
		String sql = "UPDATE `" + this.getTableName(user) + "`";
		List<Object> value = new ArrayList<>();
		List<String> list = this.getColumnName(user, value);
		String set = " SET ";
		String where = " WHERE ";
		for(int i = 0; i < list.size(); i++) {
			//处理where语句，默认为id
			if(i == list.size() - 1) {
				if(list.get(i).toString().equals("id")) {
					if(value.get(i).getClass().getSimpleName().equals("String")) {
						where += "`" + list.get(i).toString() + "` = '" + value.get(i).toString() + "'";
					}else {
						where += "`" + list.get(i).toString() + "` = " + value.get(i).toString();
					}
				} else {
					if(value.get(i).getClass().getSimpleName().equals("String")) {
						set += "`" + list.get(i).toString() + "` = '" + value.get(i).toString() + "'";
					}else {
						set += "`" + list.get(i).toString() + "` = " + value.get(i).toString();
					}
				}
				break;
			}
			
			if(list.get(i).toString().equals("id")) {
				if(value.get(i).getClass().getSimpleName().equals("String")) {
					where += "`" + list.get(i).toString() + "` = '" + value.get(i).toString() + "'";
				}else {
					where += "`" + list.get(i).toString() + "` = " + value.get(i).toString();
				}
			} else {
				if(value.get(i).getClass().getSimpleName().equals("String")) {
					set += "`" + list.get(i).toString() + "` = '" + value.get(i).toString() + "' AND";
				}else {
					set += "`" + list.get(i).toString() + "` = " + value.get(i).toString() + " AND";
				}
			}
		}
		sql += set + where + ";";
		return sql;
	}
	
	/**
	 * 构造where语句
	 * @param column where中的列
	 * @param value where中列对应的值，注意需要一一对应。
	 * @return
	 */
	private String makeWhere(List<String> column, List<Object> value) {
		String wheres = " WHERE ";
		for(int i = 0; i < column.size(); i++) {
			if(i == column.size() - 1) {
				wheres += "`" + column.get(i).toString() + "` ";
				if(value.get(i).getClass().getSimpleName().equals("Integer")) {
					wheres += "= " + value.get(i).toString();
				}else {
					wheres += "LIKE '" + value.get(i).toString() + "'";
				}
				break;
			}
			
			wheres += "`" + column.get(i).toString() + "` ";
			if(value.get(i).getClass().getSimpleName().equals("Integer")) {
				wheres += "= " + value.get(i).toString() + " AND ";
			}else {
				wheres += "LIKE '" + value.get(i).toString() + "' AND ";
			}
		}
		return wheres;
	}

	/**
	 * 获取数据表的名称
	 * @param ob
	 * @return
	 */
	private String getTableName(Object ob) {
		String CLASS_NAME = "app.http.entity."+ ob.getClass().getSimpleName();
		String table = "";
		
		try {
			Class<?> clazz = Class.forName(CLASS_NAME);		
			if(clazz.isAnnotationPresent(Table.class)) {
				Table md = (Table)clazz.getAnnotation(Table.class);
				table = md.value();
			}		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}
	
	/**
	 * 获取该表内的所有字段的名称以及初值，初值通过value传递
	 * @param ob
	 * @param value
	 * @return
	 */
	private List<String> getColumnName(Object ob, List<Object> value) {
		String CLASS_NAME = "app.http.entity."+ ob.getClass().getSimpleName();
		List<String> list = new ArrayList<String>();
		
		try {
			Class<?> clazz = Class.forName(CLASS_NAME);
			Field[] fields = clazz.getDeclaredFields();
			for(Field field : fields) {
				if(field.isAnnotationPresent(Column.class)) {
					Column columnAnn = field.getAnnotation(Column.class);
					field.setAccessible(true);
					if(field.get(ob) == null || field.get(ob).toString().equals("0")) {
					} else {
						list.add(columnAnn.value());
						value.add(field.get(ob));
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
