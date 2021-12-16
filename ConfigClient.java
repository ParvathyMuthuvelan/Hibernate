package com.client;

import java.util.List;

import com.dao.StudentDao;
import com.pojo.Student;

public class ConfigClient {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
     /*   Student student = new Student("minu", "sri", "minu@gmail.com");
       studentDao.saveStudent(student);

       student = new Student("sai", "sri", "sai@gmail.com");
       studentDao.saveStudent(student);*/

        List < Student > students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s));
        
        //update
     /*   Student obj=new Student();
        obj.setId(1);
        obj.setFirstName("Sai sri");
        studentDao.update(obj);
        students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s));*/
        //delete
      studentDao.deleteStudent(1);
        students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s));
        
    }
}
