'use strict';

angular.module('eletrocrazy',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Carrinhos',{templateUrl:'views/Carrinho/search.html',controller:'SearchCarrinhoController'})
      .when('/Carrinhos/new',{templateUrl:'views/Carrinho/detail.html',controller:'NewCarrinhoController'})
      .when('/Carrinhos/edit/:CarrinhoId',{templateUrl:'views/Carrinho/detail.html',controller:'EditCarrinhoController'})
      .when('/Categoria',{templateUrl:'views/Categoria/search.html',controller:'SearchCategoriaController'})
      .when('/Categoria/new',{templateUrl:'views/Categoria/detail.html',controller:'NewCategoriaController'})
      .when('/Categoria/edit/:CategoriaId',{templateUrl:'views/Categoria/detail.html',controller:'EditCategoriaController'})
      .when('/Pessoas',{templateUrl:'views/Pessoa/search.html',controller:'SearchPessoaController'})
      .when('/Pessoas/new',{templateUrl:'views/Pessoa/detail.html',controller:'NewPessoaController'})
      .when('/Pessoas/edit/:PessoaId',{templateUrl:'views/Pessoa/detail.html',controller:'EditPessoaController'})
      .when('/Produtos',{templateUrl:'views/Produto/search.html',controller:'SearchProdutoController'})
      .when('/Produtos/new',{templateUrl:'views/Produto/detail.html',controller:'NewProdutoController'})
      .when('/Produtos/edit/:ProdutoId',{templateUrl:'views/Produto/detail.html',controller:'EditProdutoController'})
      .when('/Ususarios',{templateUrl:'views/Ususario/search.html',controller:'SearchUsusarioController'})
      .when('/Ususarios/new',{templateUrl:'views/Ususario/detail.html',controller:'NewUsusarioController'})
      .when('/Ususarios/edit/:UsusarioId',{templateUrl:'views/Ususario/detail.html',controller:'EditUsusarioController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
