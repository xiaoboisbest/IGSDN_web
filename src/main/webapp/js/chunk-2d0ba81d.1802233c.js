(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0ba81d"],{3802:function(e,c,n){"use strict";n.r(c);var s=function(){var e=this,c=e.$createElement,n=e._self._c||c;return n("div",[n("div",{directives:[{name:"show",rawName:"v-show",value:!e.isSuccess,expression:"!isSuccess"}],staticStyle:{padding:"20px"}},[e._v("\n        "+e._s(this.msg)+"\n    ")]),e._l(e.documentData,function(c){return n("div",{directives:[{name:"show",rawName:"v-show",value:e.isSuccess,expression:"isSuccess"}]},[n("img",{attrs:{src:"data:image/jpg;base64,"+c,width:"100%"}})])})],2)},t=[],o=n("7f43"),i=n.n(o),u={name:"DocumentOnlinePreview",data:function(){return{isSuccess:!1,msg:"数据加载中...",documentData:[]}},created:function(){var e=this,c=1,n="docx",s="document\\public\\vue脚手架(vue-cli)安装教程.docx";console.log("documentId:"+c),console.log("documentType:"+n),console.log("documentUrl:"+s),i.a.post("/IGSDN/documentOnlinePreview",{documentId:c,documentType:n,documentUrl:s}).then(function(c){e.msg="",e.documentData=c.data,e.isSuccess=!0}).catch(function(c){e.msg="数据加载失败",e.isSuccess=!1})}},a=u,d=n("17cc"),r=Object(d["a"])(a,s,t,!1,null,"0bfabc0c",null);c["default"]=r.exports}}]);