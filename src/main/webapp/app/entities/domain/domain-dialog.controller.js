(function() {
    'use strict';

    angular
        .module('opsomedApp')
        .controller('DomainDialogController', DomainDialogController);

    DomainDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Domain'];

    function DomainDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Domain) {
        var vm = this;

        vm.domain = entity;
        vm.clear = clear;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.domain.id !== null) {
                Domain.update(vm.domain, onSaveSuccess, onSaveError);
            } else {
                Domain.save(vm.domain, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('opsomedApp:domainUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
