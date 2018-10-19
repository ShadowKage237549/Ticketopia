(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/Components/forum/forum.component.css":
/*!******************************************************!*\
  !*** ./src/app/Components/forum/forum.component.css ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/Components/forum/forum.component.html":
/*!*******************************************************!*\
  !*** ./src/app/Components/forum/forum.component.html ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row mx-3 my-5\">\n  <h1>Ticketopia Forum</h1>\n</div>\n<div class=\"row mx-3\">\n  <div class=\"col-12 mx-3\">\n    <h3>Categories</h3>\n    <p class=\"mx-3\">Discuss upcoming events</p>\n    <hr>\n  </div>\n  <div class=\"col-12 mx-3\" *ngFor=\"let topic of topicCategories\">\n    <a class=\"row mx-3 forum rounded shadow-sm\" routerLinkActive=\"active\" routerLink=\"{{topic.topicId}}\">\n      <p class=\"col-4\">{{topic.topicName}}</p>\n      <p class=\"col-8\">{{topic.topicDescription}}</p>\n    </a>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/Components/forum/forum.component.ts":
/*!*****************************************************!*\
  !*** ./src/app/Components/forum/forum.component.ts ***!
  \*****************************************************/
/*! exports provided: ForumComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumComponent", function() { return ForumComponent; });
/* harmony import */ var _forumtopic_topic_topic__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./../forumtopic/topic/topic */ "./src/app/Components/forumtopic/topic/topic.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ForumComponent = /** @class */ (function () {
    function ForumComponent(hClient) {
        this.hClient = hClient;
        //Each topic is an anchor which leads to the forumtopic.component
        this.topicCategories = [
            new _forumtopic_topic_topic__WEBPACK_IMPORTED_MODULE_0__["Topic"](1, "topic 1", "topic 1 description of the topic"),
            new _forumtopic_topic_topic__WEBPACK_IMPORTED_MODULE_0__["Topic"](2, "topic 2", "topic 2 description of the topic")
        ];
    }
    ForumComponent.prototype.ngOnInit = function () {
    };
    ForumComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-forum',
            template: __webpack_require__(/*! ./forum.component.html */ "./src/app/Components/forum/forum.component.html"),
            styles: [__webpack_require__(/*! ./forum.component.css */ "./src/app/Components/forum/forum.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], ForumComponent);
    return ForumComponent;
}());



/***/ }),

/***/ "./src/app/Components/forumpost/comment/ForumComment.ts":
/*!**************************************************************!*\
  !*** ./src/app/Components/forumpost/comment/ForumComment.ts ***!
  \**************************************************************/
/*! exports provided: ForumComment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumComment", function() { return ForumComment; });
var ForumComment = /** @class */ (function () {
    function ForumComment(commentId, commentContent) {
        this.commentContent = commentContent;
        this.commentId = commentId;
    }
    return ForumComment;
}());



/***/ }),

/***/ "./src/app/Components/forumpost/forumpost.component.css":
/*!**************************************************************!*\
  !*** ./src/app/Components/forumpost/forumpost.component.css ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".comment {\n    border: solid 1px;\n    border-color:silver;\n    padding: 15px;\n    margin: 15px 0;\n    box-shadow: 0px 0px 2px gray;\n}"

/***/ }),

/***/ "./src/app/Components/forumpost/forumpost.component.html":
/*!***************************************************************!*\
  !*** ./src/app/Components/forumpost/forumpost.component.html ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row mx-3 my-5\">\n  <h1>Ticketopia Forum</h1>\n</div>\n<div class=\"row mx-3\">\n  <div class=\"col-12 mx-3\">\n    <h3>{{postTitle}}</h3>\n    <hr>\n    <div class=\"row\">\n        <h3>{{postTitle}}</h3>\n    </div>\n  </div>\n  <div class=\"col-12 mx-3\" *ngFor=\"let c of forumComments\">\n    <p class=\"comment rounded shadow-sm\">\n      {{c.commentContent}}\n    </p>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/Components/forumpost/forumpost.component.ts":
/*!*************************************************************!*\
  !*** ./src/app/Components/forumpost/forumpost.component.ts ***!
  \*************************************************************/
