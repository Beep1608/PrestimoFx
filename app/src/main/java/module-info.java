module responsive {
   requires javafx.controls;
   requires javafx.graphics;
   requires javafx.swing;
   requires java.sql;
  requires   org.hibernate.orm.core;
  requires java.naming;

  requires jakarta.persistence;
  requires jakarta.xml.bind;
  requires jakarta.transaction;


  requires org.jboss.logging;
  requires com.fasterxml.classmate;
  requires net.bytebuddy;

  requires  org.postgresql.jdbc;
  requires transitive jenvy;
  requires atlantafx.base;
  exports org.example;



  opens org.example to jakarta.persistence,  org.hibernate.orm.core;
  opens org.example.pages to jenvy;



}
