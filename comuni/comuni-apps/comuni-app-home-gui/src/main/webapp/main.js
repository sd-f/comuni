/* global angular */

var app = angular.module('ComuniHomeApp', ['ngMaterial', 'ngResource']);

app.controller('ComuniHomeAppCtrl', ['$scope', '$resource', '$mdSidenav', function ($scope, $resource, $mdSidenav) {
    $scope.toggleSidenav = function (menuId) {
      $mdSidenav(menuId).toggle();
    };
    $scope.conversationWelcome = {};
    $scope.answerToHello = {};

    $scope.conversationName = {};
    $scope.questionWhatIsYourName = {};
    $scope.answerToWhatIsYourName = {};

    var Answer = $resource('http://localhost:8021/comuni-app-home-1.0-SNAPSHOT/hello');
    Answer.get({}).$promise.then(function (answer) {
      $scope.conversationWelcome = answer;
      $scope.answerToHello = $scope.conversationWelcome['answer']['sentences']['hello'];
      $scope.questionWhatIsYourName = $scope.conversationWelcome['answer']['you-can']['ask']['question'];
      var Name = $resource('http://localhost:8021/comuni-app-home-1.0-SNAPSHOT' + $scope.questionWhatIsYourName);
      Name.get({}).$promise.then(function (answer) {
        $scope.conversationName = answer;
        $scope.answerToWhatIsYourName = $scope.conversationName['answer']['sentences']['my-name-is'];
      });
    });

  }]);