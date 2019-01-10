import React, { Component } from 'react';

export class AddEmployeeComponent extends Component{
    state = {
        formEnabled : false
    }

    constructor(){
        super();
        this.openForm = this.openForm.bind(this);
        this.closeForm = this.closeForm.bind(this);

    }

    openForm = () =>{
        this.setState({
            formEnabled: true
        });
    }

    closeForm = () =>{
        this.setState({
            formEnabled: false
        });
    }
    
    add = e => {
        e.preventDefault();
        this.props.onAdd({
            name: document.getElementById("employee_name").value, 
            id: document.getElementById("employee_id").value, 
            email: document.getElementById("employee_email").value,
            department: document.getElementById("employee_department").value
        })
    }

    render(){
        return(
            <React.Fragment>
                <button onClick = {this.openForm}>Open Form</button>
                {this.state.formEnabled &&
                    <form>
                        <input type='text' id='employee_name' placeholder='Employee Name'/><br/>
                        <input type='text' id="employee_id" placeholder="Employee ID"/><br/>
                        <input type='text' id='employee_email' placeholder="Employee email"/><br/>
                        <select id='employee_department'>
                        {this.props.departments.map((department, i)=>{
                            return(<option value={department.name}>{department.name}</option>)
                        })}
                        </select><br/>
                        <button onClick = {this.add}>Add Employee</button>
                        <button onClick = {this.closeForm}>Close</button>
                    </form>
                }
            </React.Fragment>
        )
    }
}