(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6c04cc52"],{baa6:function(t,e,a){"use strict";var n=a("c3f9"),i=a.n(n);i.a},c3f9:function(t,e,a){},d75c:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{margin:"50px 50px"}},[a("el-card",{staticClass:"box-card"},[a("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":t.activeIndex,mode:"horizontal","active-text-color":"#606266"},on:{select:t.handleSelect}},[a("el-submenu",{attrs:{index:"1"}},[a("template",{slot:"title"},[t._v("未读")]),a("el-menu-item",{attrs:{index:"1-0"}},[t._v("全部")]),a("el-menu-item",{attrs:{index:"1-1"}},[t._v("系统通知")]),a("el-menu-item",{attrs:{index:"1-2"}},[t._v("评论")])],2),a("el-submenu",{attrs:{index:"2"}},[a("template",{slot:"title"},[t._v("已读")]),a("el-menu-item",{attrs:{index:"2-0"}},[t._v("全部")]),a("el-menu-item",{attrs:{index:"2-1"}},[t._v("系统通知")]),a("el-menu-item",{attrs:{index:"2-2"}},[t._v("评论")])],2),a("el-submenu",{attrs:{index:"3"}},[a("template",{slot:"title"},[t._v("垃圾箱")]),a("el-menu-item",{attrs:{index:"3-0"}},[t._v("全部")]),a("el-menu-item",{attrs:{index:"3-1"}},[t._v("系统通知")]),a("el-menu-item",{attrs:{index:"3-2"}},[t._v("评论")])],2)],1),[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData}},[a("el-table-column",{attrs:{label:"日期",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("i",{staticClass:"el-icon-time"}),a("span",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(e.row.remark_date))])]}}])}),a("el-table-column",{attrs:{label:"内容",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-popover",{staticStyle:{cursor:"pointer"},attrs:{trigger:"hover",placement:"top"}},[a("p",[t._v("评论人："+t._s(e.row.userName))]),a("div",{staticClass:"name-wrapper",attrs:{slot:"reference"},slot:"reference"},[a("el-tag",{attrs:{size:"medium"}},[t._v(t._s(e.row.content))])],1)])]}}])}),a("el-table-column",{attrs:{label:"文件",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("i",{staticClass:"el-icon-tickets"}),a("span",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(e.row.documentName))])]}}])}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return t.handleEdit(e.$index,e.row)}}},[t._v("回复\n                        ")]),a("el-button",{attrs:{size:"mini"},on:{click:function(a){return t.handleHistory(e.$index,e.row)}}},[t._v("对话记录\n                        ")]),a("el-button",{directives:[{name:"show",rawName:"v-show",value:!("3-0"===t.showDel||"3-1"===t.showDel||"3-2"===t.showDel),expression:"!(showDel==='3-0'||showDel==='3-1'||showDel==='3-2')"}],attrs:{size:"mini",type:"danger"},on:{click:function(a){return t.handleRemove(e.$index,e.row)}}},[t._v("删除\n                        ")]),a("el-button",{directives:[{name:"show",rawName:"v-show",value:"3-0"===t.showDel||"3-1"===t.showDel||"3-2"===t.showDel,expression:"showDel==='3-0'||showDel==='3-1'||showDel==='3-2'"}],attrs:{size:"mini",type:"danger"},on:{click:function(a){return t.handleDelete(e.$index,e.row)}}},[t._v("彻底删除\n                        ")])]}}])})],1)]],2),a("el-dialog",{attrs:{visible:t.dialogHistory},on:{"update:visible":function(e){t.dialogHistory=e}}},[a("div",{staticClass:"block"},[a("el-card",{staticStyle:{"margin-bottom":"20px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[t._v("对话历史")])]),a("el-timeline",[t._l(t.documentComment,function(e,n){return a("el-timeline-item",{key:n,attrs:{timestamp:e.remarkDate,placement:"top"}},[a("div",{staticStyle:{"margin-left":"40px"}},[a("p",{staticStyle:{"font-size":"16px","margin-left":"5px","margin-bottom":"5px",float:"left"}},[t._v("\n                                "+t._s(e.commentatorName))]),a("div",{staticClass:"l-info"},[a("div",{staticClass:"l-nav l-nav-border"}),a("div",{staticClass:"l-nav l-nav-background"}),t._v("\n                                "+t._s(e.content)+"\n                            ")])])])}),t._l(t.documentComment2,function(e,n){return a("el-timeline-item",{attrs:{timestamp:e.remarkDate,placement:"top"}},[a("div",{staticStyle:{"margin-left":"40px"}},[a("p",{staticStyle:{"font-size":"16px","margin-left":"5px","margin-bottom":"5px",float:"left"}},[t._v("\n                                "+t._s(e.commentatorName))]),a("div",{staticClass:"l-info"},[a("div",{staticClass:"l-nav l-nav-border"}),a("div",{staticClass:"l-nav l-nav-background"}),t._v("\n                                "+t._s(e.content)+"\n                            ")])])])})],2)],1)],1)]),a("el-dialog",{attrs:{visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("div",[a("el-card",[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[t._v("回复")])]),a("div",{staticStyle:{margin:"2px 0"}},[a("el-checkbox",{staticStyle:{margin:"5px 0"},model:{value:t.value2,callback:function(e){t.value2=e},expression:"value2"}},[t._v("匿名")]),a("el-input",{staticStyle:{margin:"5px 0"},attrs:{type:"textarea",autosize:{minRows:2,maxRows:4},placeholder:"必须少于50个字符！"},model:{value:t.remark_content,callback:function(e){t.remark_content=e},expression:"remark_content"}})],1)])],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:t.dialogCancel}},[t._v("设为已读")]),a("el-button",{attrs:{type:"primary",disabled:t.showButton},on:{click:t.dialogSubmit}},[t._v("提交")])],1)])],1)},i=[],s=(a("639b"),a("e6d8"),a("7ac3"),a("f534"),a("c30b"),a("bc2f"),a("74f7"),a("611e"),a("0ec7")),o=a.n(s),l=a("7f43"),r=a.n(l),c=a("6bf2"),u=a.n(c),m={watch:{$route:function(){var t=this;this.userId=JSON.parse(localStorage.getItem("user_msg")).id,r.a.get("/IGSDN/genUser/userInformation/"+this.userId).then(function(e){t.data=e.data,t.handleSelect("1-0",null)}).catch(function(t){console.log(t)})}},mounted:function(){var t=this;this.userId=JSON.parse(localStorage.getItem("user_msg")).id,r.a.get("/IGSDN/genUser/userInformation/"+this.userId).then(function(e){t.data=e.data,t.handleSelect("1-0",null)}).catch(function(t){console.log(t)})},data:function(){return{dialogFormVisible:!1,dialogHistory:!1,documentID:"",dc_id:"",userID:"",userId:"",index:"",value2:!1,showSubmitButton:"true",remark_content:"",showDel:"",activeIndex:"1-1",data:[],tableData:[],documentComment:[{commentator:"",content:"",document:"",id:"",identify:"",remarkDate:"",commentatorName:"",documentName:""}],documentComment2:[{commentId:"",commentator:"",content:"",document:"",id:"",identify:"",second:"",remarkDate:"",commentatorName:"",documentName:""}],formLabelWidth:"120px"}},computed:{show:function(){var t=this.showDel.splice("-");if(3===t[0])return!0},showButton:function(){return this.remark_content.trim().length<50&&this.remark_content.trim().length>0?this.showSubmitButton=!1:this.showSubmitButton=!0}},methods:{handleSelect:function(t,e){this.showDel=t;var a=t.toString(),n=a.split("-");switch(n[0]){case"1":"0"===n[1]?this.tableData=this.data.filter(function(t){return 1===t.state}):"1"===n[1]?this.tableData=this.data.filter(function(t){return"0"===t.source&&1===t.state}):"2"===n[1]&&(this.tableData=this.data.filter(function(t){return"0"!==t.source&&1===t.state}));break;case"2":"0"===n[1]?this.tableData=this.data.filter(function(t){return 2===t.state||3===t.state}):"1"===n[1]?this.tableData=this.data.filter(function(t){return"0"===t.source&&(2===t.state||3===t.state)}):"2"===n[1]&&(this.tableData=this.data.filter(function(t){return"0"!==t.source&&(2===t.state||3===t.state)}));break;case"3":"0"===n[1]?this.tableData=this.data.filter(function(t){return 0===t.state}):"1"===n[1]?this.tableData=this.data.filter(function(t){return"0"===t.source&&0===t.state}):"2"===n[1]&&(this.tableData=this.data.filter(function(t){return"0"!==t.source&&0===t.state}));break}},handleHistory:function(t,e){var a=this;this.dialogHistory=!0,r.a.get("/IGSDN/genUser/showRemark/"+e.id).then(function(t){for(var e=t.data,n=e["list1"],i=e["list2"],s=0;s<n.length;s++)n[s].identify&&(n[s].commentatorName="匿名");for(s=0;s<i.length;s++)i[s].commentator===a.userId?i[s].commentatorName="您":i[s].identify&&i[s].commentator!==a.userId&&(i[s].commentatorName="匿名");a.documentComment2=i.sort(function(t,e){return t["id"]<e["id"]?-1:t["id"]>e["id"]?1:0}),a.documentComment=n}).catch(function(t){console.log(t)})},handleRemove:function(t,e){var a=this,n=e.id,i=0;r.a.put("/IGSDN/genUser/userInformationRemove/",{userInformationID:n,state:i}).then(function(t){t.data?(o.a.publish("removeInformationNum",1),a.$message({showClose:!0,message:"已放入垃圾箱",type:"success"})):a.$message({showClose:!0,message:"放入垃圾箱失败",type:"error"})}).catch(function(t){console.log(t)}),1!==this.tableData[t].state&&2!==this.tableData[t].state&&3!==this.tableData[t].state||(this.tableData[t].state=0,this.tableData.splice(t,1))},handleEdit:function(t,e){this.remark_content="",this.thisRowID=e.dc_id,this.thisRowType=e.source,this.documentID=e.documentID,this.userID=e.userID,this.dialogFormVisible=!0,this.index=t},handleDelete:function(t,e){var a=this;this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){a.$message({type:"success",message:"删除成功!"});var t=e.id;r.a.delete("/IGSDN/genUser/userInformationDelete/"+t).then(function(e){return e.data?(a.data.forEach(function(e,n){e.id==t&&a.data.splice(n,1)}),"删除成功"):"未删除"}).catch(function(t){console.log(t)}),a.tableData.splice(a.index,1)}).catch(function(){a.$message({type:"info",message:"已取消"})})},dialogSubmit:function(){var t=this;if(1===this.tableData[this.index].state||2===this.tableData[this.index].state){this.tableData[this.index].state;var e=this.tableData[this.index].state,a=this.tableData[this.index].id;r.a.put("/IGSDN/genUser/userInformationRemove/",{userInformationID:a,state:e}).then(function(e){return e.data?(t.tableData.splice(t.index,1),"修改成功"):"未修改"}).catch(function(t){console.log(t)})}var n,i={};n=this.userID,1===this.thisRowType?i.isSecond=!0:2===this.thisRowType&&(i.isSecond=!1),i.document=this.documentID,i.commentId=this.thisRowID,i.content=this.remark_content,i.commentator=this.userId,i.remarkDate=u()().utc().format("YYYY-MM-DD"),i.isIdentify=this.value2,i.id=null,r.a.post("/IGSDN/genUser/userInformationRemark/",{documentComment2String:JSON.stringify(i),receive:n}).then(function(e){e.data?(t.dialogFormVisible=!1,t.$message({showClose:!0,message:"回复成功",type:"success"})):t.$message({showClose:!0,message:"回复失败",type:"error"})}).catch(function(t){console.log(t)}),this.dialogFormVisible=!1},dialogCancel:function(){if(1===this.tableData[this.index].state){this.tableData[this.index].state=2;var t=this.tableData[this.index].state,e=this.tableData[this.index].id;r.a.put("/IGSDN/genUser/userInformationRemove/",{userInformationID:e,state:t}).then(function(t){return t.data?"修改成功":"未修改"}).catch(function(t){console.log(t)}),this.tableData.splice(this.index,1)}this.dialogFormVisible=!1}}},d=m,h=(a("baa6"),a("17cc")),f=Object(h["a"])(d,n,i,!1,null,"18becb29",null);e["default"]=f.exports}}]);