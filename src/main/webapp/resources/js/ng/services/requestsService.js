/**
 * Created by pr on 01/10/2016.
 */
app.service('requestsService',['serverConnector',function(serverConnector){
    this.makeOrder = function(data){
        return serverConnector.send(
            {
                method:"post",
                url:"make-order",
                data:data
            }
        )
    };
    this.becomeChef = function(data){
        return serverConnector.send(
            {
                method:'post',
                url:'create-chef',
                data: data
            }
        )
    };
    this.becomeCourier = function(data){
        return serverConnector.send(
            {
                method:'post',
                url:'create-courier',
                data: data
            }
        )
    };
    this.getChefs = function(data){
        return serverConnector.send(
            {
                method : "get",
                url : "get-chefs",
                params : data
            }

        )
    };
    this.loadDishes = function(data){
        return serverConnector.send(
            {
                method : "get",
                url : "get-dishes",
                params : data
            }
        )
    };
    this.addCategories=function(data){
        return serverConnector.send(
            {
                method:"post",
                url:"add-categories",
                data:data
            }
        )
    };
    this.getDish = function(data){
        return serverConnector.send(
            {
                method:"get",
                url:"get-dish",
                params :data
            }
        )
    }


    this.sendMail = function(data){
        return serverConnector.send(
            {
                method:'post',
                url:"send-email",
                data:data
            }
        )
    }

}]);