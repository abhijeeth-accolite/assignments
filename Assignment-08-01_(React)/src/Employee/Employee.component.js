import React, { Component } from 'react';

import { AddEmployeeComponent } from './AddEmployee.component';
import { EmployeeListComponent } from './EmployeeList.component';

export class EmployeeComponent extends Component {
  
  state = {
    employees : [],
  }

  constructor(){
    super();
    this.onAddHandler = this.onAddHandler.bind(this);
  }

  onAddHandler = (data) => {  
    let employees = [...this.state.employees];
    employees.push(data);
    this.setState({
      employees: employees
    });    
  }

  render() {
    return(
      <div style={{border:"1px solid black", marginRight:"20%", marginLeft:"20%", padding:"20px"}}>
        <h1>EMPLOYEE COMPONENT</h1>
        <AddEmployeeComponent  onAdd={this.onAddHandler} departments={this.props.departments}/>
        <EmployeeListComponent departments={this.props.departments} employees={this.state.employees}/>
      </div>
    ); 
  }
} 