$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'shop/order/list',
        datatype: "json",
        colModel: [			
			{ label: '订单编号', name: 'outTradeNo', index: 'OUT_TRADE_NO', width: 50, key: false },
			{ label: '商品', name: 'projectName', index: 'PROJECT_NAME', width: 150 }, 
			{ label: '价格（单位：元）', name: 'price', index: 'PRICE', width: 80 ,formatter: function(item, index){
				return item.toFixed(2);
			}},		
			{ label: '买家信息', name: 'orderId', index: 'ORDER_ID', width: 100 ,key: true ,formatter: function(item, index,object){
				return object.phone+"|"+object.username;
			}},
			{ label: '所属店铺', name: 'storeName', index: 'storeName', width: 100 },
/*			{ label: '订单类型', name: 'type', index: 'TYPE', width: 80 ,formatter: function(item, index){
				if(item=='shop'){
					return "商城";
				}else if(item=='recharge'){
					return "充值";
				}else if(item=='project'){
					return "购买专家课程";
				}else if(item=='reward'){
					return "签到奖励";
				}else if(item=='transfer'){
					return "转账";
				}
			}},*/
			{ label: '支付方式', name: 'payType', index: 'PAY_TYPE', width: 80 ,formatter: function(item, index){
				if(item=='alipay'){
					return '<span class="label label-success">支付宝</span>';
				}else if(item=='wx'){
					return '<span class="label label-success">微信支付</span>';
				}else if(item=='paypal'){
					return '<span class="label label-success">paypal支付</span>';
				}else if(item=='account'){
					return '<span class="label label-warning">余额支付</span>';
				}else if(item=='test'){
					return '<span class="label label-warning">体验金支付</span>';
				}else{
					return '';
				}
			}},
			{ label: '交易状态', name: 'status', index: 'STATUS', width: 80 ,formatter: function(item, index,object){
				if(item==-1){
					return '<span class="text-success">失效订单</span>' ;
				}else if(item==0){
					return '<span class="text-danger">未支付</span> <a class="btn btn-success btn-xs" onclick="confirmStatus(\''+object.orderId+'\',\''+object.status+'\');">确认付款</a>';
				}else if(item==1){
					return '<span class="text-success">已完成</span>';
				}else if(item==2){
					return '<span class="text-danger">待发货</span> <a class="btn btn-success btn-xs" onclick="confirmStatus(\''+object.orderId+'\',\''+object.status+'\');">确认发货</a>';
				}else if(item==3){
					return '<span class="text-danger">待收货</span> <a class="btn btn-success btn-xs" onclick="confirmStatus(\''+object.orderId+'\',\''+object.status+'\');">确认收货</a>';
				}
			}},
			{ label: '创建时间', name: 'createTime', index: 'CREATE_TIME', width: 100 }
						
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
			outTradeNo: null,
			status: ''
		},
		showList: true,
		title: null,
		items:{},
		order: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.order = {};
		},
		update: function (event) {
			var orderId = getSelectedRow();
			if(orderId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "订单信息";
            
            vm.getInfo(orderId);
            vm.getGoodsItems(orderId);
		},
		saveOrUpdate: function (event) {
			var url = vm.order.orderId == null ? "shop/order/save" : "shop/order/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.order),
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
			var orderIds = getSelectedRows();
			if(orderIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url:  baseURL +"shop/order/delete",
				    contentType: "application/json",
				    data: JSON.stringify(orderIds),
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
		getInfo: function(orderId){
			$.get(baseURL +"shop/order/info/"+orderId, function(r){
                vm.order = r.order;
            });
		},
		getGoodsItems: function(orderId){
	          $.get(baseURL + "shop/ordergoods/list/"+orderId, function(r){
	              vm.items = r.ordergoodsList;
	              console.log(r);
	          })
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'outTradeNo': vm.q.outTradeNo,'status': vm.q.status},
                page:page
            }).trigger("reloadGrid");
		}
	}
});

function confirmStatus(orderId,status){
	if(status==0){
		var msg = "确认此订单已付款吗？";
		var newstatus = '2';
	}else if(status==2){
		msg = "确认此订单已发货吗？";
		newstatus = '3';
	}else if(status==3){
		msg = "确认此订单已收货吗？";
		newstatus = '1';
	}else{
		return;
	}
	vm.order.orderId = orderId;
	vm.order.status = newstatus;
	confirm(msg, function(){
		$.ajax({
			type: "POST",
		    url:  baseURL +"shop/order/confirm",
		    contentType: "application/json",
		    data: JSON.stringify(vm.order),
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