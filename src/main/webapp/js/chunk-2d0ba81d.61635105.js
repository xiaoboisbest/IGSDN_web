(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0ba81d"],{3802:function(e,n,s){"use strict";s.r(n);var c=function(){var e=this,n=e.$createElement,s=e._self._c||n;return s("div",[s("div",{directives:[{name:"show",rawName:"v-show",value:!e.isSuccess,expression:"!isSuccess"}],staticStyle:{padding:"20px"}},[e._v("\n        "+e._s(this.msg)+"\n    ")]),e._l(e.documentData,function(n){return s("div",{directives:[{name:"show",rawName:"v-show",value:e.isSuccess,expression:"isSuccess"}]},[s("img",{attrs:{src:"data:image/jpg;base64,"+n}})])})],2)},t=[],o=s("7f43"),a=s.n(o),i={name:"DocumentOnlinePreview",data:function(){return{isSuccess:!1,msg:"数据加载中...",documentData:[]}},created:function(){var e=this,n=1,s="pdf",c="document\\public\\AlgD&A19春夏-01 算法概述.pdf";console.log("documentId:"+n),console.log("documentType:"+s),console.log("documentUrl:"+c),a.a.post("/IGSDN/documentOnlinePreview",{documentId:n,documentType:s,documentUrl:c}).then(function(n){e.msg="",e.documentData=n.data,e.isSuccess=!0}).catch(function(n){e.msg="数据加载失败",e.isSuccess=!1})}},u=i,d=s("17cc"),r=Object(d["a"])(u,c,t,!1,null,"51694197",null);n["default"]=r.exports}}]);