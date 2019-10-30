
function getMenuTree() {
    var root = {
        id:0,
        name:"root",
        open:true
    }
    $.ajax({
        type:'get',
        url:'/permission/listAllPermission',
        contentType:"application/json;charts=utf-8",
        async:false,
        success:function (ret) {
            var data = ret.data;
            var length = data.length;
            var children = [];
            for(var i = 0 ;i<length;i++){
                var d = data[i];
                console.log(d);
                var node = createNode(d);
                children[i] = node;
            }
            root.children = children;
        }
    });
    return root;
}
function createNode(d) {
    return undefined;
}


function getSetting(isRadioType) {
    var setting ={
        check :{
            enable :true,
            chkboxType:{
                "Y" : "ps",
                "N" : "ps"
            }
        },
        asyc :{
          enable :true
        },
        data :{
            simpleData : {
                enable : true,
                idKey : "id",
                pIdKey : "pId",
                rootPId :0
            }
        },
        callback : {
            onCheck : zTreeOnCheck
        }
    };

    if(isRadioType){
        setting.check = {
            enable : true,
            chkStyle :"radio",
            radioType:"all"
        }
    }
    return setting;
}
function  zTreeOnCheck(event,treeId,treeNode) {
    
}