<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.pactera.util.base.TLMLan"%>
<%@page import="com.pactera.pageModel.base.TLMSessionInfo"%>
<%@page import="com.pactera.model.tlm.TLMProjectPlan2"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	Object lan = session.getAttribute("LAN");
	TLMSessionInfo info = (TLMSessionInfo) session.getAttribute("sessionInfo");
	TLMProjectPlan2 plan = (TLMProjectPlan2) request.getAttribute("plan");
%>
<head>
</head>
<script type="text/javascript" charset="utf-8">
$.extend($.fn.validatebox.defaults.rules, {
	workloadSumVali: {
		validator: function (value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message: '请输入数字，并确保格式正确'
	}
})
$.extend($.fn.validatebox.defaults.rules, {
	plantartDateVali: {
		validator: function (value) {
			    var rows = $("#treegrid").treegrid('getSelections');
                if(rows.length >0){
                	var plannedStartDateEditor = $('#treegrid').treegrid('getEditor', {id:rows[0].proTaskId,field:'plannedStartDate'});
                	var plannedStartDateValue = plannedStartDateEditor.target.datebox('getValue');
                	var plannedEndDateEditor = $('#treegrid').treegrid('getEditor', {id:rows[0].proTaskId,field:'plannedEndDate'});
                	var plannedEndDateValue = plannedEndDateEditor.target.datebox('getValue');
					if(plannedStartDateValue == '' || plannedEndDateValue == ''){
				    	return true;
				    }
					var time1 = Date.parse(new Date(plannedStartDateValue));
				    var time2 = Date.parse(new Date(plannedEndDateValue));
				    var nTime = time2 - time1;
					return nTime>=0;
                }else{
                	return true;
                }
			},
		message: '计划开始时间必须小于或等于计划结束时间！'
	},
	planEndDateVali: {
		validator: function (value) {
			var rows = $("#treegrid").treegrid('getSelections');
            if(rows.length >0){
            	var plannedStartDateEditor = $('#treegrid').treegrid('getEditor', {id:rows[0].proTaskId,field:'plannedStartDate'});
            	var plannedStartDateValue = plannedStartDateEditor.target.datebox('getValue');
            	var plannedEndDateEditor = $('#treegrid').treegrid('getEditor', {id:rows[0].proTaskId,field:'plannedEndDate'});
            	var plannedEndDateValue = plannedEndDateEditor.target.datebox('getValue');
				if(plannedStartDateValue == '' || plannedEndDateValue == ''){
			    	return true;
			    }
				var time1 = Date.parse(new Date(plannedStartDateValue));
			    var time2 = Date.parse(new Date(plannedEndDateValue));
			    var nTime = time2 - time1;
				return nTime>=0;
            }else{
            	return true;
            }
		},
		message: '计划结束时间必须大于或等于计划开始时间！'
	},
	actualStartDateVali: {
		validator: function (value) {
			var rows = $("#treegrid").treegrid('getSelections');
	        if(rows.length >0){
	        	var actualStartDateEditor = $('#treegrid').treegrid('getEditor', {id:rows[0].proTaskId,field:'actualStartDate'});
	        	var actualStartDateValue = actualStartDateEditor.target.datebox('getValue');
	        	var actualEndDateEditor = $('#treegrid').treegrid('getEditor', {id:rows[0].proTaskId,field:'actualEndDate'});
	        	var actualEndDateValue = actualEndDateEditor.target.datebox('getValue');
				if(actualStartDateValue == '' || actualEndDateValue == ''){
			    	return true;
			    }
				var time1 = Date.parse(new Date(actualStartDateValue));
			    var time2 = Date.parse(new Date(actualEndDateValue));
			    var nTime = time2 - time1;
				return nTime>=0;
	        }else{
	        	return true;
	        }
        },
		message: '实际开始时间必须小于或等于实际结束时间！'
	},
	actualEndDateVali: {
		validator: function (value) {
			var rows = $("#treegrid").treegrid('getSelections');
	        if(rows.length >0){
	        	var actualStartDateEditor = $('#treegrid').treegrid('getEditor', {id:rows[0].proTaskId,field:'actualStartDate'});
	        	var actualStartDateValue = actualStartDateEditor.target.datebox('getValue');
	        	var actualEndDateEditor = $('#treegrid').treegrid('getEditor', {id:rows[0].proTaskId,field:'actualEndDate'});
	        	var actualEndDateValue = actualEndDateEditor.target.datebox('getValue');
				if(actualStartDateValue == '' || actualEndDateValue == ''){
			    	return true;
			    }
				var time1 = Date.parse(new Date(actualStartDateValue));
			    var time2 = Date.parse(new Date(actualEndDateValue));
			    var nTime = time2 - time1;
				return nTime>=0;
	        }else{
	        	return true;
	        }
        },
		message: '实际结束时间必须大于或等于实际开始时间！'
	}
})

var treegrid;
var checkProTaskId;

var editRow = undefined;
$(function() {
	treegrid = $('#treegrid').treegrid({
		url : '${pageContext.request.contextPath}/taskPlan!treegrid.do?projectId=<%=plan.getProjectId()%>&parentId=0',
		title : '<%=TLMLan.lan("项目任务计划", lan)%>',
		height : 430,
		collapsible: true,
		idField : 'proTaskId',
		treeField:'taskId',
		singleSelect : true,
		frozenColumns : [[
			{	field : 'proTaskId',
				title : '<%=TLMLan.lan("计划ID", lan)%>',
				width : 80,
				hidden : true
			},
			{	field : 'parentId',
				title : '<%=TLMLan.lan("计划ID", lan)%>',
				width : 80,
				hidden : true
			},
			{	field : 'taskId',
				title : '<%=TLMLan.lan("任务ID", lan)%>',
				width : 80,
				editor:{type:'validatebox', options:{ required:true,validType:'length[0,50]'}}
			},

			{	field : 'taskName',
				title : '<%=TLMLan.lan("任务名称", lan)%>',
				width : 120,
				editor:{type:'validatebox', options:{ required:true,validType:'length[0,100]'}}
			}
		]],
		columns : [[
			{	field : 'plannedStartDate',
				title : '<%=TLMLan.lan("计划开始日期", lan)%>',
				width : 80,
				formatter:function(val){
					if(val != null && val !=''&& val !='undefined'){
						return $.formattDateStr(val,'zh');
					}else{
						return "";
					}
				},
				editor:{type:'datebox', options:{editable:false, required:true,validType:'plantartDateVali'}}
			},
	         {
            	field : 'plannedEndDate',
				title : '<%=TLMLan.lan("计划结束日期", lan)%>',
				width : 80,
				formatter:function(val){
					if(val != null && val !=''&& val !='undefined'){
						return $.formattDateStr(val,'zh');
					}else{
						return "";
					}
				},
				editor:{type:'datebox', options:{editable:false, required:true,validType:'planEndDateVali'}}
			},
			{	field : 'actualStartDate',
				title : '<%=TLMLan.lan("实际开始日期", lan)%>',
				width : 80,
				formatter:function(val){
					if(val != null && val !=''&& val !='undefined'){
						return $.formattDateStr(val,'zh');
					}else{
						return "";
					}
				},
				editor:{type:'datebox', options:{editable:false,validType:'actualStartDateVali'}}
			},
	         {
            	field : 'actualEndDate',
				title : '<%=TLMLan.lan("实际结束日期", lan)%>',
				width : 80,
				formatter:function(val){
					if(val != null && val !=''&& val !='undefined'){
						return $.formattDateStr(val,'zh');
					}else{
						return "";
					}
				},
				editor:{type:'datebox', options:{editable:false,validType:'actualEndDateVali'}}
			},
			{
				field : 'createDate',
				title : '<%=TLMLan.lan("创建时间", lan)%>',
				width : 80,
				formatter:function(val){
					if(val != null && val !=''&& val !='undefined'){
						return $.formattDateStr(val,'zh');
					}else{
						return "";
					}
				},
				hidden: true
			},
			{
				field : 'workDays',
				title : '<%=TLMLan.lan("持续时长", lan)%>',
				width : 80,
				formatter:function(val,row,index){
					if(row.plannedStartDate == undefined ||row.plannedEndDate == undefined ){
						return "";
					}else{
						var time1 = Date.parse(new Date(row.plannedStartDate.replace(/-/g, "/")));
					    var time2 = Date.parse(new Date(row.plannedEndDate.replace(/-/g, "/")));
					    var nDays = Math.abs(parseInt((time2 - time1) / 1000 / 3600 / 24));
					    return nDays+1;
					}
				}
			},
			{
				field : 'taskProcess',
				title : '<%=TLMLan.lan("进度百分比", lan)%>',
				width : 80,
				hidden: true
			}
			,
			{
				field : 'workloadSum',
				title : '<%=TLMLan.lan("预估工作量", lan)%>',
				width : 80,
				editor:{type:'validatebox',options:{ validType:'workloadSumVali'}}
			},
			{
				field : 'memberSum',
				title : '<%=TLMLan.lan("预计投入人数", lan)%>',
				width : 80

			},{
				field : 'bak',
				title : '<%=TLMLan.lan("备注", lan)%>',
				width : 80,
				editor:{type:'validatebox', options:{validType:'length[0,1000]'}}
			},
			{
				field : 'memberMess',
				title : '<%=TLMLan.lan("投入人员", lan)%>',
				width : 100,
				hidden: false,
				formatter : function(val, row, rowIndex){
					if(row.taskUserName == undefined){
						row.taskUserName = "选择人员";
					}
					var mess = row.expectedPerson;
					//return "<a href='#' onclick='planHrm_edit(\"" + row.proTaskId + "\",\"" + row.expectedPerson + "\");'>" + row.taskUserName + "</a>";

					return "<a href='#' onclick='setTimeout(planHrm_edit,10)'>" + row.taskUserName + "</a>";
				}
			},
			{
				field : 'taskUserName',
				title : '<%=TLMLan.lan("投入人员", lan)%>',
				width : 120,
				hidden: true
			},
			{
				field : 'expectedPerson',
				title : '<%=TLMLan.lan("投入人员id", lan)%>',
				width : 120,
				hidden: true
			}
		]],

        toolbar: [{
            text: '添加', iconCls: 'addIconCls', handler: function () {
                if (editRow != undefined) {
                	$("#treegrid").treegrid('unselectAll');
                    $("#treegrid").treegrid('endEdit', editRow);
                    $("#treegrid").treegrid('selectRow',editRow);
                    $("#treegrid").treegrid('beginEdit', editRow);
                }
                if (editRow == undefined) {
                	 var rows = $("#treegrid").treegrid('getSelections');
                     if(rows.length >0){
                     	var rowIndex = rows[0].proTaskId;
                     	$("#treegrid").treegrid('append', {
                         	 parent : rows[0].proTaskId,
                             data: [{id:-1,proTaskId:-1,parentId:rows[0].proTaskId,taskId:"",children:[]}]
                         });
                     }else{
                    	 $("#treegrid").treegrid('append', {
                    		 parent : 0,
                             data: [{id:-1,proTaskId:-1,parentId:0,taskId:"",children:[]}]
                         });
                     }
                    $("#treegrid").treegrid('beginEdit', -1);
                    editRow = -1;
                    $("#treegrid").treegrid('unselectAll');
                    $("#treegrid").treegrid('selectRow',editRow);
                }
            }
        }, '-', {
            text: '提交', iconCls: 'icon-commit', handler: function () {
            	$("#treegrid").treegrid('endEdit',  editRow);
                //如果调用acceptChanges(),使用getChanges()则获取不到编辑和新增的数据。
                //使用JSON序列化datarow对象，发送到后台。
                 var rows = $("#treegrid").treegrid('getChanges');
                console.log("sad",rows)
                 if(rows != undefined && rows.length>0){
                	var rows = $("#treegrid").treegrid('getSelections');
                	var rowstr = JSON.stringify(rows[0]);
                    var url = "${pageContext.request.contextPath}";
                    var dataSource;
                    var flag = "";
                    if(rows.length!=1){
                    	parent.cmjs.msgAlert('<%=TLMLan.lan("警告", lan)%>','<%=TLMLan.lan("请编辑一条任务!", lan)%>','warning');
                    	return;
                    }
                    if(rows[0].proTaskId != "" && rows[0].proTaskId != undefined && rows[0].proTaskId != -1){
                    	flag = "EDIT";
                    }else{
                    	flag = "ADD";
                    }
                    if(flag == "EDIT"){
                    	url = url +"/taskPlan!edit.do";
                    	dataSource = {
    							proTaskId : rows[0].proTaskId,
    							projectId : ${requestScope.plan.projectId},
    							parentId: rows[0].parentId,
    							taskId : rows[0].taskId,
    							taskName : rows[0].taskName,
    							plannedStartDate : rows[0].plannedStartDate,
    							plannedEndDate : rows[0].plannedEndDate,
    							actualStartDate : rows[0].actualStartDate,
    							actualEndDate : rows[0].actualEndDate,
    							workloadSum : rows[0].workloadSum,
    							expectedPerson : rows[0].expectedPerson,
    							bak:rows[0].bak
    						};
                    }else{
                    	url = url +"/taskPlan!add.do";
                    	dataSource = {
    							projectId : ${requestScope.plan.projectId},
    							parentId: rows[0].parentId,
    							taskId : rows[0].taskId,
    							taskName : rows[0].taskName,
    							plannedStartDate : rows[0].plannedStartDate,
    							plannedEndDate : rows[0].plannedEndDate,
    							actualStartDate : rows[0].actualStartDate,
    							actualEndDate : rows[0].actualEndDate,
    							workloadSum : rows[0].workloadSum,
    							expectedPerson : rows[0].expectedPerson,
    							bak:rows[0].bak
    						};
                    }
                   $.ajax({
						url : url,
						data : dataSource,
						cache : false,
						dataType : 'JSON',
						success : function(r) {
							if (r.success) {
								if(flag == "EDIT"){
									$("#treegrid").treegrid('update', {
						    	         id :  r.obj.proTaskId,
			                             row: {
			                            	 	parentId: r.obj.parentId,
				    							workDays : r.obj.workDays,
				    							memberSum : r.obj.memberSum
			    							}
			                        });
								}else{
									$("#treegrid").treegrid('update', {
						    	         id : -1,
			                             row: {
			                            	    id :  r.obj.proTaskId,
			                            	    proTaskId : r.obj.proTaskId,
			                            	    parentId: r.obj.parentId,
				    							workDays : r.obj.workDays,
				    							memberSum : r.obj.memberSum,
				    							children : []
			    							}
			                        });
								}
								$("#treegrid").treegrid('unselectAll');
								$("#treegrid").treegrid('acceptChanges');
								/*
								$("#treegrid").treegrid('reload',r.obj.proTaskId);
								$("#treegrid").treegrid('refresh',r.obj.proTaskId); */
								$("#treegrid").treegrid('reload'); //页面刷新
	                    		editRow = undefined;
							}else{
								$("#treegrid").treegrid('unselectAll');
	                            $("#treegrid").treegrid('selectRow',editRow);
	                            $("#treegrid").treegrid('endEdit', editRow);
	                            $("#treegrid").treegrid('beginEdit', editRow);
							}
							parent.cmjs.msgShow({
								msg : r.msg,
								title : '<%=TLMLan.lan("提示", lan)%>'
							});
						}
					});
                 }

            }
        }, '-', {
            text: '撤销', iconCls: 'icon-rollback', handler: function () {
            	if(editRow != undefined){
                    if(editRow == -1){
                    	$("#treegrid").treegrid('remove',editRow);
                    }else{
                    	$("#treegrid").treegrid('cancelEdit',editRow);
                    }
            		editRow = undefined;
            		$("#treegrid").treegrid('unselectAll');
            	}
            }
        }, '-', {
            text: '删除', iconCls: 'removeIconCls', handler: function () {
                var rows = $("#treegrid").treegrid('getSelections');
                if(rows.length >0){
                	var rowIndex = rows[0].proTaskId;
                	$.ajax({
						url : '${pageContext.request.contextPath}/taskPlan!delete.do',
						data : {
							proTaskId : rows[0].proTaskId
						},
						cache : false,
						dataType : 'JSON',
						success : function(r) {
							if (r.success) {
								$("#treegrid").treegrid('remove',rowIndex);
	                    		$("#treegrid").treegrid('acceptChanges');
	                    		editRow = undefined;
							}else{
								$("#treegrid").treegrid('unselectAll');
	                            $("#treegrid").treegrid('select',rowIndex);
	                            if(editRow != undefined){
	                            	$("#treegrid").treegrid('endEdit', editRow);
	                                $("#treegrid").treegrid('beginEdit', editRow);
	                            }
							}
							parent.cmjs.msgShow({
								msg : r.msg,
								title : '<%=TLMLan.lan("提示", lan)%>'
							});
						}
					});
                }
            }
        }, '-', {
            text: '修改', iconCls: 'editIconCls', handler: function () {
                var rows = $("#treegrid").treegrid('getSelections');
                if (rows !=null && rows != '') {
                    if (editRow != undefined) {

                    } else if (editRow == undefined  ) {
                        var index = rows[0].proTaskId;
                        $("#treegrid").treegrid('beginEdit', index);
                        editRow = index;
                    }
                }
            }
        }],
        onAfterEdit: function (row, changes) {

        },
        onDblClickRow : function (row) {
            if (editRow != undefined) {
            }
            if (editRow == undefined) {
           		$("#treegrid").treegrid('beginEdit', row.proTaskId);
                editRow = row.proTaskId;
            }
        },
        onClickRow:function(row){
            if (editRow != undefined) {
            	$("#treegrid").treegrid('unselectAll');
                $("#treegrid").treegrid('select',editRow);
                $("#treegrid").treegrid('endEdit', editRow);
                $("#treegrid").treegrid('beginEdit', editRow);
            }

        }
	});
});



function planHrm_edit() {
	var proTaskId='-1';
	var expectedPerson="";
	//判断 任务名称 是否为空
	var rowsGet = $("#treegrid").treegrid('getSelected');
	if(rowsGet){
		proTaskId = rowsGet.proTaskId;
		expectedPerson = rowsGet.expectedPerson;
	}else{
		parent.cmjs.msgAlert('<%=TLMLan.lan("警告", lan)%>','<%=TLMLan.lan("请选择一条任务!", lan)%>','warning');
		return;
	}
	var p = parent.cmjs.showDialog({shadow: true,
				title : "<span style=\"line-height:30px;padding-left:5px;color:#FFFFFF\"><%=TLMLan.lan("人员信息",lan)%></span>",
				href : '${pageContext.request.contextPath}/taskPlan!userDlgHrm.do?projectId='+<%=plan.getProjectId()%>+'&proTaskId='+proTaskId+'&expectedPerson='+expectedPerson,
				width : 730,
				height : 450,
				buttons : [ {
					text : '<%=TLMLan.lan("确定",lan)%>',
					handler : function() {
						var rows = p.find('#datagridHrmAll').datagrid('getChecked');
						var uids="";
						var uName="选择人员";
						if(rows.length>0){
							for(var i=0;i<rows.length;i++){
								if(i==0){
									uids=rows[0].userId;
									uName=rows[0].realName+"...";
								}else{
									uids+=","+rows[i].userId;
								}
							}
						}
						$("#treegrid").treegrid('update', {
			    	         id :  proTaskId,
                             row: {
                            	 taskUserName :uName,
                            	 expectedPerson : uids
   							}
                       });
					   p.dialog('close');// 关闭
					   //用于提交保存
					    if (editRow != undefined) {
							return;
			            }
			            if (editRow == undefined) {
			           		$("#treegrid").treegrid('beginEdit', rowsGet.proTaskId);
			                editRow = rowsGet.proTaskId;
			            }
					}
				},{
					text : '<%=TLMLan.lan("取消",lan)%>',
					handler : function() {
							p.dialog('close');
					}
				}]
			});
}

</script>
<div align="center" style="padding: 5px; overflow: hidden;">
	<form id="planForm" enctype="multipart/form-data" method="post"
		action="${pageContext.request.contextPath}/plan!edit.do">
		<input id="proTaskId" name="proTaskId" type="hidden">
		<table class="tableForm">
			<tr>

				<th>项目名称:</th>
				<td><select id="projectId" name="projectId"
					class="easyui-combobox" readOnly >
						<c:forEach var="item" items="${sessionInfo.projectList}">
							<option value="${item.projectId}">${item.projectName}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<div data-options="region:'center',border:false" style="height: 5px"></div>
		<div data-options="region:'center',border:false"
			style="width: 99%; height: 99%">
			<table id="treegrid"></table>
		</div>
	</form>
</div>

