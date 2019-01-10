import React, { Component } from 'react';
import { EmployeeComponent } from './Employee/Employee.component';
import { DepartmentComponent } from './Department/Department.component';


export class RootComponent extends Component {
  state = {
    departments : []
  }

  onDeptAddHandler = (data) => {  
    let departments = [...this.state.departments];
    departments.push(data);
    this.setState({
      departments: departments
    });
  }

  render() {
    return(  
      <React.Fragment>
        <EmployeeComponent departments = {this.state.departments}/>
        <DepartmentComponent departments = {this.state.departments} onDeptAddHandler = {this.onDeptAddHandler}/>
      </React.Fragment>
    ); 
  }
} 



