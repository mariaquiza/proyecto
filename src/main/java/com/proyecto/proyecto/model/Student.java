package com.proyecto.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private String lastname;
    private boolean attend;

    public Student(){

    }
    public Student(String name, String lastname, boolean attend){
        this.name= name;
        this.lastname= lastname;
        this.attend= attend;
    }

    public String getId(){
        return id;
    }

    /** 
     *  @param id
     */
    public void setId(String id){
    this.id=id;
    }
    
    /** 
     *  @return 
     */
    public String getName(){
        return name;
    }

    /** 
     *  @param name
     */
    public void setName(String name){
        this.name=name;
    }

    /** 
     *  @return 
     */
    public String getLastname(){
        return lastname;
    }

    /** 
     *  @param lastname
     */
    public void setLastname(String lastname){
        this.lastname=lastname;
    }

    /** 
     *  @return 
     */
    public boolean isAttend(){
        return attend;
    }

    /** 
     *  @param attend
     */
    public void setAttend(boolean attend){
        this.attend=attend;
    }

    @Override
    public String toString(){
        return "Student[id=" + id + ", nombre=" + name + ", desc=" + lastname + 
        ", asistio=" + attend + "]";
    }

    
}
