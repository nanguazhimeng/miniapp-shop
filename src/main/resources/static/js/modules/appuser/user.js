$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'appuser/user/list',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'id', index: 'id', width: 50, key: true },
			{ label: '上级', name: 'pid', index: 'pid', width: 80 }, 			
			{ label: '昵称', name: 'username', index: 'username', width: 80 }, 			
			{ label: '手机号', name: 'phone', index: 'phone', width: 80 }, 			
			{ label: '头像', name: 'avatar', index: 'avatar', width: 80 ,formatter: function(item, index,object){
					if(object.avatar!=null&&object.avatar!=''){
						return '<img  height="40" width="40" src="'+object.avatar+'" alt="">';
					}else{
						return '<img style="border-radius:5px" height="40" width="40" src="http://otmvibxnd.bkt.clouddn.com/ueditor/file/20180125/97c02572e44744349ab31eb6e2eadb1f" alt="">';
					}
				}},				 			
			{ label: '等级', name: 'rolename', index: 'rolename', width: 80 ,formatter: function(item, index,object){
				if(object.roleId==6){
					return item+'<a class="btn btn-success btn-xs" onclick="toAgent(\''+object.id+'\',\''+object.phone+'\');">升为代理</a>';
				}else{
					return item;
				}

			}},	 	
			{ label: '上级', name: 'pname', index: 'pname', width: 80 }, 	
			{ label: '账户余额', name: 'accountMoney', index: 'account_money', width: 80 }, 			
			{ label: '我的专属码', name: 'exclusiveCode', index: 'exclusive_code', width: 80 ,formatter: function(item, index,object){
				return "U"+object.id;
			}},	
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			keywords: null,
			roleId: null
		},
		showList: true,
		title: null,
		user: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.user = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.user.id == null ? "appuser/user/save" : "appuser/user/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.user),
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
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url:  baseURL +"appuser/user/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL +"appuser/user/info/"+id, function(r){
                vm.user = r.user;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'keywords': vm.q.keywords,'roleId': vm.q.roleId},
                page:page
            }).trigger("reloadGrid");
		}
	}
});
function toAgent(id,phone){
	confirm("确定将手机号："+phone+"升级为代理吗？", function(){
		$.ajax({
			type: "POST",
		    url:  baseURL +"appuser/user/toAgent",
		    data: "id=" + id,
		    success: function(r){
				if(r.code == 0){
					alert('操作成功', function(index){
						$("#jqGrid").trigger("reloadGrid");
					});
				}else{
					alert(r.msg);
				}
			}
		});
	});
}