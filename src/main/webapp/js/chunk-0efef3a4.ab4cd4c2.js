(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0efef3a4"],{"2c08":function(e,t,n){},"6a86":function(e,t,n){"use strict";var l=n("2c08"),s=n.n(l);s.a},ace2:function(e,t,n){"use strict";var l=n("dd3d"),s=n.n(l);s.a},bfe9:function(e,t,n){"use strict";n.r(t);var l=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"wrapper"},[n("v-head"),n("v-sidebar"),n("div",{staticClass:"content-box",class:{"content-collapse":e.collapse}},[n("v-tags"),n("div",{staticClass:"content"},[n("transition",{attrs:{name:"move",mode:"out-in"}},[n("keep-alive",{attrs:{include:e.tagsList}},[n("router-view")],1)],1)],1)],1)],1)},s=[],i=(n("3a23"),function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"header"},[n("div",{staticClass:"collapse-btn",on:{click:e.collapseChage}},[n("i",{staticClass:"el-icon-menu"})]),n("div",{staticClass:"logo"},[e._v("IGSDN - 知识管理系统")]),n("div",{staticClass:"header-right"},[n("div",{staticClass:"header-user-con"},[n("div",{staticClass:"btn-fullscreen",on:{click:e.handleFullScreen}},[n("el-tooltip",{attrs:{effect:"dark",content:e.fullscreen?"取消全屏":"全屏",placement:"bottom"}},[n("i",{staticClass:"el-icon-rank"})])],1),n("div",{staticClass:"btn-bell"},[n("el-tooltip",{attrs:{effect:"dark",content:e.message?"有"+e.message+"条未读消息":"消息中心",placement:"bottom"}},[n("router-link",{attrs:{to:"/tabs"}},[n("i",{staticClass:"el-icon-bell"})])],1),e.message?n("span",{staticClass:"btn-bell-badge"}):e._e()],1),n("el-dropdown",{staticClass:"user-name",attrs:{trigger:"click"},on:{command:e.handleCommand}},[n("span",{staticClass:"el-dropdown-link"},[e._v("\n                    "+e._s(e.username)+" "),n("i",{staticClass:"el-icon-caret-bottom"})]),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",{attrs:{divided:"",command:"changePassword"}},[e._v("修改密码")]),n("el-dropdown-item",{attrs:{divided:"",command:"userCenter"}},[e._v("个人中心")]),n("el-dropdown-item",{attrs:{divided:"",command:"loginout"}},[e._v("退出登录")])],1)],1)],1)])])}),a=[],o=n("6e6d"),c=new o["default"],r=c,d={data:function(){return{collapse:!1,fullscreen:!1,name:"linxin",message:2}},computed:{username:function(){var e=localStorage.getItem("ms_username");return e||this.name}},methods:{handleCommand:function(e){"loginout"==e&&(localStorage.removeItem("t_user"),localStorage.removeItem("user_msg"),this.$router.push("/genUserLogin")),"changePassword"==e&&this.$router.push("changePassword"),"userCenter"==e&&this.$router.push("userCenter")},collapseChage:function(){this.collapse=!this.collapse,r.$emit("collapse",this.collapse)},handleFullScreen:function(){var e=document.documentElement;this.fullscreen?document.exitFullscreen?document.exitFullscreen():document.webkitCancelFullScreen?document.webkitCancelFullScreen():document.mozCancelFullScreen?document.mozCancelFullScreen():document.msExitFullscreen&&document.msExitFullscreen():e.requestFullscreen?e.requestFullscreen():e.webkitRequestFullScreen?e.webkitRequestFullScreen():e.mozRequestFullScreen?e.mozRequestFullScreen():e.msRequestFullscreen&&e.msRequestFullscreen(),this.fullscreen=!this.fullscreen}},mounted:function(){document.body.clientWidth<1500&&this.collapseChage()}},u=d,m=(n("6a86"),n("17cc")),p=Object(m["a"])(u,i,a,!1,null,"149d7800",null),v=p.exports,h=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"sidebar"},[n("el-menu",{staticClass:"sidebar-el-menu",attrs:{"default-active":e.onRoutes,collapse:e.collapse,"background-color":"white","text-color":"black","active-text-color":"#00d1b2","unique-opened":"",router:""}},[e._l(e.items,function(t){return[t.subs?[n("el-submenu",{key:t.index,attrs:{index:t.index}},[n("template",{slot:"title"},[n("i",{class:t.icon}),n("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(t.title))])]),e._l(t.subs,function(t){return[t.subs?n("el-submenu",{key:t.index,attrs:{index:t.index}},[n("template",{slot:"title"},[e._v(e._s(t.title))]),e._l(t.subs,function(t,l){return n("el-menu-item",{key:l,attrs:{index:t.index}},[e._v("\n                                "+e._s(t.title)+"\n                            ")])})],2):n("el-menu-item",{key:t.index,attrs:{index:t.index}},[e._v("\n                            "+e._s(t.title)+"\n                        ")])]})],2)]:[n("el-menu-item",{key:t.index,attrs:{index:t.index}},[n("i",{class:t.icon}),n("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(t.title))])])]]})],2)],1)},f=[],g=(n("f91a"),{data:function(){return{collapse:!1,items:[{icon:"el-icon-lx-home",index:"recommendation",title:"首页"},{icon:"el-icon-document",index:"2",title:"知识分类",subs:[{index:"knowledge-base",title:"计算机基础"},{index:"2-2",title:"编程语言",subs:[{index:"knowledge-pl-C",title:"C"},{index:"knowledge-pl-java",title:"java"},{index:"knowledge-pl-C#",title:"C#"},{index:"knowledge-pl-Kotlin",title:"Kotlin"},{index:"knowledge-pl-Python",title:"Python"},{index:"knowledge-pl-JavaScript",title:"JavaScript"}]}]},{icon:"el-icon-reading",index:"3",title:"个人知识",subs:[{index:"knowledge-private-base",title:"计算机基础"},{index:"2-2",title:"编程语言",subs:[{index:"knowledge-private-pl-C",title:"C"},{index:"knowledge-private-pl-java",title:"java"},{index:"knowledge-private-pl-C#",title:"C#"},{index:"knowledge-private-pl-Kotlin",title:"Kotlin"},{index:"knowledge-private-pl-Python",title:"Python"},{index:"knowledge-private-pl-JavaScript",title:"JavaScript"}]}]},{icon:"el-icon-upload2",index:"upload",title:"文件上传"}]}},computed:{onRoutes:function(){return this.$route.path.replace("/","")}},created:function(){var e=this;r.$on("collapse",function(t){e.collapse=t})}}),x=g,b=(n("ace2"),Object(m["a"])(x,h,f,!1,null,"2370d030",null)),w=b.exports,C={data:function(){return{tagsList:[],collapse:!1}},components:{vHead:v,vSidebar:w},created:function(){var e=this;r.$on("collapse",function(t){e.collapse=t}),r.$on("tags",function(t){for(var n=[],l=0,s=t.length;l<s;l++)t[l].name&&n.push(t[l].name);e.tagsList=n})}},k=C,_=Object(m["a"])(k,l,s,!1,null,null,null);t["default"]=_.exports},dd3d:function(e,t,n){}}]);