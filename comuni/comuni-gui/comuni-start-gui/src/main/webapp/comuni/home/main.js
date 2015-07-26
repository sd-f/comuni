/* global angular */

var startConversationHome = "/comuni-conversations/start-conversations/home/";

var app = angular.module('ComuniHomeApp', ['ngMaterial', 'ngResource'])
    .config(function ($mdThemingProvider) {
      $mdThemingProvider.theme('default')
          .primaryPalette('indigo', {
          })
          // If you specify less than all of the keys, it will inherit from the
          // default shades
          .accentPalette('grey', {
          });
    });
;

app.controller('ComuniHomeAppCtrl', ['$scope', '$resource', '$mdSidenav', function ($scope, $resource, $mdSidenav) {
    $scope.toggleSidenav = function (menuId) {
      $mdSidenav(menuId).toggle();
    };
    $scope.conversationWelcome = {};
    $scope.answerToHello = {};
    $scope.conversationName = {};
    $scope.questionWhatIsYourName = {};
    $scope.answerToWhatIsYourName = {};

    $scope.messages = [];

    $scope.messages.push({
      what: "/hello Server",
      who: "GUI",
      image: "accessibility",
      notes: "Say to server"
    });

    var Answer = $resource(startConversationHome + 'hello');
    Answer.get({}).$promise.then(function (answer) {
      $scope.conversationWelcome = answer;
      $scope.answerToHello = $scope.conversationWelcome.answer.sentences.hello;

      $scope.messages.push({
        what: $scope.answerToHello,
        who: "Server",
        image: "computer",
        notes: "Server answered: " + JSON.stringify(answer)
      });



      $scope.questionWhatIsYourName = $scope.conversationWelcome.answer['you-can'].ask.question;

      $scope.messages.push({
        what: $scope.questionWhatIsYourName,
        who: "GUI",
        image: "accessibility",
        notes: "Asking server"
      });

      var Name = $resource(startConversationHome + $scope.questionWhatIsYourName);
      Name.get({}).$promise.then(function (answer) {
        $scope.conversationName = answer;
        $scope.answerToWhatIsYourName = $scope.conversationName.answer.sentences['my-name-is'];

        $scope.messages.push({
          what: "my-name-is " + $scope.questionWhatIsYourName,
          who: "Server",
          image: "computer",
          notes: "Server answered: " + JSON.stringify(answer)
        });

      });
    });
  }]);