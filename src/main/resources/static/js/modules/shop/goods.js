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

$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'shop/goods/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '分类', name: 'cates', index: 'cates', width: 80 }, 			
			{ label: '品牌', name: 'brandid', index: 'brandid', width: 80 }, 			
			{ label: '标题', name: 'goodsname', index: 'goodsname', width: 80 }, 			
			{ label: '描述', name: 'desc', index: 'desc', width: 80 }, 			
			{ label: '图片内容', name: 'img', index: 'img', width: 80 }, 			
			{ label: '文本内容', name: 'imgs', index: 'imgs', width: 80 }, 			
			{ label: '现价', name: 'marketprice', index: 'marketprice', width: 80 }, 			
			{ label: '成本', name: 'costprice', index: 'costprice', width: 80 }, 			
			{ label: '原价', name: 'originprice', index: 'originprice', width: 80 }, 			
			{ label: '活动开始时间', name: 'starttime', index: 'starttime', width: 80 }, 			
			{ label: '活动结束时间', name: 'endtime', index: 'endtime', width: 80 }, 			
			{ label: '运费设置', name: 'expressRule', index: 'express_rule', width: 80 }, 			
			{ label: '运费', name: 'expressprice', index: 'expressprice', width: 80 }, 			
			{ label: '来源', name: 'location', index: 'location', width: 80 }, 			
			{ label: '标签', name: 'label', index: 'label', width: 80 }, 			
			{ label: '库存', name: 'total', index: 'total', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createtime', width: 80 }, 			
			{ label: '排序', name: 'displayorder', index: 'displayorder', width: 80 }			
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
		showList: true,
		title: null,
		goods: {goodscategoryName:null}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.getGoodscategory();
			vm.showList = false;
			vm.title = "新增";
			vm.goods = {goodscategoryName:null};
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
			var url = vm.goods.id == null ? "shop/goods/save" : "shop/goods/update";
			$.ajax({
				type: "POST",
			    url: baseURL+url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.goods),
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
				    url:  baseURL +"shop/goods/delete",
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
			$.get(baseURL +"shop/goods/info/"+id, function(r){
                vm.goods = r.goods;
                vm.getGoodscategory();
            });
		},
        goodscategoryTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择分类",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#goodscategoryLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级菜单
                    vm.goods.cates = node[0].id;
                    vm.goods.goodscategoryName = node[0].name;
                    console.log(vm.goods.goodscategoryName);
                    layer.close(index);
                }
            });
        },
		getGoodscategory: function () {  
			//加载分类树
			$.get(baseURL + "shop/category/select", function(r){
				ztree = $.fn.zTree.init($("#goodscategoryTree"), setting, r.categoryList);
				var node = ztree.getNodeByParam("cates", vm.goods.cates);
				ztree.selectNode(node);
				vm.goods.goodscategoryName = node.name;
			})
			},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});