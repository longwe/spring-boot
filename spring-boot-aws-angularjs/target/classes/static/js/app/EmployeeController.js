'use strict';

angular.module('crudApp').controller('EmployeeController',
    ['EmployeeService', '$scope',  function( EmployeeService, $scope) {

        var self = this;
        self.employee = {};
        self.employees=[];

        self.submit = submit;
        self.getAllEmployees = getAllEmployees;
        self.createEmployee = createEmployee;
        self.updateEmployee = updateEmployee;
        self.removeEmployee = removeEmployee;
        self.editEmployee = editEmployee;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.employee.id === undefined || self.employee.id === null) {
                console.log('Saving New Employee', self.employee);
                createEmployee(self.employee);
            } else {
            	updateEmployee(self.employee, self.employee.id);
                console.log('Employee updated with id ', self.employee.id);
            }
        }

        function createEmployee(employee) {
            console.log('About to create employee');
            EmployeeService.createEmployee(employee)
                .then(
                    function (response) {
                        console.log('Employee created successfully');
                        self.successMessage = 'Employee created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.employee={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Employee');
                        self.errorMessage = 'Error while creating Employee: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateEmployee(employee, id){
            console.log('About to update employee');
            EmployeeService.updateEmployee(employee, id)
                .then(
                    function (response){
                        console.log('Employee updated successfully');
                        self.successMessage='Employee updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Employee');
                        self.errorMessage='Error while updating Employee '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeEmployee(id){
            console.log('About to remove Employee with id '+id);
            EmployeeService.removeEmployee(id)
                .then(
                    function(){
                        console.log('Employee '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing employee '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllEmployees(){
            return EmployeeService.getAllEmployees();
        }

        function editEmployee(id) {
            self.successMessage='';
            self.errorMessage='';
            EmployeeService.getEmployee(id).then(
                function (employee) {
                    self.employee = employee;
                },
                function (errResponse) {
                    console.error('Error while removing employee ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.employee={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);