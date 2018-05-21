<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<c:set var="contextpath" value="${pageContext.request.contextPath}"
       scope="page" />
<html>
<script src="js/jquery-1.9.1/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#GetExamApplyInfo").click(function () {
            alert("获取检查申请单信息");
            $.ajax({
                type: "POST",
                contentType : 'application/json;charset=utf-8',
                url: "http://192.0.0.100:8084/CXF-Server/auth/mutualCheckRule/testUpdateRadiationApplyStatus",
                dataType: 'text',
                success: function(msg){
                    alert(msg);
                }
            });
        });
        $("#UpdateExamApplyStatus").click(function () {
            alert("更新检查申请单信息");
            $.ajax({
                type: "POST",
                contentType : 'application/json;charset=utf-8',
                url: "http://192.0.0.100:8084/CXF-Server/user/UpdateExamApplyStatus",
                dataType: 'text',
                success: function(msg){
                    alert(msg);
                }
            });
        });
        $("#UpdateUltrasoundExamApplyStatus").click(function () {
            alert("更新超声检查申请单信息");
            $.ajax({
                type: "POST",
                contentType : 'application/json;charset=utf-8',
                url: "http://192.0.0.100:8084/CXF-Server/user/UpdateUltrasoundExamApplyStatus",
                dataType: 'text',
                success: function(msg){
                    alert(msg);
                }
            });
        });

        $("#SendPacsReport").click(function () {
            alert("发送检查报告");
            $.ajax({
                type: "POST",
                contentType : 'application/json;charset=utf-8',
                url: "http://192.0.0.100:8084/CXF-Server/user/SendPacsReport",
                dataType: 'text',
                success: function(msg){
                    alert(msg);
                }
            });
        });
        $("#testToken").click(function () {
            alert("发送检查报告");
            $.ajax({
                type: "POST",
                contentType : 'application/json;charset=utf-8',
                url: "http://localhost:8080/CXF-zhiYe//user/testToken",/* http://localhost:8080/CXF-zhiYe/  http://192.0.0.100:8084/CXF-Server*/
                dataType: 'text',
                success: function(msg){
                        alert(msg);
                }
            });
        })
    })
</script>
<body>
<h2>Hello World!</h2>

<input type="button" value="获取检查申请单信息" id="GetExamApplyInfo">
<<br/>

<input type="button" value="更新超声检查申请单信息" id="UpdateUltrasoundExamApplyStatus">
<<br/>

<input type="button" value="更新放射检查申请单信息" id="UpdateExamApplyStatus">
<<br/>

<input type="button" value="发送检查报告" id="SendPacsReport">
<<br/>

<input type="button" value="测试转换数据发送至ftp" id="testToken">
</body>

</html>
