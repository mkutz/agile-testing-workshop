(function() {
    var app = angular.module('customer-service-ui', ['ngResource']);

    app.directive('customers', ['$resource', function($resource) {
        return {
            restrict: 'E',
            replace: true,
            controller: function($scope) {
                console.info("enter customers directive controller");
                var Customer = $resource('/api/customer/:customerId', {'customerId': 'customerId'});
                $scope.customers = Customer.query();
            }
        }
    }]);

})();
