var App = angular.module('LibraryApp', ['vcRecaptcha']);

App.controller('libraryController', function ($scope, $http, $window) {

    $scope.getBooks = function () {
        $http.get("library").success(function (response) {
            $scope.books = response;
        });
    };

    $scope.deleteBook = function (id) {

        var deleteBook = $window.confirm("Are you absolutely sure you want to delete?");
        if (deleteBook) {
            $http.delete("library/deleteBook/" + id).success(function () {
                $window.alert("Book was deleted.");
                $scope.getBooks();
            }).error(function () {
                $window.alert("An error occured. Deleting was failed.");
            });
        }
    };

    $scope.addBook = function (book) {

        if (isAddFormValid(book)) {
            $http.post("library/createBook", book).success(function () {
                $window.alert("Book was created.");
                $scope.getBooks();
                $scope.hideAddModal();
            }).error(function () {
                $window.alert('An error occured. Creation was failed.')
            });
        }
    };

    $scope.editBook = function (book) {

        if (isEditFormValid(book)) {
            $http.put("library/updateBook", book).success(function () {
                $window.alert("Book was edited.");
                $scope.getBooks();
                $scope.hideEditModal();
            }).error(function () {
                $window.alert('An error occured. Edit was failed.')
            });
        }
    };

    $scope.showEditModal = function (book) {
        $scope.book = book;
        $scope.editModal = true;
    };

    $scope.showAddModal = function () {
        $scope.book = null;
        $scope.addModal = true;
    };

    $scope.hideAddModal = function () {
        $scope.addModal = false;
        $scope.book = null;
    };

    $scope.hideEditModal = function () {
        $scope.editModal = false;
        $scope.book = null;
        $scope.getBooks();
    };

    function isAddFormValid(book) {

        var isValid = true;

        if (book == null || book.name == null || book.name === null) {
            $window.alert("Book Name must not be empty.");
            isValid = false;
        }

        if (book == null || book.author == null || book.author === null) {
            $window.alert("Book Author Name must not be empty");
            isValid = false;
        }

        if ($scope.capthcaValid == null || !$scope.capthcaValid) {
            $window.alert("You must validate the capthca");
            isValid = false;
        }

        return isValid;
    }

    function isEditFormValid(book) {

        var isValid = true;

        if (book == null || book.name == null || book.name === null) {
            $window.alert("Book Name must not be empty.");
            isValid = false;
        }

        if (book == null || book.author == null || book.author === null) {
            $window.alert("Book Author Name must not be empty");
            isValid = false;
        }

        return isValid;
    }

    $scope.setResponse = function () {
        $scope.capthcaValid = true;
    };

    $scope.cbExpiration = function () {
        $scope.capthcaValid = false;
    };

    $scope.capthcaValid = false;
    $scope.editMode = false;
    $scope.createMode = false;
    $scope.getBooks();
});