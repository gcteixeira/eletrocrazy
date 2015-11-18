angular.module('eletrocrazy').factory('UsusarioResource', function($resource){
    var resource = $resource('rest/ususarios/:UsusarioId',{UsusarioId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});