/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

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
    @JoinColumn(name="workingScheduleid", insertable = false, updatable = false)
    private WorkingSchedule workingSchedule;
    
    @Column(name = "workingScheduleid", updatable = true, nullable = false)
    private int workingScheduleid;
    
    
}
