
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

  <table id="dg" title="石油油气田基本信息" class="easyui-datagrid"
         url="${oil}/queryOilFieldByPage"
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
          <th field="yqtbm" width="50">油气田编码</th>
          <th field="longitude" width="50">经度</th>
          <th field="latitude" width="50">纬度</th>
          <th field="yqProvince" width="50">省份名称</th>
          <th field="yqCompany" width="50">公司名称</th>
          <th field="status" width="50">油气田状态</th>
      </tr>
      </thead>
  </table>

  <div id="toolbar">
      <label>检索油气田信息</label>
      <input id="search">
  </div>

  </body>
</html>
