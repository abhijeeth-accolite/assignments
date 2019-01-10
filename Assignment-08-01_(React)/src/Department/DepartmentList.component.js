import React, { Component } from 'react';

export class DepartmentListComponent extends Component{
    render(){
        return(
            <div>
                <h3>List of Departments : </h3>
                <ul>
                {this.props.departments.map((department, i)=>{
                    return(
                        <li>{department.name}</li>
                    )
                })}
                </ul>
            </div>
        )
    }
}