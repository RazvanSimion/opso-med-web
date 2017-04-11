(function() {
    'use strict';

    angular
        .module('opsomedApp')
        .controller('DomainDetailController', DomainDetailController);

    DomainDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Domain'];

    function DomainDetailController($scope, $rootScope, $stateParams, previousState, entity, Domain) {
        var vm = this;

        vm.domain = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('opsomedApp:domainUpdate', function(event, result) {
            vm.domain = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
