# NUIST-Homework-and-Course-Designment-for-JAVA

## Project1 : [Student-Course Management System Demo]

### Features
- save and load a Student-Course 2-dimensional table of scores
- print the table with all average values
- query for any average or summit value of any student/course
- show an sorted ranklist according to any course

### Functions
- avg all: print the whole table with average values
- avg * : query for the average value of any student/course
- max * : query for the maximum value of any student/course
- sort * : show an sorted ranklist according to any course
- exit : exit the system safely

### Design and idea
In this project, I design a class called **data** to save all related information, says, student list, course list, and the their crossing scores. 

Note that all commands but for "avg all" and "exit" requires to search the student/course list for an exact location. So I firstly define locating functions for these two items. In this case, any avg/max operations can be easily solved.

Other operations are ordinary.

### Potential update
- replace current plain find_stu/find_crs algorithm with an AC Automachine, which reduce the Time complexity from n\*m (number of students and courses multiplied with their lengths) to m (the length only).
- replace current bubble sorting to quick sort and achieve a complexity of n\*logn
- calculate the maximum/average value in advance

[Student-Course Management System Demo]:https://github.com/sky66666/Java-Homework-and-Course-Designment/blob/master/Project1.java
