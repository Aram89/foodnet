/**
 * Created by pr on 01/03/2016.
 */


app.service('translationService', function($resource) {
    this.getTranslation = function($scope, language) {
        var languageFilePath = 'resources/translations/lang_' + language + '.json';
        $resource(languageFilePath).get(function (data) {
            $scope.tr = data;
        });
    };
});