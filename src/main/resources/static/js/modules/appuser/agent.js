$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'appuser/agent/list',
        datatype: "json",
        colModel: [			
			{ label: '代理ID', name: 'id', index: 'id', width: 50, key: true },
			{ label: '头像', name: 'uid', index: 'UID', width: 50 ,formatter: function(item, index,object){
				return '<img height="40" width="40" src="'+object.avatar+'" alt="">';
			}},	
			{ label: '用户', name: 'uid', index: 'UID', width: 120 ,formatter: function(item, index,object){
				return object.phone+"|"+object.username;
			}},	
			{ label: '等级', name: 'rolename', index: 'rolename', width: 80 },
			{ label: '所属代理', name: 'pname', index: 'pname', width: 80 },
			{ label: '个人业绩', name: 'subSpend', index: 'sub_spend', width: 80  ,formatter: function(item, index){
				return item.toFixed(2);
			}},	 			
			{ label: '团队业绩', name: 'teamSpend', index: 'team_spend', width: 80  ,formatter: function(item, index){
				return item.toFixed(2);
			}},				
			{ label: '总佣金', name: 'totalCommission', index: 'total_commission', width: 80  ,formatter: function(item, index){
				return item.toFixed(2);
			}},				
			{ label: '未提佣金', name: 'commission', index: 'commission', width: 80  ,formatter: function(item, index){
				return item.toFixed(2);
			}},	 			
			{ label: '状态', name: 'status', index: 'status', width: 80 ,formatter: function(item, index,object){
				 if(item==0){
					return '<span class="text-danger">未审核</span>';
				}else if(item==1){
					return '<span class="text-success">审核成功</span>';
				}else if(item==2){
					return '<span class="text-danger">审核失败</span>';
				}
			}},	
			{ label: '审核时间', name: 'checkTime', index: 'check_time', width: 80 }, 			
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
		showSetPassword: false,
		title: null,
		manager:{password:null},
		agent: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.agent = {};
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
		setPassword:function (event){
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			$.get(baseURL +"appuser/agent/info/"+id, function(r){
				 var managerUserId = r.agent.managerUserId;
				   vm.showSetPassword = true;
				   vm.showList = false;
		           vm.title = "后台管理员设置";
		           vm.getManager(managerUserId);
            });
            
		},
		updatePassword:function(event){
			$.ajax({
				type: "POST",
			    url: baseURL+"sys/user/update",
			    contentType: "application/json",
			    data: JSON.stringify(vm.manager),
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
		getManager: function(userId){
			$.get(baseURL + "sys/user/info/"+userId, function(r){
				vm.manager = r.user;
				vm.manager.password = null;
			});
		},
		check:function (event){
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
            vm.title = "审核";
			$.get(baseURL +"appuser/agent/info/"+id, function(r){
                if(r.agent.status==1){
    				alert("该用户已审核通过");
    				return ;
                }
            	$('#myModal').modal({  
          		  keyboard: false  
          		}) 
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.agent.id == null ? "appuser/agent/save" : "appuser/agent/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.agent),
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
		check:function(event){
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			$.get(baseURL +"appuser/agent/info/"+id, function(r){
                if(r.agent.status==1){
                	alert("已审核通过");
                	return;
                }
                vm.agent = r.agent;
    			confirm('确定升级用户  '+vm.agent.username+'为代理商吗？', function(){
    				$.ajax({
    					type: "POST",
    				    url:  baseURL +"appuser/agent/check",
    				    contentType: "application/json",
    				    data: JSON.stringify(vm.agent),
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
				    url:  baseURL +"appuser/agent/delete",
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
			$.get(baseURL +"appuser/agent/info/"+id, function(r){
                vm.agent = r.agent;
            });
		},
		reload: function (event) {
			vm.showList = true;
			vm.showSetPassword = false;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'keywords': vm.q.keywords,'roleId': vm.q.roleId},
                page:page
            }).trigger("reloadGrid");
		}
	}
});


