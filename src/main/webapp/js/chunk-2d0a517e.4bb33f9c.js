(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0a517e"],{"08dd":function(e,i,t){"use strict";t.r(i);var n=function(){var e=this,i=e.$createElement,t=e._self._c||i;return t("div",["images"===e.type?t("div",{staticClass:"images"},e._l(e.documentData,function(e){return t("div",{staticStyle:{padding:"0 50px"}},[t("img",{attrs:{src:e,width:"100%"}})])}),0):e._e(),"markdown"===e.type?t("div",{staticClass:"markdown"},[t("mavon-editor",{ref:"md",attrs:{value:e.documentData,subfield:!1,defaultOpen:"preview",toolbarsFlag:!1,editable:!1,scrollStyle:!0,ishljs:!0}})],1):e._e(),t("div",{directives:[{name:"loading",rawName:"v-loading.fullscreen.lock",value:e.isFirstLoading&&e.isLoading,expression:"isFirstLoading && isLoading",modifiers:{fullscreen:!0,lock:!0}}]}),t("div",{directives:[{name:"loading",rawName:"v-loading",value:!e.isFirstLoading&&e.isLoading,expression:"!isFirstLoading && isLoading"}],staticStyle:{margin:"60px"}})])},s=[],a=(t("639b"),t("e6d8"),t("6657")),o=(t("cc71"),t("7f43")),d=t.n(o),c={name:"DocumentOnlinePreview",components:{mavonEditor:a["mavonEditor"]},data:function(){return{isScrolling:!1,type:"",isSuccess:!0,isLoading:!0,isFinish:!1,documentId:0,documentType:0,documentUrl:"",pageNum:1,pageSize:4,documentData:[]}},created:function(){this.pageNum=1,this.documentId=this.$route.query.documentId,this.documentType=this.$route.query.documentType,this.documentUrl=this.$route.query.documentUrl,this.isFinish=!1,this.loadDocumentData()},mounted:function(){window.addEventListener("scroll",this.handleScroll,!1),window.addEventListener("mousewheel",this.handleScroll,!1),window.addEventListener("DOMMouseScroll",this.handleScroll,!1)},methods:{loadDocumentData:function(){var e=this;this.isLoading=!0;var i=this.documentId,t=this.documentType,n=this.documentUrl,s=this.pageNum,a=this.pageSize;d.a.post("/IGSDN/documentOnlinePreview",{documentId:i,documentType:t,documentUrl:n,pageNum:s,pageSize:a}).then(function(i){e.handleData(i.data),1===e.pageNum&&e.$message({message:"载入成功",type:"success"}),e.pageNum+=1,e.isSuccess=!0,e.isLoading=!1,e.isScrolling=!1}).catch(function(i){e.isLoading=!1,e.isSuccess=!1,e.isScrolling=!1,e.$message.error("抱歉，加载失败了")})},handleScroll:function(e){if(!this.isScrolling&&!this.isLoading&&!this.isFinish){var i=document.documentElement.scrollTop,t=document.documentElement.clientHeight,n=document.documentElement.scrollHeight;0==i&&t==n&&e.deltaY>0&&(this.isScrolling=!0,this.loadDocumentData()),0!=i&&i+t+1>n&&(this.isScrolling=!0,this.loadDocumentData())}},handleData:function(e){var i=this;this.isMarkdown(e)?(this.documentData=e[1],this.isFinish=!0):this.isImages(e)&&(e.shift(),e?e.forEach(function(e){i.documentData.push("data:image/jpg;base64,"+e)}):this.isFinish=!0)},isMarkdown:function(e){return e!=[]&&"markdown"==e[0]&&(this.type="markdown",!0)},isImages:function(e){return e!=[]&&"images"==e[0]&&(this.type="images",!0)}},computed:{isFirstLoading:function(){return 1===this.pageNum}}},r=c,u=t("17cc"),l=Object(u["a"])(r,n,s,!1,null,"3174956a",null);i["default"]=l.exports}}]);