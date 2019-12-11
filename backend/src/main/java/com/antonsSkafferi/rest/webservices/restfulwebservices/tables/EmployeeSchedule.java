/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fredriksellgren
 */
@Entity
@Table(name = "employeeschedule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeSchedule implements Serializable {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeescheduleid", updatable = false, nullable = false)
    private int employeescheduleid;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employeeid", insertable = false, updatable = false)
    private Employee employee;
    
    @Column(name = "employeeid", updatable = true, nullable = false)
    private int employeeid;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="workingscheduleid", insertable = false, updatable = false)
    private WorkingSchedule workingschedule;
    
    @Column(name = "workingscheduleid", updatable = true, nullable = false)
    private int workingscheduleid;
    
    public EmployeeSchedule(){}
    
    public EmployeeSchedule(int employeeid, int workingscheduleid){
        this.employeeid = employeeid;
        this.workingscheduleid = workingscheduleid;
    }
    
    /**
     * @return the employeescheduleid
     */
    public int getEmployeescheduleid() {
        return employeescheduleid;
    }

    /**
     * @param employeescheduleid the employeescheduleid to set
     */
    public void setEmployeescheduleid(int employeescheduleid) {
        this.employeescheduleid = employeescheduleid;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the employeeid
     */
    public int getEmployeeid() {
        return this.employeeid;
    }

    /**
     * @param employeeid the employeeid to set
     */
    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * @return the workingschedule
     */
    public WorkingSchedule getWorkingschedule() {
        return workingschedule;
    }

    /**
     * @param workingschedule the workingschedule to set
     */
    public void setWorkingschedule(WorkingSchedule workingschedule) {
        this.workingschedule = workingschedule;
    }

    /**
     * @return the workingscheduleid
     */
    public int getWorkingscheduleid() {
        return workingscheduleid;
    }

    /**
     * @param workingscheduleid the workingscheduleid to set
     */
    public void setWorkingscheduleid(int workingscheduleid) {
        this.workingscheduleid = workingscheduleid;
    }
    
    @Override
    public String toString(){
        return "EmployeeSchedule [employeescheduleid = " + getEmployeescheduleid() + ", employeeid=" + employee + ", workingScheduleid=" + workingschedule + "]";
    }
    
    
}
