(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0ba81d"],{3802:function(e,c,n){"use strict";n.r(c);var s=function(){var e=this,c=e.$createElement,n=e._self._c||c;return n("div",{style:{padding:e.isSuccess?"0":"20px"}},[n("div",{directives:[{name:"show",rawName:"v-show",value:e.isSuccess,expression:"isSuccess"}]},e._l(e.documentData,function(e){return n("img",{attrs:{src:"data:image/jpg;base64,"+e}})}),0),n("div",{directives:[{name:"show",rawName:"v-show",value:!e.isSuccess,expression:"!isSuccess"}]},[e._v("\n        "+e._s(this.documentData)+"\n    ")])])},t=[],o=(n("612f"),n("7f43")),a=n.n(o),u={name:"DocumentOnlinePreview",data:function(){return{isSuccess:!1,documentData:"数据加载中..."}},created:function(){var e=this,c=1,n="pdf",s="document\\public\\AlgD&A19春夏-01 算法概述.pdf";console.log("documentId:"+c),console.log("documentType:"+n),console.log("documentUrl:"+s),a.a.post("/IGSDN/documentOnlinePreview",{documentId:c,documentType:n,documentUrl:s}).then(function(c){e.documentData=JSON.parse(c.data),e.documentData.forEach(function(e){console.log(e)}),e.isSuccess=!0}).catch(function(c){e.documentData="数据加载失败！",e.isSuccess=!1})}},i=u,d=n("17cc"),r=Object(d["a"])(i,s,t,!1,null,"b4882e50",null);c["default"]=r.exports}}]);