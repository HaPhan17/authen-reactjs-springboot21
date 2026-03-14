package vn.haphan.msmultitenanttask.entity;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.UUID;

/**
 * @author : Hà Phan
 * created date : 2/24/2026
 * project-name : ms-learn-spring40
 * package-name : vn.haphan.msmultitenanttask
 **/
//@Entity
//@Table(name = "tasks")
@Data
public class Task {

//    @Id
//    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private String status;
    private String tenantId ;
}
