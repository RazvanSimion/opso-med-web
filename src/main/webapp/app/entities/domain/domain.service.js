(function() {
    'use strict';
    angular
        .module('opsomedApp')
        .factory('Domain', Domain);

    Domain.$inject = ['$resource'];

    function Domain ($resource) {
        var resourceUrl =  'api/domains/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