/*! exports provided: ForumpostComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumpostComponent", function() { return ForumpostComponent; });
/* harmony import */ var _post_ForumPost__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./post/ForumPost */ "./src/app/Components/forumpost/post/ForumPost.ts");
/* harmony import */ var _comment_ForumComment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./comment/ForumComment */ "./src/app/Components/forumpost/comment/ForumComment.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ForumpostComponent = /** @class */ (function () {
    function ForumpostComponent() {
        this.selectedPost = new _post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](1, "Post Title 1", "Post Content");
        this.forumComments = [new _comment_ForumComment__WEBPACK_IMPORTED_MODULE_1__["ForumComment"](2, "commentContent")];
        this.postId = this.selectedPost.postId;
        this.postContent = this.selectedPost.postContent;
        this.postTitle = this.selectedPost.postTitle;
    }
    ForumpostComponent.prototype.ngOnInit = function () {
    };
    ForumpostComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Component"])({
            selector: 'app-forumpost',
            template: __webpack_require__(/*! ./forumpost.component.html */ "./src/app/Components/forumpost/forumpost.component.html"),
            styles: [__webpack_require__(/*! ./forumpost.component.css */ "./src/app/Components/forumpost/forumpost.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ForumpostComponent);
    return ForumpostComponent;
}());



/***/ }),

/***/ "./src/app/Components/forumpost/post/ForumPost.ts":
/*!********************************************************!*\
  !*** ./src/app/Components/forumpost/post/ForumPost.ts ***!
  \********************************************************/
/*! exports provided: ForumPost */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumPost", function() { return ForumPost; });
var ForumPost = /** @class */ (function () {
    function ForumPost(postId, postTitle, postContent) {
        this.postId = postId;
        this.postContent = postContent;
        this.postTitle = postTitle;
    }
    return ForumPost;
}());



/***/ }),

/***/ "./src/app/Components/forumtopic/forumtopic.component.css":
/*!****************************************************************!*\
  !*** ./src/app/Components/forumtopic/forumtopic.component.css ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/Components/forumtopic/forumtopic.component.html":
/*!*****************************************************************!*\
  !*** ./src/app/Components/forumtopic/forumtopic.component.html ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row mx-3 my-5\">\n  <h1>Ticketopia Forum</h1>\n</div>\n<div class=\"row mx-3\">\n  <div class=\"col-12 mx-3\">\n    <h3>{{topicCategory}}</h3>\n    <hr>\n  </div>\n  <div class=\"col-12 mx-3\" *ngFor=\"let post of posts\">\n    <a class=\"row mx-3 forum rounded\" routerLinkActive=\"active\" routerLink=\"{{post.postId}}\">\n      <p class=\"col-4\">{{post.postTitle}}</p>\n      <p class=\"col-8\">{{post.postContent}}</p>\n    </a>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/Components/forumtopic/forumtopic.component.ts":
/*!***************************************************************!*\
  !*** ./src/app/Components/forumtopic/forumtopic.component.ts ***!
  \***************************************************************/
/*! exports provided: ForumtopicComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ForumtopicComponent", function() { return ForumtopicComponent; });
/* harmony import */ var _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./../forumpost/post/ForumPost */ "./src/app/Components/forumpost/post/ForumPost.ts");
/* harmony import */ var _topic_topic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./topic/topic */ "./src/app/Components/forumtopic/topic/topic.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ForumtopicComponent = /** @class */ (function () {
    function ForumtopicComponent() {
        this.selectedTopic = new _topic_topic__WEBPACK_IMPORTED_MODULE_1__["Topic"](1, "topic 1", "topic 1 description of the topic");
        this.topicCategory = this.selectedTopic.topicName;
        this.topicId = this.selectedTopic.topicId;
        this.postTitle = "Post title";
        this.posts = [
            new _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](1, "Post Title x", "Post Description of Post Title x"),
            new _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](2, "Post Title x", "Post Description of Post Title x"),
            new _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](3, "Post Title x", "Post Description of Post Title x"),
            new _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](4, "Post Title x", "Post Description of Post Title x"),
            new _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](5, "Post Title x", "Post Description of Post Title x"),
            new _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](6, "Post Title x", "Post Description of Post Title x"),
            new _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](7, "Post Title x", "Post Description of Post Title x"),
            new _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](8, "Post Title x", "Post Description of Post Title x"),
            new _forumpost_post_ForumPost__WEBPACK_IMPORTED_MODULE_0__["ForumPost"](9, "Post Title x", "Post Description of Post Title x")
        ];
        this.postDescription = "the first 100 characters of the post content";
    }
    ForumtopicComponent.prototype.ngOnInit = function () {
    };
    ForumtopicComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Component"])({
            selector: 'app-forumtopic',
            template: __webpack_require__(/*! ./forumtopic.component.html */ "./src/app/Components/forumtopic/forumtopic.component.html"),
            styles: [__webpack_require__(/*! ./forumtopic.component.css */ "./src/app/Components/forumtopic/forumtopic.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], ForumtopicComponent);
    return ForumtopicComponent;
}());



