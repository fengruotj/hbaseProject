
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "../public/head.ftl">

    <script type="text/javascript">

        $(function(){

            $('#dg').datagrid('load', {
                name : '',
            });

            $('#namesearch').searchbox({
                searcher : function(value, name) {
                    $('#dg').datagrid('load', {
                        name : value,
                    });
                },
                prompt : 'Please Input Value'
            });
        });

    </script>

</head>

<body>

<table id="dg" title="石油油气田状态信息" class="easyui-datagrid"
       url="${oil}/queryOilStatusByPage"
       toolbar="#toolbar"
       pagination= true
       striped=true
       nowrap=true
       idField="id"
       rownumbers="true" fitColumns="true">

    <thead frozen="true">
    <tr>
        <th field="ck" checkbox="true"></th>
        <th field="id" width="30">id</th>
    </tr>
    </thead>

    <thead>
    <tr>
        <th field="name" width="50">油田名称</th>
        <th field="year" width="50">年份</th>
        <th field="cccd" width="50">采出程度</th>
        <th field="ccb" width="50">储采比</th>
        <th field="zhhsl" width="50">综合含水率</th>
        <th field="dnclzl" width="50">当年产量重量</th>
        <th field="ykftmdzclzl" width="50">已开发探明地质储量重量</th>
        <th field="wkftmdzclzl" width="50">未开发探明地质储量重量</th>
        <th field="wkftmjskcclzl" width="50">未开发探明技术可采储量重量</th>
        <th field="ykftmjskcclzl" width="50">已开发探明技术储量重量</th>
        <th field="ykftmjjkcclzl" width="50">已开发探明经济可采储量重量</th>
        <th field="wkftmjjkcclzl" width="50">未开发探明经济可采储量重量</th>
        <th field="status" width="50">油气田状态</th>
    </tr>
    </thead>
</table>

<div id="toolbar">
    <label>检索油气田信息</label>
    <input id="namesearch">
</div>

</body>
</html>
