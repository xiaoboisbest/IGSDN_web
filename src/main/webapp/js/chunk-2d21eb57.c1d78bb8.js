(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21eb57"],{d75c:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{margin:"50px 50px"}},[a("el-card",{staticClass:"box-card"},[a("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":t.activeIndex,mode:"horizontal","active-text-color":"#606266"},on:{select:t.handleSelect}},[a("el-submenu",{attrs:{index:"1"}},[a("template",{slot:"title"},[t._v("未读")]),a("el-menu-item",{attrs:{index:"1-1"}},[t._v("系统通知")]),a("el-menu-item",{attrs:{index:"1-2"}},[t._v("评论")])],2),a("el-submenu",{attrs:{index:"2"}},[a("template",{slot:"title"},[t._v("已读")]),a("el-menu-item",{attrs:{index:"2-1"}},[t._v("系 统通知")]),a("el-menu-item",{attrs:{index:"2-2"}},[t._v("评论")])],2),a("el-submenu",{attrs:{index:"3"}},[a("template",{slot:"title"},[t._v("垃圾箱")]),a("el-menu-item",{attrs:{index:"3-1"}},[t._v("系统通知")]),a("el-menu-item",{attrs:{index:"3-2"}},[t._v("评论")])],2)],1),[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData}},[a("el-table-column",{attrs:{label:"日期",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("i",{staticClass:"el-icon-time"}),a("span",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(e.row.remark_date))])]}}])}),a("el-table-column",{attrs:{label:"姓名",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-popover",{attrs:{trigger:"hover",placement:"top"}},[a("p",[t._v("姓名: "+t._s(e.row.userName))]),a("div",{staticClass:"name-wrapper",attrs:{slot:"reference"},slot:"reference"},[a("el-tag",{attrs:{size:"medium"}},[t._v(t._s(e.row.userName))])],1)])]}}])}),a("el-table-column",{attrs:{label:"文件",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("i",{staticClass:"el-icon-tickets"}),a("span",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(e.row.documentName))])]}}])}),a("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini"},on:{click:function(a){return t.handleEdit(e.$index,e.row)}}},[t._v("回复\n                        ")]),a("el-button",{directives:[{name:"show",rawName:"v-show",value:!("3-1"===t.showDel||"3-2"===t.showDel),expression:"!(showDel==='3-1'||showDel==='3-2')"}],attrs:{size:"mini",type:"danger"},on:{click:function(a){return t.handleRemove(e.$index,e.row)}}},[t._v("删除\n                        ")]),a("el-button",{directives:[{name:"show",rawName:"v-show",value:"3-1"===t.showDel||"3-2"===t.showDel,expression:"showDel==='3-1'||showDel==='3-2'"}],attrs:{size:"mini",type:"danger"},on:{click:function(a){return t.handleDelete(e.$index,e.row)}}},[t._v("彻底删除\n                        ")])]}}])})],1)]],2),a("el-dialog",{attrs:{visible:t.dialogFormVisible},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("div",{staticClass:"block"},[a("el-timeline",[t._l(t.documentCommnent,function(e,n){return a("el-timeline-item",{key:n,attrs:{timestamp:e.remarkDate,placement:"top"}},[e.identify?a("el-card",[a("h4",{staticStyle:{"margin-left":"10px"}},[t._v("匿名 评论：")]),a("p",{staticStyle:{"font-size":"22px","margin-left":"80px"}},[t._v(" "+t._s(e.content))])]):t._e(),e.identify?t._e():a("el-card",[a("h4",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(e.commentatorName)+" 评论：")]),a("p",{staticStyle:{"font-size":"22px","margin-left":"80px"}},[t._v(" "+t._s(e.content))])])],1)}),t._l(t.documentCommnent2,function(e,n){return a("el-timeline-item",{attrs:{timestamp:e.remarkDate,placement:"top"}},[e.commentator===t.ID?a("el-card",{staticStyle:{height:"85px"}},[a("h4",{staticStyle:{float:"right","padding-right":"10px"}},[t._v(" 你 回复")]),a("br"),a("p",{staticStyle:{"font-size":"22px",float:"right","padding-right":"50px"}},[t._v(" "+t._s(e.content))])]):t._e(),e.commentator!==t.ID&&1==e.identify?a("el-card",[a("h4",{staticStyle:{"margin-left":"10px"}},[t._v("匿名 评论：")]),a("p",{staticStyle:{"font-size":"22px","margin-left":"80px"}},[t._v(" "+t._s(e.content))])]):t._e(),e.commentator!==t.ID&&0==e.identify?a("el-card",[a("h4",{staticStyle:{"margin-left":"10px"}},[t._v(t._s(e.commentatorName)+" 评论：")]),a("p",{staticStyle:{"font-size":"22px","margin-left":"80px"}},[t._v(" "+t._s(e.content))])]):t._e()],1)})],2)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:t.dialogCancel}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:t.dialogSubmit}},[t._v("确 定")])],1)])],1)},i=[],s=(a("ab56"),a("ea65"),a("48fb"),a("7f43")),o=a.n(s),r={mounted:function(){var t=this;this.handleSelect("1-1",null);var e=3;this.ID=e,o.a.get("/IGSDN/genUser/userInformation/"+e).then(function(e){t.data=e.data}).catch(function(t){console.log(t)})},data:function(){return{ID:"",index:"",showError:!1,remark_content:"",showDel:"",activeIndex:"1-1",data:[{content:"翠花我爱你",documentName:"111",id:"",is_dentify:"",remark_date:"",source:"1",state:"1",userName:"张三",documentID:"",userID:""}],tableData:[],dialogFormVisible:!1,form:{remark_date:"2018-07-09",userName:"张三",content:"翠花我爱你",reMessage:""},documentCommnent:[{commentator:"",content:"",document:"",id:"",identify:"",remarkDate:"",commentatorName:"",documentName:""}],documentCommnent2:[{commentId:"",commentator:"",content:"",document:"",id:"",identify:"",second:"",remarkDate:"",commentatorName:"",documentName:""}],formLabelWidth:"120px"}},computed:{show:function(){var t=this.showDel.splice("-");if(3===t[0])return!0},reverseSum:function(){return this.documentCommnent2.reverse()}},methods:{handleSelect:function(t,e){this.showDel=t;var a=t.toString(),n=a.split("-");switch(n[0]){case"1":n.shift(),"1"===n[0]?this.tableData=this.data.filter(function(t){return"0"===t.source&&1===t.state}):"2"===n[0]&&(this.tableData=this.data.filter(function(t){return"0"!==t.source&&1===t.state}));break;case"2":n.shift(),"1"===n[0]?this.tableData=this.data.filter(function(t){return"0"===t.source&&(2===t.state||3===t.state)}):"2"===n[0]&&(this.tableData=this.data.filter(function(t){return"0"!==t.source&&(2===t.state||3===t.state)}));break;case"3":n.shift(),"1"===n[0]?this.tableData=this.data.filter(function(t){return"0"===t.source&&0===t.state}):"2"===n[0]&&(this.tableData=this.data.filter(function(t){return"0"!==t.source&&0===t.state}));break}},handleRemove:function(t,e){var a=e.id,n=0;o.a.put("/IGSDN/genUser/userInformationRemove/",{userInformationID:a,state:n}).then(function(t){t.data?alert("修改成功"):alert("修改shibai")}).catch(function(t){console.log(t)}),1!==this.tableData[t].state&&2!==this.tableData[t].state&&3!==this.tableData[t].state||(this.tableData[t].state=0,this.tableData.splice(t,1))},handleEdit:function(t,e){var a=this;o.a.get("/IGSDN/genUser/showRemark/"+e.id).then(function(t){var e=t.data;a.documentCommnent=e["list1"];var n=e["list2"];console.log(n),n.sort(function(t,e){return t["id"]<e["id"]?-1:t["id"]>e["id"]?1:0}),a.documentCommnent2=n}).catch(function(t){console.log(t)}),this.dialogFormVisible=!0,this.index=t,this.form.userName=e.userName,this.form.content=e.content,this.form.remark_date=e.remark_date},handleDelete:function(t,e){var a=e.id;o.a.delete("/IGSDN/genUser/userInformationDelete/"+a).then(function(t){return t.data?"删除成功":"未删除"}).catch(function(t){console.log(t)}),this.tableData.splice(this.index,1)},open:function(){var t=this;this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.$message({type:"success",message:"删除成功!"})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},dialogSubmit:function(){if((this.form.reMessage.trim().length>50||0===this.form.reMessage.trim().length)&&(this.showError=!0),1===this.tableData[this.index].state||2===this.tableData[this.index].state){this.tableData[this.index].state=3;var t=this.tableData[this.index].state,e=this.tableData[this.index].id;o.a.put("/IGSDN/genUser/userInformationRemove/",{userInformationID:e,state:t}).then(function(t){return t.data?"修改成功":"未修改"}).catch(function(t){console.log(t)}),this.tableData.splice(this.index,1)}this.dialogFormVisible=!1},dialogCancel:function(){if(1===this.tableData[this.index].state){this.tableData[this.index].state=2;var t=this.tableData[this.index].state,e=this.tableData[this.index].id;alert(e+"=="+t),o.a.put("/IGSDN/genUser/userInformationRemove/",{userInformationID:e,state:t}).then(function(t){return t.data?"修改成功":"未修改"}).catch(function(t){console.log(t)}),this.tableData.splice(this.index,1)}this.dialogFormVisible=!1}}},l=r,c=a("17cc"),m=Object(c["a"])(l,n,i,!1,null,"63444a6a",null);e["default"]=m.exports}}]);