/***/ }),

/***/ "./src/app/Components/forumtopic/topic/topic.ts":
/*!******************************************************!*\
  !*** ./src/app/Components/forumtopic/topic/topic.ts ***!
  \******************************************************/
/*! exports provided: Topic */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Topic", function() { return Topic; });
var Topic = /** @class */ (function () {
    function Topic(topicId, topicName, topicDescription) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
    }
    return Topic;
}());



/***/ }),

/***/ "./src/app/Components/home/home.component.css":
/*!****************************************************!*\
  !*** ./src/app/Components/home/home.component.css ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/Components/home/home.component.html":
/*!*****************************************************!*\
  !*** ./src/app/Components/home/home.component.html ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row mx-3 my-5\">\n  <h1>Ticketopia! </h1>\n</div>\n<div class=\"row mx-3\">\n  <div class=\"col\">\n    <h3>Partners</h3><br>\n  </div>\n</div>\n<div class=\"row mx-3\">\n\n  <div class=\"col\">\n    <div class=\"card text-center my-3\">\n      <div class=\"card-header \">Company Name</div>\n      <div class=\"card-body\">\n        <p class=\"card-text\">Find out the next best place you'll attend</p>\n        <a routerLink=\"store\" class=\"btn btn-info\">Tickets available here!</a>\n      </div>\n    </div>\n    <div class=\"card text-center my-3\">\n        <div class=\"card-header \">Company Name</div>\n        <div class=\"card-body\">\n          <p class=\"card-text\">Find out the next best place you'll attend</p>\n          <a routerLink=\"store\" class=\"btn btn-info\">Tickets available here!</a>\n        </div>\n      </div>\n  </div>\n  <div class=\"col\">\n    <div class=\"card text-center my-3\">\n      <div class=\"card-header \">Company Name</div>\n      <div class=\"card-body\">\n        <p class=\"card-text\">Find out the next best place you'll attend</p>\n        <a routerLink=\"store\" class=\"btn btn-info\">Tickets available here!</a>\n      </div>\n    </div>\n    <div class=\"card text-center my-3\">\n        <div class=\"card-header \">Company Name</div>\n        <div class=\"card-body\">\n          <p class=\"card-text\">Find out the next best place you'll attend</p>\n          <a   class=\"btn btn-info\" routerLinkActive=\"active\" routerLink=\"store\">Tickets available here!</a>\n        </div>\n      </div>\n  </div>\n\n</div>"

/***/ }),

/***/ "./src/app/Components/home/home.component.ts":
/*!***************************************************!*\
  !*** ./src/app/Components/home/home.component.ts ***!
  \***************************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var HomeComponent = /** @class */ (function () {
    function HomeComponent(hClient) {
        this.hClient = hClient;
    }
    HomeComponent.prototype.ngOnInit = function () {
    };
    HomeComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-home',
            template: __webpack_require__(/*! ./home.component.html */ "./src/app/Components/home/home.component.html"),
            styles: [__webpack_require__(/*! ./home.component.css */ "./src/app/Components/home/home.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpClient"]])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "./src/app/Components/login/login.component.css":
/*!******************************************************!*\
  !*** ./src/app/Components/login/login.component.css ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/Components/login/login.component.html":
/*!*******************************************************!*\
  !*** ./src/app/Components/login/login.component.html ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\r\n  login works!\r\n</p>\r\n"

/***/ }),

/***/ "./src/app/Components/login/login.component.ts":
/*!*****************************************************!*\
  !*** ./src/app/Components/login/login.component.ts ***!
  \*****************************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var LoginComponent = /** @class */ (function () {
    function LoginComponent() {
    }
    LoginComponent.prototype.ngOnInit = function () {
    };
    LoginComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/Components/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/Components/login/login.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], LoginComponent);
    return LoginComponent;
}());



