import axios from "axios";

interface Employee {
  firstName: string;
  lastName: string;
  email: string;
}

const REST_API_BASE_URL = "http://localhost:8080/api/employees";

export const listEmployees = () => axios.get(REST_API_BASE_URL);

export const createEmployee = (employee: Employee) => axios.post(REST_API_BASE_URL, employee);

export const getEmployee = (employeeId: string) => axios.get(REST_API_BASE_URL + '/' + employeeId);

export const updateEmployee = (employeeId: string, employee: Employee) => axios.put(REST_API_BASE_URL + '/' + employeeId, employee);

export const deleteEmployee = (employeeId : string) => axios.delete(REST_API_BASE_URL + '/' + employeeId);