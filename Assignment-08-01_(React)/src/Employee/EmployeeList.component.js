import React, { Component } from 'react';

export class EmployeeListComponent extends Component{
    state = {
        selectedDepartment : "all"
    }

    handleOnChange = () => {
        var selectedDepartment = document.getElementById("to_show_dept").value;
        this.setState({
            selectedDepartment : selectedDepartment
        })
    }

    render(){
        return(
            <div>
                <br/>
                <h3 style={{display:"inline"}}>List of Employees:</h3>
                <select id="to_show_dept" onChange={this.handleOnChange}>
                    <option value="all"> - </option>
                    {this.props.departments.map((department, i)=>{
                            return(
                               <option value={department.name}>{department.name}</option> 
                            )
                    })}
                </select>
                <table>
                {this.props.employees.filter((employee)=>{
                    if(this.state.selectedDepartment === 'all') return true;
                    else return employee.department === this.state.selectedDepartment;
                }).map((employee, i)=>{
                    return(
                        <tr>
                            <td>{employee.name}</td>
                            <td>{employee.id}</td>
                            <td>{employee.email}</td>
                            <td>{employee.department}</td>
                        </tr>
                    )
                })
                }
                </table>
            </div>
        )
    }
}