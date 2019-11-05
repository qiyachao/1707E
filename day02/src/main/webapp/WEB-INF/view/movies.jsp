<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/index_work.css"/> 
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
</head>
<body>
	<table>
	影片名称:<input type="text" name="name"> 上映时间:<input type="date" name="startDate">--<input type="date" name=endDate><br><br>
	导演:<input type="text" name="actor"> 价格:<input type="text" name="startprice">--<input type="text" name=endtprice><br><br>
	电影年代:<select name="year">
		  <option value="">请选择</option>
		  <option value="2010">2010</option>
		  <option value="2014">2014</option>
		  <option value="2016">2016</option>
		  <option value="2019">2019</option>
		</select>
	电影时长:<input type="text" name="startlongtime">--<input type="text" name=endlongtime><br><br>
	<input type="submit" value="查询">
	<tr>
	<td><input type="checkbox" onclick="selAll(this.checked)"></td>
	<td>影片名</td>
	<td>导演</td>
	<td>票价</td>
	<td><a href="javascript:query('uptime')">上映时间</a></td>
	<td><a href="javascript:query('longtime')">时长</a></td>
	<td>类型</td>
	<td><a href="javascript:query('year')">年代</a></td>
	<td>区域</td>
	<td>状态</td>
	<td>操作</td>
	</tr>
	<c:forEach items="${movies }" var="m">
	<tr>
	<td><input type="checkbox" class="ck" value="${m.id }"></td>
	<td>${m.name }</td>
	<td>${m.actor }导演</td>
	<td>${m.price }</td>
	<td><fm:formatDate value="${m.uptime }"/></td>
	<td>${m.longtime }</td>
	<td>${m.type }</td>
	<td>${m.year }</td>
	<td>${m.area }</td>
	
	<td>${m.status }</td>
	<td>
	<c:if test="${m.status=='热映'}">
	<button type="button" onclick="update('${m.id}','下架')">下架</button>
	</c:if>
	<c:if test="${m.status == "下架"}">
	<button type="button" onclick="update('${m.id}','即将上映')">即将上映</button>
	</c:if>
	<c:if test="${m.status == "即将上映"}">
	<button type="button" onclick="update('${m.id}','热映')">热映</button>
	</c:if>
	</td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="11">${page }</td>
	</tr>
	
	</table>
</body>
<script type="text/javascript">
	var orderMethod ='${movieVO.orderMethod=='asc'?'desc':'asc'}';
	function query(orderFiled){
		location.href="/list?orderFiled="+orderFiled+"&orderMethod="+orderMethod;
	}
	function update(id,status){
		$.post(
				"update",
				{id:id,status:status},
				function(flag){
					if(flag){
						alert("修改成功");
						location.reload();
					}else{
						alert("失败");
					}
				}
		)
	}
	function selAll(flag){
		$(".ck").attr("checked",flag);
	}
</script>
</html>