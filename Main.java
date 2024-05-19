package yest;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        UniversityManagementSystem ums = new UniversityManagementSystem();
        ums.run();
    }
}

class UniversityManagementSystem {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;
    private Scanner scanner;

    public UniversityManagementSystem() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    public void viewStudentCourseAssignments() {
        System.out.println("\nStudent Course Assignments:");
        for (Student student : students) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student ID: " + student.getId());
            System.out.println("Courses Enrolled:");
            boolean enrolledCoursesExist = false;
            for (Course course : courses) {
                if (course.getEnrolledStudents().contains(student)) {
                    System.out.println("- " + course.getName());
                    enrolledCoursesExist = true;
                }
            }
            if (!enrolledCoursesExist) {
                System.out.println("- No courses enrolled");
            }
            System.out.println("-----------------------");
        }
    }


    public void run() {
        while (true) {
            System.out.println("\nUniversity Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Create Course");
            System.out.println("4. Enroll Student to Course");
            System.out.println("5. Assign Teacher to Course");
            System.out.println("6. Enter Marks");
            System.out.println("7. View Student list and Course they are in");
            System.out.println("8. Exit");
            System.out.print("\nEnter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    createCourse();
                    break;
                case 4:
                    enrollStudentToCourse();
                    break;
                case 5:
                    assignTeacherToCourse();
                    break;
                case 6:
                    // Implement entering marks
                    break;
                case 7:
                	viewStudentCourseAssignments();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student date of birth (YYYY-MM-DD): ");
        String dobString = scanner.nextLine();
        Date dob = parseDate(dobString);
        System.out.print("Enter student roll number: ");
        String rollNo = scanner.nextLine();
        System.out.print("Enter student Aadhar number: ");
        String aadharNo = scanner.nextLine();

        Student student = new Student(name, id, dob, rollNo, aadharNo);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void addTeacher() {
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        System.out.print("Enter teacher ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter teacher designation: ");
        String designation = scanner.nextLine();

        Teacher teacher = new Teacher(name, id, designation);
        teachers.add(teacher);
        System.out.println("Teacher added successfully.");
    }

    public void createCourse() {
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        Course course = new Course(name, courseId);
        courses.add(course);
        System.out.println("Course created successfully.");
    }

    public void enrollStudentToCourse() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            course.enrollStudent(student);
            System.out.println("Student enrolled in course successfully.");
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void assignTeacherToCourse() {
        System.out.print("Enter teacher ID: ");
        String teacherId = scanner.nextLine();
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        Teacher teacher = findTeacherById(teacherId);
        Course course = findCourseById(courseId);

        if (teacher != null && course != null) {
            course.assignTeacher(teacher);
            System.out.println("Teacher assigned to course successfully.");
        } else {
            System.out.println("Teacher or course not found.");
        }
    }

    // Other methods (enterMarks, viewFees, applyForLeave) can be implemented similarly

    // Utility method to find a student by ID
    private Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Utility method to find a teacher by ID
    private Teacher findTeacherById(String id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null;
    }

    // Utility method to find a course by ID
    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    // Utility method to parse date from string
    private Date parseDate(String dateStr) {
        // Implement date parsing logic here
        return null;
    }
}

class Student {
    private String name;
    private String id;
    private Date dob;
    private String rollNo;
    private String aadharNo;

    public Student(String name, String id, Date dob, String rollNo, String aadharNo) {
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.rollNo = rollNo;
        this.aadharNo = aadharNo;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

    
}

class Teacher {
    private String name;
    private String id;
    private String designation;

    public Teacher(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

    // Getters and setters
}

class Course {
    private String name;
    private String courseId;
    private List<Student> enrolledStudents;
    private Teacher teacher;

    public Course(String name, String courseId) {
        this.name = name;
        this.courseId = courseId;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

    
}
