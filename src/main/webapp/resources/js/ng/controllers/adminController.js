// STATUS
//'pending';
//'accepted';
//'completed';
//'declined';


app.controller('adminController',['$scope',function($scope) {

    $scope.orderList = [];

    $scope.showStatusModal = false;
    $scope.currentOrder = null;
    $scope.currentStatusField = '';
    $scope.currentStatus = null;

    $scope.changeStatus = function(order, statusField) {
        $scope.currentOrder = order;
        $scope.currentStatusField = statusField;
        $scope.currentStatus = order[statusField];
        $('#statusModal').modal('show');
    };

    $scope.changeCurrentStatus = function() {
        $scope.currentOrder[$scope.currentStatusField] = $scope.currentStatus;

        if($scope.currentStatusField == 'orderStatus'
            && ($scope.currentStatus == 'completed' || $scope.currentStatus == 'declined')
        ) {
            $scope.currentOrder.chefStatus = $scope.currentStatus;
            $scope.currentOrder.clientStatus = $scope.currentStatus;
            $scope.currentOrder.courierStatus = $scope.currentStatus;
        }
        $('#statusModal').modal('hide');
        //TODO: ajax request to save and show changes after response
    };

    $scope.getOrderList = function() {
        $scope.orderList = [
            {
                id: 111,

                phoneNumber: '095 56 78 18',
                location: 'Aram khachatryan 20 53',
                chefLocation: 'Սոսեի 2/2',
                orderTime: '2016-04-03 14:20',
                totalPrice: '3 500',
                chefPrice: '2 800',
                chefPhoneNumber: '055 26 30 65',

                chefStatus : 'pending',
                clientStatus : 'accepted',
                courierStatus : 'completed',
                orderStatus : 'declined'
            }
        ];

        //TODO: ajax get order list in backend
    };

    $scope.statusColor = function(order, statusField) {
        switch (order[statusField]) {
            case 'pending':
                return 'warning';
            case 'accepted':
                return 'info';
            case 'completed':
                return 'success';
            case 'declined':
                return 'danger';
        }
    };

}]);

