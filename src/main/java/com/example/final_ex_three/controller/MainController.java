package com.example.final_ex_three.controller;

import com.example.final_ex_three.model.Book;
import com.example.final_ex_three.model.BorrowCard;
import com.example.final_ex_three.model.Student;
import com.example.final_ex_three.service.book.BookService;
import com.example.final_ex_three.service.book.BookServiceImpl;
import com.example.final_ex_three.service.borrowCard.BorrowCardService;
import com.example.final_ex_three.service.borrowCard.BorrowCardServiceImpl;
import com.example.final_ex_three.service.student.StudentService;
import com.example.final_ex_three.service.student.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "MainController", urlPatterns = "/Library")
public class MainController extends HttpServlet {
    private final BookService bookService = new BookServiceImpl();
    private final StudentService studentService = new StudentServiceImpl();
    private final BorrowCardService borrowCardService = new BorrowCardServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String show = request.getParameter("S");
        if (show == null) {
            show = "bookList";
        }
        switch (show) {
            case "bookList":
                showBookList(request, response);
                break;
            case "borrowCardList":
                showBorrowCardList(request, response);
                break;
            case "borrowBook":
                showBorrowBook(request, response);
                break;
                case "showAddStudent":
                    showAddStudent(request, response);
                break;
            case "returnBook":

                break;
            case "studentList":
                showListStudent(request, response);

                break;
            default:
                showBookList(request, response);
                break;
        }
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showBorrowCardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BorrowCard> borrowCards = borrowCardService.getAllBorrowCards();
        request.setAttribute("borrowCards", borrowCards);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/borrowCard/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showBorrowBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String bookBorrowId = request.getParameter("bookID");
        List<Student> students = studentService.getAllStudents();
        if (bookBorrowId != null) {
            int bookID = Integer.parseInt(bookBorrowId);
            Book book = bookService.getBookById(bookID);
            if (book.getQuantity() > 0) {
                request.setAttribute("book", book);
                request.setAttribute("students", students);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/borrowCard/add.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("message", "Không còn sách để mượn.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/book/list.jsp");
                dispatcher.forward(request, response);
            }
        } else {
//            sử lý nếu bị lỗi ko truyền đc id
            response.sendRedirect("Library?S=bookList");
        }
    }

    private void showBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.getAllBooks();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/book/list.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("A");
        if (action == null) {
            action = "borrow";
        }
        switch (action) {
            case "borrow":
                BorrowBook(request, response);
                break;
            case "addStudent":
                addStudent(request, response);
                break;
            default:
                break;
        }
    }

    private void BorrowBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            int bookID = Integer.parseInt(request.getParameter("bookID"));
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            String borrowDate = request.getParameter("borrowDate");
            String returnDate = request.getParameter("returnDate");

            Book book = bookService.getBookById(bookID);
            Student student = studentService.getStudentById(studentID);

            BorrowCard borrowCard = new BorrowCard();
            borrowCard.setBookID(bookID);
            borrowCard.setStudentID(studentID);
            borrowCard.setBorrowDate(LocalDate.parse(borrowDate));
            borrowCard.setReturnDate(LocalDate.parse(returnDate));
            borrowCardService.addBorrowCard(borrowCard);

            book.setQuantity(book.getQuantity() - 1);
            bookService.updateBook(book);

            response.sendRedirect("Library?S=borrowCardList");

        } catch (NumberFormatException e) {

            request.setAttribute("message", "Dữ liệu không hợp lệ.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/book/list.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String studentName = request.getParameter("studentName");
            String studentClass = request.getParameter("studentClass");

            Student student = new Student();
            student.setStudentName(studentName);
            student.getStudentClass();
            studentService.addStudent(student);
            response.sendRedirect("Library?S=studentList");
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Dữ liệu không h��p lệ.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/student/add.jsp");
            dispatcher.forward(request, response);
        }
    }


}



