var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;
var category = {
	    id: "categoryTable",
	    table: null,
	    layerIndex: -1
	};
/**
 * 初始化表格的列
 */
category.initColumn = function () {
    var columns = [
            {field: 'selectItem', radio: true},
            {title: '分类ID', field: 'id',visible: false, align: 'center', valign: 'middle', width: '80px'},
	        {title: '名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '100px'},
            {title: '上级分类', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
	        {title: '分类图片', field: 'iconurl', align: 'center', valign: 'middle', sortable: true, width: '100px', formatter: function(item, index){
	        	return item.iconurl == null ? '' : '<img height="50" width="100"  src="'+item.iconurl+'">';
			}},
	        {title: '排序', field: 'displayorder', align: 'center', valign: 'middle', sortable: true, width: '500px',formatter: function(item, index){
	        	return '<input type="text" value="'+item.displayorder+'" class="form-control"  onblur="updateDisplayorder('+item.id+','+item.displayorder+');">';
	        }}
           ]
    return columns;
}

function updateDisplayorder(id,displayorder){
	
	
}

function getid () {
    var selected = $('#categoryTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}
$(function () {
    var colunms = category.initColumn();
    var table = new TreeTable(category.id, baseURL + "shop/category/list", colunms);
    table.setExpandColumn(2);
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("pid");
    table.setExpandAll(false);
    table.init();
    category.table = table;
	
    vm.initUpload();
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		category: {
			 parentName:null,
		     pid:0,
			 type:0,
			 displayorder:0
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.getcategory();
			var selected = $('#categoryTable').bootstrapTreeTable('getSelections');
			if (selected.length != 0 && selected[0].level == 1) {
		    	var id = selected[0].id;
		    	var level = 1;
		    } else{
		    	var level = 2;
		    }
			vm.showList = false;
			vm.title = "新增";
			vm.category = { parentName:null, pid:id,displayorder:0};
			
			$("#upload").show();
			$(".multi-img-details").html("");
		},
		update: function (event) {
//			vm.getcategory();
			var id = getid();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.category.id == null ? "shop/category/save" : "shop/category/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.category),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
        categoryTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择分类",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#categoryLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.category.pid = node[0].id;
                    vm.category.parentName = node[0].name;
                    
                    if(vm.category.pid != 0){
                    	alert("最多只能两级分类");
                    	return false;
                    }
                    layer.close(index);
                }
            });
        },
		del: function (event) {
			var id = getid();
			if(id == null){
				return ;
			}
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url:  baseURL +"shop/category/delete",
				    data: "id=" + id,
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL +"shop/category/info/"+id, function(r){
                vm.category = r.category;
                var icon = vm.category.iconurl;
                if(icon!=null){
                	$("#upload").hide();
            		$(".multi-img-details").html('<div class="multi-item"><img src="'+icon+'" class="img-responsive img-thumbnail"><input type="hidden" class="form-control"  value="'+icon+'"><em class="close" title="删除这张图片" onclick="deleteMultiImage(this)">×</em></div>');
                }
                vm.getcategory();
            });
		},
        initUpload: function(){
          new AjaxUpload('#upload', {
              action: baseURL + 'sys/oss/upload?token=' + token,
              name: 'file',
              autoSubmit:true,
              responseType:"json",
              onSubmit:function(file, extension){
                  if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                      alert('只支持jpg、png、gif格式的图片！');
                      return false;
                  }
              },
              onComplete : function(file, r){
                  if(r.code == 0){
                  	$("#icon").val(r.url);
                  	vm.category.iconurl = r.url;
                  	$("#upload").hide();
            		$(".multi-img-details").append('<div class="multi-item"><img src="'+r.url+'" class="img-responsive img-thumbnail"><input type="hidden" class="form-control"  value="'+r.url+'"><em class="close" title="删除这张图片" onclick="deleteMultiImage(this)">×</em></div>');
                    alert("上传成功");
                  }else{
                      alert(r.msg);
                  }
              }
          }); 
      },
      getcategory: function () {  
          //加载分类树
          $.get(baseURL + "shop/category/select", function(r){
              ztree = $.fn.zTree.init($("#categoryTree"), setting, r.categoryList);
              console.log(r.categoryList);
              var node = ztree.getNodeByParam("id", vm.category.pid);
              ztree.selectNode(node);
              vm.category.parentName = node.name;
          })
       },
		reload: function (event) {
            vm.showList = true;
            category.table.refresh();
		}
	}
});