/***/ }),

/***/ "./src/app/Components/navbar/navbar.component.css":
/*!********************************************************!*\
  !*** ./src/app/Components/navbar/navbar.component.css ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "nav ul li a {\r\n\r\n    border: solid 2px;\r\n    padding: 5px 30px;\r\n    margin: 0 5px;\r\n}"

/***/ }),

/***/ "./src/app/Components/navbar/navbar.component.html":
/*!*********************************************************!*\
  !*** ./src/app/Components/navbar/navbar.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n  <a class=\"navbar-brand\" routerLinkActive=\"active\" routerLink=\"home\">Ticketopia</a>\r\n        <ul class=\"navbar-nav mr-auto\">\r\n          <li class=\"nav-item\">\r\n            <a class=\"nav-link\" routerLinkActive=\"active\" routerLink=\"home\">Home</a>\r\n          </li>\r\n          <li class=\"nav-item\">\r\n            <a class=\"nav-link\" routerLinkActive=\"active\" routerLink=\"forum\">Forum</a>\r\n          </li>\r\n          <li class=\"nav-item\">\r\n              <a class=\"nav-link\" routerLinkActive=\"active\" routerLink=\"store\">Store</a>\r\n            </li>\r\n          <li class=\"nav-item\">\r\n            <a class=\"nav-link\" routerLinkActive=\"active\" routerLink=\"login\">Login</a>\r\n          </li>\r\n        </ul>\r\n</nav>"

/***/ }),

/***/ "./src/app/Components/navbar/navbar.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/Components/navbar/navbar.component.ts ***!
  \*******************************************************/
/*! exports provided: NavbarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavbarComponent", function() { return NavbarComponent; });
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var NavbarComponent = /** @class */ (function () {
    function NavbarComponent(hClient) {
        this.hClient = hClient;
    }
    NavbarComponent.prototype.ngOnInit = function () {
    };
    NavbarComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-navbar',
            template: __webpack_require__(/*! ./navbar.component.html */ "./src/app/Components/navbar/navbar.component.html"),
            styles: [__webpack_require__(/*! ./navbar.component.css */ "./src/app/Components/navbar/navbar.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpClient"]])
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "./src/app/Components/store/store.component.css":
/*!******************************************************!*\
  !*** ./src/app/Components/store/store.component.css ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/Components/store/store.component.html":
/*!*******************************************************!*\
  !*** ./src/app/Components/store/store.component.html ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\r\n  store works!\r\n</p>\r\n"

/***/ }),

/***/ "./src/app/Components/store/store.component.ts":
/*!*****************************************************!*\
  !*** ./src/app/Components/store/store.component.ts ***!
  \*****************************************************/
