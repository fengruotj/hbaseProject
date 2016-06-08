
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "../public/head.ftl">

    <script type="text/javascript">

        $(function(){

            $('#dg').datagrid('load', {
                name : ''
            });

            $('#search').searchbox({
                searcher : function(value, name) {
                    $('#dg').datagrid('load', {
                        name : value
                    });
                },
                prompt : 'Please Input Value'
            });
        });

    </script>

</head>

<body>

<table id="dg" title="数据仓库油气田基本信息" class="easyui-datagrid"
       url="${oil}/queryHbaseOilFieldByPage"
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
        <th field="YQTMC" width="50">名称</th>
        <th field="YQTBM" width="50">编码</th>
        <th field="PDMC" width="50">盆地名称</th>
        <th field="SSPDBM" width="50">盆地编码</th>
        <th field="YQCLX" width="50">油气藏类型</th>
        <th field="NF" width="50">年份</th>
        <th field="SQMC" width="50">省区名称</th>
        <th field="CJYHD" width="50">沉积岩厚度</th>
        <th field="TMCD" width="50">探明程度</th>
        <th field="MJ" width="50">油气田面积</th>
        <th field="ZHHSL" width="50">综合含水量</th>
        <th field="CCCD" width="50">采出程度</th>
        <th field="CCB" width="50">储采比</th>
        <th field="LJTMDZCLZL" width="50">累计探明地质储量重量</th>
        <th field="LJTMDZCLTJ" width="50">累计探明地质储量体积</th>
        <th field="HYQCX" width="50">含油气层系</th>
        <th field="YX" width="50">岩系</th>
    </tr>
    </thead>
</table>

<div id="toolbar">
    <label>检索油气田信息</label>
    <input id="search">
</div>

</body>
</html>
