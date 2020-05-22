/**  
 * js常用方法封装
 * 作者：王丙祎
 */
function By() { };

By.consolelog = console.log;

/**
 *对Date的扩展，将 Date 转化为指定格式的String
 *月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 *年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 *例子：
 *(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 *(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
 */
Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1,
                (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    return fmt;
};
By.prototype.formatDate = function (d, fmt) {
    return d.format(fmt);
};
By.prototype.getStyle = function (obj, name) {
    if (window.getComputedStyle) {
        return getComputedStyle(obj, null)[name];
    } else {
        return obj.currentStyle[name];
    }
};

// console.log + 忽略exception
By.prototype.log = function (msg) {
    try {
        console.log(msg);
    } catch (exception) {
        return;
    }
};

// 关闭console.log的功能
By.prototype.closeConsoleLog = function() {
    console.log = null;
}

// 开启console.log的功能
By.prototype.openConsoleLog = function() {
    console.log = By.consolelog;
}


/** 
 * 操作内容文本的兼容的方法
 * 兼容的 innerText，textContent
 */
By.prototype.inText = function (obj, text) {
    // IE或非IE高版本
    if (document.all) {
        if (typeof (text) == 'undefined') {
            return obj.innerText;
        } else {
            obj.innerText = text;
        }
    } else {
        if (typeof (text) == 'undefined') {
            return obj.textContent;
        } else {
            obj.textContent = text;
        }
    }
}

// 给元素添加类属性，如果已有则不再设置，若没有，则添加
By.prototype.addClass = function (element, value) {
    if (!element.className) {
        element.className = value;
    } else {
        if (element.className.indexOf(value) == -1) {
            element.className += ' ' + value;
        }
    }
}

// 移除元素的class属性值中的类名
By.prototype.removeClass = function (element, value) {
    if(typeof(value)=='undefined' || element.className == value) {
        element.className = '';
    } else {
        if(element.className.indexOf(value) != -1) {
            element.className.replace(value, '');
        }
    }
}

// 兼容版，通过类名获取标签元素
By.prototype.getElementByClassName = function(classNames) {
    var allTags = document.getElementsByTagName("*");
    
    var arr = new Array();
    for(let i=0; i<allTags.length; i++) {
        if(allTags[i].className) {
            arr[arr.length] = allTags[i];
        }
    }
    return arr;
}




const by = new By();
