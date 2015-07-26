/* global angular */

var startConversationHome = "/comuni-conversations/start-conversation/home/";

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

    var Answer = $resource(startConversationHome + 'hello');
    Answer.get({}).$promise.then(function (answer) {
      $scope.conversationWelcome = answer;
      $scope.answerToHello = $scope.conversationWelcome['answer']['sentences']['hello'];
      $scope.questionWhatIsYourName = $scope.conversationWelcome['answer']['you-can']['ask']['question'];
      var Name = $resource(startConversationHome + $scope.questionWhatIsYourName);
      Name.get({}).$promise.then(function (answer) {
        $scope.conversationName = answer;
        $scope.answerToWhatIsYourName = $scope.conversationName['answer']['sentences']['my-name-is'];
      });
    });

  }]);