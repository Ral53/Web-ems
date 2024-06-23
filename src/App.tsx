import './App.css'
import { HeaderComponent } from './components/HeaderComponent'
import { ListEmployeeComponents } from './components/ListEmployeeComponents'
import FooterComponent from "./components/FooterComponent.tsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import EmployeeComponent from './components/EmployeeComponent.tsx';


function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent/>
          <Routes>
            {/*// http://localhost:3000*/}
            <Route path='/' element={<ListEmployeeComponents/>}></Route>
            {/*// http:/localhost:3000/employees*/}
            <Route path='/employees' element={<ListEmployeeComponents/>}></Route>
            {/*// http:/localhost:3000/add-employee*/}
            <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
            {/* // http://localhost:3000/edit-employee/1 */}
            <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>

          </Routes>

        <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App
