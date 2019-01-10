import React, { Component } from 'react';

import { AddDepartmentComponent } from './AddDepartment.component';
import { DepartmentListComponent } from './DepartmentList.component';

export class DepartmentComponent extends Component {
  render() {
    return(
       <div style={{border:"1px solid black", marginRight:"20%", marginLeft:"20%", padding:"20px"}}>
          <h1>DEPARTMENT COMPONENT</h1>
          <AddDepartmentComponent  onAdd={this.props.onDeptAddHandler} />
          <DepartmentListComponent departments={this.props.departments}/>
        </div>
    ); 
  }
} 