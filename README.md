# School Management System

## Overview
School Management System is a comprehensive web application built with Spring Boot that provides a complete solution for educational institutions to manage their administrative and academic operations. The system facilitates the management of departments, classes, students, teachers, subjects, and grades in a unified platform.

## Features

### Department Management
- Create, view, update, and delete departments
- Assign teachers and classes to departments
- Track departmental performance metrics

### Class Management
- Create, view, update, and delete classes
- Assign students to classes
- Associate classes with departments
- Track class performance metrics

### Student Management
- Create, view, update, and delete student profiles
- Manage student enrollment in classes
- Track student attendance and academic performance
- Maintain student contact information and status

### Teacher Management
- Create, view, update, and delete teacher profiles
- Assign teachers to departments and subjects
- Track teacher workload and performance
- Maintain teacher contact information

### Subject Management
- Create, view, update, and delete subjects
- Define credit values for subjects
- Assign subjects to departments
- Associate teachers with subjects

### Grade Management
- Record and manage student grades for subjects
- Calculate average scores based on attendance, midterm, and final scores
- Generate report cards by academic year
- Track academic performance over time

### Academic Year Management
- Define academic years
- Associate teacher-subject assignments with specific academic years
- Track academic progress by year

## Technology Stack

### Backend
- **Java 17**
- **Spring Boot 3.x** - Core framework
- **Spring Data JPA** - Data access layer
- **Spring Web MVC** - Web layer
- **Spring Validation** - Input validation
- **Lombok** - Reduces boilerplate code

### Database
- **MySQL** (or other supported RDBMS)
- **Hibernate** - ORM framework

### Tools & Development
- **Maven** - Dependency management and build
- **Git** - Version control
- **JUnit & Mockito** - Testing frameworks


        
## API Documentation

### Department APIs
- `GET /departments/` - Get all departments
- `GET /departments/{id}` - Get a specific department
- `POST /departments/` - Create a new department
- `PUT /departments/{id}` - Update a department
- `DELETE /departments/{id}` - Delete a department

### Class APIs
- `GET /classes/` - Get all classes
- `GET /classes/{id}` - Get a specific class
- `POST /classes/` - Create a new class
- `PUT /classes/{id}` - Update a class
- `DELETE /classes/{id}` - Delete a class

### Student APIs
- `GET /students/` - Get all students
- `GET /students/{id}` - Get a specific student
- `POST /students/` - Create a new student
- `PUT /students/{id}` - Update a student
- `DELETE /students/{id}` - Delete a student

### Teacher APIs
- `GET /teachers/` - Get all teachers
- `GET /teachers/{id}` - Get a specific teacher
- `POST /teachers/` - Create a new teacher
- `PUT /teachers/{id}` - Update a teacher
- `DELETE /teachers/{id}` - Delete a teacher

### Subject APIs
- `GET /subjects/` - Get all subjects
- `GET /subjects/{id}` - Get a specific subject
- `POST /subjects/` - Create a new subject
- `PUT /subjects/{id}` - Update a subject
- `DELETE /subjects/{id}` - Delete a subject

### Grade APIs
- `GET /grades/` - Get all grades
- `GET /grades/{id}` - Get a specific grade
- `GET /grades/student/{studentId}` - Get grades for a specific student
- `GET /grades/teacher/{teacherId}` - Get grades assigned by a specific teacher
- `GET /grades/subject/{subjectId}` - Get grades for a specific subject
- `POST /grades/` - Create a new grade
- `PUT /grades/{id}` - Update a grade
- `DELETE /grades/{id}` - Delete a grade

### Teacher-Subject APIs
- `GET /teacher-subjects/` - Get all teacher-subject mappings
- `GET /teacher-subjects/{id}` - Get a specific teacher-subject mapping
- `GET /teacher-subjects/teacher/{teacherId}` - Get subjects taught by a specific teacher
- `POST /teacher-subjects/` - Create a new teacher-subject mapping
- `PUT /teacher-subjects/{id}` - Update a teacher-subject mapping
- `DELETE /teacher-subjects/{id}` - Delete a teacher-subject mapping

## Database Schema

### Department Table
- `id` (PK)
- `department_code`
- `department_name`

### Classes Table
- `id` (PK)
- `class_code`
- `class_name`
- `department_id` (FK to Department)

### Student Table
- `id` (PK)
- `student_code`
- `full_name`
- `gender`
- `birth_date`
- `email`
- `phone`
- `class_id` (FK to Classes)
- `status`

### Teacher Table
- `id` (PK)
- `teacher_code`
- `full_name`
- `gender`
- `birth_date`
- `email`
- `phone`
- `department_id` (FK to Department)

### Subject Table
- `id` (PK)
- `subject_code`
- `subject_name`
- `credits`
- `department_id` (FK to Department)

### Grade Table
- `id` (PK)
- `student_id` (FK to Student)
- `subject_id` (FK to Subject)
- `teacher_id` (FK to Teacher)
- `attendance_score`
- `midterm_score`
- `final_score`
- `average_score`
- `academic_year`

### Teacher-Subject Table
- `id` (PK)
- `teacher_id` (FK to Teacher)
- `subject_id` (FK to Subject)
- `academic_year`

## Setup and Installation

### Prerequisites
- JDK 17 or higher
- Maven 3.6 or higher
- MySQL (or other compatible RDBMS)

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/school-management.git
   cd school-management
   ```

2. **Configure the database**
   
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/school_management
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Build the application**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   
   The application will be available at http://localhost:8080

## Security Considerations

This application implements basic validation for data integrity but does not include authentication and authorization mechanisms out of the box. For production deployment, consider implementing:

- JWT or OAuth2 authentication
- Role-based access control (RBAC)
- HTTPS enforcement
- Input sanitization
- Rate limiting

## Future Enhancements

- User authentication and authorization
- File upload for student and teacher documents
- Email notifications
- Calendar and scheduling system
- Attendance tracking system
- Financial management module
- Mobile application support
- Reporting and analytics dashboard
- Parent portal

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgements

- Spring Boot documentation
- Lombok documentation
- All contributors who have helped shape this project