/*! exports provided: StoreComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StoreComponent", function() { return StoreComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var StoreComponent = /** @class */ (function () {
    function StoreComponent(hClient) {
        this.hClient = hClient;
    }
    StoreComponent.prototype.ngOnInit = function () {
    };
    StoreComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-store',
            template: __webpack_require__(/*! ./store.component.html */ "./src/app/Components/store/store.component.html"),
            styles: [__webpack_require__(/*! ./store.component.css */ "./src/app/Components/store/store.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], StoreComponent);
    return StoreComponent;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-navbar></app-navbar>\n<div class=\"container-fluid\" style=\"padding-top: 50px;\">\n  <div class=\"row\">\n    <div class=\"col-2\">\n      \n    </div>\n    <div class=\"col-8 rounded shadow\" style=\"background: white;\">\n      <router-outlet></router-outlet>\n    </div>\n    <div class=\"col-2\">\n      \n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var AppComponent = /** @class */ (function () {
    function AppComponent(elementRef) {
        this.elementRef = elementRef;
        this.title = 'Ticketopia';
    }
    AppComponent.prototype.ngAfterViewInit = function () {
        this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor = "#cdcdcd";
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ElementRef"]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _routes__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./routes */ "./src/app/routes.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _Components_navbar_navbar_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./Components/navbar/navbar.component */ "./src/app/Components/navbar/navbar.component.ts");
/* harmony import */ var _Components_home_home_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./Components/home/home.component */ "./src/app/Components/home/home.component.ts");
/* harmony import */ var _Components_forum_forum_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./Components/forum/forum.component */ "./src/app/Components/forum/forum.component.ts");
/* harmony import */ var _Components_store_store_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./Components/store/store.component */ "./src/app/Components/store/store.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _Components_login_login_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./Components/login/login.component */ "./src/app/Components/login/login.component.ts");
/* harmony import */ var _Components_forumtopic_forumtopic_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./Components/forumtopic/forumtopic.component */ "./src/app/Components/forumtopic/forumtopic.component.ts");
/* harmony import */ var _Components_forumpost_forumpost_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./Components/forumpost/forumpost.component */ "./src/app/Components/forumpost/forumpost.component.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};














var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"],
                _Components_navbar_navbar_component__WEBPACK_IMPORTED_MODULE_5__["NavbarComponent"],
                _Components_home_home_component__WEBPACK_IMPORTED_MODULE_6__["HomeComponent"],
                _Components_forum_forum_component__WEBPACK_IMPORTED_MODULE_7__["ForumComponent"],
                _Components_store_store_component__WEBPACK_IMPORTED_MODULE_8__["StoreComponent"],
                _Components_login_login_component__WEBPACK_IMPORTED_MODULE_10__["LoginComponent"],
                _Components_forumtopic_forumtopic_component__WEBPACK_IMPORTED_MODULE_11__["ForumtopicComponent"],
                _Components_forumpost_forumpost_component__WEBPACK_IMPORTED_MODULE_12__["ForumpostComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClientModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_3__["RouterModule"].forRoot(_routes__WEBPACK_IMPORTED_MODULE_2__["appRoutes"], { useHash: true })
            ],
            providers: [
                { provide: _angular_common__WEBPACK_IMPORTED_MODULE_13__["LocationStrategy"], useClass: _angular_common__WEBPACK_IMPORTED_MODULE_13__["HashLocationStrategy"] },
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_4__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/routes.ts":
/*!***************************!*\
  !*** ./src/app/routes.ts ***!
  \***************************/
/*! exports provided: appRoutes */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "appRoutes", function() { return appRoutes; });
/* harmony import */ var _Components_home_home_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Components/home/home.component */ "./src/app/Components/home/home.component.ts");
/* harmony import */ var _Components_forum_forum_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./Components/forum/forum.component */ "./src/app/Components/forum/forum.component.ts");
/* harmony import */ var _Components_forumtopic_forumtopic_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./Components/forumtopic/forumtopic.component */ "./src/app/Components/forumtopic/forumtopic.component.ts");
/* harmony import */ var _Components_store_store_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./Components/store/store.component */ "./src/app/Components/store/store.component.ts");
/* harmony import */ var _Components_login_login_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./Components/login/login.component */ "./src/app/Components/login/login.component.ts");
/* harmony import */ var _Components_forumpost_forumpost_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./Components/forumpost/forumpost.component */ "./src/app/Components/forumpost/forumpost.component.ts");






var appRoutes = [
    {
        path: 'login',
        component: _Components_login_login_component__WEBPACK_IMPORTED_MODULE_4__["LoginComponent"]
    },
    {
        path: 'store',
        component: _Components_store_store_component__WEBPACK_IMPORTED_MODULE_3__["StoreComponent"]
    },
    {
        path: 'home/store',
        component: _Components_store_store_component__WEBPACK_IMPORTED_MODULE_3__["StoreComponent"]
    },
    {
        path: 'forum',
        component: _Components_forum_forum_component__WEBPACK_IMPORTED_MODULE_1__["ForumComponent"]
    },
    {
        path: 'forum/:topic',
        component: _Components_forumtopic_forumtopic_component__WEBPACK_IMPORTED_MODULE_2__["ForumtopicComponent"]
    },
    {
        path: 'forum/:topic/:post',
        component: _Components_forumpost_forumpost_component__WEBPACK_IMPORTED_MODULE_5__["ForumpostComponent"]
    },
    {
        path: '',
        component: _Components_home_home_component__WEBPACK_IMPORTED_MODULE_0__["HomeComponent"]
    },
    {
        path: 'home',
        component: _Components_home_home_component__WEBPACK_IMPORTED_MODULE_0__["HomeComponent"]
    },
    {
        path: '**',
        redirectTo: 'home',
        pathMatch: 'full'
    }
];


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");



Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! D:\GitHub\Project2\Angular\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map