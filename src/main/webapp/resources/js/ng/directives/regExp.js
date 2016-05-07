/**
 * Created by pr on 03/19/2016.
 */
app.directive('regExpCheck',[function(){
    return{
        restrict:'A',
        require:'ngModel',
        link:function(scope,elem,attr,ctrl){
            var exp = attr['regExpCheck'];
            var timeoutID;
            var check= new RegExp(exp);
            function validate(){
                if (timeoutID) clearTimeout(timeoutID);
                timeoutID = setTimeout(function(){
                    if(check.test(ctrl.$modelValue)){
                        ctrl.$setValidity('regexp', true);
                        scope.$apply();
                    }else{
                        ctrl.$setValidity('regexp', false);
                        scope.$apply();
                    }
                },300);

            }
            scope.$watch(attr.ngModel, function (n) {
                if(n){
                    validate();
                }
            })
        }
    }
}]);