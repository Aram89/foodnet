/**
 * Created by pr on 01/10/2016.
 */
app.service('requestsService',['serverConnector',function(serverConnector){
    this.becomeChef = function(data){
        return serverConnector.send(
            {
                method:'get',
                url:'create-chef',
                data: data
            }
        )
    }
}]);