function Employee(firstName, lastName, id, email, salary, dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.salary = salary;
        this.dept = dept;
}

let employees = [];
employees.push(new Employee("Abhijeeth", "Padarthi", 001, "abhi@gmail.com", 100, "Human Resources"));
employees.push(new Employee("Devnash", "Sharma", 002, "dev@gmail.com", 101, "Human Resources"));
employees.push(new Employee("Akhil", "Chouhan", 003, "akhil@gmail.com", 102, "Information Technology"));

console.log(employees);

Employee.prototype.dets = function() {
    return (this.firstName +  " works in the " + this.dept + " department and earns Rs" + this.salary +"/ s");
}
console.log(employees[0].dets());

employees[1].__proto__.age = 25;
console.log(employees[1].firstName +  " is "+ employees[1].age + " years old");

var myFunc = () => {
    return "hello world";
};

console.log("using call : " + myFunc.call());
var bindedMyFunc = myFunc.bind();
console.log("using bind : " + bindedMyFunc());