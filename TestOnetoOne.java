package com.onetoone;

import java.util.Date;

import org.hibernate.Session;

import com.util.HibernateUtilConfig;
 

public class TestOnetoOne {
 
    public static void main(String[] args) {
         
    	Session session = HibernateUtilConfig.getSessionFactory().openSession();
         
        // obtains the session
       
        session.beginTransaction();
         
        Author author=new Author("Cameron", "Cameron@gmail.com");
        
        // creates a Book entity
        Book newBook = new Book();
        newBook.setTitle("Hibernate Made Easy");
        newBook.setDescription("Simplified Data Persistence with Hibernate and JPA");
        newBook.setPublishedDate(new Date());
         
        newBook.setAuthor(author);
        session.save(newBook);
         

         
        // gets the book entity back
   Book book = (Book) session.get(Book.class, 1L);
        System.out.println("Book's Title: " + book.getTitle());
        System.out.println("Book's Description: " + book.getDescription());
         
        Author author1 = book.getAuthor();
        System.out.println("Author's Name: " + author1.getName());
        System.out.println("Author's Email: " + author1.getEmail());
         
        session.getTransaction().commit();
        session.close();       
    }
}

