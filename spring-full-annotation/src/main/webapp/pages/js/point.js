export class Person{
    constructor(name,age){
        this.name = name;
        this.age = age;
    }

    info(){
        return `用户信息：${this.name}---${this.age}`
    }
}

