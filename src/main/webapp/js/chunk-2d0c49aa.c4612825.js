(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0c49aa"],{"3c15":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[t.isPrivate?t._e():i("KnowledgeScroller",{staticStyle:{margin:"0 10px"},attrs:{isScrolling:t.isScrolling,categoryId:t.categoryId,changeFlag:t.changeFlag},on:{loadingFlag:t.receiveChildMsg}}),t.isPrivate?i("KnowledgePagination",{staticStyle:{margin:"0 10px"},attrs:{categoryId:t.categoryId,changeFlag:t.changeFlag}}):t._e()],1)},n=[],s=(i("c30b"),i("6646")),o=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticStyle:{margin:"0 10px"}},[i("span",{staticStyle:{width:"auto",display:"inline",float:"left"}},[i("el-card",{staticStyle:{"min-width":"600px"}},[i("el-input",{staticStyle:{"font-size":"14px",width:"640px",margin:"5px 20px 20px 20px"},attrs:{"prefix-icon":"el-icon-search",placeholder:"文件搜索...",clearable:""},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.init(!1)}},model:{value:t.query,callback:function(e){t.query=e},expression:"query"}}),i("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:t.upload}},[t._v("上传新文件")]),i("div",{staticStyle:{margin:"10px auto","text-align":"center"}},[i("i",{directives:[{name:"show",rawName:"v-show",value:t.isLoading,expression:"isLoading"}],staticClass:"el-icon-loading"}),t._v(t._s(t.msg))]),t._l(t.documentList,function(t){return i("KnowledgeItem",{key:t.id,staticStyle:{margin:"0 20px 20px 0",width:"auto",display:"inline"},attrs:{document:t,isPrivate:!0,isPublic:t.public}})})],2),i("el-card",[i("el-pagination",{attrs:{"current-page":t.currentPage,"page-sizes":[5,10,15,20],"page-size":t.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:t.total},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1)],1),i("CategoryIntro",{attrs:{categoryId:t.categoryId}})],1)},c=[],r=i("7f43"),l=i.n(r),g=i("0ec7"),u=i.n(g),d=i("1c45"),h=i("8ae3"),p={name:"KnowledgePagination",components:{CategoryIntro:h["a"],KnowledgeItem:d["a"]},props:["categoryId","changeFlag"],data:function(){return{query:"",userId:0,total:0,pageSize:5,currentPage:1,isLoading:!1,isSuccess:!0,documentList:[]}},mounted:function(){var t=this;this.userId=JSON.parse(localStorage.getItem("user_msg")).id,this.init(!0),u.a.subscribe("deleteDocument",function(e,i){i&&t.listDocumentByPagination()})},watch:{changeFlag:function(){this.init(!0)}},computed:{msg:function(){return this.isLoading?"加载中...":this.isSuccess||0!=this.documentList.length?this.isSuccess&&0==this.documentList.length?"暂无更多数据":"":"抱歉，加载失败，请尝试刷新页面"}},methods:{init:function(t){this.total=0,this.pageSize=5,this.currentPage=1,this.isLoading=!1,this.isSuccess=!0,this.documentList=[],t&&(this.query=""),this.listDocumentByPagination()},handleSizeChange:function(t){this.pageSize=t,this.listDocumentByPagination(),console.log("每页 ".concat(t," 条"))},handleCurrentChange:function(t){this.currentPage=t,this.listDocumentByPagination(),console.log("当前页: ".concat(t))},listDocumentByPagination:function(){var t=this;this.isLoading=!0;var e=this.query,i=this.userId,a=this.currentPage,n=this.pageSize,s=this.categoryId;l.a.post("/IGSDN/listDocumentByPagination",{query:e,userId:i,categoryId:s,currentPage:a,pageSize:n}).then(function(e){t.documentList=e.data.data,t.total=e.data.total,t.isLoading=!1}).catch(function(e){t.isSuccess=!1,t.isLoading=!1})},upload:function(){this.$router.push("upload")}}},y=p,m=i("17cc"),f=Object(m["a"])(y,o,c,!1,null,"6008c942",null),v=f.exports,S={name:"Knowledge",props:["isScrolling"],components:{KnowledgeScroller:s["a"],KnowledgePagination:v},data:function(){return{changeFlag:!0,isPrivate:!0,categoryId:0}},created:function(){this.getCategory()},watch:{$route:function(){this.getCategory()},category:{handler:function(t,e){t!=e&&(this.changeFlag=!this.changeFlag)},deep:!0}},computed:{category:function(){var t=this.isPrivate,e=this.categoryId;return{isPrivate:t,categoryId:e}}},methods:{getCategory:function(){var t=this.$route.params.category,e=t.split("-");"private"==e[0]?(this.categoryId=e[1],this.isPrivate=!0):(this.categoryId=e[0],this.isPrivate=!1)},receiveChildMsg:function(t){this.$emit("loadingFlag",t)}}},I=S,P=Object(m["a"])(I,a,n,!1,null,"7cfc9be0",null);e["default"]=P.exports}}]);