(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-477f3086"],{"013f":function(e,n,t){},"2f96":function(e,n,t){"use strict";t.r(n);var c=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",{ref:"list",staticClass:"filter-list-recommend"},[t("el-container",[t("el-main",[t("KnowledgeScroller",{staticClass:"block",attrs:{isScrolling:e.isScrolling,userId:e.userId,changeFlag:e.changeFlag},on:{loadingFlag:e.receiveChildMsg}})],1)],1)],1)},l=[],a=t("6646"),i={name:"Recommendation",props:["isScrolling"],components:{KnowledgeScroller:a["a"]},data:function(){return{userId:0,changeFlag:!0}},mounted:function(){this.userId=localStorage.getItem("user_msg")?localStorage.getItem("user_msg").id:2,this.changeFlag=!this.changeFlag},computed:{$route:function(){this.changeFlag=!this.changeFlag}},methods:{receiveChildMsg:function(e){this.$emit("loadingFlag",e)}}},s=i,o=(t("f049"),t("17cc")),r=Object(o["a"])(s,c,l,!1,null,"78ecdc76",null);n["default"]=r.exports},f049:function(e,n,t){"use strict";var c=t("013f"),l=t.n(c);l.a}}]);