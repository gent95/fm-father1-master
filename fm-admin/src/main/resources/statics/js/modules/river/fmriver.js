$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'modules/fmriver/list',
        datatype: "json",
        colModel: [			
			{ label: 'riverId', name: 'riverId', index: 'river_id', width: 50, key: true },
			{ label: '河流名称', name: 'riverName', index: 'river_name', width: 80 }, 			
			{ label: '河流面积', name: 'riverArea', index: 'river_area', width: 80 }, 			
			{ label: '河流图片URL', name: 'riverUrl', index: 'river_url', width: 80 }, 			
			{ label: '河流地址', name: 'riverAddress', index: 'river_address', width: 80 }, 			
			{ label: '河流管理者', name: 'riverManager', index: 'river_manager', width: 80 }, 			
			{ label: '用户id', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }			
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
		fmRiver: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.fmRiver = {};
		},
		update: function (event) {
			var riverId = getSelectedRow();
			if(riverId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(riverId)
		},
		saveOrUpdate: function (event) {
			var url = vm.fmRiver.riverId == null ? "modules/fmriver/save" : "modules/fmriver/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.fmRiver),
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
			var riverIds = getSelectedRows();
			if(riverIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "modules/fmriver/delete",
                    contentType: "application/json",
				    data: JSON.stringify(riverIds),
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
		getInfo: function(riverId){
			$.get(baseURL + "modules/fmriver/info/"+riverId, function(r){
                vm.fmRiver = r.fmRiver;
            });
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