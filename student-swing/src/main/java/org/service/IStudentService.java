package org.service;

import org.dto.TableDTO;
import org.entity.StudentRequest;
import org.entity.StudentDO;

public interface IStudentService {
    TableDTO queryAll(StudentRequest request);
    StudentDO queryById(int id);
    boolean add(StudentDO studentDO);
    boolean update(StudentDO studentDO);
    boolean delete(int[] ids);
}
