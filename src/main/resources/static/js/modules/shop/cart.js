$(function () {
	vm.getDiscount();
    $("#jqGrid").jqGrid({
        url: baseURL + 'shop/goods/list',
        datatype: "json",
        colModel: [			
			{ label: '商品ID', name: 'id', index: 'id', width: 50, key: true },
			{ label: '标题', name: 'goodsname', index: 'goodsname', width: 80 }, 
			{ label: '分类', name: 'cates', index: 'cates', width: 80 }, 			
			{ label: '品牌', name: 'brandid', index: 'brandid', width: 80 }, 			
			{ label: '现价', name: 'marketprice', index: 'marketprice', width: 80 }, 			
			{ label: '库存', name: 'total', index: 'total', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createtime', width: 80 }, 			
			{ label: '排序', name: 'displayorder', index: 'displayorder', width: 80 }			
        ],
		viewrecords: true,
        height: 250,
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
	
    $("#jqGrid2").jqGrid({
        url: baseURL + 'shop/cart/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '商品', name: 'goodsname', index: 'goodsname', width: 80 }, 
			{ label: '所属分类', name: 'cates', index: 'cates', width: 80 }, 
			{ label: '数量', name: 'total', index: 'total', width: 80 }, 
			{ label: '金额', name: 'marketprice', index: 'marketprice' , formatter: "number", formatoptions: {thousandsSeparator:",", defaulValue:"",decimalPlaces:2}},
        ],
		viewrecords: true,
        height: 250,
//        rowNum: 10,
//		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        footerrow:true,            
//        pager: "#jqGridPager",
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
        	 var rowNum = $(this).jqGrid('getGridParam','records');
        	if (rowNum > 0) {
                $(".ui-jqgrid-sdiv").show();
                var totals = jQuery(this).getCol('total', false, 'sum');
                var marketpriceSum = jQuery(this).getCol('marketprice', false, 'sum');
                vm.order.total = totals;
                vm.order.price = (marketpriceSum * vm.order.discount).toFixed(2);
                
                vm.order.discountprice = (marketpriceSum - vm.order.price).toFixed(2);
                $("#jqGrid2").footerData("set", {
                	"id": "	合计：",
                	"total": totals, 
                	"marketprice": marketpriceSum
                	});
    		} else {
                $(".ui-jqgrid-sdiv").hide();
            }
        	
        	
        	
        	//隐藏grid底部滚动条
//        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		order:{total:null,discount:0.00,discountprice:0.00,price:0.00},
		cart: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.cart = {};
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
		topay: function(event){
			$.ajax({
				type: "POST",
			    url: baseURL+"shop/cart/createOrder",
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
		saveOrUpdate: function (event) {
			var url = vm.cart.id == null ? "shop/cart/save" : "shop/cart/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.cart),
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
			console.log(ids);
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url:  baseURL +"shop/cart/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid2").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getDiscount: function(){
			$.get(baseURL +"appuser/user/getDiscount", function(r){
                vm.order.discount = r.discount;
            });
		},
		getInfo: function(id){
			$.get(baseURL +"shop/cart/info/"+id, function(r){
                vm.cart = r.cart;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid2").jqGrid('getGridParam','page');
			$("#jqGrid2").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});