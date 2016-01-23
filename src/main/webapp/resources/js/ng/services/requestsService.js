/**
 * Created by pr on 01/10/2016.
 */
app.service('requestsService',['serverConnector',function(serverConnector){
    this.becomeChef = function(data){
        return serverConnector.send(
            {
                method:'post',
                url:'create-chef',
                data: data
            }
        )
    };
    this.loadDishes = function(data){
        return serverConnector.send(
            {
                method : "get",
                url : "get-dishes",
                data : data
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
    }
}]);