import React, { Component } from 'react';

export class AddDepartmentComponent extends Component{
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
            name: document.getElementById("department_name").value, 
        })
    }

    render(){
        return(
            <div>
                <button onClick = {this.openForm} >Open Form</button>
                {this.state.formEnabled &&
                <form  style={{display:"inline"}}>
                    <input type='text' id='department_name' placeholder='Department Name'/>
                    <button onClick = {this.add}>Add Department</button>
                    <button onClick = {this.closeForm}>Close</button>
                </form>
                }
            </div>
        )
    }
}