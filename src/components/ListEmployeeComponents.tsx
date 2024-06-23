import React, {useEffect, useState} from 'react';
import {deleteEmployee, listEmployees} from '../services/EmployeeService';
import {useNavigate} from 'react-router-dom';

interface Employee {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
}

export const ListEmployeeComponents: React.FC = () => {
    const [employees, setEmployees] = useState<Employee[]>([]);
    const navigator = useNavigate();

    useEffect(() => {
        getAllEmployees();
    }, []);

    function getAllEmployees() {
        listEmployees()
            .then(response => {
                setEmployees(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    }

    function addNewEmployee() {
        navigator('/add-employee');
    }

    function updateEmployee(id: number) {
        navigator(`/edit-employee/${id}`);
    }

    const handleDelete = (id: number) => {
        if (id) {
            deleteEmployee(id.toString())
                .then(() => {
                    console.log('Employee deleted successfully');
                    // Refresh the employee list after deletion
                    getAllEmployees();
                })
        }
    }

    return (
        <div className='container'>
            <h2>List of Employees</h2>
            <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>
            <table className='table table-striped table-bordered'>
                <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {employees.map((employee) => (
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                        <td>
                            <button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>Update
                            </button>
                            <button type='button' className='btn btn-danger'
                                    onClick={() => handleDelete(employee.id)}
                            style={{marginLeft:'10px'}}>Delete
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};
