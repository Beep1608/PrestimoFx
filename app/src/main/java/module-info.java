module responsive {
   requires javafx.controls;
   requires javafx.graphics;
   requires javafx.swing;
   requires java.sql;
  requires org.hibernate.orm.core;
  requires jakarta.persistence;
  requires jakarta.validation;
  requires java.naming;


  exports org.example;

  opens org.example to jakarta.persistence,  org.hibernate.orm.core;
}
