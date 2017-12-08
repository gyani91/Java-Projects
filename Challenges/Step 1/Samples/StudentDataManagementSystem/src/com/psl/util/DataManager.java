package com.psl.util;

import java.util.List;

import com.psl.beans.Student;
import com.psl.exceptions.InsufficientDataException;

public interface DataManager {
  List<Student> populateData(String fileName);
  void sortData(List<Student> studentList);
  void validateData(List<Student> studentList) throws InsufficientDataException;
  
}
